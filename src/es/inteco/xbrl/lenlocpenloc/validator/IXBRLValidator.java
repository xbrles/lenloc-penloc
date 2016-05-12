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

import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLValidatorException;

/**
 * 
 * 
 * Interfaz de la clase XBRLValidator. Define los métodos de validación de
 * documentos XBRL contra la taxonomía.
 * 
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
 * @see es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator XBRLValidator,
 *      es.inteco.xbrl.lenlocpenloc.validator.ENLOCXBRLValidator
 *      ENLOCXBRLValidator
 * 
 */

public interface IXBRLValidator {

	/**
	 * Valida el documento XBRL contra la taxonomía recibiendo la ruta donde se
	 * encuentra la instancia XBRL.
	 * 
	 * @param documentPath ruta del documento XBRL que se quiere validar
	 * 
	 * @return Objeto de tipo ValidateResult. Recoge los mensajes de validación
	 *         (si existen) y un indicador de si el documento XBRL se considera
	 *         válido
	 * 
	 * @throws XBRLValidatorException si se produce un error durante el proceso
	 *         de validación.
	 */
	public abstract ValidateResult validate(String documentPath) throws XBRLValidatorException;

	/**
	 * Valida el documento XBRL contra la taxonomía recibiendo la instancia XBRL
	 * como array de bytes.
	 * 
	 * @param inputDocument Array de bytes con el documento XBRL que se quiere
	 *        validar
	 * 
	 * @param postProcessResult Indicador de si se procesará el validate result
	 *        original de xbreeze para facilitar su posterior interpretacion
	 * 
	 * @return Objeto de tipo ValidateResult. Recoge los mensajes de validación
	 *         (si existen) y un indicador de si el documento XBRL se considera
	 *         válido
	 * 
	 * @throws XBRLValidatorException si se produce un error durante el proceso
	 *         de validación.
	 */
	public abstract ValidateResult validate(byte[] inputDocument, boolean postProcessResult)
	        throws XBRLValidatorException;

	/**
	 * Valida el documento XBRL contra la taxonomía sin procesar el resultado.
	 * 
	 * @param inputDocument Array de bytes con el documento XBRL que se quiere
	 *        validar
	 * 
	 * @return Objeto de tipo ValidateResult. Recoge los mensajes de validación
	 *         (si existen) y un indicador de si el documento XBRL se considera
	 *         válido
	 * 
	 * @throws XBRLValidatorException si se produce un error durante el proceso
	 *         de validación.
	 */
	public abstract ValidateResult validate(byte[] inputDocument) throws XBRLValidatorException;

}