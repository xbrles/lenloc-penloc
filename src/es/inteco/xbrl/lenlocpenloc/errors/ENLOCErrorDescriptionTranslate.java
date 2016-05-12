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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut;
import es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorParameter;

/**
 * 
 * 
 * Clase que traduce la descripcion de los errores sustituyendo nombres XBRL por
 * codigos ENLOC.
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

public class ENLOCErrorDescriptionTranslate implements IErrorDescriptionTranslate {

	/*
	 * (non-Javadoc)
	 * 
	 * @seees.inteco.xbrl.lenlocpenloc.errors.IErrorDescriptionTranslate#
	 * getTranslatedDescription
	 * (es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut)
	 */
	
	public String getTranslatedDescription(ENLOCErrorOut errorOut, String translatedBaseDescription) {
		int parC = errorOut.getENLOCErrorParameterCount();
		if(parC > 0) {
			for(int j = 0; j < parC; j++) {
				ENLOCErrorParameter ep = errorOut.getENLOCErrorParameter(j);
				if(!(ep.getENLOCCode() == null || ep.getENLOCCode().equals(""))) {
					translatedBaseDescription = translatedBaseDescription.replace("{" + j + "}", ep.getENLOCCode());
				}
			}
		}
		return translatedBaseDescription;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seees.inteco.xbrl.lenlocpenloc.errors.IErrorDescriptionTranslate#
	 * getTranslatedDescription
	 * (es.inteco.xbrl.lenlocpenloc.errors.out.ENLOCErrorOut)
	 */
	public String getAdaptedDescription(ENLOCErrorOut errorOut) {

		String td = errorOut.getDefaultDescription();

		int parC = errorOut.getENLOCErrorParameterCount();
		if(parC > 0) {
			for(int j = 0; j < parC; j++) {
				ENLOCErrorParameter ep = errorOut.getENLOCErrorParameter(j);
				if(!(ep.getENLOCCode() == null || ep.getENLOCCode().equals(""))) {
					String originalParamValue = ep.getContent();

					// dejamos comillas simples
					if(originalParamValue.charAt(0) == '\'') {
						originalParamValue = originalParamValue.substring(1);
					}
					int lastChar = originalParamValue.length();
					if(originalParamValue.charAt(lastChar - 1) == '\'') {
						originalParamValue = originalParamValue.substring(0, lastChar - 1);
					}

					// dejamos llaves
					if(originalParamValue.charAt(0) == '{') {
						originalParamValue = originalParamValue.substring(1);
					}
					lastChar = originalParamValue.length();
					if(originalParamValue.charAt(lastChar - 1) == '}') {
						originalParamValue = originalParamValue.substring(0, lastChar - 1);
					}

					try {
						td = td.replaceAll(originalParamValue, ep.getENLOCCode());
					} catch(java.util.regex.PatternSyntaxException e1) {
						td = replaceByStep(td, originalParamValue, ep.getENLOCCode());
					} catch(Exception e) {
						td += " ENLOCCode(" + ep.getENLOCCode() + ")";
					}
				}
			}// for (int j = 0; j < parC; j++)

		}
		return td;

	}

	private String replaceByStep(String text, String look, String replacement) {

		String returnValue = text;

		int index1 = -1;
		try {

			String copyLook = notHttp(look);

			index1 = text.indexOf(copyLook);
			boolean result = false;
			if(index1 > -1) {
				result = true;
			}
			while(result) {
				result = false;

				String ini = text.substring(0, index1);
				String finalT = text.substring(index1 + copyLook.length());

				returnValue = ini + replacement + finalT;

				text = returnValue;
				index1 = text.indexOf(copyLook);
				if(index1 > -1) {
					result = true;
				}
			}

		} catch(Throwable e1) {
			returnValue = text += " ENLOCCode(" + replacement + ")";
		}

		return returnValue;
	}

	private String notHttp(String text) {
		String transError = null;
		StringBuffer sb = new StringBuffer();

		Pattern p = Pattern.compile("&http");
		Matcher m = p.matcher(text);

		boolean result = m.find();
		while(result) {
			transError = "http";
			m.appendReplacement(sb, transError);

			result = m.find();
		}
		m.appendTail(sb);

		transError = sb.toString();

		return transError;
	}
}