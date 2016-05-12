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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XBRLENLOCException;
import es.inteco.xbrl.lenlocpenloc.utils.ENLOCUtils;
import es.inteco.xbrl.lenlocpenloc.utils.XbrlApiConfiguration;

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
 * @version 1.0, 05/08/2009
 * @author difusioncalidad@inteco.es
 * @see
 * 
 */

public class TransformerToXMLTest {

	private static final String TransformerToXML = "es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML";
	private static final String createInstance = "createInstance";
	private static final String transform = "transform";

	static String testPath;
	static String INPUT_PATH;
	static String OUTPUT_PATH;

	String inputPath = null;
	String outputPath = null;

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
		File inputDocumentFile = null;
		byte[] inputDocument;

		try {
			ByteArrayOutputStream documentByteArray = new ByteArrayOutputStream();
			try {
				ENLOCUtils.saveFileToByteArray(new File(inputPath), documentByteArray);
			} catch(XBRLENLOCException e) {
				throw new TransformException(TransformException.errorInTransformationToXml, new String[] { inputPath },
				        e.getErrorsHandler());
			}
			inputDocument = documentByteArray.toByteArray();
			inputDocumentFile = ENLOCUtils.createTempFile(inputDocument, "transformtoxml", ".xbrl");
			ENLOCUtils.normalizeSchema(new ByteArrayInputStream(inputDocument), XbrlApiConfiguration.getInstance()
			        .getTaxonomyRoot(), inputDocumentFile.getAbsolutePath());
			inputPath = inputDocumentFile.getAbsolutePath();

			Class claseTransformerToXML = Class.forName(TransformerToXML);

			Method createInstanceMethod = claseTransformerToXML.getDeclaredMethod(createInstance, new Class[0]);
			createInstanceMethod.setAccessible(true);

			Object transformerToXMLInstance = createInstanceMethod.invoke(null, new Object[0]);

			Method transformMethod = claseTransformerToXML.getDeclaredMethod(transform, new Class[] { String.class,
			        String.class });
			transformMethod.setAccessible(true);

			result = (byte[]) transformMethod.invoke(transformerToXMLInstance, new Object[] { inputPath, outputPath });
		} catch(InvocationTargetException e) {
			throw (TransformException) e.getTargetException();
		} catch(XBRLENLOCException e) {
			throw new TransformException(TransformException.errorInTransformationToXml, new String[] { inputPath }, e
			        .getErrorsHandler());
		} catch(Exception e1) {
			fail("Error inesperado al cargar el método" + e1.getMessage());
			e1.printStackTrace();
		}
		return result;
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodDIOK() {
		inputPath = INPUT_PATH + "UTS12-TC61.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC61.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodA1OK() {
		inputPath = INPUT_PATH + "UTS12-TC62.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC62.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodA2OK() {
		inputPath = INPUT_PATH + "UTS12-TC63.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC63.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodA3POK() {
		inputPath = INPUT_PATH + "UTS12-TC64.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC64.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodA3ROK() {
		inputPath = INPUT_PATH + "UTS12-TC65.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC65.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodA4EAOK() {
		inputPath = INPUT_PATH + "UTS12-TC66.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC66.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodA4RAOK() {
		inputPath = INPUT_PATH + "UTS12-TC67.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC67.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodA5OK() {
		inputPath = INPUT_PATH + "UTS12-TC68.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC68.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodGASTOK() {
		inputPath = INPUT_PATH + "UTS12-TC69.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC69.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodINGOK() {
		inputPath = INPUT_PATH + "UTS12-TC70.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC70.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodCBOK() {
		inputPath = INPUT_PATH + "UTS12-TC71.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC71.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodACROK() {
		inputPath = INPUT_PATH + "UTS12-TC72.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC72.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodDEUOK() {
		inputPath = INPUT_PATH + "UTS12-TC73.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC73.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodPROGOK() {
		inputPath = INPUT_PATH + "UTS12-TC74.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC74.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodRTOK() {
		inputPath = INPUT_PATH + "UTS12-TC75.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC75.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodRPOK() {
		inputPath = INPUT_PATH + "UTS12-TC76.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC76.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodRPAOK() {
		inputPath = INPUT_PATH + "UTS12-TC77.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC77.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLallOK() {
		inputPath = INPUT_PATH + "UTS12-TC78.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC78.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLInputNotXBRLKO() {
		inputPath = INPUT_PATH + "UTS12-TC79.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC79.xml";
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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLInputNoLenlocKO() {
		inputPath = INPUT_PATH + "UTS12-TC80.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC80.xml";
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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLInputWithErrorsKO() {
		inputPath = INPUT_PATH + "UTS12-TC81.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC81.xml";
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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformPENLOCXBRLToXMLmodPDIOK() {
		inputPath = INPUT_PATH + "UTS12-TC82.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC82.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformPENLOCXBRLToXMLmodPINGOK() {
		inputPath = INPUT_PATH + "UTS12-TC83.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC83.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformPENLOCXBRLToXMLmodPPROGOK() {
		inputPath = INPUT_PATH + "UTS12-TC84.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC84.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformPENLOCXBRLToXMLmodPGASTOK() {
		inputPath = INPUT_PATH + "UTS12-TC85.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC85.xml";
		try {
			transform();
		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error durante la transformacion");
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.TransformerToXML#transform(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void transformPENLOCXBRLToXMLallOK() {
		inputPath = INPUT_PATH + "UTS12-TC86.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC86.xml";
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
	public final void transformPENLOCXBRLToXMLInputNotXBRLKO() {
		inputPath = INPUT_PATH + "UTS12-TC87.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC87.xml";
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
	public final void transformPENLOCXBRLToXMLInputWithErrorsKO() {
		inputPath = INPUT_PATH + "UTS12-TC88.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC88.xml";
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
}