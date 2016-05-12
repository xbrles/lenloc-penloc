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

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;

import es.inteco.xbrl.lenlocpenloc.config.ConfigReport;
import es.inteco.xbrl.lenlocpenloc.config.ConfigurationManager;
import es.inteco.xbrl.lenlocpenloc.errors.ENLOCErrorsHandler;
import es.inteco.xbrl.lenlocpenloc.errors.GenericErrorsHandler;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.ConfigException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.DocumentNotFoundException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLENLOCException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLValidatorException;
import es.inteco.xbrl.lenlocpenloc.utils.ENLOCUtils;

/**
 * 
 * Clase que gestiona la validación de un documento XBRL contra las taxonomías
 * LENLOC y PENLOC e incorpora traduccion a códigos ENLOC.
 * 
 * Esta clase genera un resultado indicando si la validación ha sido correcta,
 * para ello utiliza la clase ValidateResult, en la cual indica si la validación
 * fue bien o no en cuyo caso informa de los errores de validación que se hayan
 * encontrado.
 * 
 * Es una extensión de la clase XBRLValidator, mediante la cual se hace un
 * tratamiento diferente en la devolución de los errores. Dicho tratamiento
 * consiste en añadir información de los códigos ENLOC que han podido ser
 * traducidos, mediante la consulta a los mapas, de los conceptos de la
 * taxonomía que puedan aparecer en los mensajes de error.
 * 
 * El resto del tratamiento de errores es idéntico al realizado en la clase
 * XBRLValidator.
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
public class ENLOCXBRLValidator extends XBRLValidator {

	static Logger logger = Logger.getLogger(ENLOCXBRLValidator.class);

	String reportID = null;

	/* Constructor */
	protected ENLOCXBRLValidator() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate(java.lang
	 * .String)
	 */
	public ValidateResult validate(String documentPath) throws XBRLValidatorException {
		ValidateResult validateResult = null;

		try {
			FileInputStream inputStreamDocument = new FileInputStream(documentPath);

			String schemaRef = ENLOCUtils.getSchemaRef(inputStreamDocument);
			inputStreamDocument.close();

			ConfigReport cr = ConfigurationManager.getInstance().getGlobalReportFromSchemaRef(schemaRef);

			if(cr != null) {
				reportID = cr.getId();
			}

			validateResult = super.validate(documentPath);
		} catch(XBRLValidatorException e) {
			throw e;
		} catch(FileNotFoundException e) {
			logger.error(e.getMessage());
			throw new XBRLValidatorException(DocumentNotFoundException.fileNotFound, new String[] { documentPath }, e);
		} catch(DocumentNotFoundException e) {
			throw new XBRLValidatorException(DocumentNotFoundException.fileNotFound, new String[] { documentPath }, e);
		} catch(IOException e) {
			logger.error(e.getMessage());
			throw new XBRLValidatorException(XBRLValidatorException.errorInValidationXbrlInstance,
			        new String[] { documentPath }, e);
		} catch(ConfigException e) {
			logger.error(e.getMessage());
			throw new XBRLValidatorException(XBRLValidatorException.errorInValidationXbrlInstance,
			        new String[] { documentPath }, e.getErrorsHandler());
		} catch(XBRLENLOCException e) {
			logger.error(e.getMessage());
			throw new XBRLValidatorException(XBRLValidatorException.errorInValidationXbrlInstance,
			        new String[] { documentPath }, e.getErrorsHandler());
		}
		return validateResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate(byte[])
	 */
	public ValidateResult validate(byte[] inputDocument) throws XBRLValidatorException {
		ValidateResult validateResult = null;

		try {
			ByteArrayInputStream inputStreamDocument = new ByteArrayInputStream(inputDocument);

			inputStreamDocument.close();

			String schemaRef = ENLOCUtils.getSchemaRef(inputStreamDocument);

			ConfigReport cr = ConfigurationManager.getInstance().getGlobalReportFromSchemaRef(schemaRef);

			if(cr != null) {
				reportID = cr.getId();
			}

			validateResult = super.validate(inputDocument);

		} catch(XBRLValidatorException e) {
			throw e;
		} catch(DocumentNotFoundException e) {
			throw new XBRLValidatorException(DocumentNotFoundException.fileNotFound, new String[] { "XBRL instance" },
			        e);
		} catch(IOException e) {
			logger.error(e.getMessage());
			throw new XBRLValidatorException(XBRLValidatorException.errorInValidationXbrlInstance,
			        new String[] { "XBRL instance" }, e);
		} catch(ConfigException e) {
			logger.error(e.getMessage());
			throw new XBRLValidatorException(XBRLValidatorException.errorInValidationXbrlInstance,
			        new String[] { "XBRL instance" }, e.getErrorsHandler());
		} catch(XBRLENLOCException e) {
			logger.error(e.getMessage());
			throw new XBRLValidatorException(XBRLValidatorException.errorInValidationXbrlInstance,
			        new String[] { "XBRL instance" }, e.getErrorsHandler());
		}
		return validateResult;
	}

	/**
	 * Devuelve una instancia de la propia clase.
	 * 
	 * @return Objeto del tipo IXBRLValidator
	 */
	public static IXBRLValidator createInstance() {
		return new ENLOCXBRLValidator();
	}

	
	protected GenericErrorsHandler getErrorsHandler() {
		return new ENLOCErrorsHandler(reportID);
	}

}