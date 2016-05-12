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
 * Item.java,v 1.4 2009/01/19 14:06:34 a130499 Exp $
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
public class Item implements java.io.Serializable {

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * Field _id.
	 */
	private java.lang.String _id;

	/**
	 * Field _sign.
	 */
	private es.inteco.xbrl.lenlocpenloc.config.format.types.ItemSignType _sign;

	/**
	 * Field _unit.
	 */
	private es.inteco.xbrl.lenlocpenloc.config.format.types.Unittype _unit;

	/**
	 * Field _decimals.
	 */
	private java.lang.String _decimals;

	/**
	 * Field _reportingDate.
	 */
	private org.exolab.castor.types.Date _reportingDate;

	/**
	 * Field _value.
	 */
	private java.lang.String _value;

	/**
	 * Field _noteList.
	 */
	private java.util.Vector<es.inteco.xbrl.lenlocpenloc.config.format.Note> _noteList;

	// ----------------/
	// - Constructors -/
	// ----------------/

	public Item() {
		super();
		this._noteList = new java.util.Vector<es.inteco.xbrl.lenlocpenloc.config.format.Note>();
	}

	// -----------/
	// - Methods -/
	// -----------/

	
	public boolean equals(Object object) {
		boolean isEqual = false;
		Item vItem = (Item)object;
		if(vItem.getId()!=null && this.getId().equals(vItem.getId())) {
			isEqual = true;
		}
		return isEqual;
	}
	
	/**
	 * 
	 * 
	 * @param vNote
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addNote(final es.inteco.xbrl.lenlocpenloc.config.format.Note vNote)
	        throws java.lang.IndexOutOfBoundsException {
		this._noteList.addElement(vNote);
	}

	/**
	 * 
	 * 
	 * @param index
	 * @param vNote
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addNote(final int index, final es.inteco.xbrl.lenlocpenloc.config.format.Note vNote)
	        throws java.lang.IndexOutOfBoundsException {
		this._noteList.add(index, vNote);
	}

	/**
	 * Method enumerateNote.
	 * 
	 * @return an Enumeration over all
	 *         es.inteco.xbrl.lenlocpenloc.config.format.Note elements
	 */
	public java.util.Enumeration<? extends es.inteco.xbrl.lenlocpenloc.config.format.Note> enumerateNote() {
		return this._noteList.elements();
	}

	/**
	 * Returns the value of field 'decimals'.
	 * 
	 * @return the value of field 'Decimals'.
	 */
	public java.lang.String getDecimals() {
		return this._decimals;
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
	 * Method getNote.
	 * 
	 * @param index
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 * @return the value of the es.inteco.xbrl.lenlocpenloc.config.format.Note
	 *         at the given index
	 */
	public es.inteco.xbrl.lenlocpenloc.config.format.Note getNote(final int index)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._noteList.size()) {
			throw new IndexOutOfBoundsException("getNote: Index value '" + index + "' not in range [0.."
			        + (this._noteList.size() - 1) + "]");
		}

		return (es.inteco.xbrl.lenlocpenloc.config.format.Note) _noteList.get(index);
	}

	/**
	 * Method getNote.Returns the contents of the collection in an Array.
	 * <p>
	 * Note: Just in case the collection contents are changing in another
	 * thread, we pass a 0-length Array of the correct type into the API call.
	 * This way we <i>know</i> that the Array returned is of exactly the correct
	 * length.
	 * 
	 * @return this collection as an Array
	 */
	public es.inteco.xbrl.lenlocpenloc.config.format.Note[] getNote() {
		es.inteco.xbrl.lenlocpenloc.config.format.Note[] array = new es.inteco.xbrl.lenlocpenloc.config.format.Note[0];
		return (es.inteco.xbrl.lenlocpenloc.config.format.Note[]) this._noteList.toArray(array);
	}

	/**
	 * Method getNoteCount.
	 * 
	 * @return the size of this collection
	 */
	public int getNoteCount() {
		return this._noteList.size();
	}

	/**
	 * Returns the value of field 'reportingDate'.
	 * 
	 * @return the value of field 'ReportingDate'.
	 */
	public org.exolab.castor.types.Date getReportingDate() {
		return this._reportingDate;
	}

	/**
	 * Returns the value of field 'sign'.
	 * 
	 * @return the value of field 'Sign'.
	 */
	public es.inteco.xbrl.lenlocpenloc.config.format.types.ItemSignType getSign() {
		return this._sign;
	}

	/**
	 * Returns the value of field 'unit'.
	 * 
	 * @return the value of field 'Unit'.
	 */
	public es.inteco.xbrl.lenlocpenloc.config.format.types.Unittype getUnit() {
		return this._unit;
	}

	/**
	 * Returns the value of field 'value'.
	 * 
	 * @return the value of field 'Value'.
	 */
	public java.lang.String getValue() {
		return this._value;
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
	public void removeAllNote() {
		this._noteList.clear();
	}

	/**
	 * Method removeNote.
	 * 
	 * @param vNote
	 * @return true if the object was removed from the collection.
	 */
	public boolean removeNote(final es.inteco.xbrl.lenlocpenloc.config.format.Note vNote) {
		boolean removed = _noteList.remove(vNote);
		return removed;
	}

	/**
	 * Method removeNoteAt.
	 * 
	 * @param index
	 * @return the element removed from the collection
	 */
	public es.inteco.xbrl.lenlocpenloc.config.format.Note removeNoteAt(final int index) {
		java.lang.Object obj = this._noteList.remove(index);
		return (es.inteco.xbrl.lenlocpenloc.config.format.Note) obj;
	}

	/**
	 * Sets the value of field 'decimals'.
	 * 
	 * @param decimals the value of field 'decimals'.
	 */
	public void setDecimals(final java.lang.String decimals) {
		this._decimals = decimals;
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
	 * @param vNote
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void setNote(final int index, final es.inteco.xbrl.lenlocpenloc.config.format.Note vNote)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._noteList.size()) {
			throw new IndexOutOfBoundsException("setNote: Index value '" + index + "' not in range [0.."
			        + (this._noteList.size() - 1) + "]");
		}

		this._noteList.set(index, vNote);
	}

	/**
	 * 
	 * 
	 * @param vNoteArray
	 */
	public void setNote(final es.inteco.xbrl.lenlocpenloc.config.format.Note[] vNoteArray) {
		// -- copy array
		_noteList.clear();

		for(int i = 0; i < vNoteArray.length; i++) {
			this._noteList.add(vNoteArray[i]);
		}
	}

	/**
	 * Sets the value of field 'reportingDate'.
	 * 
	 * @param reportingDate the value of field 'reportingDate'.
	 */
	public void setReportingDate(final org.exolab.castor.types.Date reportingDate) {
		this._reportingDate = reportingDate;
	}

	/**
	 * Sets the value of field 'sign'.
	 * 
	 * @param sign the value of field 'sign'.
	 */
	public void setSign(final es.inteco.xbrl.lenlocpenloc.config.format.types.ItemSignType sign) {
		this._sign = sign;
	}

	/**
	 * Sets the value of field 'unit'.
	 * 
	 * @param unit the value of field 'unit'.
	 */
	public void setUnit(final es.inteco.xbrl.lenlocpenloc.config.format.types.Unittype unit) {
		this._unit = unit;
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
	 * Method unmarshal.
	 * 
	 * @param reader
	 * @throws org.exolab.castor.xml.MarshalException if object is null or if
	 *         any SAXException is thrown during marshaling
	 * @throws org.exolab.castor.xml.ValidationException if this object is an
	 *         invalid instance according to the schema
	 * @return the unmarshaled es.inteco.xbrl.lenlocpenloc.config.format.Item
	 */
	public static es.inteco.xbrl.lenlocpenloc.config.format.Item unmarshal(final java.io.Reader reader)
	        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
		return (es.inteco.xbrl.lenlocpenloc.config.format.Item) org.exolab.castor.xml.Unmarshaller.unmarshal(
		        es.inteco.xbrl.lenlocpenloc.config.format.Item.class, reader);
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