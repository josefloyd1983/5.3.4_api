/**
 * 
 */
package cl.liberty.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import cl.liberty.model.Using;

/**
 * @author jgarrido
 *
 */
public class UsingMapper implements RowMapper<Using> {

	private static final Logger logger = LoggerFactory.getLogger(UsingMapper.class);

	@Override
	public Using mapRow(ResultSet rs, int rowNum) throws SQLException {
		logger.debug("Using: {}", rs.getInt("ID_USO"));
		Using using = new Using();
		using.setUsingId(rs.getInt("ID_USO"));
		using.setUsingDescription(rs.getString("DESCRIPCION"));
		return using;
	}

}
