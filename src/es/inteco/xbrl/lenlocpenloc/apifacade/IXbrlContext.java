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

import java.util.Date;

/**
 * 
 * 
 * Interfaz que debe cumplir una clase que pretende encapsular un objeto XBRL
 * del tipo Context
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

public interface IXbrlContext {

	/**
	 * Devuelve el identificador del contexto.
	 * 
	 * @return identificador del contexto
	 * 
	 */
	public abstract String getId();

	/**
	 * Asigna un identificador.
	 * 
	 * @param id identificador del contexto
	 */
	public abstract void setId(String id);

	/**
	 * Devuelve el esquema del identificador de la entidad del contexto.
	 * 
	 * @return esquemda del identificador
	 * 
	 */
	public abstract String getEntityIdentifierSchema();

	/**
	 * Asigna un el esquema para el identificador de la entidad del contexto.
	 * 
	 * @param entityIdentifierSchema esquema del identificador
	 * 
	 */
	public abstract void setEntityIdentifierSchema(String entityIdentifierSchema);

	/**
	 * Devuelve el valor del identificador de la entidad del contexto.
	 * 
	 * @return valor del identificador
	 * 
	 */
	public abstract String getEntityIdentifierValue();

	/**
	 * Asigna un valor para el identificador de la entidad del contexto.
	 * 
	 * @param entityIdentifierValue valor del identificador
	 * 
	 */
	public abstract void setEntityIdentifierValue(String entityIdentifierValue);

	/**
	 * Devuelve la fecha de inicio para el periodo del contexto.
	 * 
	 * @return fecha inicio
	 * 
	 */
	public abstract Date getPeriodStartDate();

	/**
	 * Asigna la fecha inicio para el periodo duration del contexto.
	 * 
	 * @param periodStartDate fecha inicio
	 * 
	 */
	public abstract void setPeriodStartDate(Date periodStartDate);

	/**
	 * Devuelve la fecha fin del periodo duration del contexto.
	 * 
	 * @return fecha fin
	 * 
	 */
	public abstract Date getPeriodEndDate();

	/**
	 * Asigna la fecha fin del periodo duration del context.
	 * 
	 * @param periodEndDate fecha fin
	 */
	public abstract void setPeriodEndDate(Date periodEndDate);

	/**
	 * Obtiene la fecha del periodo instant del contexto.
	 * 
	 * @return fecha instant
	 * 
	 */
	public abstract Date getPeriodInstant();

	/**
	 * Asigna la fecha para el periodo insntant del contexto.
	 * 
	 * @param periodInstant fecha instant
	 * 
	 */
	public abstract void setPeriodInstant(Date periodInstant);

	/**
	 * Indica si el contexto es dimensional.
	 * 
	 * @return true si el contexto es dimensional, false en caso contrario.
	 * 
	 */
	public abstract boolean isScenarioIsDimensional();

	/**
	 * Asigna si el contexto es dimensional.
	 * 
	 * @param scenarioIsDimensional true para indicar que el contexto es
	 *        dimensional, false en caso contrario.
	 * 
	 */
	public abstract void setScenarioIsDimensional(boolean scenarioIsDimensional);

	/**
	 * Devuelve la instancia de la API XBRL a la cual encapsula. El valor puede
	 * ser nulo si el contexto al cual representa esta clase no ha sido creado
	 * en la instancia XBRL, por tanto, este valor solo se usa en el ámbito de
	 * la facade.
	 * 
	 * @return referencia al contexto correspondiente a la API XBRL usada.
	 * 
	 */
	public abstract Object getContextObject();

	/**
	 * Asigna un objeto contexto correspondiente a los valores representados por
	 * esta clase.
	 * 
	 * @param contextObject objeto contexto
	 * 
	 */
	public abstract void setContextObject(Object contextObject);

	/**
	 * Devuelve el objeto periodo correspondiente a la información contenida en
	 * esta instancia.
	 * 
	 * @return objeto periodo
	 * 
	 */
	public abstract Object getPeriodObject();

	/**
	 * Asigna un objeto periodo.
	 * 
	 * @param periodObject referencia al objeto periodo
	 * 
	 */
	public abstract void setPeriodObject(Object periodObject);

	/**
	 * Asigna el nombre de la dimensión, si el contexto es dimensional.
	 * 
	 * @param dimension nombre de la dimensión
	 * 
	 */
	public abstract void setDimension(String dimension);

	/**
	 * Devuelve el nombre de la dimensión a la cual pertenece este contexto.
	 * 
	 * @return nombre de la dimensión
	 * 
	 */
	public abstract String getDimension();

	/**
	 * Asigna el nombre del miembro de la dimensión
	 * 
	 * @param member nombre del miembro de la dimensión
	 * 
	 */
	public abstract void setMember(String member);

	/**
	 * Devuelve el nombre del miembro de la dimensión.
	 * 
	 * @return nombre del miembro de la dimensión.
	 * 
	 */
	public abstract String getMember();

	/**
	 * 
	 * TODO Incluir descripción del método con un punto al final.
	 * 
	 * @param typedMemberValue
	 * 
	 */

	/**
	 * Asigna el valor del miembro de la dimensión implícita
	 * 
	 * @param typedMemberValue valor del miembro de la dimensión
	 * 
	 */
	public abstract void setTypedMember(String typedMemberValue);

	/**
	 * Devuelve el valor del miembro de la dimensión implícita.
	 * 
	 * @return valor del miembro de la dimensión.
	 * 
	 */
	public abstract String getTypedMember();

}