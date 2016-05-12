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

import java.io.IOException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import es.inteco.xbrl.lenlocpenloc.errors.exceptions.TransformException;

import es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer;
import es.inteco.xbrl.lenlocpenloc.transform.IENLOCTransformer;

/**
 * 
 * 
 * Esta clase implementa un WebService para llamar al transformador ENLOC. Este
 * transformador cumple con los requerimientos definidos y documentados por el
 * interfaz IENLOCTransformer.
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
 * @version 1.0, 19/09/2009
 * @author difusioncalidad@inteco.es
 * 
 */
@WebService ()
public class ENLOCWSTransformer {

	static Logger logger = Logger.getLogger(ENLOCTransformer.class);

	/**
	 * Web service operation
	 */
	@WebMethod (operationName = "transformToXML")
	public TransformerResponse transformToXML(@WebParam (name = "request") TransformerRequest request)
	        throws IOException {

		IENLOCTransformer transformer;
		TransformerResponse resultado = new TransformerResponse();
		byte[] outputDocument = null;
		logger.debug("Running WebService XBRL Transformer - transformToXML");

		// inicio del proceso de transformacion
		try {
			transformer = ENLOCTransformer.createInstance();
			outputDocument = transformer.transformToXml(request.getInputDocument(), request.isValidarXBRL());
			resultado.setOutputFile(outputDocument);
			resultado.setEjecucionOk(true);
		} catch(TransformException e) {
			resultado.setEjecucionOk(false);
			resultado.setErrorMessage(e.getMessage());
			e.printStackTrace();
			logger.error("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			resultado.setEjecucionOk(false);
			resultado.setErrorMessage(e1.getMessage());
			e1.printStackTrace();
			logger.error("Se ha producido una excepcion no esperada " + e1.getMessage());
		}
		return resultado;
	}

	/**
	 * Web service operation
	 */
	@WebMethod (operationName = "transformToXBRL")
	public TransformerResponse transformToXBRL(@WebParam (name = "request") TransformerRequest request)
	        throws IOException {
		IENLOCTransformer transformer;
		TransformerResponse resultado = new TransformerResponse();
		byte[] outputDocument = null;
		logger.debug("Running WebService XBRL Transformer - transformToXBRL");

		// inicio del proceso de transformacion
		try {
			transformer = ENLOCTransformer.createInstance();
			outputDocument = transformer.transformToXbrl(request.getInputDocument(), request.isValidarXBRL());
			resultado.setOutputFile(outputDocument);
			resultado.setEjecucionOk(true);
		} catch(TransformException e1) {
			resultado.setEjecucionOk(false);
			resultado.setErrorMessage(e1.getMessage());
			e1.printStackTrace();
			logger.error("Se ha producido un error de transformación no esperado " + e1.getMessage());
		} catch(Exception e2) {
			resultado.setEjecucionOk(false);
			resultado.setErrorMessage(e2.getMessage());
			e2.printStackTrace();
			logger.error("Se ha producido una excepcion no esperada " + e2.getMessage());
		}
		return resultado;
	}

}
