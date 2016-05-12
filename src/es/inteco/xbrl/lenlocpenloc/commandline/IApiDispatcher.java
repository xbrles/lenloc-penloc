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

package es.inteco.xbrl.lenlocpenloc.commandline;

/**
 * Interfaz que debe cumplir una clase que ejecute llamadas a la API en sus
 * funcionalidades básicas.
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
public interface IApiDispatcher {

	/**
	 * Obtiene la ruta y nombre del documento XBRL.
	 * 
	 * @return Ruta y nombre
	 */
	public abstract String getDocXbrlPath();

	/**
	 * Establece la ruta y nombre del documento XBRL.
	 * 
	 * @param docXbrlPath ruta y nombre
	 */
	public void setDocXbrlPath(String docXbrlPath);

	/**
	 * Obtiene la ruta y nombre del documento XML.
	 * 
	 * @return Ruta y nombre
	 */
	public String getDocXMLPath();

	/**
	 * Establece la ruta y nombre del documento XML.
	 * 
	 * @param docXMLPath ruta y nombre
	 */
	public void setDocXMLPath(String docXMLPath);

	/**
	 * Obtiene la ruta y nombre del documento HTML.
	 * 
	 * @return Ruta y nombre del documento HTML
	 */
	public String getDocHTMLPath();

	/**
	 * Establece la ruta y nombre del documento HTML.
	 * 
	 * @param docHTMLPath nombre y ruta
	 */
	public void setDocHTMLPath(String docHTMLPath);

	/**
	 * Obtiene un indicador de si se solicita una validación de XBRL.
	 * 
	 * @return (true/false)
	 */
	public boolean isValidationRequired();

	/**
	 * Establece un indicador de si se solicita una validación de XBRL.
	 * 
	 * @param validationRequired indicador
	 */
	public void setValidationRequired(boolean validationRequired);

	/**
	 * Obtiene el nombre del módulo que se quiere visualizar.
	 * 
	 * @return Nombre de modulo
	 */
	public String getModuleName();

	/**
	 * Establece el nombre del módulo que se quiere visualizar.
	 * 
	 * @param moduleName nombre del modulo
	 */
	public void setModuleName(String moduleName);

	/**
	 * Obtiene ruta y nombre del fichero donde se almacenaran los errores.
	 * 
	 * @return Ruta y nombre
	 */
	public String getErrorFilePath();

	/**
	 * Establece ruta y nombre del fichero donde se almacenaran los errores.
	 * 
	 * @param errorFilePath ruta y nombre
	 */
	public void setErrorFilePath(String errorFilePath);

	/**
	 * Obtiene ruta y nombre del fichero donde se almacenaran los resultados de
	 * validación.
	 * 
	 * @return Ruta y nombre
	 */
	public String getValidationResultFilePath();

	/**
	 * Establece ruta y nombre del fichero donde se almacenaran los resultados
	 * de validación.
	 * 
	 * @param validationResultFilePath ruta y nombre
	 */
	public void setValidationResultFilePath(String validationResultFilePath);

	/**
	 * Método que ejecuta la validación XBRL.
	 * 
	 * @return indicador del resultado del proceso<br>
	 *         <b>0: </b>El proceso finalizó sin errores<br>
	 *         <b>-1: </b>El proceso no finalizó correctamente<br>
	 *         <b>1: </b>El proceso finalizó con errores tipo Warning<br>
	 */
	public abstract int executeXBRLValidation();

	/**
	 * Método que ejecuta la validación XSD.
	 * 
	 * @return indicador del resultado del proceso<br>
	 *         <b>0: </b>El proceso finalizó sin errores<br>
	 *         <b>-1: </b>El proceso no finalizó correctamente<br>
	 *         <b>1: </b>El proceso finalizó con errores tipo Warning<br>
	 */
	public abstract int executeXSDValidation();

	/**
	 * Método que ejecuta la transformación a XML.
	 * 
	 * @return indicador del resultado del proceso<br>
	 *         <b>0: </b>El proceso finalizó sin errores<br>
	 *         <b>-1: </b>El proceso no finalizó correctamente<br>
	 *         <b>1: </b>El proceso finalizó con errores tipo Warning<br>
	 */
	public abstract int executeTransformationToXML();

	/**
	 * Método que ejecuta la transformación a XBRL.
	 * 
	 * @return indicador del resultado del proceso<br>
	 *         <b>0: </b>El proceso finalizó sin errores<br>
	 *         <b>-1: </b>El proceso no finalizó correctamente<br>
	 *         <b>1: </b>El proceso finalizó con errores tipo Warning<br>
	 */
	public abstract int executeTransformationToXBRL();

	/**
	 * Método que ejecuta la visualización de un XML.
	 * 
	 * @return indicador del resultado del proceso<br>
	 *         <b>0: </b>El proceso finalizó sin errores<br>
	 *         <b>-1: </b>El proceso no finalizó correctamente<br>
	 *         <b>1: </b>El proceso finalizó con errores tipo Warning<br>
	 */
	public abstract int executeVisualizationFromXML();

	/**
	 * Método que ejecuta la visualización de un XBRL.
	 * 
	 * @return indicador del resultado del proceso<br>
	 *         <b>0: </b>El proceso finalizó sin errores<br>
	 *         <b>-1: </b>El proceso no finalizó correctamente<br>
	 *         <b>1: </b>El proceso finalizó con errores tipo Warning<br>
	 */
	public abstract int executeVisualizationFromXBRL();

}
