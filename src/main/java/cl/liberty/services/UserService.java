/**
 * 
 */
package cl.liberty.services;

import java.util.List;

import cl.liberty.model.User;
import cl.liberty.request.UserRequest;
import cl.liberty.response.OperationResponse;

/**
 * @author jgarrido
 *
 */
public interface UserService {

	public User getUser(String userName);

	public List<User> getUsers(Integer userId, Integer status, Integer profileId, Integer countryId, String name,
			String namelastName, String userName);

	public User getUser(Integer userId);

	public User getUserByUserName(String userName);

	public User getUserByEmail(String email);

	public OperationResponse addUser(UserRequest userRequest);

	public OperationResponse editUser(UserRequest userRequest);

	public OperationResponse deleteUser(Integer userId);

	public OperationResponse addUserProfile(Integer userId, Integer profileId, Integer countryId);
	
	public OperationResponse editUserProfile(Integer userId, Integer profileId, Integer countryId);
	
	public OperationResponse deleteUserProfile(Integer userId);
	
	public boolean validateUserExist(Integer userId);
	
	public OperationResponse changeStatusUser(Integer userId, Integer status);

}
