/**
 * 
 */
package cl.liberty.response;

import java.util.List;

import cl.liberty.model.Profile;

/**
 * @author jgarrido
 *
 */
public class ProfileResponse {

	List<Profile> profiles;

	@Override
	public String toString() {
		return "ProfileResponse [profiles=" + profiles + "]";
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

}
