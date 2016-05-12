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

import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLValidatorException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XSDValidatorException;

import es.inteco.xbrl.lenlocpenloc.validator.IXBRLValidator;
import es.inteco.xbrl.lenlocpenloc.validator.ENLOCXBRLValidator;
import es.inteco.xbrl.lenlocpenloc.validator.IXSDValidator;
import es.inteco.xbrl.lenlocpenloc.validator.ValidateResult;
import es.inteco.xbrl.lenlocpenloc.validator.XSDValidator;

/**
 * 
 * 
 * Clase que gestiona la validación de un documento XBRL contra una taxonomía,
 * así como la validación de un documento en XML común contra su esquema, vía
 * Webservice.
 * 
 * Esta clase se compone de dos métodos públicos (WebMethods) mediante los
 * cuales es posible invocar la funcionalidad de validación XBRL y validación
 * XSD, respectivamente.
 * 
 * Devolviendo en ambos casos un objeto que encapsula el resultado de la
 * validación, así como un informe de errores de validación que hayan podido
 * encontrarse.
 * 
 * La validación XBRL está basada en la API de XBreeze, a la cual se accede a
 * través de la funcionalidad que publica la facade implementada para dicha API.
 * 
 * El resultado de la validación consiste en indicar si la instancia es
 * correcta, para ello se utilizará el atributo booleano "valid" que así lo
 * indica en el objeto ValidatorResponse que devuelven estos métodos.
 * 
 * Si durante la validación se detectaron errores, dichos errores serán
 * informados según el formato definido para ello mediante el esquema de errores
 * config/schemas/lenlocpenloc2010-errors-output.xsd.
 * 
 * En dichos errores se informa del código, la descripción por defecto y los
 * parámetros en caso de que los hubiera.
 * 
 * Los errores que se pueden devolver están clasificados en tres tipos, de
 * validación de esquema, validación Xbreeze (XBRL) o errores de la propia API
 * (error de sistema genérico).
 * 
 * Todos los errores quedan catalogados en el fichero
 * lenlocpenloc2010-errors.xml.
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
 * @version 1.0, 20/09/2009
 * @author difusioncalidad@inteco.es
 * 
 */
@WebService ()
public class ENLOCWSValidator {

	static Logger logger = Logger.getLogger(ENLOCXBRLValidator.class);

	/**
	 * Web service operation
	 */
	@WebMethod (operationName = "validateXBRL")
	public ValidatorResponse validateXBRL(@WebParam (name = "request") ValidatorRequest request) {
		IXBRLValidator validadorXbrl;
		ValidateResult resultadoValidacion = null;
		ValidatorResponse response = new ValidatorResponse();
		logger.debug("Running WebService XBRL Validator - validateXBRL");

		// Inicio del proceso de validacion
		try {
			validadorXbrl = ENLOCXBRLValidator.createInstance();
			resultadoValidacion = validadorXbrl.validate(request.getInputDocument());
			response.setEjecucionOk(true);
			response.setValid(resultadoValidacion.isValid());
			response.setErrorMessage(resultadoValidacion.getErrors());
		} catch(XBRLValidatorException e) {
			response.setEjecucionOk(false);
			response.setErrorMessage(e.getMessage());
			e.printStackTrace();
			logger.error("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			response.setEjecucionOk(false);
			response.setErrorMessage(e1.getMessage());
			e1.printStackTrace();
			logger.error("Se ha producido una excepcion no esperada " + e1.getMessage());
		}
		return response;
	}

	/**
	 * Web service operation
	 */
	@WebMethod (operationName = "validateXSD")
	public ValidatorResponse validateXSD(@WebParam (name = "request") ValidatorRequest request) {
		IXSDValidator validadorXsd;
		ValidateResult resultadoValidacion = null;
		ValidatorResponse response = new ValidatorResponse();
		logger.debug("Running WebService XBRL validator - validateXSD");

		// Inicio del proceso de validacion
		try {
			validadorXsd = XSDValidator.createInstance();
			resultadoValidacion = validadorXsd.validate(request.getInputDocument());
			response.setEjecucionOk(true);
			response.setValid(resultadoValidacion.isValid());
			response.setErrorMessage(resultadoValidacion.getErrors());
		} catch(XSDValidatorException e) {
			response.setEjecucionOk(false);
			response.setErrorMessage(e.getMessage());
			e.printStackTrace();
			logger.error("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			response.setEjecucionOk(false);
			response.setErrorMessage(e1.getMessage());
			e1.printStackTrace();
			logger.error("Se ha producido una excepcion no esperada " + e1.getMessage());
		}
		return response;
	}

}
