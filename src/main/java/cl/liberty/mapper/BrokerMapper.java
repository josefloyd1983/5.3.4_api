/**
 * 
 */
package cl.liberty.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import cl.liberty.model.Broker;

/**
 * @author jgarrido
 *
 */
public class BrokerMapper implements RowMapper<Broker> {

	private static final Logger logger = LoggerFactory.getLogger(BrokerMapper.class);

	@Override
	public Broker mapRow(ResultSet rs, int rowNum) throws SQLException {
		logger.debug("Broker: {}", rs.getInt("CODIGO_CORREDOR"));
		Broker broker = new Broker();
		broker.setBrokerCode(rs.getInt("CODIGO_CORREDOR"));
		broker.setBrokerDescription(rs.getString("DESCRIPCION"));
		return broker;
	}

}
