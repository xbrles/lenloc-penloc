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

package es.inteco.xbrl.lenlocpenloc.transform;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import es.inteco.xbrl.lenlocpenloc.errors.exceptions.DocumentNotFoundException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.TransformException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLENLOCException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLValidatorException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XSDValidatorException;
import es.inteco.xbrl.lenlocpenloc.utils.ENLOCUtils;
import es.inteco.xbrl.lenlocpenloc.utils.XbrlApiConfiguration;
import es.inteco.xbrl.lenlocpenloc.validator.ENLOCXBRLValidator;
import es.inteco.xbrl.lenlocpenloc.validator.ValidateResult;
import es.inteco.xbrl.lenlocpenloc.validator.XSDValidator;

/**
 * 
 * 
 * Esta clase implementa un transformador ENLOC. Este transformador cumple con
 * los requerimientos definidos y documentados por el interfaz
 * IENLOCTransformer.
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

public class ENLOCTransformer implements IENLOCTransformer {

	static Logger logger = Logger.getLogger(ENLOCTransformer.class);

	private ArrayList<String> loggerTraceList = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.transform.IENLOCTransformer#getLoggerList()
	 */
	public ArrayList<String> getLoggerTraceList() {
		return loggerTraceList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.transform.IENLOCTransformer#setLoggerList
	 * (java.util.ArrayList)
	 */
	public void setLoggerTraceList(ArrayList<String> loggerList) {
		this.loggerTraceList = loggerList;
	}

	/**
	 * Constructor
	 */
	private ENLOCTransformer() {

	}

	/**
	 * Valida un XSD
	 * 
	 * @param documentPath
	 * @throws XSDValidatorException
	 * @throws DocumentNotFoundException
	 */
	private void validateXSD(String documentPath) throws XSDValidatorException, DocumentNotFoundException {
		ValidateResult validateResult = XSDValidator.createInstance().validate(documentPath);
		if(!validateResult.isValid()) {
			throw new XSDValidatorException(validateResult.getErrors(), new String[] {});
		}
		if(logger.isInfoEnabled()) {
			logger.info("Successfully validated document at " + documentPath);
		}
	}

	/**
	 * Valida un XBRL
	 * 
	 * @param documentPath
	 * @throws DocumentNotFoundException
	 * @throws XBRLValidatorException
	 */
	private void validateXBRL(String documentPath) throws XBRLValidatorException {

		ValidateResult validateResult = ENLOCXBRLValidator.createInstance().validate(documentPath);
		if(!validateResult.isValid()) {
			throw new XBRLValidatorException(validateResult.getErrors(), new String[] {});
		}
		if(logger.isInfoEnabled()) {
			logger.info("Successfully validated document at " + documentPath);
		}
	}

	/**
	 * Valida un documento XBRL
	 * 
	 * @param inputDocument array de bytes que forman el XBRL origen de la
	 *        transformación
	 * @throws XBRLValidatorException
	 */
	public void validateXBRL(byte[] inputDocument) throws XBRLValidatorException {

		ValidateResult validateResult = ENLOCXBRLValidator.createInstance().validate(inputDocument);
		if(!validateResult.isValid()) {
			throw new XBRLValidatorException(validateResult.getErrors(), new String[] {});
		}
		if(logger.isInfoEnabled()) {
			logger.info("Successfully validated document");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.transform.IENLOCTransformer#transformToXbrl
	 * (java.lang.String, java.lang.String)
	 */
	public void transformToXbrl(String inputPath, String outputPath) throws TransformException {
		transformToXbrl(inputPath, outputPath, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.transform.IENLOCTransformer#transformToXbrl
	 * (java.lang .String, java.lang.String, boolean)
	 */
	public void transformToXbrl(String inputPath, String outputPath, boolean validateXbrl) throws TransformException {
		try {
			validateXSD(inputPath);
		} catch(XSDValidatorException e) {
			throw new TransformException(TransformException.errorValidatingXMLInput, new String[] { inputPath }, e);
		} catch(DocumentNotFoundException e) {
			throw new TransformException(TransformException.errorInTransformationToXbrl, new String[] { inputPath }, e
			        .getErrorsHandler());
		}

		if(logger.isInfoEnabled())
			logger.info("Init transformation to XBRL inputPath=" + inputPath + " outputPath=" + outputPath);

		try {
			TransformerToXBRL transformerToXBRL = TransformerToXBRL.createInstance();

			transformerToXBRL.setLoggerTraceList(this.loggerTraceList);

			transformerToXBRL.transform(inputPath, outputPath);

			if(logger.isInfoEnabled())
				logger.info("Finish transformation to XBRL inputPath=" + inputPath + " outputPath=" + outputPath);
		} catch(TransformException e) {
			File f = new File(outputPath);
			if(f.exists()) {
				f.delete();
			}
			throw e;
		}
		if(validateXbrl) {
			try {
				validateXBRL(outputPath);
			} catch(XBRLValidatorException e) {
				throw new TransformException(TransformException.errorValidatingXBRLInstance,
				        new String[] { inputPath }, e);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.transform.IENLOCTransformer#transformToXbrl
	 * (java.lang .String, boolean)
	 */
	public byte[] transformToXbrl(String inputPath, boolean validate) throws TransformException {

		try {
			validateXSD(inputPath);
		} catch(XSDValidatorException e) {
			throw new TransformException(TransformException.errorValidatingXMLInput, new String[] { inputPath }, e);
		} catch(DocumentNotFoundException e) {
			throw new TransformException(TransformException.errorInTransformationToXbrl, new String[] { inputPath }, e
			        .getErrorsHandler());
		}

		if(logger.isInfoEnabled())
			logger.info("Init transformation to XBRL inputPath=" + inputPath);

		TransformerToXBRL transformerToXBRL = TransformerToXBRL.createInstance();

		transformerToXBRL.setLoggerTraceList(this.loggerTraceList);

		byte[] result = transformerToXBRL.transform(inputPath);

		if(logger.isInfoEnabled())
			logger.info("Finish transformation to XBRL inputPath=" + inputPath);

		if(validate) {
			try {
				validateXBRL(result);
			} catch(XBRLValidatorException e) {
				throw new TransformException(TransformException.errorValidatingXBRLInstance,
				        new String[] { inputPath }, e);
			}
		}

		return result;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.transform.IENLOCTransformer#transformToXbrl
	 * (byte[], boolean)
	 */
	public byte[] transformToXbrl(byte[] inputDocument, boolean validateXbrl) throws TransformException {

		byte[] brlResult = null;
		File inputDocumentFile = null;
		String inputPath = null;

		try {
			inputDocumentFile = ENLOCUtils.createTempFile(inputDocument, "transformtoxml", ".xml");

			inputPath = inputDocumentFile.getAbsolutePath();

			try {
				validateXSD(inputPath);
			} catch(XSDValidatorException e) {
				throw new TransformException(TransformException.errorValidatingXMLInput, new String[] { inputPath }, e);
			} catch(DocumentNotFoundException e) {
				throw new TransformException(TransformException.errorInTransformationToXbrl,
				        new String[] { inputPath }, e.getErrorsHandler());
			}

			if(logger.isInfoEnabled())
				logger.info("Init transformation to XBRL inputPath=" + inputPath);

			TransformerToXBRL transformerToXBRL = TransformerToXBRL.createInstance();

			transformerToXBRL.setLoggerTraceList(this.loggerTraceList);

			brlResult = transformerToXBRL.transform(inputPath);

			if(logger.isInfoEnabled())
				logger.info("Finish transformation to XBRL inputPath=" + inputPath);

			if(validateXbrl) {
				try {
					validateXBRL(brlResult);
				} catch(XBRLValidatorException e) {
					throw new TransformException(TransformException.errorValidatingXBRLInstance,
					        new String[] { inputPath }, e);
				}
			}
		} catch(TransformException exp) {
			throw exp;
		} catch(Exception e) {
			throw new TransformException(TransformException.errorInTransformationToXbrl, new String[] { inputPath }, e);
		} finally {
			if((inputDocumentFile != null) && inputDocumentFile.exists()) {
				inputDocumentFile.delete();
			}
		}

		return brlResult;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.transform.IENLOCTransformer#transformToXml
	 * (java.lang .String, java.lang.String, boolean)
	 */
	public void transformToXml(String inputPath, String outputPath, boolean validateXbrl) throws TransformException {
		FileOutputStream fileOutput = null;
		try {
			ByteArrayOutputStream documentByteArray = new ByteArrayOutputStream();
			try {
				ENLOCUtils.saveFileToByteArray(new File(inputPath), documentByteArray);
			} catch(XBRLENLOCException e) {
				throw new TransformException(TransformException.errorInTransformationToXml, new String[] { inputPath },
				        e.getErrorsHandler());
			}
			byte[] result = transformToXml(documentByteArray.toByteArray(), validateXbrl);
			fileOutput = new FileOutputStream(outputPath);
			fileOutput.write(result);
			fileOutput.close();

		} catch(TransformException exp) {
			File f = new File(outputPath);
			if(f.exists()) {
				f.delete();
			}
			throw exp;
		} catch(Exception e) {
			throw new TransformException(TransformException.errorInTransformationToXml, new String[] { inputPath }, e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.transform.IENLOCTransformer#transformToXml
	 * (java.lang .String, boolean)
	 */
	public byte[] transformToXml(String inputPath, boolean validateXbrl) throws TransformException {
		ByteArrayOutputStream documentByteArray = new ByteArrayOutputStream();
		try {
			ENLOCUtils.saveFileToByteArray(new File(inputPath), documentByteArray);
		} catch(XBRLENLOCException e) {
			throw new TransformException(TransformException.errorInTransformationToXml, new String[] { inputPath }, e
			        .getErrorsHandler());
		}
		return transformToXml(documentByteArray.toByteArray(), validateXbrl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.transform.IENLOCTransformer#transformToXml
	 * (byte[], boolean)
	 */
	public byte[] transformToXml(byte[] inputDocument, boolean validateXbrl) throws TransformException {

		byte[] xmlResult = null;
		File inputDocumentFile = null;
		String inputPath = "";
		try {
			if(validateXbrl) {
				try {
					validateXBRL(inputDocument);
				} catch(XBRLValidatorException e) {
					throw new TransformException(TransformException.errorValidatingXBRLInstance,
					        new String[] { inputPath }, e);
				}
			}

			inputDocumentFile = ENLOCUtils.createTempFile(inputDocument, "transformtoxml", ".xbrl");
			ENLOCUtils.normalizeSchema(new ByteArrayInputStream(inputDocument), XbrlApiConfiguration.getInstance()
			        .getTaxonomyRoot(), inputDocumentFile.getAbsolutePath());
			inputPath = inputDocumentFile.getAbsolutePath();

			if(logger.isInfoEnabled())
				logger.info("Init transformation to XML inputPath=" + inputPath);

			TransformerToXML transformerToXML = TransformerToXML.createInstance();

			transformerToXML.setLoggerTraceList(this.loggerTraceList);

			xmlResult = transformerToXML.transform(inputPath);

			if(logger.isInfoEnabled())
				logger.info("Finish transformation to XML inputPath=" + inputPath);

		} catch(TransformException exp) {
			throw exp;
		} catch(XBRLENLOCException e) {
			throw new TransformException(TransformException.errorInTransformationToXml, new String[] { inputPath }, e
			        .getErrorsHandler());
		} finally {
			if((inputDocumentFile != null) && inputDocumentFile.exists()) {
				inputDocumentFile.delete();
			}
		}

		return xmlResult;
	}

	/**
	 * Crea una instancia del transformador ENLOC.
	 * 
	 * @return Nueva instancia del transformador.
	 * 
	 */
	public static IENLOCTransformer createInstance() {
		return new ENLOCTransformer();
	}
}