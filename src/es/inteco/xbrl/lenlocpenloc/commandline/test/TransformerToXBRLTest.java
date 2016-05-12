/**
*
* API XBRL-LENLOCPENLOC2010 is a set of packages for the processing of instances XBRL
* (eXtensible Business Reporting Language) corresponding to the taxonomies LENLOC2010 and PENLOC2010.
* The Ministerial Order EHA/3565/2008 is the legal text that regulates the budget structure of local entities in Spain.
* Processing of budget outturn will be according to the LENLOC2010 taxonomy.
* Processing of general budget will be according to the PENLOC2010 taxonomy.
* This program is part of the API XBRL-LENLOCPENLOC2010.
*
* Copyright (C) 2009 INTECO (Instituto Nacional de Tecnologías de la
* Comunicación, S.A.)
*
* Authors: Members of Software Quality Department inside INTECO
*
* E-mail: difusioncalidad@inteco.es
*
* This program is free software; you can redistribute it and/or modify it under the terms of
* the GNU Lesser General Public License as published by the Free Software Foundation; 
* either version 3 of the License, or (at your opinion) any later version.
*
* This program is distributed in the hope that it will be useful, but WITHOUT ANY
* WARRANTY; without even the implied warranty of MERCHANTABILITY or 
* FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
* License for more details.
*
* You should have received a copy of the GNU Lesser General Public License along
* with this program. If not, see http://www.gnu.org/licenses/
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
 * TODO Clase test para probar la transformación de XML a XBRL
 * 
 * 
 *<br><br>
 <b>Proyecto</b>: API XBRL-LENLOCPENLOC2010 - Grupo de utilidades y librerías en código abierto para facilitar 
 * la integración del formato XBRL en las herramientas software de gestión de terceros
 * aislándose de la complejidad en el procesamiento del modelo de datos de las taxonomías.
 * Ayudando de esta forma a las entidades locales en la labor de realización de informes XBRL
 * y asegurar el éxito en el reporte de presupuestos y liquidación de presupuestos 
 * de las entidades locales en formato XBRL
 *
 *
 * @version 1.0, 09/07/2009
 * @author difusioncalidad@inteco.es
 * @see
 *
 */

public class TransformerToXBRLTest {
		
	static String testPath;
	static String INPUT_PATH;
	static String OUTPUT_PATH;
	static String BAT_PATH;
	
	String inputPath;
	String outputPath;
	String errorsPath;
	String validationPath;
	String batPath;
	
	@BeforeClass
	public static void init() {
		Properties prop = new Properties();
		try {
	        prop.load(new FileInputStream("./config/enloc.properties"));
	        testPath = prop.getProperty("testPath");
	        INPUT_PATH = testPath + "commandline/transform/input/";
	        OUTPUT_PATH = testPath + "commandline/transform/output/";
	        BAT_PATH = testPath + "commandline/";
        } catch(IOException e) {
	        e.printStackTrace();
        }
	}
	
	public final void commandlineTransformXMLToXBRLWithoutInputpathParameterKO() {
		inputPath = INPUT_PATH + "ITS41-TC35.xml";
		outputPath = OUTPUT_PATH + "ITS41-TC35.xbrl";
		errorsPath = OUTPUT_PATH + "ITS41-TC35_errors.xml";
		validationPath = OUTPUT_PATH + "ITS41-TC35_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat", "-xmltoxbrl", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=-1)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba -1");
	    	}
		}
	    catch(Exception e){		    
	    	throw new AssertionError(e);
		}  
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineTransformXMLToXBRLWithoutOutputpathParameterKO() {
		inputPath = INPUT_PATH + "ITS41-TC36.xml";
		outputPath = OUTPUT_PATH + "ITS41-TC36.xbrl";
		errorsPath = OUTPUT_PATH + "ITS41-TC36_errors.xml";
		validationPath = OUTPUT_PATH + "ITS41-TC36_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat", "-xmltoxbrl", "-i", inputPath, outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=-1)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba -1");
	    	}
		}
	    catch(Exception e){		    
	    	throw new AssertionError(e);
		}  
	}
	
	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineTransformXMLToXBRLWithoutErrorpathParameterKO() {
		inputPath = INPUT_PATH + "ITS41-TC37.xml";
		outputPath = OUTPUT_PATH + "ITS41-TC37.xbrl";
		errorsPath = OUTPUT_PATH + "ITS41-TC37_errors.xml";
		validationPath = OUTPUT_PATH + "ITS41-TC37_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat", "-xmltoxbrl", "-i", inputPath, "-o", outputPath, errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=-1)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba -1");
	    	}
		}
	    catch(Exception e){		    
	    	throw new AssertionError(e);
		}  
	}
	
	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineTransformXMLToXBRLWithoutValidationpathParameterKO() {
		inputPath = INPUT_PATH + "ITS41-TC38.xml";
		outputPath = OUTPUT_PATH + "ITS41-TC38.xbrl";
		errorsPath = OUTPUT_PATH + "ITS41-TC38_errors.xml";
		validationPath = OUTPUT_PATH + "ITS41-TC38_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat", "-xmltoxbrl", "-i", inputPath, "-o", outputPath, "-e", errorsPath, "-l", validationPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try {
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=-1)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba -1");
	    	}
	    }
	    catch(Exception e){		    
	    	throw new AssertionError(e);
		}  
	}
	
	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineTransformXMLToXBRLWithoutValidationParameterKO() {
		inputPath = INPUT_PATH + "ITS41-TC39.xml";
		outputPath = OUTPUT_PATH + "ITS41-TC39.xbrl";
		errorsPath = OUTPUT_PATH + "ITS41-TC39_errors.xml";
		validationPath = OUTPUT_PATH + "ITS41-TC39_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat", "-xmltoxbrl", "-i", inputPath, "-o", outputPath, "-e", errorsPath, "-v", validationPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=-1)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba -1");
	    	}
		}
	    catch(Exception e){		    
	    	throw new AssertionError(e);
		}  
	}
	
	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineTransformXMLToXBRLItemIdNotExistsKO() {
		inputPath = INPUT_PATH + "ITS41-TC40.xml";
		outputPath = OUTPUT_PATH + "ITS41-TC40.xbrl";
		errorsPath = OUTPUT_PATH + "ITS41-TC40_errors.xml";
		validationPath = OUTPUT_PATH + "ITS41-TC40_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat", "-xmltoxbrl", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try {
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!= 1)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba 1");
	    	}
	    }
	    catch(Exception e){		    
	    	throw new AssertionError(e);
		}  
	}
	
	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineTransformXMLToXBRLItemIdNotReportedKO() {
		inputPath = INPUT_PATH + "ITS41-TC41.xml";
		outputPath = OUTPUT_PATH + "ITS41-TC41.xbrl";
		errorsPath = OUTPUT_PATH + "ITS41-TC41_errors.xml";
		validationPath = OUTPUT_PATH + "ITS41-TC41_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat", "-xmltoxbrl", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!= 1)
	    	{
	    		throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba 1");
	    	}
	    }
	    catch(Exception e){		    
	    	throw new AssertionError(e);
		}  
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineTransformXMLToXBRLRowIdNotReportedKO() {
		inputPath = INPUT_PATH + "ITS41-TC42.xml";
		outputPath = OUTPUT_PATH + "ITS41-TC42.xbrl";
		errorsPath = OUTPUT_PATH + "ITS41-TC42_errors.xml";
		validationPath = OUTPUT_PATH + "ITS41-TC42_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat", "-xmltoxbrl", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try {
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!= -1)
	    	{
	    		throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba -1");
	    	}
	    }
	    catch(Exception e){		    
	    	throw new AssertionError(e);
		}  
	}	
	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineTransformXMLToXBRLRowIdDuplicatedKO() {
		inputPath = INPUT_PATH + "ITS41-TC43.xml";
		outputPath = OUTPUT_PATH + "ITS41-TC43.xbrl";
		errorsPath = OUTPUT_PATH + "ITS41-TC43_errors.xml";
		validationPath = OUTPUT_PATH + "ITS41-TC43_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat", "-xmltoxbrl", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!= 1)
	    	{
	    		throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba 1");
	    	}
	    }
	    catch(Exception e){		    
	    	throw new AssertionError(e);
		}  
	}
	
	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineTransformXMLToXBRLItemIdDuplicatedKO() {
		inputPath = INPUT_PATH + "ITS41-TC44.xml";
		outputPath = OUTPUT_PATH + "ITS41-TC44.xbrl";
		errorsPath = OUTPUT_PATH + "ITS41-TC44_errors.xml";
		validationPath = OUTPUT_PATH + "ITS41-TC44_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat", "-xmltoxbrl", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!= 1)
	    	{
	    		throw new Exception("El resultado de la ejecución es " + proceso.exitValue() + " y se esperaba 1");
	    	}
	    }
	    catch(Exception e){		    
	    	throw new AssertionError(e);
		}  
	}
	
	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineTransformXMLToXBRLWithIncorrectInputpathParameterKO() {
		inputPath = INPUT_PATH + "NO_EXISTE/ITS41-TC45.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat", "-xmltoxbrl", "-i", inputPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=-1)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba -1");
	    	}
		}
	    catch(Exception e){		    
	    	throw new AssertionError(e);
		}  
	}

	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineTransformXMLToXBRLWithIncorrectOutputpathParameterKO() {
		inputPath = INPUT_PATH + "ITS41-TC46.xml";
		outputPath = OUTPUT_PATH + "NO_EXISTE/ITS41-TC46.xbrl";
		errorsPath = OUTPUT_PATH + "ITS41-TC46_errors.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat", "-xmltoxbrl", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=-1)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba -1");
	    	}
		}
	    catch(Exception e){		    
	    	throw new AssertionError(e);
		}  
	}
	
	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineTransformXMLToXBRLWithIncorrectErrorpathParameterKO() {
		inputPath = INPUT_PATH + "ITS41-TC47.xml";
		outputPath = OUTPUT_PATH + "ITS41-TC47.xbrl";
		errorsPath = OUTPUT_PATH + "NO_EXISTE/ITS41-TC47_errors.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat", "-xmltoxbrl", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=-1)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba -1");
	    	}
		}
	    catch(Exception e){		    
	    	throw new AssertionError(e);
		}  
	}
	
	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineTransformXMLToXBRLWithIncorrectValidationpathParameterKO() {
		inputPath = INPUT_PATH + "ITS41-TC48.xml";
		outputPath = OUTPUT_PATH + "ITS41-TC48.xbrl";
		errorsPath = OUTPUT_PATH + "ITS41-TC48_errors.xml";
		validationPath = OUTPUT_PATH + "NO_EXISTE/ITS41-TC48_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat", "-xmltoxbrl", "-i", inputPath, "-o", outputPath, "-e", errorsPath, "-v", validationPath, "-l"};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try {
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=-1)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba -1");
	    	}
	    }
	    catch(Exception e){		    
	    	throw new AssertionError(e);
		}  
	}
	
}