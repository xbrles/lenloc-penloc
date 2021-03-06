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

import es.inteco.xbrl.lenlocpenloc.errors.GenericErrorsHandler;

/**
 * 
 * 
 * Clase utilizada para notificar los errores encontrado durante el proceso de
 * visualizaci�n.
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

public class ViewerException extends XBRLENLOCException {

	/* Error inicializando el viewer */
	public static String errorCreatingViewer = "errorCreatingViewer";
	/* El m�dulo solicitado no tiene una configuraci�n asociada */
	public static String errorModuleNotExist = "errorModuleNotExist";
	/* El fichero de entrada no tiene datos */
	public static String fileIsEmpty = "fileIsEmpty";
	/* El fichero de entrada no tiene datos para el m�dulo seleccionado */
	public static String errorNoDataInModule = "errorNoDataInModule";
	/* Error al cargar el fichero de entrada */
	public static String errorLoadingInputFile = "errorLoadingInputFile";

	/**
	 * Crea una excepci�n con un identificador, el cual corresponder� a una de
	 * las constantes definidas.
	 * 
	 * @param message constante correspondiente al c�digo del mensaje
	 * @param cause mensaje de la excepci�n original
	 * 
	 */
	public ViewerException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Crea una excepci�n con un identificador, el cual corresponder� a una de
	 * las constantes definidas, con los par�metros necesarios para completar el
	 * mensaje de error.
	 * 
	 * @param message constante correspondiente al c�digo del mensaje
	 * 
	 * @param parameters par�metros para completar el mensaje
	 * 
	 * @param cause mensaje de la excepci�n original
	 * 
	 */
	public ViewerException(String message, String[] parameters, Throwable cause) {
		super(message, parameters, cause);
	}

	/**
	 * Crea una excepci�n con un identificador, el cual corresponder� a una de
	 * las constantes definidas, con los par�metros necesarios para completar el
	 * mensaje de error sin indicar la causa del error.
	 * 
	 * @param message constante correspondiente al c�digo del mensaje
	 * 
	 * @param parameters par�metros para completar el mensaje
	 * 
	 */
	public ViewerException(String message, String[] parameters) {
		super(message, parameters);

	}

	/**
	 * Crea una excepci�n con un identificador, el cual corresponder� a una de
	 * las constantes definidas.
	 * 
	 * @param message constante correspondiente al c�digo del mensaje
	 * @param errorsHandler contiene los errores propagados hasta llegar a esta
	 *        excepci�n.
	 * 
	 */
	public ViewerException(String message, GenericErrorsHandler errorsHandler) {
		super(message, errorsHandler);
	}

	/**
	 * Crea una excepci�n con un identificador, el cual corresponder� a una de
	 * las constantes definidas, con los par�metros necesarios para completar el
	 * mensaje de error.
	 * 
	 * @param message constante correspondiente al c�digo del mensaje
	 * 
	 * @param parameters par�metros para completar el mensaje
	 * 
	 * @param errorsHandler contiene los errores propagados hasta llegar a esta
	 *        excepci�n.
	 * 
	 */
	public ViewerException(String message, String[] parameters, GenericErrorsHandler errorsHandler) {
		super(message, parameters, errorsHandler);
	}

	private static final long serialVersionUID = 1L;

}