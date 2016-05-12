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

package es.inteco.xbrl.lenlocpenloc.validator.test;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLValidatorException;
import es.inteco.xbrl.lenlocpenloc.validator.IXBRLValidator;
import es.inteco.xbrl.lenlocpenloc.validator.ValidateResult;
import es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator;

/**
 * 
 * 
 * Clase que verifica el correcto funcionamiento del validador XBRL
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
 * @see
 * 
 */

public class XBRLValidatorTest {

	static String testPath;
	static String INPUT_PATH;
	static String OUTPUT_PATH;

	String inputPath;
	String outputPath;

	static IXBRLValidator validator;
	ValidateResult validateResult;

	@BeforeClass
	public static void init() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("./config/enloc.properties"));
			testPath = prop.getProperty("testPath");
			INPUT_PATH = testPath + "validator/input/";
			OUTPUT_PATH = testPath + "validator/output/";
			validator = XBRLValidator.createInstance();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCmodDIOK() {
		inputPath = INPUT_PATH + "UTS21-TC37.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCmodA1OK() {
		inputPath = INPUT_PATH + "UTS21-TC38.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCmodA2OK() {
		inputPath = INPUT_PATH + "UTS21-TC39.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCmodA3POK() {
		inputPath = INPUT_PATH + "UTS21-TC40.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCmodA3ROK() {
		inputPath = INPUT_PATH + "UTS21-TC41.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCmodA4EAOK() {
		inputPath = INPUT_PATH + "UTS21-TC42.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCmodA4RAOK() {
		inputPath = INPUT_PATH + "UTS21-TC43.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCmodA5OK() {
		inputPath = INPUT_PATH + "UTS21-TC44.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCmodGASTOK() {
		inputPath = INPUT_PATH + "UTS21-TC45.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCmodINGOK() {
		inputPath = INPUT_PATH + "UTS21-TC46.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCmodCBOK() {
		inputPath = INPUT_PATH + "UTS21-TC47.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCmodACROK() {
		inputPath = INPUT_PATH + "UTS21-TC48.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCmodDEUOK() {
		inputPath = INPUT_PATH + "UTS21-TC49.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCmodPROGOK() {
		inputPath = INPUT_PATH + "UTS21-TC50.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCmodRTOK() {
		inputPath = INPUT_PATH + "UTS21-TC51.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCmodRPOK() {
		inputPath = INPUT_PATH + "UTS21-TC52.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCmodRPAOK() {
		inputPath = INPUT_PATH + "UTS21-TC53.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCallOK() {
		inputPath = INPUT_PATH + "UTS21-TC54.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCDTSFileMissingKO() {
		inputPath = INPUT_PATH + "UTS21-TC55.xbrl";
		outputPath = OUTPUT_PATH + "UTS21-TC55.txt";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				try {
					PrintStream result = new PrintStream(new File(outputPath));
					result.println(validateResult.getErrors());
				} catch(FileNotFoundException e1) {

				}
				System.out.println(validateResult.getErrors());
			} else {
				fail("La validación debería haber producido errores");
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCInputNotXBRLKO() {
		inputPath = INPUT_PATH + "UTS21-TC56.xbrl";
		outputPath = OUTPUT_PATH + "UTS21-TC56.txt";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			fail("El proceso debería haber lanzado una excepción");
		} catch(XBRLValidatorException e) {
			try {
				e.printStackTrace(new PrintStream(new File(outputPath)));
			} catch(FileNotFoundException e1) {

			}
			e.printStackTrace();
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepción no esperada: " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCInputNotEnlocKO() {
		inputPath = INPUT_PATH + "UTS21-TC57.xbrl";
		outputPath = OUTPUT_PATH + "UTS21-TC57.txt";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			fail("El proceso debería haber lanzado una excepción");
		} catch(XBRLValidatorException e) {
			try {
				e.printStackTrace(new PrintStream(new File(outputPath)));
			} catch(FileNotFoundException e1) {

			}
			e.printStackTrace();
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepción no esperada: " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCElementMissingKO() {
		inputPath = INPUT_PATH + "UTS21-TC58.xbrl";
		outputPath = OUTPUT_PATH + "UTS21-TC58.txt";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				try {
					PrintStream result = new PrintStream(new File(outputPath));
					result.println(validateResult.getErrors());
				} catch(FileNotFoundException e1) {

				}
				System.out.println(validateResult.getErrors());
			} else {
				fail("La validación debería haber producido errores");
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCInvalidElementDataKO() {
		inputPath = INPUT_PATH + "UTS21-TC59.xbrl";
		outputPath = OUTPUT_PATH + "UTS21-TC59.txt";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				try {
					PrintStream result = new PrintStream(new File(outputPath));
					result.println(validateResult.getErrors());
				} catch(FileNotFoundException e1) {

				}
				System.out.println(validateResult.getErrors());
			} else {
				fail("La validación debería haber producido errores");
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCContextMissingKO() {
		inputPath = INPUT_PATH + "UTS21-TC60.xbrl";
		outputPath = OUTPUT_PATH + "UTS21-TC60.txt";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				try {
					PrintStream result = new PrintStream(new File(outputPath));
					result.println(validateResult.getErrors());
				} catch(FileNotFoundException e1) {

				}
				System.out.println(validateResult.getErrors());
			} else {
				fail("La validación debería haber producido errores");
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLLENLOCContextIncorrectKO() {
		inputPath = INPUT_PATH + "UTS21-TC61.xbrl";
		outputPath = OUTPUT_PATH + "UTS21-TC61.txt";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				try {
					PrintStream result = new PrintStream(new File(outputPath));
					result.println(validateResult.getErrors());
				} catch(FileNotFoundException e1) {

				}
				System.out.println(validateResult.getErrors());
			} else {
				fail("La validación debería haber producido errores");
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLPENLOCmodPDIOK() {
		inputPath = INPUT_PATH + "UTS21-TC62.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLPENLOCmodPINGOK() {
		inputPath = INPUT_PATH + "UTS21-TC63.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLPENLOCmodPPROGOK() {
		inputPath = INPUT_PATH + "UTS21-TC64.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLPENLOCmodPGASTOK() {
		inputPath = INPUT_PATH + "UTS21-TC65.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLPENLOCallOK() {
		inputPath = INPUT_PATH + "UTS21-TC66.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error de validación: " + validateResult.getErrors());
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLPENLOCDTSFileMissingKO() {
		inputPath = INPUT_PATH + "UTS21-TC67.xbrl";
		outputPath = OUTPUT_PATH + "UTS21-TC67.txt";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				try {
					PrintStream result = new PrintStream(new File(outputPath));
					result.println(validateResult.getErrors());
				} catch(FileNotFoundException e1) {

				}
				System.out.println(validateResult.getErrors());
			} else {
				fail("La validación debería haber producido errores");
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLPENLOCElementMissingKO() {
		inputPath = INPUT_PATH + "UTS21-TC68.xbrl";
		outputPath = OUTPUT_PATH + "UTS21-TC68.txt";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				try {
					PrintStream result = new PrintStream(new File(outputPath));
					result.println(validateResult.getErrors());
				} catch(FileNotFoundException e1) {

				}
				System.out.println(validateResult.getErrors());
			} else {
				fail("La validación debería haber producido errores");
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLPENLOCInvalidElementDataKO() {
		inputPath = INPUT_PATH + "UTS21-TC69.xbrl";
		outputPath = OUTPUT_PATH + "UTS21-TC69.txt";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				try {
					PrintStream result = new PrintStream(new File(outputPath));
					result.println(validateResult.getErrors());
				} catch(FileNotFoundException e1) {

				}
				System.out.println(validateResult.getErrors());
			} else {
				fail("La validación debería haber producido errores");
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLPENLOCContextMissingKO() {
		inputPath = INPUT_PATH + "UTS21-TC70.xbrl";
		outputPath = OUTPUT_PATH + "UTS21-TC70.txt";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				try {
					PrintStream result = new PrintStream(new File(outputPath));
					result.println(validateResult.getErrors());
				} catch(FileNotFoundException e1) {

				}
				System.out.println(validateResult.getErrors());
			} else {
				fail("La validación debería haber producido errores");
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.validator.XBRLValidator#validate
	 * java.lang.byte[] inputDocument)} .
	 */
	@Test
	public final void validateXBRLPENLOCContextIncorrectKO() {
		inputPath = INPUT_PATH + "UTS21-TC71.xbrl";
		outputPath = OUTPUT_PATH + "UTS21-TC71.txt";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			validateResult = validator.validate(inputDocument);
			if(!validateResult.isValid()) {
				try {
					PrintStream result = new PrintStream(new File(outputPath));
					result.println(validateResult.getErrors());
				} catch(FileNotFoundException e1) {

				}
				System.out.println(validateResult.getErrors());
			} else {
				fail("La validación debería haber producido errores");
			}
		} catch(XBRLValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error no esperado " + e.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			fail("Se ha producido una excepcion no esperada " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}