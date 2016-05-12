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

package es.inteco.xbrl.lenlocpenloc.transform;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;
import org.exolab.castor.types.Date;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

import es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlApiFacade;
import es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlContext;
import es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlFact;
import es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlInstance;
import es.inteco.xbrl.lenlocpenloc.apifacade.IXbrlUnit;
import es.inteco.xbrl.lenlocpenloc.apifacade.impl.XbrlApiFactory;
import es.inteco.xbrl.lenlocpenloc.config.ConfigurationManager;
import es.inteco.xbrl.lenlocpenloc.config.NsItem;
import es.inteco.xbrl.lenlocpenloc.config.format.Item;
import es.inteco.xbrl.lenlocpenloc.config.format.Module;
import es.inteco.xbrl.lenlocpenloc.config.format.Note;
import es.inteco.xbrl.lenlocpenloc.config.format.Report;
import es.inteco.xbrl.lenlocpenloc.config.format.Row;
import es.inteco.xbrl.lenlocpenloc.config.format.Table;
import es.inteco.xbrl.lenlocpenloc.config.format.types.Unittype;
import es.inteco.xbrl.lenlocpenloc.config.maps.ConceptMap;
import es.inteco.xbrl.lenlocpenloc.config.maps.Member;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.ConfigException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.DocumentNotFoundException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.TransformException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLApiException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLENLOCException;
import es.inteco.xbrl.lenlocpenloc.utils.NotesComparator;
import es.inteco.xbrl.lenlocpenloc.utils.ENLOCUtils;
import es.inteco.xbrl.lenlocpenloc.utils.UtilConstants;

import es.inteco.xbrl.lenlocpenloc.utils.RowsComparator;
import es.inteco.xbrl.lenlocpenloc.utils.XbrlApiConfiguration;

/**
 * 
 * 
 * Clase encargada de realizar la transformación de XML a XBRL. Es una clase de
 * ámbito paquete, su funcionalidad es publicada mediante la clase
 * ENLOCTransformer.
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
 * @see
 * 
 */

class TransformerToXBRL {

	private static final Logger logger = Logger.getLogger(TransformerToXBRL.class);

	/**
	 * Objeto utilizado para acceder a la configuación necesaria para realizar
	 * el proceso de transformación, mapas, global, etc.
	 */
	private ConfigurationManager configM = null;
	/**
	 * Objeto que expone la funcionalidad de la API XBRL en la que se basa el
	 * proceso de transformación.
	 */
	private IXbrlApiFacade apiFacade = null;
	/**
	 * Objeto report que contendrá la instancia del XML de entrada el cual se
	 * transformará a XBRL.
	 */
	private Report report = null;
	/**
	 * Instancia XBRL sobre la cual se irán añadiendo todos los elementos
	 * encontrados en el objeto report.
	 */
	private IXbrlInstance instance = null;

	/**
	 * Tabla global de unidades. Se utiliza como almacenamiento temporal de las
	 * unidades creadas durante el proceso de transformación, de modo que se
	 * evite la creación duplicada de unidades en la instancia XBRL.
	 */
	private HashMap<String, IXbrlUnit> units = new HashMap<String, IXbrlUnit>();

	/**
	 * Lista donde serán almacenados los warnings o errores que llegan al logger
	 */
	private ArrayList<String> loggerTraceList = null;

	/**
	 * Establece el arraylist destinado al almacenar los warnings o errores que
	 * llegan al logger producidos durante la transformación
	 * 
	 * @param loggerList ArrayList de String
	 */
	protected void setLoggerTraceList(ArrayList<String> loggerList) {
		this.loggerTraceList = loggerList;
		try {
			apiFacade.setLoggerTraceList(loggerList);
		} catch(Exception e) {
		}
	}

	/**
	 * Constructor de la clase, en el cual se inicializa la configuración y la
	 * facade.
	 * 
	 * @throws XBRLENLOCException Eleva el error que se haya podido producir
	 *         durante el proceso
	 * 
	 */
	private TransformerToXBRL() throws TransformException {
		try {
			configM = ConfigurationManager.getInstance();
		} catch(DocumentNotFoundException e) {
			throw new TransformException(TransformException.errorCreatingTransformerToXBRL, e.getErrorsHandler());
		} catch(ConfigException e) {
			throw new TransformException(TransformException.errorCreatingTransformerToXBRL, e.getErrorsHandler());
		}
		apiFacade = XbrlApiFactory.get_instance();
	}

	/* Devuelve el id de la Entity de un report */
	private String getIdentity() {
		return report.getEntity().getId();
	}

	/* Devuelve el URI de la entity de un report */
	private String getIdentityUri() {
		return report.getEntity().getUri();
	}

	/**
	 * Método encargado de deserializar el report indicado en el path que se
	 * pasa como parámetro.
	 * 
	 * @param inputPath path en el cual se encuentra el report a transformar
	 * 
	 * @return instancia del report deserializado
	 * @throws DocumentNotFoundException
	 * 
	 * @throws XBRLENLOCException si hay algún error durante la deserialziación
	 * 
	 */
	private Report loadReport(String inputPath) throws ConfigException, DocumentNotFoundException {

		Report inputReport = null;

		File inputFile = new File(inputPath);

		try {
			inputReport = Report
			        .unmarshal(new InputStreamReader(new FileInputStream(inputFile), UtilConstants.ENCODING));

		} catch(MarshalException e) {
			logger.error(e.getMessage());
			throw new ConfigException(ConfigException.errorInReportFileDeserialization, new String[] { inputPath }, e);

		} catch(ValidationException e) {
			logger.error(e.getMessage());
			throw new ConfigException(ConfigException.errorInValidationGlobalFile, new String[] { inputPath }, e);

		} catch(FileNotFoundException e) {
			logger.error(e.getMessage());
			throw new DocumentNotFoundException(DocumentNotFoundException.notExistReportFile,
			        new String[] { inputPath });
		} catch(UnsupportedEncodingException e) {
			logger.error(e.getMessage());
			throw new ConfigException(ConfigException.unsuportedEncoding, new String[] { inputPath }, e);
		}

		return inputReport;

	}

	/**
	 * Las unidades, a medida que se van requiriendo son solicitadas a través de
	 * este método, ya que es el encargado de mantener una tabla de unidades
	 * creadas durante el proceso de transformación, permitiendo así su
	 * reutilización.
	 * 
	 * @param unitKey identificar de las unidad solicitada
	 * 
	 * @return devuelve un objeto encapsulador de unidad
	 * @throws XBRLApiException
	 * @throws ConfigException en caso de producirse algún error
	 * 
	 */
	private IXbrlUnit getUnit(String unitKey) throws ConfigException, XBRLApiException {
		IXbrlUnit unit = units.get(unitKey);

		if(unit == null) {

			// Get information necessary for create unit element from
			// configuration
			String unitCode = configM.getUnit(unitKey, report.getId());
			if(unitCode == null) {
				throw new ConfigException(ConfigException.notFoundUnitCode, new String[] { unitKey });
			}
			String unitPrefix = configM.getUnitPrefix(unitKey, report.getId());

			unit = XbrlApiFactory.createUnit();
			unit.setCode(unitCode);
			unit.setPrefix(unitPrefix);
			unit.setKey(unitKey);

			// Create the unit element in the XBRL instance
			unit = apiFacade.createUnit(unit, instance);
			units.put(unitKey, unit);
		}

		return unit;

	}

	/**
	 * Crea un objeto intermedio para encapsular el valor de un contexto XBRL y
	 * la instancia una vez haya sido procesada por la facade. <br /><br /> Este
	 * método comprueba si las fechas de reporte inicio y fin son las mismas y
	 * el periodo indicado es duration, en cuyo caso, el contexto no es creado,
	 * ya que no tendría sentido crear un contexto con esta configuración. <br
	 * /><br /> Si el tipo de perido es INSTANT, entonces sólo se le da valor al
	 * periodo instante, en caso contrario, dicho periodo se dejaría nulo y se
	 * asignaría perido end y period start.
	 * 
	 * @param periodType tipo de periodo
	 * 
	 * @param reportingStartDate fecha inicial de reporte del contexto
	 * 
	 * @param reportingDateEnd fecha fin de reporte del contexto
	 * 
	 * @param contextID identificador del contexto
	 * 
	 * @return objeto encapsulador del contexto
	 * 
	 */
	private IXbrlContext createContext(String periodType, Date reportingStartDate, Date reportingEndDate,
	        String contextID) {

		IXbrlContext context = null;
		boolean equalsDates = (reportingEndDate.toDate().compareTo(reportingStartDate.toDate()) == 0);
		if(!((periodType.equals(UtilConstants.DURATION)) && (equalsDates))) {

			context = XbrlApiFactory.createContext();
			context.setId(contextID);
			context.setEntityIdentifierSchema(getIdentityUri());
			context.setEntityIdentifierValue(getIdentity());

			if(periodType.equals(UtilConstants.INSTANT)) {
				context.setPeriodInstant(reportingEndDate.toDate());
			} else {
				context.setPeriodEndDate(reportingEndDate.toDate());
				context.setPeriodStartDate(reportingStartDate.toDate());
			}
		}

		return context;
	}

	/**
	 * Se proceso un módulo pasado como argumento. Además se pasa una tabla con
	 * los contextos en la cual se van referenciando los contextos que se van
	 * creando. <br /><br /> Antes de crear un contexto se comprueba si el
	 * contexto ya existe, en cuyo caso se reutiliza.
	 * 
	 * @param module referencia al módulo
	 * 
	 * @param tempContextTable tabla con los contextos
	 * 
	 * @throws XBRLENLOCException en caso de que se produzca algún error
	 * 
	 */
	private void processModule(Module module, Hashtable<String, IXbrlContext> tempContextTable)
	        throws TransformException {
		IXbrlContext instantContext = null;
		IXbrlContext durationContext = null;

		// En primer lugar se obtiene la unidad para el módulo, la cual viene
		// dada en el atributo baseunit
		IXbrlUnit unit = null;
		try {
			// string no se creará como unidad en el XBRL
			if(!(Unittype.STRING.value().equalsIgnoreCase(module.getBaseUnit().value()))) {
				unit = getUnit(module.getBaseUnit().value());
			}

			// Se crean dos contextos uno duration y otro instant, aunque
			// primero se
			// comprueba si existen ya en la tabla de contextos
			// para ello, en primer lugar se generan los identificadores en
			// función
			// del identificador del módulo, y la fecha de reporte.
			String instantContextKey = TransformerHelper.getContextID("Y1", module.getId(), module
			        .getReportingEndDate(), UtilConstants.INSTANT);

			if(tempContextTable.containsKey(instantContextKey)) {
				instantContext = tempContextTable.get(instantContextKey);
			} else {
				instantContext = createContext(UtilConstants.INSTANT, module.getReportingStartDate(), module
				        .getReportingEndDate(), instantContextKey);
				instantContext = apiFacade.createContext(instantContext, instance);
				apiFacade.createInstantPeriod(instantContext, instance);
				tempContextTable.put(instantContextKey, instantContext);
			}

			String durationContextKey = TransformerHelper.getContextID("Y1", module.getId(), module
			        .getReportingEndDate(), UtilConstants.DURATION);

			if(tempContextTable.containsKey(durationContextKey)) {
				durationContext = tempContextTable.get(durationContextKey);
			} else {
				durationContext = createContext(UtilConstants.DURATION, module.getReportingStartDate(), module
				        .getReportingEndDate(), durationContextKey);
				// Puede ser nulo, en el caso de que las fechas inicio y fin
				// sean
				// iguales
				if(durationContext != null) {
					durationContext = apiFacade.createContext(durationContext, instance);
					apiFacade.createDurationPeriod(durationContext, instance);
					tempContextTable.put(durationContextKey, durationContext);
				}
			}

			// Se procesan las tablas incluidas en el módulo, creando los facts
			// y
			// contextos dimensionales sobre la instancia XBRL
			processTables(module);

			// Se procesan los items incluidos en el módulo creando los facts
			// equivalentes en la instancia XBRL
			processItems(null, instantContext, durationContext, module.getId(), unit, module.getBaseDecimals(), module
			        .getItem(), tempContextTable, null, null, null);
		} catch(XBRLApiException e) {
			throw new TransformException(TransformException.errorInTransformationToXbrl, e.getErrorsHandler());
		} catch(ConfigException e) {
			throw new TransformException(TransformException.errorInTransformationToXbrl, e.getErrorsHandler());
		}
	}

	/**
	 * Procesa un fact(item) dado, creando el elemento equivalente en la
	 * instancia XBRL. Para ello se realizan varias comprobaciones: <br />
	 * <ul>
	 * <li>
	 * Las unidades se sobrescriben a las indicadas en el módulo al que
	 * pertenece dicho item, en caso de que el item sea informado con dicha
	 * unidad.</li>
	 * <li>
	 * Igual que las unidades, ocurre con los decimales.</li>
	 * <li>
	 * Se genera el namespace al cual pertenece dicho item, en caso de que
	 * exista.</li>
	 * <li>
	 * Si el item contiene una fecha de reporte se creará un contexto especial
	 * del tipo instante con la fecha indicada. Esto se utiliza para indicar que
	 * un item que se encuentra dentro de un modulo de tipo duration, se está
	 * reportando sólo para el instante inicio o fin del periodo indicado en el
	 * módulo.</li>
	 * <li>
	 * Si no existe ninguna fecha de reporte en el item, se utilizará el
	 * contexto instant o duration en función de si si el concepto al que
	 * pertenece dicho item es de un tipo o de otro.</li>
	 * <li>
	 * Si el atributo parent no es nulo, quiere decir que el item es hijo de una
	 * tupla, por lo tanto se creará como tal en caso contrario se creará como
	 * un fact de la instancia.</li>
	 *</ul>
	 * 
	 * @param parent referencia a la tupla padre, en caso de que de a lugar
	 * 
	 * @param instantContext referencia al contexto instante, sobre el cual se
	 *        generarán los items de tipo instant
	 * 
	 * @param durationContext referencia al contexto duration, sobre el cual se
	 *        generarán los items de tipo duration
	 * 
	 * @param moduleID identificador del módulo al que pertenece el item
	 * 
	 * @param unit unidad del módulo, y que se sobrescribirá con lo que se
	 *        informe en el item
	 * 
	 * @param baseDecimals decimales del módulo, y que se sobrescribirán con lo
	 *        que se indique en el item
	 * 
	 * @param item item que se quiere generar como fact en la instancia XBRL
	 * 
	 * @param fact elemento IXbrlFact que encapsula la información para
	 *        intercambio con la facade
	 * 
	 * @param itemInfo información obtenida de los mapas de configuración para
	 *        el item (ConceptMap)
	 * 
	 * @param tempContextTable tabla temporal de contextos en la cual se
	 *        guardarán aquellos que se creen durante el proceso
	 * @param rowValue
	 * @param dimensionValueNS
	 * @param dimensionValue
	 * @param itemInfo2
	 * 
	 * @throws TransformException
	 */
	private void processItem(IXbrlFact parent, IXbrlContext instantContext, IXbrlContext durationContext,
	        String moduleID, IXbrlUnit unit, String baseDecimals, Item item, IXbrlFact fact, ConceptMap itemInfo,
	        Hashtable<String, IXbrlContext> tempContextTable, ConceptMap itemInfo2, String dimensionValue,
	        String dimensionValueNS, String rowValue) throws TransformException {
		try {
			// Item unit override module unit
			Unittype unitType = item.getUnit();
			if(unitType != null) {
				String itemUnitKey = item.getUnit().value();
				unit = getUnit(itemUnitKey);
			}

			// Item decimals override module decimals
			String itemDecimals = item.getDecimals();
			if((itemDecimals != null) && (!itemDecimals.trim().isEmpty())) {
				baseDecimals = itemDecimals;
			}

			NsItem nsItem = new NsItem();
			nsItem.setPrefix(itemInfo.getNsPrefix());
			nsItem.setUri(itemInfo.getNs());

			apiFacade.createNamespaces(new NsItem[] { nsItem }, instance);

			fact.setDecimals(baseDecimals);
			fact.setUnit(unit);
			IXbrlContext context = apiFacade.isInstant(fact, instance) ? instantContext : durationContext;

			if(context == null) {
				// throw new XBRLENLOCException("itemDurationInModuleInstant",
				// new
				// String[]{});
				logger.warn("Item " + fact.getConcept() + " of duration type in a instant module");
				if(!(loggerTraceList == null)) {
					loggerTraceList.add("WARNING: Item " + fact.getConcept() + " of duration type in a instant module");
				}
				context = instantContext;
			}
			IXbrlContext instantContextDim = null;
			IXbrlContext instantContextNew = null;

			if(item.getReportingDate() != null) {

				String periodType = item.getReportingDate().toDate().equals(this.getDateContext(context))
				        ? UtilConstants.INSTANT_INI : UtilConstants.INSTANT_FIN;
				String contextID = TransformerHelper.getContextID("Y", moduleID, item.getReportingDate(), periodType);

				instantContextNew = createContext(UtilConstants.INSTANT, item.getReportingDate(), item
				        .getReportingDate(), contextID);

				if(tempContextTable.containsKey(contextID)) {
					context = tempContextTable.get(contextID);
				} else {
					if(itemInfo.getContainerDimensionType() != null
					        && itemInfo.getContainerDimensionType().equals(UtilConstants.SEGMENT)) {
						if(itemInfo.isTypedDimension()) {
							instantContextDim = apiFacade.createTypedDimensionalContext(instantContextNew, instance,
							        itemInfo.getDomain(), dimensionValue, dimensionValueNS, rowValue);
						} else {
							instantContextDim = apiFacade.createDimensionalContext(instantContextNew, instance,
							        itemInfo.getDomain(), dimensionValue);
						}
						apiFacade.createInstantPeriod(instantContextDim, instance);
					} else {
						instantContextDim = apiFacade.createContext(instantContextNew, instance);
						apiFacade.createInstantPeriod(instantContextNew, instance);
						apiFacade.createDimension(itemInfo.getDomain(), dimensionValue, instantContextNew, instance);
					}
					instantContextDim.setId(contextID);
					tempContextTable.put(instantContextDim.getId(), instantContextDim);
				}
			}
			if(instantContextDim != null) {
				fact.setContext(instantContextDim);
			} else {
				fact.setContext(context);
			}

			if(parent == null) {
				fact = apiFacade.createFact(fact, instance);

			} else {
				fact = apiFacade.createTupleChild(fact, parent, instance);
			}

			if(item.getNote() != null) {

				processNotes(fact, item.getNote());
			}
		} catch(XBRLApiException e) {
			throw new TransformException(TransformException.errorInTransformationToXbrl, e.getErrorsHandler());
		} catch(ConfigException e) {
			throw new TransformException(TransformException.errorInTransformationToXbrl, e.getErrorsHandler());
		} catch(Exception e) {
			throw new TransformException(TransformException.errorInTransformationToXbrl, e);
		}
	}

	private java.util.Date getDateContext(IXbrlContext context) {
		java.util.Date dateContext = null;
		if(context.getPeriodStartDate() != null) {
			dateContext = context.getPeriodStartDate();
		} else {
			dateContext = context.getPeriodInstant();
		}
		return dateContext;
	}

	/**
	 * 
	 * 
	 * Procesa las tablas encontradas en el fichero de formato común para
	 * generar las dimensiones y sus contextos.
	 * 
	 * @param module
	 * @throws TransformException
	 * 
	 */
	private void processTables(Module module) throws TransformException {
		Table[] tables = module.getTable();
		int numTables = tables.length;
		Hashtable<String, IXbrlContext> tempContextTable = new Hashtable<String, IXbrlContext>();
		for(int i = 0; i < numTables; i++) {
			Table table = tables[i];

			processRows(table.getRow(), table.getId(), module, tempContextTable);
		}
	}

	/**
	 * 
	 * 
	 * Procesa una lista de objetos Row.
	 * 
	 * @param rows
	 * @param tableID
	 * @param module
	 * @param tempContextTable
	 * @throws TransformException
	 * 
	 */
	private void processRows(Row rows[], String tableID, Module module, Hashtable<String, IXbrlContext> tempContextTable)
	        throws TransformException {

		try {
			int numRows = rows.length;

			List<Row> rowsList = Arrays.asList(rows);
			Collections.sort(rowsList, new RowsComparator());
			Hashtable<String, Row> rowTable = new Hashtable<String, Row>();

			for(int i = 0; i < numRows; i++) {
				Row row = rowsList.get(i);

				TransformerHelper.checkDuplicateRows(rowTable, row, logger, loggerTraceList);
				
				Item item = row.getItem(0);
				ConceptMap itemInfo = configM.getInfoByInputID(report.getId(), module.getId(), item.getId());
				NsItem[] nsList = configM.getBasicNamespaces(report.getId());
				if(itemInfo == null) {
					logger.warn("Not exists the conceptMap " + "\"" + item.getId() + "\"" + " in the map " + module.getId());
					if(!(loggerTraceList == null)) {
						loggerTraceList.add("WARNING: Not exists the conceptMap " + "\"" + item.getId() + "\"" + " in the map "
						        + "\"" + module.getId() + "\"");
					}
					continue;
				}

				boolean isTypedDimension = itemInfo.isTypedDimension();

				Member domainMember = TransformerHelper.getMemberByIndex(itemInfo, row.getId(), row.getValue());
				if(domainMember == null) {
					throw new TransformException(TransformException.notExistDomainMemberForModule, new String[] {
					        row.getId(), module.getId() });
				}

				String dimension = itemInfo.getDomain();

				String dimensionValue = domainMember.getQname();

				String[] dimensionValueParts = dimensionValue.split(":");
				String dimensionValuePrefix = dimensionValueParts[0];
				String dimensionValueName = dimensionValueParts[1];
				String dimensionValueNS = null;
				for(int j = 0; j < nsList.length; j++) {
					NsItem nsItem = nsList[j];
					if(nsItem.getPrefix().equals(dimensionValuePrefix)) {
						dimensionValueNS = nsItem.getUri();
					}
				}
				String containerDimensionType = itemInfo.getContainerDimensionType();

				IXbrlContext instantContext = null;
				IXbrlContext durationContext = null;

				// TODO formar la key con el valor de la typed dimension
				String instantContextKey = TransformerHelper.getContextID("Y1", module.getId(), module
				        .getReportingEndDate(), UtilConstants.INSTANT, dimensionValue, dimension, row.getValue());

				if(tempContextTable.containsKey(instantContextKey)) {
					instantContext = tempContextTable.get(instantContextKey);
				} else {
					instantContext = createContext(UtilConstants.INSTANT, module.getReportingStartDate(), module
					        .getReportingEndDate(), instantContextKey);
					if(instantContext != null) {
						if(containerDimensionType != null && containerDimensionType.equals(UtilConstants.SEGMENT)) {
							if(isTypedDimension) {
								instantContext = apiFacade.createTypedDimensionalContext(instantContext, instance,
								        dimension, dimensionValueName, dimensionValueNS, row.getValue());
							} else {
								instantContext = apiFacade.createDimensionalContext(instantContext, instance,
								        dimension, dimensionValue);
							}
							apiFacade.createInstantPeriod(instantContext, instance);
						} else {
							instantContext = apiFacade.createContext(instantContext, instance);
							apiFacade.createInstantPeriod(instantContext, instance);
							apiFacade.createDimension(dimension, dimensionValue, instantContext, instance);
						}
						tempContextTable.put(instantContext.getId(), instantContext);
					}
				}
				// TODO probar la implementación del contexto dimensional con
				// segmento para los contextos duration
				String durationContextKey = TransformerHelper.getContextID("Y1", module.getId(), module
				        .getReportingEndDate(), UtilConstants.DURATION, dimensionValue, dimension, row.getValue());
				if(tempContextTable.containsKey(durationContextKey)) {
					durationContext = tempContextTable.get(durationContextKey);
				} else {
					durationContext = createContext(UtilConstants.DURATION, module.getReportingStartDate(), module
					        .getReportingEndDate(), durationContextKey);
					if(durationContext != null) {
						if(containerDimensionType.equals(UtilConstants.SEGMENT)) {
							durationContext = apiFacade.createDimensionalContext(durationContext, instance, dimension,
							        dimensionValue);
							apiFacade.createDurationPeriod(durationContext, instance);
						} else {
							durationContext = apiFacade.createContext(durationContext, instance);
							apiFacade.createDurationPeriod(durationContext, instance);
							apiFacade.createDimension(dimension, dimensionValue, durationContext, instance);
						}
						tempContextTable.put(durationContext.getId(), durationContext);
					}
				}

				IXbrlUnit unit = getUnit(module.getBaseUnit().value());
				processItems(null, instantContext, durationContext, module.getId(), unit, module.getBaseDecimals(), row
				        .getItem(), tempContextTable, dimensionValue, dimensionValueNS, row.getValue());
			}
		} catch(ConfigException e) {
			throw new TransformException(TransformException.errorInTransformationToXbrl, e.getErrorsHandler());
		} catch(XBRLApiException e) {
			throw new TransformException(TransformException.errorInTransformationToXbrl, e.getErrorsHandler());
		} catch(DocumentNotFoundException e) {
			throw new TransformException(TransformException.errorInTransformationToXbrl, e.getErrorsHandler());
		}
	}

	/**
	 * 
	 * 
	 * Procesa una lista de items del fichero común generando los elementos de
	 * la instancia XBRL.
	 * 
	 * @param parent
	 * @param instantContext
	 * @param durationContext
	 * @param moduleID
	 * @param unit
	 * @param baseDecimals
	 * @param items
	 * @param tempContextTable
	 * @param string
	 * @param dimensionValueNS
	 * @param dimensionValue
	 * @param itemInfo
	 * @throws TransformException
	 * 
	 */
	private void processItems(IXbrlFact parent, IXbrlContext instantContext, IXbrlContext durationContext,
	        String moduleID, IXbrlUnit unit, String baseDecimals, Item items[],
	        Hashtable<String, IXbrlContext> tempContextTable, String dimensionValue, String dimensionValueNS,
	        String rowValue) throws TransformException {

		int numItem = items.length;
		Hashtable<String, Item> itemTable = new Hashtable<String, Item>();

		for(int i = 0; i < numItem; i++) {
			Item item = items[i];

			TransformerHelper.checkDuplicateItems(itemTable, item, logger, loggerTraceList);

			IXbrlFact fact = null;

			ConceptMap itemInfo = null;
			try {
				itemInfo = configM.getInfoByInputID(report.getId(), moduleID, item.getId());
			} catch(ConfigException e) {
				throw new TransformException(TransformException.errorInTransformationToXbrl, e.getErrorsHandler());
			} catch(DocumentNotFoundException e) {
				throw new TransformException(TransformException.errorInTransformationToXbrl, e.getErrorsHandler());
			}

			if(itemInfo == null) {
				logger.warn("Not exists the conceptMap " + item.getId() + " in the map " + moduleID);
				if(!(loggerTraceList == null)) {
					loggerTraceList.add("WARNING: Not exists the conceptMap " + item.getId() + " in the map "
					        + moduleID);
				}
				continue;
			}

			fact = TransformerHelper.createFact(itemInfo, item, false);

			processItem(parent, instantContext, durationContext, moduleID, unit, baseDecimals, item, fact, itemInfo,
			        tempContextTable, itemInfo, dimensionValue, dimensionValueNS, rowValue);
		}

	}

	/**
	 * 
	 * 
	 * Crea los comentarios para el fact.
	 * 
	 * @param fact
	 * @param notes
	 * @throws TransformException
	 * 
	 */
	private void processNotes(IXbrlFact fact, Note notes[]) throws TransformException {

		int numNote = notes.length;

		List<Note> notesList = Arrays.asList(notes);
		Collections.sort(notesList, new NotesComparator());
		try {
			for(int i = 0; i < numNote; i++) {

				Note note = notesList.get(i);

				if(instance.getFootNoteLink() == null) {
					instance.setFootNoteLink(apiFacade.createFootNoteLink(instance));
				}
				apiFacade.createFootNote(instance.getFootNoteLink(), fact, "es", note.getText(), String
				        .valueOf(new Long(note.getId()).intValue()), instance);
			}
		} catch(XBRLApiException e) {
			throw new TransformException(TransformException.errorInTransformationToXbrl, e.getErrorsHandler());
		}
	}

	/**
	 * 
	 * 
	 * Genera la instancia XBRL.
	 * 
	 * @throws TransformException
	 * 
	 */
	private void generateXBRL() throws TransformException {
		units.clear();

		try {
			// Generate basic namespaces
			NsItem basicNS[] = configM.getBasicNamespaces(report.getId());
			apiFacade.createNamespaces(basicNS, instance);
		} catch(ConfigException e) {
			throw new TransformException(TransformException.errorInTransformationToXbrl, e.getErrorsHandler());
		} catch(XBRLApiException e) {
			throw new TransformException(TransformException.errorInTransformationToXbrl, e.getErrorsHandler());
		}

		Hashtable<String, IXbrlContext> tempContextTable = new Hashtable<String, IXbrlContext>();

		// Generate modules included in Report
		Module modules[] = report.getModule();
		int numModules = report.getModuleCount();

		for(int i = 0; i < numModules; i++) {
			processModule(modules[i], tempContextTable);
		}

	}

	/**
	 * 
	 * 
	 * Realiza la transformación de un fichero común en instancia XBRL.
	 * 
	 * @param inputPath
	 * @param outputPath
	 * @return
	 * @throws TransformException
	 * 
	 */
	byte[] transform(String inputPath, String outputPath) throws TransformException {
		byte[] xbrlResult = null;
		try {
			// Load Report from XML instance
			report = loadReport(inputPath);

			// Create XBRL instance
			instance = apiFacade.createInstance(outputPath, configM.getTargetNamespace(report.getId()), configM
			        .getShemaRefUri(report.getId()));

			// Get XBRL instance from Report information
			generateXBRL();

			xbrlResult = apiFacade.generateXbrlByteArray(instance);

			ByteArrayOutputStream outputStreamXBRL = new ByteArrayOutputStream();

			String normalizedSchemaRef = configM.getBaseUrl(report.getId()) + "/"
			        + configM.getShemaRefUri(report.getId());
			ENLOCUtils.normalizeSchema(new ByteArrayInputStream(xbrlResult), XbrlApiConfiguration.getInstance()
			        .getTaxonomyRoot(), normalizedSchemaRef, outputStreamXBRL);

			xbrlResult = outputStreamXBRL.toByteArray();

			FileOutputStream outputStremFile = new FileOutputStream(outputPath);
			outputStremFile.write(xbrlResult);

		} catch(DocumentNotFoundException exp) {
			throw new TransformException(TransformException.errorInTransformationToXbrl, new String[] { inputPath },
			        exp.getErrorsHandler());
		} catch(TransformException ex) {
			File f = new File(outputPath);
			if(f.exists()) {
				f.delete();
			}
			throw ex;
		} catch(ConfigException exp) {
			throw new TransformException(TransformException.errorInTransformationToXbrl, new String[] { inputPath },
			        exp.getErrorsHandler());
		} catch(Exception e) {
			logger.error(e);
			throw new TransformException(TransformException.errorInTransformationToXbrl, new String[] { outputPath });
		}

		return xbrlResult;

	}

	/**
	 * 
	 * 
	 * Realiza la transformación de un fichero de formato común en una instancia
	 * XBRL.
	 * 
	 * @param inputPath
	 * @return
	 * @throws TransformException
	 * 
	 */
	byte[] transform(String inputPath) throws TransformException {

		File instanceFile = null;
		byte[] xbrlResult = null;
		String outputPath = null;

		try {
			instanceFile = ENLOCUtils.createTempFile("transformToXbrl", ".xbrl");

			outputPath = instanceFile.getAbsolutePath();

			xbrlResult = transform(inputPath, outputPath);

		} catch(XBRLENLOCException e) {
			throw new TransformException(TransformException.errorInTransformationToXbrl, e.getErrorsHandler());
		} finally {
			try {
				if(instance != null) {
					apiFacade.closeInstance(instance);
				}
			} catch(Exception e) {
				logger.warn(e);
				if(!(loggerTraceList == null)) {
					loggerTraceList.add("WARNING: " + e.toString());
				}
			}

			if((instanceFile != null) && instanceFile.exists()) {
				instanceFile.delete();
			}
		}

		return xbrlResult;
	}

	/**
	 * Crea una instancia de la propia clase
	 * 
	 * @return Objeto del tipo TransformerToXBRL
	 * @throws XBRLENLOCException
	 */
	static TransformerToXBRL createInstance() throws TransformException {

		return new TransformerToXBRL();
	}
}