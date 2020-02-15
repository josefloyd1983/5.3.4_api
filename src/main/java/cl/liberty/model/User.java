/**
 * 
 */
package cl.liberty.model;

import java.io.Serializable;

/**
 * @author jgarrido
 *
 */
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	private String creationDate;
	private String email;
	private String lastName;
	private String name;
	private Integer status;
	private String userName;
	private String password;
	private Integer countryId;
	private String countryName;
	private String countryCode;
	private Integer profileId;
	private String profileName;
	private String flagRoute;
	private String profileCreationDate;
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", creationDate=" + creationDate + ", email=" + email + ", lastName="
				+ lastName + ", name=" + name + ", status=" + status + ", userName=" + userName + ", password="
				+ password + ", countryId=" + countryId + ", countryName=" + countryName + ", countryCode="
				+ countryCode + ", profileId=" + profileId + ", profileName=" + profileName + ", flagRoute=" + flagRoute
				+ ", profileCreationDate=" + profileCreationDate + "]";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getFlagRoute() {
		return flagRoute;
	}

	public void setFlagRoute(String flagRoute) {
		this.flagRoute = flagRoute;
	}

	public String getProfileCreationDate() {
		return profileCreationDate;
	}

	public void setProfileCreationDate(String profileCreationDate) {
		this.profileCreationDate = profileCreationDate;
	}
	
	
}
