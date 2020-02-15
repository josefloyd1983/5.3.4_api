/**
 * 
 */
package cl.liberty.services;

import java.util.List;

import cl.liberty.model.Property;

/**
 * @author jgarrido
 *
 */
public interface PropertyService {

	public Property getProperty(String name);

	public List<Property> getPropertys(Integer idPadre);

}
