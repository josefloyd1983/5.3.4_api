/**
 * @name BodyReq.java 
 * 
 * @version 1.0 
 * 
 * @date 2 mar. 2018 
 * 
 * @author JOSELUIS 
 * 
 * @copyright Aligare Consultores. All rights reserved.
 */
package cl.liberty.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import cl.liberty.constantes.Constantes;

/**
 * @description 	
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = Constantes.BODY)
@XmlAccessorType(XmlAccessType.FIELD)
public class BodyReqAuth implements Serializable {
	
	private static final long	serialVersionUID	= 2257688156166956018L;
	
	private String user;
	
	private String pass;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BodyReqAuth [user=" + user + ", pass=" + pass + "]";
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}


}
