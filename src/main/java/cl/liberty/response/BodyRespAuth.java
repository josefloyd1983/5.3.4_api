/**
 * @name BodyResp.java 
 * 
 * @version 1.0 
 * 
 * @date 4 mar. 2018 
 * 
 * @author JOSELUIS 
 * 
 * @copyright Aligare Consultores. All rights reserved.
 */
package cl.liberty.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import cl.liberty.constantes.Constantes;
import cl.liberty.model.Data;

/**
 * @description    
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement(name = Constantes.BODY)
@XmlAccessorType(XmlAccessType.FIELD)
public class BodyRespAuth implements Serializable {

	private static final long	serialVersionUID	= 6695883932484057201L;
	
	private int code;
	
	private String message;
	
	private String date;
	
	private Data data;

	@Override
	public String toString() {
		return "BodyRespAuth [code=" + code + ", message=" + message + ", date=" + date + ", data=" + data + "]";
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
	
	

	

	
	
	
}
