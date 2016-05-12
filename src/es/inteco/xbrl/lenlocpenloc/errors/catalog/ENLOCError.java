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
 * Class ENLOCError.
 * 
 * @version 1.0, 24/06/2009
 */
public class ENLOCError implements java.io.Serializable {

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
	 * Field _type.
	 */
	private es.inteco.xbrl.lenlocpenloc.errors.catalog.types.ENLOCErrorTypeType _type;

	/**
	 * Field _id.
	 */
	private java.lang.String _id;

	/**
	 * Field _lang.
	 */
	private java.lang.String _lang;

	/**
	 * Field _parameterList.
	 */
	private java.lang.String _parameterList;

	/**
	 * internal content storage
	 */
	private java.lang.String _content = "";

	// ----------------/
	// - Constructors -/
	// ----------------/

	public ENLOCError() {
		super();
		setContent("");
	}

	// -----------/
	// - Methods -/
	// -----------/

	/**
	 * Delete a error Code
     */
	public void deleteErrorCode() {
		this._has_errorCode = false;
	}

	/**
	 * Returns the value of field 'content'. The field 'content' has the
	 * following description: internal content storage
	 * 
	 * @return the value of field 'Content'.
	 */
	public java.lang.String getContent() {
		return this._content;
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
	 * Returns the value of field 'id'.
	 * 
	 * @return the value of field 'Id'.
	 */
	public java.lang.String getId() {
		return this._id;
	}

	/**
	 * Returns the value of field 'lang'. The field 'lang' has the following
	 * description: Attempting to install the relevant ISO 2- and 3-letter codes
	 * as the enumerated possible values is probably never going to be a
	 * realistic possibility. See RFC 3066 at
	 * http://www.ietf.org/rfc/rfc3066.txt and the IANA registry at
	 * http://www.iana.org/assignments/lang-tag-apps.htm for further
	 * information.
	 * 
	 * @return the value of field 'Lang'.
	 */
	public java.lang.String getLang() {
		return this._lang;
	}

	/**
	 * Returns the value of field 'parameterList'.
	 * 
	 * @return the value of field 'ParameterList'.
	 */
	public java.lang.String getParameterList() {
		return this._parameterList;
	}

	/**
	 * Returns the value of field 'type'.
	 * 
	 * @return the value of field 'Type'.
	 */
	public es.inteco.xbrl.lenlocpenloc.errors.catalog.types.ENLOCErrorTypeType getType() {
		return this._type;
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
	 * @param out is the out
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
	 * @param handler is the handler
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
	 * Sets the value of field 'content'. The field 'content' has the following
	 * description: internal content storage
	 * 
	 * @param content the value of field 'content'.
	 */
	public void setContent(final java.lang.String content) {
		this._content = content;
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
	 * Sets the value of field 'id'.
	 * 
	 * @param id the value of field 'id'.
	 */
	public void setId(final java.lang.String id) {
		this._id = id;
	}

	/**
	 * Sets the value of field 'lang'. The field 'lang' has the following
	 * description: Attempting to install the relevant ISO 2- and 3-letter codes
	 * as the enumerated possible values is probably never going to be a
	 * realistic possibility. See RFC 3066 at
	 * http://www.ietf.org/rfc/rfc3066.txt and the IANA registry at
	 * http://www.iana.org/assignments/lang-tag-apps.htm for further
	 * information.
	 * 
	 * @param lang the value of field 'lang'.
	 */
	public void setLang(final java.lang.String lang) {
		this._lang = lang;
	}

	/**
	 * Sets the value of field 'parameterList'.
	 * 
	 * @param parameterList the value of field 'parameterList'.
	 */
	public void setParameterList(final java.lang.String parameterList) {
		this._parameterList = parameterList;
	}

	/**
	 * Sets the value of field 'type'.
	 * 
	 * @param type the value of field 'type'.
	 */
	public void setType(final es.inteco.xbrl.lenlocpenloc.errors.catalog.types.ENLOCErrorTypeType type) {
		this._type = type;
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
	 *         es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError
	 */
	public static es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError unmarshal(final java.io.Reader reader)
	        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
		return (es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError) Unmarshaller.unmarshal(
		        es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError.class, reader);
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
