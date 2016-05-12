/**
 * 
 * API XBRL-LENLOCPENLOC2010 is a set of packages for the processing of
 * instances XBRL (eXtensible Business Reporting Language) corresponding to the
 * taxonomies LENLOC2010 and PENLOC2010. The Ministerial Order EHA/3565/2008 is
 * the legal text that regulates the budget structure of local entities in
 * Spain. Processing of budget outturn will be according to the LENLOC2010
 * taxonomy. Processing of general budget will be according to the PENLOC2010
 * taxonomy. This program is part of the API XBRL-LENLOCPENLOC2010.
 * 
 * Copyright (C) 2009 INTECO (Instituto Nacional de Tecnologías de la
 * Comunicación, S.A.)
 * 
 * Authors: Members of Software Quality Department inside INTECO
 * 
 * E-mail: difusioncalidad@inteco.es
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your opinion)
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see http://www.gnu.org/licenses/
 */

package es.inteco.xbrl.lenlocpenloc.validator;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLENLOCException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XSDValidatorException;
import es.inteco.xbrl.lenlocpenloc.utils.ENLOCUtils;
import es.inteco.xbrl.lenlocpenloc.utils.XbrlApiConfiguration;

/**
 * 
 * 
 * Clase que gestiona la validación XSD de documentos XML.
 * 
 * 
 *<br>
 * <br>
 * <b>Proyecto</b>: API XBRL-LENLOCPENLOC2010 - Grupo de utilidades y librerías
 * en código abierto para facilitar la integración del formato XBRL en las
 * herramientas software de gestión de terceros aislándose de la complejidad en
 * el procesamiento del modelo de datos de las taxonomías. Ayudando de esta
 * forma a las entidades locales en la labor de realización de informes XBRL y
 * asegurar el éxito en el reporte de presupuestos y liquidación de presupuestos
 * de las entidades locales en formato XBRL
 * 
 * 
 * @version 1.0, 24/06/2009
 * @author difusioncalidad@inteco.es
 * 
 */

public class XSDValidator implements IXSDValidator {

	private static final String cParserXerces = "org.apache.xerces.parsers.SAXParser";
	private static final String cNamespaces = "http://xml.org/sax/features/namespaces";
	private static final String cNamespacePrefix = "http://xml.org/sax/features/namespace-prefixes";
	private static final String cValidation = "http://xml.org/sax/features/validation";
	private static final String cValidationSchema = "http://apache.org/xml/features/validation/schema";
	private static final String cFullCheckSchema = "http://apache.org/xml/features/validation/schema-full-checking";
	private static final String cDinamicValidation = "http://apache.org/xml/features/validation/dynamic";
	private static final String cContinuaFaltalError = "http://apache.org/xml/features/continue-after-fatal-error";
	private static final String cSchemaLenguage = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	private static final String W3C_XML_SCHEMA_NS_URI = "http://www.w3.org/2001/XMLSchema";

	static Logger logger = Logger.getLogger(XBRLValidator.class);

	/**
	 * Constructor por defecto.
	 */
	private XSDValidator() {
	}

	/**
	 * Valida el documento XML.
	 * 
	 * @param documentFile Documento XML que se quiere validar
	 * @param eh ErrorHandler. Manejador de errores
	 * @param ch ContentHandler. Manejador de contenido
	 * 
	 * @throws Exception si se produce un error durante la validación.
	 */
	private void validate(File documentFile, ErrorHandler eh, ContentHandler ch) throws Exception {

		XMLReader xreader = XMLReaderFactory.createXMLReader(cParserXerces);

		xreader.setFeature(cValidation, true);
		xreader.setFeature(cValidationSchema, true);
		xreader.setFeature(cNamespaces, true);
		xreader.setFeature(cNamespacePrefix, true);
		xreader.setFeature(cFullCheckSchema, true);
		xreader.setFeature(cContinuaFaltalError, true);
		xreader.setFeature(cDinamicValidation, false);
		xreader.setProperty(cSchemaLenguage, W3C_XML_SCHEMA_NS_URI);

		xreader.setEntityResolver(XbrlApiConfiguration.getInstance().getResolver());

		if(ch != null)
			xreader.setContentHandler(ch);

		if(eh != null)
			xreader.setErrorHandler(eh);

		xreader.parse(new InputSource(new java.io.InputStreamReader(new FileInputStream(documentFile), "UTF-8")));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.validator.IXSDValidator#validate(java.lang
	 * .String)
	 */
	public ValidateResult validate(String documentPath) throws XSDValidatorException {

		ErrorHandler errorHandler = new ErrorHandler();
		File documentFile = new File(documentPath);

		if(!documentFile.exists()) {
			throw new XSDValidatorException(XSDValidatorException.notFoundInputDocumentToValidate,
			        new String[] { documentPath });
		}

		try {
			validate(documentFile, errorHandler, errorHandler);
		} catch(Exception e) {
			throw new XSDValidatorException(e.getMessage(), e);
		}

		return new ValidateResult(errorHandler.getErrors(), errorHandler.isValid());
	}

	/**
	 * Crea una instancia de la propia clase.
	 * 
	 * @return Instancia de la propia clase XSDValidator
	 */
	public static IXSDValidator createInstance() {

		return new XSDValidator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.validator.IXSDValidator#validate(byte[])
	 */
	
	public ValidateResult validate(byte[] inputDocument) throws XSDValidatorException {
		File inputDocumentFile = null;
		String inputPath = null;
		ValidateResult validateResult = null;

		try {
			inputDocumentFile = ENLOCUtils.createTempFile(inputDocument, "transformtoxml", ".xml");
		} catch(XBRLENLOCException e) {
			throw new XSDValidatorException(XBRLENLOCException.errorCreatingTempFile, e.getErrorsHandler());
		}

		inputPath = inputDocumentFile.getAbsolutePath();

		validateResult = validate(inputPath);

		return validateResult;
	}
}