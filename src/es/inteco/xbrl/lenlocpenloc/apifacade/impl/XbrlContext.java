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

import java.util.Date;

import es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext;

/**
 * 
 * Clase usada para encapsular un objeto correspondiente a un contexto XBRL.
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

public class XbrlContext implements IXbrlContext {

	private String id = null;
	private String entityIdentifierSchema = null;
	private String entityIdentifierValue = null;
	private Date periodStartDate = null;
	private Date periodEndDate = null;
	private Date periodInstant = null;
	private boolean scenarioIsDimensional = false;
	private Object contextObject = null;
	private Object periodObject = null;
	private String dimension = null;
	private String member = null;
	private String typedMember = null;

	/**
	 * Constructor
	 */
	XbrlContext() {
		super();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#getId()
	 */
	public final String getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#setId(java.lang.String
	 * )
	 */
	public final void setId(String id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#getEntityIdentifierSchema
	 * ()
	 */
	public final String getEntityIdentifierSchema() {
		return entityIdentifierSchema;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#setEntityIdentifierSchema
	 * (java.lang.String)
	 */
	public final void setEntityIdentifierSchema(String entityIdentifierSchema) {
		this.entityIdentifierSchema = entityIdentifierSchema;
	}

	public final String getEntityIdentifierValue() {
		return entityIdentifierValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#setEntityIdentifierValue
	 * (java.lang.String)
	 */
	public final void setEntityIdentifierValue(String entityIdentifierValue) {
		this.entityIdentifierValue = entityIdentifierValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#getPeriodStartDate()
	 */
	public final Date getPeriodStartDate() {
		return periodStartDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#setPeriodStartDate
	 * (java.util.Date)
	 */
	public final void setPeriodStartDate(Date periodStartDate) {
		this.periodStartDate = periodStartDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#getPeriodEndDate()
	 */
	public final Date getPeriodEndDate() {
		return periodEndDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#setPeriodEndDate(java
	 * .util.Date)
	 */
	public final void setPeriodEndDate(Date periodEndDate) {
		this.periodEndDate = periodEndDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#getPeriodInstant()
	 */
	public final Date getPeriodInstant() {
		return periodInstant;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#setPeriodInstant(java
	 * .util.Date)
	 */
	public final void setPeriodInstant(Date periodInstant) {
		this.periodInstant = periodInstant;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#isScenarioIsDimensional
	 * ()
	 */
	public final boolean isScenarioIsDimensional() {
		return scenarioIsDimensional;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#setScenarioIsDimensional
	 * (boolean)
	 */
	public final void setScenarioIsDimensional(boolean scenarioIsDimensional) {
		this.scenarioIsDimensional = scenarioIsDimensional;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#getContextObject()
	 */
	public final Object getContextObject() {
		return contextObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#setContextObject(java
	 * .lang.Object)
	 */
	public final void setContextObject(Object contextObject) {
		this.contextObject = contextObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#getPeriodObject()
	 */
	public final Object getPeriodObject() {
		return periodObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#setPeriodObject(java
	 * .lang.Object)
	 */
	public final void setPeriodObject(Object periodObject) {
		this.periodObject = periodObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#getDimension()
	 */
	public String getDimension() {
		return dimension;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#setDimension(java.
	 * lang.String)
	 */
	public void setDimension(String dimension) {
		this.dimension = dimension;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#getMember()
	 */
	public String getMember() {
		return member;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#setMember(java.lang
	 * .String)
	 */
	public void setMember(String member) {
		this.member = member;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#getTypedMember()
	 */
	public String getTypedMember() {
		return this.typedMember;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext#setTypedMember(java
	 * .lang.String)
	 */
	public void setTypedMember(String typedMemberValue) {
		this.typedMember = typedMemberValue;
	}

}