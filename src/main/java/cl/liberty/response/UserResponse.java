/**
 * 
 */
package cl.liberty.response;

import java.util.List;

import cl.liberty.model.User;

/**
 * @author jgarrido
 *
 */
public class UserResponse {

	List<User> users;

	@Override
	public String toString() {
		return "UserResponse [users=" + users + "]";
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	

}
