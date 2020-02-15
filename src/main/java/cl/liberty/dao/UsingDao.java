/**
 * 
 */
package cl.liberty.dao;

import java.util.List;

import cl.liberty.model.Using;

/**
 * @author jgarrido
 *
 */
public interface UsingDao {

	public List<Using> getUsings();

	public Using getUsingByDescription(String description);

}
