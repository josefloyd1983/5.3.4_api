/**
 * 
 */
package cl.liberty.model;

import java.io.Serializable;

/**
 * @author jgarrido
 *
 */
public class Profile implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer profileId;
	private String name;
	private String creationDate;
	private String flagRoute;
	
	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", name=" + name + ", creationDate=" + creationDate + ", flagRoute="
				+ flagRoute + "]";
	}

	public Integer getProfileId() {
		return profileId;
	}

	public String getName() {
		return name;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public String getFlagRoute() {
		return flagRoute;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public void setFlagRoute(String flagRoute) {
		this.flagRoute = flagRoute;
	}
	
	

}
