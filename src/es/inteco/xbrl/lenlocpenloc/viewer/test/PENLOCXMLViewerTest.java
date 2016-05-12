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
package es.inteco.xbrl.lenlocpenloc.viewer.test;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

import es.inteco.xbrl.lenlocpenloc.errors.exceptions.ViewerException;
import es.inteco.xbrl.lenlocpenloc.viewer.ENLOCViewer;
import es.inteco.xbrl.lenlocpenloc.viewer.IENLOCViewer;

/**
 * 
 * 
 * TODO Incluir descripción de la clase
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
 * @version 1.0, 31/07/2009
 * @author difusioncalidad@inteco.es
 * @see
 * 
 */

public class PENLOCXMLViewerTest {

	static String testPath;
	static String INPUT_PATH;
	static String OUTPUT_PATH;

	private static final String PENLOC_XBRL_MODULO_PDI = "PDI";
	private static final String PENLOC_XBRL_MODULO_PING = "PING";
	private static final String PENLOC_XBRL_MODULO_PPROG = "PPROG";
	private static final String PENLOC_XBRL_MODULO_PGAST = "PGAST";

	String inputPath;
	String outputPath;
	static IENLOCViewer viewer;

	@BeforeClass
	public static void init() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("./config/enloc.properties"));
			testPath = prop.getProperty("testPath");
			INPUT_PATH = testPath + "viewer/input/";
			OUTPUT_PATH = testPath + "viewer/output/";
			viewer = ENLOCViewer.createInstance();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ViewerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.viewer.ENLOCViewer#viewXML(java.lang.String inputPath, java.lang.String module, java.lang.String outputPath)}
	 * .
	 */
	@Test
	public final void viewPENLOCXMLmodPDIOK() {
		inputPath = INPUT_PATH + "UTS32-TC22.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC22.html";

		try {
			viewer.viewXML(inputPath, PENLOC_XBRL_MODULO_PDI, outputPath);

		} catch(ViewerException e) {
			e.printStackTrace();
			fail("Se ha producido un error al generar la visualización." + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.viewer.ENLOCViewer#viewXML(java.lang.String inputPath, java.lang.String module, java.lang.String outputPath)}
	 * .
	 */
	@Test
	public final void viewPENLOCXMLmodPINGOK() {
		inputPath = INPUT_PATH + "UTS32-TC23.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC23.html";

		try {
			viewer.viewXML(inputPath, PENLOC_XBRL_MODULO_PING, outputPath);

		} catch(ViewerException e) {
			e.printStackTrace();
			fail("Se ha producido un error al generar la visualización." + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.viewer.ENLOCViewer#viewXML(java.lang.String inputPath, java.lang.String module, java.lang.String outputPath)}
	 * .
	 */
	@Test
	public final void viewPENLOCXMLmodPPROGOK() {
		inputPath = INPUT_PATH + "UTS32-TC24.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC24.html";

		try {
			viewer.viewXML(inputPath, PENLOC_XBRL_MODULO_PPROG, outputPath);

		} catch(ViewerException e) {
			e.printStackTrace();
			fail("Se ha producido un error al generar la visualización." + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.viewer.ENLOCViewer#viewXML(java.lang.String inputPath, java.lang.String module, java.lang.String outputPath)}
	 * .
	 */
	@Test
	public final void viewPENLOCXMLmodPGASTOK() {
		inputPath = INPUT_PATH + "UTS32-TC25.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC25.html";

		try {
			viewer.viewXML(inputPath, PENLOC_XBRL_MODULO_PGAST, outputPath);

		} catch(ViewerException e) {
			e.printStackTrace();
			fail("Se ha producido un error al generar la visualización." + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.viewer.ENLOCViewer#viewXML(java.lang.String inputPath, java.lang.String module, java.lang.String outputPath)}
	 * .
	 */
	@Test
	public final void viewPENLOCXMLInputNotDataKO() {
		inputPath = INPUT_PATH + "UTS32-TC26.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC26.html";

		try {
			viewer.viewXML(inputPath, PENLOC_XBRL_MODULO_PING, outputPath);
			fail("No se ha producido un error, y debería haberse producido al generar la visualización.");
		} catch(ViewerException e) {
			try {
				e.printStackTrace(new PrintStream(new File(outputPath.replace(outputPath.substring(outputPath
				        .lastIndexOf(".") + 1), "txt"))));
			} catch(FileNotFoundException e1) {

			}
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.viewer.ENLOCViewer#viewXML(java.lang.String inputPath, java.lang.String module, java.lang.String outputPath)}
	 * .
	 */
	@Test
	public final void viewPENLOCXMLDocumentNotFoundKO() {
		inputPath = INPUT_PATH + "UTS32-TC27.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC27.html";

		try {
			viewer.viewXML(inputPath, PENLOC_XBRL_MODULO_PING, outputPath);
			fail("No se ha producido un error, y debería haberse producido al generar la visualización.");
		} catch(ViewerException e) {
			try {
				e.printStackTrace(new PrintStream(new File(outputPath.replace(outputPath.substring(outputPath
				        .lastIndexOf(".") + 1), "txt"))));
			} catch(FileNotFoundException e1) {

			}
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.viewer.ENLOCViewer#viewXML(java.lang.String inputPath, java.lang.String module, java.lang.String outputPath)}
	 * .
	 */
	@Test
	public final void viewPENLOCXMLInputNotXMLKO() {
		inputPath = INPUT_PATH + "UTS32-TC28.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC28.html";

		try {
			viewer.viewXML(inputPath, PENLOC_XBRL_MODULO_PING, outputPath);
			fail("No se ha producido un error, y debería haberse producido al generar la visualización.");
		} catch(ViewerException e) {
			try {
				e.printStackTrace(new PrintStream(new File(outputPath.replace(outputPath.substring(outputPath
				        .lastIndexOf(".") + 1), "txt"))));
			} catch(FileNotFoundException e1) {

			}
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.viewer.ENLOCViewer#viewXML(java.lang.String inputPath, java.lang.String module, java.lang.String outputPath)}
	 * .
	 */
	@Test
	public final void viewPENLOCXMLModuleNotExistKO() {
		inputPath = INPUT_PATH + "UTS32-TC29.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC29.html";

		try {
			viewer.viewXML(inputPath, "MODULO_NO_EXISTE", outputPath);
			fail("No se ha producido un error, y debería haberse producido al generar la visualización.");
		} catch(ViewerException e) {
			try {
				e.printStackTrace(new PrintStream(new File(outputPath.replace(outputPath.substring(outputPath
				        .lastIndexOf(".") + 1), "txt"))));
			} catch(FileNotFoundException e1) {

			}
			e.printStackTrace();
		}
	}
}