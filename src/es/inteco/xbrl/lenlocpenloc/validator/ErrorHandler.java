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

package es.inteco.xbrl.lenlocpenloc.validator;

import org.apache.log4j.Logger;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import es.inteco.xbrl.lenlocpenloc.errors.GenericErrorsHandler;
import es.inteco.xbrl.lenlocpenloc.utils.ENLOCUtils;

/**
 * 
 * 
 * Clase utilizada como manejador de errores en la validación XSD.
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

public class ErrorHandler extends DefaultHandler {

	private static final Logger logger = Logger.getLogger(XBRLValidator.class);

	private boolean valid = true;
	private GenericErrorsHandler errorHandler = new GenericErrorsHandler();

	/**
	 * Constructor por defecto.
	 */
	public ErrorHandler() {
		super();
	}

	/**
	 * Devuelve la lista de errores en String.
	 * 
	 * @return String con la lista de errores.
	 */
	public String getErrors() {
		return errorHandler.toString();
	}

	/**
	 * Devuelve un indicador de si el documento es válido.
	 * 
	 * @return boolean con el indicador de si el documento es válido.
	 */
	public boolean isValid() {

		return valid;
	}

	/**
	 * Procesa el error de schema.
	 * 
	 * @param exception Excepción analizada
	 */
	private void ctrlError(SAXParseException exception) {
		try {
			ENLOCUtils.processSchemaValidationError(exception.getMessage(), errorHandler);

		} catch(Exception e) {
			logger.error(e);
			valid = false;
		}

		valid = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.xml.sax.helpers.DefaultHandler#error(org.xml.sax.SAXParseException)
	 */
	public void error(SAXParseException exception) {
		ctrlError(exception);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.xml.sax.helpers.DefaultHandler#fatalError(org.xml.sax.SAXParseException
	 * )
	 */
	public void fatalError(SAXParseException exception) {
		ctrlError(exception);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.xml.sax.helpers.DefaultHandler#warning(org.xml.sax.SAXParseException)
	 */
	public void warning(SAXParseException exception) {
		ctrlError(exception);
	}
}