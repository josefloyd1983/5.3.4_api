/**
 * 
 */
package cl.liberty.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import cl.liberty.model.Contractor;

/**
 * @author jgarrido
 *
 */
public class ContractorMapper implements RowMapper<Contractor> {

	private static final Logger logger = LoggerFactory.getLogger(ContractorMapper.class);

	@Override
	public Contractor mapRow(ResultSet rs, int rowNum) throws SQLException {
		logger.debug("Contractor: {}", rs.getInt("CODIGO_CONTRATANTE"));
		Contractor contractor = new Contractor();
		contractor.setContractorCode(rs.getInt("CODIGO_CONTRATANTE"));
		contractor.setContractorDescription(rs.getString("DESCRIPCION"));
		return contractor;
	}

}
