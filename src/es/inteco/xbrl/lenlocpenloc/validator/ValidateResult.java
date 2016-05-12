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

/**
 * 
 * 
 * Clase que encapsula el resultado de la validación. Es usada para devolver la
 * respuesta del servicio de validación.
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

public class ValidateResult {

	private String _Errors = null;
	private String generalError = null;
	private boolean valid = true;

	/**
	 * Constructor por defecto.
	 */
	public ValidateResult() {
		super();
	}

	/**
	 * Constructor con parámetros.
	 * 
	 * @param errors Lista de errores que presenta el documento.
	 * @param isValid Indicador de si el documento es válido.
	 */
	public ValidateResult(String errors, boolean isValid) {
		_Errors = errors;
		valid = isValid;
	}

	/**
	 * Devuelve la lista de errores de validación.
	 * 
	 * @return string con la lista de errores encontrados durante el proceso de
	 *         validación.
	 */
	public String getErrors() {
		return _Errors;
	}

	/**
	 * 
	 * Devuelve un indicador de si el documento es válido.
	 * 
	 * @return boolean con el indicador de si el documento enviado a validar es
	 *         válido.
	 */
	public boolean isValid() {

		return valid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return _Errors;
	}

	/**
	 * 
	 * Devuelve la lista de errores producidos durante el proceso de validación.
	 * 
	 * @return Cadena de errores, en caso de que los hubiera, producidos en el
	 *         proceso de validación.
	 */
	public final String getGeneralError() {
		return generalError;
	}

	/**
	 * 
	 * Agrega la lista de errores producidos durante el proceso de validación.
	 * 
	 * @param generalError Cadena de errores, en caso de que los hubiera,
	 *        producidos en el proceso de validación.
	 */
	public final void setGeneralError(String generalError) {
		this.generalError = generalError;
	}

}