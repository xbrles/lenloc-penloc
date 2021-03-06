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

package es.inteco.xbrl.lenlocpenloc.errors.out;

/**
 * Class ENLOCErrorOut.
 * 
 * <b>Proyecto</b>: API XBRL-LENLOCPENLOC2010 - Grupo de utilidades y
 * librer�as en c�digo abierto para facilitar la integraci�n del formato XBRL en
 * las herramientas software de gesti�n de terceros aisl�ndose de la complejidad
 * en el procesamiento del modelo de datos de las taxonom�as. Ayudando de esta
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
public class ENLOCErrorOut implements java.io.Serializable {

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * Field _errorCode.
	 */
	private long _errorCode;

	/**
	 * keeps track of state for field: _errorCode
	 */
	private boolean _has_errorCode;

	/**
	 * Field _errorType.
	 */
	private java.lang.String _errorType;

	/**
	 * Field _ENLOCErrorParameterList.
	 */
	private java.util.Vector<es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter> _ENLOCErrorParameterList;

	/**
	 * Field _defaultDescription.
	 */
	private java.lang.String _defaultDescription;

	/**
	 * Field _translatedDescription.
	 */
	private java.lang.String _translatedDescription;

	// ----------------/
	// - Constructors -/
	// ----------------/

	public ENLOCErrorOut() {
		super();
		this._ENLOCErrorParameterList = new java.util.Vector<es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter>();
	}

	// -----------/
	// - Methods -/
	// -----------/

	/**
	 * 
	 * 
	 * @param vENLOCErrorParameter
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addENLOCErrorParameter(
	        final es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter vENLOCErrorParameter)
	        throws java.lang.IndexOutOfBoundsException {
		this._ENLOCErrorParameterList.addElement(vENLOCErrorParameter);
	}

	/**
	 * 
	 * 
	 * @param index
	 * @param vENLOCErrorParameter
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addENLOCErrorParameter(final int index,
	        final es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter vENLOCErrorParameter)
	        throws java.lang.IndexOutOfBoundsException {
		this._ENLOCErrorParameterList.add(index, vENLOCErrorParameter);
	}

	/**
     */
	public void deleteErrorCode() {
		this._has_errorCode = false;
	}

	/**
	 * Method enumerateENLOCErrorParameter.
	 * 
	 * @return an Enumeration over all
	 *         es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter
	 *         elements
	 */
	public java.util.Enumeration<? extends es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter> enumerateENLOCErrorParameter() {
		return this._ENLOCErrorParameterList.elements();
	}

	/**
	 * Returns the value of field 'defaultDescription'.
	 * 
	 * @return the value of field 'DefaultDescription'.
	 */
	public java.lang.String getDefaultDescription() {
		return this._defaultDescription;
	}

	/**
	 * Returns the value of field 'errorCode'.
	 * 
	 * @return the value of field 'ErrorCode'.
	 */
	public long getErrorCode() {
		return this._errorCode;
	}

	/**
	 * Returns the value of field 'errorType'.
	 * 
	 * @return the value of field 'ErrorType'.
	 */
	public java.lang.String getErrorType() {
		return this._errorType;
	}

	/**
	 * Method getENLOCErrorParameter.
	 * 
	 * @param index
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 * @return the value of the
	 *         es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter at the
	 *         given index
	 */
	public es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter getENLOCErrorParameter(final int index)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._ENLOCErrorParameterList.size()) {
			throw new IndexOutOfBoundsException("getENLOCErrorParameter: Index value '" + index + "' not in range [0.."
			        + (this._ENLOCErrorParameterList.size() - 1) + "]");
		}

		return (es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter) _ENLOCErrorParameterList.get(index);
	}

	/**
	 * Method getENLOCErrorParameter.Returns the contents of the collection in
	 * an Array.
	 * <p>
	 * Note: Just in case the collection contents are changing in another
	 * thread, we pass a 0-length Array of the correct type into the API call.
	 * This way we <i>know</i> that the Array returned is of exactly the correct
	 * length.
	 * 
	 * @return this collection as an Array
	 */
	public es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter[] getENLOCErrorParameter() {
		es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter[] array = new es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter[0];
		return (es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter[]) this._ENLOCErrorParameterList
		        .toArray(array);
	}

	/**
	 * Method getENLOCErrorParameterCount.
	 * 
	 * @return the size of this collection
	 */
	public int getENLOCErrorParameterCount() {
		return this._ENLOCErrorParameterList.size();
	}

	/**
	 * Returns the value of field 'translatedDescription'.
	 * 
	 * @return the value of field 'TranslatedDescription'.
	 */
	public java.lang.String getTranslatedDescription() {
		return this._translatedDescription;
	}

	/**
	 * Method hasErrorCode.
	 * 
	 * @return true if at least one ErrorCode has been added
	 */
	public boolean hasErrorCode() {
		return this._has_errorCode;
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
	public void removeAllENLOCErrorParameter() {
		this._ENLOCErrorParameterList.clear();
	}

	/**
	 * Method removeENLOCErrorParameter.
	 * 
	 * @param vENLOCErrorParameter
	 * @return true if the object was removed from the collection.
	 */
	public boolean removeENLOCErrorParameter(
	        final es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter vENLOCErrorParameter) {
		boolean removed = _ENLOCErrorParameterList.remove(vENLOCErrorParameter);
		return removed;
	}

	/**
	 * Method removeENLOCErrorParameterAt.
	 * 
	 * @param index
	 * @return the element removed from the collection
	 */
	public es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter removeENLOCErrorParameterAt(final int index) {
		java.lang.Object obj = this._ENLOCErrorParameterList.remove(index);
		return (es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter) obj;
	}

	/**
	 * Sets the value of field 'defaultDescription'.
	 * 
	 * @param defaultDescription the value of field 'defaultDescription'.
	 */
	public void setDefaultDescription(final java.lang.String defaultDescription) {
		this._defaultDescription = defaultDescription;
	}

	/**
	 * Sets the value of field 'errorCode'.
	 * 
	 * @param errorCode the value of field 'errorCode'.
	 */
	public void setErrorCode(final long errorCode) {
		this._errorCode = errorCode;
		this._has_errorCode = true;
	}

	/**
	 * Sets the value of field 'errorType'.
	 * 
	 * @param errorType the value of field 'errorType'.
	 */
	public void setErrorType(final java.lang.String errorType) {
		this._errorType = errorType;
	}

	/**
	 * 
	 * 
	 * @param index
	 * @param vENLOCErrorParameter
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void setENLOCErrorParameter(final int index,
	        final es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter vENLOCErrorParameter)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._ENLOCErrorParameterList.size()) {
			throw new IndexOutOfBoundsException("setENLOCErrorParameter: Index value '" + index + "' not in range [0.."
			        + (this._ENLOCErrorParameterList.size() - 1) + "]");
		}

		this._ENLOCErrorParameterList.set(index, vENLOCErrorParameter);
	}

	/**
	 * 
	 * 
	 * @param vENLOCErrorParameterArray
	 */
	public void setENLOCErrorParameter(
	        final es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter[] vENLOCErrorParameterArray) {
		// -- copy array
		_ENLOCErrorParameterList.clear();

		for(int i = 0; i < vENLOCErrorParameterArray.length; i++) {
			this._ENLOCErrorParameterList.add(vENLOCErrorParameterArray[i]);
		}
	}

	/**
	 * Sets the value of field 'translatedDescription'.
	 * 
	 * @param translatedDescription the value of field 'translatedDescription'.
	 */
	public void setTranslatedDescription(final java.lang.String translatedDescription) {
		this._translatedDescription = translatedDescription;
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
	 *         es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut
	 */
	public static es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut unmarshal(final java.io.Reader reader)
	        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
		return (es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut) org.exolab.castor.xml.Unmarshaller.unmarshal(
		        es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut.class, reader);
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