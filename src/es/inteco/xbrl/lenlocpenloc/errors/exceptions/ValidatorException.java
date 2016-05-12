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

import java.io.StringReader;

import es.inteco.xbrl.lenlocpenloc.errors.GenericErrorsHandler;
import es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorsOutput;

/**
 * 
 * Clase base utilizada para notificar los errores de validación.
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

public class ValidatorException extends XBRLENLOCException {

	private static final long serialVersionUID = 1L;

	/**
	 * Crea una excepción con un identificador, el cual corresponderá a una de
	 * las constantes definidas.
	 * 
	 * @param message constante correspondiente al mensaje
	 * 
	 * @param cause mensaje de la excepción original
	 * 
	 */
	public ValidatorException(String message, Throwable cause) {
		super(message, cause);

		// valoro lo que llega en messageIn
		if(ValidatorException.isENLOCErrorsOutput(message)) {
			// si ya llegaba bien, deshago lo que ha hecho super
			this.message = message;
		}
	}

	/**
	 * Crea una excepción con un identificador, el cual corresponderá a una de
	 * las constantes definidas, con los parámetros necesarios para completar el
	 * mensaje de error.
	 * 
	 * @param messageIn constante correspondiente al mensaje
	 * 
	 * @param parameters parámetros para completar el mensaje
	 * 
	 * @param cause mensaje de la excepción original
	 * 
	 */
	public ValidatorException(String messageIn, String[] parameters, Throwable cause) {
		super(messageIn, parameters, cause);

		// valoro lo que llega en messageIn
		if(ValidatorException.isENLOCErrorsOutput(messageIn)) {
			// si ya llegaba bien, deshago lo que ha hecho super
			this.message = messageIn;
		}
	}

	/**
	 * Crea una excepción sin indicar la causa de la excepción.
	 * 
	 * @param messageIn constante correspondiente al mensaje de error
	 * 
	 * @param parameters parámetros para completar el mensaje de error
	 * 
	 */
	public ValidatorException(String messageIn, String[] parameters) {
		super(messageIn, parameters);

		// valoro lo que llega en messageIn
		if(ValidatorException.isENLOCErrorsOutput(messageIn)) {
			// si ya llegaba bien, deshago lo que ha hecho super
			this.message = messageIn;
		}
	}

	/**
	 * Crea una excepción con un identificador, el cual corresponderá a una de
	 * las constantes definidas.
	 * 
	 * @param messageIn constante correspondiente al mensaje.
	 * 
	 * @param errorsHandler contiene los errores propagados hasta llegar a esta
	 *        excepción.
	 * 
	 * @param cause mensaje de la excepción original.
	 * 
	 */
	public ValidatorException(String messageIn, GenericErrorsHandler errorsHandler, Throwable cause) {
		super(messageIn, errorsHandler, cause);

		// valoro lo que llega en messageIn
		if(ValidatorException.isENLOCErrorsOutput(messageIn)) {
			// si ya llegaba bien, deshago lo que ha hecho super
			this.message = messageIn;
		}
	}

	/**
	 * Crea una excepción con un identificador, el cual corresponderá a una de
	 * las constantes definidas, con los parámetros necesarios para completar el
	 * mensaje de error.
	 * 
	 * @param messageIn constante correspondiente al mensaje.
	 * 
	 * @param parameters parámetros para completar el mensaje
	 * 
	 * @param errorsHandler contiene los errores propagados hasta llegar a esta
	 *        excepción.
	 * 
	 */
	public ValidatorException(String messageIn, String[] parameters, GenericErrorsHandler errorsHandler) {
		super(messageIn, parameters, errorsHandler);

		// valoro lo que llega en messageIn
		if(ValidatorException.isENLOCErrorsOutput(messageIn)) {
			// si ya llegaba bien, deshago lo que ha hecho super
			this.message = messageIn;
		}
	}

	/**
	 * Crea una excepción con un identificador, el cual corresponderá a una de
	 * las constantes definidas.
	 * 
	 * @param message constante correspondiente al código del mensaje
	 * 
	 * @param errorsHandler contiene los errores propagados hasta llegar a esta
	 *        excepción.
	 * 
	 */
	public ValidatorException(String message, GenericErrorsHandler errorsHandler) {
		super(message, errorsHandler);
	}

	private static boolean isENLOCErrorsOutput(String text) {
		boolean returnValue = false;

		java.io.Reader txtReader = null;
		try {
			txtReader = new StringReader(text);
			ENLOCErrorsOutput.unmarshal(txtReader);
			returnValue = true;
		} catch(Throwable ex) {
		} finally {
			try {
				txtReader.close();
			} catch(Exception e1) {
			}
		}
		return returnValue;
	}

}