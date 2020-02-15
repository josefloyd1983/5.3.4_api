/**
 * 
 */
package cl.liberty.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import cl.liberty.model.User;

/**
 * @author jgarrido
 *
 */
public class UserMapper implements RowMapper<User> {

	private static final Logger logger = LoggerFactory.getLogger(UserMapper.class);

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		logger.debug("Usuario: {}", rs.getInt("id_user"));
		User user = new User();
		user.setUserId(rs.getInt("id_user"));
		user.setCreationDate(rs.getString("creationdate"));
		user.setEmail(rs.getString("email"));
		user.setLastName(rs.getString("lastname"));
		user.setName(rs.getString("name"));
		user.setStatus(rs.getInt("status"));
		user.setUserName(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setCountryId(rs.getInt("id_country"));
		user.setCountryName(rs.getString("countryname"));
		user.setCountryCode(rs.getString("countrycode"));
		user.setProfileId(rs.getInt("id_profile"));
		user.setProfileName(rs.getString("profilename"));
		user.setProfileCreationDate(rs.getString("profilecreationdate"));
		user.setFlagRoute(rs.getString("flagroute"));
		return user;
	}

}
