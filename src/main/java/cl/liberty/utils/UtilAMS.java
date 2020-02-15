/**
 * 
 */
package cl.liberty.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cl.liberty.constantes.Constantes;
import cl.liberty.constantes.Errores;
import cl.liberty.model.PolicyCoverage;
import cl.liberty.request.BodyReqAuth;
import cl.liberty.response.BodyRespAuth;

/**
 * @author joseg
 *
 */
public class UtilAMS {

	private static final Logger logger = LoggerFactory.getLogger(UtilAMS.class);

	/**
	 * 
	 */
	private UtilAMS() {
		super();
	}

	/**
	 * Metodo que formatea una fecha
	 * 
	 * @param String,
	 *            fecha a formatear
	 * @param String,
	 *            formato de fecha
	 * @return String retorna el formato de fecha a un String
	 * 
	 */
	public static String formatDate(Date fecha, int iOptFormat) {
		String sFormatedDate = "";
		String sFormat = null;
		try {
			SimpleDateFormat df = null;
			switch (iOptFormat) {
			case 0:
				sFormat = "dd/MM/yy HH:mm:ss,SSS";
				break;
			case 1:
				sFormat = "dd/MM/yy";
				break;
			case 2:
				sFormat = "dd/MM/yy HH:mm:ss,SSS";
				break;
			case 3:
				sFormat = Constantes.FORMAT_DATE;
				break;
			case 4:
				sFormat = "yyyyMMdd";
				break;
			case 5:
				sFormat = "yyyyMMdd";
				break;
			case 6:
				sFormat = "dd-MM-yyyy";
				break;
			default:
				sFormat = "dd-MM-yyyy";
				break;
			}
			df = new SimpleDateFormat(sFormat);
			sFormatedDate = df.format(fecha != null ? fecha : "");

			if (iOptFormat == 0 && sFormatedDate != null) {

				sFormatedDate = sFormatedDate + "000000";
			}
		} catch (Exception e) {
			sFormatedDate = "";
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return sFormatedDate;
	}

	/**
	 * Comnpara si la fecha de inicio es mayor a la de termino
	 * 
	 * @param String
	 *            Fecha Inicio
	 * @param String
	 *            Fecha Termino
	 * @return boolean logico con la respuesta de la ejecucion
	 */
	public static boolean compareIfDateIsOlder(String startDate, String endDate) {
		boolean result = false;
		try {
			// Obtenemos las fechas enviadas en el formato a comparar
			SimpleDateFormat formateador = new SimpleDateFormat(Constantes.FORMAT_DATE);
			Date startDateInit = formateador.parse(startDate);
			Date startDateEnd = formateador.parse(endDate);

			if (startDateInit.before(startDateEnd)) {
				logger.info("La Fecha 1 es menor ");
				result = false;
			} else {
				if (startDateEnd.before(startDateInit)) {
					logger.info("La Fecha 1 es Mayor ");
					result = true;
				} else {
					logger.info("Las Fechas Son iguales ");
					result = false;
				}
			}
		} catch (Exception e) {
			result = false;
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

	public static boolean isDiffOneDay(String startDate, String endDate) {
		boolean result = false;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date initialDate = dateFormat.parse(startDate);
			Date finalDate = dateFormat.parse(endDate);
			int dayDifference = (int) ((finalDate.getTime() - initialDate.getTime()) / 86400000);
			if (Constantes.NUMBER_ONE_LESS.equals(String.valueOf(dayDifference))) {
				result = false;
			} else if (Constantes.NUMBER_ZERO.equals(String.valueOf(dayDifference))) {
				result = false;
			} else if (Constantes.NUMBER_ONE.equals(String.valueOf(dayDifference))) {
				result = false;
			} else {
				result = true;
			}
		} catch (Exception e) {
			result = false;
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

	public static String usingDescription(int usingCode) {
		String result = null;
		if (usingCode == 1801) {
			result = Constantes.USING_DESCRIPTION_COMMERCIAL;
		} else if (usingCode == 1807) {
			result = Constantes.USING_DESCRIPTION_COMMERCIAL;
		} else if (usingCode == 1982) {
			result = Constantes.USING_DESCRIPTION_HOUSING;
		} else if (usingCode == 1983) {
			result = Constantes.USING_DESCRIPTION_HOUSING;
		} else {
			result = "";
		}
		return result;
	}

	public static int gettPolicyUsingId(List<PolicyCoverage> policyCoverages) {
		int contador = 0;
		int commercialCount = 0;
		int housingCount = 0;
		for (int j = 0; j < policyCoverages.size(); j++) {
			contador++;
			if ("Habitacional".equalsIgnoreCase(policyCoverages.get(j).getPolicyCoverageUsing())) {
				housingCount++;
			} else if ("Comercial".equalsIgnoreCase(policyCoverages.get(j).getPolicyCoverageUsing())) {
				commercialCount++;
			}
		}
		if (contador == 0) {
			return 0;
		} else {
			if (housingCount > 0 && commercialCount == 0) {
				return 1;
			} else if (commercialCount > 0 && housingCount == 0) {
				return 2;
			} else {
				return 0;
			}
		}
	}

	/**
	 * Metodo que invoca al servicio y devuelve la response
	 * 
	 * @param BodyRespAuth request del servicio
	 * @return BodyRespAuth objeto de respuesta del servicio
	 */
	public static BodyRespAuth invokeResponseServiceAuth(String urlService, BodyReqAuth bodyReq) {
		ObjectMapper mapperRequest = new ObjectMapper();
		StringWriter stringRequest = new StringWriter();
		ObjectMapper mapperResponse = new ObjectMapper();
		BodyRespAuth eResponse = null;

		try {
			mapperRequest.writeValue(stringRequest, bodyReq);
			String jsonResponseService = getResponseServiceAuth(urlService, UtilAMS.getJSONString(bodyReq));

			if (jsonResponseService != null) {
				eResponse = mapperResponse.readValue(jsonResponseService, BodyRespAuth.class);
			}
		} catch (JsonGenerationException e) {
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			eResponse = null;
		} catch (JsonMappingException e) {
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
			eResponse = null;
		} catch (IOException e) {
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return eResponse;
	}

	/**
	 * Metodo que convierte los objetos BodyResp en un String basado en formato
	 * json
	 * 
	 * @param BodyReqAuth
	 *            con toda la informacion del objeto que sera convertido en json
	 * @return String que representa la informacion de un objeto pero en formato
	 *         json
	 */
	public static String getJSONString(BodyReqAuth bodyReqAuth) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(bodyReqAuth);
		} catch (JsonMappingException e) {
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
			return null;
		} catch (IOException e) {
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);

		}
		return "{\"error\": \"Exception\"}";
	}

	/**
	 * metodo que la respuesta del servicio en un String basado en JSON
	 * 
	 * @param request  con toda la informacion del objeto a convertir en JSON
	 * @return String cadena bajo la representacion de JSON
	 */
	public static String getResponseServiceAuth(String urlService, String jsonRequest) {

		StringBuilder sb = new StringBuilder();

		String http = urlService;

		HttpURLConnection urlConnection = null;
		try {
			URL url = new URL(http);
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setDoOutput(true);
			urlConnection.setRequestMethod(Constantes.METHOD_POST);
			urlConnection.setUseCaches(false);
			urlConnection.setConnectTimeout(50000);
			urlConnection.setReadTimeout(50000);
			urlConnection.setRequestProperty(Constantes.CONTENT_TYPE, Constantes.APPLICATION_JSON_ENCODE);
			urlConnection.connect();
			// You Can also Create JSONObject here
			OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
			out.write(jsonRequest);// here i sent the parameter
			out.close();
			int httpResult = urlConnection.getResponseCode();
			if (httpResult == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line + "\n");
				}
				br.close();
				return sb.toString();
			} else {
				logger.debug("Response: {}", urlConnection.getResponseMessage());
				return null;
			}

		} catch (MalformedURLException e) {
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
			closeConection(urlConnection);
		} catch (Exception e) {
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
			return null;
		}
		closeConection(urlConnection);
		return null;
	}

	/**
	 * Cerrar conexiones
	 * 
	 * @param rs
	 * @param em
	 * @param emf
	 */
	public static void closeConection(HttpURLConnection urlConnection) {
		try {
			if (urlConnection != null) {
				urlConnection.disconnect();
			}
		} catch (Exception e) {
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
	}
}
