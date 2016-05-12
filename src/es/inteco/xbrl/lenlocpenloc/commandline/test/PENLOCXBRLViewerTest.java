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

public class PENLOCXBRLViewerTest {

	public static final String PENLOC_XBRL_MODULO_PDI = "PDI";
	public static final String PENLOC_XBRL_MODULO_PING = "PING";
	public static final String PENLOC_XBRL_MODULO_PPROG = "PPROG";
	public static final String PENLOC_XBRL_MODULO_PGAST = "PGAST";

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
	public final void commandlineViewPENLOCXBRLmodPDIOK() {
		inputPath = INPUT_PATH + "ITS45-TC18.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC18.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC18_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        PENLOC_XBRL_MODULO_PDI, "-o", outputPath, "-e", errorsPath };
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
	public final void commandlineViewPENLOCXBRLmodPINGOK() {
		inputPath = INPUT_PATH + "ITS45-TC19.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC19.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC19_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        PENLOC_XBRL_MODULO_PING, "-o", outputPath, "-e", errorsPath };
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
	public final void commandlineViewPENLOCXBRLmodPPROGOK() {
		inputPath = INPUT_PATH + "ITS45-TC20.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC20.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC20_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        PENLOC_XBRL_MODULO_PPROG, "-o", outputPath, "-e", errorsPath };
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
	public final void commandlineViewPENLOCXBRLmodPGASTOK() {
		inputPath = INPUT_PATH + "ITS45-TC21.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC21.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC21_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        PENLOC_XBRL_MODULO_PGAST, "-o", outputPath, "-e", errorsPath };
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
	public final void commandlineViewPENLOCXBRLInputNotDataKO() {
		inputPath = INPUT_PATH + "ITS45-TC22.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC22.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC22_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        PENLOC_XBRL_MODULO_PING, "-o", outputPath, "-e", errorsPath };
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

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewPENLOCXBRLDocumentNotFoundKO() {
		inputPath = INPUT_PATH + "ITS45-TC23.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC23.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC23_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        PENLOC_XBRL_MODULO_PING, "-o", outputPath, "-e", errorsPath };
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

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewPENLOCXBRLInputXBRLNotEnlocKO() {
		inputPath = INPUT_PATH + "ITS45-TC24.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC24.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC24_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m",
		        PENLOC_XBRL_MODULO_PING, "-o", outputPath, "-e", errorsPath };
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

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineViewPENLOCXBRLModuleNotExistKO() {
		inputPath = INPUT_PATH + "ITS45-TC25.xbrl";
		outputPath = OUTPUT_PATH + "ITS45-TC25.html";
		errorsPath = OUTPUT_PATH + "ITS45-TC25_errors.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-xbrltohtml", "-i", inputPath, "-m", "NOT_EXIST",
		        "-o", outputPath, "-e", errorsPath };
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