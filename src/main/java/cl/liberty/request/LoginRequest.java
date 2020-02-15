/**
 * 
 */
package cl.liberty.request;

import java.io.Serializable;

/**
 * @author jgarrido
 *
 */
public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String user;
	private String password;

	/**
	 * 
	 */
	public LoginRequest() {
		super();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
