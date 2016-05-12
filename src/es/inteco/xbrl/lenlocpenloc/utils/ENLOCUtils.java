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

package es.inteco.xbrl.lenlocpenloc.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.apache.xerces.dom.DeferredElementNSImpl;
import org.apache.xerces.util.XMLCatalogResolver;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.SAXException;

import es.inteco.xbrl.lenlocpenloc.config.format.Entity;
import es.inteco.xbrl.lenlocpenloc.config.format.Item;
import es.inteco.xbrl.lenlocpenloc.config.format.Module;
import es.inteco.xbrl.lenlocpenloc.config.format.Note;
import es.inteco.xbrl.lenlocpenloc.config.format.Report;
import es.inteco.xbrl.lenlocpenloc.config.format.Row;
import es.inteco.xbrl.lenlocpenloc.config.format.Table;
import es.inteco.xbrl.lenlocpenloc.config.maps.ConceptMap;
import es.inteco.xbrl.lenlocpenloc.config.maps.Member;
import es.inteco.xbrl.lenlocpenloc.errors.GenericErrorsHandler;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.DocumentNotFoundException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLENLOCException;

/**
 * 
 * 
 * Clase con varias funcionalidades genéricas de apoyo al código de la API.
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

public abstract class ENLOCUtils {

	private static final Logger logger = Logger.getLogger(ENLOCUtils.class);

	/**
	 * 
	 * 
	 * Obtiene la ruta completa de un fichero.
	 * 
	 * @param args nombre del fichero.
	 * @return String con la ruta completa.
	 * @throws XBRLENLOCException si se produce un error.
	 * 
	 */
	public static String getFullPath(String args) throws XBRLENLOCException {
		try {
			// find the path separator used. mostly MS and MAC use
			// "\" but UNIX use "/"
			String strPathSeparator = System.getProperty("file.separator");

			if(strPathSeparator.equals("\\")) // for MS
			{
				// now replace any illegal '/' with '\\'
				args = args.replace('/', '\\');
			} else if(strPathSeparator.equals("/")) // for everything else
			{
				// now replace any illegal '\\' with '/'
				args = args.replace('\\', '/');
				args = new File(args).getCanonicalPath();
			}

			return args;
		} catch(IOException e) {
			throw new XBRLENLOCException(XBRLENLOCException.errorGettingFile, new String[] { args }, e);
		}
	}

	/**
	 * Reemplaza una cadena dentro de otra cadena.
	 * 
	 * @param string cadena original.
	 * @param pattern patrón para el cambio.
	 * @param newPattern cadena a insertar.
	 * @return new string cadena reemplazada.
	 */
	public static String replace(String string, String pattern, String newPattern) {
		try {
			StringBuffer stringBuffer = new StringBuffer(string);

			int index = string.length();
			int offset = pattern.length();

			while((index = string.lastIndexOf(pattern, index - 1)) > -1) {
				stringBuffer.replace(index, index + offset, newPattern);
			}

			return stringBuffer.toString();
		} catch(StringIndexOutOfBoundsException e) {
			return string;
		}
	}

	/**
	 * Este método formatea la cadena de entrada con los argumentos pasados. Hay
	 * que tener en cuenta que el usuario debe introducir los parámetros por
	 * parejas, es decir, no se controlará que cada parámetro concuerde con su
	 * pareja, si el número de argumentos pasados no es el correcto el método
	 * devuelve null.
	 * 
	 * @param template plantilla para rellenar.
	 * 
	 * @param arguments Los argumentos para rellenar los huecos en la plantilla.
	 * 
	 * @return cadena formateada.
	 */
	public static String format(String template, String[] arguments) {
		int numberOfPairBraces = getNumberOfPairBraces(template);

		// this used to require that numberOfPairBraces exactly match argument
		// count,
		// but this is wrong; this means that we can't reuse parameters
		if(numberOfPairBraces < arguments.length)
			return template;

		if(arguments != null) {
			// likewise, we can't index up to numberOfPairBraces, but only up to
			// argument coungt
			for(int i = 0; i < arguments.length; ++i) {
				// using regex is too messy here; too many special regex
				// characters to worry about
				// ...so since we don't really need or want regex replacements
				// anyway, just avoid
				// the whole issue
				String toBeReplaced = "{" + i + "}";
				template = replace(template, toBeReplaced, arguments[i]);
			}
		}

		return template;
	}

	// This method returns number of pair braces in the string provided
	private static int getNumberOfPairBraces(String str) {
		int start = 0; // we will start from the begining of the string
		int numberOfPairBraces = 0; // number of braces found in the input
		// string
		int at = -1; // this will have the position where a match is found
		while(start < str.length()) {
			at = str.indexOf("{", start);
			if(at == -1)
				break;
			++numberOfPairBraces;
			start = at + 1;
		}

		return numberOfPairBraces;

	}

	/**
	 * Escribe un schemaRef válido en el documento.
	 * 
	 * @param inputStreamDocument documento con la instancia XBRL.
	 * @param taxonomyRoot ruta de la taxonomía.
	 * @param normalizedSchemaRef ruta normalizada del esquema base.
	 * @param ouputStreamXML documento de salida.
	 * @throws XBRLENLOCException si se produce un error.
	 */
	public static void normalizeSchema(InputStream inputStreamDocument, String taxonomyRoot,
	        String normalizedSchemaRef, ByteArrayOutputStream ouputStreamXML) throws XBRLENLOCException {
		try {
			String logicalUri = null;

			System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
			        "org.apache.xerces.jaxp.DocumentBuilderFactoryImpl");

			javax.xml.parsers.DocumentBuilderFactory dfactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
			dfactory.setNamespaceAware(true);
			dfactory.setIgnoringElementContentWhitespace(true);
			Document doc = dfactory.newDocumentBuilder().parse(inputStreamDocument);

			DeferredElementNSImpl schemaRefNode = (DeferredElementNSImpl) doc.getDocumentElement()
			        .getElementsByTagNameNS("http://www.xbrl.org/2003/linkbase", "schemaRef").item(0);
			if(schemaRefNode != null) {
				logicalUri = schemaRefNode.getAttributeNS("http://www.w3.org/1999/xlink", "href");
			}
			if((logicalUri == null) || (logicalUri.trim().equals(""))) {
				throw new XBRLENLOCException("notFoundSchemaRefInTheInstance", new String[] {});
			}

			doc.getDocumentElement().removeAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "schemaLocation");

			schemaRefNode.setAttributeNS("http://www.w3.org/1999/xlink", "href", normalizedSchemaRef);

			saveXML(doc, ouputStreamXML);

		} catch(XBRLENLOCException ex) {
			throw ex;
		} catch(Exception e) {
			throw new XBRLENLOCException(XBRLENLOCException.errorNormalizeSchema, e);
		}
	}

	/**
	 * Escribe un schemaRef valido en el documento
	 * 
	 * @param inputStreamDocument documento con la instancia XBRL.
	 * @param taxonomyRoot ruta de la taxonomía.
	 * @param ouputStreamXML documento de salida.
	 * @throws XBRLENLOCException si se produce un error.
	 */
	public static void normalizeSchema(InputStream inputStreamDocument, String taxonomyRoot,
	        ByteArrayOutputStream ouputStreamXML) throws XBRLENLOCException {
		try {
			String physicalUri = null;
			String logicalUri = null;

			System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
			        "org.apache.xerces.jaxp.DocumentBuilderFactoryImpl");

			javax.xml.parsers.DocumentBuilderFactory dfactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
			dfactory.setNamespaceAware(true);
			dfactory.setIgnoringElementContentWhitespace(true);
			Document doc = dfactory.newDocumentBuilder().parse(inputStreamDocument);

			DeferredElementNSImpl schemaRefNode = (DeferredElementNSImpl) doc.getDocumentElement()
			        .getElementsByTagNameNS("http://www.xbrl.org/2003/linkbase", "schemaRef").item(0);
			if(schemaRefNode != null) {
				logicalUri = schemaRefNode.getAttributeNS("http://www.w3.org/1999/xlink", "href");
			}

			if((logicalUri == null) || (logicalUri.trim().equals(""))) {
				throw new XBRLENLOCException("notFoundSchemaRefInTheInstance", new String[] {});
			}

			if(logicalUri.startsWith("http")) {
				XMLCatalogResolver catalog = XbrlApiConfiguration.getInstance().getResolver();
				String resolvedUri = catalog.resolveSystem(logicalUri);
				if((resolvedUri == null) || (resolvedUri.startsWith("http"))) {
					throw new XBRLENLOCException(XBRLENLOCException.canNotResolveSchemaRef, new String[] { logicalUri });
				}
				physicalUri = new File(new java.net.URL(resolvedUri).getPath()).getName();

				physicalUri = taxonomyRoot + physicalUri;

				doc.getDocumentElement().removeAttributeNS("http://www.w3.org/2001/XMLSchema-instance",
				        "schemaLocation");

				schemaRefNode.setAttributeNS("http://www.w3.org/1999/xlink", "href", physicalUri);
			}
			/*
			 * LENLOC Líneas añadidas para poder utilizar la taxonomía en el
			 * directorio '/taxonomy'
			 */
			//
			else {
				physicalUri = taxonomyRoot + logicalUri;

				doc.getDocumentElement().removeAttributeNS("http://www.w3.org/2001/XMLSchema-instance",
				        "schemaLocation");

				schemaRefNode.setAttributeNS("http://www.w3.org/1999/xlink", "href", physicalUri);
			}
			//
			/* FIN LENLOC - Final de líneas añadidas */
			saveXML(doc, ouputStreamXML);

		} catch(XBRLENLOCException ex) {
			throw ex;

		} catch(Exception e) {
			throw new XBRLENLOCException("errorNormalizeSchema", new String[] {}, e);
		}
	}

	/**
	 * Escribe un schemaRef valido en el documento.
	 * 
	 * @param inputStreamDocument documento con la instancia XBRL.
	 * @param taxonomyRoot ruta de la taxonomía.
	 * @param outputPath ruta del documento de salida.
	 * @throws XBRLENLOCException si se produce un error.
	 */
	public static void normalizeSchema(InputStream inputStreamDocument, String taxonomyRoot, String outputPath)
	        throws XBRLENLOCException {
		try {
			ByteArrayOutputStream inputStream = new ByteArrayOutputStream();
			ENLOCUtils.normalizeSchema(inputStreamDocument, XbrlApiConfiguration.getInstance().getTaxonomyRoot(),
			        inputStream);
			FileOutputStream fos = new FileOutputStream(outputPath);
			fos.write(inputStream.toByteArray());
			fos.flush();
			fos.close();
		} catch(XBRLENLOCException ex) {
			throw ex;
		} catch(Exception e) {
			throw new XBRLENLOCException("errorNormalizeSchema", new String[] {}, e);
		}

	}

	/**
	 * Serializa un XML a ByteArrayOutputStream.
	 * 
	 * @param doc documento que se va a serializar.
	 * @param outputStreamXML documento de salida.
	 * @throws Exception si se produce un error.
	 */
	public static void saveXML(Document doc, ByteArrayOutputStream outputStreamXML) throws Exception {

		System.setProperty(DOMImplementationRegistry.PROPERTY, "org.apache.xerces.dom.DOMImplementationSourceImpl");
		DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
		DOMImplementation domImpl = registry.getDOMImplementation("LS 3.0");
		DOMImplementationLS implLS = (DOMImplementationLS) domImpl;
		LSSerializer dom3Writer = implLS.createLSSerializer();

		LSOutput output = implLS.createLSOutput();

		output.setByteStream(outputStreamXML);
		output.setEncoding("UTF-8");
		dom3Writer.write(doc, output);
	}

	/**
	 * Lee un fichero y genera el correspondiente ByteArrayOutputStream.
	 * 
	 * @param inputFile documento de entrada.
	 * @param outputStream documento de salida.
	 * @throws XBRLENLOCException si se produce un error.
	 */
	public static void saveFileToByteArray(File inputFile, ByteArrayOutputStream outputStream)
	        throws XBRLENLOCException {
		FileInputStream inputStreamFile = null;
		try {
			inputStreamFile = new FileInputStream(inputFile);
			while(inputStreamFile.available() > 0) {
				outputStream.write(inputStreamFile.read());

			}

		} catch(Exception e) {
			throw new XBRLENLOCException(XBRLENLOCException.errorSavingFileToByteArray, new String[] {}, e);
		} finally {
			if(inputStreamFile != null) {
				try {
					inputStreamFile.close();
				} catch(IOException e) {
				}
			}
		}
	}

	/**
	 * Busca las trazas de error asociadas a un object.
	 * 
	 * @param objToTrace objeto del que se trazan los errores.
	 * @return trazas en String
	 */
	public static String getTraceObject(Object objToTrace) {
		String traceResult = "null";

		if(objToTrace != null) {

			if(objToTrace instanceof Item) {
				Item item = (Item) objToTrace;
				traceResult = "id=" + item.getId() + " " + "value=" + item.getValue() + " " + "decimals="
				        + item.getDecimals() + " reportingDate=" + item.getReportingDate();
			} else if(objToTrace instanceof Entity) {
				Entity entity = (Entity) objToTrace;
				traceResult = "id=" + entity.getId() + " " + "uri=" + entity.getUri();
			} else if(objToTrace instanceof Module) {
				Module module = (Module) objToTrace;
				traceResult = "id=" + module.getId() + " " + "baseDecimals=" + module.getBaseDecimals() + " "
				        + "baseUnit=" + module.getBaseUnit() + " startDate="
				        + module.getReportingStartDate().toString() + " endDate="
				        + module.getReportingEndDate().toString();
			} else if(objToTrace instanceof Note) {
				Note note = (Note) objToTrace;
				traceResult = "id=" + note.getId() + " " + "text=" + note.getText();
			} else if(objToTrace instanceof Row) {
				Row row = (Row) objToTrace;
				traceResult = "id=" + row.getId() + " " + "index=" + row.getIndex();
			} else if(objToTrace instanceof Report) {
				Report report = (Report) objToTrace;
				traceResult = "id=" + report.getId() + " " + "date=" + report.getDate();
			} else if(objToTrace instanceof Table) {
				Table table = (Table) objToTrace;
				traceResult = "id=" + table.getId();
			} else {
				System.out.println("Not exist trace for " + objToTrace);
				traceResult = "null";
			}
		}
		return "[" + traceResult + "]";

	}

	/**
	 * Obtiene el valor de una property a través de su name, en este caso un método perteneciente al objeto pasado como parámetro
	 * 
	 * @param getMethodName nombre del método
	 * @param objTarget objeto del que vamos a coger el método
	 * @return valor de la ejecución del método
	 */
	public static Object getPropertyValueByName(String getMethodName, Object objTarget) {

		Object value = null;
		try {
			Method method = objTarget.getClass().getDeclaredMethod(getMethodName, new Class[] {});
			value = method.invoke(objTarget, new Object[] {});

		} catch(SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;

	}

	/**
	 * Obtiene la fecha actual.
	 * 
	 * @return fecha actual.
	 */
	public static final java.util.Date getCurrentDate() {
		java.util.Date now = new java.util.Date();

		DateFormat ISO8601Local = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		TimeZone timeZone = TimeZone.getDefault();
		ISO8601Local.setTimeZone(timeZone);

		return now;
	}

	/**
	 * Obtiene el identificador de report de una instancia.
	 * 
	 * @param documentPath ruta del documento.
	 * @return identificador del report.
	 * @throws DocumentNotFoundException si no se encuentra el documento.
	 * @throws XBRLENLOCException si se produce un error.
	 */
	public static final String getReportID(String documentPath) throws DocumentNotFoundException, XBRLENLOCException {

		Document doc = null;
		String reportID = null;

		try {
			System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
			        "org.apache.xerces.jaxp.DocumentBuilderFactoryImpl");

			javax.xml.parsers.DocumentBuilderFactory dfactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
			dfactory.setNamespaceAware(true);
			dfactory.setIgnoringElementContentWhitespace(true);
			doc = dfactory.newDocumentBuilder().parse(new FileInputStream(documentPath));

			reportID = doc.getDocumentElement().getAttribute("id");

		} catch(FileNotFoundException e) {
			logger.error(e);
			throw new DocumentNotFoundException(DocumentNotFoundException.fileNotFound, new String[] { documentPath },
			        e);
		} catch(Exception e) {
			logger.error(e);
			throw new XBRLENLOCException(XBRLENLOCException.errorGettingReportID, new String[] { documentPath }, e);
		}

		return reportID;
	}

	/**
	 * Da un formato correcto a un error de validación de schema.
	 * 
	 * @param message mensaje de error.
	 * @param errorHandler objeto que almacena los mensajes.
	 * @throws Exception si se produce un error.
	 */
	public static void processSchemaValidationError(String message, GenericErrorsHandler errorHandler) throws Exception {
		ArrayList<String> params = new ArrayList<String>();
		// get the error message
		String errorMessage = message;
		// split error message using :, error messages will be of the format
		// errorcode:errormessage
		int spiltpoint = errorMessage.indexOf(':');
		String errorcode = "notFoundCode";

		if(spiltpoint > 0) {
			errorcode = errorMessage.substring(0, spiltpoint);
			String contentParams = errorMessage.substring(spiltpoint);

			Pattern p = Pattern.compile("('[^']+')");
			Matcher m = p.matcher(contentParams);
			while(m.find()) {
				String foundParam = contentParams.substring(m.start(), m.end());
				params.add(foundParam);
			}
		}
		errorHandler.addError(errorcode, message, params);
	}

	/**
	 * Crea un fichero temporal.
	 * 
	 * @param prefix prefijo del nombre del fichero.
	 * @param extension extensión del fichero.
	 * @return fichero creado.
	 * @throws XBRLENLOCException si se produce un error.
	 */
	public static final File createTempFile(String prefix, String extension) throws XBRLENLOCException {
		File instanceFile = null;
		try {
			String tempDirectory = XbrlApiConfiguration.getInstance().getTempDirectory();
			File tempDirectoryFile = new File(tempDirectory);
			if(!tempDirectoryFile.exists()) {
				throw new XBRLENLOCException(XBRLENLOCException.notExistTempDirectory, new String[] { tempDirectory });
			}
			instanceFile = File.createTempFile(prefix, extension, tempDirectoryFile);

		} catch(IOException e) {
			throw new XBRLENLOCException(XBRLENLOCException.errorCreatingTempFile, e);
		}
		return instanceFile;
	}

	/**
	 * Crea un fichero temporal.
	 * 
	 * @param inputDocument documento de entrada.
	 * @param prefix prefijo del nombre del fichero.
	 * @param extension extensión del fichero
	 * @return fichero creado.
	 * @throws XBRLENLOCException si se produce un error.
	 */
	public static final File createTempFile(byte[] inputDocument, String prefix, String extension)
	        throws XBRLENLOCException {
		File inputDocumentFile;
		try {

			String tempDirectory = XbrlApiConfiguration.getInstance().getTempDirectory();
			File tempDirectoryFile = new File(tempDirectory);
			if(!tempDirectoryFile.exists()) {
				throw new XBRLENLOCException(XBRLENLOCException.notExistTempDirectory, new String[] { tempDirectory });
			}
			inputDocumentFile = File.createTempFile(prefix, extension, tempDirectoryFile);
			FileOutputStream fos = new FileOutputStream(inputDocumentFile);
			fos.write(inputDocument);
			fos.flush();
			fos.close();

		} catch(IOException e) {
			throw new XBRLENLOCException("Error creating temporal file", e);
		}
		return inputDocumentFile;
	}

	/**
	 * Obtiene un miembro, buscándolo en la lista de de Members de un conceptMap
	 * dimensional mediante el nombre el member.
	 * 
	 * @param conceptMap referencia al conceptMap donde se busca el member
	 * 
	 * @param memberName nombre del member
	 * 
	 * @return member, si es encontrado o nulo en caso contrario
	 * 
	 */
	public static final Member getMemberByName(ConceptMap conceptMap, String memberName) {
		Member memberResponse = null;

		Member[] memberList = conceptMap.getMember();
		int numMembers = memberList.length;
		for(int i = 0; i < numMembers; i++) {
			Member currentMember = memberList[i];
			if(currentMember.getQname().equals(memberName)) {
				memberResponse = currentMember;
				break;
			}
		}

		return memberResponse;
	}

	/**
	 * Genera el id para un footnote.
	 * 
	 * @return Id del footnote.
	 */
	public static final String generateFootNoteID() {

		return "id_footnote_elem_" + UUID.randomUUID();
	}

	/**
	 * Se genera un footnote label identificador adecuado a las especificaciones
	 * de LENLOCPENLOC2010. <br /><br /> Este identificador se compone mediante
	 * la constante footnote_ concatenado con un número aleatorio.
	 * 
	 * @return footnote generado.
	 */
	public static final String generateFootNoteLabelID() {

		return "footnote_" + UUID.randomUUID();
	}

	/**
	 * Devuelve el numero aleatorio (code) generado formando parte del footnote.
	 * 
	 * @param footNoteID identificador del footNote.
	 * @return code del id del footnote.
	 */
	public static final String getCodeFromFootNoteID(String footNoteID) {

		return footNoteID.substring(footNoteID.lastIndexOf("_") + 1);
	}

	/**
	 * Obtiene el schemaRef de una instancia.
	 * 
	 * @param inputStreamDocument documento de entrada.
	 * @return schemaRef esquema base de la instancia.
	 * @throws XBRLENLOCException si se produce un error.
	 */
	public static final String getSchemaRef(InputStream inputStreamDocument) throws XBRLENLOCException {

		Document doc;
		String schemaRefUri = null;

		try {
			System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
			        "org.apache.xerces.jaxp.DocumentBuilderFactoryImpl");

			javax.xml.parsers.DocumentBuilderFactory dfactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
			dfactory.setNamespaceAware(true);
			dfactory.setIgnoringElementContentWhitespace(true);
			doc = dfactory.newDocumentBuilder().parse(inputStreamDocument);

			DeferredElementNSImpl schemaRefNode = (DeferredElementNSImpl) doc.getDocumentElement()
			        .getElementsByTagNameNS("http://www.xbrl.org/2003/linkbase", "schemaRef").item(0);

			String logicalUri = null;

			if(schemaRefNode != null) {
				logicalUri = schemaRefNode.getAttributeNS("http://www.w3.org/1999/xlink", "href");
			}

			if((logicalUri == null) || (logicalUri.trim().equals(""))) {
				throw new XBRLENLOCException("notFoundSchemaRefInTheInstance", new String[] {});
			}

			if(logicalUri.startsWith("http:")) {
				schemaRefUri = new File(new URL(logicalUri).getPath()).getName();
			} else {
				File f = new File(logicalUri);
				schemaRefUri = f.getName();
			}
		} catch(SAXException e) {
			throw new XBRLENLOCException(XBRLENLOCException.errorGettingSchema, e);
		} catch(IOException e) {
			throw new XBRLENLOCException(XBRLENLOCException.errorGettingSchema, e);
		} catch(ParserConfigurationException e) {
			throw new XBRLENLOCException(XBRLENLOCException.errorGettingSchema, e);
		}

		return schemaRefUri;
	}
}