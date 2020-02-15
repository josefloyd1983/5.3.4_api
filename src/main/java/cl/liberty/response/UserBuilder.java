/**
 * 
 */
package cl.liberty.response;

import cl.liberty.model.User;

/**
 * @author jgarrido
 *
 */
public class UserBuilder {

	User user;

	@Override
	public String toString() {
		return "UserBuilder [user=" + user + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	

}
