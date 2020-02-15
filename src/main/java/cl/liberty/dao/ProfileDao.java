/**
 * 
 */
package cl.liberty.dao;

import java.util.List;

import cl.liberty.model.Profile;
import cl.liberty.model.ProfileMenu;
import cl.liberty.model.User;

/**
 * @author jgarrido
 *
 */
public interface ProfileDao {

	public List<Profile> getProfiles();

	public List<ProfileMenu> getProfileMenus(User usuario);

	public List<ProfileMenu> getProfileSubMenus(User usuario, int fatherId);

}
