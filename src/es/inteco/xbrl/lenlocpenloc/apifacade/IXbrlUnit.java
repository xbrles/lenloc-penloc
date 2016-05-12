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

package es.inteco.xbrl.lenlocpenloc.apifacade;

/**
 * 
 * Interfaz que debe cumplir una clase que pretende encapsular un objeto XBRL
 * del tipo Unit
 * 
 * <br>
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

public interface IXbrlUnit {

	/**
	 * Devuelve el key de un unit
	 * 
	 * @return key del unit
	 */
	public abstract String getKey();

	/**
	 * Establece el key de un unit
	 * 
	 * @param key key del unit
	 */
	public abstract void setKey(String key);

	/**
	 * Devuelve el code de un unit
	 * 
	 * @return code del unit
	 */
	public abstract String getCode();

	/**
	 * Establece el code de un unit
	 * 
	 * @param code code del unit
	 */
	public abstract void setCode(String code);

	/**
	 * Devuelve el prefijo de un unit
	 * 
	 * @return prefijo del unit
	 */
	public abstract String getPrefix();

	/**
	 * Establece el prefijo de un unit
	 * 
	 * @param prefix prefijo de unit
	 */
	public abstract void setPrefix(String prefix);

	/**
	 * Devuelve el measure de un unit
	 * 
	 * @return measure del unit
	 */
	public abstract Object getMeasure();

	/**
	 * Establece el measure de un unit
	 * 
	 * @param measure mesaure del unit
	 */
	public abstract void setMeasure(Object measure);

	/**
	 * Devuelve el unit como object
	 * 
	 * @return unit como object
	 */
	public abstract Object getUnitObject();

	/**
	 * Establece el unit a partir de un object
	 * 
	 * @param unitObject unit como object
	 */
	public abstract void setUnitObject(Object unitObject);

}