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

public class LENLOCXSDValidatorTest {

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
	public final void commandlineValidateXSDLENLOCallOK() {
		inputPath = INPUT_PATH + "ITS44-TC01.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC01_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC01_validation.xml";

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
	public final void commandlineValidateXSDLENLOCInputNotValidKO() {
		inputPath = INPUT_PATH + "ITS44-TC02.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC02_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC02_validation.xml";

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
	public final void commandlineValidateXSDLENLOCElementNotDefinedKO() {
		inputPath = INPUT_PATH + "ITS44-TC03.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC03_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC03_validation.xml";

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
	public final void commandlineValidateXSDLENLOCAttributeRequiredKO() {
		inputPath = INPUT_PATH + "ITS44-TC04.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC04_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC04_validation.xml";

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
	public final void commandlineValidateXSDLENLOCmodDIOK() {
		inputPath = INPUT_PATH + "ITS44-TC16.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC16_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC16_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
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
	public final void commandlineValidateXSDLENLOCmodA1OK() {
		inputPath = INPUT_PATH + "ITS44-TC17.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC17_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC17_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
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
	public final void commandlineValidateXSDLENLOCmodA2OK() {
		inputPath = INPUT_PATH + "ITS44-TC18.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC18_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC18_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
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
	public final void commandlineValidateXSDLENLOCmodA3POK() {
		inputPath = INPUT_PATH + "ITS44-TC19.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC19_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC19_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
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
	public final void commandlineValidateXSDLENLOCmodA3ROK() {
		inputPath = INPUT_PATH + "ITS44-TC20.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC20_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC20_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
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
	public final void commandlineValidateXSDLENLOCmodA4EAOK() {
		inputPath = INPUT_PATH + "ITS44-TC21.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC21_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC21_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
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
	public final void commandlineValidateXSDLENLOCmodA4RAOK() {
		inputPath = INPUT_PATH + "ITS44-TC22.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC22_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC22_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
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
	public final void commandlineValidateXSDLENLOCmodA5OK() {
		inputPath = INPUT_PATH + "ITS44-TC23.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC23_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC23_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
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
	public final void commandlineValidateXSDLENLOCmodGASTOK() {
		inputPath = INPUT_PATH + "ITS44-TC24.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC24_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC24_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
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
	public final void commandlineValidateXSDLENLOCmodINGOK() {
		inputPath = INPUT_PATH + "ITS44-TC25.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC25_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC25_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
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
	public final void commandlineValidateXSDLENLOCmodCBOK() {
		inputPath = INPUT_PATH + "ITS44-TC26.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC26_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC26_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
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
	public final void commandlineValidateXSDLENLOCmodACROK() {
		inputPath = INPUT_PATH + "ITS44-TC27.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC27_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC27_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
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
	public final void commandlineValidateXSDLENLOCmodDEUOK() {
		inputPath = INPUT_PATH + "ITS44-TC28.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC28_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC28_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
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
	public final void commandlineValidateXSDLENLOCmodPROGOK() {
		inputPath = INPUT_PATH + "ITS44-TC29.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC29_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC29_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
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
	public final void commandlineValidateXSDLENLOCmodRTOK() {
		inputPath = INPUT_PATH + "ITS44-TC30.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC30_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC30_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
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
	public final void commandlineValidateXSDLENLOCmodRPOK() {
		inputPath = INPUT_PATH + "ITS44-TC31.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC31.errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC31_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
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
	public final void commandlineValidateXSDLENLOCmodRPAOK() {
		inputPath = INPUT_PATH + "ITS44-TC32.xml";
		errorsPath = OUTPUT_PATH + "ITS44-TC32_errors.xml";
		validationPath = OUTPUT_PATH + "ITS44-TC32_validation.xml";

		String[] cmd = { "cmd.exe", "/C", "lanzadorPruebas.bat", "-validatexsd", "-i", inputPath, "-e", errorsPath, "-v", validationPath };
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