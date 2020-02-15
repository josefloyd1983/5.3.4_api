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
import cl.liberty.dao.UsingDao;
import cl.liberty.model.Using;

/**
 * @author jgarrido
 *
 */

@Repository
public class UsingDaoImpl implements UsingDao {

	@Autowired
	Environment env;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Using> getUsings() {
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_usings")
				.returningResultSet(env.getProperty(Constantes.P_CURSOR),
						BeanPropertyRowMapper.newInstance(Using.class));
		Map<String, Object> out = simpleJdbcCall.execute();
		return ((List<Using>) out.get(env.getProperty(Constantes.P_CURSOR)));

	}

	@SuppressWarnings("rawtypes")
	@Override
	public Using getUsingByDescription(String description) {
		SqlParameterSource paramaters = new MapSqlParameterSource().addValue(Constantes.PARAMETER_USING_DESCRIPTION,
				description);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE))
				.withProcedureName("p_using_by_description");
		Map out = simpleJdbcCall.execute(paramaters);
		Using using = new Using();
		using.setUsingId(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_USING_ID))));
		using.setUsingDescription(String.valueOf(out.get(Constantes.PARAMETER_USING_DESCRIPTION)));
		return using;

	}
}
