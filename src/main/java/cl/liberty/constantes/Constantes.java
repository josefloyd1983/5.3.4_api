/**
 * 
 */
package cl.liberty.constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * @author jgarrido
 *
 */
public class Constantes {

	@Autowired
	Environment env;

	/**
	 * 
	 */
	private Constantes() {
		super();
	}

	/** Constantes de la aplicacion */
	public static final int SUCCESS = 0;
	public static final int ERROR = 1;
	public static final int WARNING = 2;
	public static final int PROPERTY_ID_PADRE = 1;
	public static final String PROPERTY_NAME_COVERAGE = "COBERTURA";
	public static final String FORMAT_DATE = "yyyy-MM-dd HH:mm:ss";
	public static final String USING_DESCRIPTION_HOUSING = "Habitacional";
	public static final String USING_DESCRIPTION_COMMERCIAL = "Comercial";

	/** Constantes para nombre de mapeos */
	public static final String MAP_PARAMETER_USER_ID = "idUser";
	public static final String MAP_PARAMETER_PROPERTY_ID_PADRE = "idPadre";
	public static final String MAP_PARAMETER_BROKER_CODE = "brokerCode";
	public static final String MAP_PARAMETER_VALIDATE_IN_YEAR = "validInYears";
	public static final String MAP_PARAMETER_SYSTEM_DATE = "systemDate";
	public static final String MAP_PARAMETER_BROKER_DESCRIPTION = "brokerDescription";
	public static final String MAP_PARAMETER_BROKER_ID = "brokerId";
	public static final String MAP_PARAMETER_CONTRACTOR_CODE = "contractorCode";
	public static final String MAP_PARAMETER_CONTRACTOR_DESCRIPTION = "contractorDescription";
	public static final String MAP_PARAMETER_CONTRACTOR_ID = "coverageId";
	public static final String MAP_PARAMETER_FLOW_CODE = "flowCode";
	public static final String MAP_PARAMETER_FLOW_DESCRIPTION = "flowDescription";
	public static final String MAP_PARAMETER_FLOW_ID = "flowId";
	public static final String MAP_PARAMETER_USING_CODE = "usingCode";
	public static final String MAP_PARAMETER_USING_DESCRIPTION = "usingDescription";
	public static final String MAP_PARAMETER_USING_ID = "usingId";
	public static final String MAP_PARAMETER_POLICY_NUMBER = "policyNumber";
	public static final String MAP_PARAMETER_POLICY_NUMBER_BRANCH = "branchNumber";
	public static final String MAP_PARAMETER_WALLET_ID = "walletId";
	public static final String MAP_PARAMETER_WALLET_NAME = "walletName";
	public static final String MAP_PARAMETER_WALLET_START_DATE = "validityStartDate";
	public static final String MAP_PARAMETER_WALLET_END_DATE = "validityEndDate";
	public static final String MAP_PARAMETER_WALLET_STATUS = "status";
	public static final String MAP_PARAMETER_WALLET_BRANCH = "branchNumber";
	public static final String	MAP_PARAMETER_USERID					= "userId";
	public static final String	MAP_PARAMETER_USER_STATUS					= "status";
	public static final String	MAP_PARAMETER_USER_PROFILEID					= "profileId";
	public static final String	MAP_PARAMETER_USER_COUNTRYID					= "countryId";
	public static final String	MAP_PARAMETER_USER_NAME					= "name";
	public static final String	MAP_PARAMETER_USER_USERNAME					= "userName";
	public static final String	MAP_PARAMETER_USER_LASTNAME					= "lastName";
	public static final String	MAP_PARAMETER_USER_EMAIL					= "email";
	public static final String	MAP_PARAMETER_USER_NAME_SURNAME					= "nameSurname";
	public static final String	MAP_PARAMETER_USER_PASS_WORD					= "passWord";
	public static final String	MAP_PARAMETER_USER_CREATIONDATE					= "creacionDate";
	
	/** Tags y atributos de peticion/respuesta XML/JSON */
	public static final String	BODY								= "BODY";
	public static final String	CONTENT_TYPE						= "Content-Type";
	public static final String	CONTENT_LENGTH						= "Content-Length";
	public static final String	APPLICATION_JSON_ENCODE				= "application/json; charset=UTF-8";
	public static final String	TEXT_HTML								= "text/html";	
	public static final String	ACCEPT				= "Accept";
	public static final String	TLS				= "TLS";
	public static final String METHOD_POST							= "POST";
	public static final String METHOD_GET							= "GET";
	public static final String SERVICE_AUTH_URL							= "service.endpoint";

	/** base de Datos */
	public static final String ESCHEMA_DB = "schema.db";
	public static final String ESCHEMA_PACKAGE = "schema.package";
	public static final String P_CURSOR = "sp.cursor";
	public static final String PASS_WORD = "PASSWORD";
	
	/** Constantes parametros procedure */
	public static final String	PARAMETER_BROKER_CODE					= "p_broker_code";
	public static final String	PARAMETER_BROKER_DESCRIPTION					= "p_broker_description";
	public static final String	PARAMETER_COUNT					= "p_count";
	public static final String	PARAMETER_CONTRACTOR_CODE					= "p_contractor_code";
	public static final String	PARAMETER_CONTRACTOR_DESCRIPTION					= "p_contractor_description";
	public static final String	PARAMETER_FLOW_ID					= "p_flow_id";
	public static final String	PARAMETER_FLOW_DESCRIPTION					= "p_flow_description";
	public static final String	PARAMETER_USING_ID					= "p_using_id";
	public static final String	PARAMETER_USING_DESCRIPTION					= "p_using_description";
	
	
	public static final String	PARAMETER_LOG_EVENT_ID					= "p_event_id";
	public static final String	PARAMETER_LOG_USER_ID					= "p_user_id";
	public static final String	PARAMETER_LOG_WALLET_ID					= "p_wallet_id";
	public static final String	PARAMETER_LOG_VALUE_NEW					= "p_value_new";
	public static final String	PARAMETER_LOG_VALUE_OLD					= "p_value_old";
	public static final String	PARAMETER_LOG_MODIFICATION_DATE			= "p_modification_date";

	public static final String	PARAMETER_PROPERYS_FAHTER_ID			= "p_father_id";
	
	public static final String	PARAMETER_PROPERYS_ID			= "p_property_id";
	public static final String	PARAMETER_PROPERYS_COUNTRY_ID			= "p_country_id";
	public static final String	PARAMETER_PROPERYS_TYPE			= "p_property_type";
	public static final String	PARAMETER_PROPERYS_NAME			= "p_name";
	public static final String	PARAMETER_PROPERYS_DESCRIPTION			= "p_description";
	public static final String	PARAMETER_PROPERYS_VALUE			= "p_value";
	public static final String	PARAMETER_PROPERYS_STATUS			= "p_status";

	public static final String	PARAMETER_PROFILE_ID			= "p_profile_id";
	public static final String	PARAMETER_PROFILE_FATHER_ID			= "p_father_id";

	public static final String	PARAMETER_USER_ID			= "p_user_id";
	public static final String	PARAMETER_USER_USERNAME			= "p_username";
	public static final String	PARAMETER_USER_CREATION_DATE		= "p_creation_date";
	public static final String	PARAMETER_USER_EMAIL		= "p_email";
	public static final String	PARAMETER_LASTNAME		= "p_last_name";
	public static final String	PARAMETER_USER_NAME			= "p_name";
	public static final String	PARAMETER_USER_STATUS			= "p_status";
	public static final String	PARAMETER_USER_CONTRASENA			= "p_password";
	public static final String	PARAMETER_USER_COUNTRY_ID			= "p_country_id";
	public static final String	PARAMETER_USER_COUNTRY_NAME			= "p_country_name";
	public static final String	PARAMETER_USER_COUNTRY_CODE			= "p_country_code";
	public static final String	PARAMETER_USER_PROFILE_ID			= "p_profile_id";
	public static final String	PARAMETER_USER_PROFILE_NAME			= "p_profile_name";
	public static final String	PARAMETER_USER_PROFILE_CREATION_DATE		= "p_profile_creation_date";
	public static final String	PARAMETER_USER_FLAG_ROUTE		= "p_flag_route";
	public static final String	PARAMETER_USER_NAME_SURNAME			= "p_name_surname";
	
	public static final String	PARAMETER_WALLET_POLICY_NUMBER			= "p_policy_number";
	public static final String	PARAMETER_WALLET_CONTRACTOR_CODE			= "p_contractor_code";
	public static final String	PARAMETER_WALLET_BROKER_CODE			= "p_broker_code";
	public static final String	PARAMETER_WALLET_VALID_IN_YEAR			= "p_valid_in_years";
	public static final String	PARAMETER_WALLET_FATHER_ID			= "p_father_id";
	public static final String	PARAMETER_WALLET_ID			= "p_wallet_id";
	public static final String	PARAMETER_WALLET_NAME			= "p_wallet_name";
	public static final String	PARAMETER_WALLET_EFFECTIVE_DATE_START			= "p_effective_date_start";
	public static final String	PARAMETER_WALLET_EFFECTIVE_DATE_END			= "p_effective_date_end";
	public static final String	PARAMETER_WALLET_CONTRACTOR_DESCRIPTION			= "p_contractor_description";
	public static final String	PARAMETER_WALLET_BROKER_DESCRIPTION			= "p_broker_description";
	public static final String	PARAMETER_WALLET_FLOW_ID			= "p_flow_id";
	public static final String	PARAMETER_WALLET_FLOW_DESCRIPTION			= "p_flow_description";
	public static final String	PARAMETER_WALLET_USING_ID			= "p_using_id";
	public static final String	PARAMETER_WALLET_USING_DESCRIPTION			= "p_using_description";
	public static final String	PARAMETER_WALLET_STATUS			= "p_status";
	public static final String	PARAMETER_WALLET_BRANCH_NUMBER			= "p_branch_number";
	public static final String	PARAMETER_WALLET_USER_ID			= "p_user_id";
	
	
	public static final String	PARAMETER_POLICY_NUMBER			= "p_policy_number";
	public static final String	PARAMETER_POLICY_CONTRACTOR_CODE			= "p_contractor_code";
	public static final String	PARAMETER_POLICY_BROKER_CODE			= "p_broker_code";
	public static final String	PARAMETER_POLICY_VALID_IN_YEAR			= "p_valid_in_years";
	public static final String	PARAMETER_POLICY_FATHER_ID			= "p_father_id";
	public static final String	PARAMETER_POLICY_ID			= "p_wallet_id";
	public static final String	PARAMETER_POLICY_NAME			= "p_wallet_name";
	public static final String	PARAMETER_POLICY_EFFECTIVE_DATE_START			= "p_effective_date_start";
	public static final String	PARAMETER_POLICY_EFFECTIVE_DATE_END			= "p_effective_date_end";
	public static final String	PARAMETER_POLICY_CONTRACTOR_NAME			= "p_contractor_name";
	public static final String	PARAMETER_POLICY_BROKER_NAME			= "p_broker_name";
	public static final String	PARAMETER_POLICY_FLOW_ID			= "p_flow_id";
	public static final String	PARAMETER_POLICY_FLOW_DESCRIPTION			= "p_flow_description";
	public static final String	PARAMETER_POLICY_USING_ID			= "p_using_id";
	public static final String	PARAMETER_POLICY_USING_DESCRIPTION			= "p_using_description";
	public static final String	PARAMETER_POLICY_STATUS			= "p_status";
	public static final String	PARAMETER_POLICY_BRANCH_NUMBER			= "p_branch_number";
	public static final String	PARAMETER_POLICY_BRANCH_NAME			= "p_branch_name";
	public static final String	PARAMETER_POLICY_USER_ID			= "p_user_id";

	/** Caracteres **/
	public static final String EMPTY = "";
	public static final String NUMBER_ONE_LESS = "-1";
	public static final String NUMBER_ZERO = "0";
	public static final String NUMBER_ONE = "1";

	/** Url CrossOrigin */
	public static final String CROSS_ORIGIN_LOCAL = "http://localhost:4200";
	public static final String CROSS_ORIGIN_DEV = "https://localhost";
	public static final String CROSS_ORIGIN_CERT = "https://localhost";
	public static final String CROSS_ORIGIN_PROD = "https://localhost";

}
