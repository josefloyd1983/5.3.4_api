/**
 * 
 */
package cl.liberty.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import cl.liberty.constantes.Constantes;
import cl.liberty.dao.WalletDao;
import cl.liberty.model.ValidityStart;
import cl.liberty.model.Wallet;
import cl.liberty.model.WalletCoverage;
import cl.liberty.model.WalletHistory;
import cl.liberty.request.WalletRequest;

/**
 * @author jgarrido
 *
 */

@Repository
public class WalletDaoImpl implements WalletDao {

	@Autowired
	Environment env;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("rawtypes")
	@Override
	public Wallet getWallet(Integer policyNumber, Integer contractorCode, Integer brokerCode, String validInYears) {
		SqlParameterSource paramaters = new MapSqlParameterSource()
				.addValue(Constantes.PARAMETER_WALLET_POLICY_NUMBER, policyNumber)
				.addValue(Constantes.PARAMETER_WALLET_CONTRACTOR_CODE, contractorCode)
				.addValue(Constantes.PARAMETER_WALLET_BROKER_CODE, brokerCode)
				.addValue(Constantes.PARAMETER_WALLET_VALID_IN_YEAR, validInYears);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_wallet");
		Map out = simpleJdbcCall.execute(paramaters);
		Wallet wallet = new Wallet();
		wallet.setWalletId(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_WALLET_ID))));
		wallet.setWalletName(String.valueOf(out.get(Constantes.PARAMETER_WALLET_NAME)));
		wallet.setPolicyNumber(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_WALLET_POLICY_NUMBER))));
		wallet.setValidityStartDate(String.valueOf(out.get(Constantes.PARAMETER_WALLET_EFFECTIVE_DATE_START)));
		wallet.setValidityEndDate(String.valueOf(out.get(Constantes.PARAMETER_WALLET_EFFECTIVE_DATE_END)));
		wallet.setContractorCode(
				Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_WALLET_CONTRACTOR_CODE))));
		wallet.setContractorDescription(String.valueOf(out.get(Constantes.PARAMETER_WALLET_CONTRACTOR_DESCRIPTION)));
		wallet.setFlowId(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_WALLET_FLOW_ID))));
		wallet.setFlowDescription(String.valueOf(out.get(Constantes.PARAMETER_WALLET_FLOW_DESCRIPTION)));
		wallet.setUsingId(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_WALLET_USING_ID))));
		wallet.setUsingDescription(String.valueOf(out.get(Constantes.PARAMETER_WALLET_USING_DESCRIPTION)));
		wallet.setBrokerCode(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_WALLET_BROKER_CODE))));
		wallet.setBrokerDescription(String.valueOf(out.get(Constantes.PARAMETER_WALLET_BROKER_DESCRIPTION)));
		wallet.setStatus(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_WALLET_STATUS))));
		return wallet;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Wallet> getWallets(Integer policyNumber, Integer contractorCode, Integer brokerCode,
			String validInYears, Integer idPadre) {
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue(Constantes.PARAMETER_WALLET_POLICY_NUMBER, policyNumber)
				.addValue(Constantes.PARAMETER_WALLET_CONTRACTOR_CODE, contractorCode)
				.addValue(Constantes.PARAMETER_WALLET_BROKER_CODE, brokerCode)
				.addValue(Constantes.PARAMETER_WALLET_VALID_IN_YEAR, validInYears)
				.addValue(Constantes.PARAMETER_WALLET_FATHER_ID, idPadre);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_wallets")
				.returningResultSet(env.getProperty(Constantes.P_CURSOR),
						BeanPropertyRowMapper.newInstance(Wallet.class));
		Map<String, Object> out = simpleJdbcCall.execute(parameters);
		return ((List<Wallet>) out.get(env.getProperty(Constantes.P_CURSOR)));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WalletCoverage> getWalletCoverages(Integer policyNumber, Integer branchNumber, Integer idPadre) {
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue(Constantes.PARAMETER_WALLET_POLICY_NUMBER, policyNumber)
				.addValue(Constantes.PARAMETER_WALLET_BRANCH_NUMBER, branchNumber)
				.addValue(Constantes.PARAMETER_WALLET_FATHER_ID, idPadre);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_wallet_coverages")
				.returningResultSet(env.getProperty(Constantes.P_CURSOR),
						BeanPropertyRowMapper.newInstance(WalletCoverage.class));
		Map<String, Object> out = simpleJdbcCall.execute(parameters);
		return ((List<WalletCoverage>) out.get(env.getProperty(Constantes.P_CURSOR)));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WalletHistory> getWalletHistorys(Integer policyNumber, Integer idUser) {
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue(Constantes.PARAMETER_WALLET_POLICY_NUMBER, policyNumber)
				.addValue(Constantes.PARAMETER_WALLET_USER_ID, idUser);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_wallet_historys")
				.returningResultSet(env.getProperty(Constantes.P_CURSOR),
						BeanPropertyRowMapper.newInstance(WalletHistory.class));
		Map<String, Object> out = simpleJdbcCall.execute(parameters);
		return ((List<WalletHistory>) out.get(env.getProperty(Constantes.P_CURSOR)));
	}

	@Override
	public void addWallet(WalletRequest walletRequest) {
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue(Constantes.PARAMETER_WALLET_NAME, walletRequest.getWalletName())
				.addValue(Constantes.PARAMETER_WALLET_POLICY_NUMBER, walletRequest.getPolicyNumber())
				.addValue(Constantes.PARAMETER_WALLET_EFFECTIVE_DATE_START, walletRequest.getValidityStartDate())
				.addValue(Constantes.PARAMETER_WALLET_EFFECTIVE_DATE_END, walletRequest.getValidityEndDate())
				.addValue(Constantes.PARAMETER_WALLET_CONTRACTOR_CODE, walletRequest.getContractorCode())
				.addValue(Constantes.PARAMETER_WALLET_FLOW_ID, walletRequest.getFlowId())
				.addValue(Constantes.PARAMETER_WALLET_USING_ID, walletRequest.getUsingId())
				.addValue(Constantes.PARAMETER_WALLET_BROKER_CODE, walletRequest.getBrokerCode())
				.addValue(Constantes.PARAMETER_WALLET_STATUS, walletRequest.getStatus());

		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_add_wallet");
		simpleJdbcCall.execute(parameters);
	}

	@Override
	public void editWallet(WalletRequest walletRequest) {
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue(Constantes.PARAMETER_WALLET_ID, walletRequest.getWalletId())
				.addValue(Constantes.PARAMETER_WALLET_NAME, walletRequest.getWalletName())
				.addValue(Constantes.PARAMETER_WALLET_POLICY_NUMBER, walletRequest.getPolicyNumber())
				.addValue(Constantes.PARAMETER_WALLET_EFFECTIVE_DATE_START, walletRequest.getValidityStartDate())
				.addValue(Constantes.PARAMETER_WALLET_EFFECTIVE_DATE_END, walletRequest.getValidityEndDate())
				.addValue(Constantes.PARAMETER_WALLET_CONTRACTOR_CODE, walletRequest.getContractorCode())
				.addValue(Constantes.PARAMETER_WALLET_FLOW_ID, walletRequest.getFlowId())
				.addValue(Constantes.PARAMETER_WALLET_USING_ID, walletRequest.getUsingId())
				.addValue(Constantes.PARAMETER_WALLET_BROKER_CODE, walletRequest.getBrokerCode())
				.addValue(Constantes.PARAMETER_WALLET_STATUS, walletRequest.getStatus());

		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_edit_wallet");
		simpleJdbcCall.execute(parameters);

	}

	@Override
	public void deleteWallet(Integer walletId) {
		SqlParameterSource paramaters = new MapSqlParameterSource().addValue(Constantes.PARAMETER_WALLET_ID, walletId);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_delete_wallet");
		simpleJdbcCall.execute(paramaters);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean validateWalletExist(Integer walletId) {
		SqlParameterSource paramaters = new MapSqlParameterSource().addValue(Constantes.PARAMETER_WALLET_ID, walletId);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_wallet_exist");
		Map out = simpleJdbcCall.execute(paramaters);
		return Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_COUNT))) != 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ValidityStart> getValidityStarts() {
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_validity_starts")
				.returningResultSet(env.getProperty(Constantes.P_CURSOR),
						BeanPropertyRowMapper.newInstance(ValidityStart.class));
		Map<String, Object> out = simpleJdbcCall.execute();
		return ((List<ValidityStart>) out.get(env.getProperty(Constantes.P_CURSOR)));
	}

}
