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

import java.util.ArrayList;

import es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext;
import es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact;
import es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlUnit;

/**
 * 
 * Clase usada para encapsular un objeto correspondiente a un fact XBRL.
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

public class XbrlFact implements IXbrlFact {

	private String concept = null;
	private String value = null;
	private String decimals = null;
	private IXbrlUnit unit = null;
	private String prefix = null;
	private String namespace = null;
	private IXbrlContext context = null;
	private String sign = null;
	private Object factObject = null;
	private ArrayList<String> footNotes = null;
	private int order = 0;

	/**
	 * Constructor
	 */
	XbrlFact() {
		super();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#getConcept()
	 */
	public final String getConcept() {
		return concept;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#setConcept(java.lang.
	 * String)
	 */
	public final void setConcept(String concept) {
		this.concept = concept;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#getValue()
	 */
	public final String getValue() {
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#setValue(java.lang.String
	 * )
	 */
	public final void setValue(String value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#getDecimals()
	 */
	public final String getDecimals() {
		return decimals;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#setDecimals(java.lang
	 * .String)
	 */
	public final void setDecimals(String decimals) {
		this.decimals = decimals;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#getUnit()
	 */
	public final IXbrlUnit getUnit() {
		return unit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#setUnit(es.inteco.xbrl
	 * .lenlocpenloc.apifacade.IXbrlUnit)
	 */
	public final void setUnit(IXbrlUnit unit) {
		this.unit = unit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#getContext()
	 */
	public final IXbrlContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#setContext(es.inteco.
	 * xbrl.lenlocpenloc.apifacade.IXbrlContext)
	 */
	public final void setContext(IXbrlContext context) {
		this.context = context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#getFactObject()
	 */
	public final Object getFactObject() {
		return factObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#setFactObject(java.lang
	 * .Object)
	 */
	public final void setFactObject(Object factObject) {
		this.factObject = factObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#getPrefix()
	 */
	public final String getPrefix() {
		return prefix;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#setPrefix(java.lang.String
	 * )
	 */
	public final void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#getNamespace()
	 */
	public final String getNamespace() {
		return namespace;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#setNamespace(java.lang
	 * .String)
	 */
	public final void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#getSign()
	 */
	public final String getSign() {
		return sign;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#setSign(java.lang.String)
	 */
	public final void setSign(String sign) {
		this.sign = sign;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#getFootNotes()
	 */
	public ArrayList<String> getFootNotes() {
		return footNotes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#setFootNotes(java.util
	 * .ArrayList)
	 */
	public void setFootNotes(ArrayList<String> footNotes) {
		this.footNotes = footNotes;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#isTuple()
	 */
	public boolean isTuple() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#setOrder(int)
	 */
	public void setOrder(int order) {
		this.order = order;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact#getOrder()
	 */
	public int getOrder() {
		return order;
	}

}