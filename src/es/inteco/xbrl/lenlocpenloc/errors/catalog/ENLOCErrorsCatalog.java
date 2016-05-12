/*
 * This class was automatically generated with <a
 * href="http://www.castor.org">Castor 1.2</a>, using an XML Schema. $Id$
 */

package es.inteco.xbrl.lenlocpenloc.errors.catalog;

// ---------------------------------/
// - Imported classes and packages -/
// ---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class ENLOCErrorsCatalog.
 * 
 * @version $Revision$ $Date$
 */
public class ENLOCErrorsCatalog implements java.io.Serializable {

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * Field _ENLOCErrorList.
	 */
	private java.util.Vector _ENLOCErrorList;

	// ----------------/
	// - Constructors -/
	// ----------------/

	public ENLOCErrorsCatalog() {
		super();
		this._ENLOCErrorList = new java.util.Vector();
	}

	// -----------/
	// - Methods -/
	// -----------/

	/**
	 * 
	 * 
	 * @param vENLOCError
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addENLOCError(final es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError vENLOCError)
	        throws java.lang.IndexOutOfBoundsException {
		this._ENLOCErrorList.addElement(vENLOCError);
	}

	/**
	 * 
	 * 
	 * @param index
	 * @param vENLOCError
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void addENLOCError(final int index, final es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError vENLOCError)
	        throws java.lang.IndexOutOfBoundsException {
		this._ENLOCErrorList.add(index, vENLOCError);
	}

	/**
	 * Method enumerateENLOCError.
	 * 
	 * @return an Enumeration over all
	 *         es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError elements
	 */
	public java.util.Enumeration enumerateENLOCError() {
		return this._ENLOCErrorList.elements();
	}

	/**
	 * Method getENLOCError.
	 * 
	 * @param index
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 * @return the value of the
	 *         es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError at the
	 *         given inde
	 */
	public es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError getENLOCError(final int index)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._ENLOCErrorList.size()) {
			throw new IndexOutOfBoundsException("getENLOCError: Index value '" + index + "' not in range [0.."
			        + (this._ENLOCErrorList.size() - 1) + "]");
		}

		return (es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError) _ENLOCErrorList.get(index);
	}

	/**
	 * Method getENLOCError.Returns the contents of the collection in an Array.
	 * <p>
	 * Note: Just in case the collection contents are changing in another
	 * thread, we pass a 0-length Array of the correct type into the API call.
	 * This way we <i>know</i> that the Array returned is of exactly the correct
	 * length.
	 * 
	 * @return this collection as an Array
	 */
	public es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError[] getENLOCError() {
		es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError[] array = new es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError[0];
		return (es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError[]) this._ENLOCErrorList.toArray(array);
	}

	/**
	 * Method getENLOCErrorCount.
	 * 
	 * @return the size of this collection
	 */
	public int getENLOCErrorCount() {
		return this._ENLOCErrorList.size();
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
		Marshaller.marshal(this, out);
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
		Marshaller.marshal(this, handler);
	}

	/**
     */
	public void removeAllENLOCError() {
		this._ENLOCErrorList.clear();
	}

	/**
	 * Method removeENLOCError.
	 * 
	 * @param vENLOCError
	 * @return true if the object was removed from the collection.
	 */
	public boolean removeENLOCError(final es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError vENLOCError) {
		boolean removed = _ENLOCErrorList.remove(vENLOCError);
		return removed;
	}

	/**
	 * Method removeENLOCErrorAt.
	 * 
	 * @param index
	 * @return the element removed from the collection
	 */
	public es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError removeENLOCErrorAt(final int index) {
		java.lang.Object obj = this._ENLOCErrorList.remove(index);
		return (es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError) obj;
	}

	/**
	 * 
	 * 
	 * @param index
	 * @param vENLOCError
	 * @throws java.lang.IndexOutOfBoundsException if the index given is outside
	 *         the bounds of the collection
	 */
	public void setENLOCError(final int index, final es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError vENLOCError)
	        throws java.lang.IndexOutOfBoundsException {
		// check bounds for index
		if(index < 0 || index >= this._ENLOCErrorList.size()) {
			throw new IndexOutOfBoundsException("setENLOCError: Index value '" + index + "' not in range [0.."
			        + (this._ENLOCErrorList.size() - 1) + "]");
		}

		this._ENLOCErrorList.set(index, vENLOCError);
	}

	/**
	 * 
	 * 
	 * @param vENLOCErrorArray
	 */
	public void setENLOCError(final es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError[] vENLOCErrorArray) {
		// -- copy array
		_ENLOCErrorList.clear();

		for(int i = 0; i < vENLOCErrorArray.length; i++) {
			this._ENLOCErrorList.add(vENLOCErrorArray[i]);
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
	 *         es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCErrorsCatalog
	 */
	public static es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCErrorsCatalog unmarshal(final java.io.Reader reader)
	        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
		return (es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCErrorsCatalog) Unmarshaller.unmarshal(
		        es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCErrorsCatalog.class, reader);
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
