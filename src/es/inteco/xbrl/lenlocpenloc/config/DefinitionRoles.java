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
 * DefinitionRoles.java,v 1.5 2009/01/19 14:12:30 a130499 Exp $
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
public class DefinitionRoles implements java.io.Serializable {

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * Field _roleList.
	 */
	private java.util.Vector<es.inteco.xbrl.lenlocpenloc.config.Role> _roleList;

	// ----------------/
	// - Constructors -/
	// ----------------/

	public DefinitionRoles() {
		super();
		this._roleList = new java.util.Vector<es.inteco.xbrl.lenlocpenloc.config.Role>();
	}

	// -----------/
	// - Methods -/
	// -----------/

	/**
	 * 
	 * 
	 * @param vRole
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addRole(final es.inteco.xbrl.lenlocpenloc.config.Role vRole) throws java.lang.IndexOutOfBoundsException {
		this._roleList.addElement(vRole);
	}

	/**
	 * 
	 * 
	 * @param index
	 * @param vRole
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addRole(final int index, final es.inteco.xbrl.lenlocpenloc.config.Role vRole)
	        throws java.lang.IndexOutOfBoundsException {
		this._roleList.add(index, vRole);
	}

	/**
	 * Method enumerateRole.
	 * 
	 * @return an Enumeration over all es.inteco.xbrl.lenlocpenloc.config.Role
	 *         elements
	 */
	public java.util.Enumeration<? extends es.inteco.xbrl.lenlocpenloc.config.Role> enumerateRole() {
		return this._roleList.elements();
	}

	/**
	 * Method getRole.
	 * 
	 * @param index
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 * @return the value of the es.inteco.xbrl.lenlocpenloc.config.Role at the
	 *         given index
	 */
	public es.inteco.xbrl.lenlocpenloc.config.Role getRole(final int index) throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._roleList.size()) {
			throw new IndexOutOfBoundsException("getRole: Index value '" + index + "' not in range [0.."
			        + (this._roleList.size() - 1) + "]");
		}

		return (es.inteco.xbrl.lenlocpenloc.config.Role) _roleList.get(index);
	}

	/**
	 * Method getRole.Returns the contents of the collection in an Array.
	 * <p>
	 * Note: Just in case the collection contents are changing in another
	 * thread, we pass a 0-length Array of the correct type into the API call.
	 * This way we <i>know</i> that the Array returned is of exactly the correct
	 * length.
	 * 
	 * @return this collection as an Array
	 */
	public es.inteco.xbrl.lenlocpenloc.config.Role[] getRole() {
		es.inteco.xbrl.lenlocpenloc.config.Role[] array = new es.inteco.xbrl.lenlocpenloc.config.Role[0];
		return (es.inteco.xbrl.lenlocpenloc.config.Role[]) this._roleList.toArray(array);
	}

	/**
	 * Method getRoleCount.
	 * 
	 * @return the size of this collection
	 */
	public int getRoleCount() {
		return this._roleList.size();
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
     */
	public void removeAllRole() {
		this._roleList.clear();
	}

	/**
	 * Method removeRole.
	 * 
	 * @param vRole
	 * @return true if the object was removed from the collection.
	 */
	public boolean removeRole(final es.inteco.xbrl.lenlocpenloc.config.Role vRole) {
		boolean removed = _roleList.remove(vRole);
		return removed;
	}

	/**
	 * Method removeRoleAt.
	 * 
	 * @param index
	 * @return the element removed from the collection
	 */
	public es.inteco.xbrl.lenlocpenloc.config.Role removeRoleAt(final int index) {
		java.lang.Object obj = this._roleList.remove(index);
		return (es.inteco.xbrl.lenlocpenloc.config.Role) obj;
	}

	/**
	 * 
	 * 
	 * @param index
	 * @param vRole
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void setRole(final int index, final es.inteco.xbrl.lenlocpenloc.config.Role vRole)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._roleList.size()) {
			throw new IndexOutOfBoundsException("setRole: Index value '" + index + "' not in range [0.."
			        + (this._roleList.size() - 1) + "]");
		}

		this._roleList.set(index, vRole);
	}

	/**
	 * 
	 * 
	 * @param vRoleArray
	 */
	public void setRole(final es.inteco.xbrl.lenlocpenloc.config.Role[] vRoleArray) {
		// -- copy array
		_roleList.clear();

		for(int i = 0; i < vRoleArray.length; i++) {
			this._roleList.add(vRoleArray[i]);
		}
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
	 *         es.inteco.xbrl.lenlocpenloc.config.DefinitionRoles
	 */
	public static es.inteco.xbrl.lenlocpenloc.config.DefinitionRoles unmarshal(final java.io.Reader reader)
	        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
		return (es.inteco.xbrl.lenlocpenloc.config.DefinitionRoles) org.exolab.castor.xml.Unmarshaller.unmarshal(
		        es.inteco.xbrl.lenlocpenloc.config.DefinitionRoles.class, reader);
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