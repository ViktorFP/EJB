package by.epamlab.beans.reservations.customer;

public class Phone {
	private boolean isDefault;
	private String phoneNumber;
	private String phoneType;
	private int sequence;
	private Status syncStatus;
	
	public Phone() {		
	}

	public Phone(String isDefault, String phoneNumber, String phoneType,
			String sequence, String syncStatus) {
		this.isDefault = Boolean.parseBoolean(isDefault);
		this.phoneNumber = phoneNumber;
		this.phoneType = phoneType;
		this.sequence = Integer.parseInt(sequence);
		this.syncStatus = Enum.valueOf(Status.class, syncStatus);
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public Status getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(Status syncStatus) {
		this.syncStatus = syncStatus;
	}
	
	
}
