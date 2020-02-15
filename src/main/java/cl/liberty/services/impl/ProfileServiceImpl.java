/**
 * 
 */
package cl.liberty.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.liberty.constantes.Constantes;
import cl.liberty.constantes.Errores;
import cl.liberty.dao.ProfileDao;
import cl.liberty.model.Profile;
import cl.liberty.model.ProfileMenu;
import cl.liberty.model.User;
import cl.liberty.services.ProfileService;

/**
 * @author jgarrido
 *
 */

@Repository
public class ProfileServiceImpl implements ProfileService {

	private static final Logger logger = LoggerFactory.getLogger(ProfileServiceImpl.class);

	@Autowired
	private ProfileDao profileDao;

	@Override
	@Transactional
	public List<Profile> getProfiles() {
		List<Profile> result = new ArrayList<>();
		try {
			result = profileDao.getProfiles();
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	@Transactional
	public List<ProfileMenu> getProfileMenus(User usuario) {
		List<ProfileMenu> profileMenus = new ArrayList<>();
		List<ProfileMenu> profileSubMenus = new ArrayList<>();

		try {
			List<ProfileMenu> result = profileDao.getProfileMenus(usuario);
			for (int j = 0; j < result.size(); j++) {
				ProfileMenu profileMenu = new ProfileMenu();
				profileMenu.setModuleId(result.get(j).getModuleId());
				profileMenu.setTitle(result.get(j).getTitle());
				profileMenu.setPath(Constantes.EMPTY);
				profileMenu.setUrl(Constantes.EMPTY);
				profileMenu.setDdClass("single-dd");
				profileMenu.setClasss("has-arrow");
				profileMenu.setLink(Constantes.EMPTY);
				profileMenu.setIcon(Constantes.EMPTY);
				profileMenu.setExtraLink(false);
				profileMenu.setIcon(result.get(j).getIcon());
				profileMenu.setAccessId(result.get(j).getAccessId());
				profileMenu.setAccessName(result.get(j).getAccessName());
				profileMenu.setCreationDate(result.get(j).getCreationDate());
				profileSubMenus = getProfileSubMenus(usuario, result.get(j).getModuleId());
				profileMenu.setSubMenu(profileSubMenus);
				if (!profileSubMenus.isEmpty()) {
					profileMenus.add(profileMenu);
				}
			}
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return profileMenus;
	}

	@Override
	@Transactional
	public List<ProfileMenu> getProfileSubMenus(User usuario, int fatherId) {
		List<ProfileMenu> result = new ArrayList<>();
		try {
			result = profileDao.getProfileSubMenus(usuario, fatherId);
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

}
