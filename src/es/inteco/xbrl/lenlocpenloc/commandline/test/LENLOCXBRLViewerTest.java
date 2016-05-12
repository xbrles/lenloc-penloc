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
package es.inteco.xbrl.lenlocpenloc.commandline.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

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
 * @version 1.0, 30/07/2009
 * @author difusioncalidad@inteco.es
 * @see
 * 
 */

public class LENLOCXBRLViewerTest {

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

	static String testPath;
	static String INPUT_PATH;
	static String OUTPUT_PATH;
	static String BAT_PATH;

	String inputPath;
	String outputPath;
	String errorsPath;
	String batPath;

	@BeforeClass
	public static void init() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("./config/enloc.properties"));
			testPath = prop.getProperty("testPath");
			INPUT_PATH = testPath + "commandline/viewer/input/";
			OUTPUT_PATH = testPath + "commandline/viewer/output/";
			BAT_PATH = testPath + "commandline/";
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewLENLOCXBRLmodDIOK() {
		inputPath = INPUT_PATH + "ITS45-TC01.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC01.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC01_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        LENLOC_XBRL_MODULO_DI, "-o", outputPath, "-e", errorsPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != 0) {
				throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba 0");
			}
		} catch(Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewLENLOCXBRLmodA1OK() {
		inputPath = INPUT_PATH + "ITS45-TC02.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC02.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC02_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        LENLOC_XBRL_MODULO_A1, "-o", outputPath, "-e", errorsPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != 0) {
				throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba 0");
			}
		} catch(Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewLENLOCXBRLmodA2OK() {
		inputPath = INPUT_PATH + "ITS45-TC03.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC03.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC03_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        LENLOC_XBRL_MODULO_A2, "-o", outputPath, "-e", errorsPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != 0) {
				throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba 0");
			}
		} catch(Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewLENLOCXBRLmodA3POK() {
		inputPath = INPUT_PATH + "ITS45-TC04.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC04.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC04_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        LENLOC_XBRL_MODULO_A3P, "-o", outputPath, "-e", errorsPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != 0) {
				throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba 0");
			}
		} catch(Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewLENLOCXBRLmodA3ROK() {
		inputPath = INPUT_PATH + "ITS45-TC05.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC05.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC05_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        LENLOC_XBRL_MODULO_A3R, "-o", outputPath, "-e", errorsPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != 0) {
				throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba 0");
			}
		} catch(Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewLENLOCXBRLmodA4EAOK() {
		inputPath = INPUT_PATH + "ITS45-TC06.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC06.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC06_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        LENLOC_XBRL_MODULO_A4EA, "-o", outputPath, "-e", errorsPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != 0) {
				throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba 0");
			}
		} catch(Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewLENLOCXBRLmodA4RAOK() {
		inputPath = INPUT_PATH + "ITS45-TC07.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC07.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC07_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        LENLOC_XBRL_MODULO_A4RA, "-o", outputPath, "-e", errorsPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != 0) {
				throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba 0");
			}
		} catch(Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewLENLOCXBRLmodA5OK() {
		inputPath = INPUT_PATH + "ITS45-TC08.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC08.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC08_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        LENLOC_XBRL_MODULO_A5, "-o", outputPath, "-e", errorsPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != 0) {
				throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba 0");
			}
		} catch(Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewLENLOCXBRLmodGASTOK() {
		inputPath = INPUT_PATH + "ITS45-TC09.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC09.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC09_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        LENLOC_XBRL_MODULO_GAST, "-o", outputPath, "-e", errorsPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != 0) {
				throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba 0");
			}
		} catch(Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewLENLOCXBRLmodINGOK() {
		inputPath = INPUT_PATH + "ITS45-TC10.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC10.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC10_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        LENLOC_XBRL_MODULO_ING, "-o", outputPath, "-e", errorsPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != 0) {
				throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba 0");
			}
		} catch(Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewLENLOCXBRLmodCBOK() {
		inputPath = INPUT_PATH + "ITS45-TC11.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC11.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC11_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        LENLOC_XBRL_MODULO_CB, "-o", outputPath, "-e", errorsPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != 0) {
				throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba 0");
			}
		} catch(Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewLENLOCXBRLmodACROK() {
		inputPath = INPUT_PATH + "ITS45-TC12.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC12.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC12_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        LENLOC_XBRL_MODULO_ACR, "-o", outputPath, "-e", errorsPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != 0) {
				throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba 0");
			}
		} catch(Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewLENLOCXBRLmodDEUOK() {
		inputPath = INPUT_PATH + "ITS45-TC13.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC13.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC13_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        LENLOC_XBRL_MODULO_DEU, "-o", outputPath, "-e", errorsPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != 0) {
				throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba 0");
			}
		} catch(Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewLENLOCXBRLmodPROGOK() {
		inputPath = INPUT_PATH + "ITS45-TC14.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC14.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC14_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        LENLOC_XBRL_MODULO_PROG, "-o", outputPath, "-e", errorsPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != 0) {
				throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba 0");
			}
		} catch(Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewLENLOCXBRLmodRTOK() {
		inputPath = INPUT_PATH + "ITS45-TC15.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC15.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC15_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        LENLOC_XBRL_MODULO_RT, "-o", outputPath, "-e", errorsPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != 0) {
				throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba 0");
			}
		} catch(Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewLENLOCXBRLmodRPOK() {
		inputPath = INPUT_PATH + "ITS45-TC16.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC16.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC16_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        LENLOC_XBRL_MODULO_RP, "-o", outputPath, "-e", errorsPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != 0) {
				throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba 0");
			}
		} catch(Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewLENLOCXBRLmodRPAOK() {
		inputPath = INPUT_PATH + "ITS45-TC17.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC17.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC17_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        LENLOC_XBRL_MODULO_RPA, "-o", outputPath, "-e", errorsPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != 0) {
				throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba 0");
			}
		} catch(Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewLENLOCXBRLInputNotDataKO() {
		inputPath = INPUT_PATH + "ITS45-TC26.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC26.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC26_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        LENLOC_XBRL_MODULO_RT, "-o", outputPath, "-e", errorsPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != -1) {
				throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba 0");
			}
		} catch(Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewLENLOCXBRLModuleNotExistKO() {
		inputPath = INPUT_PATH + "ITS45-TC27.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC27.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC27_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        "MODULE_NOT_EXIST", "-o", outputPath, "-e", errorsPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != -1) {
				throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba -1");
			}
		} catch(Exception e) {
			throw new AssertionError(e);
		}
	}
}