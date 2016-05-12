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
 * Class ENLOCErrorsOutput.
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
public class ENLOCErrorsOutput implements java.io.Serializable {

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * Field _ENLOCErrorOutList.
	 */
	private java.util.Vector<es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut> _ENLOCErrorOutList;

	// ----------------/
	// - Constructors -/
	// ----------------/

	public ENLOCErrorsOutput() {
		super();
		this._ENLOCErrorOutList = new java.util.Vector<es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut>();
	}

	// -----------/
	// - Methods -/
	// -----------/

	/**
	 * 
	 * 
	 * @param vENLOCErrorOut
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addENLOCErrorOut(final es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut vENLOCErrorOut)
	        throws java.lang.IndexOutOfBoundsException {
		this._ENLOCErrorOutList.addElement(vENLOCErrorOut);
	}

	/**
	 * 
	 * 
	 * @param vENLOCErrorOut
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addENLOCErrorOutBefore(final es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut vENLOCErrorOut)
	        throws java.lang.IndexOutOfBoundsException {
		this._ENLOCErrorOutList.add(0, vENLOCErrorOut);
	}

	/**
	 * 
	 * 
	 * @param index
	 * @param vENLOCErrorOut
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addENLOCErrorOut(final int index,
	        final es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut vENLOCErrorOut)
	        throws java.lang.IndexOutOfBoundsException {
		this._ENLOCErrorOutList.add(index, vENLOCErrorOut);
	}

	/**
	 * Method enumerateENLOCErrorOut.
	 * 
	 * @return an Enumeration over all
	 *         es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut elements
	 */
	public java.util.Enumeration<? extends es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut> enumerateENLOCErrorOut() {
		return this._ENLOCErrorOutList.elements();
	}

	/**
	 * Method getENLOCErrorOut.
	 * 
	 * @param index
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 * @return the value of the
	 *         es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut at the given
	 *         index
	 */
	public es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut getENLOCErrorOut(final int index)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._ENLOCErrorOutList.size()) {
			throw new IndexOutOfBoundsException("getENLOCErrorOut: Index value '" + index + "' not in range [0.."
			        + (this._ENLOCErrorOutList.size() - 1) + "]");
		}

		return (es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut) _ENLOCErrorOutList.get(index);
	}

	/**
	 * Method getENLOCErrorOut.Returns the contents of the collection in an
	 * Array.
	 * <p>
	 * Note: Just in case the collection contents are changing in another
	 * thread, we pass a 0-length Array of the correct type into the API call.
	 * This way we <i>know</i> that the Array returned is of exactly the correct
	 * length.
	 * 
	 * @return this collection as an Array
	 */
	public es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut[] getENLOCErrorOut() {
		es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut[] array = new es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut[0];
		return (es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut[]) this._ENLOCErrorOutList.toArray(array);
	}

	/**
	 * Method getENLOCErrorOutCount.
	 * 
	 * @return the size of this collection
	 */
	public int getENLOCErrorOutCount() {
		return this._ENLOCErrorOutList.size();
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
	public void removeAllENLOCErrorOut() {
		this._ENLOCErrorOutList.clear();
	}

	/**
	 * Method removeENLOCErrorOut.
	 * 
	 * @param vENLOCErrorOut
	 * @return true if the object was removed from the collection.
	 */
	public boolean removeENLOCErrorOut(final es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut vENLOCErrorOut) {
		boolean removed = _ENLOCErrorOutList.remove(vENLOCErrorOut);
		return removed;
	}

	/**
	 * Method removeENLOCErrorOutAt.
	 * 
	 * @param index
	 * @return the element removed from the collection
	 */
	public es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut removeENLOCErrorOutAt(final int index) {
		java.lang.Object obj = this._ENLOCErrorOutList.remove(index);
		return (es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut) obj;
	}

	/**
	 * 
	 * 
	 * @param index
	 * @param vENLOCErrorOut
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void setENLOCErrorOut(final int index,
	        final es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut vENLOCErrorOut)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._ENLOCErrorOutList.size()) {
			throw new IndexOutOfBoundsException("setENLOCErrorOut: Index value '" + index + "' not in range [0.."
			        + (this._ENLOCErrorOutList.size() - 1) + "]");
		}

		this._ENLOCErrorOutList.set(index, vENLOCErrorOut);
	}

	/**
	 * 
	 * 
	 * @param vENLOCErrorOutArray
	 */
	public void setENLOCErrorOut(final es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut[] vENLOCErrorOutArray) {
		// -- copy array
		_ENLOCErrorOutList.clear();

		for(int i = 0; i < vENLOCErrorOutArray.length; i++) {
			this._ENLOCErrorOutList.add(vENLOCErrorOutArray[i]);
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
	 *         es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorsOutput
	 */
	public static es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorsOutput unmarshal(final java.io.Reader reader)
	        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
		return (es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorsOutput) org.exolab.castor.xml.Unmarshaller.unmarshal(
		        es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorsOutput.class, reader);
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