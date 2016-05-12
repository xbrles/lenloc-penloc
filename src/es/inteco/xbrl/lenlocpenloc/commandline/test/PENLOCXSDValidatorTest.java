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
 * @version 1.0, 27/07/2009
 * @author difusioncalidad@inteco.es
 * @see
 * 
 */

public class PENLOCXSDValidatorTest {

	static String testPath;
	static String INPUT_PATH;
	static String OUTPUT_PATH;
	static String BAT_PATH;

	String inputPath;
	String errorsPath;
	String validationPath;
	String batPath;

	@BeforeClass
	public static void init() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("./config/enloc.properties"));
			testPath = prop.getProperty("testPath");
			INPUT_PATH = testPath + "commandline/validator/input/";
			OUTPUT_PATH = testPath + "commandline/validator/output/";
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
	public final void commandlineValidateXSDPENLOCallOK() {
		inputPath = INPUT_PATH + "ITS44-TC05.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC05_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC05_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath,
		        "-v", validationPath };
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
	public final void commandlineValidateXSDPENLOCDocumentNotFoundKO() {
		inputPath = INPUT_PATH + "ITS44-TC06.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC06_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC06_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath,
		        "-v", validationPath };
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
	public final void commandlineValidateXSDPENLOCAttributeNotDefinedKO() {
		inputPath = INPUT_PATH + "ITS44-TC07.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC07_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC07_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath,
		        "-v", validationPath };
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
	public final void commandlineValidateXSDPENLOCElementRequiredKO() {
		inputPath = INPUT_PATH + "ITS44-TC08.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC08_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC08_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath,
		        "-v", validationPath };
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
	public final void commandlineValidateXSDPENLOCmodPDIOK() {
		inputPath = INPUT_PATH + "ITS44-TC33.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC33_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC33_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath,
		        "-v", validationPath };
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
	public final void commandlineValidateXSDPENLOCmodPINGOK() {
		inputPath = INPUT_PATH + "ITS44-TC34.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC34_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC34_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath,
		        "-v", validationPath };
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
	public final void commandlineValidateXSDPENLOCmodPPROGOK() {
		inputPath = INPUT_PATH + "ITS44-TC35.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC35_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC35_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath,
		        "-v", validationPath };
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
	public final void commandlineValidateXSDPENLOCmodPGASTOK() {
		inputPath = INPUT_PATH + "ITS44-TC36.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC36_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC36_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath,
		        "-v", validationPath };
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
}