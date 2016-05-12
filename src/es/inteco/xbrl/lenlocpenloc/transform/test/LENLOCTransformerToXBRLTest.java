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
 * @version 1.0, 09/07/2009
 * @author difusioncalidad@inteco.es
 * @see
 * 
 */

public class LENLOCTransformerToXBRLTest {

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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodDIOK() {
		inputPath = INPUT_PATH + "UTS11-TC01.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC01.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodA1OK() {
		inputPath = INPUT_PATH + "UTS11-TC02.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC02.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodA2OK() {
		inputPath = INPUT_PATH + "UTS11-TC03.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC03.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodA3POK() {
		inputPath = INPUT_PATH + "UTS11-TC04.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC04.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodA3ROK() {
		inputPath = INPUT_PATH + "UTS11-TC05.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC05.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodA4EAOK() {
		inputPath = INPUT_PATH + "UTS11-TC06.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC06.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodA4RAOK() {
		inputPath = INPUT_PATH + "UTS11-TC07.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC07.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodA5OK() {
		inputPath = INPUT_PATH + "UTS11-TC08.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC08.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodGASTOK() {
		inputPath = INPUT_PATH + "UTS11-TC09.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC09.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodINGOK() {
		inputPath = INPUT_PATH + "UTS11-TC10.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC10.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodCBOK() {
		inputPath = INPUT_PATH + "UTS11-TC11.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC11.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodACROK() {
		inputPath = INPUT_PATH + "UTS11-TC12.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC12.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodDEUOK() {
		inputPath = INPUT_PATH + "UTS11-TC13.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC13.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodPROGOK() {
		inputPath = INPUT_PATH + "UTS11-TC14.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC14.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodRTOK() {
		inputPath = INPUT_PATH + "UTS11-TC15.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC15.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodRPOK() {
		inputPath = INPUT_PATH + "UTS11-TC16.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC16.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodRPAOK() {
		inputPath = INPUT_PATH + "UTS11-TC17.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC17.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLallOK() {
		inputPath = INPUT_PATH + "UTS11-TC18.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC18.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);

		} catch(TransformException e) {
			e.printStackTrace();
			fail("Se ha producido un error " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLFileNotFoundKO() {
		inputPath = INPUT_PATH + "UTS11-TC19.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC19.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);
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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLReportIDNotExistKO() {
		inputPath = INPUT_PATH + "UTS11-TC20.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC20.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);
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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLModuleIDNotExistKO() {
		inputPath = INPUT_PATH + "UTS11-TC21.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC21.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);
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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLRowIDNotExistKO() {
		inputPath = INPUT_PATH + "UTS11-TC22.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC22.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);
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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLInputNotValidKO() {
		inputPath = INPUT_PATH + "UTS11-TC23.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC23.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, false);
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
	 * {@link es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(java.lang.String, java.lang.String, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLOutputNotValidKO() {
		inputPath = INPUT_PATH + "UTS11-TC24.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC24.xbrl";

		try {
			enlocTransformer.transformToXbrl(inputPath, outputPath, true);
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodDIByteArrayOK() {

		inputPath = INPUT_PATH + "UTS11-TC36.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC36.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodA1ByteArrayOK() {

		inputPath = INPUT_PATH + "UTS11-TC37.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC37.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodA2ByteArrayOK() {

		inputPath = INPUT_PATH + "UTS11-TC38.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC38.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodA3PByteArrayOK() {

		inputPath = INPUT_PATH + "UTS11-TC39.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC39.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodA3RByteArrayOK() {

		inputPath = INPUT_PATH + "UTS11-TC40.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC40.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodA4EAByteArrayOK() {

		inputPath = INPUT_PATH + "UTS11-TC41.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC41.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodA4RAByteArrayOK() {

		inputPath = INPUT_PATH + "UTS11-TC42.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC42.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodA5ByteArrayOK() {

		inputPath = INPUT_PATH + "UTS11-TC43.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC43.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodGASTByteArrayOK() {

		inputPath = INPUT_PATH + "UTS11-TC44.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC44.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodINGByteArrayOK() {

		inputPath = INPUT_PATH + "UTS11-TC45.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC45.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodCBByteArrayOK() {

		inputPath = INPUT_PATH + "UTS11-TC46.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC46.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodACRByteArrayOK() {

		inputPath = INPUT_PATH + "UTS11-TC47.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC47.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodDEUByteArrayOK() {

		inputPath = INPUT_PATH + "UTS11-TC48.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC48.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodPROGByteArrayOK() {

		inputPath = INPUT_PATH + "UTS11-TC49.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC49.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodRTByteArrayOK() {

		inputPath = INPUT_PATH + "UTS11-TC50.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC50.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodRPByteArrayOK() {

		inputPath = INPUT_PATH + "UTS11-TC51.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC51.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLmodRPAByteArrayOK() {

		inputPath = INPUT_PATH + "UTS11-TC52.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC52.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLallByteArrayOK() {

		inputPath = INPUT_PATH + "UTS11-TC53.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC53.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLReportIDNotExistByteArrayKO() {

		inputPath = INPUT_PATH + "UTS11-TC54.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC54.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
			try {
				e1.printStackTrace(new PrintStream(new File(outputPath.replace(outputPath.substring(outputPath
				        .lastIndexOf(".") + 1), "txt"))));
			} catch(FileNotFoundException e2) {

			}
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLModuleIDNotExistByteArrayKO() {
		inputPath = INPUT_PATH + "UTS11-TC55.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC55.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
			try {
				e1.printStackTrace(new PrintStream(new File(outputPath.replace(outputPath.substring(outputPath
				        .lastIndexOf(".") + 1), "txt"))));
			} catch(FileNotFoundException e2) {

			}
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLRowIDNotExistByteArrayKO() {
		inputPath = INPUT_PATH + "UTS11-TC56.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC56.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
			try {
				e1.printStackTrace(new PrintStream(new File(outputPath.replace(outputPath.substring(outputPath
				        .lastIndexOf(".") + 1), "txt"))));
			} catch(FileNotFoundException e2) {

			}
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLInputNotValidByteArrayKO() {
		inputPath = INPUT_PATH + "UTS11-TC57.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC57.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
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
			try {
				e1.printStackTrace(new PrintStream(new File(outputPath.replace(outputPath.substring(outputPath
				        .lastIndexOf(".") + 1), "txt"))));
			} catch(FileNotFoundException e2) {

			}
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLOutputNotValidByteArrayKO() {
		inputPath = INPUT_PATH + "UTS11-TC58.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC58.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, true);
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
			try {
				e1.printStackTrace(new PrintStream(new File(outputPath.replace(outputPath.substring(outputPath
				        .lastIndexOf(".") + 1), "txt"))));
			} catch(FileNotFoundException e2) {

			}
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
	 * es.inteco.xbrl.lenlocpenloc.transform.ENLOCTransformer#transformToXbrl(
	 * java.lang.byte [], java.lang.Boolean)} .
	 */
	@Test
	public final void transformLENLOCXMLToXBRLInputNotXMLByteArrayKO() {
		inputPath = INPUT_PATH + "UTS11-TC59.xml";
		outputPath = OUTPUT_PATH + "UTS11-TC59.xbrl";

		File file = new File(inputPath);
		FileInputStream fileInputDocument = null;
		FileOutputStream fileOutDocument = null;

		byte[] inputDocument = new byte[(int) file.length()];

		try {
			fileInputDocument = new FileInputStream(file);

			// lee todos los bytes al byte[]
			fileInputDocument.read(inputDocument);

			byte[] result = enlocTransformer.transformToXbrl(inputDocument, false);
			fileOutDocument = new FileOutputStream(outputPath);
			fileOutDocument.write(result);
			fail("No se ha producido ninguna excepcion y la instancia tiene errores");

		} catch(IOException e1) {
			try {
				e1.printStackTrace(new PrintStream(new File(outputPath.replace(outputPath.substring(outputPath
				        .lastIndexOf(".") + 1), "txt"))));
			} catch(FileNotFoundException e2) {

			}
			e1.printStackTrace();
		} catch(TransformException e) {

			try {
				e.printStackTrace(new PrintStream(new File(outputPath.replace(outputPath.substring(outputPath
				        .lastIndexOf(".") + 1), "txt"))));
			} catch(FileNotFoundException e1) {

			}
			e.printStackTrace();
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