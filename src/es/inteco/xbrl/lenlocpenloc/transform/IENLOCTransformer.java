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

package es.inteco.xbrl.lenlocpenloc.transform;

import java.util.ArrayList;

import es.inteco.xbrl.lenlocpenloc.errors.exceptions.TransformException;

/**
 * 
 * 
 * La clase principal es ENLOCTransformer, es la clase que contiene los m�todos
 * encargados de realizar los procesos de transformaci�n. Dicha clase se basa en
 * el uso de clases de otros paquetes del sistema. <br /><br /> Los procesos de
 * transformaci�n consisten en convertir los datos proporcionados en formato
 * com�n y pasarlos a XBRL o viceversa. <br /><br /> Antes y despu�s de realizar
 * dichas conversiones, realizar� las validaciones oportunas, bas�ndose en los
 * servicios de validaci�n. <br /><br /> Para realizar las transformaciones,
 * esta clase se apoya en el uso de la librer�a XBReeze, la cual proporciona
 * m�todos y clases para un acceso estructurado a los informes y taxonom�as
 * XBRL.
 * 
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

public interface IENLOCTransformer {

	/**
	 * Realiza la transformaci�n de un documento en formato com�n (XML) a XBRL,
	 * devolviendo la salida en un fichero, cuyo path es indicado en el
	 * par�metro de entrada outputPath. <br /><br /> Antes de realizar la
	 * transformaci�n a XBRL, el transformador comprueba si el XML de entrada en
	 * formato com�n cumple con el esquema definido para tal, realizando una
	 * validaci�n de esquema. <br /><br /> Si se encuentran errores en la
	 * validaci�n, se eleva una excepci�n del tipo XSDValidatorExcetion,
	 * indicando en el mensaje los errores de validaci�n encontrados. <br /><br
	 * /> Una vez finalizada la transformaci�n y antes de devolver la respuesta,
	 * en funci�n del par�metro de entrada validateXbrl se valida la instancia
	 * XBRL. <br /><br /> En el caso de encontrarse errores en la validaci�n del
	 * XBRL, el transformaci�n eleva una excepci�n del tipo
	 * XBRLValidatorException, en cuyo mensaje se encuentran los erroes de
	 * validaci�n encontrados.
	 * 
	 * @param inputPath ruta del documento XML de entrada
	 * 
	 * @param outputPath ruta donde se guardar� el documento respuesta
	 * 
	 * @throws TransformException En el caso de encontrar errores en el
	 *         proceso de transformaci�n
	 * 
	 */
	public abstract void transformToXbrl(String inputPath, String outputPath) throws TransformException;

	/**
	 * Realiza la transformaci�n de un documento en formato com�n (XML) a XBRL,
	 * devolviendo la salida en un fichero, cuyo path es indicado en el
	 * par�metro de entrada outputPath. <br /><br /> Antes de realizar la
	 * transformaci�n a XBRL, el transformador comprueba si el XML de entrada en
	 * formato com�n cumple con el esquema definido para tal, realizando una
	 * validaci�n de esquema. <br /><br /> Si se encuentran errores en la
	 * validaci�n, se eleva una excepci�n del tipo XSDValidatorExcetion,
	 * indicando en el mensaje los errores de validaci�n encontrados. <br /><br
	 * /> Una vez finalizada la transformaci�n y antes de devolver la respuesta,
	 * en funci�n del par�metro de entrada validateXbrl se valida la instancia
	 * XBRL. <br /><br /> En el caso de encontrarse errores en la validaci�n del
	 * XBRL, el transformaci�n eleva una excepci�n del tipo
	 * XBRLValidatorException, en cuyo mensaje se encuentran los erroes de
	 * validaci�n encontrados.
	 * 
	 * @param inputPath ruta del documento XML de entrada
	 * 
	 * @param outputPath ruta donde se guardar� el documento respuesta
	 * 
	 * @param validateXbrl indica si se valida el Xbrl de salida
	 * 
	 * @throws TransformException En el caso de encontrar errores en el
	 *         proceso de transformaci�n
	 * 
	 */
	public abstract void transformToXbrl(String inputPath, String outputPath, boolean validateXbrl)
	        throws TransformException;

	/**
	 * Realiza la transformaci�n de un documento en formato com�n (XML) a XBRL.
	 * El documento XBRL resultado es devuelto como un array de bytes. <br /><br
	 * /> Antes de realizar la transformaci�n a XBRL, el transformador comprueba
	 * si el XML de entrada en formato com�n cumple con el esquema definido para
	 * tal, realizando una validaci�n de esquema. <br /><br /> Si se encuentran
	 * errores en la validaci�n, se eleva una excepci�n del tipo
	 * XSDValidatorExcetion, indicando en el mensaje los errores de validaci�n
	 * encontrados. <br /><br /> Una vez finalizada la transformaci�n y antes de
	 * devolver la respuesta, en funci�n del par�metro de entrada validateXbrl
	 * se valida la instancia XBRL. <br /><br /> En el caso de encontrarse
	 * errores en la validaci�n del XBRL, el transformaci�n eleva una excepci�n
	 * del tipo XBRLValidatorException, en cuyo mensaje se encuentran los erroes
	 * de validaci�n encontrados.
	 * 
	 * @param inputPath Ruta del documento XML de entrada
	 * 
	 * @param validateXbrl Valor booleano que indicar� si se debe validar el
	 *        documento XBRL antes de devolver.
	 * 
	 * @return Objeto con el documento XBRL resultado de la transformaci�n
	 * 
	 * @throws TransformException En el caso de encontrar errores en el
	 *         proceso de transformaci�n
	 */
	public abstract byte[] transformToXbrl(String inputPath, boolean validateXbrl) throws TransformException;

	/**
	 * Realiza la transformaci�n de un documento en formato com�n (XML) a XBRL.
	 * El documento XBRL resultado es devuelto como un array de bytes. <br /><br
	 * /> El documento de entrada es pasado como un array de bytes. Dicho array
	 * se guarda en un archivo temporal antes de continuar con el proceso. <br
	 * /><br /> Antes de realizar la transformaci�n a XBRL, el transformador
	 * comprueba si el XML de entrada en formato com�n cumple con el esquema
	 * definido para tal, realizando una validaci�n de esquema. <br /><br /> Si
	 * se encuentran errores en la validaci�n, se eleva una excepci�n del tipo
	 * XSDValidatorExcetion, indicando en el mensaje los errores de validaci�n
	 * encontrados. <br /><br /> Una vez finalizada la transformaci�n y antes de
	 * devolver la respuesta, en funci�n del par�metro de entrada validateXbrl
	 * se valida la instancia XBRL. <br /><br /> En el caso de encontrarse
	 * errores en la validaci�n del XBRL, el transformaci�n eleva una excepci�n
	 * del tipo XBRLValidatorException, en cuyo mensaje se encuentran los erroes
	 * de validaci�n encontrados.
	 * 
	 * @param inputDocument Array de bytes con el documento XML de entrada
	 * 
	 * @param validateXbrl Valor booleano que indicar� si se debe validar el
	 *        documento XBRL antes de devolver.
	 * 
	 * @return Array de bytes con el documento XBRL resultado de la
	 *         transformaci�n
	 * 
	 * @throws TransformException En el caso de encontrar errores en el
	 *         proceso de transformaci�n
	 */
	public abstract byte[] transformToXbrl(byte[] inputDocument, boolean validateXbrl) throws TransformException;

	/**
	 * Realiza la transformaci�n de un documento XBRL a un documento XML en
	 * formato com�n, validando previamente el documento XBRL de entrada si es
	 * cierto el par�metro de entrada validateXbrl. <br /><br /> Si el documento
	 * de entrada contiene errores de validaci�n XBRL y se ha indicado que se
	 * haga la validaci�n XBRL previa a la transformaci�n, el transformaci�n
	 * eleva una exceci�n XBRLValidatorException indicando en el mensaje los
	 * errores de validaci�n encontrados. <br /><br /> Una vez finalizada la
	 * transformaci�n, se hace una verficaci�n del XML de salida. Si se detecta
	 * alg�n error en la validaci�n de dicho XML, se eleva una excepci�n
	 * XSDValidatorException, indicando en el mensaje de error los errores
	 * encontrados.
	 * 
	 * 
	 * 
	 * @param inputPath Ruta del documento XBRL de entrada.
	 * 
	 * @param outputPath Ruta donde se guardar� el documento XML de respuesta.
	 * 
	 * @param validateXbrl Valor booleano que indicar� si se debe validar el
	 *        documento XBRL de entrada, previamente a su transformaci�n.
	 * 
	 * @throws TransformException En el caso de encontrar errores en el
	 *         proceso de transformaci�n
	 */
	public abstract void transformToXml(String inputPath, String outputPath, boolean validateXbrl)
	        throws TransformException;

	/**
	 * Realiza la transformaci�n de un documento XBRL a un documento XML en
	 * formato com�n, validando previamente el documento XBRL de entrada si es
	 * cierto el par�metro de entrada validateXbrl. <br /><br /> Si el documento
	 * de entrada contiene errores de validaci�n XBRL y se ha indicado que se
	 * haga la validaci�n XBRL previa a la transformaci�n, el transformaci�n
	 * eleva una exceci�n XBRLValidatorException indicando en el mensaje los
	 * errores de validaci�n encontrados. <br /><br /> Una vez finalizada la
	 * transformaci�n, se hace una verficaci�n del XML de salida. Si se detecta
	 * alg�n error en la validaci�n de dicho XML, se eleva una excepci�n
	 * XSDValidatorException, indicando en el mensaje de error los errores
	 * encontrados. <br /><br /> La respuesta la devuelve como un array de bytes
	 * conteniendo el documento generado.
	 * 
	 * 
	 * 
	 * @param inputPath Ruta del documento XBRL de entrada
	 * 
	 * @param validateXbrl valor booleano que indicar� si se debe validar el
	 *        documento XBRL de entrada, previamente a su transformaci�n.
	 * 
	 * @return Devuelve un documento con el resultado de la transformaci�n.
	 * 
	 * @throws TransformException En el caso de encontrar errores en el
	 *         proceso de transformaci�n
	 */
	public abstract byte[] transformToXml(String inputPath, boolean validateXbrl) throws TransformException;

	/**
	 * Realiza la transformaci�n de un documento XBRL a un documento XML en
	 * formato com�n, validando previamente el documento XBRL de entrada si es
	 * cierto el par�metro de entrada validateXbrl. <br /><br />
	 * 
	 * El documento de entrada estar� contenido en un array de bytes. <br /><br
	 * />
	 * 
	 * Si el documento de entrada contiene errores de validaci�n XBRL y se ha
	 * indicado que se haga la validaci�n XBRL previa a la transformaci�n, el
	 * transformaci�n eleva una exceci�n XBRLValidatorException indicando en el
	 * mensaje los errores de validaci�n encontrados. <br /><br />
	 * 
	 * Una vez finalizada la transformaci�n, se hace una verficaci�n del XML de
	 * salida. Si se detecta alg�n error en la validaci�n de dicho XML, se eleva
	 * una excepci�n XSDValidatorException, indicando en el mensaje de error los
	 * errores encontrados. <br /><br />
	 * 
	 * La respuesta la devuelve como un array de bytes conteniendo el documento
	 * generado.
	 * 
	 * 
	 * @param inputDocument array de bytes con el documento de entrada
	 * 
	 * @param validateXbrl valor booleano que indicar� si se debe validar el
	 *        documento XBRL de entrada, previamente a su transformaci�n.
	 * 
	 * @return Devuelve un documento con el resultado de la transformaci�n.
	 * 
	 * @throws TransformException En el caso de encontrar errores en el
	 *         proceso de transformaci�n
	 */
	public abstract byte[] transformToXml(byte[] inputDocument, boolean validateXbrl) throws TransformException;

	/**
	 * Obtiene la lista destinada a almacenar warnings o errores que llegan al
	 * logger durante el proceso
	 * 
	 * @return ArrayList de String
	 */
	public ArrayList<String> getLoggerTraceList();

	/**
	 * Establece la lista destinada a almacenar warnings o errores que llegan al
	 * logger durante el proceso
	 * 
	 * @param loggerList ArrayList de String
	 */
	public void setLoggerTraceList(ArrayList<String> loggerList);

}