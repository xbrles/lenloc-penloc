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

package es.inteco.xbrl.lenlocpenloc.errors.out.types;

/**
 * Enumeration ENLOCErrorOutTypeType.
 * 
 * <b>Proyecto</b>: API XBRL-LENLOCPENLOC2010 - Grupo de utilidades y
 * librerías en código abierto para facilitar la integración del formato XBRL en
 * las herramientas software de gestión de terceros aislándose de la complejidad
 * en el procesamiento del modelo de datos de las taxonomías. Ayudando de esta
 * forma a las entidades locales en la labor de realización de informes XBRL y
 * asegurar el éxito en el reporte de presupuestos y liquidación de presupuestos
 * de las entidades locales en formato XBRL
 * 
 * 
 * @version 1.0, 24/06/2009
 * @author difusioncalidad@inteco.es
 * 
 */

@SuppressWarnings ("serial")
public enum ENLOCErrorOutTypeType implements java.io.Serializable {

	// ------------------/
	// - Enum Constants -/
	// ------------------/

	/**
	 * Constant XBREEZE
	 */
	XBREEZE("xbreeze"),
	/**
	 * Constant XERCES
	 */
	XERCES("xerces"),
	/**
	 * Constant XAPINTECO
	 */
	XAPINTECO("xapinteco");

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * Field value.
	 */
	private final java.lang.String value;

	// ----------------/
	// - Constructors -/
	// ----------------/

	private ENLOCErrorOutTypeType(final java.lang.String value) {
		this.value = value;
	}

	// -----------/
	// - Methods -/
	// -----------/

	/**
	 * Method fromValue.
	 * 
	 * @param value
	 * @return the constant for this value
	 */
	public static es.inteco.xbrl.lenlocpenloc.errors.out.types.ENLOCErrorOutTypeType fromValue(
	        final java.lang.String value) {
		for(ENLOCErrorOutTypeType c : ENLOCErrorOutTypeType.values()) {
			if(c.value.equals(value)) {
				return c;
			}
		}
		throw new IllegalArgumentException(value);
	}

	/**
	 * 
	 * 
	 * @param value
	 */
	public void setValue(final java.lang.String value) {
	}

	/**
	 * Method toString.
	 * 
	 * @return the value of this constant
	 */
	public java.lang.String toString() {
		return this.value;
	}

	/**
	 * Method value.
	 * 
	 * @return the value of this constant
	 */
	public java.lang.String value() {
		return this.value;
	}

}