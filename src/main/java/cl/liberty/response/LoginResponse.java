/**
 * 
 */
package cl.liberty.response;

import java.util.List;

import cl.liberty.model.ProfileMenu;
import cl.liberty.model.User;

/**
 * @author jgarrido
 *
 */
public class LoginResponse {

	User user;
	List<ProfileMenu> profileMenus;

	@Override
	public String toString() {
		return "LoginResponse [user=" + user + ", profileMenus=" + profileMenus + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ProfileMenu> getProfileMenus() {
		return profileMenus;
	}

	public void setProfileMenus(List<ProfileMenu> profileMenus) {
		this.profileMenus = profileMenus;
	}

}
