/**
 * 
 */
package cl.liberty.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import cl.liberty.model.Wallet;

/**
 * @author jgarrido
 *
 */
public class WalletMapper implements RowMapper<Wallet> {

	private static final Logger logger = LoggerFactory.getLogger(WalletMapper.class);

	@Override
	public Wallet mapRow(ResultSet rs, int rowNum) throws SQLException {
		logger.debug("Wallet: {}", rs.getInt("ID_CARTERA"));
		Wallet wallet = new Wallet();
		wallet.setWalletId(rs.getInt("ID_CARTERA"));
		wallet.setWalletName(rs.getString("NOMBRE_CARTERA"));
		wallet.setPolicyNumber(rs.getInt("NUMERO_POLIZA"));
		wallet.setValidityStartDate(rs.getString("FECHA_VIGENCIA_INICIO"));
		wallet.setValidityEndDate(rs.getString("FECHA_VIGENCIA_FIN"));
		wallet.setContractorCode(rs.getInt("CODIGO_CONTRATANTE"));
		wallet.setContractorDescription(rs.getString("DESCRIPCION_CONTRATANTE"));
		wallet.setFlowId(rs.getInt("ID_FLUJO"));
		wallet.setFlowDescription(rs.getString("DESCRIPCION_FLUJO"));
		wallet.setUsingId(rs.getInt("ID_USO"));
		wallet.setUsingDescription(rs.getString("DESCRIPCION_USO"));
		wallet.setBrokerCode(rs.getInt("CODIGO_CORREDOR"));
		wallet.setBrokerDescription(rs.getString("DESCRIPCION_CORREDOR"));
		wallet.setStatus(rs.getInt("ESTADO"));
		return wallet;
	}

}
