/**
 * 
 */
package cl.liberty.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import cl.liberty.model.Log;

/**
 * @author jgarrido
 *
 */
public class LogMapper implements RowMapper<Log> {

	private static final Logger logger = LoggerFactory.getLogger(LogMapper.class);

	@Override
	public Log mapRow(ResultSet rs, int rowNum) throws SQLException {
		logger.debug("Flow: {}", rs.getInt("ID_FLUJO"));
		Log log = new Log();
		log.setEventId(rs.getInt("ID_EVENTO"));
		log.setLogId(rs.getInt("ID_LOG"));
		log.setModificatioDate(rs.getString("FECHA_MODIFICACION"));
		log.setUserId(rs.getInt("ID_USUARIO"));
		log.setValueNew(rs.getString("VALOR_NUEVO"));
		log.setValueOld(rs.getString("VALOR_ANTIGUO"));
		return log;
	}

}
