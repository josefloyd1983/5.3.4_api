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
import cl.liberty.dao.PolicyDao;
import cl.liberty.model.Policy;
import cl.liberty.model.PolicyCoverage;

/**
 * @author jgarrido
 *
 */

@Repository
public class PolicyDaoImpl implements PolicyDao {

	@Autowired
	Environment env;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("rawtypes")
	@Override
	public Policy getPolicy(int policyNumber, int branchNumber) {
		SqlParameterSource paramaters = new MapSqlParameterSource()
				.addValue(Constantes.PARAMETER_POLICY_NUMBER, policyNumber)
				.addValue(Constantes.PARAMETER_POLICY_BRANCH_NUMBER, branchNumber);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_policy");
		Map out = simpleJdbcCall.execute(paramaters);
		Policy policy = new Policy();
		policy.setPolicyBranch(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_POLICY_BRANCH_NUMBER))));
		policy.setPolicyBranchName(String.valueOf(out.get(Constantes.PARAMETER_POLICY_BRANCH_NAME)));
		policy.setPolicyNumber(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_POLICY_NUMBER))));
		policy.setContractorCode(
				Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_POLICY_CONTRACTOR_CODE))));
		policy.setContractorName(String.valueOf(out.get(Constantes.PARAMETER_POLICY_CONTRACTOR_NAME)));
		policy.setBrokerCode(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_POLICY_BROKER_CODE))));
		policy.setBrokerName(String.valueOf(out.get(Constantes.PARAMETER_POLICY_BROKER_NAME)));
		policy.setValidityStartDate(String.valueOf(out.get(Constantes.PARAMETER_POLICY_EFFECTIVE_DATE_START)));
		policy.setValidityEndDate(String.valueOf(out.get(Constantes.PARAMETER_POLICY_EFFECTIVE_DATE_END)));

		return policy;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Policy> getPolicys(int policyNumber, int branchNumber) {
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue(Constantes.PARAMETER_POLICY_NUMBER, policyNumber)
				.addValue(Constantes.PARAMETER_POLICY_BRANCH_NUMBER, branchNumber);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_policys")
				.returningResultSet(env.getProperty(Constantes.P_CURSOR),
						BeanPropertyRowMapper.newInstance(Policy.class));
		Map<String, Object> out = simpleJdbcCall.execute(parameters);
		return ((List<Policy>) out.get(env.getProperty(Constantes.P_CURSOR)));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PolicyCoverage> getPolicyCoverages(int policyNumber, int branchNumber, int idPadre) {
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue(Constantes.PARAMETER_POLICY_NUMBER, policyNumber)
				.addValue(Constantes.PARAMETER_POLICY_BRANCH_NUMBER, branchNumber)
				.addValue(Constantes.PARAMETER_POLICY_FATHER_ID, idPadre);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_policy_coverages")
				.returningResultSet(env.getProperty(Constantes.P_CURSOR),
						BeanPropertyRowMapper.newInstance(PolicyCoverage.class));
		Map<String, Object> out = simpleJdbcCall.execute(parameters);
		return ((List<PolicyCoverage>) out.get(env.getProperty(Constantes.P_CURSOR)));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Policy> getPolicyNonMortgages(int policyNumber) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(Constantes.PARAMETER_POLICY_NUMBER,
				policyNumber);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE))
				.withProcedureName("p_policy_non_mortgages").returningResultSet(env.getProperty(Constantes.P_CURSOR),
						BeanPropertyRowMapper.newInstance(Policy.class));
		Map<String, Object> out = simpleJdbcCall.execute(parameters);
		return ((List<Policy>) out.get(env.getProperty(Constantes.P_CURSOR)));
	}

}
