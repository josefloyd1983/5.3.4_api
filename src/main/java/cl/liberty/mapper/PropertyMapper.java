/**
 * 
 */
package cl.liberty.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import cl.liberty.model.Property;

/**
 * @author jgarrido
 *
 */
public class PropertyMapper implements RowMapper<Property> {

	private static final Logger logger = LoggerFactory.getLogger(PropertyMapper.class);

	@Override
	public Property mapRow(ResultSet rs, int rowNum) throws SQLException {
		logger.debug("Property: {}", rs.getInt("id_property"));
		Property property = new Property();
		property.setPropertyId(rs.getInt("id_property"));
		property.setPaisId(rs.getInt("id_pais"));
		property.setTipoPropertyId(rs.getInt("id_tipoproperty"));
		property.setName(rs.getString("nombre"));
		property.setDescription(rs.getString("descripcion"));
		property.setValue(rs.getString("valor"));
		property.setStatus(rs.getInt("estado"));
		property.setPadreId(rs.getInt("id_padre"));
		return property;
	}

}
