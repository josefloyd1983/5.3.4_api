/**
 * 
 */
package cl.liberty.model;

import java.io.Serializable;

/**
 * @author jgarrido
 *
 */
public class Property implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer propertyId;
	private Integer paisId;
	private Integer tipoPropertyId;
	private String name;
	private String description;
	private String value;
	private Integer status;
	private Integer padreId;
	
	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", paisId=" + paisId + ", tipoPropertyId=" + tipoPropertyId
				+ ", name=" + name + ", description=" + description + ", value=" + value + ", status=" + status
				+ ", padreId=" + padreId + "]";
	}

	public Integer getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	public Integer getPaisId() {
		return paisId;
	}

	public void setPaisId(Integer paisId) {
		this.paisId = paisId;
	}

	public Integer getTipoPropertyId() {
		return tipoPropertyId;
	}

	public void setTipoPropertyId(Integer tipoPropertyId) {
		this.tipoPropertyId = tipoPropertyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPadreId() {
		return padreId;
	}

	public void setPadreId(Integer padreId) {
		this.padreId = padreId;
	}
	
	
	
	

}
