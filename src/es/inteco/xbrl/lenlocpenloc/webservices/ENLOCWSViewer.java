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

package es.inteco.xbrl.lenlocpenloc.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import es.inteco.xbrl.lenlocpenloc.errors.exceptions.ViewerException;
import es.inteco.xbrl.lenlocpenloc.viewer.ENLOCViewer;
import es.inteco.xbrl.lenlocpenloc.viewer.IENLOCViewer;

/**
 * 
 * 
 * Clase que implementa un WebService para visualizar informes en HTML desde un
 * documento en formato XML o XBRL.
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
 * @version 1.0, 18/09/2009
 * @author difusioncalidad@inteco.es
 * 
 */

@WebService ()
public class ENLOCWSViewer {

	static Logger logger = Logger.getLogger(ENLOCViewer.class);
	public static final String LENLOC_XBRL_MODULO_DI = "DI";
	public static final String LENLOC_XBRL_MODULO_A1 = "A1";
	public static final String LENLOC_XBRL_MODULO_A2 = "A2";
	public static final String LENLOC_XBRL_MODULO_A3P = "A3P";
	public static final String LENLOC_XBRL_MODULO_A3R = "A3R";
	public static final String LENLOC_XBRL_MODULO_A4EA = "A4EA";
	public static final String LENLOC_XBRL_MODULO_A4RA = "A4RA";
	public static final String LENLOC_XBRL_MODULO_A5 = "A5";
	public static final String LENLOC_XBRL_MODULO_GAST = "GAST";
	public static final String LENLOC_XBRL_MODULO_ING = "ING";
	public static final String LENLOC_XBRL_MODULO_CB = "CB";
	public static final String LENLOC_XBRL_MODULO_ACR = "ACR";
	public static final String LENLOC_XBRL_MODULO_DEU = "DEU";
	public static final String LENLOC_XBRL_MODULO_PROG = "PROG";
	public static final String LENLOC_XBRL_MODULO_RT = "RT";
	public static final String LENLOC_XBRL_MODULO_RP = "RP";
	public static final String LENLOC_XBRL_MODULO_RPA = "RPA";

	/**
	 * Web service operation
	 */
	@WebMethod (operationName = "view")
	public ViewerResponse view(@WebParam (name = "request") ViewerRequest request) {
		byte[] htmlResult = null;
		IENLOCViewer viewer;
		ViewerResponse result = new ViewerResponse();
		logger.debug("Running WebService XBRL Viewer - view");

		// Iniciamos el proceso de visualizacion
		try {
			viewer = ENLOCViewer.createInstance();
			htmlResult = viewer.view(request.getInputDocument(), request.getModulo());
			result.setHtml(htmlResult);
			result.setEjecucionOk(true);
		} catch(ViewerException e) {
			result.setEjecucionOk(false);
			result.setErrorMessage(e.getMessage());
			e.printStackTrace();
			logger.error("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			result.setEjecucionOk(false);
			result.setErrorMessage(e1.getMessage());
			e1.printStackTrace();
			logger.error("Se ha producido una excepcion no esperada " + e1.getMessage());
		}
		return result;
	}

	/**
	 * Web service operation
	 */
	@WebMethod (operationName = "viewXML")
	public ViewerResponse viewXML(@WebParam (name = "request") ViewerRequest request) {
		byte[] htmlResult = null;
		IENLOCViewer viewer;
		ViewerResponse result = new ViewerResponse();
		logger.debug("Running WebService XBRL Viewer - viewXML");

		// Iniciamos el proceso de visualizacion
		try {
			viewer = ENLOCViewer.createInstance();
			htmlResult = viewer.viewXML(request.getInputDocument(), request.getModulo());
			result.setHtml(htmlResult);
			result.setEjecucionOk(true);
		} catch(ViewerException e) {
			result.setEjecucionOk(false);
			result.setErrorMessage(e.getMessage());
			e.printStackTrace();
			logger.error("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			result.setEjecucionOk(false);
			result.setErrorMessage(e1.getMessage());
			e1.printStackTrace();
			logger.error("Se ha producido una excepcion no esperada " + e1.getMessage());
		}
		return result;
	}

}
