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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

import es.inteco.xbrl.lenlocpenloc.config.ConfigurationManager;
import es.inteco.xbrl.lenlocpenloc.config.format.Module;
import es.inteco.xbrl.lenlocpenloc.config.format.Report;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.ConfigException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.DocumentNotFoundException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.TransformException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.ViewerException;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLENLOCException;
import es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer;
import es.inteco.xbrl.lenlocpenloc.utils.ENLOCUtils;
import es.inteco.xbrl.lenlocpenloc.utils.UtilConstants;
import es.inteco.xbrl.lenlocpenloc.utils.XSLTransformer;
import es.inteco.xbrl.lenlocpenloc.utils.XbrlApiConfiguration;

/**
 * 
 * 
 * Clase utilizada para visualizar informes desde un documento en formato XML o
 * XBRL.
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

public class ENLOCViewer implements IENLOCViewer {

	static Logger logger = Logger.getLogger(ENLOCViewer.class);
	static String processGeneratedInput = null;
	static String processGeneratedError = null;
	static int processTimeOut = 180000; // 3 minutes

	private ArrayList<String> loggerTraceList = null;
	/**
	 * Objeto utilizado para acceder a la configuación necesaria para realizar
	 * el proceso de transformación, mapas, global, etc.
	 */
	private ConfigurationManager configM = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.viewer.IENLOCViewer#getLoggerTraceList()
	 */
	public ArrayList<String> getLoggerTraceList() {
		return loggerTraceList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.viewer.IENLOCViewer#setLoggerTraceList(java
	 * .util.ArrayList )
	 */
	public void setLoggerTraceList(ArrayList<String> loggerList) {
		this.loggerTraceList = loggerList;
	}

	/**
	 * Constructor
	 * 
	 * @throws ViewerException
	 */
	ENLOCViewer() throws ViewerException {
		try {
			configM = ConfigurationManager.getInstance();
		} catch(DocumentNotFoundException e) {
			throw new ViewerException(ViewerException.errorCreatingViewer, e.getErrorsHandler());
		} catch(ConfigException e) {
			throw new ViewerException(ViewerException.errorCreatingViewer, e.getErrorsHandler());
		}
		// apiFacade = XbrlApiFactory.get_instance();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.viewer.IENLOCViewer#view(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	public void view(String inputPath, String module, String outputPath) throws ViewerException {
		try {
			byte[] xmlResult = ENLOCTransformer.createInstance().transformToXml(inputPath, false);
			byte[] htmlResult = viewXML(xmlResult, module);
			File outputFileHtml = new File(outputPath);
			FileOutputStream fos = new FileOutputStream(outputFileHtml);
			fos.write(htmlResult);
			fos.flush();
			fos.close();
		} catch(ViewerException ex) {
			throw ex;
		} catch(TransformException e) {
			throw new ViewerException(ViewerException.errorTryingViewInstance, e.getErrorsHandler());
		} catch(Exception e) {
			throw new ViewerException(ViewerException.errorTryingViewInstance, e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.viewer.IENLOCViewer#view(byte[],
	 * java.lang.String)
	 */
	public byte[] view(byte[] inputDocument, String module) throws ViewerException {
		File inputDocumentFile = null;
		File outputDocumentFile = null;
		byte[] resultHtml = null;
		try {

			inputDocumentFile = ENLOCUtils.createTempFile(inputDocument, "viewerxbrl", ".xbrl");
			outputDocumentFile = ENLOCUtils.createTempFile("viewerxbrl", ".xml");

			FileOutputStream fos = new FileOutputStream(outputDocumentFile);

			view(inputDocumentFile.getAbsolutePath(), module, outputDocumentFile.getAbsolutePath());

			ByteArrayOutputStream outputStreamHtml = new ByteArrayOutputStream();

			ENLOCUtils.saveFileToByteArray(outputDocumentFile, outputStreamHtml);

			resultHtml = outputStreamHtml.toByteArray();

			fos.close();

		} catch(ViewerException ex) {
			throw ex;
		} catch(XBRLENLOCException e) {
			throw new ViewerException(ViewerException.errorTryingViewInstance, e.getErrorsHandler());
		} catch(Exception e) {
			throw new ViewerException(ViewerException.errorTryingViewInstance, e);
		} finally {
			if((inputDocumentFile != null) && inputDocumentFile.exists()) {
				inputDocumentFile.delete();
			}
			if((outputDocumentFile != null) && outputDocumentFile.exists()) {
				outputDocumentFile.delete();
			}
		}
		return resultHtml;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.inteco.xbrl.lenlocpenloc.viewer.IENLOCViewer#viewXML(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	public void viewXML(String inputPath, String module, String outputPath) throws ViewerException {

		if(!configM.existModule(module)) {
			throw new ViewerException(ViewerException.errorModuleNotExist, new String[] { module });
		}

		String transformerRoot = XbrlApiConfiguration.getInstance().getXslTransformerPath();

		File testExistsFile = null;

		try {
			// validation
			testExistsFile = new File(inputPath);
			if(!(testExistsFile.exists())) {
				logger.error("Input file [" + inputPath + "] does not exists");
				throw new DocumentNotFoundException(DocumentNotFoundException.fileNotFound, new String[] { inputPath,
				        "Input file" });
			}

			if(!fileIsEmpty(inputPath, module)) {
				transformerRoot = transformerRoot.replaceAll("\\\\", "/");
				if(!(transformerRoot.endsWith("/"))) {
					transformerRoot += "/";
				}
				inputPath = inputPath.replaceAll("\\\\", "/");
				outputPath = outputPath.replaceAll("\\\\", "/");

				String xsl1 = transformerRoot + "xml2html.xsl";

				// validation
				testExistsFile = new File(xsl1);
				if(!(testExistsFile.exists())) {
					logger.error("Style sheet file [" + xsl1 + "] does not exists");
					throw new DocumentNotFoundException(DocumentNotFoundException.fileNotFound, new String[] { xsl1,
					        "Style sheet file at view process" });
				}

				String xslParams = "module=" + module + ";configPath=" + transformerRoot.replaceAll(" ", "%20");

				XSLTransformer.transform(inputPath, xsl1, outputPath, xslParams);

				testExistsFile = new File(outputPath);
				if(!(testExistsFile.exists())) {
					logger.error("Result file " + outputPath + "] has not been created");
					throw new ViewerException(ViewerException.errorTryingViewInstanceResultFile, new String[] {});
				}

				logger.info("Visualization has been generated " + outputPath);
			}

		} catch(ViewerException e) {
			throw e;
		} catch(DocumentNotFoundException e) {
			throw new ViewerException(ViewerException.errorTryingViewInstance, e.getErrorsHandler());
		} catch(XBRLENLOCException e) {
			throw new ViewerException(ViewerException.errorTryingViewInstance, e.getErrorsHandler());
		} catch(Throwable e) {
			throw new ViewerException(XBRLENLOCException.errorTryingViewInstance, e);
		}

	}

	/**
	 * 
	 * Comprueba que el fichero de formato común de entrada tiene datos.
	 * 
	 * @param inputPath ruta del fichero de formato común.
	 * @return boolean true si el fichero está vacío.
	 * @throws ViewerException si se produce un error en el proceso de Visualización
	 * 
	 */
	private boolean fileIsEmpty(String inputPath, String module) throws ViewerException {
		try {
			Report report = loadReport(inputPath);
			int numModules = report.getModuleCount();
			if(numModules == 0) {
				throw new ViewerException(ViewerException.fileIsEmpty, new String[] { inputPath });
			}
			boolean moduleExist = false;
			int numChildrenModule = 0;
			for(int i = 0; i < numModules; i++) {
				Module moduleReport = report.getModule(i);
				if(moduleReport.getId().equals(module)) {
					moduleExist = true;
					int numTables = moduleReport.getTableCount();
					int numItems = moduleReport.getItemCount();
					numChildrenModule = numTables + numItems;
				}
			}
			if(!moduleExist || numChildrenModule == 0) {
				throw new ViewerException(ViewerException.errorNoDataInModule, new String[] { inputPath, module });
			}
		} catch(ConfigException e) {
			throw new ViewerException(ViewerException.errorLoadingInputFile, new String[] { inputPath }, e
			        .getErrorsHandler());
		} catch(DocumentNotFoundException e) {
			throw new ViewerException(ViewerException.errorLoadingInputFile, new String[] { inputPath }, e
			        .getErrorsHandler());
		}
		return false;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.inteco.xbrl.lenlocpenloc.viewer.IENLOCViewer#viewXML(byte[],
	 * java.lang.String)
	 */
	public byte[] viewXML(byte[] inputDocument, String module) throws ViewerException {

		File inputDocumentFile = null;
		File outputDocumentFile = null;
		byte[] htmlResult = null;
		try {
			String tempDirectory = XbrlApiConfiguration.getInstance().getTempDirectory();
			File tempDirectoryFile = new File(tempDirectory);
			if(!tempDirectoryFile.exists()) {
				throw new XBRLENLOCException(XBRLENLOCException.notExistTempDirectory, new String[] { tempDirectory });
			}
			inputDocumentFile = ENLOCUtils.createTempFile(inputDocument, "viewerxml", ".xml");
			outputDocumentFile = ENLOCUtils.createTempFile("viewerhtml", ".html");

			viewXML(inputDocumentFile.getAbsolutePath(), module, outputDocumentFile.getAbsolutePath());

			ByteArrayOutputStream outputStreamHtml = new ByteArrayOutputStream();

			ENLOCUtils.saveFileToByteArray(outputDocumentFile, outputStreamHtml);

			htmlResult = outputStreamHtml.toByteArray();

		} catch(ViewerException ex) {
			throw ex;
		} catch(Exception e) {
			throw new ViewerException(XBRLENLOCException.errorTryingViewInstance, e);
		} finally {
			if((inputDocumentFile != null) && inputDocumentFile.exists()) {
				inputDocumentFile.delete();
			}
			if((outputDocumentFile != null) && outputDocumentFile.exists()) {
				outputDocumentFile.delete();
			}
		}
		return htmlResult;

	}

	/**
	 * Crea una instancia de la propia clase
	 * 
	 * @return Objeto del tipo IENLOCViewer
	 * 
	 * @throws ViewerException error al intentar devolver la instancia
	 */
	public static IENLOCViewer createInstance() throws ViewerException {
		return new ENLOCViewer();
	}
}