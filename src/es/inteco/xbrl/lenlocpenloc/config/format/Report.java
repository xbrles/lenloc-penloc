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

package es.inteco.xbrl.lenlocpenloc.config.format;

/**
 * 
 * This class was automatically generated with <a
 * href="http://www.castor.org">Castor 1.3rc1</a>, using an XML Schema. $Id:
 * Report.java,v 1.4 2009/01/19 14:06:34 a130499 Exp $
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
public class Report implements java.io.Serializable {

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * Field _id.
	 */
	private java.lang.String _id;

	/**
	 * Field _date.
	 */
	private java.util.Date _date;

	/**
	 * Field _entity.
	 */
	private es.inteco.xbrl.lenlocpenloc.config.format.Entity _entity;

	/**
	 * Field _moduleList.
	 */
	private java.util.Vector<es.inteco.xbrl.lenlocpenloc.config.format.Module> _moduleList;

	// ----------------/
	// - Constructors -/
	// ----------------/

	public Report() {
		super();
		this._moduleList = new java.util.Vector<es.inteco.xbrl.lenlocpenloc.config.format.Module>();
	}

	// -----------/
	// - Methods -/
	// -----------/

	/**
	 * 
	 * 
	 * @param vModule
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addModule(final es.inteco.xbrl.lenlocpenloc.config.format.Module vModule)
	        throws java.lang.IndexOutOfBoundsException {
		this._moduleList.addElement(vModule);
	}

	/**
	 * 
	 * 
	 * @param index
	 * @param vModule
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addModule(final int index, final es.inteco.xbrl.lenlocpenloc.config.format.Module vModule)
	        throws java.lang.IndexOutOfBoundsException {
		this._moduleList.add(index, vModule);
	}

	/**
	 * Method enumerateModule.
	 * 
	 * @return an Enumeration over all
	 *         es.inteco.xbrl.lenlocpenloc.config.format.Module elements
	 */
	public java.util.Enumeration<? extends es.inteco.xbrl.lenlocpenloc.config.format.Module> enumerateModule() {
		return this._moduleList.elements();
	}

	/**
	 * Returns the value of field 'date'.
	 * 
	 * @return the value of field 'Date'.
	 */
	public java.util.Date getDate() {
		return this._date;
	}

	/**
	 * Returns the value of field 'entity'.
	 * 
	 * @return the value of field 'Entity'.
	 */
	public es.inteco.xbrl.lenlocpenloc.config.format.Entity getEntity() {
		return this._entity;
	}

	/**
	 * Returns the value of field 'id'.
	 * 
	 * @return the value of field 'Id'.
	 */
	public java.lang.String getId() {
		return this._id;
	}

	/**
	 * Method getModule.
	 * 
	 * @param index
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 * @return the value of the es.inteco.xbrl.lenlocpenloc.config.format.Module
	 *         at the given index
	 */
	public es.inteco.xbrl.lenlocpenloc.config.format.Module getModule(final int index)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._moduleList.size()) {
			throw new IndexOutOfBoundsException("getModule: Index value '" + index + "' not in range [0.."
			        + (this._moduleList.size() - 1) + "]");
		}

		return (es.inteco.xbrl.lenlocpenloc.config.format.Module) _moduleList.get(index);
	}

	/**
	 * Method getModule.Returns the contents of the collection in an Array.
	 * <p>
	 * Note: Just in case the collection contents are changing in another
	 * thread, we pass a 0-length Array of the correct type into the API call.
	 * This way we <i>know</i> that the Array returned is of exactly the correct
	 * length.
	 * 
	 * @return this collection as an Array
	 */
	public es.inteco.xbrl.lenlocpenloc.config.format.Module[] getModule() {
		es.inteco.xbrl.lenlocpenloc.config.format.Module[] array = new es.inteco.xbrl.lenlocpenloc.config.format.Module[0];
		return (es.inteco.xbrl.lenlocpenloc.config.format.Module[]) this._moduleList.toArray(array);
	}

	/**
	 * Method getModuleCount.
	 * 
	 * @return the size of this collection
	 */
	public int getModuleCount() {
		return this._moduleList.size();
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
	public void removeAllModule() {
		this._moduleList.clear();
	}

	/**
	 * Method removeModule.
	 * 
	 * @param vModule
	 * @return true if the object was removed from the collection.
	 */
	public boolean removeModule(final es.inteco.xbrl.lenlocpenloc.config.format.Module vModule) {
		boolean removed = _moduleList.remove(vModule);
		return removed;
	}

	/**
	 * Method removeModuleAt.
	 * 
	 * @param index
	 * @return the element removed from the collection
	 */
	public es.inteco.xbrl.lenlocpenloc.config.format.Module removeModuleAt(final int index) {
		java.lang.Object obj = this._moduleList.remove(index);
		return (es.inteco.xbrl.lenlocpenloc.config.format.Module) obj;
	}

	/**
	 * Sets the value of field 'date'.
	 * 
	 * @param date the value of field 'date'.
	 */
	public void setDate(final java.util.Date date) {
		this._date = date;
	}

	/**
	 * Sets the value of field 'entity'.
	 * 
	 * @param entity the value of field 'entity'.
	 */
	public void setEntity(final es.inteco.xbrl.lenlocpenloc.config.format.Entity entity) {
		this._entity = entity;
	}

	/**
	 * Sets the value of field 'id'.
	 * 
	 * @param id the value of field 'id'.
	 */
	public void setId(final java.lang.String id) {
		this._id = id;
	}

	/**
	 * 
	 * 
	 * @param index
	 * @param vModule
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void setModule(final int index, final es.inteco.xbrl.lenlocpenloc.config.format.Module vModule)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._moduleList.size()) {
			throw new IndexOutOfBoundsException("setModule: Index value '" + index + "' not in range [0.."
			        + (this._moduleList.size() - 1) + "]");
		}

		this._moduleList.set(index, vModule);
	}

	/**
	 * 
	 * 
	 * @param vModuleArray
	 */
	public void setModule(final es.inteco.xbrl.lenlocpenloc.config.format.Module[] vModuleArray) {
		// -- copy array
		_moduleList.clear();

		for(int i = 0; i < vModuleArray.length; i++) {
			this._moduleList.add(vModuleArray[i]);
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
	 * @return the unmarshaled es.inteco.xbrl.lenlocpenloc.config.format.Report
	 */
	public static es.inteco.xbrl.lenlocpenloc.config.format.Report unmarshal(final java.io.Reader reader)
	        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
		return (es.inteco.xbrl.lenlocpenloc.config.format.Report) org.exolab.castor.xml.Unmarshaller.unmarshal(
		        es.inteco.xbrl.lenlocpenloc.config.format.Report.class, reader);
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