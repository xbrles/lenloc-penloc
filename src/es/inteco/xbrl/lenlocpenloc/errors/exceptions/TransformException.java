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

import es.inteco.xbrl.lenlocpenloc.errors.GenericErrorsHandler;

/**
 * 
 * Clase utilizada para notificar los errores encontrados en el proceso de
 * transformación.
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

public class TransformException extends XBRLENLOCException {

	private static final long serialVersionUID = 1L;

	/**
	 * Error general encontrado en el proceso de transformación de un documento
	 * en formato común (XML) a XBRL.
	 */
	public static final String errorInTransformationToXbrl = "errorInTransformationToXbrl";
	/**
	 * Error general encontrado en el proceso de transformación de un documento
	 * XBRL a XML en formato común.
	 */
	public static final String errorInTransformationToXml = "errorInTransformationToXml";
	/**
	 * Error al validar el fichero de entrada en la transformación de XML a
	 * XBRL.
	 */
	public static final String errorValidatingXMLInput = "errorValidatingXMLInput";
	/**
	 * Error obteniendo un módulo sobre el cual se guardarán los elementos,
	 * durante el proceso de generación a XML.
	 */
	public static final String errorGettingModule = "errorGettingModule";
	/**
	 * No existe domain member para un módulo dado.
	 */
	public static final String notExistDomainMemberForModule = "notExistDomainMemberForModule";
	/**
	 * Indica que viene varias veces el mismo concepto bajo el mismo periodo y
	 * con el mismo valor.
	 */
	public static final String duplicateIemsError = "duplicateIemsError";
	/**
	 * En XBRL-LENLOCPENLOC2010 todos los facts reportados sobre un contexto
	 * XBRL deben pertenecer al mismo módulo, es decir, si un contexto tiene
	 * asociado un fact de patnetA no puede tener otro u otros pertenecientes a
	 * patnetB o cualquier otro módulo diferente a patnetA.
	 */
	public static final String errorItemInBadModule = "errorItemInBadModule";
	/**
	 * No se ha encontrado conceptMap en el mapa.
	 */
	public static final String errorIdNotFoundInMap = "errorIdNotFoundInMap";
	/**
	 * Error al ejecutar la validación de un fichero XBRL desde el módulo de
	 * transformación
	 */
	public static String errorValidatingXBRLInstance = "errorValidatingXBRLInstance";
	/**
	 * Error al crear la instancia de la clase TransformerToXBRL
	 */
	public static String errorCreatingTransformerToXBRL = "errorCreatingTransformerToXBRL";
	/**
	 * Error al crear la instancia de la clase TransformerToXML
	 */
	public static String errorCreatingTransformerToXML = "errorCreatingTransformerToXML";
	/**
	 * Error al serializar la instancia XBRL resultado de la transformación
	 */
	public static String errorSerializingXBRLOutput = "errorSerializingXBRLOutput";

	public static String errorInstanceIsEmpty = "errorInstanceIsEmpty";

	/**
	 * Crea una excepción con un identificador, el cual corresponderá a una de
	 * las constantes definidas.
	 * 
	 * @param message constante correspondiente al mensaje
	 * 
	 * @param cause mensaje de la excepción original
	 * 
	 */
	public TransformException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Crea una excepción con un identificador, el cual corresponderá a una de
	 * las constantes definidas.
	 * 
	 * @param message constante correspondiente al mensaje.
	 * 
	 * @param errorsHandler contiene los errores propagados hasta llegar a esta
	 *        excepción.
	 * 
	 */
	public TransformException(String message, GenericErrorsHandler errorsHandler) {
		super(message, errorsHandler);
	}

	/**
	 * Crea una excepción con un identificador, el cual corresponderá a una de
	 * las constantes definidas, con los parámetros necesarios para completar el
	 * mensaje de error.
	 * 
	 * @param message constante correspondiente al mensaje.
	 * 
	 * @param parameters parámetros para completar el mensaje
	 * 
	 * @param errorsHandler contiene los errores propagados hasta llegar a esta
	 *        excepción.
	 * 
	 */
	public TransformException(String message, String[] parameters, GenericErrorsHandler errorsHandler) {
		super(message, parameters, errorsHandler);
	}

	/**
	 * Crea una excepción con un identificador, el cual corresponderá a una de
	 * las constantes definidas.
	 * 
	 * @param message constante correspondiente al mensaje.
	 * 
	 * @param errorsHandler contiene los errores propagados hasta llegar a esta
	 *        excepción.
	 * 
	 * @param cause mensaje de la excepción original.
	 * 
	 */
	public TransformException(String message, GenericErrorsHandler errorsHandler, Throwable cause) {
		super(message, errorsHandler, cause);
	}

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
	public TransformException(String message, String[] parameters, Throwable cause) {
		super(message, parameters, cause);
	}

	/**
	 * Crea una excepción con un identificador, el cual corresponderá a una de
	 * las constantes definidas, con los parámetros necesarios para completar el
	 * mensaje de error sin indicar la causa del error.
	 * 
	 * @param message constante correspondiente al mensaje
	 * 
	 * @param parameters parámetros para completar el mensaje
	 * 
	 */
	public TransformException(String message, String[] parameters) {
		super(message, parameters);
	}

}