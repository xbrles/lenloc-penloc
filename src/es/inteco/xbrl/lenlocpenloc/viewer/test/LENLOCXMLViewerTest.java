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

public class LENLOCXMLViewerTest {

	static String testPath;
	static String INPUT_PATH;
	static String OUTPUT_PATH;

	private static final String LENLOC_XBRL_MODULO_DI = "DI";
	private static final String LENLOC_XBRL_MODULO_A1 = "A1";
	private static final String LENLOC_XBRL_MODULO_A2 = "A2";
	private static final String LENLOC_XBRL_MODULO_A3P = "A3P";
	private static final String LENLOC_XBRL_MODULO_A3R = "A3R";
	private static final String LENLOC_XBRL_MODULO_A4EA = "A4EA";
	private static final String LENLOC_XBRL_MODULO_A4RA = "A4RA";
	private static final String LENLOC_XBRL_MODULO_A5 = "A5";
	private static final String LENLOC_XBRL_MODULO_GAST = "GAST";
	private static final String LENLOC_XBRL_MODULO_ING = "ING";
	private static final String LENLOC_XBRL_MODULO_CB = "CB";
	private static final String LENLOC_XBRL_MODULO_ACR = "ACR";
	private static final String LENLOC_XBRL_MODULO_DEU = "DEU";
	private static final String LENLOC_XBRL_MODULO_PROG = "PROG";
	private static final String LENLOC_XBRL_MODULO_RT = "RT";
	private static final String LENLOC_XBRL_MODULO_RP = "RP";
	private static final String LENLOC_XBRL_MODULO_RPA = "RPA";

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
	public final void viewLENLOCXMLmodDIOK() {
		inputPath = INPUT_PATH + "UTS32-TC01.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC01.html";

		try {
			viewer.viewXML(inputPath, LENLOC_XBRL_MODULO_DI, outputPath);

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
	public final void viewLENLOCXMLmodA1OK() {
		inputPath = INPUT_PATH + "UTS32-TC02.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC02.html";

		try {
			viewer.viewXML(inputPath, LENLOC_XBRL_MODULO_A1, outputPath);

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
	public final void viewLENLOCXMLmodA2OK() {
		inputPath = INPUT_PATH + "UTS32-TC03.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC03.html";

		try {
			viewer.viewXML(inputPath, LENLOC_XBRL_MODULO_A2, outputPath);

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
	public final void viewLENLOCXMLmodA3POK() {
		inputPath = INPUT_PATH + "UTS32-TC04.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC04.html";

		try {
			viewer.viewXML(inputPath, LENLOC_XBRL_MODULO_A3P, outputPath);

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
	public final void viewLENLOCXMLmodA3ROK() {
		inputPath = INPUT_PATH + "UTS32-TC05.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC05.html";

		try {
			viewer.viewXML(inputPath, LENLOC_XBRL_MODULO_A3R, outputPath);

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
	public final void viewLENLOCXMLmodA4EAOK() {
		inputPath = INPUT_PATH + "UTS32-TC06.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC06.html";

		try {
			viewer.viewXML(inputPath, LENLOC_XBRL_MODULO_A4EA, outputPath);

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
	public final void viewLENLOCXMLmodA4RAOK() {
		inputPath = INPUT_PATH + "UTS32-TC07.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC07.html";

		try {
			viewer.viewXML(inputPath, LENLOC_XBRL_MODULO_A4RA, outputPath);

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
	public final void viewLENLOCXMLmodA5OK() {
		inputPath = INPUT_PATH + "UTS32-TC08.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC08.html";

		try {
			viewer.viewXML(inputPath, LENLOC_XBRL_MODULO_A5, outputPath);

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
	public final void viewLENLOCXMLmodGASTOK() {
		inputPath = INPUT_PATH + "UTS32-TC09.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC09.html";

		try {
			viewer.viewXML(inputPath, LENLOC_XBRL_MODULO_GAST, outputPath);

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
	public final void viewLENLOCXMLmodINGOK() {
		inputPath = INPUT_PATH + "UTS32-TC10.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC10.html";

		try {
			viewer.viewXML(inputPath, LENLOC_XBRL_MODULO_ING, outputPath);

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
	public final void viewLENLOCXMLmodCBOK() {
		inputPath = INPUT_PATH + "UTS32-TC11.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC11.html";

		try {
			viewer.viewXML(inputPath, LENLOC_XBRL_MODULO_CB, outputPath);

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
	public final void viewLENLOCXMLmodACROK() {
		inputPath = INPUT_PATH + "UTS32-TC12.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC12.html";

		try {
			viewer.viewXML(inputPath, LENLOC_XBRL_MODULO_ACR, outputPath);

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
	public final void viewLENLOCXMLmodDEUOK() {
		inputPath = INPUT_PATH + "UTS32-TC13.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC13.html";

		try {
			viewer.viewXML(inputPath, LENLOC_XBRL_MODULO_DEU, outputPath);

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
	public final void viewLENLOCXMLmodPROGOK() {
		inputPath = INPUT_PATH + "UTS32-TC14.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC14.html";

		try {
			viewer.viewXML(inputPath, LENLOC_XBRL_MODULO_PROG, outputPath);

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
	public final void viewLENLOCXMLmodRTOK() {
		inputPath = INPUT_PATH + "UTS32-TC15.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC15.html";

		try {
			viewer.viewXML(inputPath, LENLOC_XBRL_MODULO_RT, outputPath);

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
	public final void viewLENLOCXMLmodRPOK() {
		inputPath = INPUT_PATH + "UTS32-TC16.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC16.html";

		try {
			viewer.viewXML(inputPath, LENLOC_XBRL_MODULO_RP, outputPath);

		} catch(ViewerException e) {
			e.printStackTrace();
			fail("Se ha producido un " + "error al generar la visualización." + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.viewer.ENLOCViewer#viewXML(java.lang.String inputPath, java.lang.String module, java.lang.String outputPath)}
	 * .
	 */
	@Test
	public final void viewLENLOCXMLmodRPAOK() {
		inputPath = INPUT_PATH + "UTS32-TC17.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC17.html";

		try {
			viewer.viewXML(inputPath, LENLOC_XBRL_MODULO_RPA, outputPath);

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
	public final void viewLENLOCXMLInputNotDataKO() {
		inputPath = INPUT_PATH + "UTS32-TC18.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC18.html";

		try {
			viewer.viewXML(inputPath, LENLOC_XBRL_MODULO_RT, outputPath);
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
	public final void viewLENLOCXMLDocumentNotFoundKO() {
		inputPath = INPUT_PATH + "UTS32-TC19.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC19.html";

		try {
			viewer.viewXML(inputPath, LENLOC_XBRL_MODULO_RT, outputPath);
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
	public final void viewLENLOCXMLInputNotXMLKO() {
		inputPath = INPUT_PATH + "UTS32-TC20.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC20.html";

		try {
			viewer.viewXML(inputPath, LENLOC_XBRL_MODULO_RT, outputPath);
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
	public final void viewLENLOCXMLModuleNotExistKO() {
		inputPath = INPUT_PATH + "UTS32-TC21.xml";
		outputPath = OUTPUT_PATH + "UTS32-TC21.html";

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