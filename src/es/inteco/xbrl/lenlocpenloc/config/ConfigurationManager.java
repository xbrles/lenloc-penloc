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

package es.inteco.xbrl.lenlocpenloc.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

import es.inteco.xbrl.lenlocpenloc.config.maps.ConceptMap;
import es.inteco.xbrl.lenlocpenloc.config.maps.Statement;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.ConfigException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.DocumentNotFoundException;
import es.inteco.xbrl.lenlocpenloc.utils.XbrlApiConfiguration;

/**
 * 
 * 
 * Clase de configuraci�n usada para consultar la informaci�n necesaria en los
 * procesos de transformaci�n de formato com�n a XBRL y viceversa. <br /><br />
 * Mediante esta clase se accede al fichero de configuraci�n global.xml y a los
 * mapas definidos a partir de la taxonom�a para facilitar los procesos de
 * transformaci�n. <br /><br /> Para mantener la informaci�n lo m�s
 * eficientemente posible, utiliza una cach� interna basada en ehCache y la cual
 * puede ser configurada mediante el fichero de configuraci�n ehcache.xml. <br
 * /><br /> Para conocer m�s sobre c�mo configurar la cach�, puede visitar la
 * web del proyecto la cual se encuentra en la siguiente direcci�n
 * http://ehcache.sourceforge.net <br /><br /> Tanto el fichero global.xml como
 * el resto de ficheros de configuraci�n correspondientes a los mapas, los
 * cuales se encuentran bajo el directorio resources/ENLOCMaps, son le�dos
 * mediante Castor. <br /><br /> Cuando los mapas son deserializados mediante
 * Castor, son encapsulados mediante la clase ConfigMap, la cual crea tablas de
 * �ndices de modo que el acceso a los elementos sea lo m�s eficiente posible.
 * 
 * 
 *<br>
 * <br>
 * <b>Proyecto</b>: API XBRL-LENLOCPENLOC2010 - Grupo de utilidades y librer�as
 * en c�digo abierto para facilitar la integraci�n del formato XBRL en las
 * herramientas software de gesti�n de terceros aisl�ndose de la complejidad en
 * el procesamiento del modelo de datos de las taxonom�as. Ayudando de esta
 * forma a las entidades locales en la labor de realizaci�n de informes XBRL y
 * asegurar el �xito en el reporte de presupuestos y liquidaci�n de presupuestos
 * de las entidades locales en formato XBRL
 * 
 * 
 * @version 1.0, 24/06/2009
 * @author difusioncalidad@inteco.es
 * 
 */

public class ConfigurationManager {

	private static final Logger logger = Logger.getLogger(ConfigurationManager.class);

	private static final String MAPS_CACHE_NAME = "mapsCache";

	private static Global global = null;
	private static ConfigurationManager configManager = null;

	private CacheManager cacheManager = null;
	private Cache mapsCache = null;
	private HashMap<String, String> mapsCacheKeys = new HashMap<String, String>();

	/* Constructor */
	private ConfigurationManager() throws DocumentNotFoundException, ConfigException {

		String mapsPath = XbrlApiConfiguration.getInstance().getMapsPath();
		File directoryMaps = new File(mapsPath);
		File globalFile = null;

		if(!directoryMaps.exists()) {
			throw new DocumentNotFoundException(DocumentNotFoundException.notExistDirectoryMap,
			        new String[] { mapsPath });
		}

		String globalFilePath = XbrlApiConfiguration.getInstance().getGlobalPath();

		globalFile = new File(globalFilePath);

		if(!globalFile.exists()) {
			throw new DocumentNotFoundException(DocumentNotFoundException.notExistGlobalFile,
			        new String[] { globalFilePath });
		}

		FileReader globalFileReader = null;
		
		try {
			globalFileReader = new FileReader(globalFile);

		} catch(FileNotFoundException e) {
			throw new DocumentNotFoundException(DocumentNotFoundException.notExistGlobalFile,
			        new String[] { globalFilePath }, e);
		}

		try {
			global = Global.unmarshal(globalFileReader);

		} catch(MarshalException e) {
			throw new ConfigException(ConfigException.errorInGlobalFileDeserialization,
			        new String[] { globalFilePath }, e);

		} catch(ValidationException e) {
			throw new ConfigException(ConfigException.errorInValidationGlobalFile, new String[] { globalFilePath }, e);
		}

		cacheManager = CacheManager.create();
		cacheManager.addCache(MAPS_CACHE_NAME);
		mapsCache = cacheManager.getCache(MAPS_CACHE_NAME);

	}

	/* Metodo que inicializa la clase */
	private synchronized static void initialize() throws DocumentNotFoundException, ConfigException {
		if(configManager == null) {
			configManager = new ConfigurationManager();
		}
	}

	/**
	 * Obtiene la referencia a la configuraci�n de mapas necesaria para realizar
	 * la transformaci�n de formato com�n a XBRL y viceversa.
	 * 
	 * @return referencia a la configuraci�n
	 * 
	 * @throws ConfigException si se produce un error de configuraci�n.
	 * @throws DocumentNotFoundException si no se encuentra el documento en el sistema
	 */
	public static final ConfigurationManager getInstance() throws DocumentNotFoundException, ConfigException {
		if(configManager == null) {
			initialize();
		}

		return configManager;
	}

	/* Devuelve un objeto ConfigReport partiendo de un report ID */
	private ConfigReport getReport(String reportID) throws ConfigException {
		ConfigReport reportFound = null;

		int numReports = global.getConfigReportCount();

		for(int i = 0; i < numReports; i++) {

			if(global.getConfigReport(i).getId().equals(reportID)) {
				reportFound = global.getConfigReport(i);
				break;
			}
		}

		if(reportFound == null) {
			throw new ConfigException(ConfigException.notFoundReportInGlobal, new String[] { reportID });
		}

		return reportFound;
	}

	/* Devuelve un objeto Unit partiendo de un key y un report */
	private Unit getUnitByKey(ConfigReport report, String unitKey) {

		Unit unitFound = null;

		int numUnits = report.getUnitCount();

		for(int i = 0; i < numUnits; i++) {
			if(report.getUnit(i).getKey().equalsIgnoreCase(unitKey)) {
				unitFound = report.getUnit(i);
				break;
			}
		}
		return unitFound;
	}

	/* Devuelve un module perteneciente a un report */
	private ConfigModule getModule(ConfigReport report, String moduleID) throws ConfigException {

		ConfigModule moduleFound = null;

		int numModules = report.getConfigModuleCount();

		for(int i = 0; i < numModules; i++) {

			if(report.getConfigModule(i).getId().equals(moduleID)) {
				moduleFound = report.getConfigModule(i);
				break;
			}
		}
		if(moduleFound == null) {
			throw new ConfigException(ConfigException.notFoundModuleForReportInGlobal, new String[] { moduleID,
			        report.getId() });

		}

		return moduleFound;
	}

	/* Comprueba si existe configuraci�n para un m�dulo concreto */
	/**
	 * Comprueba si existe configuraci�n para un m�dulo concreto.
	 * 
	 * @param moduleID identificaci�n del m�dulo que se est� buscando.
	 * 
	 * @return boolean true si se ha encontrado el m�dulo.
	 */
	public boolean existModule(String moduleID) {

		ConfigReport configReport = null;

		int numReports = global.getConfigReportCount();

		for(int i = 0; i < numReports; i++) {
			configReport = global.getConfigReport(i);
			int numModules = configReport.getConfigModuleCount();
			for(int j = 0; j < numModules; j++) {
				if(configReport.getConfigModule(j).getId().equals(moduleID)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Obtiene la lista de espacios de nombres b�sicos que debe contener una
	 * instancia XBRL correspondiente a un report dado.
	 * 
	 * @param idReport identificador del report
	 * 
	 * @return lista de espacios de nombres
	 * 
	 * @throws ConfigException si se produce un error de configuraci�n.
	 */
	public NsItem[] getBasicNamespaces(String idReport) throws ConfigException {

		return getReport(idReport).getNsItem();
	}

	/**
	 * Obtiene la URI para el schemaRef del report indicado.
	 * 
	 * @param reportID identificador del report
	 * 
	 * @return String contenedor de la URI encontrada
	 * 
	 * @throws ConfigException si se produce un error de configuraci�n.
	 */
	public String getShemaRefUri(String reportID) throws ConfigException {
		return getReport(reportID).getSchemaRef().getUri();
	}

	/**
	 * Devuelve el targetNamespace para el report indicado mediante un
	 * identificador dado.
	 * 
	 * @param reportID identificador del report consultado
	 * 
	 * @return String contenedor del targetNamespace consultado
	 * 
	 * @throws ConfigException si se produce un error de configuraci�n.
	 */
	public String getTargetNamespace(String reportID) throws ConfigException {
		return getReport(reportID).getSchemaRef().getTargetNamespace();
	}

	/**
	 * Devuelve la URL base que usa el schemaRef de un report.
	 * 
	 * @param reportID identificador del report
	 * 
	 * @return URL base
	 * 
	 * @throws ConfigException si se produce un error de configuraci�n.
	 */
	public String getBaseUrl(String reportID) throws ConfigException {
		return getReport(reportID).getSchemaRef().getBaseUrl();
	}

	/**
	 * Devuelve el code correspondiente a un unitKey e identificador de report
	 * dado.
	 * 
	 * @param unitKey identificador de la unidad para la cual se hace la
	 *        consulta
	 * 
	 * @param reportID identificador del report que contiene la unidad
	 * 
	 * @return codido de la unidad cousltada
	 * 
	 * @throws ConfigException si se produce un error de configuraci�n.
	 */
	public String getUnit(String unitKey, String reportID) throws ConfigException {
		String unitCode = null;

		Unit vUnit = getUnitByKey(getReport(reportID), unitKey);
		if(vUnit != null) {
			unitCode = vUnit.getCode();
		}
		return unitCode;
	}

	/**
	 * Devuelve el prefijo correspondiente a un identificador de report y una
	 * clave de unidad.
	 * 
	 * @param unitKey clave de la unidad consultada
	 * 
	 * @param reportID identificador del report que contiene la unidad
	 *        consultada
	 * 
	 * @return prefijo de la unidad dada
	 * 
	 * @throws ConfigException si se produce un error de configuraci�n.
	 */
	public String getUnitPrefix(String unitKey, String reportID) throws ConfigException {

		String unitPrefix = null;

		Unit vUnit = getUnitByKey(getReport(reportID), unitKey);
		if(vUnit != null) {
			unitPrefix = vUnit.getPrefix();
		}
		return unitPrefix;
	}

	/**
	 * Devuelve un ConfigMap correspondiente a un identificador de mapa e
	 * identificador de report dados. Accede a la cach� de mapas, en caso de no
	 * encontrarlo accede al m�dulo de configuraci�n en el cual se indica el
	 * nombre del fichero que contiene el Statement correspondiente y lo
	 * deserializa, a�adi�ndolo a la cach� antes de ser devuelto.
	 * 
	 * @param reportID identificador del report que contiene la informaci�n del
	 *        mapa
	 * 
	 * @param moduleID identificador del m�dulo que contiene la informaci�n del
	 *        mapa
	 * 
	 * @return ConfigMap con los ConceptMaps correspondientes al Statement
	 *         indicado con la configuraci�n encontrada bajo el m�dulo
	 *         identificado mediante el par�metro moduleID.
	 * @throws DocumentNotFoundException no se encuentra el documento en el sistema
	 * 
	 * @throws ConfigException si se produce un error de configuraci�n.
	 */
	private ConfigMap getMap(String reportID, String moduleID) throws ConfigException, DocumentNotFoundException {
		String mapFile = null;
		Statement statement = null;
		ConfigMap map = null;
		Object lock = new Object();
		try {
			String key = reportID + "_" + moduleID;

			if(mapsCacheKeys.containsKey(key)) {
				Element moduleElement = mapsCache.get(mapsCacheKeys.get(key));
				if(moduleElement != null) {
					map = (ConfigMap) moduleElement.getObjectValue();
				}
			}
			if(map == null) {
				synchronized(lock) {

					mapFile = getModule(getReport(reportID), moduleID).getFileMap();
					String mapFullPath = XbrlApiConfiguration.getInstance().getMapsPath() + mapFile;
					if(logger.isDebugEnabled()) {
						logger.debug("loading map: " + mapFullPath);
					}
					FileReader fileMapReader = new FileReader(mapFullPath);
					statement = Statement.unmarshal(fileMapReader);
					map = new ConfigMap(statement);
					mapsCache.put(new Element(key, map));
					mapsCacheKeys.put(key, key);
				}

			}
		} catch(MarshalException e) {
			logger.error(e);
			throw new ConfigException(ConfigException.errorInMapFileDeserialization, new String[] { mapFile }, e);

		} catch(ValidationException e) {
			logger.error(e);
			throw new ConfigException(ConfigException.errorInValidationMapFile, new String[] { mapFile }, e);

		} catch(FileNotFoundException e) {
			logger.error(e);
			throw new DocumentNotFoundException(DocumentNotFoundException.notExistMapFile, new String[] { mapFile });
		}
		return map;
	}

	/* Devuelve un ConfigMap a partir de un inputID buscando dentro de un report */
	private ConfigMap searchConfigMapByInputID(String reportID, String inputID) throws ConfigException,
	        DocumentNotFoundException {
		ConfigMap configMapResp = null;
		ConfigReport report = getReport(reportID);

		if(report != null) {
			int numModules = report.getConfigModuleCount();
			for(int i = 0; i < numModules; i++) {
				ConfigModule currentModule = report.getConfigModule(i);
				ConfigMap currentConfigMap = getMap(reportID, currentModule.getId());
				if(currentConfigMap.getConceptMapByInputID(inputID) != null) {
					configMapResp = currentConfigMap;
					break;
				}
			}
		}
		return configMapResp;
	}

	/* Devuelve un module buscando por un outputID */
	private ConfigModule searchModuleByOutputID(String reportID, String outputID, String dimension, String member)
	        throws ConfigException, DocumentNotFoundException {
		ConfigModule moduleResp = null;
		ConfigReport report = getReport(reportID);

		if(report != null) {
			int numModules = report.getConfigModuleCount();
			for(int i = 0; i < numModules; i++) {
				ConfigModule currentModule = report.getConfigModule(i);
				ConfigMap currentConfigMap = getMap(reportID, currentModule.getId());

				ConceptMap currentConceptMap = currentConfigMap.getConceptMapByOutputID(outputID, dimension, member);
				if(currentConceptMap != null) {
					moduleResp = currentModule;
					break;
				}
			}
		}
		return moduleResp;
	}

	/* Devuelve un ConfigMap buscando por outputID */
	private ConfigMap searchConfigMapByOutputID(String reportID, String outputID, String dimension, String member)
	        throws ConfigException, DocumentNotFoundException {
		ConfigMap configMapResp = null;
		ConfigReport report = getReport(reportID);

		if(report != null) {
			int numModules = report.getConfigModuleCount();
			for(int i = 0; i < numModules; i++) {
				ConfigModule currentModule = report.getConfigModule(i);
				ConfigMap currentConfigMap = getMap(reportID, currentModule.getId());

				ConceptMap currentConceptMap = currentConfigMap.getConceptMapByOutputID(outputID, dimension, member);
				if(currentConceptMap != null) {
					configMapResp = currentConfigMap;
					break;
				}
			}
		}
		return configMapResp;
	}

	/* Devuelve un ConfigMap trabajando con los codigos de formato com�n */
	private ConfigMap searchConfigMapToTranslate(String reportID, String prefix, String outputID)
	        throws ConfigException, DocumentNotFoundException {
		ConfigMap configMapResp = null;
		ConfigReport report = getReport(reportID);

		if(report != null) {
			int numModules = report.getConfigModuleCount();
			for(int i = 0; i < numModules; i++) {
				ConfigModule currentModule = report.getConfigModule(i);
				ConfigMap currentConfigMap = getMap(reportID, currentModule.getId());
				if(currentConfigMap.getConceptMapByOutputIDPrefix(outputID, prefix) != null) {
					configMapResp = currentConfigMap;
					break;
				}
			}
		}
		return configMapResp;
	}

	/* Devuelve un ConfigMap trabajando con los codigos de formato com�n */
	private ConfigMap searchConfigMapToTranslate(String reportID, String outputID) throws ConfigException,
	        DocumentNotFoundException {
		ConfigMap configMapResp = null;
		ConfigReport report = getReport(reportID);

		if(report != null) {
			int numModules = report.getConfigModuleCount();
			for(int i = 0; i < numModules; i++) {
				ConfigModule currentModule = report.getConfigModule(i);
				ConfigMap currentConfigMap = getMap(reportID, currentModule.getId());
				if(currentConfigMap.getConceptMapToTranslate(outputID) != null) {
					configMapResp = currentConfigMap;
					break;
				}
			}
		}
		return configMapResp;
	}

	/**
	 * Localiza un ConceptMap mediante el identificador del report, el
	 * identificador del m�dulo y el identificador de entrada, inputID del
	 * propio ConceptMap.
	 * 
	 * @param reportID identifcador del report
	 * 
	 * @param moduleID identificador del m�dulo
	 * 
	 * @param inputID identificador de entrada del ConceptMap
	 * 
	 * @return referencia al ConceptMap encontrado
	 * 
	 * @throws DocumentNotFoundException si se produce un error al no
	 *         encontrarse un fichero.
	 * 
	 * @throws ConfigException si se produce un error de configuraci�n.
	 */
	public ConceptMap getInfoByInputID(String reportID, String moduleID, String inputID) throws ConfigException,
	        DocumentNotFoundException {
		ConceptMap conceptMapResult = null;
		ConfigMap map = null;
		if(moduleID != null) {
			map = getMap(reportID, moduleID);

		} else {
			map = searchConfigMapByInputID(reportID, inputID);
		}
		if(map != null) {
			conceptMapResult = map.getConceptMapByInputID(inputID);
		}

		return conceptMapResult;
	}

	/**
	 * Localiza un ConceptMap mediante el identificador del report, el
	 * identificador del m�dulo y el identificador de entrada, outputID del
	 * propio ConceptMap, la dimensi�n y el miembro, para aquellos conceptos que
	 * pertenecen a mapas dimensionales.
	 * 
	 * @param reportID identificador del report
	 * 
	 * @param moduleID identificador del m�dulo
	 * 
	 * @param outputID identificador de salida del ConceptMap
	 * 
	 * @param dimension nombre de la dimension
	 * 
	 * @param member nombre del miembro
	 * 
	 * @return referencia al ConceptMap encontrado
	 * 
	 * @throws DocumentNotFoundException si se produce un error al no
	 *         encontrarse un documento.
	 * 
	 * @throws ConfigException si se produce un error de configuraci�n.
	 */
	public ConceptMap getInfoByOutputID(String reportID, String moduleID, String outputID, String dimension,
	        String member) throws ConfigException, DocumentNotFoundException {
		ConceptMap conceptMapResult = null;
		ConfigMap map = null;
		if(moduleID != null) {
			map = getMap(reportID, moduleID);

		} else {
			map = searchConfigMapByOutputID(reportID, outputID, dimension, member);
		}
		if(map != null) {
			conceptMapResult = map.getConceptMapByOutputID(outputID, dimension, member);
		}

		return conceptMapResult;
	}

	/**
	 * Localiza un ConceptMap mediante el identificador del report, el
	 * identificador del m�dulo y el identificador de entrada, outputID del
	 * propio ConceptMap y el dominio, para aquellos conceptos que pertenecen a
	 * mapas dimensionales.
	 * 
	 * @param reportID identifcador del report
	 * 
	 * @param moduleID identificador del m�dulo
	 * 
	 * @param outputID identificador de salida del ConceptMap
	 * 
	 * 
	 * @return referencia al ConceptMap encontrado
	 * 
	 * @throws DocumentNotFoundException si se produce un error al no
	 *         encontrarse un documento.
	 * 
	 * @throws ConfigException si se produce un error de configuraci�n.
	 */
	public ConceptMap getInfoByOutputID(String reportID, String moduleID, String outputID) throws ConfigException,
	        DocumentNotFoundException {
		ConceptMap conceptMapResult = null;
		conceptMapResult = getInfoByOutputID(reportID, moduleID, outputID, null, null);
		return conceptMapResult;
	}

	/**
	 * Localiza un ConceptMap mediante el identificador del report, el
	 * identificador del m�dulo y el identificador de entrada, outputID del
	 * propio ConceptMap y el dominio, para aquellos conceptos que pertenecen a
	 * mapas dimensionales. Teniendo en cuenta la traducci�n entre elementos
	 * XBRL y codigos de formato com�n.
	 * 
	 * @param reportID identifcador del report
	 * 
	 * @param moduleID identificador del m�dulo
	 * 
	 * @param outputID identificador de salida del ConceptMap
	 * 
	 * @return referencia al ConceptMap encontrado
	 * 
	 * @throws DocumentNotFoundException si se produce un error al no
	 *         encontrarse un documento.
	 * 
	 * @throws ConfigException si se produce un error de configuraci�n.
	 */
	public String getInfoToTranslate(String reportID, String moduleID, String prefix, String outputID)
	        throws ConfigException, DocumentNotFoundException {
		String outputToTranslate = null;
		ConfigMap map = null;
		if(moduleID != null) {
			map = getMap(reportID, moduleID);

		} else {
			map = searchConfigMapToTranslate(reportID, prefix, outputID);
		}
		if(map != null) {
			outputToTranslate = map.getConceptMapToTranslate(outputID);
		}

		return outputToTranslate;
	}

	/**
	 * Localiza un ConceptMap mediante el identificador del report, el
	 * identificador del m�dulo y el identificador de entrada, outputID del
	 * propio ConceptMap y el dominio, para aquellos conceptos que pertenecen a
	 * mapas dimensionales. Teniendo en cuenta la traducci�n entre elementos
	 * XBRL y codigos de formato com�n.
	 * 
	 * @param reportID identifcador del report
	 * 
	 * @param moduleID identificador del m�dulo
	 * 
	 * @param outputID identificador de salida del ConceptMap
	 * 
	 * @return referencia al ConceptMap encontrado
	 * 
	 * @throws DocumentNotFoundException si se produce un error al no
	 *         encontrarse un documento.
	 * 
	 * @throws ConfigException si se produce un error de configuraci�n.
	 */
	public String getInfoToTranslate(String reportID, String moduleID, String outputID) throws ConfigException,
	        DocumentNotFoundException {
		String outputToTranslate = null;
		ConfigMap map = null;
		if(moduleID != null) {
			map = getMap(reportID, moduleID);

		} else {
			map = searchConfigMapToTranslate(reportID, outputID);
		}
		if(map != null) {
			outputToTranslate = map.getConceptMapToTranslate(outputID);
		}

		return outputToTranslate;
	}

	/**
	 * Obtiene el identificador del m�dulo para un identificador de report,
	 * dimension, member y ConceptMap dados. Indica qu� m�dulo contiene el
	 * ConceptMap dado.
	 * 
	 * @param reportID identificador del report.
	 * 
	 * @param outputID identificador de salida del ConceptMap.
	 * 
	 * @param dimension dimensi�n.
	 * 
	 * @param member member nombre del miembro de la dimensi�n.
	 * 
	 * @return Identificador del m�dulo contenedor del ConceptMap.
	 * 
	 * @return identificador del m�dulo.
	 * 
	 * @throws DocumentNotFoundException si se produce un error al no
	 *         encontrarse un documento.
	 * 
	 * @throws ConfigException si se produce un error de configuraci�n.
	 * 
	 */
	public String getModuleID(String reportID, String outputID, String dimension, String member)
	        throws ConfigException, DocumentNotFoundException {
		String moduleID = null;

		ConfigModule module = searchModuleByOutputID(reportID, outputID, dimension, member);
		if(module != null) {
			moduleID = module.getId();
		}

		return moduleID;
	}

	/**
	 * Devuelve la configuraci�n de un Report para un schemaRef dado.
	 * 
	 * @param schemaRef schemaRef del m�dulo a localizar.
	 * 
	 * @return configuraci�n del report encontrado
	 * 
	 */
	public ConfigReport getGlobalReportFromSchemaRef(String schemaRef) {

		ConfigReport foundReport = null;

		String utilSchemaRef = schemaRef;

		utilSchemaRef = schemaRef.replace('\\', '/');
		String[] arrSchemaRef = utilSchemaRef.split("/");
		int segmentCount = arrSchemaRef.length;
		utilSchemaRef = arrSchemaRef[segmentCount - 1];

		ConfigReport[] globalReportList = global.getConfigReport();

		for(int i = 0; i < globalReportList.length; i++) {
			ConfigReport globalReport = globalReportList[i];
			SchemaRef globalSchemaRef = globalReport.getSchemaRef();

			if(globalSchemaRef.getUri().equalsIgnoreCase(utilSchemaRef)) {
				foundReport = globalReport;
				break;
			}
		}

		return foundReport;
	}

	/**
	 * Devuelve un objeto de tipo Global.
	 * 
	 * @return Objeto del tipo Global
	 */
	public Global getGlobal() {

		return global;
	}

	/**
	 * Obtiene y devuelve el orden que debe llevar un elemento dentro de la
	 * tupla en la que est� anidado.
	 * 
	 * @param reportID id del report
	 * @param moduleID id del module
	 * @param itemID id del item
	 * @param parentInputID codigo de la tupla padre
	 * @return BigDecimal con el order correcto
	 * @throws ConfigException si se produce un error de configuraci�n.
	 */
	public BigDecimal getOrderToReplace(String reportID, String moduleID, String itemID, String parentInputID)
	        throws ConfigException {
		BigDecimal returnValue = null;
		try {

			ConfigMap map = null;

			if(moduleID != null) {
				map = getMap(reportID, moduleID);

			} else {
				map = searchConfigMapByInputID(reportID, itemID);
			}
			if(map != null) {
				ArrayList<ConceptMap> conceptList = map.getAllConceptMapByInputID(itemID);
				if(!(conceptList == null) && conceptList.size() > 1) {
					for(int i = 0; i < conceptList.size(); i++) {
						ConceptMap cm = conceptList.get(i);
						String cmOutID = cm.getOutputID();
						if(!(cmOutID == null) && !(cmOutID.trim().equals(""))) {
							String[] arrCodesOut = cmOutID.split(":");
							if(arrCodesOut.length > 1
							        && (arrCodesOut[arrCodesOut.length - 2].toString().equals(parentInputID))) {
								returnValue = cm.getOrder();
								break;
							}
						}

					}
				}
			}

		} catch(Throwable e3) {
			returnValue = null;
		}
		return returnValue;
	}
}