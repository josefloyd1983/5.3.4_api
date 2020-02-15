/**

*

 */

package cl.liberty.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import cl.liberty.constantes.Constantes;
import cl.liberty.dao.UserDao;
import cl.liberty.model.User;
import cl.liberty.request.UserRequest;
import cl.liberty.utils.UtilAMS;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	Environment env;

	@Autowired

	private NamedParameterJdbcTemplate jdbc;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("rawtypes")
	@Override
	public User getUser(String userName) {
		SqlParameterSource paramaters = new MapSqlParameterSource().addValue(Constantes.PARAMETER_USER_USERNAME,
				userName);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_user");
		Map out = simpleJdbcCall.execute(paramaters);
		User user = new User();
		user.setUserId(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_USER_ID))));
		user.setCreationDate(String.valueOf(out.get(Constantes.PARAMETER_USER_CREATION_DATE)));
		user.setEmail(String.valueOf(out.get(Constantes.PARAMETER_USER_EMAIL)));
		user.setLastName(String.valueOf(out.get(Constantes.PARAMETER_LASTNAME)));
		user.setName(String.valueOf(out.get(Constantes.PARAMETER_USER_NAME)));
		user.setStatus(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_USER_STATUS))));
		user.setUserName(String.valueOf(out.get(Constantes.PARAMETER_USER_USERNAME)));
		user.setPassword(String.valueOf(out.get(Constantes.PARAMETER_USER_CONTRASENA)));
		user.setCountryId(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_USER_COUNTRY_ID))));
		user.setCountryName(String.valueOf(out.get(Constantes.PARAMETER_USER_COUNTRY_NAME)));
		user.setCountryCode(String.valueOf(out.get(Constantes.PARAMETER_USER_COUNTRY_CODE)));
		user.setProfileId(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_USER_PROFILE_ID))));
		user.setProfileName(String.valueOf(out.get(Constantes.PARAMETER_USER_PROFILE_NAME)));
		user.setProfileCreationDate(String.valueOf(out.get(Constantes.PARAMETER_USER_PROFILE_CREATION_DATE)));
		user.setFlagRoute(String.valueOf(out.get(Constantes.PARAMETER_USER_FLAG_ROUTE)));
		return user;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers(Integer userId, Integer status, Integer profileId, Integer countryId, String name,
			String nameSurname, String userName) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(Constantes.PARAMETER_USER_ID, userId)
				.addValue(Constantes.PARAMETER_USER_STATUS, status)
				.addValue(Constantes.PARAMETER_USER_PROFILE_ID, profileId)
				.addValue(Constantes.PARAMETER_USER_COUNTRY_ID, countryId)
				.addValue(Constantes.PARAMETER_USER_NAME, name)
				.addValue(Constantes.PARAMETER_USER_NAME_SURNAME, nameSurname)
				.addValue(Constantes.PARAMETER_USER_USERNAME, userName);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_users")
				.returningResultSet(env.getProperty(Constantes.P_CURSOR),
						BeanPropertyRowMapper.newInstance(User.class));
		Map<String, Object> out = simpleJdbcCall.execute(parameters);
		return ((List<User>) out.get(env.getProperty(Constantes.P_CURSOR)));
	}

	@SuppressWarnings("rawtypes")
	@Override
	public User getUser(Integer userId) {
		SqlParameterSource paramaters = new MapSqlParameterSource().addValue(Constantes.PARAMETER_USER_ID, userId);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_user_identity");
		Map out = simpleJdbcCall.execute(paramaters);
		User user = new User();
		user.setUserId(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_USER_ID))));
		user.setCreationDate(String.valueOf(out.get(Constantes.PARAMETER_USER_CREATION_DATE)));
		user.setEmail(String.valueOf(out.get(Constantes.PARAMETER_USER_EMAIL)));
		user.setLastName(String.valueOf(out.get(Constantes.PARAMETER_LASTNAME)));
		user.setName(String.valueOf(out.get(Constantes.PARAMETER_USER_NAME)));
		user.setStatus(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_USER_STATUS))));
		user.setUserName(String.valueOf(out.get(Constantes.PARAMETER_USER_USERNAME)));
		user.setPassword(String.valueOf(out.get(Constantes.PARAMETER_USER_CONTRASENA)));
		user.setCountryId(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_USER_COUNTRY_ID))));
		user.setCountryName(String.valueOf(out.get(Constantes.PARAMETER_USER_COUNTRY_NAME)));
		user.setCountryCode(String.valueOf(out.get(Constantes.PARAMETER_USER_COUNTRY_CODE)));
		user.setProfileId(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_USER_PROFILE_ID))));
		user.setProfileName(String.valueOf(out.get(Constantes.PARAMETER_USER_PROFILE_NAME)));
		user.setProfileCreationDate(String.valueOf(out.get(Constantes.PARAMETER_USER_PROFILE_CREATION_DATE)));
		user.setFlagRoute(String.valueOf(out.get(Constantes.PARAMETER_USER_FLAG_ROUTE)));
		return user;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public User getUserByUserName(String userName) {
		SqlParameterSource paramaters = new MapSqlParameterSource().addValue(Constantes.PARAMETER_USER_USERNAME,
				userName);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_user_by_username");
		Map out = simpleJdbcCall.execute(paramaters);
		User user = new User();
		user.setUserId(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_USER_ID))));
		user.setCreationDate(String.valueOf(out.get(Constantes.PARAMETER_USER_CREATION_DATE)));
		user.setEmail(String.valueOf(out.get(Constantes.PARAMETER_USER_EMAIL)));
		user.setLastName(String.valueOf(out.get(Constantes.PARAMETER_LASTNAME)));
		user.setName(String.valueOf(out.get(Constantes.PARAMETER_USER_NAME)));
		user.setStatus(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_USER_STATUS))));
		user.setUserName(String.valueOf(out.get(Constantes.PARAMETER_USER_USERNAME)));
		user.setPassword(String.valueOf(out.get(Constantes.PARAMETER_USER_CONTRASENA)));
		user.setCountryId(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_USER_COUNTRY_ID))));
		user.setCountryName(String.valueOf(out.get(Constantes.PARAMETER_USER_COUNTRY_NAME)));
		user.setCountryCode(String.valueOf(out.get(Constantes.PARAMETER_USER_COUNTRY_CODE)));
		user.setProfileId(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_USER_PROFILE_ID))));
		user.setProfileName(String.valueOf(out.get(Constantes.PARAMETER_USER_PROFILE_NAME)));
		user.setProfileCreationDate(String.valueOf(out.get(Constantes.PARAMETER_USER_PROFILE_CREATION_DATE)));
		user.setFlagRoute(String.valueOf(out.get(Constantes.PARAMETER_USER_FLAG_ROUTE)));
		return user;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public User getUserByEmail(String email) {
		SqlParameterSource paramaters = new MapSqlParameterSource().addValue(Constantes.PARAMETER_USER_EMAIL, email);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_user_by_email");
		Map out = simpleJdbcCall.execute(paramaters);
		User user = new User();
		user.setUserId(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_USER_ID))));
		user.setCreationDate(String.valueOf(out.get(Constantes.PARAMETER_USER_CREATION_DATE)));
		user.setEmail(String.valueOf(out.get(Constantes.PARAMETER_USER_EMAIL)));
		user.setLastName(String.valueOf(out.get(Constantes.PARAMETER_LASTNAME)));
		user.setName(String.valueOf(out.get(Constantes.PARAMETER_USER_NAME)));
		user.setStatus(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_USER_STATUS))));
		user.setUserName(String.valueOf(out.get(Constantes.PARAMETER_USER_USERNAME)));
		user.setPassword(String.valueOf(out.get(Constantes.PARAMETER_USER_CONTRASENA)));
		user.setCountryId(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_USER_COUNTRY_ID))));
		user.setCountryName(String.valueOf(out.get(Constantes.PARAMETER_USER_COUNTRY_NAME)));
		user.setCountryCode(String.valueOf(out.get(Constantes.PARAMETER_USER_COUNTRY_CODE)));
		user.setProfileId(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_USER_PROFILE_ID))));
		user.setProfileName(String.valueOf(out.get(Constantes.PARAMETER_USER_PROFILE_NAME)));
		user.setProfileCreationDate(String.valueOf(out.get(Constantes.PARAMETER_USER_PROFILE_CREATION_DATE)));
		user.setFlagRoute(String.valueOf(out.get(Constantes.PARAMETER_USER_FLAG_ROUTE)));
		return user;
	}

	@Override
	public void addUser(UserRequest userRequest) {
		Date now = new Date();
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue(Constantes.PARAMETER_USER_NAME, userRequest.getName())
				.addValue(Constantes.PARAMETER_LASTNAME, userRequest.getLastName())
				.addValue(Constantes.PARAMETER_USER_USERNAME, userRequest.getUserName())
				.addValue(Constantes.PARAMETER_USER_EMAIL, userRequest.getEmail())
				.addValue(Constantes.PARAMETER_USER_PROFILE_ID, userRequest.getProfileId())
				.addValue(Constantes.PARAMETER_USER_STATUS, userRequest.getStatus())
				.addValue(Constantes.PARAMETER_USER_CONTRASENA, userRequest.getPassWord())
				.addValue(Constantes.PARAMETER_USER_CREATION_DATE, UtilAMS.formatDate(now, 3));

		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_add_user");
		simpleJdbcCall.execute(parameters);

	}

	@Override
	public void editUser(UserRequest userRequest) {
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue(Constantes.PARAMETER_USER_ID, userRequest.getUserId())
				.addValue(Constantes.PARAMETER_USER_NAME, userRequest.getName())
				.addValue(Constantes.PARAMETER_LASTNAME, userRequest.getLastName())
				.addValue(Constantes.PARAMETER_USER_USERNAME, userRequest.getUserName())
				.addValue(Constantes.PARAMETER_USER_EMAIL, userRequest.getEmail())
				.addValue(Constantes.PARAMETER_USER_PROFILE_ID, userRequest.getProfileId())
				.addValue(Constantes.PARAMETER_USER_STATUS, userRequest.getStatus())
				.addValue(Constantes.PARAMETER_USER_CONTRASENA, userRequest.getPassWord());

		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_edit_user");
		simpleJdbcCall.execute(parameters);
	}

	@Override
	public void deleteUser(Integer userId) {
		SqlParameterSource paramaters = new MapSqlParameterSource().addValue(Constantes.PARAMETER_USER_ID, userId);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_delete_user");
		simpleJdbcCall.execute(paramaters);
	}

	@Override
	public void addUserProfile(Integer userId, Integer profileId, Integer countryId) {
		SqlParameterSource namedParameters = new MapSqlParameterSource()
				.addValue(Constantes.MAP_PARAMETER_USERID, userId)
				.addValue(Constantes.MAP_PARAMETER_USER_PROFILEID, profileId).addValue("countryId", countryId);
		String query = "INSERT INTO " + env.getProperty(Constantes.ESCHEMA_DB)
				+ ".HIPO_USUARIO_PERFIL_PAIS (ID_USUARIO, ID_PERFIL, ID_PAIS) VALUES(:userId, :profileId, :countryId)";
		jdbc.update(query, namedParameters);
	}

	@Override
	public void editUserProfile(Integer userId, Integer profileId, Integer countryId) {
		SqlParameterSource namedParameters = new MapSqlParameterSource()
				.addValue(Constantes.MAP_PARAMETER_USERID, userId)
				.addValue(Constantes.MAP_PARAMETER_USER_PROFILEID, profileId).addValue("countryId", countryId);
		String query = "UPDATE " + env.getProperty(Constantes.ESCHEMA_DB)
				+ ".HIPO_USUARIO_PERFIL_PAIS SET ID_PERFIL=:profileId, ID_PAIS=:countryId WHERE ID_USUARIO = :userId";
		jdbc.update(query, namedParameters);

	}

	@Override
	public void deleteUserProfile(Integer userId) {
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(Constantes.MAP_PARAMETER_USERID,
				userId);
		String query = "DELETE FROM " + env.getProperty(Constantes.ESCHEMA_DB)
				+ ".HIPO_USUARIO_PERFIL_PAIS WHERE ID_USUARIO = :userId";
		jdbc.update(query, namedParameters);

	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean validateUserExist(Integer userId) {
		SqlParameterSource paramaters = new MapSqlParameterSource().addValue(Constantes.PARAMETER_USER_ID, userId);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_user_exist");
		Map out = simpleJdbcCall.execute(paramaters);
		return Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_COUNT))) != 0;

	}

	@Override
	public void changeStatusUser(Integer userId, Integer status) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(Constantes.PARAMETER_USER_ID, userId)
				.addValue(Constantes.PARAMETER_USER_STATUS, status);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_change_status_user");
		simpleJdbcCall.execute(parameters);

	}
}