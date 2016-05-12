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

package es.inteco.xbrl.lenlocpenloc.errors.exceptions;

/**
 * 
 * Clase utilizada para notificar errores producidos cuando no se encuentra el
 * documento o directoiro solicitado.
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

public class DocumentNotFoundException extends XBRLENLOCException {

	/**
	 * No se ha podido encontrar el directorio ENLOCMaps, en el cual se
	 * encuentran los mapas utilizados por los servicios de transformación.
	 */
	public static final String notExistDirectoryMap = "notExistDirectoryMap";
	/**
	 * No se ha encontrado el archivo de configuración Global.xml.
	 */
	public static final String notExistGlobalFile = "notExistGlobalFile";
	/**
	 * No se encuentra el documento para el mapa usado en el servicio de
	 * transformación.
	 */
	public static final String notExistMapFile = "notExistMapFile";
	/**
	 * No se encuentra el documento report indicado.
	 */
	public static final String notExistReportFile = "notExistReportFile";
	/**
	 * No se encuentra el documento a validar.
	 */
	public static final String notFoundInputDocumentToValidate = "notFoundInputDocumentToValidate";
	/**
	 * Fichero no encontrado.
	 */
	public static final String fileNotFound = "fileNotFound";// "File {0} not found {1}"

	/**
	 * Crea una excepción con un identificador, el cual corresponderá a una de
	 * las constantes definidas, con los parámetros necesarios para completar el
	 * mensaje de error.
	 * 
	 * @param message constante correspondiente al mensaje
	 * 
	 * @param parameters parámetros para completar el mensaje
	 * 
	 * @param cause mensaje de la excepción original
	 * 
	 */
	public DocumentNotFoundException(String message, String[] parameters, Throwable cause) {
		super(message, parameters, cause);

	}

	/**
	 * Crea una excepción sin indicar la causa de la excepción.
	 * 
	 * @param message constante correspondiente al mensaje de error
	 * 
	 * @param parameters parámetros para completar el mensaje de error
	 * 
	 */
	public DocumentNotFoundException(String message, String[] parameters) {
		super(message, parameters);

	}

	/**
	 * Crea una excepción con un identificador, el cual corresponderá a una de
	 * las constantes definidas.
	 * 
	 * @param message constante correspondiente al mensaje
	 * 
	 * @param cause mensaje de la excepción original
	 * 
	 */
	public DocumentNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	private static final long serialVersionUID = 1L;

}