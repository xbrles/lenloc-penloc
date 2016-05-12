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
 * ConfigReport.java,v 1.5 2009/01/19 14:12:31 a130499 Exp $
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
public class ConfigReport implements java.io.Serializable {

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * Field _id.
	 */
	private java.lang.String _id;

	/**
	 * Field _nsItemList.
	 */
	private java.util.Vector<es.inteco.xbrl.lenlocpenloc.config.NsItem> _nsItemList;

	/**
	 * Field _unitList.
	 */
	private java.util.Vector<es.inteco.xbrl.lenlocpenloc.config.Unit> _unitList;

	/**
	 * Field _schemaRef.
	 */
	private es.inteco.xbrl.lenlocpenloc.config.SchemaRef _schemaRef;

	/**
	 * Field _configModuleList.
	 */
	private java.util.Vector<es.inteco.xbrl.lenlocpenloc.config.ConfigModule> _configModuleList;

	// ----------------/
	// - Constructors -/
	// ----------------/

	public ConfigReport() {
		super();
		this._nsItemList = new java.util.Vector<es.inteco.xbrl.lenlocpenloc.config.NsItem>();
		this._unitList = new java.util.Vector<es.inteco.xbrl.lenlocpenloc.config.Unit>();
		this._configModuleList = new java.util.Vector<es.inteco.xbrl.lenlocpenloc.config.ConfigModule>();
	}

	// -----------/
	// - Methods -/
	// -----------/

	/**
	 * 
	 * 
	 * @param vConfigModule
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addConfigModule(final es.inteco.xbrl.lenlocpenloc.config.ConfigModule vConfigModule)
	        throws java.lang.IndexOutOfBoundsException {
		this._configModuleList.addElement(vConfigModule);
	}

	/**
	 * 
	 * 
	 * @param index
	 * @param vConfigModule
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addConfigModule(final int index, final es.inteco.xbrl.lenlocpenloc.config.ConfigModule vConfigModule)
	        throws java.lang.IndexOutOfBoundsException {
		this._configModuleList.add(index, vConfigModule);
	}

	/**
	 * 
	 * 
	 * @param vNsItem
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addNsItem(final es.inteco.xbrl.lenlocpenloc.config.NsItem vNsItem)
	        throws java.lang.IndexOutOfBoundsException {
		this._nsItemList.addElement(vNsItem);
	}

	/**
	 * 
	 * 
	 * @param index
	 * @param vNsItem
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addNsItem(final int index, final es.inteco.xbrl.lenlocpenloc.config.NsItem vNsItem)
	        throws java.lang.IndexOutOfBoundsException {
		this._nsItemList.add(index, vNsItem);
	}

	/**
	 * 
	 * 
	 * @param vUnit
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addUnit(final es.inteco.xbrl.lenlocpenloc.config.Unit vUnit) throws java.lang.IndexOutOfBoundsException {
		this._unitList.addElement(vUnit);
	}

	/**
	 * 
	 * 
	 * @param index
	 * @param vUnit
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addUnit(final int index, final es.inteco.xbrl.lenlocpenloc.config.Unit vUnit)
	        throws java.lang.IndexOutOfBoundsException {
		this._unitList.add(index, vUnit);
	}

	/**
	 * Method enumerateConfigModule.
	 * 
	 * @return an Enumeration over all
	 *         es.inteco.xbrl.lenlocpenloc.config.ConfigModule elements
	 */
	public java.util.Enumeration<? extends es.inteco.xbrl.lenlocpenloc.config.ConfigModule> enumerateConfigModule() {
		return this._configModuleList.elements();
	}

	/**
	 * Method enumerateNsItem.
	 * 
	 * @return an Enumeration over all es.inteco.xbrl.lenlocpenloc.config.NsItem
	 *         elements
	 */
	public java.util.Enumeration<? extends es.inteco.xbrl.lenlocpenloc.config.NsItem> enumerateNsItem() {
		return this._nsItemList.elements();
	}

	/**
	 * Method enumerateUnit.
	 * 
	 * @return an Enumeration over all es.inteco.xbrl.lenlocpenloc.config.Unit
	 *         elements
	 */
	public java.util.Enumeration<? extends es.inteco.xbrl.lenlocpenloc.config.Unit> enumerateUnit() {
		return this._unitList.elements();
	}

	/**
	 * Method getConfigModule.
	 * 
	 * @param index
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 * @return the value of the es.inteco.xbrl.lenlocpenloc.config.ConfigModule
	 *         at the given index
	 */
	public es.inteco.xbrl.lenlocpenloc.config.ConfigModule getConfigModule(final int index)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._configModuleList.size()) {
			throw new IndexOutOfBoundsException("getConfigModule: Index value '" + index + "' not in range [0.."
			        + (this._configModuleList.size() - 1) + "]");
		}

		return (es.inteco.xbrl.lenlocpenloc.config.ConfigModule) _configModuleList.get(index);
	}

	/**
	 * Method getConfigModule.Returns the contents of the collection in an
	 * Array.
	 * <p>
	 * Note: Just in case the collection contents are changing in another
	 * thread, we pass a 0-length Array of the correct type into the API call.
	 * This way we <i>know</i> that the Array returned is of exactly the correct
	 * length.
	 * 
	 * @return this collection as an Array
	 */
	public es.inteco.xbrl.lenlocpenloc.config.ConfigModule[] getConfigModule() {
		es.inteco.xbrl.lenlocpenloc.config.ConfigModule[] array = new es.inteco.xbrl.lenlocpenloc.config.ConfigModule[0];
		return (es.inteco.xbrl.lenlocpenloc.config.ConfigModule[]) this._configModuleList.toArray(array);
	}

	/**
	 * Method getConfigModuleCount.
	 * 
	 * @return the size of this collection
	 */
	public int getConfigModuleCount() {
		return this._configModuleList.size();
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
	 * Method getNsItem.
	 * 
	 * @param index
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 * @return the value of the es.inteco.xbrl.lenlocpenloc.config.NsItem at the
	 *         given index
	 */
	public es.inteco.xbrl.lenlocpenloc.config.NsItem getNsItem(final int index)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._nsItemList.size()) {
			throw new IndexOutOfBoundsException("getNsItem: Index value '" + index + "' not in range [0.."
			        + (this._nsItemList.size() - 1) + "]");
		}

		return (es.inteco.xbrl.lenlocpenloc.config.NsItem) _nsItemList.get(index);
	}

	/**
	 * Method getNsItem.Returns the contents of the collection in an Array.
	 * <p>
	 * Note: Just in case the collection contents are changing in another
	 * thread, we pass a 0-length Array of the correct type into the API call.
	 * This way we <i>know</i> that the Array returned is of exactly the correct
	 * length.
	 * 
	 * @return this collection as an Array
	 */
	public es.inteco.xbrl.lenlocpenloc.config.NsItem[] getNsItem() {
		es.inteco.xbrl.lenlocpenloc.config.NsItem[] array = new es.inteco.xbrl.lenlocpenloc.config.NsItem[0];
		return (es.inteco.xbrl.lenlocpenloc.config.NsItem[]) this._nsItemList.toArray(array);
	}

	/**
	 * Method getNsItemCount.
	 * 
	 * @return the size of this collection
	 */
	public int getNsItemCount() {
		return this._nsItemList.size();
	}

	/**
	 * Returns the value of field 'schemaRef'.
	 * 
	 * @return the value of field 'SchemaRef'.
	 */
	public es.inteco.xbrl.lenlocpenloc.config.SchemaRef getSchemaRef() {
		return this._schemaRef;
	}

	/**
	 * Method getUnit.
	 * 
	 * @param index
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 * @return the value of the es.inteco.xbrl.lenlocpenloc.config.Unit at the
	 *         given index
	 */
	public es.inteco.xbrl.lenlocpenloc.config.Unit getUnit(final int index) throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._unitList.size()) {
			throw new IndexOutOfBoundsException("getUnit: Index value '" + index + "' not in range [0.."
			        + (this._unitList.size() - 1) + "]");
		}

		return (es.inteco.xbrl.lenlocpenloc.config.Unit) _unitList.get(index);
	}

	/**
	 * Method getUnit.Returns the contents of the collection in an Array.
	 * <p>
	 * Note: Just in case the collection contents are changing in another
	 * thread, we pass a 0-length Array of the correct type into the API call.
	 * This way we <i>know</i> that the Array returned is of exactly the correct
	 * length.
	 * 
	 * @return this collection as an Array
	 */
	public es.inteco.xbrl.lenlocpenloc.config.Unit[] getUnit() {
		es.inteco.xbrl.lenlocpenloc.config.Unit[] array = new es.inteco.xbrl.lenlocpenloc.config.Unit[0];
		return (es.inteco.xbrl.lenlocpenloc.config.Unit[]) this._unitList.toArray(array);
	}

	/**
	 * Method getUnitCount.
	 * 
	 * @return the size of this collection
	 */
	public int getUnitCount() {
		return this._unitList.size();
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
	public void removeAllConfigModule() {
		this._configModuleList.clear();
	}

	/**
     */
	public void removeAllNsItem() {
		this._nsItemList.clear();
	}

	/**
     */
	public void removeAllUnit() {
		this._unitList.clear();
	}

	/**
	 * Method removeConfigModule.
	 * 
	 * @param vConfigModule
	 * @return true if the object was removed from the collection.
	 */
	public boolean removeConfigModule(final es.inteco.xbrl.lenlocpenloc.config.ConfigModule vConfigModule) {
		boolean removed = _configModuleList.remove(vConfigModule);
		return removed;
	}

	/**
	 * Method removeConfigModuleAt.
	 * 
	 * @param index
	 * @return the element removed from the collection
	 */
	public es.inteco.xbrl.lenlocpenloc.config.ConfigModule removeConfigModuleAt(final int index) {
		java.lang.Object obj = this._configModuleList.remove(index);
		return (es.inteco.xbrl.lenlocpenloc.config.ConfigModule) obj;
	}

	/**
	 * Method removeNsItem.
	 * 
	 * @param vNsItem
	 * @return true if the object was removed from the collection.
	 */
	public boolean removeNsItem(final es.inteco.xbrl.lenlocpenloc.config.NsItem vNsItem) {
		boolean removed = _nsItemList.remove(vNsItem);
		return removed;
	}

	/**
	 * Method removeNsItemAt.
	 * 
	 * @param index
	 * @return the element removed from the collection
	 */
	public es.inteco.xbrl.lenlocpenloc.config.NsItem removeNsItemAt(final int index) {
		java.lang.Object obj = this._nsItemList.remove(index);
		return (es.inteco.xbrl.lenlocpenloc.config.NsItem) obj;
	}

	/**
	 * Method removeUnit.
	 * 
	 * @param vUnit
	 * @return true if the object was removed from the collection.
	 */
	public boolean removeUnit(final es.inteco.xbrl.lenlocpenloc.config.Unit vUnit) {
		boolean removed = _unitList.remove(vUnit);
		return removed;
	}

	/**
	 * Method removeUnitAt.
	 * 
	 * @param index
	 * @return the element removed from the collection
	 */
	public es.inteco.xbrl.lenlocpenloc.config.Unit removeUnitAt(final int index) {
		java.lang.Object obj = this._unitList.remove(index);
		return (es.inteco.xbrl.lenlocpenloc.config.Unit) obj;
	}

	/**
	 * 
	 * 
	 * @param index
	 * @param vConfigModule
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void setConfigModule(final int index, final es.inteco.xbrl.lenlocpenloc.config.ConfigModule vConfigModule)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._configModuleList.size()) {
			throw new IndexOutOfBoundsException("setConfigModule: Index value '" + index + "' not in range [0.."
			        + (this._configModuleList.size() - 1) + "]");
		}

		this._configModuleList.set(index, vConfigModule);
	}

	/**
	 * 
	 * 
	 * @param vConfigModuleArray
	 */
	public void setConfigModule(final es.inteco.xbrl.lenlocpenloc.config.ConfigModule[] vConfigModuleArray) {
		// -- copy array
		_configModuleList.clear();

		for(int i = 0; i < vConfigModuleArray.length; i++) {
			this._configModuleList.add(vConfigModuleArray[i]);
		}
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
	 * @param vNsItem
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void setNsItem(final int index, final es.inteco.xbrl.lenlocpenloc.config.NsItem vNsItem)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._nsItemList.size()) {
			throw new IndexOutOfBoundsException("setNsItem: Index value '" + index + "' not in range [0.."
			        + (this._nsItemList.size() - 1) + "]");
		}

		this._nsItemList.set(index, vNsItem);
	}

	/**
	 * 
	 * 
	 * @param vNsItemArray
	 */
	public void setNsItem(final es.inteco.xbrl.lenlocpenloc.config.NsItem[] vNsItemArray) {
		// -- copy array
		_nsItemList.clear();

		for(int i = 0; i < vNsItemArray.length; i++) {
			this._nsItemList.add(vNsItemArray[i]);
		}
	}

	/**
	 * Sets the value of field 'schemaRef'.
	 * 
	 * @param schemaRef the value of field 'schemaRef'.
	 */
	public void setSchemaRef(final es.inteco.xbrl.lenlocpenloc.config.SchemaRef schemaRef) {
		this._schemaRef = schemaRef;
	}

	/**
	 * 
	 * 
	 * @param index
	 * @param vUnit
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void setUnit(final int index, final es.inteco.xbrl.lenlocpenloc.config.Unit vUnit)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._unitList.size()) {
			throw new IndexOutOfBoundsException("setUnit: Index value '" + index + "' not in range [0.."
			        + (this._unitList.size() - 1) + "]");
		}

		this._unitList.set(index, vUnit);
	}

	/**
	 * 
	 * 
	 * @param vUnitArray
	 */
	public void setUnit(final es.inteco.xbrl.lenlocpenloc.config.Unit[] vUnitArray) {
		// -- copy array
		_unitList.clear();

		for(int i = 0; i < vUnitArray.length; i++) {
			this._unitList.add(vUnitArray[i]);
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
	 * @return the unmarshaled es.inteco.xbrl.lenlocpenloc.config.ConfigReport
	 */
	public static es.inteco.xbrl.lenlocpenloc.config.ConfigReport unmarshal(final java.io.Reader reader)
	        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
		return (es.inteco.xbrl.lenlocpenloc.config.ConfigReport) org.exolab.castor.xml.Unmarshaller.unmarshal(
		        es.inteco.xbrl.lenlocpenloc.config.ConfigReport.class, reader);
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