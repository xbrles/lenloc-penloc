/*
 * This class was automatically generated with <a
 * href="http://www.castor.org">Castor 1.2</a>, using an XML Schema. $Id$
 */

package es.inteco.xbrl.lenlocpenloc.errors.catalog.descriptors;

// ---------------------------------/
// - Imported classes and packages -/
// ---------------------------------/

import es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCErrorsCatalog;

/**
 * Class ENLOCErrorsCatalogDescriptor.
 * 
 * @version $Revision$ $Date$
 */
public class ENLOCErrorsCatalogDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * Field _elementDefinition.
	 */
	private boolean _elementDefinition;

	/**
	 * Field _nsPrefix.
	 */
	private java.lang.String _nsPrefix;

	/**
	 * Field _nsURI.
	 */
	private java.lang.String _nsURI;

	/**
	 * Field _xmlName.
	 */
	private java.lang.String _xmlName;

	/**
	 * Field _identity.
	 */
	private org.exolab.castor.xml.XMLFieldDescriptor _identity;

	// ----------------/
	// - Constructors -/
	// ----------------/

	public ENLOCErrorsCatalogDescriptor() {
		super();
		_nsURI = "http://www.inteco.es/xbrl/lenlocpenloc2010/errors/catalog";
		_xmlName = "ENLOCErrorsCatalog";
		_elementDefinition = true;

		// -- set grouping compositor
		setCompositorAsSequence();
		org.exolab.castor.xml.util.XMLFieldDescriptorImpl desc = null;
		org.exolab.castor.mapping.FieldHandler handler = null;
		org.exolab.castor.xml.FieldValidator fieldValidator = null;
		// -- initialize attribute descriptors

		// -- initialize element descriptors

		// -- _ENLOCErrorList
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
		        es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError.class, "_ENLOCErrorList", "ENLOCError",
		        org.exolab.castor.xml.NodeType.Element);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {

			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				ENLOCErrorsCatalog target = (ENLOCErrorsCatalog) object;
				return target.getENLOCError();
			}

			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException,
			        IllegalArgumentException {
				try {
					ENLOCErrorsCatalog target = (ENLOCErrorsCatalog) object;
					target.addENLOCError((es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError) value);
				} catch(java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
				try {
					ENLOCErrorsCatalog target = (ENLOCErrorsCatalog) object;
					target.removeAllENLOCError();
				} catch(java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return new es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError();
			}
		};
		desc.setSchemaType("list");
		desc.setComponentType("es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError");
		desc.setHandler(handler);
		desc.setNameSpaceURI("http://www.inteco.es/xbrl/lenlocpenloc2010/errors/catalog");
		desc.setRequired(true);
		desc.setMultivalued(true);
		addFieldDescriptor(desc);
		addSequenceElement(desc);

		// -- validation code for: _ENLOCErrorList
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		fieldValidator.setMinOccurs(1);
		{ // -- local scope
		}
		desc.setValidator(fieldValidator);
	}

	// -----------/
	// - Methods -/
	// -----------/

	/**
	 * Method getAccessMode.
	 * 
	 * @return the access mode specified for this class.
	 */
	public org.exolab.castor.mapping.AccessMode getAccessMode() {
		return null;
	}

	/**
	 * Method getIdentity.
	 * 
	 * @return the identity field, null if this class has no identity.
	 */
	public org.exolab.castor.mapping.FieldDescriptor getIdentity() {
		return _identity;
	}

	/**
	 * Method getJavaClass.
	 * 
	 * @return the Java class represented by this descriptor.
	 */
	public java.lang.Class getJavaClass() {
		return es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCErrorsCatalog.class;
	}

	/**
	 * Method getNameSpacePrefix.
	 * 
	 * @return the namespace prefix to use when marshaling as XML.
	 */
	public java.lang.String getNameSpacePrefix() {
		return _nsPrefix;
	}

	/**
	 * Method getNameSpaceURI.
	 * 
	 * @return the namespace URI used when marshaling and unmarshaling as XML.
	 */
	public java.lang.String getNameSpaceURI() {
		return _nsURI;
	}

	/**
	 * Method getValidator.
	 * 
	 * @return a specific validator for the class described by this
	 *         ClassDescriptor.
	 */
	public org.exolab.castor.xml.TypeValidator getValidator() {
		return this;
	}

	/**
	 * Method getXMLName.
	 * 
	 * @return the XML Name for the Class being described.
	 */
	public java.lang.String getXMLName() {
		return _xmlName;
	}

	/**
	 * Method isElementDefinition.
	 * 
	 * @return true if XML schema definition of this Class is that of a global
	 *         element or element with anonymous type definition.
	 */
	public boolean isElementDefinition() {
		return _elementDefinition;
	}

}
