/**
 * 
 */
package cl.liberty.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import cl.liberty.model.Policy;

/**
 * @author jgarrido
 *
 */
public class PolicyMapper implements RowMapper<Policy> {

	private static final Logger logger = LoggerFactory.getLogger(PolicyMapper.class);

	@Override
	public Policy mapRow(ResultSet rs, int rowNum) throws SQLException {
		logger.debug("Policy: {}", rs.getInt("numero_poliza"));
		Policy policy = new Policy();
		policy.setPolicyBranch(rs.getInt("codigo_ramo"));
		policy.setPolicyBranchName(rs.getString("ramo"));
		policy.setPolicyNumber(rs.getInt("numero_poliza"));
		policy.setContractorCode(rs.getInt("codigo_persona_contratante"));
		policy.setContractorName(rs.getString("descripcion_contratante"));
		policy.setBrokerCode(rs.getInt("codigo_corredor"));
		policy.setBrokerName(rs.getString("descripcion_corredor"));
		policy.setValidityStartDate(rs.getString("vigencia_inicio"));
		policy.setValidityEndDate(rs.getString("vigencia_fin"));
		return policy;
	}

}
