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
 * TODO Incluir descripción de la clase
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

public class LENLOCTransformerToXMLTest {
		
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
	
	/**
	 * Test method for
	 * {@link es.inteco.xbrl.lenlocpenloc.commandline.ShellWrapper#main(java.lang.String[] args)}
	 * .
	 */
	@Test
	public final void commandlineTransformLENLOCXBRLToXMLmodDIOK() {
		inputPath = INPUT_PATH + "ITS42-TC01.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC01.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC01_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC01_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=0)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba 0");
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
	public final void commandlineTransformLENLOCXBRLToXMLmodA1OK() {
		inputPath = INPUT_PATH + "ITS42-TC02.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC02.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC02_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC02_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=0)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba 0");
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
	public final void commandlineTransformLENLOCXBRLToXMLmodA2OK() {
		inputPath = INPUT_PATH + "ITS42-TC03.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC03.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC03_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC03_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=0)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba 0");
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
	public final void commandlineTransformLENLOCXBRLToXMLmodA3POK() {
		inputPath = INPUT_PATH + "ITS42-TC04.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC04.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC04_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC04_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=0)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba 0");
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
	public final void commandlineTransformLENLOCXBRLToXMLmodA3ROK() {
		inputPath = INPUT_PATH + "ITS42-TC05.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC05.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC05_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC05_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=0)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba 0");
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
	public final void commandlineTransformLENLOCXBRLToXMLmodA4EAOK() {
		inputPath = INPUT_PATH + "ITS42-TC06.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC06.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC06_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC06_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=0)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba 0");
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
	public final void commandlineTransformLENLOCXBRLToXMLmodA4RAOK() {
		inputPath = INPUT_PATH + "ITS42-TC07.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC07.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC07_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC07_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=0)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba 0");
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
	public final void commandlineTransformLENLOCXBRLToXMLmodA5OK() {
		inputPath = INPUT_PATH + "ITS42-TC08.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC08.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC08_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC08_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=0)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba 0");
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
	public final void commandlineTransformLENLOCXBRLToXMLmodGASTOK() {
		inputPath = INPUT_PATH + "ITS42-TC09.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC09.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC09_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC09_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=0)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba 0");
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
	public final void commandlineTransformLENLOCXBRLToXMLmodINGOK() {
		inputPath = INPUT_PATH + "ITS42-TC10.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC10.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC10_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC10_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=0)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba 0");
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
	public final void commandlineTransformLENLOCXBRLToXMLmodCBOK() {
		inputPath = INPUT_PATH + "ITS42-TC11.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC11.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC11_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC11_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=0)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba 0");
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
	public final void commandlineTransformLENLOCXBRLToXMLmodACROK() {
		inputPath = INPUT_PATH + "ITS42-TC12.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC12.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC12_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC12_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=0)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba 0");
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
	public final void commandlineTransformLENLOCXBRLToXMLmodDEUOK() {
		inputPath = INPUT_PATH + "ITS42-TC13.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC13.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC13_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC13_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=0)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba 0");
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
	public final void commandlineTransformLENLOCXBRLToXMLmodPROGOK() {
		inputPath = INPUT_PATH + "ITS42-TC14.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC14.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC14_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC14_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=0)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba 0");
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
	public final void commandlineTransformLENLOCXBRLToXMLmodRTOK() {
		inputPath  = INPUT_PATH + "ITS42-TC15.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC15.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC15_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC15_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=0)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba 0");
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
	public final void commandlineTransformLENLOCXBRLToXMLmodRPOK() {
		inputPath = INPUT_PATH + "ITS42-TC16.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC16.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC16_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC16_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=0)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba 0");
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
	public final void commandlineTransformLENLOCXBRLToXMLmodRPAOK() {
		inputPath = INPUT_PATH + "ITS42-TC17.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC17.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC17_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC17_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=0)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba 0");
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
	public final void commandlineTransformLENLOCXBRLToXMLmodAllOK() {
		inputPath = INPUT_PATH + "ITS42-TC18.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC18.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC18_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC18_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=0)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba 0");
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
	public final void commandlineTransformLENLOCXBRLToXMLFileNotFoundKO() {
		inputPath = INPUT_PATH + "ITS42-TC24.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC24.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC24_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC24_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
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
	public final void commandlineTransformLENLOCXBRLToXMLInputWithErrorsKO() {
		inputPath = INPUT_PATH + "ITS42-TC25.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC25.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC25_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC25_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
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
	public final void commandlineTransformLENLOCXBRLToXMLInputNotValidKO() {
		inputPath = INPUT_PATH + "ITS42-TC26.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC26.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC26_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC26_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=0)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba 0");
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
	public final void commandlineTransformLENLOCXBRLToXMLInputNotValidWithValidationKO() {
		inputPath = INPUT_PATH + "ITS42-TC27.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC27.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC27_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC27_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath, "-v", validationPath, "-l"};
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
	public final void commandlineTransformLENLOCXBRLToXMLDimensionNotExistKO() {
		inputPath = INPUT_PATH + "ITS42-TC31.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC31.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC31_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC31_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
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
	public final void commandlineTransformLENLOCXBRLToXMLDimensionElementNotExistKO() {
		inputPath = INPUT_PATH + "ITS42-TC32.xbrl";
		outputPath = OUTPUT_PATH + "ITS42-TC32.xml";
		errorsPath = OUTPUT_PATH + "ITS42-TC32_errors.xml";
		validationPath = OUTPUT_PATH + "ITS42-TC32_validation.xml";
		
		String[] cmd = {"cmd.exe", "/C", "lanzadorPruebas.bat","-xbrltoxml", "-i", inputPath, "-o", outputPath, "-e", errorsPath};
		Runtime aplicacion = Runtime.getRuntime();
		Process proceso = null;
				
	    try{
	    	File comandoBat = new File(BAT_PATH);
	    	proceso = aplicacion.exec(cmd,null,comandoBat.getAbsoluteFile());
	    	proceso.waitFor();
	    	if (proceso.exitValue()!=1)
	    	{
	    		throw new Exception("El resultado de la ejecución es "+proceso.exitValue() + " y se esperaba 1");
	    	}
		}
	    catch(Exception e){		    
	    	throw new AssertionError(e);
		}  
	}
}