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

package es.inteco.xbrl.lenlocpenloc.config.maps.descriptors;

// ---------------------------------/
// - Imported classes and packages -/
// ---------------------------------/

import es.inteco.xbrl.lenlocpenloc.config.maps.ConceptMap;

/**
 * 
 * This class was automatically generated with <a
 * href="http://www.castor.org">Castor 1.3rc1</a>, using an XML Schema. $Id:
 * ConceptMapDescriptor.java,v 1.5 2009/01/19 12:17:08 a130499 Exp $
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

public class ConceptMapDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {

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

	public ConceptMapDescriptor() {
		super();
		/* LENLOC : Cambio map */
		_nsURI = "http://www.inteco.es/xbrl/lenlocpenloc2010/map";
		/* LENLOC */
		_xmlName = "conceptMap";
		_elementDefinition = true;

		// -- set grouping compositor
		setCompositorAsSequence();
		org.exolab.castor.xml.util.XMLFieldDescriptorImpl desc = null;
		org.exolab.castor.mapping.FieldHandler handler = null;
		org.exolab.castor.xml.FieldValidator fieldValidator = null;
		// -- initialize attribute descriptors

		// -- _outputID
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.String.class, "_outputID", "outputID",
		        org.exolab.castor.xml.NodeType.Attribute);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {

			
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				ConceptMap target = (ConceptMap) object;
				return target.getOutputID();
			}

			
			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException,
			        IllegalArgumentException {
				try {
					ConceptMap target = (ConceptMap) object;
					target.setOutputID((java.lang.String) value);
				} catch(java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			
			@SuppressWarnings ("unused")
			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setSchemaType("string");
		desc.setHandler(handler);
		desc.setMultivalued(false);
		addFieldDescriptor(desc);

		// -- validation code for: _outputID
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			org.exolab.castor.xml.validators.StringValidator typeValidator;
			typeValidator = new org.exolab.castor.xml.validators.StringValidator();
			fieldValidator.setValidator(typeValidator);
			typeValidator.setWhiteSpace("preserve");
		}
		desc.setValidator(fieldValidator);
		// -- _inputID
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.String.class, "_inputID", "inputID",
		        org.exolab.castor.xml.NodeType.Attribute);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {

			
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				ConceptMap target = (ConceptMap) object;
				return target.getInputID();
			}

			
			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException,
			        IllegalArgumentException {
				try {
					ConceptMap target = (ConceptMap) object;
					target.setInputID((java.lang.String) value);
				} catch(java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			
			@SuppressWarnings ("unused")
			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setSchemaType("string");
		desc.setHandler(handler);
		desc.setRequired(true);
		desc.setMultivalued(false);
		addFieldDescriptor(desc);

		// -- validation code for: _inputID
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		fieldValidator.setMinOccurs(1);
		{ // -- local scope
			org.exolab.castor.xml.validators.StringValidator typeValidator;
			typeValidator = new org.exolab.castor.xml.validators.StringValidator();
			fieldValidator.setValidator(typeValidator);
			typeValidator.setWhiteSpace("preserve");
		}
		desc.setValidator(fieldValidator);
		// -- _ns
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.String.class, "_ns", "ns",
		        org.exolab.castor.xml.NodeType.Attribute);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {

			
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				ConceptMap target = (ConceptMap) object;
				return target.getNs();
			}

			
			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException,
			        IllegalArgumentException {
				try {
					ConceptMap target = (ConceptMap) object;
					target.setNs((java.lang.String) value);
				} catch(java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			
			@SuppressWarnings ("unused")
			public java.lang.Object newInstance(java.lang.Object parent) {
				return new java.lang.String();
			}
		};
		desc.setSchemaType("anyURI");
		desc.setHandler(handler);
		desc.setRequired(true);
		desc.setMultivalued(false);
		addFieldDescriptor(desc);

		// -- validation code for: _ns
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		fieldValidator.setMinOccurs(1);
		{ // -- local scope
		}
		desc.setValidator(fieldValidator);
		// -- _nsPrefix
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.String.class, "_nsPrefix", "nsPrefix",
		        org.exolab.castor.xml.NodeType.Attribute);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {

			
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				ConceptMap target = (ConceptMap) object;
				return target.getNsPrefix();
			}

			
			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException,
			        IllegalArgumentException {
				try {
					ConceptMap target = (ConceptMap) object;
					target.setNsPrefix((java.lang.String) value);
				} catch(java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			
			@SuppressWarnings ("unused")
			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setSchemaType("string");
		desc.setHandler(handler);
		desc.setRequired(true);
		desc.setMultivalued(false);
		addFieldDescriptor(desc);

		// -- validation code for: _nsPrefix
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		fieldValidator.setMinOccurs(1);
		{ // -- local scope
			org.exolab.castor.xml.validators.StringValidator typeValidator;
			typeValidator = new org.exolab.castor.xml.validators.StringValidator();
			fieldValidator.setValidator(typeValidator);
			typeValidator.setWhiteSpace("preserve");
		}
		desc.setValidator(fieldValidator);
		// -- _domain
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.String.class, "_domain", "domain",
		        org.exolab.castor.xml.NodeType.Attribute);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {

			
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				ConceptMap target = (ConceptMap) object;
				return target.getDomain();
			}

			
			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException,
			        IllegalArgumentException {
				try {
					ConceptMap target = (ConceptMap) object;
					target.setDomain((java.lang.String) value);
				} catch(java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			
			@SuppressWarnings ("unused")
			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setSchemaType("string");
		desc.setHandler(handler);
		desc.setMultivalued(false);
		addFieldDescriptor(desc);

		// -- validation code for: _domain
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			org.exolab.castor.xml.validators.StringValidator typeValidator;
			typeValidator = new org.exolab.castor.xml.validators.StringValidator();
			fieldValidator.setValidator(typeValidator);
			typeValidator.setWhiteSpace("preserve");
		}
		desc.setValidator(fieldValidator);
		/* LENLOC */
		// -- _containerDimensionType
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.String.class, "_containerDimensionType",
		        "containerDimensionType", org.exolab.castor.xml.NodeType.Attribute);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {

			
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				ConceptMap target = (ConceptMap) object;
				return target.getContainerDimensionType();
			}

			
			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException,
			        IllegalArgumentException {
				try {
					ConceptMap target = (ConceptMap) object;
					target.setContainerDimensionType((java.lang.String) value);
				} catch(java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			
			@SuppressWarnings ("unused")
			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setSchemaType("string");
		desc.setHandler(handler);
		desc.setMultivalued(false);
		addFieldDescriptor(desc);

		// -- validation code for: _containerDimensionType
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			org.exolab.castor.xml.validators.StringValidator typeValidator;
			typeValidator = new org.exolab.castor.xml.validators.StringValidator();
			fieldValidator.setValidator(typeValidator);
			typeValidator.setWhiteSpace("preserve");
		}
		desc.setValidator(fieldValidator);
		/* LENLOC */
		/* LENLOC */
		// -- _isTypeDimension
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.Boolean.class, "_isTypedDimension",
		        "isTypedDimension", org.exolab.castor.xml.NodeType.Attribute);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {

			
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				ConceptMap target = (ConceptMap) object;
				return target.isTypedDimension();
			}

			
			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException,
			        IllegalArgumentException {
				try {
					ConceptMap target = (ConceptMap) object;
					target.setTypedDimension((java.lang.Boolean) value);
				} catch(java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			
			@SuppressWarnings ("unused")
			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setSchemaType("boolean");
		desc.setHandler(handler);
		desc.setMultivalued(false);
		addFieldDescriptor(desc);

		// -- validation code for: _containerDimensionType
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			org.exolab.castor.xml.validators.BooleanValidator typeValidator;
			typeValidator = new org.exolab.castor.xml.validators.BooleanValidator();
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);
		/* LENLOC */
		// -- _parent
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.String.class, "_parent", "parent",
		        org.exolab.castor.xml.NodeType.Attribute);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {

			
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				ConceptMap target = (ConceptMap) object;
				return target.getParent();
			}

			
			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException,
			        IllegalArgumentException {
				try {
					ConceptMap target = (ConceptMap) object;
					target.setParent((java.lang.String) value);
				} catch(java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			
			@SuppressWarnings ("unused")
			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setSchemaType("string");
		desc.setHandler(handler);
		desc.setMultivalued(false);
		addFieldDescriptor(desc);

		// -- validation code for: _parent
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			org.exolab.castor.xml.validators.StringValidator typeValidator;
			typeValidator = new org.exolab.castor.xml.validators.StringValidator();
			fieldValidator.setValidator(typeValidator);
			typeValidator.setWhiteSpace("preserve");
		}
		desc.setValidator(fieldValidator);
		// -- _order
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.math.BigDecimal.class, "_order", "order",
		        org.exolab.castor.xml.NodeType.Attribute);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {

			
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				ConceptMap target = (ConceptMap) object;
				return target.getOrder();
			}

			
			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException,
			        IllegalArgumentException {
				try {
					ConceptMap target = (ConceptMap) object;
					target.setOrder((java.math.BigDecimal) value);
				} catch(java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			
			@SuppressWarnings ("unused")
			public java.lang.Object newInstance(java.lang.Object parent) {
				return new java.math.BigDecimal(0);
			}
		};
		desc.setImmutable(true);
		desc.setSchemaType("decimal");
		desc.setHandler(handler);
		desc.setMultivalued(false);
		addFieldDescriptor(desc);

		// -- validation code for: _order
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			org.exolab.castor.xml.validators.DecimalValidator typeValidator;
			typeValidator = new org.exolab.castor.xml.validators.DecimalValidator();
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);
		// -- initialize element descriptors

		// -- _memberList
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
		        es.inteco.xbrl.lenlocpenloc.config.maps.Member.class, "_memberList", "member",
		        org.exolab.castor.xml.NodeType.Element);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {

			
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				ConceptMap target = (ConceptMap) object;
				return target.getMember();
			}

			
			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException,
			        IllegalArgumentException {
				try {
					ConceptMap target = (ConceptMap) object;
					target.addMember((es.inteco.xbrl.lenlocpenloc.config.maps.Member) value);
				} catch(java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
				try {
					ConceptMap target = (ConceptMap) object;
					target.removeAllMember();
				} catch(java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			
			@SuppressWarnings ("unused")
			public java.lang.Object newInstance(java.lang.Object parent) {
				return new es.inteco.xbrl.lenlocpenloc.config.maps.Member();
			}
		};
		desc.setSchemaType("list");
		desc.setComponentType(es.inteco.xbrl.lenlocpenloc.config.maps.Member.class.getName());
		desc.setHandler(handler);
		/* LENLOC : Cambio map */
		desc.setNameSpaceURI("http://www.inteco.es/xbrl/lenlocpenloc2010/map");
		/* LENLOC */
		desc.setMultivalued(true);
		addFieldDescriptor(desc);
		addSequenceElement(desc);

		// -- validation code for: _memberList
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		fieldValidator.setMinOccurs(0);
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
		return es.inteco.xbrl.lenlocpenloc.config.maps.ConceptMap.class;
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