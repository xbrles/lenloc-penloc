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

package es.inteco.xbrl.lenlocpenloc.errors.out;

/**
 * Class ENLOCErrorParameter.
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
public class ENLOCErrorParameter implements java.io.Serializable {

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * Field _id.
	 */
	private long _id;

	/**
	 * keeps track of state for field: _id
	 */
	private boolean _has_id;

	/**
	 * Field _ENLOCCode.
	 */
	private java.lang.String _ENLOCCode;

	/**
	 * internal content storage
	 */
	private java.lang.String _content = "";

	// ----------------/
	// - Constructors -/
	// ----------------/

	public ENLOCErrorParameter() {
		super();
		setContent("");
	}

	// -----------/
	// - Methods -/
	// -----------/

	/**
     */
	public void deleteId() {
		this._has_id = false;
	}

	/**
	 * Returns the value of field 'content'. The field 'content' has the
	 * following description: internal content storage
	 * 
	 * @return the value of field 'Content'.
	 */
	public java.lang.String getContent() {
		return this._content;
	}

	/**
	 * Returns the value of field 'id'.
	 * 
	 * @return the value of field 'Id'.
	 */
	public long getId() {
		return this._id;
	}

	/**
	 * Returns the value of field 'ENLOCCode'.
	 * 
	 * @return the value of field 'ENLOCCode'.
	 */
	public java.lang.String getENLOCCode() {
		return this._ENLOCCode;
	}

	/**
	 * Method hasId.
	 * 
	 * @return true if at least one Id has been added
	 */
	public boolean hasId() {
		return this._has_id;
	}

	/**
	 * Method isValid.
	 * 
	 * @return true if this object is valid according to the schema
	 */
	public boolean isValid() {
		try {
			validate();
		} catch(org.exolab.castor.xml.ValidationException vex) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * 
	 * @param out
	 * @throws org.exolab.castor.xml.MarshalException if object is null or if
	 *         any SAXException is thrown during marshaling
	 * @throws org.exolab.castor.xml.ValidationException if this object is an
	 *         invalid instance according to the schema
	 */
	public void marshal(final java.io.Writer out) throws org.exolab.castor.xml.MarshalException,
	        org.exolab.castor.xml.ValidationException {
		org.exolab.castor.xml.Marshaller.marshal(this, out);
	}

	/**
	 * 
	 * 
	 * @param handler
	 * @throws java.io.IOException if an IOException occurs during marshaling
	 * @throws org.exolab.castor.xml.ValidationException if this object is an
	 *         invalid instance according to the schema
	 * @throws org.exolab.castor.xml.MarshalException if object is null or if
	 *         any SAXException is thrown during marshaling
	 */
	public void marshal(final org.xml.sax.ContentHandler handler) throws java.io.IOException,
	        org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
		org.exolab.castor.xml.Marshaller.marshal(this, handler);
	}

	/**
	 * Sets the value of field 'content'. The field 'content' has the following
	 * description: internal content storage
	 * 
	 * @param content the value of field 'content'.
	 */
	public void setContent(final java.lang.String content) {
		this._content = content;
	}

	/**
	 * Sets the value of field 'id'.
	 * 
	 * @param id the value of field 'id'.
	 */
	public void setId(final long id) {
		this._id = id;
		this._has_id = true;
	}

	/**
	 * Sets the value of field 'ENLOCCode'.
	 * 
	 * @param ENLOCCode the value of field 'ENLOCCode'.
	 */
	public void setENLOCCode(final java.lang.String ENLOCCode) {
		this._ENLOCCode = ENLOCCode;
	}

	/**
	 * Method unmarshal.
	 * 
	 * @param reader
	 * @throws org.exolab.castor.xml.MarshalException if object is null or if
	 *         any SAXException is thrown during marshaling
	 * @throws org.exolab.castor.xml.ValidationException if this object is an
	 *         invalid instance according to the schema
	 * @return the unmarshaled
	 *         es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter
	 */
	public static es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter unmarshal(final java.io.Reader reader)
	        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
		return (es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter) org.exolab.castor.xml.Unmarshaller
		        .unmarshal(es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter.class, reader);
	}

	/**
	 * 
	 * 
	 * @throws org.exolab.castor.xml.ValidationException if this object is an
	 *         invalid instance according to the schema
	 */
	public void validate() throws org.exolab.castor.xml.ValidationException {
		org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
		validator.validate(this);
	}

}