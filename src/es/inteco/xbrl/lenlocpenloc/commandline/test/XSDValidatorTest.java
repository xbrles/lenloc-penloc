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
 * TODO Incluir descripci�n de la clase
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
 * @version 1.0, 27/07/2009
 * @author difusioncalidad@inteco.es
 * @see
 * 
 */

public class XSDValidatorTest {

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
	public final void commandlineValidateXSDXMLWithoutHeaderKO() {
		inputPath = INPUT_PATH + "ITS44-TC09.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC09_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC09_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != -1) {
				throw new Exception("El resultado de la ejecuci�n es " + proceso.exitValue() + " y se esperaba -1");
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
	public final void commandlineValidateXSDOpeningTagElementNotFoundKO() {
		inputPath = INPUT_PATH + "ITS44-TC10.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC10_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC10_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != -1) {
				throw new Exception("El resultado de la ejecuci�n es " + proceso.exitValue() + " y se esperaba -1");
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
	public final void commandlineValidateXSDClosingTagElementNotFoundKO() {
		inputPath = INPUT_PATH + "ITS44-TC11.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC11_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC11_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != -1) {
				throw new Exception("El resultado de la ejecuci�n es " + proceso.exitValue() + " y se esperaba -1");
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
	public final void commandlineValidateXSDInvalidDateFormatKO() {
		inputPath = INPUT_PATH + "ITS44-TC12.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC12_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC12_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != -1) {
				throw new Exception("El resultado de la ejecuci�n es " + proceso.exitValue() + " y se esperaba -1");
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
	public final void commandlineValidateXSDUnitNotDefinedKO() {
		inputPath = INPUT_PATH + "ITS44-TC13.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC13_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC13_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != -1) {
				throw new Exception("El resultado de la ejecuci�n es " + proceso.exitValue() + " y se esperaba -1");
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
	public final void commandlineValidateXSDWithoutInputpathParameterKO() {
		inputPath = INPUT_PATH + "ITS44-TC14.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC14_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC14_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", inputPath, "-e", errorsPath, "-v", validationPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != -1) {
				throw new Exception("El resultado de la ejecuci�n es " + proceso.exitValue() + " y se esperaba -1");
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
	public final void commandlineValidateXBRLWithoutValidationpathParameterKO() {
		inputPath = INPUT_PATH + "ITS44-TC15.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC15_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC15_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, validationPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != -1) {
				throw new Exception("El resultado de la ejecuci�n es " + proceso.exitValue() + " y se esperaba -1");
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
	public final void commandlineValidateXBRLWithIncorrectInputFilepathParameterKO() {
		inputPath = INPUT_PATH + "NO_EXISTE/ITS44-TC37.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC37_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC37_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != -1) {
				throw new Exception("El resultado de la ejecuci�n es " + proceso.exitValue() + " y se esperaba -1");
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
	public final void commandlineValidateXBRLWithIncorrectErrorsFilepathParameterKO() {
		inputPath = INPUT_PATH + "ITS44-TC38.xml";
		errorsPath = OUTPUT_PATH + "NO_EXISTE/ITS44-TC38_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC38_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != -1) {
				throw new Exception("El resultado de la ejecuci�n es " + proceso.exitValue() + " y se esperaba -1");
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
	public final void commandlineValidateXBRLWithIncorrectValidationFilepathParameterKO() {
		inputPath = INPUT_PATH + "ITS44-TC39.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC39_errors.xml";
		validationPath = OUTPUT_PATH + "NO_EXISTE/ITS44-TC39_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;

		try {
			File comandoBat = new File(BAT_PATH);
			proceso = aplicacion.exec(cmd, null, comandoBat.getAbsoluteFile());
			proceso.waitFor();
			if(proceso.exitValue() != -1) {
				throw new Exception("El resultado de la ejecuci�n es " + proceso.exitValue() + " y se esperaba -1");
			}
		} catch(Exception e) {
			throw new AssertionError(e);
		}
	}
}	