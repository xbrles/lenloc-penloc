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

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import es.inteco.xbrl.lenlocpenloc.config.ConfigurationManager;

/**
 * 
 * 
 * Clase que traduce los errores de ENLOC. Se encarga de buscar todos los
 * valores posibles en los mapas de ENLOC y añadir los identificadores obtenidos
 * entre paréntesis al lado de los parámetros traducidos. <br /> Por ejemplo, si
 * un parámetro contiene UnidadesTupla, el resultado sería
 * UnidadesTupla(0900000)
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

public class ENLOCErrorParamTranslate implements IErrorParamTranslate {

	private static final Logger logger = Logger.getLogger(ENLOCErrorParamTranslate.class);

	private String reportID = null;

	/**
	 * Constructor
	 * 
	 * @param reportID Identificador de report
	 */
	public ENLOCErrorParamTranslate(String reportID) {
		this.reportID = reportID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.errors.IErrorParamTranslate#translate(java
	 * .lang.String )
	 */
	public String translate(String param) {

		String transError = null;
		StringBuffer sb = new StringBuffer();
		try {
			Pattern p = Pattern.compile("([a-zA-Z_.0-9]+)");
			Matcher m = p.matcher(param);

			boolean result = m.find();
			while(result) {
				// String conceptName = param.substring(m.start(), m.end());
				String[] concept = param.split(":");
				String code = null;
				String conceptName = "";
				if(concept.length == 2) {
					String prefix = concept[0];
					conceptName = concept[1];

					code = ConfigurationManager.getInstance().getInfoToTranslate(reportID, null, prefix, conceptName);
				}
				if(code != null) {

					transError = conceptName + "(" + code + ")";
					m.appendReplacement(sb, transError);
					logger.debug("Traduciendo código " + conceptName + "=" + transError);
				}

				result = m.find();
			}
			m.appendTail(sb);

		} catch(Exception e) {
			logger.error(e);
		}

		transError = sb.toString();

		return transError;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.errors.IErrorParamTranslate#getENLOCCode(
	 * java.lang.String)
	 */
	public String getENLOCCode(String param) {
		ArrayList<String> arrCodes = new ArrayList<String>();
		ArrayList<String> moduleNotDimension = new ArrayList<String>();
		moduleNotDimension.add("lenloc2");
		moduleNotDimension.add("penloc2-ord");
		String transError = null;
		StringBuffer sb = new StringBuffer();
		try {

			Pattern p = Pattern.compile("([a-zA-Z_.0-9]+)");
			Matcher m = p.matcher(param);
			boolean prefixConceptFind = false;
			boolean result = m.find();
			while(result) {
				String code = null;
				if(param.indexOf("#") != -1) {
					String uriPrefix = "http://www.meh.es/taxonomias/";
					if (param.startsWith(uriPrefix)) {
						String prefix = param.substring(uriPrefix.length(), param.indexOf("#"));
						String conceptName = param.substring(param.indexOf("#")+1,param.indexOf(";"));
						if (!moduleNotDimension.contains(prefix)) {
							prefixConceptFind = true;
						}	
						code = ConfigurationManager.getInstance().getInfoToTranslate(reportID, null, prefix,conceptName);
					}
					if (!prefixConceptFind) {
						String conceptName = param.substring(m.start(), m.end());
						code = ConfigurationManager.getInstance().getInfoToTranslate(reportID, null, conceptName);
					}
				} else {
					String[] concept = param.split(":");
					if(concept.length == 2) {
						String prefix = concept[0];
						String conceptName = concept[1];
						code = ConfigurationManager.getInstance().getInfoToTranslate(reportID, null, prefix,
						        conceptName);
					}
				}

				if(code != null) {
					arrCodes.add(code);
				}
				if (code != null && prefixConceptFind) {
					result = false;
				}
				else {
					result = m.find();
				}	
			}
			m.appendTail(sb);

		} catch(Exception e) {
			logger.error(e);
		}

		if(arrCodes.size() > 0) {
			transError = arrCodes.toString().substring(1, arrCodes.toString().length() - 1);
		}
		return transError;
	}

}