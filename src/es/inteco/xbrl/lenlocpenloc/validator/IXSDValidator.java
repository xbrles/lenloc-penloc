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

import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XSDValidatorException;

/**
 * 
 * 
 * Interfaz de la clase XSDValidator. Define los métodos de validación de
 * documentos XML de formato comun contra el XSD
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
 * @see es.inteco.xbrl.lenlocpenloc.validator.XSDValidator XSDValidator
 * 
 */

public interface IXSDValidator {

	/**
	 * Valida un documento XML de formato comun contra el XSD
	 * 
	 * @param documentPath ruta del documento XML de formato comun que se quiere
	 *        validar
	 * 
	 * @return Objeto de tipo ValidateResult. Recoge los mensajes de validación
	 *         (si existen) y un indicador de si el documento XML se considera
	 *         válido
	 * 
	 * @throws XSDValidatorException si se produce un error durante la
	 *         validación.
	 */
	public abstract ValidateResult validate(String documentPath) throws XSDValidatorException;

	/**
	 * Valida un documento XML de formato comun contra el XSD
	 * 
	 * @param inputDocument array de bytes que contiene un documento XML de
	 *        formato comun que se quiere validar
	 * 
	 * @return Objeto de tipo ValidateResult. Recoge los mensajes de validación
	 *         (si existen) y un indicador de si el documento XML se considera
	 *         válido
	 * 
	 * @throws XSDValidatorException si se produce un error durante la
	 *         validación.
	 */
	public abstract ValidateResult validate(byte[] inputDocument) throws XSDValidatorException;
}