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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

import es.inteco.xbrl.lenlocpenloc.errors.exceptions.TransformException;
import es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer;
import es.inteco.xbrl.lenlocpenloc.transform.IENLOCTransformer;

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
 * @version 1.0, 15/07/2009
 * @author difusioncalidad@inteco.es
 * @see
 * 
 */

public class LENLOCTransformerToXMLTest {

	static String testPath;
	static String INPUT_PATH;
	static String OUTPUT_PATH;

	String inputPath;
	String outputPath;

	static IENLOCTransformer enlocTransformer;

	@BeforeClass
	public static void init() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("./config/enloc.properties"));
			testPath = prop.getProperty("testPath");
			INPUT_PATH = testPath + "transform/input/";
			OUTPUT_PATH = testPath + "transform/output/";
			enlocTransformer = ENLOCTransformer.createInstance();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodDIOK() {
		inputPath = INPUT_PATH + "UTS12-TC01.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC01.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodA1OK() {
		inputPath = INPUT_PATH + "UTS12-TC02.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC02.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodA2OK() {
		inputPath = INPUT_PATH + "UTS12-TC03.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC03.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodA3POK() {
		inputPath = INPUT_PATH + "UTS12-TC04.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC04.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodA3ROK() {
		inputPath = INPUT_PATH + "UTS12-TC05.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC05.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodA4EAOK() {
		inputPath = INPUT_PATH + "UTS12-TC06.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC06.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodA4RAOK() {
		inputPath = INPUT_PATH + "UTS12-TC07.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC07.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodA5OK() {
		inputPath = INPUT_PATH + "UTS12-TC08.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC08.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodGASTOK() {
		inputPath = INPUT_PATH + "UTS12-TC09.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC09.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodINGOK() {
		inputPath = INPUT_PATH + "UTS12-TC10.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC10.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodCBOK() {
		inputPath = INPUT_PATH + "UTS12-TC11.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC11.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodACROK() {
		inputPath = INPUT_PATH + "UTS12-TC12.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC12.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodDEUOK() {
		inputPath = INPUT_PATH + "UTS12-TC13.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC13.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodPROGOK() {
		inputPath = INPUT_PATH + "UTS12-TC14.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC14.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodRTOK() {
		inputPath = INPUT_PATH + "UTS12-TC15.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC15.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodRPOK() {
		inputPath = INPUT_PATH + "UTS12-TC16.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC16.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodRPAOK() {
		inputPath = INPUT_PATH + "UTS12-TC17.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC17.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLallOK() {
		inputPath = INPUT_PATH + "UTS12-TC18.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC18.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLInputNotXBRLKO() {
		inputPath = INPUT_PATH + "UTS12-TC19.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC19.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, false);
			fail("No se ha producido ninguna excepcion y la instancia tiene errores");

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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLInputNoLenlocKO() {
		inputPath = INPUT_PATH + "UTS12-TC20.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC20.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, false);
			fail("No se ha producido ninguna excepcion y la instancia tiene errores");

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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLInputNotValidWithValidationKO() {
		inputPath = INPUT_PATH + "UTS12-TC21.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC21.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, true);
			fail("No se ha producido ninguna excepcion y la instancia tiene errores");

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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLInputWithErrorsKO() {
		inputPath = INPUT_PATH + "UTS12-TC22.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC22.xml";

		try {
			enlocTransformer.transformToXml(inputPath, outputPath, false);
			fail("No se ha producido ninguna excepcion y la instancia tiene errores");

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
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodDIByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC31.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC31.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		} catch(IOException e1) {
			e1.printStackTrace();
			fail("Se ha producido un error " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodA1ByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC32.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC32.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		} catch(IOException e1) {
			e1.printStackTrace();
			fail("Se ha producido un error " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodA2ByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC33.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC33.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		} catch(IOException e1) {
			e1.printStackTrace();
			fail("Se ha producido un error " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodA3PByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC34.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC34.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		} catch(IOException e1) {
			e1.printStackTrace();
			fail("Se ha producido un error " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodA3RByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC35.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC35.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		} catch(IOException e1) {
			e1.printStackTrace();
			fail("Se ha producido un error " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodA4EAByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC36.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC36.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		} catch(IOException e1) {
			e1.printStackTrace();
			fail("Se ha producido un error " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodA4RAByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC37.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC37.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		} catch(IOException e1) {
			e1.printStackTrace();
			fail("Se ha producido un error " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodA5ByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC38.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC38.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		} catch(IOException e1) {
			e1.printStackTrace();
			fail("Se ha producido un error " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodGASTByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC39.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC39.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		} catch(IOException e1) {
			e1.printStackTrace();
			fail("Se ha producido un error " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodINGByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC40.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC40.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		} catch(IOException e1) {
			e1.printStackTrace();
			fail("Se ha producido un error " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodCBByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC41.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC41.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		} catch(IOException e1) {
			e1.printStackTrace();
			fail("Se ha producido un error " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodACRByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC42.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC42.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		} catch(IOException e1) {
			e1.printStackTrace();
			fail("Se ha producido un error " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodDEUByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC43.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC43.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		} catch(IOException e1) {
			e1.printStackTrace();
			fail("Se ha producido un error " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodPROGByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC44.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC44.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		} catch(IOException e1) {
			e1.printStackTrace();
			fail("Se ha producido un error " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodRTByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC45.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC45.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		} catch(IOException e1) {
			e1.printStackTrace();
			fail("Se ha producido un error " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodRPByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC46.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC46.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		} catch(IOException e1) {
			e1.printStackTrace();
			fail("Se ha producido un error " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLmodRPAByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC47.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC47.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		} catch(IOException e1) {
			e1.printStackTrace();
			fail("Se ha producido un error " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLallByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC48.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC48.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		} catch(IOException e1) {
			e1.printStackTrace();
			fail("Se ha producido un error " + e1.getMessage());
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLInputNotXBRLByteArrayKO() {
		inputPath = INPUT_PATH + "UTS12-TC49.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC49.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);
			fail("No se ha producido ninguna excepcion y la instancia tiene errores");

		} catch(TransformException e) {
			try {
				e.printStackTrace(new PrintStream(new File(outputPath.replace(outputPath.substring(outputPath
				        .lastIndexOf(".") + 1), "txt"))));
			} catch(FileNotFoundException e1) {

			}
			e.printStackTrace();
		} catch(IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLInputNoLenlocByteArrayKO() {
		inputPath = INPUT_PATH + "UTS12-TC50.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC50.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);
			fail("No se ha producido ninguna excepcion y la instancia tiene errores");

		} catch(TransformException e) {
			try {
				e.printStackTrace(new PrintStream(new File(outputPath.replace(outputPath.substring(outputPath
				        .lastIndexOf(".") + 1), "txt"))));
			} catch(FileNotFoundException e1) {

			}
			e.printStackTrace();
		} catch(IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLInputNotValidWithValidationByteArrayKO() {
		inputPath = INPUT_PATH + "UTS12-TC51.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC51.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, true);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);
			fail("No se ha producido ninguna excepcion y la instancia tiene errores");

		} catch(TransformException e) {
			try {
				e.printStackTrace(new PrintStream(new File(outputPath.replace(outputPath.substring(outputPath
				        .lastIndexOf(".") + 1), "txt"))));
			} catch(FileNotFoundException e1) {

			}
			e.printStackTrace();
		} catch(IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXml(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXBRLToXMLInputWithErrorsByteArrayKO() {
		inputPath = INPUT_PATH + "UTS12-TC52.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC52.xml";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXml(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);
			fail("No se ha producido ninguna excepcion y la instancia tiene errores");

		} catch(TransformException e) {
			try {
				e.printStackTrace(new PrintStream(new File(outputPath.replace(outputPath.substring(outputPath
				        .lastIndexOf(".") + 1), "txt"))));
			} catch(FileNotFoundException e1) {

			}
			e.printStackTrace();
		} catch(IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				fileInputDocument.close();
				if(fileOutDocument != null) {
					fileOutDocument.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}