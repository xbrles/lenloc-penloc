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

package es.inteco.xbrl.lenlocpenloc.errors;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import es.inteco.xbrl.lenlocpenloc.errors.catalog.ENLOCError;
import es.inteco.xbrl.lenlocpenloc.errors.exceptions.XSDValidatorException;
import es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorsOutput;
import es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut;
import es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter;
import es.inteco.xbrl.lenlocpenloc.errors.out.types.ENLOCErrorOutTypeType;
import es.inteco.xbrl.lenlocpenloc.utils.UtilConstants;

/**
 * 
 * 
 * Clase manejadora de errores. Mantiene una estructura de los errores que se
 * van reportando. <br /> <br /> Por tanto, contiene métodos para agregar
 * errores y mediante el método sobrescrito toString() devuelve la serialización
 * de la estructura XML conteniendo todos los errores que han sido reportados.
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

public class GenericErrorsHandler {

	private static final Logger logger = Logger.getLogger(GenericErrorsHandler.class);

	ENLOCErrorsOutput errors = null;

	/**
	 * Constructor
	 */
	public GenericErrorsHandler() {
		errors = new ENLOCErrorsOutput();
	}

	/**
	 * Devuelve una traduccion del parametro sustituyendo nombres de elementos
	 * xbrl por codigos ENLOC
	 * 
	 * @return parametro de error traducido
	 */
	protected IErrorParamTranslate getErrorParamTranslate() {
		return null;
	}

	/**
	 * Devuelve una descripcion de error donde se sustituye nombres XBRL por
	 * codigos ENLOC
	 * 
	 * @return descripcion de error
	 */
	protected IErrorDescriptionTranslate getErrorDescriptionTranslate() {
		return null;
	}

	/**
	 * Permite agregar un error a la estructura, a partir del identificador del
	 * error, la descripción por defecto del error y una lista de parámetros.
	 * 
	 * @param errorID identificador del error
	 * 
	 * @param defaultDescription descripció por defecto
	 * 
	 * @param parameters lista de parámetros para componer la descripción del
	 *        error
	 * 
	 * @throws Exception devuelve ante cualquier error que se produzca
	 * 
	 */
	public void addError(String errorID, String defaultDescription, ArrayList<String> parameters) throws Exception {
		ENLOCErrorOut newError = createErrorOutput(errorID, defaultDescription, parameters);
		errors.addENLOCErrorOut(newError);
	}

	/**
	 * Permite agregar un error a la estructura, a partir del identificador del
	 * error, la descripción por defecto del error y una lista de parámetros.
	 * 
	 * @param errorID identificador del error
	 * 
	 * @param defaultDescription descripció por defecto
	 * 
	 * @param parameters lista de parámetros para componer la descripción del
	 *        error
	 * 
	 * @throws Exception devuelve ante cualquier error que se produzca
	 * 
	 */
	public void addErrorBefore(String errorID, String defaultDescription, ArrayList<String> parameters)
	        throws Exception {
		ENLOCErrorOut newError = createErrorOutput(errorID, defaultDescription, parameters);
		errors.addENLOCErrorOutBefore(newError);
	}

	/* Devuelve la lista de ids incluidos en la lista de entrada */
	private ArrayList<String> getIdList(String parametersList) {
		ArrayList<String> idList = new ArrayList<String>();
		try {
			Pattern p = Pattern.compile("([0-9])");
			Matcher m = p.matcher(parametersList);

			while(m.find()) {
				String id = parametersList.substring(m.start(), m.end());
				idList.add(id);
			}
		} catch(Exception e) {
			logger.error(e);
		}
		return idList;

	}

	/* Crea un error de tipo ENLOCErrorOut */
	private ENLOCErrorOut createErrorOutput(String errorID, String defaultDescription, ArrayList<String> parameters)
	        throws Exception {
		ENLOCError errorDefinition = ErrorsCatalogManager.getInstance().getError(errorID);

		if(errorDefinition == null) {
			errorDefinition = ErrorsCatalogManager.getInstance().getError(UtilConstants.notCataloguedError);
		}

		ENLOCErrorOut errorOutput = new ENLOCErrorOut();

		if(errorDefinition.getType().value().equals(ENLOCErrorOutTypeType.XERCES.value()) && errorDefinition.getId().equalsIgnoreCase("cvc-elt.1")) {
			String messageFormat = ErrorMessages.getInstance().getMessage(XSDValidatorException.errorInputFileIncorrectFormat);
			errorOutput.setDefaultDescription(messageFormat);
		} else {
			errorOutput.setDefaultDescription(defaultDescription);			
		}

		errorOutput.setErrorCode(errorDefinition.getErrorCode());
		try {
			errorOutput.setErrorType(ErrorsCatalogManager.getInstance().getError(errorID).getType().value());
		} catch(Exception e) {/*
							 * si no podemos conseguir error type, continuamos
							 * el proceso sin lanazar una excepción
							 */
		}

		ArrayList<String> idList = getIdList(errorDefinition.getParameterList());

		Iterator<String> parametersIter = null; // parameters.iterator();
		if(!(parameters == null)) {
			parametersIter = parameters.iterator();
		}

		int i = 0;
		if(!(parameters == null)) {
			while(parametersIter.hasNext()) {

				ENLOCErrorParameter parameter = new ENLOCErrorParameter();
				String currentParam = parametersIter.next();
				if(getErrorParamTranslate() != null) {
					String enlocCode = getErrorParamTranslate().getENLOCCode(currentParam);
					parameter.setENLOCCode(enlocCode);
				}

				parameter.setContent(currentParam);
				if(idList.size() > i) {
					parameter.setId(Long.parseLong(idList.get(i)));
				}
				errorOutput.addENLOCErrorParameter(i, parameter);
				i++;
			}
		}
		String descriptionEnlocError = errorDefinition.getContent();

		// creamos translated description
		if(getErrorDescriptionTranslate() != null) {
			if((descriptionEnlocError == null || descriptionEnlocError.equals(""))) {
				errorOutput.setTranslatedDescription(getErrorDescriptionTranslate().getAdaptedDescription(errorOutput));
			} else {
				errorOutput.setTranslatedDescription(getErrorDescriptionTranslate().getTranslatedDescription(
				        errorOutput, descriptionEnlocError));
			}
		}

		return errorOutput;
	}

	/*
	 * Devuelve la estructura de errores reportados en un XML serializado como
	 * String.
	 * 
	 * @return lista de errores con formato XML
	 */
	
	public String toString() {
		return this.toString(errors);
	}

	/*
	 * Devuelve la estructura de errores reportados en un XML serializado como
	 * String.
	 * 
	 * @return lista de errores con formato XML
	 */
	private String toString(ENLOCErrorsOutput errorIn) {

		String resultToString = null;

		StringWriter writer = new StringWriter();

		try {
			errorIn.marshal(writer);

			resultToString = writer.toString();

			writer.close();

		} catch(Throwable e) {
			logger.error(e);
		}

		return resultToString;
	}

	/**
	 * 
	 * Devuelve la estructura de errores reportados en un XML serializado como
	 * String. Procesa los errores para generar un resultado en un formato más
	 * legible
	 * 
	 * @return lista de errores con formato XML
	 * 
	 */
	public String toStringPostProcess() {
		if(errors == null || errors.getENLOCErrorOutCount() < 1) {
			return this.toString();
		}

		ENLOCErrorsOutput errorsModified = postProcess();

		return this.toString(errorsModified);

	}

	private ENLOCErrorsOutput postProcess() {
		ENLOCErrorsOutput returnValue = null;
		try {

			int nextI = -1;
			int errorsCount = errors.getENLOCErrorOutCount();

			// validacion, si solo tienen un registro de error, no hacemos más
			if(errorsCount < 2) {
				return errors;
			}

			returnValue = new ENLOCErrorsOutput();

			for(int i = 0; i < errorsCount; i++) {
				nextI = i + 1;

				ENLOCErrorOut actualError = errors.getENLOCErrorOut(i);

				// leemos un 355 ó 301 ó 260, lo procesamos para ver si tiene
				// pareja 395
				if(actualError.getErrorCode() == 355 || actualError.getErrorCode() == 301
				        || actualError.getErrorCode() == 260) {
					ENLOCErrorOut nextError = null;
					try {
						nextError = errors.getENLOCErrorOut(nextI);
					} catch(IndexOutOfBoundsException e1) {
						nextI = -1;
					}

					if(nextI == -1 || nextError == null || nextError.getErrorCode() != 395) {
						// grabamos el error actual
						returnValue.addENLOCErrorOut(actualError);
					} else {
						// tenemos que hacer un merge de los errores
						ENLOCErrorOut mergeError = null;
						mergeError = doMerge(actualError, nextError);

						i++; // subimos el contador porque no tiene sentido que
						// vuelva a procesar la pareja del 355

						// agregamos el error recién creado
						if(!(mergeError == null)) {
							returnValue.addENLOCErrorOut(mergeError);
						}
					}

				} else {
					// grabamos el error actual
					returnValue.addENLOCErrorOut(actualError);
				}

			}

		} catch(Throwable e) {
			logger.error("Error in postProcess of validation result");
			// por un error aquí, no para la ejecución del programa
			return errors;
		}
		return returnValue;
	}

	private ENLOCErrorOut doMerge(ENLOCErrorOut errorA, ENLOCErrorOut errorB) {
		ENLOCErrorOut returnValue = null;
		try {
			// identificamos la pareja
			// if (errorA.getErrorCode() ==355 && errorB.getErrorCode() ==395 ){
			returnValue = new ENLOCErrorOut();

			String newErrorCodeStr = String.valueOf(errorA.getErrorCode())
			        .concat(String.valueOf(errorB.getErrorCode()));
			long newErrorCode = Long.parseLong(newErrorCodeStr);

			returnValue.setErrorCode(newErrorCode);
			returnValue.setErrorType(errorA.getErrorType());

			// parametros

			long paramsCount = 0;

			for(int i = 0; i < errorA.getENLOCErrorParameterCount(); i++) {
				ENLOCErrorParameter newParam = new ENLOCErrorParameter();
				newParam.setContent(errorA.getENLOCErrorParameter(i).getContent());
				newParam.setENLOCCode(errorA.getENLOCErrorParameter(i).getENLOCCode());
				newParam.setId(paramsCount);
				returnValue.addENLOCErrorParameter(newParam);
				paramsCount += 1;

			}
			for(int i = 0; i < errorB.getENLOCErrorParameterCount(); i++) {
				ENLOCErrorParameter newParam = new ENLOCErrorParameter();
				newParam.setContent(errorB.getENLOCErrorParameter(i).getContent());
				newParam.setENLOCCode(errorB.getENLOCErrorParameter(i).getENLOCCode());
				returnValue.addENLOCErrorParameter(newParam);
				newParam.setId(paramsCount);
				paramsCount += 1;
			}

			returnValue.setDefaultDescription(errorA.getDefaultDescription() + " " + errorB.getDefaultDescription());

			// debemos tener en cuenta que translatedDescription podría ser nula
			// si no se ejecuta la aplicación a través de la clase
			// ENLOCValidator
			String newTDesc = null;

			if(errorA.getTranslatedDescription() != null && (!(errorA.getTranslatedDescription().trim().equals("")))) {
				newTDesc = errorA.getTranslatedDescription();
			}

			if(errorB.getTranslatedDescription() != null && (!(errorB.getTranslatedDescription().trim().equals("")))) {
				if(newTDesc != null) {
					newTDesc += " " + errorB.getTranslatedDescription();
				} else {
					newTDesc = errorB.getTranslatedDescription();
				}
			}

			returnValue.setTranslatedDescription(newTDesc);

			// }

		} catch(Exception e1) {
			logger.error("Error in postProcess - doMerge of validation result");
			// no lanzo una excepción ni paro el programa
			returnValue = null;
		}
		return returnValue;
	}

}