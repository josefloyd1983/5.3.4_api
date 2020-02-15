/**
 * 
 */
package cl.liberty.response;

import java.util.List;

import cl.liberty.model.Property;

/**
 * @author jgarrido
 *
 */
public class PropertyResponse {

	List<Property> propertys;

	@Override
	public String toString() {
		return "PropertyResponse [propertys=" + propertys + "]";
	}

	public List<Property> getPropertys() {
		return propertys;
	}

	public void setPropertys(List<Property> propertys) {
		this.propertys = propertys;
	}

}
