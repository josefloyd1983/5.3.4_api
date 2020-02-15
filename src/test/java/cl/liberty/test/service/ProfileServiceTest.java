/**
 * 
 */
package cl.liberty.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.liberty.configuration.Application;
import cl.liberty.model.Profile;
import cl.liberty.model.ProfileMenu;
import cl.liberty.model.User;
import cl.liberty.services.ProfileService;

/**
 * @author jgarrido
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("local")
public class ProfileServiceTest {

	@Autowired
	ProfileService profileService;

	@Test
	public void getProfileSTest() {
		List<Profile> profiles = profileService.getProfiles();
		assertNotNull("Perfiles es null", profiles);
	}

	@Test
	public void getMenuProfileTest() {
		User usuario = new User();
		usuario.setProfileId(1);
		List<ProfileMenu> profileMenu = profileService.getProfileMenus(usuario);
		assertNotNull("Perfil Menu es null", profileMenu);
	}

	@Test
	public void getSubMenuProfileTest() {
		User usuario = new User();
		usuario.setProfileId(1);
		List<ProfileMenu> profileMenu = profileService.getProfileSubMenus(usuario, 1);
		assertNotNull("Perfil Sub Menu es null", profileMenu);
	}

}
