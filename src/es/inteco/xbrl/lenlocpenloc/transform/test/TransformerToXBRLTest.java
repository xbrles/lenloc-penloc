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
package es.inteco.xbrl.lenlocpenloc.transform.test;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

import es.inteco.xbrl.lenlocpenloc.errors.exceptions.TransformException;

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

public class TransformerToXBRLTest {

	private static final String TransformerToXBRL = "es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL";
	private static final String createInstance = "createInstance";
	private static final String transform = "transform";

	static String testPath;
	static String INPUT_PATH;
	static String OUTPUT_PATH;

	String inputPath;
	String outputPath;

	@BeforeClass
	public static void init() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("./config/enloc.properties"));
			testPath = prop.getProperty("testPath");
			INPUT_PATH = testPath + "transform/input/";
			OUTPUT_PATH = testPath + "transform/output/";
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	// Método que realiza la llamada al método transform de la clase
	// TransformerToXBRL
	byte[] transform() throws TransformException {

		byte[] result = null;

		try {

			Class claseTransformerToXBRL = Class.forName(TransformerToXBRL);

			Method createInstanceMethod = claseTransformerToXBRL.getDeclaredMethod(createInstance, new Class[0]);
			createInstanceMethod.setAccessible(true);

			Object transformerToXBRLInstance = createInstanceMethod.invoke(null, new Object[0]);

			Method transformMethod = claseTransformerToXBRL.getDeclaredMethod(transform, new Class[] { String.class,
			        String.class });
			transformMethod.setAccessible(true);

			result = (byte[]) transformMethod.invoke(transformerToXBRLInstance, new Object[] { inputPath, outputPath });
		} catch(InvocationTargetException e) {
			throw (TransformException) e.getTargetException();
		} catch(Exception e1) {
			fail("Error inesperado al cargar el método" + e1.getMessage());
			e1.printStackTrace();
		}
		return result;
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodDIOK() {
		inputPath = INPUT_PATH + "UTS11-TC71.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC71.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodA1OK() {
		inputPath = INPUT_PATH + "UTS11-TC72.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC72.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodA2OK() {
		inputPath = INPUT_PATH + "UTS11-TC73.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC73.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodA3POK() {
		inputPath = INPUT_PATH + "UTS11-TC74.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC74.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodA3ROK() {
		inputPath = INPUT_PATH + "UTS11-TC75.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC75.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodA4EAOK() {
		inputPath = INPUT_PATH + "UTS11-TC76.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC76.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodA4RAOK() {
		inputPath = INPUT_PATH + "UTS11-TC77.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC77.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodA5OK() {
		inputPath = INPUT_PATH + "UTS11-TC78.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC78.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodGASTOK() {
		inputPath = INPUT_PATH + "UTS11-TC79.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC79.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodINGOK() {
		inputPath = INPUT_PATH + "UTS11-TC80.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC80.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodCBOK() {
		inputPath = INPUT_PATH + "UTS11-TC81.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC81.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodACROK() {
		inputPath = INPUT_PATH + "UTS11-TC82.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC82.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodDEUOK() {
		inputPath = INPUT_PATH + "UTS11-TC83.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC83.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodPROGOK() {
		inputPath = INPUT_PATH + "UTS11-TC84.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC84.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodRTOK() {
		inputPath = INPUT_PATH + "UTS11-TC85.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC85.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodRPOK() {
		inputPath = INPUT_PATH + "UTS11-TC86.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC86.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodRPAOK() {
		inputPath = INPUT_PATH + "UTS11-TC87.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC87.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLallOK() {
		inputPath = INPUT_PATH + "UTS11-TC88.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC88.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLFileNotFoundKO() {
		inputPath = INPUT_PATH + "UTS11-TC89.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC89.xbrl";
		try {
			transform();
			fail("No ha habido excepcion pero se han producido errores en la transformación");
		} catch(TransformException e) {
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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLReportIDNotExistKO() {
		inputPath = INPUT_PATH + "UTS11-TC90.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC90.xbrl";
		try {
			transform();
			fail("No ha habido excepcion pero se han producido errores en la transformación");
		} catch(TransformException e) {
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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLModuleIDNotExistKO() {
		inputPath = INPUT_PATH + "UTS11-TC91.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC91.xbrl";
		try {
			transform();
			fail("No ha habido excepcion pero se han producido errores en la transformación");
		} catch(TransformException e) {
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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLRowIDNotExistKO() {
		inputPath = INPUT_PATH + "UTS11-TC92.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC92.xbrl";
		try {
			transform();
			fail("No ha habido excepcion pero se han producido errores en la transformación");
		} catch(TransformException e) {
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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLInputNotDataKO() {
		inputPath = INPUT_PATH + "UTS11-TC93.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC93.xbrl";
		try {
			transform();
			fail("No ha habido excepcion pero se han producido errores en la transformación");
		} catch(TransformException e) {
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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLOutputNotValidKO() {
		inputPath = INPUT_PATH + "UTS11-TC94.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC94.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformPENLOCXMLToXBRLmodPDIOK() {
		inputPath = INPUT_PATH + "UTS11-TC95.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC95.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformPENLOCXMLToXBRLmodPINGOK() {
		inputPath = INPUT_PATH + "UTS11-TC96.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC96.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformPENLOCXMLToXBRLmodPPROGOK() {
		inputPath = INPUT_PATH + "UTS11-TC97.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC97.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformPENLOCXMLToXBRLmodPGASTOK() {
		inputPath = INPUT_PATH + "UTS11-TC98.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC98.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformPENLOCXMLToXBRLallOK() {
		inputPath = INPUT_PATH + "UTS11-TC99.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC99.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformPENLOCXMLToXBRLFileNotFoundKO() {
		inputPath = INPUT_PATH + "UTS11-TC100.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC100.xbrl";
		try {
			transform();
			fail("No ha habido excepcion pero se han producido errores en la transformación");
		} catch(TransformException e) {
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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformPENLOCXMLToXBRLReportIDNotExistKO() {
		inputPath = INPUT_PATH + "UTS11-TC101.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC101.xbrl";
		try {
			transform();
			fail("No ha habido excepcion pero se han producido errores en la transformación");
		} catch(TransformException e) {
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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformPENLOCXMLToXBRLModuleIDNotExistKO() {
		inputPath = INPUT_PATH + "UTS11-TC102.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC102.xbrl";
		try {
			transform();
			fail("No ha habido excepcion pero se han producido errores en la transformación");
		} catch(TransformException e) {
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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformPENLOCXMLToXBRLRowIDNotExistKO() {
		inputPath = INPUT_PATH + "UTS11-TC103.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC103.xbrl";
		try {
			transform();
			fail("No ha habido excepcion pero se han producido errores en la transformación");
		} catch(TransformException e) {
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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformPENLOCXMLToXBRLInputNotDataKO() {
		inputPath = INPUT_PATH + "UTS11-TC104.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC104.xbrl";
		try {
			transform();
			fail("No ha habido excepcion pero se han producido errores en la transformación");
		} catch(TransformException e) {
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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXBRL#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformPENLOCXMLToXBRLOutputNotValidKO() {
		inputPath = INPUT_PATH + "UTS11-TC105.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC105.xbrl";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}
}