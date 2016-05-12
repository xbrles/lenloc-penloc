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

package es.inteco.xbrl.lenlocpenloc.apifacade.impl;

import es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlApiFacade;
import es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext;
import es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact;
import es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlInstance;
import es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlUnit;
import es.inteco.xbrl.lenlocpenloc.apifacade.xbreeze.UbmXbrlApiFacade;

/**
 * 
 * Factoria de objetos necesarios para trabajar con API XBRL, permitiendo
 * desacoplar el uso de la misma. Estos objetos estarán constituidos por la
 * Facade necesaria para acceder a una instancia XBRL y los objetos necesarios
 * para realizar el intercambio de información entre la API ENLOC y la API XBRL
 * en la que se basa.
 * 
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

public abstract class XbrlApiFactory {

	static IXbrlApiFacade _instance = new UbmXbrlApiFacade();

	/**
	 * @return Instancia de la Facade con la que trabajará la aplicación.
	 * 
	 */
	public static IXbrlApiFacade get_instance() {
		return _instance;
	}

	/**
	 * @return Devuelve un objeto envolvente de un Fact XBRL.
	 */
	public static IXbrlFact createFact() {

		return new XbrlFact();
	}

	/**
	 * @return Devuelve un objeto envolvente de una tupla XBRL.
	 */
	public static IXbrlFact createTuple() {

		return new XbrlTuple();
	}

	/**
	 * @return Devuelve un objeto envolvente de un Unit XBRL.
	 */
	public static IXbrlUnit createUnit() {
		return new XbrlUnit();
	}

	/**
	 * @return Devuelve un objeto envolvente de una instancia y un DTS XBRL sin
	 *         inicializar.
	 */
	public static IXbrlInstance createInstance() {
		return new XbrlInstance();
	}

	/**
	 * @param instance referencia a una instancia XBRL
	 * 
	 * @param dts referencia al DTS correspondiente a instance
	 * 
	 * @return Devuelve un objeto envolvente de una instancia y un DTS
	 *         inicialiado.
	 */
	public static IXbrlInstance XbrlInstance(Object instance, Object dts) {
		return new XbrlInstance(instance, dts);

	}

	/**
	 * @return Devuelve una instancia de un objeto envolvente de un contexto
	 *         XBRL.
	 */
	public static IXbrlContext createContext() {
		return new XbrlContext();
	}
}