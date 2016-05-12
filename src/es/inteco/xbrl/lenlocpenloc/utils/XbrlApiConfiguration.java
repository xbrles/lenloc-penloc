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

package es.inteco.xbrl.lenlocpenloc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.xerces.util.XMLCatalogResolver;

import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLENLOCException;

/**
 * 
 * 
 * Clase de configuración utilizada por la API para determinar la localización
 * de los recursos y otro tipo de propiedades las cuales deben ser configuradas
 * mediante un archivo de configuración. <br /><br /> El archivo de
 * configuración está ubicado en el directorio config y se llama
 * enloc.properties. Este archivo contiene una serie de propiedades necesarias
 * para el funcionamiento del sistema en general. <br /><br />
 * <ul>
 * <li>
 * taxonomyRoot: identifica el directorio raíz de la taxonomía.</li>
 * <li>
 * basePath: directorio raíz en el cual ha sido instalada la API. En este
 * directorio se encontrarán todos los recursos necesarios, es decir, los
 * archivos .cmd para línea de comando así como los directorios config, lib,
 * properties, resources con sus contenidos.</li>
 * <li>
 * tempDirectory: directorio temporal, necesario para guardar ficheros de modo
 * temporal, necesario para los procesos realizados por el sistema.</li>
 * <li>
 * schemaLocationIOInterface: schemaLocation de los XML de entrada en formato
 * común, necesario para poder resolver la localización del esquema con el cual
 * será validado.</li>
 * </ul>
 * 
 * Esta clase, además de proporcionar acceso a las propiedades previamente
 * mencionadas y que se encuentran en el archivo de configuración
 * enloc.properties, provee otras propiedades compuestas a partir de éstas.
 * Dichas propiedades son comentadas en sus respectivos métodos de acceso a las
 * mismas.
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

public class XbrlApiConfiguration {

	private static final Logger logger = Logger.getLogger(XbrlApiConfiguration.class);

	private static final String PROPERTY_FILE = "enloc.properties";
	// private static final String XSL_TRANSFORMATION_EXECUTABLE_BAT_FILE =
	// "runXslTransformer.bat";

	private String taxonomyRoot = null;

	private String m_coreRoot = null;
	private String mapsPath = null;
	private String globalPath = null;
	private String taxonomyConfigurationFile = null;
	private String tempDirectory = null;
	private String xslTransformerPath = null;
	private String schemaLocationIOInterface = null;
	private XMLCatalogResolver resolver = null;
	private String enlocErrorsCatalogPath = null;
	private String configLocale = "en";

	private static XbrlApiConfiguration config = null;

	/* Constructor */
	private XbrlApiConfiguration() {
		super();
	}

	/**
	 * Este método se encarga de crear una única instancia inicalizando la misma
	 * con las propiedades que serán publicadas.
	 * 
	 * @throws XBRLENLOCException si se produce un error.
	 * 
	 */
	private static void initialize() {
		config = new XbrlApiConfiguration();
		Properties enlocProperties = new Properties();
		try {
			// Carga el fichero de configuración con las propiedades
			// File c = new File ("Pruebas.txt");
			// c.createNewFile();
			// System.out.println(c.getAbsolutePath());
			ClassLoader cl = XbrlApiConfiguration.class.getClassLoader();
			enlocProperties.load(new FileInputStream(new File(cl.getResource(PROPERTY_FILE).toURI())));

			config.setTaxonomyRoot(prepareTaxonomyRoot(enlocProperties.getProperty("taxonomyRoot")));
			config.setBasePath(enlocProperties.getProperty("basePath"));
			config.setTempDirectory(enlocProperties.getProperty("tempDirectory"));
			config.setSchemaLocationIOInterface(enlocProperties.getProperty("schemaLocationIOInterface"));
			if(enlocProperties.getProperty("configLocale") != null) {
				config.setConfigLocale(enlocProperties.getProperty("configLocale"));
			}

		} catch(FileNotFoundException e) {
			logger.fatal(e);
		} catch(IOException e) {
			logger.fatal(e);
		} catch(URISyntaxException e) {
			logger.fatal(e);
		} catch(XBRLENLOCException e) {
			logger.fatal(e);
		}
	}

	static {
		initialize();
	}

	/**
	 * Devuelve una instancia de configuración, si no ha sido creada aún la crea
	 * para de modo estático de modo que las sucesivas veces que se acceda se
	 * obtenga la misma.
	 * 
	 * @return referencia a la configuración
	 * @throws XBRLENLOCException si se produce un error.
	 * 
	 */
	public static final XbrlApiConfiguration getInstance() {
		if(config == null) {
			initialize();
		}
		return config;

	}

	/**
	 * Devuelve la ruta raíz en el cual se encuentra la taxonomía.
	 * 
	 * @return path ruta de la taxonomía.
	 */
	public final String getTaxonomyRoot() {
		return taxonomyRoot;
	}

	/**
	 * Devuelve el directorio en el cual se encuentran los mapas de
	 * configuración de LENLOCPENLOC2010.
	 * 
	 * @return path de mapas.
	 * 
	 */
	public final String getMapsPath() {

		return mapsPath;
	}

	/**
	 * Devuelve el directorio en el cual se encuentran los recursos necesarios
	 * para poder invocar al transformador XSL.
	 * 
	 * @return path de transformación XSL.
	 * 
	 */
	public final String getXslTransformerPath() {
		return xslTransformerPath;
	}

	/**
	 * Devuelve el path absoluto a la localización del archivo de configuración
	 * global.xml.
	 * 
	 * @return path del archivo global.xml
	 * 
	 */
	public final String getGlobalPath() {
		return globalPath;
	}

	private final void setBasePath(String m_basePath) throws XBRLENLOCException {
		String coreRootRelative = m_basePath;

		Class<? extends XbrlApiConfiguration> c = this.getClass();
		URL u = c.getProtectionDomain().getCodeSource().getLocation();
		String fileUri = "";
		try {
			fileUri = URLDecoder.decode(u.getFile(), "UTF-8");
		} catch(UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File f = new File(fileUri);
		String coreRootBeforeChanges = f.getParent();
		if(coreRootRelative != null) {
			coreRootBeforeChanges = coreRootBeforeChanges + coreRootRelative;
		}

		if(!coreRootBeforeChanges.endsWith("\\")) {
			coreRootBeforeChanges += "\\";
		}

		m_coreRoot = ENLOCUtils.replace(coreRootBeforeChanges, "\\", "/");
		m_coreRoot = ENLOCUtils.replace(m_coreRoot, "//", "/");

		File coreRootPath = new File(m_coreRoot + "");
		if(!coreRootPath.exists()) {
			coreRootBeforeChanges = f.getAbsolutePath();
			if(coreRootRelative != null) {
				coreRootBeforeChanges = coreRootBeforeChanges + coreRootRelative;
			}
			if(!coreRootBeforeChanges.endsWith("\\")) {
				coreRootBeforeChanges += "\\";
			}
			m_coreRoot = ENLOCUtils.replace(coreRootBeforeChanges, "\\", "/");
			m_coreRoot = ENLOCUtils.replace(m_coreRoot, "//", "/");
		}
		try {

			/* LENLOC : Nuestro directorio de maps */
			mapsPath = ENLOCUtils.getFullPath(m_coreRoot + "\\resources\\ENLOCMaps\\");
			/* LENLOC */
			mapsPath = ENLOCUtils.replace(mapsPath, "\\", "/");
			mapsPath = ENLOCUtils.replace(mapsPath, "//", "/");
			xslTransformerPath = ENLOCUtils.getFullPath(m_coreRoot + "\\resources\\XSLTransformer\\");
			xslTransformerPath = ENLOCUtils.replace(xslTransformerPath, "\\", "/");
			xslTransformerPath = ENLOCUtils.replace(xslTransformerPath, "//", "/");

			globalPath = ENLOCUtils.getFullPath(m_coreRoot + "\\config\\global.xml");
			globalPath = ENLOCUtils.replace(globalPath, "\\", "/");
			globalPath = ENLOCUtils.replace(globalPath, "//", "/");

			taxonomyConfigurationFile = ENLOCUtils.getFullPath(m_coreRoot + "\\config\\TaxonomyConfiguration.xml");
			taxonomyConfigurationFile = ENLOCUtils.replace(taxonomyConfigurationFile, "\\", "/");
			taxonomyConfigurationFile = ENLOCUtils.replace(taxonomyConfigurationFile, "//", "/");

			String catalogFile = ENLOCUtils.getFullPath(m_coreRoot + "\\config\\catalog.xml");
			catalogFile = ENLOCUtils.replace(catalogFile, "\\", "/");
			catalogFile = ENLOCUtils.replace(catalogFile, "//", "/");

			resolver = getCatalog(catalogFile);

			/* LENLOC : Validación contra nuestra taxonomía */
			enlocErrorsCatalogPath = ENLOCUtils.getFullPath(m_coreRoot + "\\config\\lenlocpenloc2010-errors.xml");
			/* LENLOC */
			enlocErrorsCatalogPath = ENLOCUtils.replace(enlocErrorsCatalogPath, "\\", "/");
			enlocErrorsCatalogPath = ENLOCUtils.replace(enlocErrorsCatalogPath, "//", "/");
		} catch(XBRLENLOCException e) {
			throw new XBRLENLOCException(XBRLENLOCException.errorResolvingConfigPaths, e.getErrorsHandler(), e);
		}
	}

	private XMLCatalogResolver getCatalog(String catalogFile) {
		if(resolver == null) {
			resolver = new XMLCatalogResolver(new String[] { catalogFile });
		}

		return resolver;
	}

	private final void setTaxonomyRoot(String taxonomyRoot) {
		this.taxonomyRoot = taxonomyRoot;
	}

	/**
	 * Obtiene el path en el que se encuentra el fichero de configuración que
	 * resuelve los paths externos de la taxonomía.
	 * 
	 * @return path ruta del fichero de configuración.
	 */
	public final String getTaxonomyConfigurationFile() {
		return taxonomyConfigurationFile;
	}

	/**
	 * Devuelve el path absoluto al directorio temporal de trabajo.
	 * 
	 * @return path directorio temporal
	 */
	public final String getTempDirectory() {
		return tempDirectory;
	}

	/**
	 * 
	 * Asigna el path absoluto del directorio temporal de trabajo.
	 * 
	 * @param tempDirectory directorio temporal.
	 * 
	 */
	public final void setTempDirectory(String tempDirectory) {
		this.tempDirectory = tempDirectory;
	}

	/**
	 * 
	 * Devuelve la ubicación del esquema contra el que se valida el fichero de
	 * formato común.
	 * 
	 * @return ruta del esquema.
	 * 
	 */
	public final String getSchemaLocationIOInterface() {
		return schemaLocationIOInterface;
	}

	/**
	 * 
	 * 
	 * Asigna la ubicación del esquema contra el que se valida el fichero de
	 * formato común.
	 * 
	 * @param schemaLocationIOInterface ruta del esquema.
	 * 
	 */
	public final void setSchemaLocationIOInterface(String schemaLocationIOInterface) {
		this.schemaLocationIOInterface = schemaLocationIOInterface;
	}

	/**
	 * 
	 * 
	 * Devuelve el objeto resolver del catálogo.
	 * 
	 * @return objeto XMLCatalogResolver.
	 * 
	 */
	public final XMLCatalogResolver getResolver() {
		return resolver;
	}

	/**
	 * 
	 * Devuelve la ruta del catálogo de errores.
	 * 
	 * @return ruta del catálogo.
	 * 
	 */
	public final String getENLOCErrorsCatalogPath() {
		return enlocErrorsCatalogPath;
	}

	/**
	 * @param configLocale the configLocale to set
	 */
	public void setConfigLocale(String configLocale) {
		this.configLocale = configLocale;
	}

	/**
	 * @return the configLocale
	 */
	public String getConfigLocale() {
		return configLocale;
	}

	/**
	 * Convertimos la ruta para la taxonomia que se indica en enloc.properties
	 * en una ruta absoluta para que nuestra aplicación pueda funcionar
	 * correctamente.
	 * 
	 * @param originalProperty ruta de taxonomia leida de enloc.properties
	 * @return ruta de taxonomia en path absoluto
	 */
	private static String prepareTaxonomyRoot(String originalProperty) {
		String returnValue = originalProperty;

		try {
			// logger.debug("readed taxonomy root from properties file: " +
			// originalProperty);
			String newValue = originalProperty;

			File file = new File(newValue);
			file = file.getAbsoluteFile();

			newValue = file.getAbsoluteFile().getAbsolutePath();

			newValue = newValue.replace('\\', '/');
			if(!(newValue.endsWith("/"))) {
				newValue += "/";
			}

			returnValue = newValue;
		} catch(Exception e) {
			// registro el error pero no paro la aplicación. Intentaré ejecutar
			// con el parámetro original
			logger.error(e.getMessage());
		}

		// logger.debug("working with this taxonomy root: " + returnValue);
		return returnValue;

	}
}