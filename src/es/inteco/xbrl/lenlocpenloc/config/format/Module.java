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

package es.inteco.xbrl.lenlocpenloc.config.format;

/**
 * 
 * This class was automatically generated with <a
 * href="http://www.castor.org">Castor 1.3rc1</a>, using an XML Schema. $Id:
 * Module.java,v 1.5 2009/01/29 06:57:50 a130499 Exp $
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
 * 
 */

@SuppressWarnings ("serial")
public class Module implements java.io.Serializable {

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * Field _id.
	 */
	private java.lang.String _id;

	/**
	 * Field _reportingStartDate.
	 */
	private org.exolab.castor.types.Date _reportingStartDate;

	/**
	 * Field _reportingEndDate.
	 */
	private org.exolab.castor.types.Date _reportingEndDate;

	/**
	 * Field _baseUnit.
	 */
	private es.inteco.xbrl.lenlocpenloc.config.format.types.Unittype _baseUnit = es.inteco.xbrl.lenlocpenloc.config.format.types.Unittype
	        .fromValue("string");

	/**
	 * Field _baseDecimals.
	 */
	private java.lang.String _baseDecimals = "0";

	/**
	 * Field _itemList.
	 */
	private java.util.Vector<es.inteco.xbrl.lenlocpenloc.config.format.Item> _itemList;

	/**
	 * Field _tableList.
	 */
	private java.util.Vector<es.inteco.xbrl.lenlocpenloc.config.format.Table> _tableList;

	// ----------------/
	// - Constructors -/
	// ----------------/

	public Module() {
		super();
		setBaseUnit(es.inteco.xbrl.lenlocpenloc.config.format.types.Unittype.fromValue("string"));
		setBaseDecimals("0");
		this._itemList = new java.util.Vector<es.inteco.xbrl.lenlocpenloc.config.format.Item>();
		this._tableList = new java.util.Vector<es.inteco.xbrl.lenlocpenloc.config.format.Table>();
	}

	// -----------/
	// - Methods -/
	// -----------/

	/**
	 * 
	 * 
	 * @param vItem
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addItem(final es.inteco.xbrl.lenlocpenloc.config.format.Item vItem)
	        throws java.lang.IndexOutOfBoundsException {
		this._itemList.addElement(vItem);
	}

	/**
	 * 
	 * 
	 * @param index
	 * @param vItem
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addItem(final int index, final es.inteco.xbrl.lenlocpenloc.config.format.Item vItem)
	        throws java.lang.IndexOutOfBoundsException {
		this._itemList.add(index, vItem);
	}

	/**
	 * 
	 * 
	 * @param vTable
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addTable(final es.inteco.xbrl.lenlocpenloc.config.format.Table vTable)
	        throws java.lang.IndexOutOfBoundsException {
		this._tableList.addElement(vTable);
	}

	/**
	 * 
	 * 
	 * @param index
	 * @param vTable
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addTable(final int index, final es.inteco.xbrl.lenlocpenloc.config.format.Table vTable)
	        throws java.lang.IndexOutOfBoundsException {
		this._tableList.add(index, vTable);
	}

	/**
	 * Method enumerateItem.
	 * 
	 * @return an Enumeration over all
	 *         es.inteco.xbrl.lenlocpenloc.config.format.Item elements
	 */
	public java.util.Enumeration<? extends es.inteco.xbrl.lenlocpenloc.config.format.Item> enumerateItem() {
		return this._itemList.elements();
	}

	/**
	 * Method enumerateTable.
	 * 
	 * @return an Enumeration over all
	 *         es.inteco.xbrl.lenlocpenloc.config.format.Table elements
	 */
	public java.util.Enumeration<? extends es.inteco.xbrl.lenlocpenloc.config.format.Table> enumerateTable() {
		return this._tableList.elements();
	}

	/**
	 * Returns the value of field 'baseDecimals'.
	 * 
	 * @return the value of field 'BaseDecimals'.
	 */
	public java.lang.String getBaseDecimals() {
		return this._baseDecimals;
	}

	/**
	 * Returns the value of field 'baseUnit'.
	 * 
	 * @return the value of field 'BaseUnit'.
	 */
	public es.inteco.xbrl.lenlocpenloc.config.format.types.Unittype getBaseUnit() {
		return this._baseUnit;
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
	 * Method getItem.
	 * 
	 * @param index
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 * @return the value of the es.inteco.xbrl.lenlocpenloc.config.format.Item
	 *         at the given index
	 */
	public es.inteco.xbrl.lenlocpenloc.config.format.Item getItem(final int index)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._itemList.size()) {
			throw new IndexOutOfBoundsException("getItem: Index value '" + index + "' not in range [0.."
			        + (this._itemList.size() - 1) + "]");
		}

		return (es.inteco.xbrl.lenlocpenloc.config.format.Item) _itemList.get(index);
	}

	/**
	 * Method getItem.Returns the contents of the collection in an Array.
	 * <p>
	 * Note: Just in case the collection contents are changing in another
	 * thread, we pass a 0-length Array of the correct type into the API call.
	 * This way we <i>know</i> that the Array returned is of exactly the correct
	 * length.
	 * 
	 * @return this collection as an Array
	 */
	public es.inteco.xbrl.lenlocpenloc.config.format.Item[] getItem() {
		es.inteco.xbrl.lenlocpenloc.config.format.Item[] array = new es.inteco.xbrl.lenlocpenloc.config.format.Item[0];
		return (es.inteco.xbrl.lenlocpenloc.config.format.Item[]) this._itemList.toArray(array);
	}

	/**
	 * Method getItemCount.
	 * 
	 * @return the size of this collection
	 */
	public int getItemCount() {
		return this._itemList.size();
	}

	/**
	 * Returns the value of field 'reportingEndDate'.
	 * 
	 * @return the value of field 'ReportingEndDate'.
	 */
	public org.exolab.castor.types.Date getReportingEndDate() {
		return this._reportingEndDate;
	}

	/**
	 * Returns the value of field 'reportingStartDate'.
	 * 
	 * @return the value of field 'ReportingStartDate'.
	 */
	public org.exolab.castor.types.Date getReportingStartDate() {
		return this._reportingStartDate;
	}

	/**
	 * Method getTable.
	 * 
	 * @param index
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 * @return the value of the es.inteco.xbrl.lenlocpenloc.config.format.Table
	 *         at the given index
	 */
	public es.inteco.xbrl.lenlocpenloc.config.format.Table getTable(final int index)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._tableList.size()) {
			throw new IndexOutOfBoundsException("getTable: Index value '" + index + "' not in range [0.."
			        + (this._tableList.size() - 1) + "]");
		}

		return (es.inteco.xbrl.lenlocpenloc.config.format.Table) _tableList.get(index);
	}

	/**
	 * Method getTable.Returns the contents of the collection in an Array.
	 * <p>
	 * Note: Just in case the collection contents are changing in another
	 * thread, we pass a 0-length Array of the correct type into the API call.
	 * This way we <i>know</i> that the Array returned is of exactly the correct
	 * length.
	 * 
	 * @return this collection as an Array
	 */
	public es.inteco.xbrl.lenlocpenloc.config.format.Table[] getTable() {
		es.inteco.xbrl.lenlocpenloc.config.format.Table[] array = new es.inteco.xbrl.lenlocpenloc.config.format.Table[0];
		return (es.inteco.xbrl.lenlocpenloc.config.format.Table[]) this._tableList.toArray(array);
	}

	/**
	 * Method getTableCount.
	 * 
	 * @return the size of this collection
	 */
	public int getTableCount() {
		return this._tableList.size();
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
	public void removeAllItem() {
		this._itemList.clear();
	}

	/**
     */
	public void removeAllTable() {
		this._tableList.clear();
	}

	/**
	 * Method removeItem.
	 * 
	 * @param vItem
	 * @return true if the object was removed from the collection.
	 */
	public boolean removeItem(final es.inteco.xbrl.lenlocpenloc.config.format.Item vItem) {
		boolean removed = _itemList.remove(vItem);
		return removed;
	}

	/**
	 * Method removeItemAt.
	 * 
	 * @param index
	 * @return the element removed from the collection
	 */
	public es.inteco.xbrl.lenlocpenloc.config.format.Item removeItemAt(final int index) {
		java.lang.Object obj = this._itemList.remove(index);
		return (es.inteco.xbrl.lenlocpenloc.config.format.Item) obj;
	}

	/**
	 * Method removeTable.
	 * 
	 * @param vTable
	 * @return true if the object was removed from the collection.
	 */
	public boolean removeTable(final es.inteco.xbrl.lenlocpenloc.config.format.Table vTable) {
		boolean removed = _tableList.remove(vTable);
		return removed;
	}

	/**
	 * Method removeTableAt.
	 * 
	 * @param index
	 * @return the element removed from the collection
	 */
	public es.inteco.xbrl.lenlocpenloc.config.format.Table removeTableAt(final int index) {
		java.lang.Object obj = this._tableList.remove(index);
		return (es.inteco.xbrl.lenlocpenloc.config.format.Table) obj;
	}

	/**
	 * Sets the value of field 'baseDecimals'.
	 * 
	 * @param baseDecimals the value of field 'baseDecimals'.
	 */
	public void setBaseDecimals(final java.lang.String baseDecimals) {
		this._baseDecimals = baseDecimals;
	}

	/**
	 * Sets the value of field 'baseUnit'.
	 * 
	 * @param baseUnit the value of field 'baseUnit'.
	 */
	public void setBaseUnit(final es.inteco.xbrl.lenlocpenloc.config.format.types.Unittype baseUnit) {
		this._baseUnit = baseUnit;
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
	 * @param vItem
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void setItem(final int index, final es.inteco.xbrl.lenlocpenloc.config.format.Item vItem)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._itemList.size()) {
			throw new IndexOutOfBoundsException("setItem: Index value '" + index + "' not in range [0.."
			        + (this._itemList.size() - 1) + "]");
		}

		this._itemList.set(index, vItem);
	}

	/**
	 * 
	 * 
	 * @param vItemArray
	 */
	public void setItem(final es.inteco.xbrl.lenlocpenloc.config.format.Item[] vItemArray) {
		// -- copy array
		_itemList.clear();

		for(int i = 0; i < vItemArray.length; i++) {
			this._itemList.add(vItemArray[i]);
		}
	}

	/**
	 * Sets the value of field 'reportingEndDate'.
	 * 
	 * @param reportingEndDate the value of field 'reportingEndDate'
	 */
	public void setReportingEndDate(final org.exolab.castor.types.Date reportingEndDate) {
		this._reportingEndDate = reportingEndDate;
	}

	/**
	 * Sets the value of field 'reportingStartDate'.
	 * 
	 * @param reportingStartDate the value of field 'reportingStartDate'.
	 */
	public void setReportingStartDate(final org.exolab.castor.types.Date reportingStartDate) {
		this._reportingStartDate = reportingStartDate;
	}

	/**
	 * 
	 * 
	 * @param index
	 * @param vTable
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void setTable(final int index, final es.inteco.xbrl.lenlocpenloc.config.format.Table vTable)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._tableList.size()) {
			throw new IndexOutOfBoundsException("setTable: Index value '" + index + "' not in range [0.."
			        + (this._tableList.size() - 1) + "]");
		}

		this._tableList.set(index, vTable);
	}

	/**
	 * 
	 * 
	 * @param vTableArray
	 */
	public void setTable(final es.inteco.xbrl.lenlocpenloc.config.format.Table[] vTableArray) {
		// -- copy array
		_tableList.clear();

		for(int i = 0; i < vTableArray.length; i++) {
			this._tableList.add(vTableArray[i]);
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
	 * @return the unmarshaled es.inteco.xbrl.lenlocpenloc.config.format.Module
	 */
	public static es.inteco.xbrl.lenlocpenloc.config.format.Module unmarshal(final java.io.Reader reader)
	        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
		return (es.inteco.xbrl.lenlocpenloc.config.format.Module) org.exolab.castor.xml.Unmarshaller.unmarshal(
		        es.inteco.xbrl.lenlocpenloc.config.format.Module.class, reader);
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