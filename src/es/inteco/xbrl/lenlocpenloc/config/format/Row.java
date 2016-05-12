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

import java.util.ArrayList;
import java.util.HashSet;

import org.apache.log4j.Logger;

/**
 * 
 * This class was automatically generated with <a
 * href="http://www.castor.org">Castor 1.3rc1</a>, using an XML Schema. $Id:
 * Row.java,v 1.4 2009/01/19 14:06:34 a130499 Exp $
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
public class Row implements java.io.Serializable {

	private static final Logger logger = Logger.getLogger(Row.class);

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * Field _id.
	 */
	private java.lang.String _id;

	/**
	 * Field _value.
	 */
	private java.lang.String _value;

	/**
	 * Field _index.
	 */
	private long _index;

	/**
	 * keeps track of state for field: _index
	 */
	private boolean _has_index;

	/**
	 * Field _itemList.
	 */
	private java.util.Vector<es.inteco.xbrl.lenlocpenloc.config.format.Item> _itemList;

	private HashSet itemsInRow;

	// ----------------/
	// - Constructors -/
	// ----------------/

	
    /**
     * @return the itemsInRow
     */
    public HashSet getItemsInRow() {
    	if(itemsInRow == null) {
    		itemsInRow = new HashSet();
    	}
    	return itemsInRow;
    }

	public Row() {
		super();
		this._itemList = new java.util.Vector<es.inteco.xbrl.lenlocpenloc.config.format.Item>();
	}

	// -----------/
	// - Methods -/
	// -----------/

	
	public boolean equals(Object object) {
		boolean isEqual = false;
		Row vRow = (Row)object;
		if( vRow.getId()!=null && this.getId().equals(vRow.getId())
			&& vRow.getValue()!=null && this.getValue().equals(vRow.getValue())) {
			isEqual = true;
		}
		return isEqual;
	}
	
	/**
	 * 
	 * 
	 * @param vItem
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addItem(final es.inteco.xbrl.lenlocpenloc.config.format.Item vItem, ArrayList<String> loggerTraceList)
	        throws java.lang.IndexOutOfBoundsException {
		if(this._itemList.contains(vItem)) {
			logger.warn(("WARNING: Duplicate element "+vItem.getId()+" in row "+ this.getId()));
			if(!(loggerTraceList == null)) {
				loggerTraceList.add("WARNING: Duplicate element = " + vItem.getId() + " in row "+ this.getId());
			}
		}
		this._itemList.addElement(vItem);
	}

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
     */
	public void deleteIndex() {
		this._has_index = false;
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
	 * Returns the value of field 'id'.
	 * 
	 * @return the value of field 'Id'.
	 */
	public java.lang.String getId() {
		return this._id;
	}

	/**
	 * Returns the value of field 'value'.
	 * 
	 * @return the value of field 'value'.
	 */
	public java.lang.String getValue() {
		return this._value;
	}

	/**
	 * Returns the value of field 'index'.
	 * 
	 * @return the value of field 'Index'.
	 */
	public long getIndex() {
		return this._index;
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
	 * Method hasIndex.
	 * 
	 * @return true if at least one Index has been added
	 */
	public boolean hasIndex() {
		return this._has_index;
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
	 * Sets the value of field 'id'.
	 * 
	 * @param id the value of field 'id'.
	 */
	public void setId(final java.lang.String id) {
		this._id = id;
	}

	/**
	 * Sets the value of field 'value'.
	 * 
	 * @param value the value of field 'value'.
	 */
	public void setValue(final java.lang.String value) {
		this._value = value;
	}

	/**
	 * Sets the value of field 'index'.
	 * 
	 * @param index the value of field 'index'.
	 */
	public void setIndex(final long index) {
		this._index = index;
		this._has_index = true;
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
	 * Method unmarshal.
	 * 
	 * @param reader
	 * @throws org.exolab.castor.xml.MarshalException if object is null or if
	 *         any SAXException is thrown during marshaling
	 * @throws org.exolab.castor.xml.ValidationException if this object is an
	 *         invalid instance according to the schema
	 * @return the unmarshaled es.inteco.xbrl.lenlocpenloc.config.format.Row
	 */
	public static es.inteco.xbrl.lenlocpenloc.config.format.Row unmarshal(final java.io.Reader reader)
	        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
		return (es.inteco.xbrl.lenlocpenloc.config.format.Row) org.exolab.castor.xml.Unmarshaller.unmarshal(
		        es.inteco.xbrl.lenlocpenloc.config.format.Row.class, reader);
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