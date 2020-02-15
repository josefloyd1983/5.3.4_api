/**
 * 
 */
package cl.liberty.response;

import java.util.List;

import cl.liberty.model.Using;

/**
 * @author jgarrido
 *
 */
public class UsingResponse {

	List<Using> usings;

	@Override
	public String toString() {
		return "UsingResponse [usings=" + usings + "]";
	}

	public List<Using> getUsings() {
		return usings;
	}

	public void setUsings(List<Using> usings) {
		this.usings = usings;
	}

}
