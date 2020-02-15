/**
 * 
 */
package cl.liberty.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import cl.liberty.constantes.Constantes;
import cl.liberty.dao.ProfileDao;
import cl.liberty.model.Profile;
import cl.liberty.model.ProfileMenu;
import cl.liberty.model.User;

/**
 * @author jgarrido
 *
 */

@Repository
public class ProfileDaoImpl implements ProfileDao {

	@Autowired
	Environment env;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Profile> getProfiles() {
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_profiles")
				.returningResultSet(env.getProperty(Constantes.P_CURSOR),
						BeanPropertyRowMapper.newInstance(Profile.class));
		Map<String, Object> out = simpleJdbcCall.execute();
		return ((List<Profile>) out.get(env.getProperty(Constantes.P_CURSOR)));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProfileMenu> getProfileMenus(User usuario) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(Constantes.PARAMETER_PROFILE_ID,
				usuario.getProfileId());
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_profile_menu")
				.returningResultSet(env.getProperty(Constantes.P_CURSOR),
						BeanPropertyRowMapper.newInstance(ProfileMenu.class));
		Map<String, Object> out = simpleJdbcCall.execute(parameters);
		return ((List<ProfileMenu>) out.get(env.getProperty(Constantes.P_CURSOR)));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProfileMenu> getProfileSubMenus(User usuario, int fatherId) {
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue(Constantes.PARAMETER_PROFILE_ID, usuario.getProfileId())
				.addValue(Constantes.PARAMETER_PROFILE_FATHER_ID, fatherId);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_profile_sub_menu")
				.returningResultSet(env.getProperty(Constantes.P_CURSOR),
						BeanPropertyRowMapper.newInstance(ProfileMenu.class));
		Map<String, Object> out = simpleJdbcCall.execute(parameters);
		return ((List<ProfileMenu>) out.get(env.getProperty(Constantes.P_CURSOR)));

	}

}
