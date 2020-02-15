/**
 * 
 */
package cl.liberty.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import cl.liberty.model.WalletHistory;

/**
 * @author jgarrido
 *
 */
public class WalletHistoryMapper implements RowMapper<WalletHistory> {

	private static final Logger logger = LoggerFactory.getLogger(WalletHistoryMapper.class);

	@Override
	public WalletHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
		logger.debug("WalletHistory: {}", rs.getInt("ID_LOG"));
		WalletHistory walletHistory = new WalletHistory();
		walletHistory.setLogId(rs.getInt("ID_LOG"));
		walletHistory.setNewValue(rs.getString("VALOR_NUEVO"));
		walletHistory.setOldValue(rs.getString("VALOR_ANTIGUO"));
		walletHistory.setModificationDate(rs.getString("FECHA_MODIFICACION"));
		walletHistory.setEventId(rs.getInt("ID_EVENTO"));
		walletHistory.setEventName(rs.getString("NOMBRE_EVENTO"));
		walletHistory.setBrokerCode(rs.getInt("CODIGO_CORREDOR"));
		walletHistory.setBrokerName(rs.getString("DESCRIPCION_CORREDOR"));
		walletHistory.setContractorCode(rs.getInt("CODIGO_CONTRATANTE"));
		walletHistory.setContractorDescription(rs.getString("DESCRIPCION_CONTRATANTE"));
		walletHistory.setUserId(rs.getInt("ID_USUARIO"));
		walletHistory.setUserName(rs.getString("NOMBRE_USUARIO"));
		walletHistory.setPolicyNumber(rs.getInt("NUMERO_POLIZA"));
		return walletHistory;
	}

}
