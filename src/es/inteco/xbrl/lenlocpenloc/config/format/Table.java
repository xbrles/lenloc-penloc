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
 * Table.java,v 1.4 2009/01/19 14:06:34 a130499 Exp $
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
public class Table implements java.io.Serializable {

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * Field _id.
	 */
	private java.lang.String _id;

	/**
	 * Field _rowList.
	 */
	private java.util.Vector<es.inteco.xbrl.lenlocpenloc.config.format.Row> _rowList;

	// ----------------/
	// - Constructors -/
	// ----------------/

	public Table() {
		super();
		this._rowList = new java.util.Vector<es.inteco.xbrl.lenlocpenloc.config.format.Row>();
	}

	// -----------/
	// - Methods -/
	// -----------/

	/**
	 * 
	 * 
	 * @param vRow
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addRow(final es.inteco.xbrl.lenlocpenloc.config.format.Row vRow)
	        throws java.lang.IndexOutOfBoundsException {
		this._rowList.addElement(vRow);
	}

	/**
	 * 
	 * 
	 * @param index
	 * @param vRow
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addRow(final int index, final es.inteco.xbrl.lenlocpenloc.config.format.Row vRow)
	        throws java.lang.IndexOutOfBoundsException {
		this._rowList.add(index, vRow);
	}

	/**
	 * Method enumerateRow.
	 * 
	 * @return an Enumeration over all
	 *         es.inteco.xbrl.lenlocpenloc.config.format.Row elements
	 */
	public java.util.Enumeration<? extends es.inteco.xbrl.lenlocpenloc.config.format.Row> enumerateRow() {
		return this._rowList.elements();
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
	 * Method getRow.
	 * 
	 * @param index
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 * @return the value of the es.inteco.xbrl.lenlocpenloc.config.format.Row at
	 *         the given index
	 */
	public es.inteco.xbrl.lenlocpenloc.config.format.Row getRow(final int index)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._rowList.size()) {
			throw new IndexOutOfBoundsException("getRow: Index value '" + index + "' not in range [0.."
			        + (this._rowList.size() - 1) + "]");
		}

		return (es.inteco.xbrl.lenlocpenloc.config.format.Row) _rowList.get(index);
	}

	/**
	 * Method getRow.Returns the contents of the collection in an Array.
	 * <p>
	 * Note: Just in case the collection contents are changing in another
	 * thread, we pass a 0-length Array of the correct type into the API call.
	 * This way we <i>know</i> that the Array returned is of exactly the correct
	 * length.
	 * 
	 * @return this collection as an Array
	 */
	public es.inteco.xbrl.lenlocpenloc.config.format.Row[] getRow() {
		es.inteco.xbrl.lenlocpenloc.config.format.Row[] array = new es.inteco.xbrl.lenlocpenloc.config.format.Row[0];
		return (es.inteco.xbrl.lenlocpenloc.config.format.Row[]) this._rowList.toArray(array);
	}

	/**
	 * Method getRowCount.
	 * 
	 * @return the size of this collection
	 */
	public int getRowCount() {
		return this._rowList.size();
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
	public void removeAllRow() {
		this._rowList.clear();
	}

	/**
	 * Method removeRow.
	 * 
	 * @param vRow
	 * @return true if the object was removed from the collection.
	 */
	public boolean removeRow(final es.inteco.xbrl.lenlocpenloc.config.format.Row vRow) {
		boolean removed = _rowList.remove(vRow);
		return removed;
	}

	/**
	 * Method removeRowAt.
	 * 
	 * @param index
	 * @return the element removed from the collection
	 */
	public es.inteco.xbrl.lenlocpenloc.config.format.Row removeRowAt(final int index) {
		java.lang.Object obj = this._rowList.remove(index);
		return (es.inteco.xbrl.lenlocpenloc.config.format.Row) obj;
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
	 * @param vRow
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void setRow(final int index, final es.inteco.xbrl.lenlocpenloc.config.format.Row vRow)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._rowList.size()) {
			throw new IndexOutOfBoundsException("setRow: Index value '" + index + "' not in range [0.."
			        + (this._rowList.size() - 1) + "]");
		}

		this._rowList.set(index, vRow);
	}

	/**
	 * 
	 * 
	 * @param vRowArray
	 */
	public void setRow(final es.inteco.xbrl.lenlocpenloc.config.format.Row[] vRowArray) {
		// -- copy array
		_rowList.clear();

		for(int i = 0; i < vRowArray.length; i++) {
			this._rowList.add(vRowArray[i]);
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
	 * @return the unmarshaled es.inteco.xbrl.lenlocpenloc.config.format.Table
	 */
	public static es.inteco.xbrl.lenlocpenloc.config.format.Table unmarshal(final java.io.Reader reader)
	        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
		return (es.inteco.xbrl.lenlocpenloc.config.format.Table) org.exolab.castor.xml.Unmarshaller.unmarshal(
		        es.inteco.xbrl.lenlocpenloc.config.format.Table.class, reader);
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