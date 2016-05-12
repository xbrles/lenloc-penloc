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

package es.inteco.xbrl.lenlocpenloc.errors;

import java.io.FileReader;
import java.util.HashMap;

import org.apache.log4j.Logger;

import es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCErrorsCatalog;
import es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLENLOCException;
import es.inteco.xbrl.lenlocpenloc.utils.XbrlApiConfiguration;

/**
 * 
 * 
 * Clase que gestiona el acceso al catálogo de errores de XBRL-LENLOCPENLOC2010.
 * 
 * <br>
 * 
 * El catálogo consiste en una recopilación de todos los errores que se pueden
 * generar al invocar los servicios de XBRL-LENLOCPENLOC2010, así como una
 * codificación y clasificación de los mismos.
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

public class ErrorsCatalogManager {

	private static final Logger logger = Logger.getLogger(ErrorsCatalogManager.class);

	private static ErrorsCatalogManager manager = null;

	private final HashMap<String, ENLOCError> indexErrorsCatalog = new HashMap<String, ENLOCError>();

	/**
	 * Constructor
	 */
	public ErrorsCatalogManager() {

		try {
			String configLocale = XbrlApiConfiguration.getInstance().getConfigLocale();
			FileReader reader = new FileReader(XbrlApiConfiguration.getInstance().getENLOCErrorsCatalogPath());
			ENLOCErrorsCatalog errorsCatalog = ENLOCErrorsCatalog.unmarshal(reader);
			reader.close();

			int numErros = errorsCatalog.getENLOCErrorCount();

			for(int i = 0; i < numErros; i++) {
				ENLOCError currentError = errorsCatalog.getENLOCError(i);
				if(currentError.getLang().equals(configLocale)) {
					indexErrorsCatalog.put(currentError.getId(), currentError);
				}
			}

		} catch(Throwable e) {
			logger.error(e);
		}

	}

	/**
	 * Metodo inicializador
	 * 
	 * @throws XBRLENLOCException se produce un error general al inicializar
	 */
	private synchronized static void initialize() throws XBRLENLOCException {
		if(manager == null) {
			manager = new ErrorsCatalogManager();
		}
	}

	/**
	 * Devuelve una instancia de la propia clase
	 * 
	 * @return instancia de la clase ErrorsCatalogManager
	 * @throws XBRLENLOCException se produce error general al obtener el catálogo
	 */
	public static final ErrorsCatalogManager getInstance() throws XBRLENLOCException {
		if(manager == null) {
			initialize();
		}

		return manager;
	}

	/**
	 * Devuelve un error a partir de un ID
	 * 
	 * @param errorID Id del error
	 * 
	 * @return error de tipo ENLOCError
	 */
	public ENLOCError getError(String errorID) {
		return indexErrorsCatalog.get(errorID);
	}

}