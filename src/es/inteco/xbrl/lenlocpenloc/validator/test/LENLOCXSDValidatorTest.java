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

import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XSDValidatorException;
import es.inteco.xbrl.lenlocpenloc.validator.IXSDValidator;
import es.inteco.xbrl.lenlocpenloc.validator.ValidateResult;
import es.inteco.xbrl.lenlocpenloc.validator.XSDValidator;

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

	String inputPath;
	String outputPath;

	static IXSDValidator validator;
	ValidateResult validateResult;

	@BeforeClass
	public static void init() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("./config/enloc.properties"));
			testPath = prop.getProperty("testPath");
			INPUT_PATH = testPath + "validator/input/";
			OUTPUT_PATH = testPath + "validator/output/";
			validator = XSDValidator.createInstance();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.validator.XSDValidator#validate(java.lang.String documentPath)}
	 * .
	 */
	@Test
	public final void validateXSDLENLOCallOK() {
		inputPath = INPUT_PATH + "UTS22-TC01.xml";

		try {
			validateResult = validator.validate(inputPath);
			if(!validateResult.isValid()) {
				fail("Se ha producido un error " + validateResult.getErrors());
			}
		} catch(XSDValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.validator.XSDValidator#validate(java.lang.String documentPath)}
	 * .
	 */
	@Test
	public final void validateXSDLENLOCInputNotValidKO() {
		inputPath = INPUT_PATH + "UTS22-TC02.xml";
		outputPath = OUTPUT_PATH + "UTS22-TC02.txt";

		try {
			validateResult = validator.validate(inputPath);
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
		} catch(XSDValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido una excepción no esperada: " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.validator.XSDValidator#validate(java.lang.String documentPath)}
	 * .
	 */
	@Test
	public final void validateXSDLENLOCElementNotDefinedKO() {
		inputPath = INPUT_PATH + "UTS22-TC03.xml";
		outputPath = OUTPUT_PATH + "UTS22-TC03.txt";

		try {
			validateResult = validator.validate(inputPath);
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
		} catch(XSDValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido una excepción no esperada: " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.validator.XSDValidator#validate(java.lang.String documentPath)}
	 * .
	 */
	@Test
	public final void validateXSDLENLOCAttributeRequiredKO() {
		inputPath = INPUT_PATH + "UTS22-TC04.xml";
		outputPath = OUTPUT_PATH + "UTS22-TC04.txt";

		try {
			validateResult = validator.validate(inputPath);
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
		} catch(XSDValidatorException e) {
			e.printStackTrace();
			fail("Se ha producido una excepción no esperada: " + e.getMessage());
		}
	}

}