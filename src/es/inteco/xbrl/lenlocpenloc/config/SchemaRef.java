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

package es.inteco.xbrl.lenlocpenloc.config;

/**
 * 
 * This class was automatically generated with <a
 * href="http://www.castor.org">Castor 1.3rc1</a>, using an XML Schema. $Id:
 * SchemaRef.java,v 1.5 2009/01/19 14:12:30 a130499 Exp $
 * 
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

@SuppressWarnings ("serial")
public class SchemaRef implements java.io.Serializable {

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * Field _uri.
	 */
	private java.lang.String _uri;

	/**
	 * Field _baseUrl.
	 */
	private java.lang.String _baseUrl;

	/**
	 * Field _main.
	 */
	private boolean _main;

	/**
	 * keeps track of state for field: _main
	 */
	private boolean _has_main;

	/**
	 * Field _type.
	 */
	private java.lang.String _type;

	/**
	 * Field _targetNamespace.
	 */
	private java.lang.String _targetNamespace;

	// ----------------/
	// - Constructors -/
	// ----------------/

	public SchemaRef() {
		super();
	}

	// -----------/
	// - Methods -/
	// -----------/

	/**
     */
	public void deleteMain() {
		this._has_main = false;
	}

	/**
	 * Returns the value of field 'baseUrl'.
	 * 
	 * @return the value of field 'BaseUrl'.
	 */
	public java.lang.String getBaseUrl() {
		return this._baseUrl;
	}

	/**
	 * Returns the value of field 'main'.
	 * 
	 * @return the value of field 'Main'.
	 */
	public boolean getMain() {
		return this._main;
	}

	/**
	 * Returns the value of field 'targetNamespace'.
	 * 
	 * @return the value of field 'TargetNamespace'.
	 */
	public java.lang.String getTargetNamespace() {
		return this._targetNamespace;
	}

	/**
	 * Returns the value of field 'type'.
	 * 
	 * @return the value of field 'Type'.
	 */
	public java.lang.String getType() {
		return this._type;
	}

	/**
	 * Returns the value of field 'uri'.
	 * 
	 * @return the value of field 'Uri'.
	 */
	public java.lang.String getUri() {
		return this._uri;
	}

	/**
	 * Method hasMain.
	 * 
	 * @return true if at least one Main has been added
	 */
	public boolean hasMain() {
		return this._has_main;
	}

	/**
	 * Returns the value of field 'main'.
	 * 
	 * @return the value of field 'Main'.
	 */
	public boolean isMain() {
		return this._main;
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
	 * Sets the value of field 'baseUrl'.
	 * 
	 * @param baseUrl the value of field 'baseUrl'.
	 */
	public void setBaseUrl(final java.lang.String baseUrl) {
		this._baseUrl = baseUrl;
	}

	/**
	 * Sets the value of field 'main'.
	 * 
	 * @param main the value of field 'main'.
	 */
	public void setMain(final boolean main) {
		this._main = main;
		this._has_main = true;
	}

	/**
	 * Sets the value of field 'targetNamespace'.
	 * 
	 * @param targetNamespace the value of field 'targetNamespace'.
	 */
	public void setTargetNamespace(final java.lang.String targetNamespace) {
		this._targetNamespace = targetNamespace;
	}

	/**
	 * Sets the value of field 'type'.
	 * 
	 * @param type the value of field 'type'.
	 */
	public void setType(final java.lang.String type) {
		this._type = type;
	}

	/**
	 * Sets the value of field 'uri'.
	 * 
	 * @param uri the value of field 'uri'.
	 */
	public void setUri(final java.lang.String uri) {
		this._uri = uri;
	}

	/**
	 * Method unmarshal.
	 * 
	 * @param reader
	 * @throws org.exolab.castor.xml.MarshalException if object is null or if
	 *         any SAXException is thrown during marshaling
	 * @throws org.exolab.castor.xml.ValidationException if this object is an
	 *         invalid instance according to the schema
	 * @return the unmarshaled es.inteco.xbrl.lenlocpenloc.config.SchemaRef
	 */
	public static es.inteco.xbrl.lenlocpenloc.config.SchemaRef unmarshal(final java.io.Reader reader)
	        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
		return (es.inteco.xbrl.lenlocpenloc.config.SchemaRef) org.exolab.castor.xml.Unmarshaller.unmarshal(
		        es.inteco.xbrl.lenlocpenloc.config.SchemaRef.class, reader);
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