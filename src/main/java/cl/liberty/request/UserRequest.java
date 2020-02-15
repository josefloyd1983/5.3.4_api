/**
 * 
 */
package cl.liberty.request;

import java.io.Serializable;

/**
 * @author joseg
 *
 */
public class UserRequest implements Serializable {

	private static final long serialVersionUID = 4155055822525802475L;

	private Integer userId;
	private Integer profileId;
	private String email;
	private String name;
	private String lastName;
	private String userName;
	private String passWord;
	private Integer status;
	
	@Override
	public String toString() {
		return "UserRequest [userId=" + userId + ", profileId=" + profileId + ", email=" + email + ", name=" + name
				+ ", lastName=" + lastName + ", userName=" + userName + ", passWord=" + passWord + ", status=" + status
				+ "]";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

	

}
