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

package es.inteco.xbrl.lenlocpenloc.viewer;

import java.util.ArrayList;

import es.inteco.xbrl.lenlocpenloc.errors.exceptions.ViewerException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLENLOCException;

/**
 * 
 * 
 * Interfaz que implementa un visualizador de ENLOC.
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

public interface IENLOCViewer {

	/**
	 * Visualiza el módulo indicado de un informe XBRL dado, dicho informe se
	 * encuentra en la ruta del sistema indicada en el parámetro inputPath.
	 * 
	 * Para proporcionar la visualización genera un documento con formato html,
	 * devolviéndolo en la ruta del sistema indicada por el parámetro
	 * outputPath.
	 * 
	 * @param inputPath ruta en la cual se encuentra el informe XBRL a
	 *        visualizar
	 * 
	 * @param module módulo a visualizar
	 * 
	 * @param outputPath ruta en la cual se dejará el resultado
	 * 
	 * @throws ViewerException - Si se produce un error durante el proceso de Visualización
	 */
	public abstract void view(String inputPath, String module, String outputPath) throws ViewerException;

	/**
	 * Visualiza el módulo indicado de un informe XBRL, dado mediante un array
	 * de bytes.
	 * 
	 * Para proporcionar la visualización genera un documento con formato html
	 * devolviéndolo en un array de bytes.
	 * 
	 * @param inputDocument array de bytes con el informe XBRL
	 * 
	 * @param module identificador del módulo a visualizar
	 * 
	 * @return array de bytes con el documento html generado
	 * 
	 * @throws ViewerException - Si se produce un error durante el proceso de Visualización
	 */
	public abstract byte[] view(byte[] inputDocument, String module) throws XBRLENLOCException;

	/**
	 * Visualiza el módulo indicado de un informe en formato común (XML) dado,
	 * dicho informe se encuentra en la ruta del sistema indicada en el
	 * parámetro inputPath.
	 * 
	 * Para proporcionar la visualización genera un documento con formato html,
	 * devolviéndolo en la ruta del sistema indicada por el parámetro
	 * outputPath.
	 * 
	 * @param inputPath ruta en la cual se encuentra el informe a visualizar
	 * 
	 * @param module módulo a visualizar
	 * 
	 * @param outputPath ruta en la cual se dejará el resultado
	 * 
	 * @throws ViewerException - Si se produce un error durante el proceso de Visualización
	 */
	public abstract void viewXML(String inputPath, String module, String outputPath) throws ViewerException;

	/**
	 * Visualiza el módulo indicado de un informe en formato común (XML), dado
	 * mediante un array de bytes.
	 * 
	 * Para proporcionar la visualización genera un documento con formato html
	 * devolviéndolo en un array de bytes.
	 * 
	 * @param inputDocument array de bytes con el informe
	 * 
	 * @param module identificador del módulo a visualizar
	 * 
	 * @return array de bytes con el documento html generado
	 * 
	 * @throws XBRLENLOCException
	 */
	public abstract byte[] viewXML(byte[] inputDocument, String module) throws ViewerException;

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