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

package es.inteco.xbrl.lenlocpenloc.commandline;


/**
 * Clase que analiza y distingue los argumentos de los diferentes servicios de
 * la API<br>
 * Decide qué funcionalidad debe ser ejecutada y asigna valor a los atributos
 * necesarios para su ejecución.
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
 * 
 */
public abstract class ShellWrapper {

	static String validationExceptionSuffix = "_validation.xml";
	static String destinationSuffix_xbrl = "_output.xbrl";
	static String destinationSuffix_xml = "_output.xml";
	static String destinationSuffix_html = "_output.html";
	static String errorSuffix = "_errors.xml";

	/**
	 * Método principal de la clase que permite seleccionar los servicios
	 * ofrecidos de validación XBRL, validación XSD, transformación de XBRL a
	 * XML, transformación de XML a XBRL, transformación de XBRL a HTML y
	 * transformación de XML a HTML.<br>
	 * <br>
	 * Podemos diferenciar los seis servicios según el valor del primer
	 * argumento obligatorio la clase "ShellWrapper": <br>
	 * <br>
	 * <b>args</b> Conjunto de argumentos para discernir los diferentes
	 * servicios y sus atributos de clase. Se detallan a continuación: <br>
	 * <br>
	 * Primer argumento <b>-validatexbrl: Validación de XBRL</b><br>
	 * Siguientes argumentos: <br>
	 * <b>-i FicheroEntrada </b>: Es obligatorio e indica la ruta del fichero a
	 * validar<br>
	 * <b>[-e FicheroErrores] </b>: Es opcional e indica la ruta del fichero de
	 * errores<br>
	 * <b>[-v FicheroValidacion] </b>: Es opcional e indica la ruta del fichero
	 * con el resultado de la validación<br>
	 * <b>[-x]</b>: Es opcional y termina la ejecución devolviendo el resultado
	 * de la operación<br>
	 * <br>
	 * Primer argumento <b>-validatexsd: Validación de XML</b><br>
	 * Siguientes argumentos: <br>
	 * <b>-i FicheroEntrada </b>: Es obligatorio e indica la ruta del fichero a
	 * validar<br>
	 * <b>[-e FicheroErrores] </b>: Es opcional e indica la ruta del fichero de
	 * errores<br>
	 * <b>[-v FicheroValidacion] </b>: Es opcional e indica la ruta del fichero
	 * con el resultado de la validación<br>
	 * <b>[-x]</b>: Es opcional y termina la ejecución devolviendo el resultado
	 * de la operación<br>
	 * <br>
	 * Primer argumento <b>-xbrltoxml: Transformación de XBRL a XML</b><br>
	 * Siguientes argumentos: <br>
	 * <b>-i FicheroEntrada </b>: Es obligatorio e indica la ruta del fichero de
	 * entrada XBRL<br>
	 * <b>[-e FicheroErrores] </b>: Es opcional e indica la ruta del fichero de
	 * errores<br>
	 * <b>[-v FicheroValidacion] </b>: Es opcional e indica la ruta del fichero
	 * con el resultado de la validación<br>
	 * <b>[-o FicheroResultante] </b>: Es opcional e indica la ruta del fichero
	 * en formato XML resultado de la transformación<br>
	 * <b>[-l] </b>: Es opcional e indica que se debe realizar la validación del
	 * fichero XBRL de entrada<br>
	 * <b>[-x]</b>: Es opcional y termina la ejecución devolviendo el resultado
	 * de la operación<br>
	 *<br>
	 * Primer argumento <b>-xmltoxbrl: Transformación de XML a XBRL</b><br>
	 * Siguientes argumentos: <br>
	 * <b>-i FicheroEntrada </b>: Es obligatorio e indica la ruta del fichero de
	 * entrada XML<br>
	 * <b>[-e FicheroErrores] </b>: Es opcional e indica la ruta del fichero de
	 * errores<br>
	 * <b>[-v FicheroValidacion] </b>: Es opcional e indica la ruta del fichero
	 * con el resultado de la validación<br>
	 * <b>[-o FicheroResultante] </b>: Es opcional e indica la ruta del fichero
	 * en formato XBRL resultado de la transformación<br>
	 * <b>[-l] </b>: Es opcional e indica que se debe realizar la validación del
	 * fichero XBRL de salida <br>
	 * <b>[-x]</b>: Es opcional y termina la ejecución devolviendo el resultado
	 * de la operación<br>
	 * <br>
	 * Primer argumento <b>-xbrltohtml: Transformación de XBRL a HTML</b><br>
	 * Siguientes argumentos: <br>
	 * <b>-i FicheroEntrada </b>: Es obligatorio e indica la ruta del fichero de
	 * entrada XBRL<br>
	 * <b>-m MóduloVisualización</b>: Es obligatorio e indica el módulo a
	 * visualizar en el fichero HTML de salida <br>
	 * <b>[-e FicheroErrores] </b>: Es opcional e indica la ruta del fichero de
	 * errores<br>
	 * <b>[-o FicheroResultante] </b>: Es opcional e indica la ruta del fichero
	 * en formato HTML resultado de la transformación <br>
	 * <b>[-x]</b>: Es opcional y termina la ejecución devolviendo el resultado
	 * de la operación<br>
	 *<br>
	 * Primer argumento <b>-xmltohtml: Transformación de XML a HTML</b><br>
	 * Siguientes argumentos: <br>
	 * <b>-i FicheroEntrada </b>: Es obligatorio e indica la ruta del fichero de
	 * entrada XML<br>
	 * <b>-m MóduloVisualización</b>: Es obligatorio e indica el módulo a
	 * visualizar en el fichero HTML de salida <br>
	 * <b>[-e FicheroErrores] </b>: Es opcional e indica la ruta del fichero de
	 * errores<br>
	 * <b>[-o FicheroResultante] </b>: Es opcional e indica la ruta del fichero
	 * en formato HTML resultado de la transformación<br>
	 * <b>[-x]</b>: Es opcional y termina la ejecución devolviendo el resultado
	 * de la operación<br>
	 *<br>
	 * <br>
	 * <b>return</b> <br>
	 * Según la finalización de la ejecución se muestra un resultado por la
	 * salida estándar o en caso de utilizar el argumento -x, se termina la
	 * ejecución con dicho valor como argumento<br>
	 * <br>
	 * 
	 * resultado:<br>
	 * 0 si la ejecución ha sido correcta<br>
	 * -1 si la ejecución ha sido incorrecta<br>
	 * 1 si la ejecución ha sido correcta pero se han registrado warnings o
	 * errores leves<br>
	 */

	public static void main(String[] args) {

		int argsAction = 0;

		if(args.length == 0) {
			use(-1);
		} else {
			try {
				if(args[0].charAt(0) == '-') {
					String argumentZero = args[0];
					if(args[0].charAt(1) == 'h') {
						use(0);
					} else {
						if(argumentZero.equalsIgnoreCase("-validatexbrl")) {
							argsAction = 1;
						} else {
							if(argumentZero.equalsIgnoreCase("-xbrltoxml")) {
								argsAction = 2;
							} else {
								if(argumentZero.equalsIgnoreCase("-xmltoxbrl")) {
									argsAction = 3;
								} else {
									if(argumentZero.equalsIgnoreCase("-xbrltohtml")) {
										argsAction = 4;
									} else {
										if(argumentZero.equalsIgnoreCase("-xmltohtml")) {
											argsAction = 5;
										} else {
											if(argumentZero.equalsIgnoreCase("-validatexsd")) {
												argsAction = 6;
											} else {
												use(-1);
											}
										}
									}
								}
							}
						}
					}
				}
			} catch(Throwable argumentError) {
				use(-1);
			}
		}

		// como no ha habido error en los parámetros, continuo con el proceso
		int result = -1;
		IApiDispatcher aDispath = ApiDispatcher.createInstance();
		String inputFilePath = null;
		String errorFilePath = null;
		String validationFilePath = null;
		String outputFilePath = null;
		
		switch(argsAction) {
			case 1: // valida
				try {
					if(args.length == 1) {
						useValidation(-1,null);
					} else {
						for(int i = 1; i < args.length; i++) {
							if(args[i].charAt(0) == '-') {
								switch(args[i].charAt(1)) {
									case 'h':
										useValidation(0,null);
										break;
									case 'i':
										if(i + 1 < args.length) {
											inputFilePath = args[++i];
											if(!LogFilesManager.existsDirectory(inputFilePath))
												useValidation(-1,"La ruta \"" + inputFilePath +"\" del fichero de entrada no existe");
											else if(!LogFilesManager.existsFile(inputFilePath))
											{
												System.out.println();
												System.out.println("ERROR: El fichero de entrada " + LogFilesManager.getNoExtensionFileName(inputFilePath) + "." + LogFilesManager.getExtensionFileName(inputFilePath) + " no existe");
												aDispath.setDocXbrlPath(inputFilePath);
											}
											else if(LogFilesManager.isValidXbrlFile(inputFilePath))
												aDispath.setDocXbrlPath(inputFilePath);
											else 
												useValidation(-1,"El fichero de entrada debe tener extensión .xbrl o .xml");
										} else
											useValidation(-1,null);
										break;
									case 'e':
											if(i + 1 < args.length) {
												errorFilePath = args[++i];
												if(!LogFilesManager.existsDirectory(errorFilePath))
													generateErrorPath(inputFilePath, errorFilePath);
												else if(LogFilesManager.isValidXmlFile(errorFilePath))
													aDispath.setErrorFilePath(errorFilePath);
												else 
													useValidation(-1,"El fichero de salida de errores debe tener extensión .xml");
											} else {
												useValidation(-1,null);
											}
										break;
									case 'v':
											if(i + 1 < args.length)
											{				
												validationFilePath = args[++i];
												if(!LogFilesManager.existsDirectory(validationFilePath))
													generateValidatePath(inputFilePath, validationFilePath);
												else if(LogFilesManager.isValidXmlFile(validationFilePath))
													aDispath.setValidationResultFilePath(validationFilePath);
												else {
													useValidation(-1,"El fichero de salida de la validación debe tener extensión .xml");
												}
											} else {
												useValidation(-1,null);
											}
										break;
									case 'x':
										break;
									default:
										useValidation(-1,"Sintaxis incorrecta: error al leer los parámetros");
										break;
								}
							} else {
								useValidation(-1,"Sintaxis incorrecta: error al leer los parámetros de entrada");
							}
						}
						if(aDispath.getDocXbrlPath() == null) {
							useValidation(-1,null);
						}
					}
					aDispath.setValidationRequired(true);

					// Si no se ha definido un nombre por defecto al fichero de
					// validación se lo asigno a partir de la ruta completa del
					// fichero de entrada
					if(aDispath.getValidationResultFilePath() == null) {
						aDispath.setValidationResultFilePath(LogFilesManager.getFilePathAndNoExtensionName(
						        aDispath.getDocXbrlPath()).concat(validationExceptionSuffix));
					}

					// Si el directorio de log no está definido, asigno por
					// defecto el directorio del fichero de entrada
					if(aDispath.getErrorFilePath() == null) {
						aDispath.setErrorFilePath(LogFilesManager.getFilePathAndNoExtensionName(
						        aDispath.getDocXbrlPath()).concat(errorSuffix));
					}

					result = aDispath.executeXBRLValidation();
				} catch(Throwable argumentError) {
					useValidation(-1,null);
				}
				break;

			case 2: // transforma a xml
				try {
					inputFilePath = null;
					errorFilePath = null;
					validationFilePath = null;
					outputFilePath = null;
					if(args.length == 1) {
						useToXml(-1,null);
					} else {
						boolean valid = validate(args);
						for(int i = 1; i < args.length; i++) {
							if(args[i].charAt(0) == '-') {
								switch(args[i].charAt(1)) {
									case 'h':
										useToXml(0,null);
										break;
									case 'i':
										if(i + 1 < args.length) {
											inputFilePath = args[++i];
											if(!LogFilesManager.existsDirectory(inputFilePath))
												useToXml(-1,"La ruta \"" + inputFilePath +"\" del fichero de entrada no existe");
											else if(!LogFilesManager.existsFile(inputFilePath))
											{
												System.out.println();
												System.out.println("ERROR: El fichero de entrada " + LogFilesManager.getNoExtensionFileName(inputFilePath) + "." + LogFilesManager.getExtensionFileName(inputFilePath) + " no existe");
												aDispath.setDocXbrlPath(inputFilePath);
											}
											else if(LogFilesManager.isValidXbrlFile(inputFilePath))
												aDispath.setDocXbrlPath(inputFilePath);
											else
												useToXml(-1,"El fichero de entrada debe tener extensión .xbrl o .xml");
										} else
											useToXml(-1,null);
										break;
									case 'e':
										if(i + 1 < args.length) {
											errorFilePath = args[++i];
											if(!LogFilesManager.existsDirectory(errorFilePath))
												generateErrorPath(inputFilePath, errorFilePath);
											else if(LogFilesManager.isValidXmlFile(errorFilePath))
												aDispath.setErrorFilePath(errorFilePath);
											else {
												useToXml(-1,"El fichero de salida de errores debe tener extensión .xml");
											}
										} else {
											useToXml(-1,null);
										}
										break;
									case 'v':
										if (!valid) {
											useToXml(-1, "Se ha introducido un parámetro incorrecto \"-v\". Para realizar la validación del fichero de salida debe introducir el parámetro -l");
										}
										else {
											if(i + 1 < args.length) {
												validationFilePath = args[++i];
												if(!LogFilesManager.existsDirectory(validationFilePath))
													generateValidatePath(inputFilePath, validationFilePath);
												else if(LogFilesManager.isValidXmlFile(validationFilePath))
													aDispath.setValidationResultFilePath(validationFilePath);
												else {
													useToXml(-1,"El fichero de salida de la validación debe tener extensión .xml");
												}
											} else {
												useToXml(-1,null);
											}
										}	
										break;
									case 'l':
										aDispath.setValidationRequired(true);
										break;
									case 'o':
										if(i + 1 < args.length) {
											outputFilePath = args[++i];
											if(!LogFilesManager.existsDirectory(outputFilePath))
												generateOutputPath(inputFilePath, outputFilePath);
											else if(LogFilesManager.isValidXmlFile(outputFilePath))
												aDispath.setDocXMLPath(outputFilePath);
											else {
												useToXml(-1,"El fichero de salida debe tener extensión .xml");
											}
										} else {
											useToXml(-1,null);
										}
										break;
									case 'x':
										break;
									default:
										useToXml(-1,"Sintaxis incorrecta: error al leer los parámetros");
										break;
								}
							} else {
								useToXml(-1,"Sintaxis incorrecta: error al leer los parámetros de entrada");
							}
						}
						if(aDispath.getDocXbrlPath() == null) {
							useToXml(-1,null);
						}
					}
					// Si el directorio de log no está definido, asigno por
					// defecto el directorio del fichero de entrada
					if(aDispath.getValidationResultFilePath() == null) {
						aDispath.setValidationResultFilePath(LogFilesManager.getFilePathAndNoExtensionName(
						        aDispath.getDocXbrlPath()).concat(validationExceptionSuffix));
					}

					// Si no se ha definido un nombre al fichero de validación,
					// se lo asigno a partir de la ruta completa del fichero de
					// entrada
					if(aDispath.getErrorFilePath() == null) {
						aDispath.setErrorFilePath(LogFilesManager.getFilePathAndNoExtensionName(
						        aDispath.getDocXbrlPath()).concat(errorSuffix));
					}
					// Si no se ha definido un nombre al fichero de salida con
					// formato XML, se lo asigno a partir de la ruta completa
					// del fichero de entrada
					if(aDispath.getDocXMLPath() == null) {
						aDispath.setDocXMLPath(LogFilesManager.getFilePathAndNoExtensionName(aDispath.getDocXbrlPath())
						        .concat(destinationSuffix_xml));
					}

					result = aDispath.executeTransformationToXML();
				} catch(Throwable argumentError) {
					useToXml(-1,null);
				}
				break;

			case 3: // transforma a XBRL
				try {
					inputFilePath = null;
					errorFilePath = null;
					validationFilePath = null;
					outputFilePath = null;
					if(args.length == 1) {
						useToXbrl(-1,null);
					} else {
						boolean valid = validate(args);
						for(int i = 1; i < args.length; i++) {
							if(args[i].charAt(0) == '-') {
								switch(args[i].charAt(1)) {
									case 'h':
										useToXbrl(0,null);
										break;
									case 'i':
										if(i + 1 < args.length) {
											inputFilePath = args[++i];
											if(!LogFilesManager.existsDirectory(inputFilePath))
												useToXbrl(-1,"La ruta \"" + inputFilePath +"\" del fichero de entrada no existe");
											else if(!LogFilesManager.existsFile(inputFilePath))
											{
												System.out.println();
												System.out.println("ERROR: El fichero de entrada " + LogFilesManager.getNoExtensionFileName(inputFilePath) + "." + LogFilesManager.getExtensionFileName(inputFilePath) + " no existe");
												aDispath.setDocXMLPath(inputFilePath);
											}
											else if(LogFilesManager.isValidXmlFile(inputFilePath))
												aDispath.setDocXMLPath(inputFilePath);
											else
												useToXbrl(-1,"El fichero de entrada debe tener extensión .xml");
										} else
											useToXbrl(-1,null);
										break;
									case 'e':
										if(i + 1 < args.length) {
											errorFilePath = args[++i];
											if(!LogFilesManager.existsDirectory(errorFilePath))
												generateErrorPath(inputFilePath, errorFilePath);
											else if(LogFilesManager.isValidXmlFile(errorFilePath))
												aDispath.setErrorFilePath(errorFilePath);
											else {
												useToXbrl(-1,"El fichero de salida de errores debe tener extensión .xml");
											}
										} else {
											useToXbrl(-1,null);
										}
										break;
									case 'v':
										if (!valid) {
											useToXbrl(-1, "Se ha introducido un parámetro incorrecto \"-v\". Para realizar la validación del fichero de salida debe introducir el parámetro -l");
										}
										else {										
											if(i + 1 < args.length && valid) {
												validationFilePath = args[++i];
												if(!LogFilesManager.existsDirectory(validationFilePath))
													generateValidatePath(inputFilePath, validationFilePath);
												else if(LogFilesManager.isValidXmlFile(validationFilePath))
													aDispath.setValidationResultFilePath(validationFilePath);
												else {
													useToXbrl(-1,"El fichero de salida de la validación debe tener extensión .xml");
												}
											} else {
												useToXbrl(-1,null);
											}
										}	
										break;
									case 'l':
										aDispath.setValidationRequired(true);
										break;
									case 'o':
										if(i + 1 < args.length) {
											outputFilePath = args[++i];
											if(!LogFilesManager.existsDirectory(outputFilePath))
												generateOutputPath(inputFilePath, outputFilePath);
											else if(LogFilesManager.isValidXbrlFile(outputFilePath))
												aDispath.setDocXbrlPath(outputFilePath);
											else {
												useToXbrl(-1,"El fichero de salida debe tener extensión .xbrl o .xml");
											}
										} else {
											useToXbrl(-1,null);
										}
										break;
									case 'x':
										break;
									default:
										useToXbrl(-1,"Sintaxis incorrecta: error al leer los parámetros");
										break;
								}
							} else {
								useToXbrl(-1,"Sintaxis incorrecta: error al leer los parámetros de entrada");
							}
						}
						if(aDispath.getDocXMLPath() == null) {
							useToXbrl(-1,null);
						}
					}
					// Si el directorio de log no está definido, asigno por
					// defecto el directorio del fichero de entrada
					if(aDispath.getValidationResultFilePath() == null) {
						aDispath.setValidationResultFilePath(LogFilesManager.getFilePathAndNoExtensionName(
						        aDispath.getDocXMLPath()).concat(validationExceptionSuffix));
					}

					// Si no se ha definido un nombre al fichero de validación,
					// se lo asigno a partir de la ruta completa del fichero de
					// entrada
					if(aDispath.getErrorFilePath() == null) {
						aDispath.setErrorFilePath(LogFilesManager.getFilePathAndNoExtensionName(
						        aDispath.getDocXMLPath()).concat(errorSuffix));
					}
					// Si no se ha definido un nombre al fichero de salida con
					// formato XML, se lo asigno a partir de la ruta completa
					// del fichero de entrada
					if(aDispath.getDocXbrlPath() == null) {
						aDispath.setDocXbrlPath(LogFilesManager.getFilePathAndNoExtensionName(aDispath.getDocXMLPath())
						        .concat(destinationSuffix_xbrl));
					}
					result = aDispath.executeTransformationToXBRL();
				} catch(Throwable argumentError) {
					useToXbrl(-1,null);
				}
				break;
			case 4: // visualiza xbrl
				try {
					inputFilePath = null;
					errorFilePath = null;
					outputFilePath = null;
					if(args.length == 1) {
						useViewXbrl(-1,null);
					} else {
						for(int i = 1; i < args.length; i++) {
							if(args[i].charAt(0) == '-') {
								switch(args[i].charAt(1)) {
									case 'h':
										useViewXbrl(0,null);
										break;
									case 'i':
										if(i + 1 < args.length) {
											inputFilePath = args[++i];
											if(!LogFilesManager.existsDirectory(inputFilePath))
												useViewXbrl(-1,"La ruta \"" + inputFilePath +"\" del fichero de entrada no existe");
											else if(!LogFilesManager.existsFile(inputFilePath))
											{
												System.out.println();
												System.out.println("ERROR: El fichero de entrada " + LogFilesManager.getNoExtensionFileName(inputFilePath) + "." + LogFilesManager.getExtensionFileName(inputFilePath) + " no existe");
												aDispath.setDocXbrlPath(inputFilePath);
											}
											else if(LogFilesManager.isValidXbrlFile(inputFilePath))
												aDispath.setDocXbrlPath(inputFilePath);
											else
												useViewXbrl(-1,"El fichero de entrada debe tener extensión .xbrl o .xml");
										} else
											useViewXbrl(-1,null);
										break;
									case 'e':
										if(i + 1 < args.length) {
											errorFilePath = args[++i];
											if(!LogFilesManager.existsDirectory(errorFilePath))
												generateErrorPath(inputFilePath, errorFilePath);
											else if(LogFilesManager.isValidXmlFile(errorFilePath))
												aDispath.setErrorFilePath(errorFilePath);
											else {
												useViewXbrl(-1,"El fichero de salida de errores debe tener extensión .xml");
											}
										} else {
											useViewXbrl(-1,null);
										}
										break;
									case 'o':
										if(i + 1 < args.length) {
											outputFilePath = args[++i];
											if(!LogFilesManager.existsDirectory(outputFilePath))
												generateOutputPath(inputFilePath, outputFilePath);
											else if(LogFilesManager.isValidHtmlFile(outputFilePath))
												aDispath.setDocHTMLPath(outputFilePath);
											else {
												useViewXbrl(-1,"El fichero de salida debe tener extensión .html");
											}
										} else {
											useViewXbrl(-1,null);
										}
										break;
									case 'm':
										if(i + 1 < args.length) {
											aDispath.setModuleName(args[++i]);
										} else {
											useViewXbrl(-1,null);
										}
										break;
									case 'x':
										break;
									default:
										useViewXbrl(-1,"Sintaxis incorrecta: error al leer los parámetros");
										break;
								}
							} else {
								useViewXbrl(-1,"Sintaxis incorrecta: error al leer los parámetros de entrada");
							}
						}
						if(aDispath.getDocXbrlPath() == null) {
							useViewXbrl(-1,null);
						}
					}
					// Si no se ha definido un módulo de visualización, se
					// muestra la ayuda
					if(aDispath.getModuleName() == null) {
						useViewXbrl(-1,null);
					}
					// Si no se ha definido un nombre al fichero de error, se lo
					// asigno a partir de la ruta completa del fichero de
					// entrada
					if(aDispath.getErrorFilePath() == null) {
						aDispath.setErrorFilePath(LogFilesManager.getFilePathAndNoExtensionName(
						        aDispath.getDocXbrlPath()).concat(errorSuffix));
					}
					// Si no se ha definido un nombre al fichero de salida con
					// formato HTML, se lo asigno a partir de la ruta completa
					// del fichero de entrada
					if(aDispath.getDocHTMLPath() == null) {
						aDispath.setDocHTMLPath(LogFilesManager
						        .getFilePathAndNoExtensionName(aDispath.getDocXbrlPath())
						        .concat(destinationSuffix_html));
					}

					result = aDispath.executeVisualizationFromXBRL();
				} catch(Throwable argumentError) {
					useViewXbrl(-1,null);
				}
				break;

			case 5: // visualiza xml
				try {
					inputFilePath = null;
					errorFilePath = null;
					outputFilePath = null;
					if(args.length == 1) {
						useViewXml(-1,null);
					} else {
						for(int i = 1; i < args.length; i++) {
							if(args[i].charAt(0) == '-') {
								switch(args[i].charAt(1)) {
									case 'h':
										useViewXml(0,null);
										break;
									case 'i':
										if(i + 1 < args.length) {
											inputFilePath = args[++i];
											if(!LogFilesManager.existsDirectory(inputFilePath))
												useViewXml(-1,"La ruta \"" + inputFilePath +"\" del fichero de entrada no existe");
											else if(!LogFilesManager.existsFile(inputFilePath))
											{
												System.out.println();
												System.out.println("ERROR: El fichero de entrada " + LogFilesManager.getNoExtensionFileName(inputFilePath) + "." + LogFilesManager.getExtensionFileName(inputFilePath) + " no existe");
												aDispath.setDocXMLPath(inputFilePath);
											}
											else if(LogFilesManager.isValidXmlFile(inputFilePath))
												aDispath.setDocXMLPath(inputFilePath);
											else
												useViewXml(-1,"El fichero de entrada debe tener extensión .xml");
										} else
											useViewXml(-1,null);
										break;
									case 'e':
										if(i + 1 < args.length) {
											errorFilePath = args[++i];
											if(!LogFilesManager.existsDirectory(errorFilePath))
												generateErrorPath(inputFilePath, errorFilePath);
											else if(LogFilesManager.isValidXmlFile(errorFilePath))
												aDispath.setErrorFilePath(errorFilePath);
											else {
												useViewXml(-1,"El fichero de salida de errores debe tener extensión .xml");
											}
										} else {
											useViewXml(-1,null);
										}
										break;
									case 'o':
										if(i + 1 < args.length) {
											outputFilePath = args[++i];
											if(!LogFilesManager.existsDirectory(outputFilePath))
												generateOutputPath(inputFilePath, outputFilePath);
											else if(LogFilesManager.isValidHtmlFile(outputFilePath))
												aDispath.setDocHTMLPath(outputFilePath);
											else {
												useViewXml(-1,"El fichero de salida debe tener extensión .html");
											}
										} else {
											useViewXml(-1,null);
										}
										break;
									case 'm':
										if(i + 1 < args.length) {
											aDispath.setModuleName(args[++i]);
										} else {
											useViewXml(-1,null);
										}
										break;
									case 'x':
										break;
									default:
										useViewXml(-1,"Sintaxis incorrecta: error al leer los parámetros");
										break;
								}
							} else {
								useViewXml(-1,"Sintaxis incorrecta: error al leer los parámetros de entrada");
							}
						}
						if(aDispath.getDocXMLPath() == null) {
							useViewXml(-1,null);
						}
					}
					// Si no se ha definido un módulo de visualización, se
					// muestra la ayuda
					if(aDispath.getModuleName() == null) {
						useViewXml(-1,null);
					}
					// Si no se ha definido un nombre al fichero de error, se lo
					// asigno a partir de la ruta completa del fichero de
					// entrada
					if(aDispath.getErrorFilePath() == null) {
						aDispath.setErrorFilePath(LogFilesManager.getFilePathAndNoExtensionName(
						        aDispath.getDocXMLPath()).concat(errorSuffix));
					}
					// Si no se ha definido un nombre al fichero de salida con
					// formato HTML, se lo asigno a partir de la ruta completa
					// del fichero de entrada
					if(aDispath.getDocHTMLPath() == null) {
						aDispath.setDocHTMLPath(LogFilesManager.getFilePathAndNoExtensionName(aDispath.getDocXMLPath())
						        .concat(destinationSuffix_html));
					}
					result = aDispath.executeVisualizationFromXML();
				} catch(Throwable argumentError) {
					useViewXml(-1,null);
				}
				break;
			case 6: // valida xml
				try {
					inputFilePath = null;
					errorFilePath = null;
					validationFilePath = null;
					if(args.length == 1) {
						useValidationXML(-1,null);
					} else {
						for(int i = 1; i < args.length; i++) {
							if(args[i].charAt(0) == '-') {
								switch(args[i].charAt(1)) {
									case 'h':
										useValidationXML(0,null);
										break;
									case 'i':
										if(i + 1 < args.length) {
											inputFilePath = args[++i];
											if(!LogFilesManager.existsDirectory(inputFilePath))
												useValidationXML(-1,"La ruta \"" + inputFilePath +"\" del fichero de entrada no existe");
											else if(!LogFilesManager.existsFile(inputFilePath))
											{
												System.out.println();
												System.out.println("ERROR: El fichero de entrada " + LogFilesManager.getNoExtensionFileName(inputFilePath) + "." + LogFilesManager.getExtensionFileName(inputFilePath) + " no existe");
												aDispath.setDocXMLPath(inputFilePath);
											}
											else if(LogFilesManager.isValidXmlFile(inputFilePath))
												aDispath.setDocXMLPath(inputFilePath);
											else
												useValidationXML(-1,"El fichero de entrada debe tener extensión .xml");
										} else
											useValidationXML(-1,null);
										break;
									case 'e':
										if(i + 1 < args.length) {
											errorFilePath = args[++i];
											if(!LogFilesManager.existsDirectory(errorFilePath))
												generateErrorPath(inputFilePath, errorFilePath);
											else if(LogFilesManager.isValidXmlFile(errorFilePath))
												aDispath.setErrorFilePath(errorFilePath);
											else {
												useValidationXML(-1,"El fichero de salida de errores debe tener extensión .xml");
											}
										} else {
											useValidationXML(-1,null);
										}
										break;
									case 'v':
										if(i + 1 < args.length) {
											validationFilePath = args[++i];
											if(!LogFilesManager.existsDirectory(validationFilePath))
												generateValidatePath(inputFilePath, validationFilePath);
											else if(LogFilesManager.isValidXmlFile(validationFilePath))
												aDispath.setValidationResultFilePath(validationFilePath);
											else {
												useValidationXML(-1,"El fichero de salida de la validación debe tener extensión .xml");
											}
										} else {
											useValidationXML(-1,null);
										}
										break;
									case 'x':
										break;
									default:
										useValidationXML(-1,"Sintaxis incorrecta: error al leer los parámetros");
										break;
								}
							} else {
								useValidationXML(-1,"Sintaxis incorrecta: error al leer los parámetros de entrada");
							}
						}
						if(aDispath.getDocXMLPath() == null) {
							useValidationXML(-1,null);
						}
					}
					// aDispath.setValidationRequired(true);

					// Si no se ha definido un nombre por defecto al fichero de
					// validación se lo asigno a partir de la ruta completa del
					// fichero de entrada
					if(aDispath.getValidationResultFilePath() == null) {
						aDispath.setValidationResultFilePath(LogFilesManager.getFilePathAndNoExtensionName(
						        aDispath.getDocXMLPath()).concat(validationExceptionSuffix));
					}

					// Si el directorio de log no está definido, asigno por
					// defecto el directorio del fichero de entrada
					if(aDispath.getErrorFilePath() == null) {
						aDispath.setErrorFilePath(LogFilesManager.getFilePathAndNoExtensionName(
						        aDispath.getDocXMLPath()).concat(errorSuffix));
					}

					result = aDispath.executeXSDValidation();
				} catch(Throwable argumentError) {
					useValidationXML(-1,null);
				}
				break;
		}
		System.exit(result);
	}

	/**
	 * Método que presenta por salida estándar los errores al usuario cuando hay
	 * error en los parámetros.
	 * 
	 * @param returnValue código de salida del proceso.
	 */
	static private void use(int returnValue) {

		System.out.println();
		System.out.println("API XBRL LENLOC-PENLOC");
		System.out.println();
		System.out.println("Uso:");
		System.out.println("        arg : ");
		System.out.println("                    -validatexbrl Valida un fichero XBRL");
		System.out.println("                    -validatexsd Valida un fichero XML");
		System.out.println("                    -xbrltoxml Transforma de XBRL a XML");
		System.out.println("                    -xmltoxbrl Transforma de XML a XBRL");
		System.out.println("                    -xbrltohtml Visualiza un fichero XBRL");
		System.out.println("                    -xmltohtml Visualiza un fichero XML");
		System.out.println("");
		System.out.println("        resultado : ");
		System.out.println("                     0 si la ejecución ha sido correcta");
		System.out.println("                    -1 si la ejecución ha sido incorrecta");
		System.out.println("                     1 si la ejecución ha sido correcta pero se han registrado warnings o errores leves");
		System.out.println();
		System.out.println("		");
		System.out.println("Uso: -h");
		System.out.println("                     Muestra esta ayuda");
		System.out.println();
		System.exit(returnValue);
	}


	/**
	 * Método que presenta por salida estándar los errores al usuario cuando hay
	 * error en los parámetros.
	 * 
	 * @param message mensaje de error para el usuario.
	 */
	static private void useValidation(int returnValue, String message) {

		System.out.println();
		System.out.println("API XBRL LENLOC-PENLOC");
		System.out.println();
		if (message != null && !"".equals(message))
			System.out.println("ERROR: " + message);
		System.out.println();
		System.out.println("Uso: -validatexbrl -i FicheroEntrada [-e FicheroErrores] [-v FicheroValidacion] [-x]");
		System.out.println("                             Valida un fichero XBRL");
		System.out.println("                             -i ruta del fichero de entrada XBRL");
		System.out.println("                             -e Fichero de errores");
		System.out.println("                             -v Fichero de resultado de validación");
		System.out.println();
		System.out.println("                             -h Muestra esta ayuda");
		System.out.println();
		System.out.println("                             -x Cierra el cuadro de comandos devolviendo el resultado de la operación");
		System.out.println();
		System.out.println("        		resultado : ");
		System.out.println("                    		  0 si la ejecución ha sido correcta");
		System.out.println("                    		 -1 si la ejecución ha sido incorrecta");
		System.out.println("                    		  1 si la ejecución ha sido correcta pero se han registrado warnings o errores leves");
		System.out.println("     				");
		System.out.println();
		System.exit(returnValue);
	}


	/**
	 * Método que presenta por salida estándar los errores al usuario cuando hay
	 * error en los parámetros.
	 * 
	 * @param message mensaje de error para el usuario.
	 */
	static private void useValidationXML(int returnValue, String message) {

		System.out.println();
		System.out.println("API XBRL LENLOC-PENLOC");
		System.out.println();
		if (message != null && !"".equals(message))		
			System.out.println("ERROR: " + message);
		System.out.println();
		System.out.println("Uso: -validatexsd -i FicheroEntrada [-e FicheroErrores] [-v FicheroValidacion] [-x]");
		System.out.println("                             Valida un fichero XML");
		System.out.println("                             -i ruta del fichero de entrada XML");
		System.out.println("                             -e Fichero de errores");
		System.out.println("                             -v Fichero de resultado de validación");
		System.out.println();
		System.out.println("                             -h Muestra esta ayuda");
		System.out.println();
		System.out.println("                             -x Cierra el cuadro de comandos devolviendo el resultado de la operación");
		System.out.println();
		System.out.println("        		resultado : ");
		System.out.println("                    		  0 si la ejecución ha sido correcta");
		System.out.println("                    		 -1 si la ejecución ha sido incorrecta");
		System.out.println("                    		  1 si la ejecución ha sido correcta pero se han registrado warnings o errores leves");
		System.out.println("     				");
		System.out.println();
		System.exit(returnValue);
	}


	/**
	 * Método que presenta por salida estándar los errores al usuario cuando hay
	 * error en los parámetros.
	 * 
	 * @param message mensaje de error para el usuario.
	 */
	static private void useToXml(int returnValue, String message) {

		System.out.println();
		System.out.println("API XBRL LENLOC-PENLOC");
		System.out.println();
		if (message != null && !"".equals(message))
			System.out.println("ERROR: " + message);
		System.out.println();
		System.out.println("Uso: -xbrltoxml -i FicheroEntrada [-o FicheroResultante] [-e FicheroErrores] [-v FicheroValidacion] [-l] [-x]");
		System.out.println("                             Transforma un fichero XBRL a XML");
		System.out.println("                             -i ruta del fichero de entrada XBRL");
		System.out.println("                             -o ruta del fichero de salida XML");
		System.out.println("                             -e Fichero de errores");
		System.out.println("                             -v Fichero de resultado de validación");
		System.out.println("                             -l Realiza la validación del fichero XBRL de entrada");
		System.out.println();
		System.out.println("                             -h Muestra esta ayuda");
		System.out.println();
		System.out.println("                    	     -x Cierra el cuadro de comandos devolviendo el resultado de la operación");
		System.out.println();
		System.out.println("        		resultado : ");
		System.out.println("                    		  0 si la ejecución ha sido correcta");
		System.out.println("                    		 -1 si la ejecución ha sido incorrecta");
		System.out.println("                    		  1 si la ejecución ha sido correcta pero se han registrado warnings o errores leves");
		System.out.println("     				");
		System.out.println();
		System.exit(returnValue);
	}


	/**
	 * Método que presenta por salida estándar los errores al usuario cuando hay
	 * error en los parámetros.
	 * 
	 * @param message mensaje de error para el usuario.
	 */
	static private void useToXbrl(int returnValue, String message) {

		System.out.println();
		System.out.println("API XBRL LENLOC-PENLOC");
		System.out.println();
		if (message != null && !"".equals(message))
			System.out.println("ERROR: " + message);
		System.out.println("Uso: -xmltoxbrl -i FicheroEntrada [-o FicheroResultante] [-e FicheroErrores] [-v FicheroValidacion] [-l] [-x]");
		System.out.println("                             Transforma un fichero XML a XBRL");
		System.out.println("                             -i ruta del fichero de entrada XML");
		System.out.println("                             -o ruta del fichero de salida XBRL");
		System.out.println("                             -e Fichero de errores");
		System.out.println("                             -v Fichero de resultado de validación");
		System.out.println("                             -l Realiza la validación del fichero XBRL de salida");
		System.out.println();
		System.out.println("                             -h Muestra esta ayuda");
		System.out.println();
		System.out.println("                    	     -x Cierra el cuadro de comandos devolviendo el resultado de la operación");
		System.out.println();
		System.out.println("        		resultado : ");
		System.out.println("                    		  0 si la ejecución ha sido correcta");
		System.out.println("                    		 -1 si la ejecución ha sido incorrecta");
		System.out.println("                    		  1 si la ejecución ha sido correcta pero se han registrado warnings o errores leves");
		System.out.println("     				");
		System.out.println();
		System.exit(returnValue);
	}

	
	/**
	 * Método que presenta por salida estándar los errores al usuario cuando hay
	 * error en los parámetros.
	 * 
	 * @param message mensaje de error para el usuario.
	 */
	static private void useViewXbrl(int returnValue, String message) {

		System.out.println();
		System.out.println("API XBRL LENLOC-PENLOC");
		System.out.println();
		if (message != null && !"".equals(message))
			System.out.println("ERROR: " + message);
		System.out.println();
		System.out.println("Uso: -xbrltohtml -i FicheroEntrada -m MóduloVisualización [-o FicheroResultante] [-e FicheroErrores] [-x]");
		System.out.println("                             Transforma un fichero XBRL a HTML");
		System.out.println("                             -i ruta del fichero de entrada XBRL");
		System.out.println("                             -o ruta del fichero de salida HTML");
		System.out.println("                             -e Fichero de errores");
		System.out.println("                             -m Indica el módulo a visualizar en el fichero resultante");
		System.out.println();
		System.out.println("                             -h Muestra esta ayuda");
		System.out.println();
		System.out.println("                    	     -x Cierra el cuadro de comandos devolviendo el resultado de la operación");
		System.out.println();
		System.out.println("        		resultado : ");
		System.out.println("                    		  0 si la ejecución ha sido correcta");
		System.out.println("                    		 -1 si la ejecución ha sido incorrecta");
		System.out.println("                    		  1 si la ejecución ha sido correcta pero se han registrado warnings o errores leves");
		System.out.println("     				");
		System.out.println();
		System.exit(returnValue);
	}


	/**
	 * Método que presenta por salida estándar los errores al usuario cuando hay
	 * error en los parámetros.
	 * 
	 * @param message mensaje de error para el usuario.
	 */
	static private void useViewXml(int returnValue, String message) {

		System.out.println();
		System.out.println("API XBRL LENLOC-PENLOC");
		System.out.println();
		if (message != null && !"".equals(message))
			System.out.println("ERROR: " + message);
		System.out.println();
		System.out.println("Uso: -xmltohtml -i FicheroEntrada -m MóduloVisualización [-o FicheroResultante] [-e FicheroErrores] [-x]");
		System.out.println("                             Transforma un fichero XML a HTML");
		System.out.println("                             -i ruta del fichero de entrada XML");
		System.out.println("                             -o ruta del fichero de salida HTML");
		System.out.println("                             -e Fichero de errores");
		System.out.println("                             -m Indica el módulo a visualizar en el fichero resultante");
		System.out.println();
		System.out.println("                             -h Muestra esta ayuda");
		System.out.println();
		System.out.println("                    	     -x Cierra el cuadro de comandos devolviendo el resultado de la operación");
		System.out.println();
		System.out.println("        		resultado : ");
		System.out.println("                    		  0 si la ejecución ha sido correcta");
		System.out.println("                    		 -1 si la ejecución ha sido incorrecta");
		System.out.println("                    		  1 si la ejecución ha sido correcta pero se han registrado warnings o errores leves");
		System.out.println("     				");
		System.out.println();
		System.exit(returnValue);
	}

	static private boolean validate(String [] args) {
		boolean res = false;
		int i = 1;
		while (i < args.length && !res) {
			res = args[i++].equalsIgnoreCase("-l");
		}
		return res;
	}
	
	static private void generateErrorPath(String inputFilePath, String errorFilePath) throws Throwable{
		LogFilesManager.createParamError(LogFilesManager.getFilePathAndNoExtensionName(inputFilePath) + "_errors.xml", "ERROR: Errors file path \"" + errorFilePath + "\" not found.");
		System.out.println();
		System.out.println("La ruta \"" + errorFilePath +"\" del fichero de errores no existe. Se ha creado fichero de errores en la ruta de entrada");
		System.exit(-1);

	}
	
	static private void generateValidatePath(String inputFilePath, String validationFilePath) throws Throwable {
		LogFilesManager.createParamError(LogFilesManager.getFilePathAndNoExtensionName(inputFilePath) + "_errors.xml", "ERROR: Validation file path \"" + validationFilePath +"\" not found.");
		System.out.println();
		System.out.println("La ruta \"" + validationFilePath + "\" del fichero de validación no existe. Se ha creado un fichero de errores en la ruta de entrada.");
		System.exit(-1);
	}
	
	static private void generateOutputPath(String inputFilePath, String outputFilePath) throws Throwable {
		LogFilesManager.createParamError(LogFilesManager.getFilePathAndNoExtensionName(inputFilePath) + "_errors.xml", "ERROR: Output file path \"" + outputFilePath +"\" not found.");
		System.out.println();
		System.out.println("La ruta \"" + outputFilePath + "\" del fichero de salida no existe. Se ha creado un fichero de errores en la ruta de entrada.");
		System.exit(-1);
	}
}