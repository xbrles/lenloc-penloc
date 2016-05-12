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

package es.inteco.xbrl.lenlocpenloc.config.format.descriptors;

// ---------------------------------/
// - Imported classes and packages -/
// ---------------------------------/

import es.inteco.xbrl.lenlocpenloc.config.format.Module;

/**
 * 
 * This class was automatically generated with <a
 * href="http://www.castor.org">Castor 1.3rc1</a>, using an XML Schema. $Id:
 * ModuleDescriptor.java,v 1.5 2009/01/29 06:57:50 a130499 Exp $
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

public class ModuleDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {

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

	public ModuleDescriptor() {
		super();
		/* LENLOC : Cambiado */
		_nsURI = "http://www.inteco.es/xbrl/lenlocpenloc2010/interfazES";
		/* LENLOC */
		_xmlName = "module";
		_elementDefinition = true;

		// -- set grouping compositor
		setCompositorAsSequence();
		org.exolab.castor.xml.util.XMLFieldDescriptorImpl desc = null;
		org.exolab.castor.mapping.FieldHandler handler = null;
		org.exolab.castor.xml.FieldValidator fieldValidator = null;
		// -- initialize attribute descriptors

		// -- _id
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.String.class, "_id", "id",
		        org.exolab.castor.xml.NodeType.Attribute);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {

			
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				Module target = (Module) object;
				return target.getId();
			}

			
			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException,
			        IllegalArgumentException {
				try {
					Module target = (Module) object;
					target.setId((java.lang.String) value);
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

		// -- validation code for: _id
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		fieldValidator.setMinOccurs(1);
		{ // -- local scope
			org.exolab.castor.xml.validators.StringValidator typeValidator;
			typeValidator = new org.exolab.castor.xml.validators.StringValidator();
			fieldValidator.setValidator(typeValidator);
			typeValidator.setWhiteSpace("preserve");
		}
		desc.setValidator(fieldValidator);
		// -- _reportingStartDate
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.exolab.castor.types.Date.class,
		        "_reportingStartDate", "reportingStartDate", org.exolab.castor.xml.NodeType.Attribute);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {

			
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				Module target = (Module) object;
				return target.getReportingStartDate();
			}

			
			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException,
			        IllegalArgumentException {
				try {
					Module target = (Module) object;
					target.setReportingStartDate((org.exolab.castor.types.Date.parseDate((java.lang.String) value)));
				} catch(java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			
			@SuppressWarnings ("unused")
			public java.lang.Object newInstance(java.lang.Object parent) {
				return new org.exolab.castor.types.Date();
			}
		};
		desc.setSchemaType("date");
		desc.setHandler(handler);
		desc.setRequired(true);
		desc.setMultivalued(false);
		addFieldDescriptor(desc);

		// -- validation code for: _reportingStartDate
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		fieldValidator.setMinOccurs(1);
		{ // -- local scope
			org.exolab.castor.xml.validators.DateTimeValidator typeValidator;
			typeValidator = new org.exolab.castor.xml.validators.DateTimeValidator();
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);
		// -- _reportingEndDate
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.exolab.castor.types.Date.class,
		        "_reportingEndDate", "reportingEndDate", org.exolab.castor.xml.NodeType.Attribute);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {

			
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				Module target = (Module) object;
				return target.getReportingEndDate();
			}

			
			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException,
			        IllegalArgumentException {
				try {
					Module target = (Module) object;
					target.setReportingEndDate((org.exolab.castor.types.Date.parseDate((java.lang.String) value)));
				} catch(java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			
			@SuppressWarnings ("unused")
			public java.lang.Object newInstance(java.lang.Object parent) {
				return new org.exolab.castor.types.Date();
			}
		};
		desc.setSchemaType("date");
		desc.setHandler(handler);
		desc.setRequired(true);
		desc.setMultivalued(false);
		addFieldDescriptor(desc);

		// -- validation code for: _reportingEndDate
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		fieldValidator.setMinOccurs(1);
		{ // -- local scope
			org.exolab.castor.xml.validators.DateTimeValidator typeValidator;
			typeValidator = new org.exolab.castor.xml.validators.DateTimeValidator();
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);
		// -- _baseUnit
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
		        es.inteco.xbrl.lenlocpenloc.config.format.types.Unittype.class, "_baseUnit", "baseUnit",
		        org.exolab.castor.xml.NodeType.Attribute);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {

			
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				Module target = (Module) object;
				return target.getBaseUnit();
			}

			
			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException,
			        IllegalArgumentException {
				try {
					Module target = (Module) object;
					target.setBaseUnit((es.inteco.xbrl.lenlocpenloc.config.format.types.Unittype) value);
				} catch(java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			
			@SuppressWarnings ("unused")
			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		handler = new org.exolab.castor.xml.handlers.EnumFieldHandler(
		        es.inteco.xbrl.lenlocpenloc.config.format.types.Unittype.class, handler);
		desc.setImmutable(true);
		desc.setSchemaType("Unittype");
		desc.setHandler(handler);
		desc.setMultivalued(false);
		addFieldDescriptor(desc);

		// -- validation code for: _baseUnit
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
		}
		desc.setValidator(fieldValidator);
		// -- _baseDecimals
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.String.class, "_baseDecimals",
		        "baseDecimals", org.exolab.castor.xml.NodeType.Attribute);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {

			
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				Module target = (Module) object;
				return target.getBaseDecimals();
			}

			
			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException,
			        IllegalArgumentException {
				try {
					Module target = (Module) object;
					target.setBaseDecimals((java.lang.String) value);
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

		// -- validation code for: _baseDecimals
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			org.exolab.castor.xml.validators.StringValidator typeValidator;
			typeValidator = new org.exolab.castor.xml.validators.StringValidator();
			fieldValidator.setValidator(typeValidator);
			typeValidator.setWhiteSpace("preserve");
		}
		desc.setValidator(fieldValidator);
		// -- initialize element descriptors

		// -- _itemList
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
		        es.inteco.xbrl.lenlocpenloc.config.format.Item.class, "_itemList", "item",
		        org.exolab.castor.xml.NodeType.Element);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {

			
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				Module target = (Module) object;
				return target.getItem();
			}

			
			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException,
			        IllegalArgumentException {
				try {
					Module target = (Module) object;
					target.addItem((es.inteco.xbrl.lenlocpenloc.config.format.Item) value);
				} catch(java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
				try {
					Module target = (Module) object;
					target.removeAllItem();
				} catch(java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			
			@SuppressWarnings ("unused")
			public java.lang.Object newInstance(java.lang.Object parent) {
				return new es.inteco.xbrl.lenlocpenloc.config.format.Item();
			}
		};
		desc.setSchemaType("list");
		desc.setComponentType(es.inteco.xbrl.lenlocpenloc.config.format.Item.class.getName());
		desc.setHandler(handler);
		/* LENLOC : Cambiado */
		desc.setNameSpaceURI("http://www.inteco.es/xbrl/lenlocpenloc2010/interfazES");
		/* LENLOC */
		desc.setMultivalued(true);
		addFieldDescriptor(desc);
		addSequenceElement(desc);

		// -- validation code for: _itemList
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		fieldValidator.setMinOccurs(0);
		{ // -- local scope
		}
		desc.setValidator(fieldValidator);
		/* LENLOC : Cambiado */
		desc.setNameSpaceURI("http://www.inteco.es/xbrl/lenlocpenloc2010/interfazES");
		/* LENLOC */
		desc.setMultivalued(true);
		addFieldDescriptor(desc);
		addSequenceElement(desc);

		// -- validation code for: _recordList
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		fieldValidator.setMinOccurs(0);
		{ // -- local scope
		}
		desc.setValidator(fieldValidator);
		// -- _tableList
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
		        es.inteco.xbrl.lenlocpenloc.config.format.Table.class, "_tableList", "table",
		        org.exolab.castor.xml.NodeType.Element);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {

			
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				Module target = (Module) object;
				return target.getTable();
			}

			
			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException,
			        IllegalArgumentException {
				try {
					Module target = (Module) object;
					target.addTable((es.inteco.xbrl.lenlocpenloc.config.format.Table) value);
				} catch(java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
				try {
					Module target = (Module) object;
					target.removeAllTable();
				} catch(java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			
			@SuppressWarnings ("unused")
			public java.lang.Object newInstance(java.lang.Object parent) {
				return new es.inteco.xbrl.lenlocpenloc.config.format.Table();
			}
		};
		desc.setSchemaType("list");
		desc.setComponentType(es.inteco.xbrl.lenlocpenloc.config.format.Table.class.getName());
		desc.setHandler(handler);
		/* LENLOC : Cambiado */
		desc.setNameSpaceURI("http://www.inteco.es/xbrl/lenlocpenloc2010/interfazES");
		/* LENLOC */
		desc.setMultivalued(true);
		addFieldDescriptor(desc);
		addSequenceElement(desc);

		// -- validation code for: _tableList
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
		return es.inteco.xbrl.lenlocpenloc.config.format.Module.class;
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