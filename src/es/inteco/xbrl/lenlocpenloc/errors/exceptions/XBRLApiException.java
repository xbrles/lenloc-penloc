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

package es.inteco.xbrl.lenlocpenloc.errors.exceptions;

/**
 * 
 * Clase utilizada para notificar errores producidos en fallos de configuración,
 * bien sea, por errores en formato de entrada, bien por llevar a cabo acciones
 * no contempladas.
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

public class XBRLApiException extends XBRLENLOCException {

	/**
	 * Se ha producido un error mientra se intentaba escribir el XBRL obtenido
	 * tras el proceso de transformación.
	 */
	public static final String failedWriteXbrlDocument = "failedWriteXbrlDocument";// "Failed attempting to write {0} to {1}"
	/**
	 * El juego de caracteres utilizado en la instancia XBRL de entrada no está
	 * soportado por la aplicación, el cual debe ser UTF-8.
	 */
	public static final String unsuportedEncodingInstanceByte = "unsuportedEncodingInstanceByte";// "Error in obtaining instance as byte[]. Encoding not supported"
	/**
	 * Error producido mientras se intentaba obtener un array de bytes de la
	 * instancia resultado del proceso de transformación.
	 */
	public static final String failedGettingInstanceByte = "failedGettingInstanceByte";// "Error in obtaining instance as byte[]"
	/**
	 * Error mientras se asignan prefijos y paths.
	 */
	public static final String errorGettingXPathPrefixMaps = "errorGettingXPathPrefixMaps";// "Error associating prefixes and namespaces for XPath expressions"
	/**
	 * Error creando los namespaces básicos para la creación de una instancia
	 * XBRL.
	 */
	public static final String coreErrorCreatingNamespaces = "coreErrorCreatingNamespaces";// "Failed to create instance namespaces (core error)"
	/**
	 * Error creando los namespaces básicos para la creación de una instancia
	 * XBRL.
	 */
	public static final String errorCreatingNamespaces = "errorCreatingNamespaces";// "Failed to create instance namespaces"
	/**
	 * Error creando instancia XBRL.
	 */
	public static final String errorCreatingXbrlInstance = "errorCreatingXbrlInstance";// "Failed to create instance. Input file:{0} NameSpace:{1} Schema:{2}"
	/**
	 * Error creando un elemento XBRL Unit.
	 */
	public static final String errorCreatingUnit = "errorCreatingUnit";// "Failed to create an Unit element in instance"
	/**
	 * Error creando un elemento XBRL Measure.
	 */
	public static final String errorCreatingMeasure = "errorCreatingMeasure";// "Failed to create a Measure element in instance"
	/**
	 * Error creando un elemento XBRL Context.
	 */
	public static final String errorCreatingContext = "errorCreatingContext";// "Failed to create a Context element in instance"
	/**
	 * Error creando un elemento XBRL periodo del tipo duration.
	 */
	public static final String errorCreatingDurationPeriod = "errorCreatingDurationPeriod";// "Failed to create a Duration Period element in instance"
	/**
	 * Error creando un elemento XBRL periodo del tipo instant.
	 */
	public static final String errorCreatingInstantPeriod = "errorCreatingInstantPeriod";// "Failed to create a Instant Period element in instance"
	/**
	 * Error creando un fact, debido a que su concepto no se encuentra en la
	 * taxonomía.
	 */
	public static final String errorCreatingFactConceptNotFound = "errorCreatingFactConceptNotFound";// "Error creating fact. Concept not found. Search expression: {0}"
	/**
	 * Error creando un elemento XBRL Concept
	 */
	public static final String errorCreatingConcept = "errorCreatingConcept";// "Failed to create a Concept element in instance"
	/**
	 * Error creando una tupla, debido a que su concepto no se encuentra en la
	 * taxonomía.
	 */
	public static final String errorCreatingTupleConceptNotFound = "errorCreatingTupleConceptNotFound";// "Error creating tuple fact. Concept not found. Search expression: {0}"
	/**
	 * Error creando un elemento XBRL Tuple.
	 */
	public static final String errorCreatingTuple = "errorCreatingTuple";// "Failed to create a Tuple element in instance"
	/**
	 * Error creando un elemento XBRL Dimension.
	 */
	public static final String errorCreatingDimension = "errorCreatingDimension";// "Failed to create a Dimension element in instance"
	/**
	 * Error obteniendo información de un concepto XBRL.
	 */
	public static final String errorGettingConceptInformation = "errorGettingConceptInformation";
	/**
	 * No se ha podido encontrar el directorio ENLOCMaps, en el cual se
	 * encuentran los mapas utilizados por los servicios de transformación.
	 */
	public static final String notExistDirectoryMap = "notExistDirectoryMap";
	/**
	 * Error creando hijo de una tupla, debido a que su concepto no se encuentra
	 * en la taxonomía.
	 */
	public static final String errorCreatingTupleChildConceptNotFound = "errorCreatingTupleChildConceptNotFound";// "Error creating tuple child. Concept not found. Search expression: {0}"
	/**
	 * Error creando un elemento hijo para una tupla XBRL.
	 */
	public static final String errorCreatingTupleChild = "errorCreatingTupleChild";// "Failed to create a nested Tuple element in instance"
	/**
	 * Error comprobando si un fact dado es de tipo instant.
	 */
	public static final String errorCheckingPeridoTypeIsInstant = "errorCheckingPeridoTypeIsInstant";// "PeriodType query error, cheking if it's instant. Concept not found. Search expression: {0}"
	/**
	 * Error leyendo el atributo periodType, para determinar el tipo de periodo
	 * de un contexto dado.
	 */
	public static final String errorReadingPeridodTypeAttribute = "errorReadingPeridodTypeAttribute";// "Error reading PeriodType attribute"
	/**
	 * Error creando footnote, debido a que no se encuentra el role especificado
	 * para la footnote.
	 */
	public static final String errorCreatingFootNoteLinkLinkRoleNotFound = "errorCreatingFootNoteLinkLinkRoleNotFound";// "Error creating footnote link. LinkRole not found. Search expression: {0}"
	/**
	 * Error creando footnote, debido a que no se encuentra el role especificado
	 * para la footnote.
	 */
	public static final String errorCreatingFootNoteNoteRoleNotFound = "errorCreatingFootNoteNoteRoleNotFound";// "Error creating FootNote. Note role not found. Search expression: {0}"
	/**
	 * Error creando footnote, debido a que no se encuentra el role especificado
	 * para la footnote.
	 */
	public static final String errorCreatingFootNoteArcRoleNotFound = "errorCreatingFootNoteArcRoleNotFound";// "Error creating FootNote. Arc role not found. Search expression: {0}"
	/**
	 * Error creando un elemento XBRL FootNoteLink.
	 */
	public static final String errorCreatingFootNoteLink = "errorCreatingFootNoteLink";// "Failed to create a footnote link in instance"
	/**
	 * Error creando un elemento XBRL FootNote.
	 */
	public static final String errorCreatingFootNote = "errorCreatingFootNote";// "Failed to create a FootNote element in instance. Text:{0}"
	/**
	 * Error cargando la instancia antes de su validación.
	 */
	public static final String errorValidatingInstanceNotLoad = "errorValidatingInstanceNotLoad";// "Error during validation process for instance:{0}. Loading document was not completed successfully"
	/**
	 * Se han encontrados errores en la validación de la instancia.
	 */
	public static final String errorValidatingInstance = "errorValidatingInstance";// "Error during validation process for instance:{0}"
	/**
	 * Error obteniendo codelabel para concepto.
	 */
	public static final String coreErrorGettingCodeLabel = "coreErrorGettingCodeLabel";// "Error reading a CodeLabel from DTS (Core error)"
	/**
	 * Error obteniendo codeLabel para concpeto.
	 */
	public static final String errorGettingCodeLabel = "errorGettingCodeLabel";// "Error reading a CodeLabel from DTS"

	/**
	 * Error al añadir los members al conceptMa.
	 */
	public static final String errorAddMembersToConceptMap = "errorAddMembersToConceptMap";// "Error adding member to conceptMap"
	/**
	 * Error al crear un conceptMap.
	 */
	public static final String errorCreatingConceptMap = "errorCreatingConceptMap";// "Failed to create a ConceptMap element in DTS"
	/**
	 * Error obteniendo los miembros de un conceptMap.
	 */
	public static final String errorGettingMembers = "errorGettingMembers";// "Error getting members of hypercube"
	/**
	 * Error creando el Statement de un mapa.
	 */
	public static final String errorCreatingStatement = "errorCreatingStatement";// "Failed to create a Statement element. Schema:{0} Prefix:{1} Name:{2}"

	/**
	 * Error producido mientras se intentaba cargar la taxonomía.
	 */
	public static final String errorLoadingTaxonomy = "errorLoadingTaxonomy";// "Failed to create taxonomy. Schema:{0} Taxonomy file:{1} Uri:{2}"
	/**
	 * Error al cargar un hipercubo.
	 */
	public static final String hyperCubeNotFoundInRole = "hyperCubeNotFoundInRole";// "Error during dimension map generation. Not exists hypercube in role {0}"
	/**
	 * Error creando el Statement de un mapa.
	 */
	public static final String errorCreatingStatementDimensionMap = "errorCreatingStatementDimensionMap";// "Error creating dimensional map Statement. RoleUri:{0}, Map:{1}, NameSpace:{2}, Prefix:{3}"
	/**
	 * Error obteniendo los roles definidos en la taxonomía.
	 */
	public static final String errorGettingRoleFromDTS = "errorGettingRoleFromDTS";// "Error getting role from DTS. Role uri:{0}"
	/**
	 * Error al obtener el role del mapa.
	 */
	public static final String roleNotFoundInMap = "roleNotFoundInMap";// "Error during map generation. Not exists role {0} for map {1}"
	/**
	 * Error creando el mapa.
	 */
	public static final String errorCreatingMap = "errorCreatingMap";// "Error during map generation. RoleUri:{0}, Map:{1}, NameSpace:{2}, Prefix:{3}"
	/**
	 * Error cargando instancia.
	 */
	public static final String errorLoadingInstance = "errorLoadingInstance";// "Error loading instance. Document path:{0}"
	/**
	 * Error obteniendo esquema de la instancia.
	 */
	public static final String errorGettingSchemaFromInstance = "errorGettingSchemaFromInstance";// "Error getting schema from instance"
	/**
	 * Error obteniendo fact de la instancia.
	 */
	public static final String errorCreatingXBRLFact = "errorCreatingXBRLFact";// "Error getting fact from XBRL instance"
	/**
	 * Error obteniendo contexto de la instancia.
	 */
	public static final String errorCreatingXBRLContext = "errorCreatingXBRLContext";// "Error getting context from XBRL instance"
	/**
	 * Error comprobando si un fact es tupla.
	 */
	public static final String errorCheckingFactIsTuple = "errorCheckingFactIsTuple";// "Error checking if fact is tuple"
	/**
	 * Error obteniendo contexto desde fact.
	 */
	public static final String errorExtractingContextFromFact = "errorExtractingContextFromFact";// "Error extracting context from fact"
	/**
	 * Error convirtiendo iterador de facts a tabla.
	 */
	public static final String errorTranslatingFactsFromIteratorToTable = "errorTranslatingFactsFromIteratorToTable";// "Error translating facts from iterator to table associating context"
	/**
	 * Error obteniendo tabla de facts.
	 */
	public static final String errorGettingGlobalFactsTable = "errorGettingGlobalFactsTable";// "Error getting global facts table"
	/**
	 * Error obteniendo tabla de hijos de tupla.
	 */
	public static final String errorGettingGlobalTupleChildsTable = "errorGettingGlobalTupleChildsTable";// "Error getting global tuple childs table"
	/**
	 * Error obteniendo tabla de tuplas.
	 */
	public static final String errorGettingGlobalTupleTable = "errorGettingGlobalTupleTable";// "Error getting global tuple table"
	/**
	 * Error obteniendo la tabla de tuplas para una tupla dada.
	 */
	public static final String errorGettingGlobalTupleTableByParent = "errorGettingGlobalTupleTableByParent";// "Error getting global tuple table (by parent)"
	/**
	 * Error obteniendo la tabla de contextos de una instancia dada.
	 */
	public static final String errorGettingContextTable = "errorGettingContextTable";// "Error getting context table by instance"
	/**
	 * Error obteniendo la lista de unidades de una instancia XBRL dada.
	 */
	public static final String errorGettingUnitList = "errorGettingUnitList";// "Error getting unit list by instance"
	/**
	 * Error al intentar cerrar una instancia XBRL.
	 */
	public static final String closingInstance = "closingInstance";
	/**
	 * Error generating primary items
	 */
	public static final String errorCreatingPrimaryItems = "errorCreatingPrimaryItems";
	/**
	 * No se ha encontrado el archivo de configuración Global.xml.
	 */
	public static final String notExistGlobalFile = "notExistGlobalFile";
	/**
	 * No se encuentra el documento para el mapa usado en el servicio de
	 * transformación.
	 */
	public static final String notExistMapFile = "notExistMapFile";
	/**
	 * No se encuentra el documento report indicado.
	 */
	public static final String notExistReportFile = "notExistReportFile";
	/**
	 * No se encuentra el documento a validar.
	 */
	public static final String notFoundInputDocumentToValidate = "notFoundInputDocumentToValidate";
	/**
	 * No se encuentra el fichero de configuración global.xml, el cual debe
	 * estar en el directorio config.
	 */
	public static final String notFoundReportInGlobal = "notFoundReportInGlobal";// "Report {0} not found in global file"

	/**
	 * Crea una excepción con un identificador, el cual corresponderá a una de
	 * las constantes definidas, con los parámetros necesarios para completar el
	 * mensaje de error.
	 * 
	 * @param message constante correspondiente al mensaje.
	 * 
	 * @param parameters parámetros para completar el mensaje.
	 * 
	 * @param cause mensaje de la excepción original.
	 * 
	 */
	public XBRLApiException(String message, String[] parameters, Throwable cause) {
		super(message, parameters, cause);
	}

	/**
	 * Crea una excepción sin indicar la causa de la excepción.
	 * 
	 * @param message constante correspondiente al mensaje de error.
	 * 
	 * @param parameters parámetros para completar el mensaje de error
	 * 
	 */
	public XBRLApiException(String message, String[] parameters) {
		super(message, parameters);
	}

	/**
	 * Crea una excepción con un mensaje sin parámetros.
	 * 
	 * @param message constante correspondiente al mensaje de error.
	 * @param cause excepción original.
	 */
	public XBRLApiException(String message, Throwable cause) {
		super(message, cause);
	}

	private static final long serialVersionUID = 1L;

}