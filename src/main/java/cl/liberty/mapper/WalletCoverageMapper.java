/**
 * 
 */
package cl.liberty.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import cl.liberty.model.WalletCoverage;

/**
 * @author jgarrido
 *
 */
public class WalletCoverageMapper implements RowMapper<WalletCoverage> {

	private static final Logger logger = LoggerFactory.getLogger(WalletCoverageMapper.class);

	@Override
	public WalletCoverage mapRow(ResultSet rs, int rowNum) throws SQLException {
		logger.debug("PolicyCoverage: {}", rs.getInt("codigo_cobertura"));
		WalletCoverage walletCoverage = new WalletCoverage();
		walletCoverage.setWalletCoverageCode(rs.getInt("codigo_cobertura"));
		walletCoverage.setWalletCoverageName(rs.getString("cobertura"));
		walletCoverage.setWalletCoverageUsing(rs.getString("uso_destino"));
		return walletCoverage;
	}

}
