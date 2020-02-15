/**
 * 
 */
package cl.liberty.services;

import java.util.List;

import cl.liberty.model.Using;

/**
 * @author jgarrido
 *
 */
public interface UsingService {

	List<Using> getUsings();

	public Using getUsingByDescription(String description);
}
