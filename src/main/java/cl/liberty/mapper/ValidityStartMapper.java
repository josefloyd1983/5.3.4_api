/**
 * 
 */
package cl.liberty.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import cl.liberty.model.ValidityStart;

/**
 * @author jgarrido
 *
 */
public class ValidityStartMapper implements RowMapper<ValidityStart> {

	private static final Logger logger = LoggerFactory.getLogger(ValidityStartMapper.class);

	@Override
	public ValidityStart mapRow(ResultSet rs, int rowNum) throws SQLException {
		logger.debug("ValidityStart: {}", rs.getString("FECHA_VIGENCIA"));
		ValidityStart validityStart = new ValidityStart();
		validityStart.setValidityStartDate(rs.getString("FECHA_VIGENCIA"));
		return validityStart;
	}

}
