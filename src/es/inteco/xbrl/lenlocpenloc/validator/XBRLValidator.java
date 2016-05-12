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
 * Copyright (C) 2009 INTECO (Instituto Nacional de Tecnolog�as de la
 * Comunicaci�n, S.A.)
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
import java.io.ByteArrayOutputStream;
import java.io.File;

import org.apache.log4j.Logger;

import es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlApiFacade;
import es.inteco.xbrl.lenlocpenloc.apifacade.impl.XbrlApiFactory;
import es.inteco.xbrl.lenlocpenloc.errors.GenericErrorsHandler;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.DocumentNotFoundException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLApiException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLENLOCException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLValidatorException;
import es.inteco.xbrl.lenlocpenloc.utils.ENLOCUtils;
import es.inteco.xbrl.lenlocpenloc.utils.XbrlApiConfiguration;

/**
 * 
 * 
 * Clase que gestiona la validaci�n de un documento XBRL contra una taxonom�a.
 * 
 * Esta clase se compone de dos m�todos p�blicos mediante los cuales es posible
 * invocar la funcionalidad de validaci�n XBRL, devolviendo en ambos casos un
 * objeto que encapsula el resultado de la validaci�n, as� como un informe de
 * errores de validaci�n que hayan podido encontrarse.
 * 
 * La validaci�n XBRL est� basada en la API de XBreeze, a la cual se accede a
 * trav�s de la funcionalidad que publica la facade implementada para dicha API.
 * 
 * El resultado de la validaci�n consiste en indicar si la instancia es
 * correcta, para ello se utilizar� un m�todo booleano que as� lo indica.
 * 
 * Si durante la validaci�n se detectaron errores, dichos errores ser�n
 * informados seg�n el formato definido para ello mediante el esquema de errores
 * config/schemas/lenlocpenloc2010-errors-output.xsd.
 * 
 * En dichos errores se informa del c�digo, la descripci�n por defecto y los
 * par�metros en caso de que los hubiera.
 * 
 * Los errores que se pueden devolver est�n clasificados en tres tipos, de
 * validaci�n de esquema, validaci�n Xbreeze (XBRL) o errores de la propia API
 * (error de sistema gen�rico).
 * 
 * Todos los errores quedan catalogados en el fichero
 * lenlocpenloc2010-errors.xml.
 * 
 * 
 *<br>
 * <br>
 * <b>Proyecto</b>: API XBRL-LENLOCPENLOC2010 - Grupo de utilidades y librer�as
 * en c�digo abierto para facilitar la integraci�n del formato XBRL en las
 * herramientas software de gesti�n de terceros aisl�ndose de la complejidad en
 * el procesamiento del modelo de datos de las taxonom�as. Ayudando de esta
 * forma a las entidades locales en la labor de realizaci�n de informes XBRL y
 * asegurar el �xito en el reporte de presupuestos y liquidaci�n de presupuestos
 * de las entidades locales en formato XBRL
 * 
 * 
 * @version 1.0, 24/06/2009
 * @author difusioncalidad@inteco.es
 * 
 */

public class XBRLValidator implements IXBRLValidator {

	private static final Logger logger = Logger.getLogger(XBRLValidator.class);

	/**
	 * Constructor por defecto.
	 */
	protected XBRLValidator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.validator.IXBRLValidator#validate(java.lang
	 * .String)
	 */
	public ValidateResult validate(String documentPath) throws XBRLValidatorException {
		ValidateResult validateResult = null;

		try {

			logger.info("Processing the request XBRL validation of " + documentPath);

			File documentFile = new File(documentPath);
			if(!documentFile.exists()) {
				throw new DocumentNotFoundException(DocumentNotFoundException.notFoundInputDocumentToValidate,
				        new String[] { documentPath });
			}

			ByteArrayOutputStream documentByteArray = new ByteArrayOutputStream();
			ENLOCUtils.saveFileToByteArray(documentFile, documentByteArray);

			validateResult = validate(documentByteArray.toByteArray());

		} catch(XBRLValidatorException ex) {
			throw ex;
		} catch(XBRLENLOCException e) {
			logger.error(e.getMessage());
			throw new XBRLValidatorException(XBRLValidatorException.errorInValidationXbrlInstance,
			        new String[] { documentPath }, e.getErrorsHandler());
		}

		return validateResult;
	}

	/* Devuelve un manejador de errores */
	protected GenericErrorsHandler getErrorsHandler() {
		return new GenericErrorsHandler();

	}

	public ValidateResult validate(byte[] inputDocument) throws XBRLValidatorException {
		return validate(inputDocument, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.validator.IXBRLValidator#validate(byte[])
	 */
	public ValidateResult validate(byte[] inputDocument, boolean postProcessResult) throws XBRLValidatorException {

		ValidateResult validateResult = new ValidateResult();
		File inputDocumentFile = null;
		String documentPath = null;
		try {

			inputDocumentFile = ENLOCUtils.createTempFile(inputDocument, "xbrlvalidator", ".xbrl");

			ENLOCUtils.normalizeSchema(new ByteArrayInputStream(inputDocument), XbrlApiConfiguration.getInstance()
			        .getTaxonomyRoot(), inputDocumentFile.getAbsolutePath());

			documentPath = inputDocumentFile.getAbsolutePath();

			logger.info("XBRL Validation of " + documentPath + " started");

			IXbrlApiFacade apiFacade;
			apiFacade = XbrlApiFactory.get_instance();

			GenericErrorsHandler errorsHandler = getErrorsHandler();

			boolean valid = apiFacade.validate(documentPath, errorsHandler);

			if(postProcessResult) {
				validateResult = new ValidateResult(errorsHandler.toStringPostProcess(), valid);
			} else {
				validateResult = new ValidateResult(errorsHandler.toString(), valid);
			}

			logger.info("XBRL Validation of " + documentPath + " ended successfully");

		} catch(XBRLApiException e) {
			logger.error("XBRL Validation of " + inputDocumentFile.getAbsolutePath() + " was not completed");
			throw new XBRLValidatorException(XBRLValidatorException.errorInValidationXbrlInstance,
			        new String[] { inputDocumentFile.getAbsolutePath() }, e.getErrorsHandler());
		} catch(XBRLENLOCException e) {
			logger.error("XBRL Validation of " + inputDocumentFile.getAbsolutePath() + " was not completed");
			throw new XBRLValidatorException(XBRLValidatorException.errorInValidationXbrlInstance,
			        new String[] { inputDocumentFile.getAbsolutePath() }, e.getErrorsHandler());
		} finally {
			if((inputDocumentFile != null) && inputDocumentFile.exists()) {
				inputDocumentFile.delete();
			}
		}

		logger.info("XBRL Validation of " + documentPath + " finished");

		return validateResult;
	}

	/**
	 * Crea una instancia de la propia clase.
	 * 
	 * @return Objeto del tipo IXBRLValidator
	 */
	public static IXBRLValidator createInstance() {
		return new XBRLValidator();
	}
}