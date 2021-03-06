package by.epamlab.beans.reservations;

import java.io.Serializable;
import java.util.List;

public class FareFamily implements Serializable {
	private static final long serialVersionUID = 1L;
	private String fareFamilyCode;
	private List<AncillaryAirComponent> ancillaryAirComponent;

	public FareFamily() {
	}

	public FareFamily(String fareFamilyCode, List<AncillaryAirComponent> ancillaryAirComponent) {
		this.fareFamilyCode = fareFamilyCode;
		this.ancillaryAirComponent = ancillaryAirComponent;
	}

	public String getFareFamilyCode() {
		return fareFamilyCode;
	}

	public void setFareFamilyCode(String fareFamilyCode) {
		this.fareFamilyCode = fareFamilyCode;
	}

	public List<AncillaryAirComponent> getAncillaryAirComponent() {
		return ancillaryAirComponent;
	}

	public void setAncillaryAirComponent(List<AncillaryAirComponent> ancillaryAirComponent) {
		this.ancillaryAirComponent = ancillaryAirComponent;
	}

}
