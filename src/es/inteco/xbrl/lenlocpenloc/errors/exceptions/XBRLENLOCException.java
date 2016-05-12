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

package es.inteco.xbrl.lenlocpenloc.errors.exceptions;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;

import es.inteco.xbrl.lenlocpenloc.errors.ErrorMessages;
import es.inteco.xbrl.lenlocpenloc.errors.GenericErrorsHandler;
import es.inteco.xbrl.lenlocpenloc.utils.ENLOCUtils;

/**
 * 
 * 
 * Clase base de errores, es la clase principal para la notificaci�n de errores
 * encontrados en los servicios de XBRL-LENLOCPENLOC2010.
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

public class XBRLENLOCException extends Exception {

	private static final Logger logger = Logger.getLogger(XBRLENLOCException.class);

	protected transient String[] parameters = null;
	protected String message = "";
	protected String codeError = null;
	protected GenericErrorsHandler errorsHandler = null;

	private static final long serialVersionUID = 1L;

	/**
	 * No ha sido creado, o no hay permisos de acceso al directorio temporal
	 * definido en la configuraci�n del sistema, es decir en el par�metro
	 * "tempDirectory" del fichero de propiedades enloc.properties, que se
	 * encuentra en el directorio config del sistema.
	 */
	public static final String notExistTempDirectory = "notExistTempDirectory";// "Not exist temp directory {0}"
	/**
	 * Error en la inicializaci�n del procesador de XBRL est�ndard.
	 */
	public static final String errorInicializingProcessor = "errorInicializingProcessor";// "Error initializing processor"

	/**
	 * Error obteniendo el schemaRef de una instancia
	 */
	public static final String errorGettingSchema = "errorGettingSchema";

	/**
	 * Error obteniendo la ruta completa de un fichero.
	 */
	public static String errorGettingFile = "errorGettingFile";

	/**
	 * Error al normalizar la referencia al esquema dentro de la instancia.
	 */
	public static String errorNormalizeSchema = "errorNormalizeSchema";

	/**
	 * Error al transformar el fichero en array de bytes
	 */
	public static String errorSavingFileToByteArray = "errorSavingFileToByteArray";

	/**
	 * Error resolviendo las rutas de configuraci�n del proyecto.
	 */
	public static String errorResolvingConfigPaths = "errorResolvingConfigPaths";

	/**
	 * Error obteniendo el reportID de un fichero de formato com�n dado
	 */
	public static String errorGettingReportID = "errorGettingReportID";

	/**
	 * Error al crear un fichero temporal.
	 */
	public static String errorCreatingTempFile = "errorCreatingTempFile";

	public static String errorGettingNS = "errorGettingNS";

	/**
	 * Error inexperado en la transformacion xslt debido a par�metros
	 * incorrectos
	 */
	public static String errorParamsTransformation = "errorParamsTransformation";
	/**
	 * Error durante la transformacion XSLT.
	 */
	public static String errorInXSLTTransformation = "errorInXSLTTransformation";

	/**
	 * Error gen�rico ocurrido durante el proceso de validaci�n de una instancia
	 * XBRL.
	 */
	public static final String genericErrorValidatingInstance = "genericErrorValidatingInstance";
	/**
	 * Error intentando visualizar una instancia XBRL.
	 */
	public static final String errorTryingViewInstance = "errorTryingViewInstance";
	public static final String errorTryingViewInstanceExternal = "errorTryingViewInstanceExternal";
	public static final String errorTryingViewInstanceResultFile = "errorTryingViewInstanceResultFile";
	/**
	 * Error debido a que existe un contexto sin escenario, probablemente porque
	 * se haya especificado la dimensi�n como un segmento en lugar de escenario
	 * que es lo correcto.
	 */
	public static final String errorContextWithoutScenario = "errorContextWithoutScenario";

	/**
	 * Error debido a que existe un contexto sin escenario ni segment, debiendo
	 * ser este contexto dimensional.
	 */
	public static final String errorContextWithoutDimensionContainer = "errorContextWithoutDimensionContainer";

	/**
	 * Se produce cuando el schemaRef en la instancia de entrada no es correcto
	 * y no puede ser resuelto.
	 */
	public static final String canNotResolveSchemaRef = "canNotResolveSchemaRef";

	/**
	 * Crea una excepci�n con un identificador, el cual corresponder� a una de
	 * las constantes definidas.
	 * 
	 * @param codeError constante correspondiente al c�digo del mensaje
	 * 
	 * @param cause mensaje de la excepci�n original
	 * 
	 */
	public XBRLENLOCException(String codeError, Throwable cause) {
		this.codeError = codeError;
		setMessage(codeError, cause);
	}

	/**
	 * Crea una excepci�n con un identificador, el cual corresponder� a una de
	 * las constantes definidas.
	 * 
	 * @param codeError constante correspondiente al c�digo del mensaje
	 * 
	 * @param errorsHandler contiene los errores propagados hasta llegar a esta
	 *        excepci�n.
	 * 
	 */
	public XBRLENLOCException(String codeError, GenericErrorsHandler errorsHandler) {
		this.codeError = codeError;
		this.setErrorsHandler(errorsHandler);
		setMessage(codeError, null);
	}

	/**
	 * Crea una excepci�n con un identificador, el cual corresponder� a una de
	 * las constantes definidas, con los par�metros necesarios para completar el
	 * mensaje de error.
	 * 
	 * @param codeError constante correspondiente al c�digo del mensaje
	 * 
	 * @param parameters par�metros para completar el mensaje
	 * 
	 * @param errorsHandler contiene los errores propagados hasta llegar a esta
	 *        excepci�n.
	 * 
	 */
	public XBRLENLOCException(String codeError, String[] parameters, GenericErrorsHandler errorsHandler) {
		this.codeError = codeError;
		this.parameters = parameters;
		this.setErrorsHandler(errorsHandler);
		setMessage(codeError, null);
	}

	/**
	 * Crea una excepci�n con un identificador, el cual corresponder� a una de
	 * las constantes definidas.
	 * 
	 * @param codeError constante correspondiente al c�digo del mensaje
	 * 
	 * @param errorsHandler contiene los errores propagados hasta llegar a esta
	 *        excepci�n.
	 * 
	 * @param cause mensaje de la excepci�n original.
	 * 
	 */
	public XBRLENLOCException(String codeError, GenericErrorsHandler errorsHandler, Throwable cause) {
		this.codeError = codeError;
		this.setErrorsHandler(errorsHandler);
		setMessage(codeError, cause);
	}

	/**
	 * Crea una excepci�n con un identificador, el cual corresponder� a una de
	 * las constantes definidas, con los par�metros necesarios para completar el
	 * mensaje de error.
	 * 
	 * @param codeError constante correspondiente al c�digo del mensaje
	 * 
	 * @param parameters par�metros para completar el mensaje
	 * 
	 * @param cause mensaje de la excepci�n original
	 * 
	 */
	public XBRLENLOCException(String codeError, String[] parameters, Throwable cause) {
		this.codeError = codeError;
		this.parameters = parameters;
		setMessage(codeError, cause);
	}

	/**
	 * Crea una excepci�n con un identificador, el cual corresponder� a una de
	 * las constantes definidas, con los par�metros necesarios para completar el
	 * mensaje de error sin indicar la causa del error.
	 * 
	 * @param codeError constante correspondiente al c�digo del mensaje
	 * 
	 * @param parameters par�metros para completar el mensaje
	 * 
	 */
	public XBRLENLOCException(String codeError, String[] parameters) {
		this.codeError = codeError;
		this.parameters = parameters;
		setMessage(codeError, null);

	}

	protected void setMessage(String codeError, Throwable cause) {

		String messageFormat = ErrorMessages.getInstance().getMessage(codeError);
		if((messageFormat != null) && (parameters != null)) {
			message = ENLOCUtils.format(messageFormat, parameters);
		} else {
			message = codeError;
		}

		try {
			// GenericErrorsHandler errorsHandler = new GenericErrorsHandler();
			GenericErrorsHandler errorsHandler = this.getErrorsHandler();
			ArrayList<String> errorParameterList = null;
			try {
				errorParameterList = new ArrayList<String>(Arrays.asList(parameters));
			} catch(Exception e) {
			}

			if(cause != null && !(cause instanceof XBRLENLOCException)) {
				message = message + " original cause: " + cause.toString();
			}

			errorsHandler.addErrorBefore(codeError, message, errorParameterList);
			message = errorsHandler.toString();

			if(cause != null && cause instanceof XBRLENLOCException) {
				message = message + " original cause: " + cause.toString();
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public String getMessage() {

		return message;
	}

	/**
	 * Devuelve el c�digo de error
	 * 
	 * @return c�digo de error
	 */	
	public final String getCodeError() {
		return codeError;
	}

	
	/**
	 * Establece un nuevo c�digo de error
	 * 
	 * @param codeError c�digo de error
	 */	
	public final void setCodeError(String codeError) {
		this.codeError = codeError;
	}

	/**
	 * Devuelve el manejador de errores gen�rico
	 * 
	 * @return manejador de errores gen�rico
	 */	
	public final GenericErrorsHandler getErrorsHandler() {
		if(errorsHandler == null) {
			errorsHandler = new GenericErrorsHandler();
		}
		return errorsHandler;
	}

	/**
	 * Establece el manejador de errores
	 * 
	 * @param errorsHandler manejador de errores
	 */
	public final void setErrorsHandler(GenericErrorsHandler errorsHandler) {
		this.errorsHandler = errorsHandler;
	}
}