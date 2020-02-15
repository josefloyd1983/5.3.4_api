/**
 * 
 */
package cl.liberty.test.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.liberty.configuration.Application;
import cl.liberty.dao.ProfileDao;
import cl.liberty.model.Profile;
import cl.liberty.model.ProfileMenu;
import cl.liberty.model.User;

/**
 * @author jgarrido
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("local")
public class ProfileDaoTest {

	@Autowired
	ProfileDao profileDao;

	@Test
	public void getProfileSTest() {
		List<Profile> profiles = profileDao.getProfiles();
		assertNotNull("Perfiles es null", profiles);
	}

	@Test
	public void getProfileMenuTest() {
		User usuario = new User();
		usuario.setProfileId(1);
		List<ProfileMenu> profileMenus = profileDao.getProfileMenus(usuario);
		assertNotNull("Perfil Menu es null", profileMenus);
	}

	@Test
	public void getProfileSubMenuTest() {
		User usuario = new User();
		usuario.setProfileId(1);
		List<ProfileMenu> profileSubMenus = profileDao.getProfileSubMenus(usuario, 1);
		assertNotNull("Perfil Sub Menu es null", profileSubMenus);
	}

}
