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

package es.inteco.xbrl.lenlocpenloc.apifacade.xbreeze;

import java.util.Iterator;

import es.inteco.xbrl.lenlocpenloc.utils.ENLOCUtils;

import ubmatrix.xbrl.common.src.IDTS;
import ubmatrix.xbrl.common.src.IDTSNode;
import ubmatrix.xbrl.common.src.IDTSResultSet;
import ubmatrix.xbrl.common.src.IDomainObjectFactory;
import ubmatrix.xbrl.common.src.IIndexable;
import ubmatrix.xbrl.common.src.IRelationship;
import ubmatrix.xbrl.common.src.IXbrlDomain;
import ubmatrix.xbrl.common.utility.src.CommonUtilities;
import ubmatrix.xbrl.common.utility.src.Utility;
import ubmatrix.xbrl.domain.xbrl21Domain.behavior.src.LinkBehavior;
import ubmatrix.xbrl.domain.xbrl21Domain.dts.src.DTSPath;
import ubmatrix.xbrl.domain.xbrl21Domain.src.XbrlDomainUri;
import ubmatrix.xbrl.vofactory.src.VOFactoryImpl;

/**
 * 
 * 
 * Esta clase contiene las funcionaliades necesarias para gestionar la creación
 * de elementos de tipo link.
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

public class ENLOCLinkBehaviour extends LinkBehavior {

	private static String c_xlink = "http://www.w3.org/1999/xlink";

	/**
	 * Constructor por defecto
	 */
	public ENLOCLinkBehaviour() {
		super();
	}

	/**
	 * Crea un objeto locator en un link.
	 * 
	 * @param linkDO Objeto dominio del link
	 * 
	 * @param linkDts link dts
	 * 
	 * @param conceptDO Concepto al que se hace referencia en el locator que se
	 *        pretende crear.
	 * 
	 * @return Objeto del tipo IXbrlDomain
	 * 
	 */

	public static IXbrlDomain createLocator(IXbrlDomain linkDO, IDTS linkDts, IXbrlDomain conceptDO) throws Exception {
		// Verifica si el loc ya existe en el DTS
		String conceptDOPrefix = conceptDO.getPrefixForNamespace(conceptDO.getNamespaceUri());
		String conceptDOLabel = (conceptDOPrefix != null && conceptDOPrefix.length() > 0) ? conceptDOPrefix + "_"
		        + conceptDO.getLocalName() : conceptDO.getLocalName();

		String locQuery = CommonUtilities.formatString("/+'{0}'/'{1}'[attr('{2}#label')=='{3}']", new Object[] {
		        XbrlDomainUri.c_LinkContainsLocator, XbrlDomainUri.c_Locator, c_xlink, conceptDOLabel });

		DTSPath locPath = new DTSPath(locQuery);

		IDTSResultSet existingLoc = linkDts.find(linkDO, locPath);
		if(existingLoc.getCount() > 0) {
			Iterator existingLocEnum = existingLoc.getEnumerator();
			Utility.resetIterator(existingLocEnum);
			return (IXbrlDomain) existingLocEnum.next();
		}

		IDTSNode workingDODtsNode = linkDO.getDTSNode();
		String query = "/'&http://www.xbrl.org/2003/linkbase#loc'";
		IDomainObjectFactory doFactory = workingDODtsNode.getLocationHandle().getLocationControl()
		        .getDomainObjectFactory();
		IXbrlDomain schemaDO = (IXbrlDomain) linkDts.findSingle(query);
		if(schemaDO != null) {
			IDTSNode schemaDODtsNode = schemaDO.getDTSNode();
			if(schemaDODtsNode != null && schemaDODtsNode.getLocationHandle() != null) {
				String newVOUri = schemaDO.getFullName();
				Object vo = VOFactoryImpl.getInstance().createObject(schemaDODtsNode.getGrammar(linkDts),
				        schemaDODtsNode.getGrammar(linkDts), linkDO, newVOUri, null,
				        workingDODtsNode.getLocationHandle(), schemaDODtsNode.getLocationHandle());

				IXbrlDomain newDO = doFactory.createDomainObject(XbrlDomainUri.c_Locator, vo);

				try {
					// The lock should be taken care by the application
					newDO.setDTSNode(workingDODtsNode);
					workingDODtsNode.add(linkDts, newDO);
					workingDODtsNode.getLocationHandle().mapVOToDO(vo, newDO);
					linkDts.mapVOToDO(vo, newDO);
				} catch(Exception ex) {
					throw ex;
				}

				newDO.setAttributeValue(c_xlink, "type", "locator");

				String conceptID = conceptDO.getAttributeValue(null, "id");

				String generateID = ENLOCUtils.getCodeFromFootNoteID(conceptID);

				String id = conceptDO.getLocalName() + "_" + generateID;

				newDO.setAttributeValue(c_xlink, "type", "locator");
				newDO.setAttributeValue(c_xlink, "href", "#" + conceptID);

				newDO.setAttributeValue(c_xlink, "label", id);
				IRelationship domainObject = doFactory.createRelationship(XbrlDomainUri.c_LinkContainsLocator, null,
				        (IIndexable) linkDO, (IIndexable) newDO);

				try {
					// The lock should be taken care by the application
					domainObject.setDTSNode(workingDODtsNode);
					workingDODtsNode.add(linkDts, domainObject);
				} catch(Exception ex) {
					throw ex;
				}

				domainObject = doFactory.createRelationship(XbrlDomainUri.c_LocatorLocatesDomainObject, null,
				        (IIndexable) newDO, (IIndexable) conceptDO);
				try {

					domainObject.setDTSNode(workingDODtsNode);
					workingDODtsNode.add(linkDts, domainObject);
				} catch(Exception ex) {
					throw ex;
				}

				return newDO;
			}
		}
		return null;
	}

	/**
	 * Crea un label resource sobre un link
	 * 
	 * @param linkDO link domain object
	 * 
	 * @param linkDts dts al que pertenece el link
	 * 
	 * @param conceptDO concepto asociado al resource
	 * 
	 * @param role rol del recurso, por ejemplo, label, o documentación
	 * 
	 * @param language idioma del resource, por ejemplo: xml:lang="en"
	 * 
	 * @param text el label del texto
	 * 
	 * @return Objeto del tipo IXbrlDomain
	 * 
	 */

	public static IXbrlDomain createResource(IXbrlDomain linkDO, IDTS linkDts, IXbrlDomain conceptDO, IXbrlDomain role,
	        String language, String text) throws Exception {
		String query;
		if(linkDO.getLocalName().equals("labelLink")) {
			query = "/'&http://www.xbrl.org/2003/linkbase#label'";
		} else if(linkDO.getLocalName().equals("footnoteLink")) {
			query = "/'&http://www.xbrl.org/2003/linkbase#footnote'";
		} else if(linkDO.getLocalName().equals("referenceLink")) {
			query = "/'&http://www.xbrl.org/2003/linkbase#reference'";
		} else {
			return null;
		}

		IDTSNode workingDODtsNode = linkDO.getDTSNode();
		IDomainObjectFactory doFactory = workingDODtsNode.getLocationHandle().getLocationControl()
		        .getDomainObjectFactory();
		IXbrlDomain schemaDO = (IXbrlDomain) linkDts.findSingle(query);
		if(schemaDO != null) {
			IDTSNode schemaDODtsNode = schemaDO.getDTSNode();
			if(schemaDODtsNode != null && schemaDODtsNode.getLocationHandle() != null) {
				String newVOUri = schemaDO.getFullName();
				Object vo = VOFactoryImpl.getInstance().createObject(schemaDODtsNode.getGrammar(linkDts),
				        schemaDODtsNode.getGrammar(linkDts), linkDO, newVOUri, null,
				        workingDODtsNode.getLocationHandle(), schemaDODtsNode.getLocationHandle());

				IXbrlDomain newDO = doFactory.createDomainObject(XbrlDomainUri.c_Resource, vo);

				try {
					newDO.setDTSNode(workingDODtsNode);
					workingDODtsNode.add(linkDts, newDO);
					workingDODtsNode.getLocationHandle().mapVOToDO(vo, newDO);
					linkDts.mapVOToDO(vo, newDO);
				} catch(Exception ex) {
					throw ex;
				}
				newDO.setAttributeValue(c_xlink, "type", "resource");
				newDO.setAttributeValue(c_xlink, "role", role.getValue());

				String id = ENLOCUtils.generateFootNoteLabelID();

				newDO.setAttributeValue(c_xlink, "label", id);
				if(language != null) {
					newDO.setAttributeValue(null, "xml:lang", language);
				}
				if(text != null) {
					newDO.setValue(text);
				}
				IRelationship domainObject = doFactory.createRelationship(XbrlDomainUri.c_LinkSpecifiesResource, null,
				        (IIndexable) linkDO, (IIndexable) newDO);
				try {
					domainObject.setDTSNode(workingDODtsNode);
					workingDODtsNode.add(linkDts, domainObject);
				} catch(Exception ex) {
					throw ex;
				}

				domainObject = doFactory.createRelationship(XbrlDomainUri.c_RoleClassifies, null, (IIndexable) role,
				        (IIndexable) newDO);
				try {
					domainObject.setDTSNode(workingDODtsNode);
					workingDODtsNode.add(linkDts, domainObject);
				} catch(Exception ex) {
					throw ex;
				}

				return newDO;
			}
		}
		return null;
	}

	/**
	 * Crea un arc para un link
	 * 
	 * @param linkDO objeto del dominio para el link
	 * 
	 * @param linkDts link dts
	 * 
	 * @param conceptDO el nodo final del arco
	 * 
	 * @param arcRole el rol del arco
	 * 
	 * @param role el rol del resoruce, por ejemplo, label, o documentación
	 * 
	 * @param language the langugage of the resource, eg: xml:lang="en"
	 * 
	 * @param text el label del texto
	 * 
	 * @param title título del arco
	 * 
	 * @return Objeto del tipo IXbrlDomain
	 * 
	 */

	public static IXbrlDomain createArcWithSingleConceptAsEnd(IXbrlDomain linkDO, IDTS linkDts, IXbrlDomain conceptDO,
	        IXbrlDomain arcRole, IXbrlDomain role, String language, String text, String title, String order)
	        throws Exception {
		String query;
		String suffix;
		IXbrlDomain resourceDO = null;
		if(linkDO.getLocalName().equals("labelLink")) {
			query = "/'&" + XbrlDomainUri.c_LabelArc + "'";
			suffix = "lbl";
			resourceDO = createResource(linkDO, linkDts, conceptDO, role, language, text);
		} else if(linkDO.getLocalName().equals("referenceLink")) {
			query = "/'&" + XbrlDomainUri.c_ReferenceArc + "'";
			suffix = "ref";
			resourceDO = createResource(linkDO, linkDts, conceptDO, role, null, null);
		} else if(linkDO.getLocalName().equals("footnoteLink")) {
			query = "/'&" + XbrlDomainUri.c_FootnoteArc + "'";
			suffix = "footnote";
			resourceDO = createResource(linkDO, linkDts, conceptDO, role, language, text);
		} else {
			return null;
		}
		IDTSNode workingDODtsNode = linkDO.getDTSNode();
		IDomainObjectFactory doFactory = workingDODtsNode.getLocationHandle().getLocationControl()
		        .getDomainObjectFactory();
		IXbrlDomain schemaDO = (IXbrlDomain) linkDts.findSingle(query);
		if(schemaDO != null) {
			IDTSNode schemaDODtsNode = schemaDO.getDTSNode();
			if(schemaDODtsNode != null && schemaDODtsNode.getLocationHandle() != null) {
				IXbrlDomain locatorDO = createLocator(linkDO, linkDts, conceptDO);
				String newVOUri = schemaDO.getFullName();
				Object vo = VOFactoryImpl.getInstance().createObject(schemaDODtsNode.getGrammar(linkDts),
				        schemaDODtsNode.getGrammar(linkDts), linkDO, newVOUri, null,
				        workingDODtsNode.getLocationHandle(), schemaDODtsNode.getLocationHandle());

				IRelationship arc = doFactory.createRelationship(XbrlDomainUri.c_Arc, vo, (IIndexable) conceptDO,
				        (IIndexable) resourceDO);

				try {
					// The lock should be taken care by the application
					arc.setDTSNode(workingDODtsNode);
					workingDODtsNode.add(linkDts, arc);
					workingDODtsNode.getLocationHandle().mapVOToDO(vo, arc);
					linkDts.mapVOToDO(vo, arc);
				} catch(Exception ex) {
					throw ex;
				}

				arc.setAttributeValue(c_xlink, "type", "arc");
				arc.setAttributeValue(c_xlink, "arcrole", arcRole.getValue());

				if(title != null && !title.equals("null"))
					arc.setAttributeValue(c_xlink, "title", title);

				// Set "from" with locator's label attribute
				String id = locatorDO.getAttributeValue(c_xlink, "label");
				arc.setAttributeValue(c_xlink, "from", id);

				// Set "to" with footnote(resource)'s label attribute
				id = resourceDO.getAttributeValue(c_xlink, "label");

				arc.setAttributeValue(c_xlink, "to", id);
				arc.setAttributeValue("", "order", order);

				IRelationship domainObject = doFactory.createRelationship(XbrlDomainUri.c_LinkContainsArc, null,
				        (IIndexable) linkDO, (IIndexable) arc);
				try {
					// The lock should be taken care by the application
					domainObject.setDTSNode(workingDODtsNode);
					workingDODtsNode.add(linkDts, domainObject);
				} catch(Exception ex) {
					throw ex;
				}

				domainObject = doFactory.createRelationship(XbrlDomainUri.c_ArcroleClassifies, null,
				        (IIndexable) arcRole, (IIndexable) arc);
				try {
					// The lock should be taken care by the application
					domainObject.setDTSNode(workingDODtsNode);
					workingDODtsNode.add(linkDts, domainObject);
				} catch(Exception ex) {
					throw ex;
				}

				return arc;
			}
		}
		return null;
	}

}