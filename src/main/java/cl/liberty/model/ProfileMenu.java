/**
 * 
 */
package cl.liberty.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jgarrido
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileMenu implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer moduleId;
	private String title;
	private Integer status;
	private String path;
	private String url;
	private String icon = "";
	private Integer accessId;
	private Timestamp creationDate;
	private String accessName;
	private String link;
	@JsonProperty("ddclass")
	private String ddClass;
	@JsonProperty("extralink")
	private boolean extraLink;
	@JsonProperty("class")
	private String classs;
	@JsonProperty("submenu")
	private List<ProfileMenu> subMenu;

	@Override
	public String toString() {
		return "ProfileMenu [moduleId=" + moduleId + ", title=" + title + ", status=" + status + ", path=" + path
				+ ", url=" + url + ", icon=" + icon + ", accessId=" + accessId + ", creationDate=" + creationDate
				+ ", accessName=" + accessName + ", link=" + link + ", ddClass=" + ddClass + ", extraLink=" + extraLink
				+ ", classs=" + classs + ", subMenu=" + subMenu + "]";
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public String getTitle() {
		return (title != null ?title : "") ;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPath() {
		return (path != null ?path : "") ;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getIcon() {
		return (icon != null ?icon : "");
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getAccessId() {
		return accessId;
	}

	public void setAccessId(Integer accessId) {
		this.accessId = accessId;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getAccessName() {
		return (accessName != null ?accessName : "") ;
	}

	public void setAccessName(String accessName) {
		this.accessName = accessName;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDdClass() {
		return ddClass;
	}

	public void setDdClass(String ddClass) {
		this.ddClass = ddClass;
	}

	public boolean isExtraLink() {
		return extraLink;
	}

	public void setExtraLink(boolean extraLink) {
		this.extraLink = extraLink;
	}

	public String getClasss() {
		return classs;
	}

	public void setClasss(String classs) {
		this.classs = classs;
	}

	public List<ProfileMenu> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<ProfileMenu> subMenu) {
		this.subMenu = subMenu;
	}

	public String getUrl() {
		return (url != null ?url : "");
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	


}
