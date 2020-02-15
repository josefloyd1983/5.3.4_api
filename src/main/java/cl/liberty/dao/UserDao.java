/**
 * 
 */
package cl.liberty.dao;

import java.util.List;

import cl.liberty.model.User;
import cl.liberty.request.UserRequest;

/**
 * @author jgarrido
 *
 */
public interface UserDao {

	public User getUser(String userName);

	public List<User> getUsers(Integer userId, Integer status, Integer profileId, Integer countryId, String name,
			String namelastName, String userName);

	public User getUser(Integer userId);

	public User getUserByUserName(String userName);

	public User getUserByEmail(String email);

	public void addUser(UserRequest userRequest);

	public void editUser(UserRequest userRequest);

	public void deleteUser(Integer userId);

	public void addUserProfile(Integer userId, Integer profileId, Integer countryId);
	
	public void editUserProfile(Integer userId, Integer profileId, Integer countryId);
	
	public void deleteUserProfile(Integer userId);
	
	public boolean validateUserExist(Integer userId);
	
	public void changeStatusUser(Integer userId, Integer status);

}
