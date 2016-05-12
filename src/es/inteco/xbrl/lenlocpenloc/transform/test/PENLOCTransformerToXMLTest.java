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
 * @version 1.0, 17/07/2009
 * @author difusioncalidad@inteco.es
 * @see
 * 
 */

public class PENLOCTransformerToXMLTest {

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
	public final void transformPENLOCXBRLToXMLmodPDIOK() {
		inputPath = INPUT_PATH + "UTS12-TC23.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC23.xml";

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
	public final void transformPENLOCXBRLToXMLmodPINGOK() {
		inputPath = INPUT_PATH + "UTS12-TC24.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC24.xml";

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
	public final void transformPENLOCXBRLToXMLmodPPROGOK() {
		inputPath = INPUT_PATH + "UTS12-TC25.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC25.xml";

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
	public final void transformPENLOCXBRLToXMLmodPGASTOK() {
		inputPath = INPUT_PATH + "UTS12-TC26.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC26.xml";

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
	public final void transformPENLOCXBRLToXMLallOK() {
		inputPath = INPUT_PATH + "UTS12-TC27.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC27.xml";

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
	public final void transformPENLOCXBRLToXMLInputNotXBRLKO() {
		inputPath = INPUT_PATH + "UTS12-TC28.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC28.xml";

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
	public final void transformPENLOCXBRLToXMLInputNotValidWithValidationKO() {
		inputPath = INPUT_PATH + "UTS12-TC29.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC29.xml";

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
	public final void transformPENLOCXBRLToXMLInputWithErrorsKO() {
		inputPath = INPUT_PATH + "UTS12-TC30.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC30.xml";

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
	public final void transformPENLOCXBRLToXMLmodPDIByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC53.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC53.xml";

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
	public final void transformPENLOCXBRLToXMLmodPINGByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC54.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC54.xml";

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
	public final void transformPENLOCXBRLToXMLmodPPROGByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC55.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC55.xml";

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
	public final void transformPENLOCXBRLToXMLmodPGASTByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC56.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC56.xml";

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
	public final void transformPENLOCXBRLToXMLallByteArrayOK() {
		inputPath = INPUT_PATH + "UTS12-TC57.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC57.xml";

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
	public final void transformPENLOCXBRLToXMLInputNotXBRLByteArrayKO() {
		inputPath = INPUT_PATH + "UTS12-TC58.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC58.xml";

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
	public final void transformPENLOCXBRLToXMLInputNotValidWithValidationByteArrayKO() {
		inputPath = INPUT_PATH + "UTS12-TC59.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC59.xml";

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
	public final void transformPENLOCXBRLToXMLInputWithErrorsByteArrayKO() {
		inputPath = INPUT_PATH + "UTS12-TC60.xbrl";
		outputPath = OUTPUT_PATH + "UTS12-TC60.xml";

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