/**
 * 
 */
package cl.liberty.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import cl.liberty.model.PolicyCoverage;

/**
 * @author jgarrido
 *
 */
public class PolicyCoverageMapper implements RowMapper<PolicyCoverage> {

	private static final Logger logger = LoggerFactory.getLogger(PolicyCoverageMapper.class);

	@Override
	public PolicyCoverage mapRow(ResultSet rs, int rowNum) throws SQLException {
		logger.debug("PolicyCoverage: {}", rs.getInt("codigo_cobertura"));
		PolicyCoverage policyCoverage = new PolicyCoverage();
		policyCoverage.setPolicyCoverageCode(rs.getInt("codigo_cobertura"));
		policyCoverage.setPolicyCoverageName(rs.getString("cobertura"));
		policyCoverage.setPolicyCoverageUsing(rs.getString("uso_destino"));
		return policyCoverage;
	}

}
