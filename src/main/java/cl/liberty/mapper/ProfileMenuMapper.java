/**
 * 
 */
package cl.liberty.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import cl.liberty.model.ProfileMenu;

/**
 * @author jgarrido
 *
 */
public class ProfileMenuMapper implements RowMapper<ProfileMenu> {

	private static final Logger logger = LoggerFactory.getLogger(ProfileMenuMapper.class);

	@Override
	public ProfileMenu mapRow(ResultSet rs, int rowNum) throws SQLException {
		logger.debug("ProfileMenu: {}", rs.getString("name"));
		ProfileMenu menuProfile = new ProfileMenu();
		menuProfile.setModuleId(rs.getInt("id_module"));
		menuProfile.setTitle((rs.getString("name") != null ? rs.getString("name") : ""));
		menuProfile.setPath((rs.getString("url") != null ? rs.getString("url") : "") );
		menuProfile.setUrl((rs.getString("url") != null ? rs.getString("url") : "") );
		menuProfile.setIcon((rs.getString("icon") != null ? rs.getString("icon") : ""));
		menuProfile.setAccessId(rs.getInt("id_access"));
		menuProfile.setStatus(rs.getInt("estado"));
		menuProfile.setAccessName((rs.getString("accessName") != null ? rs.getString("accessName"): ""));
		menuProfile.setCreationDate(rs.getTimestamp("creationdate"));
		menuProfile.setDdClass("single-dd");
		menuProfile.setClasss("has-arrow");
		return menuProfile;
	}

}
