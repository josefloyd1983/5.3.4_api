/**
 * 
 */
package cl.liberty.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import cl.liberty.model.Profile;

/**
 * @author jgarrido
 *
 */
public class ProfileMapper implements RowMapper<Profile> {

	private static final Logger logger = LoggerFactory.getLogger(ProfileMapper.class);

	@Override
	public Profile mapRow(ResultSet rs, int rowNum) throws SQLException {
		logger.debug("Perfil: {}", rs.getInt("ID_PERFIL"));
		Profile profile = new Profile();
		profile.setProfileId(rs.getInt("ID_PERFIL"));
		profile.setName(rs.getString("NOMBRE"));
		profile.setCreationDate(rs.getString("FECHA_CREACION"));
		profile.setFlagRoute(rs.getString("FLAGRUTA"));
		return profile;
	}

}
