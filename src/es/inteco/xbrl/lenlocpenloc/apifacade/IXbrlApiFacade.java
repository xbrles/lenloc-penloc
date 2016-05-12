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

package es.inteco.xbrl.lenlocpenloc.apifacade;

import java.util.ArrayList;
import java.util.HashMap;

import es.inteco.xbrl.lenlocpenloc.config.NsItem;
import es.inteco.xbrl.lenlocpenloc.config.maps.Statement;
import es.inteco.xbrl.lenlocpenloc.errors.GenericErrorsHandler;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.DocumentNotFoundException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLApiException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLENLOCException;

/**
 * Interfaz que se debe implementar para constituir toda facade para el acceso a
 * una API XBRL.
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
 * @see es.inteco.xbrl.lenlocpenloc.apifacade.xbreeze.UbmXbrlApiFacade
 *      UbmXbrlApiFacade
 * 
 */

public interface IXbrlApiFacade {

	/**
	 * Genera una instancia dada sobre el documento indicado en el argumento
	 * resultPath.
	 * 
	 * @param instance Referencia a la instancia
	 * 
	 * @param resultPath ruta del fichero sobre el cual generar la instancia
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 * @throws XBRLENLOCException para notificar que se ha producido un error general
	 */
	public abstract void generateXbrlDocument(IXbrlInstance instance, String resultPath) throws XBRLApiException,
	        XBRLENLOCException;

	/**
	 * Guarda una instancia XBRL sobre un array de bytes.
	 * 
	 * @param instance referencia a la instancia a generar
	 * 
	 * @return devuelve un array de bytes con la instancia XBRL
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract byte[] generateXbrlByteArray(IXbrlInstance instance) throws XBRLApiException;

	/**
	 * Crea los namespaces pasados en el array namespacesList sobre la instancia
	 * XBRL
	 * 
	 * @param namespacesList lista de espacios de nombres a crear
	 * 
	 * @param instance referencia de la instancia
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract void createNamespaces(NsItem[] namespacesList, IXbrlInstance instance) throws XBRLApiException;

	/**
	 * Crea una instancia XBRL con la jerarquia de clases de la API usada y la
	 * encapsula en el objeto IXbrlInstance, para poder ser manipulada desde
	 * fuera de la facade.
	 * 
	 * @param documentPath ruta del documento en el cual se guardará la
	 *        instancia XBRL
	 * 
	 * @param namespaceUri uri de la instancia XBRL
	 * 
	 * @param schema nombre del fichero XSD correspondiente al esquema href de
	 *        la instancia
	 * 
	 * @return IXbrlInstance Instancia XBRL creada
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 * @throws DocumentNotFoundException documento no encontrado en la ruta
	 */
	public abstract IXbrlInstance createInstance(String documentPath, String namespaceUri, String schema)
	        throws XBRLApiException, DocumentNotFoundException;

	/**
	 * Crea un elemento Unit en la instancia XBRL. Toda la información necesaria
	 * estará encapsulada en un objeto del tipo IXbrlUnit, de modo que pueda ser
	 * manipuldado desde fuera de la facade.
	 * 
	 * @param unit referencia al objeto que encapsula el elemento Unit de XBRL
	 * 
	 * @param instance referencia a la instancia XBRL
	 * 
	 * @return referencia al objeto con el elemento Unit
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract IXbrlUnit createUnit(IXbrlUnit unit, IXbrlInstance instance) throws XBRLApiException;

	/**
	 * Crea un contexto XBRL con la información contenida en el parámetro de
	 * entrada context y encapsula el resultado en éste.
	 * 
	 * @param context referencia a objeto context
	 * 
	 * @param instance referencia a instancia XBRL
	 * 
	 * @return objeto que encapsula el contexto creado sobre la instancia XBRL
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract IXbrlContext createContext(IXbrlContext context, IXbrlInstance instance) throws XBRLApiException;

	/**
	 * Crea un contexto XBRL con la información contenida en el parámetro de
	 * entrada context, añade la información del segmento para crear el contexto
	 * dimensional y encapsula el resultado en éste.
	 * 
	 * @param context referencia a objeto context
	 * 
	 * @param instance referencia a instancia XBRL
	 * 
	 * @param domain referencia a dominio del contexto dimensional
	 * 
	 * @param member referencia a miembro del dominio del contexto dimensional
	 * 
	 * @return objeto que encapsula el contexto creado sobre la instancia XBRL
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract IXbrlContext createDimensionalContext(IXbrlContext context, IXbrlInstance instance, String domain,
	        String member) throws XBRLApiException;

	/**
	 * Crea un contexto XBRL con la información contenida en el parámetro de
	 * entrada context, añade la información del segmento para crear el contexto
	 * dimensional teniendo en cuenta que es una typed dimension y encapsula el
	 * resultado en éste.
	 * 
	 * @param context referencia a objeto context
	 * 
	 * @param instance referencia a instancia XBRL
	 * 
	 * @param domainName referencia al nombre dominio del contexto dimensional
	 * 
	 * @param domainNS referencia al namespace del dominio del contexto
	 *        dimensional
	 * 
	 * @param member referencia a miembro del dominio del contexto dimensional
	 * 
	 * @param typedMemberValue referencia al valor en el caso de que sea una
	 *        typed dimension
	 * 
	 * @return objeto que encapsula el contexto creado sobre la instancia XBRL
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract IXbrlContext createTypedDimensionalContext(IXbrlContext context, IXbrlInstance instance,
	        String domainName, String domainNS, String member, String typedMemberValue) throws XBRLApiException;

	/**
	 * Crea un periodo de tipo Duration sobre un contexto dado.
	 * 
	 * @param context referencia al contexto sobre el cual se creará el periodo
	 * 
	 * @param instance referencia a la instancia que contiene el contexto
	 * 
	 * @return devuelve el contexto actualizado con el nuevo periodo
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract IXbrlContext createDurationPeriod(IXbrlContext context, IXbrlInstance instance)
	        throws XBRLApiException;

	/**
	 * Crea un periodo de tipo Instant sobre un contexto dado.
	 * 
	 * @param context referencia al contexto sobre el cual se creará el periodo
	 * 
	 * @param instance referencia a la instancia que contiene el contexto
	 * 
	 * @return devuelve el contexto actualizado con el nuevo periodo
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract IXbrlContext createInstantPeriod(IXbrlContext context, IXbrlInstance instance)
	        throws XBRLApiException;

	/**
	 * Crea un fact con la información contenida en el parámetro fact sobre la
	 * instancia dada.
	 * 
	 * @param fact objeto que encapsula la información necesaria para crear y
	 *        contener el fact XBRL
	 * 
	 * @param instance referencia a la instancia sobre la que se creará el fact
	 *        dado
	 * 
	 * @return devuelve el fact pasado como parámetro actualizado con el fact
	 *         XBRL creado
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract IXbrlFact createFact(IXbrlFact fact, IXbrlInstance instance) throws XBRLApiException;

	/**
	 * Crea un elemento tuple con la información contenida en el parámetro tuple
	 * sobre la instancia dada.
	 * 
	 * @param tuple objeto que encapsula la información necesaria para crear y
	 *        contener el elemento tuple XBRL
	 * 
	 * @param instance referencia a la instancia sobre la que se creará la tuple
	 *        dada
	 * 
	 * @return devuelve el tuple pasado como parámetro actualizado con el
	 *         elemento tuple XBRL creado
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract IXbrlFact createTuple(IXbrlFact tuple, IXbrlInstance instance) throws XBRLApiException;

	/**
	 * Crea una dimensión sobre un contexto dado.
	 * 
	 * @param domain nombre del domain de la dimensión
	 * 
	 * @param member nombre del member correspondiente al contexto dado.
	 * 
	 * @param context referencia al contexto sobre el cual se creará la
	 *        dimensión
	 * 
	 * @param instance referencia de la instancia a la cual pertenece el
	 *        contexto dado
	 * 
	 * @return contexto actualizado con la dimensión recien creada
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract IXbrlContext createDimension(String domain, String member, IXbrlContext context,
	        IXbrlInstance instance) throws XBRLApiException;

	/**
	 * Crea un fact hijo para una tupla dada.
	 * 
	 * @param fact objeto con la información del fact hijo, el cual se usará
	 *        para ser devuelto encapsulando el nuevo objeto XBRL creado
	 * 
	 * @param parentFact tupla de la que colgará el nuevo fact
	 * 
	 * @param instance referencia a la instancia en la cual se creará el nuevo
	 *        fact
	 * 
	 * @return objeto IXbrlFact con la información actualizada del fact recien
	 *         creado
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract IXbrlFact createTupleChild(IXbrlFact fact, IXbrlFact parentFact, IXbrlInstance instance)
	        throws XBRLApiException;

	/**
	 * Indica si el periodo para un fact dado es Instant o no.
	 * 
	 * @param fact referencia del fact sobre el cual se hace la consulta
	 * 
	 * @param instance referencia a la instancia a la cual pertenece el fact
	 *        consultado
	 * 
	 * @return True en caso de que el fact indicado se defina con un concepto
	 *         cuyo periodo es tipo Instant, false en otro caso
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract boolean isInstant(IXbrlFact fact, IXbrlInstance instance) throws XBRLApiException;

	/**
	 * Crea un link para foot notes sobre la instancia dada.
	 * 
	 * @param instance referencia de la instancia sobre la que se creará el link
	 * 
	 * @return objeto creado por la API y que corresponde a la instancia del
	 *         link footnote
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract Object createFootNoteLink(IXbrlInstance instance) throws XBRLApiException;

	/**
	 * Crea una footnote sobre el footnote link dado.
	 * 
	 * @param linkDO objeto de la instancia con el link para footnote.
	 * 
	 * @param fact fact sobre el cual se creará la footnote
	 * 
	 * @param language idioma del footnote
	 * 
	 * @param text texto que contendrá el footnote
	 * 
	 * @param order orden del footnote
	 * 
	 * @param instance referencia a la instancia sobre la que se creará el
	 *        footnote
	 * 
	 * @return objeto de la instancia con la footnote
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract Object createFootNote(Object linkDO, IXbrlFact fact, String language, String text, String order,
	        IXbrlInstance instance) throws XBRLApiException;

	/**
	 * Valida una instancia XBRL localizada en el path dado.
	 * 
	 * @param documentPath path de la instancia XBRL a validar
	 * 
	 * @return array de errores obtenidos en la validación, si la lista es
	 *         vacía, entonces la validación ha sido correcta
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract String[] validate(String documentPath) throws XBRLApiException;

	/**
	 * Valida una instancia XBRL localizada en el path dado.
	 * 
	 * @param documentPath path de la instancia XBRL a validar
	 * @param errorHandler manejador de errores
	 * @return Indicador (true/false) de si la instancia ha superado la
	 *         validación
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public boolean validate(String documentPath, GenericErrorsHandler errorHandler) throws XBRLApiException;

	/**
	 * Carga una taxonomía dada la ruta física de la misma. El DTS de la
	 * taxonomía será accesible a través del método getDTS del objeto
	 * IXbrlIntance devuelto.
	 * 
	 * @param schema ruta o path físico de la localización del esquema de la
	 *        taxonomía
	 * 
	 * @return objeto que encapsula el DTS de la taxonomía
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 * @throws DocumentNotFoundException no se encuentra el documento en la ruta
	 */
	public abstract IXbrlInstance loadTaxonomy(String schema) throws XBRLApiException, DocumentNotFoundException;

	/**
	 * Crea un nuevo mapa dimensional
	 * 
	 * @param map mapa
	 * @param roleUri uri del rol
	 * @param labelRoleUri etiqueta del rol
	 * @param nameMap nombre del mapa
	 * @param mainSchemaNamespace namespace del esquema
	 * @param mainSchemaPrefix prefijo del esquema
	 * @param instance referencia a la instancia sobre la que se generará el mapa
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract void generateDimensionMap(Statement map, String roleUri, String labelRoleUri, String nameMap,
	        String mainSchemaNamespace, String mainSchemaPrefix, IXbrlInstance instance) throws XBRLApiException;

	/**
	 * Crea un nuevo mapa
	 * 
	 * @param roleUri uri del rol
	 * @param labelRoleUri etiqueta del rol
	 * @param nameMap nombre del mapa
	 * @param mainSchemaNamespace namespace del esquema
	 * @param mainSchemaPrefix prefijo del esquema
	 * @param instance referencia a la instancia sobre la que se generará el mapa
	 * @return Statement del mapa
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract Statement generateMap(String roleUri, String labelRoleUri, String nameMap,
	        String mainSchemaNamespace, String mainSchemaPrefix, IXbrlInstance instance) throws XBRLApiException;

	/**
	 * Carga una instancia XBRL dada la ruta física de la misma. El DTS de la
	 * instancia será accesible a través del método getDTS y la instancia con
	 * getInstance del objeto IXbrlIntance devuelto.
	 * 
	 * @param documentPath ruta o path físico de la localización de la instancia
	 *        XBRL
	 * 
	 * @return objeto que encapsula la instancia y el DTS de la taxonomía
	 *         descubierta a partir de la instancia dada
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract IXbrlInstance loadInstance(String documentPath) throws XBRLApiException;

	/**
	 * Obtiene el schemaRef de la instancia dada.
	 * 
	 * @param xbrlInstance referencia a la instancia sobre la cual se hace la
	 *        consulta
	 * 
	 * @return String que contiene el schemaRef de la instancia dada
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract String getXBRLschemaRef(IXbrlInstance xbrlInstance) throws XBRLApiException;

	/**
	 * Determina si un fact dado es una tupla.
	 * 
	 * @param fact referencia al fact sobre el cual se hace la consulta
	 * 
	 * @param instance referencia a la instancia que contiene dicho fact
	 * 
	 * @return True si el fact dado es una tupla y false en caso contrario
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract boolean isTuple(IXbrlFact fact, IXbrlInstance instance) throws XBRLApiException;

	/**
	 * Obtiene una lista con los facts contenidos a nivel de instancia, para una
	 * instancia y contextos dados.
	 * 
	 * @param instance referencia a la instancia sobre la cual se hace la
	 *        consulta
	 * 
	 * @param context referencia al contexto para el cual se realiza la consulta
	 *        de facts
	 * 
	 * @param contextTable tabla de contextos de la instancia
	 * 
	 * @return lista con los facts encontrados
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract ArrayList<IXbrlFact> getGlobalFacts(IXbrlInstance instance, IXbrlContext context,
	        HashMap<String, IXbrlContext> contextTable) throws XBRLApiException;

	/**
	 * Obtiene una lista con las tuplas contenidas a nivel de instancia, para
	 * una instancia dada.
	 * 
	 * @param instance referencia a la instancia sobre la cual se hace la
	 *        consulta
	 * 
	 * @param contextTable tabla de contextos de la instancia
	 * 
	 * @return lista con las tuplas encontradas
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract ArrayList<IXbrlFact> getGlobalTuples(IXbrlInstance instance,
	        HashMap<String, IXbrlContext> contextTable) throws XBRLApiException;

	/**
	 * Obtiene una lista con los facts contenidos a nivel de instancia, para una
	 * instancia y tupla dadas.
	 * 
	 * @param instance referencia a la instancia sobre la cual se hace la
	 *        consulta
	 * 
	 * @param tupleFact referencia a la tupla para la cual se realiza la
	 *        consulta de facts
	 * 
	 * @param contextTable tabla de contextos de la instancia
	 * 
	 * @return lista con los facts encontrados
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract ArrayList<IXbrlFact> getGlobalFacts(IXbrlInstance instance, IXbrlFact tupleFact,
	        HashMap<String, IXbrlContext> contextTable) throws XBRLApiException;

	/**
	 * Obtiene los contextos de una instancia dada.
	 * 
	 * @param instance referencia a la instancia sobre la cual se hace la
	 *        consulta
	 * 
	 * @return tabla con los contextos encontrados
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract HashMap<String, IXbrlContext> getContexts(IXbrlInstance instance) throws XBRLApiException;

	/**
	 * Obtiene una lista de unidades de una instancia dada.
	 * 
	 * @param instance referencia a la instancia sobre la cual se hace la
	 *        consulta
	 * 
	 * @return lista de unidades encontradas
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract ArrayList<IXbrlUnit> getUnits(IXbrlInstance instance) throws XBRLApiException;

	/**
	 * Tuplas contenidas en otra tupla dada.
	 * 
	 * @param instance referencia a la instancia contenedora de las tuplas
	 * 
	 * @param tupleParent referencia de la tupla padre sobre la cual se hace la
	 *        consulta
	 * 
	 * @param contextTable tabla de contextos de la instancia
	 * 
	 * @return tabla de tuplas encontradas
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract ArrayList<IXbrlFact> getGlobalTuples(IXbrlInstance instance, IXbrlFact tupleParent,
	        HashMap<String, IXbrlContext> contextTable) throws XBRLApiException;

	/**
	 * Cierra una instancia dada.
	 * 
	 * @param instance referencia de la instancia que se pretende cerrar.
	 * 
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract void closeInstance(IXbrlInstance instance) throws XBRLApiException;

	/**
	 * Indica si en la lista de mensajes existe alguno con severidad de error.
	 * 
	 * @param messageList referencia la lista de mensajes sobre la cual se hace
	 *        la consulta
	 * 
	 * @return True en caso de que exista algún mensaje con severidad de error,
	 *         false en otro caso
	 * 
	 */
	public abstract boolean checkErrorListSeverity(String[] messageList);
	
	/**
	 * Asocia una tupla con su tupla padre
	 * 
	 * @param fact fact objeto con la información del fact hijo
	 * @param parentFact tupla de la que colgará el nuevo fact
	 * @param instance instance referencia a la instancia en la cual se creará el nuevo
	 *        fact
	 * @return Tupla creada
	 * @throws XBRLApiException para notificar que se ha producido un error de configuración
	 */
	public abstract IXbrlFact createTupleChildTuple(IXbrlFact fact, IXbrlFact parentFact, IXbrlInstance instance)
	        throws XBRLApiException;

	/**
	 * Establece el arraylist destinado al almacenar los warnings o errores que
	 * llegan al logger
	 * 
	 * @param loggerList ArrayList de String
	 */
	public abstract void setLoggerTraceList(ArrayList<String> loggerList);
}