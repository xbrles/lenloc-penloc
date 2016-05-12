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
 * Copyright (C) 2009 INTECO (Instituto Nacional de Tecnolog�as de la
 * Comunicaci�n, S.A.)
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;

import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLENLOCException;

/**
 * 
 * 
 * Clase que transforma ficheros mediante una hoja de estilos.
 * 
 * 
 *<br>
 * <br>
 * <b>Proyecto</b>: API XBRL-LENLOCPENLOC2010 - Grupo de utilidades y librer�as
 * en c�digo abierto para facilitar la integraci�n del formato XBRL en las
 * herramientas software de gesti�n de terceros aisl�ndose de la complejidad en
 * el procesamiento del modelo de datos de las taxonom�as. Ayudando de esta
 * forma a las entidades locales en la labor de realizaci�n de informes XBRL y
 * asegurar el �xito en el reporte de presupuestos y liquidaci�n de presupuestos
 * de las entidades locales en formato XBRL
 * 
 * 
 * @version 1.0, 24/06/2009
 * @author difusioncalidad@inteco.es
 * 
 */

public abstract class XSLTransformer {

	static Logger logger = Logger.getLogger(XSLTransformer.class);

	/**
	 * Punto de entrada de ejecuci�n
	 * 
	 * @param args Array de parametros de entrada en el siguiente orden <br>
	 *        1. Documento a transformar, <br>
	 *        2. Hoja de estilos utilizada en la transformaci�n <br>
	 *        3. Documento de salida generado tras la transformacion, <br>
	 *        4. opcionalmente, parametros de entrada a la XSL. Ser� una lista
	 *        de parametros separados entre si por ';' y con el formato
	 *        parametro1=valor1;parametro2=valor2... <br>
	 * <br>
	 *        Los path con espacios en blanco, deben enviarse entrecomillados
	 * 
	 */
	public static void main(String args[]) {
		try {
			if((args == null) || (args.length < 3) || (args.length > 4)) {
				logger
				        .error("FAILED. Waiting for 3 or 4 parameters: input document, style sheet, output document and, optionally, xsl param list");
				System.err
				        .append("FAILED. Waiting for 3 or 4 parameters: input document, style sheet, output document and, optionally, xsl param list");
				System.exit(-1);
			}

			String inputDocument = args[0];
			String stylesheet = args[1];
			String outputDocument = args[2];
			String paramsList = null; // paramsList = all params a semicolon
			// separated like:
			// param1=value1;param2=value2

			if(args.length == 4) {
				paramsList = args[3];
			}

			File testExistsFile = null;
			testExistsFile = new File(inputDocument);
			if(!(testExistsFile.exists())) {
				logger.error("Input path [" + inputDocument + "] does not exists");
				System.err.append("Input path [" + inputDocument + "] does not exists");
				System.exit(-1);
			}
			testExistsFile = new File(stylesheet);
			if(!(testExistsFile.exists())) {
				logger.error("Style sheet [" + stylesheet + "] does not exists");
				System.err.append("Style sheet [" + stylesheet + "] does not exists");
				System.exit(-1);
			}

			logger.info("Start transformation process input[" + inputDocument + "], style sheet[" + stylesheet
			        + "], param[" + paramsList + "]");

			transform(inputDocument, stylesheet, outputDocument, paramsList);

			logger.info("Transformation process input[" + inputDocument + "], style sheet[" + stylesheet + "], param["
			        + paramsList + "] finish successfully");

			System.exit(0);
		} catch(Throwable e) {
			logger.error(e);
			System.err.append(e.toString());
			System.exit(-1);
		}
	}

	/**
	 * M�todo encargado de realizar la transformaci�n XSL
	 * 
	 * @param inputPath Documento origen
	 * @param xslPath Hoja de estilos
	 * @param outputPath Documento de salida
	 * @param xslParamList Lista de parametros para la hoja de estilos. Ser� una
	 *        lista de par�metros separados entre si por ';' y con el formato
	 *        parametro1=valor1;parametro2=valor2... Los path's con espacios en
	 *        blanco, deben enviarse entre comillas.
	 * @throws XBRLENLOCException
	 */
	public static void transform(String inputPath, String xslPath, String outputPath, String xslParamList)
	        throws XBRLENLOCException {
		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			File xslFile = new File(xslPath);
			FileInputStream fis = new FileInputStream(xslFile);
			Source xslSource = new StreamSource(fis);
			Transformer transformer = tFactory.newTransformer(xslSource);
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			if(!(xslParamList == null || xslParamList.equals(""))) {
				try {
					String[] arrParams = xslParamList.split(";");
					for(int i = 0; i < arrParams.length; i++) {
						String individualParam = arrParams[i];
						if(individualParam.contains("=")) {
							String[] newParam = individualParam.split("=");
							logger.info("set parameter for xsl name: [" + (String) newParam[0] + "] value: ["
							        + (String) newParam[1] + "]");
							transformer.setParameter((String) newParam[0], (String) newParam[1]);
						}
					}
				} catch(Throwable e) {
					throw new XBRLENLOCException(XBRLENLOCException.errorParamsTransformation, e);
				}
			}

			// send result transformation to a file
			StreamResult resultToFile = new StreamResult(new FileOutputStream(outputPath));
			File inputFile = new File(inputPath);
			FileInputStream inputFis = new FileInputStream(inputFile);
			Source inputSource = new StreamSource(inputFis);
			transformer.transform(inputSource, resultToFile);
		} catch(Throwable e) {
			throw new XBRLENLOCException(XBRLENLOCException.errorInXSLTTransformation, e);
		}
	}
}