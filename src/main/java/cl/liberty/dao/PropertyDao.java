/**
 * 
 */
package cl.liberty.dao;

import java.util.List;

import cl.liberty.model.Property;

/**
 * @author jgarrido
 *
 */
public interface PropertyDao {

	public Property getProperty(String name);

	public List<Property> getPropertys(Integer idPadre);

}
