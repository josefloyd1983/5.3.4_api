/**
 * 
 */
package cl.liberty.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import cl.liberty.model.Flow;

/**
 * @author jgarrido
 *
 */
public class FlowMapper implements RowMapper<Flow> {

	private static final Logger logger = LoggerFactory.getLogger(FlowMapper.class);

	@Override
	public Flow mapRow(ResultSet rs, int rowNum) throws SQLException {
		logger.debug("Flow: {}", rs.getInt("ID_FLUJO"));
		Flow flow = new Flow();
		flow.setFlowId(rs.getInt("ID_FLUJO"));
		flow.setFlowDescription(rs.getString("DESCRIPCION"));
		return flow;
	}

}
