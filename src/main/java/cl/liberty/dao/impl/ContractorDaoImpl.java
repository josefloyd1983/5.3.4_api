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
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import cl.liberty.constantes.Constantes;
import cl.liberty.dao.ContractorDao;
import cl.liberty.mapper.ContractorMapper;
import cl.liberty.model.Contractor;
import cl.liberty.request.ContractorRequest;

/**
 * @author jgarrido
 *
 */

@Repository
public class ContractorDaoImpl implements ContractorDao {

	@Autowired
	Environment env;

	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Contractor> getContractors() {
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_contractors")
				.returningResultSet(env.getProperty(Constantes.P_CURSOR),
						BeanPropertyRowMapper.newInstance(Contractor.class));
		Map<String, Object> out = simpleJdbcCall.execute();
		return ((List<Contractor>) out.get(env.getProperty(Constantes.P_CURSOR)));

	}

	@SuppressWarnings("rawtypes")
	@Override
	public Contractor getContractor(Integer contractorCode) {
		SqlParameterSource paramaters = new MapSqlParameterSource().addValue(Constantes.PARAMETER_CONTRACTOR_CODE,
				contractorCode);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_contractor");
		Map out = simpleJdbcCall.execute(paramaters);
		Contractor contractor = new Contractor();
		contractor.setContractorCode(Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_CONTRACTOR_CODE))));
		contractor.setContractorDescription(String.valueOf(out.get(Constantes.PARAMETER_CONTRACTOR_DESCRIPTION)));
		return contractor;

	}

	@Override
	public Contractor getContractorByCode(Integer contractorCode) {
		SqlParameterSource namedParameters = new MapSqlParameterSource()
				.addValue(Constantes.MAP_PARAMETER_CONTRACTOR_CODE, contractorCode);
		String query = "SELECT CODIGO_CONTRATANTE, DESCRIPCION FROM " + env.getProperty(Constantes.ESCHEMA_DB)
				+ ".HIPO_CONTRATANTE WHERE CODIGO_CONTRATANTE = :contractorCode ";
		return jdbc.queryForObject(query, namedParameters, new ContractorMapper());
	}

	@Override
	public void addContractor(ContractorRequest contractorAddRequest) {
		SqlParameterSource paramaters = new MapSqlParameterSource()
				.addValue(Constantes.PARAMETER_CONTRACTOR_CODE, contractorAddRequest.getContractorCode())
				.addValue(Constantes.PARAMETER_CONTRACTOR_DESCRIPTION, contractorAddRequest.getContractorDescription());
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_add_contractor");
		simpleJdbcCall.execute(paramaters);

	}

	@Override
	public void editContractor(ContractorRequest contractorEditRequest) {
		SqlParameterSource paramaters = new MapSqlParameterSource()
				.addValue(Constantes.PARAMETER_CONTRACTOR_CODE, contractorEditRequest.getContractorCode()).addValue(
						Constantes.PARAMETER_CONTRACTOR_DESCRIPTION, contractorEditRequest.getContractorDescription());
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_edit_contractor");
		simpleJdbcCall.execute(paramaters);

	}

	@Override
	public void deleteContractor(Integer contractorCode) {
		SqlParameterSource paramaters = new MapSqlParameterSource().addValue(Constantes.PARAMETER_CONTRACTOR_CODE,
				contractorCode);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_delete_contractor");
		simpleJdbcCall.execute(paramaters);

	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean validateContractorExist(Integer contractorCode) {
		SqlParameterSource paramaters = new MapSqlParameterSource().addValue(Constantes.PARAMETER_CONTRACTOR_CODE,
				contractorCode);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(env.getProperty(Constantes.ESCHEMA_DB))
				.withCatalogName(env.getProperty(Constantes.ESCHEMA_PACKAGE)).withProcedureName("p_contractor_exist");
		Map out = simpleJdbcCall.execute(paramaters);
		return Integer.parseInt(String.valueOf(out.get(Constantes.PARAMETER_COUNT))) != 0;

	}
}
