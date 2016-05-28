package by.epamlab.beans.reservations.customer;

public class Email {
	private boolean isDefault;
	private String emailAddress;
	private String emailType;
	private int sequence;
	private Status syncStatus;

	public Email() {
		
	}

	public Email(String isDefault, String emailAddress, String emailType,
			String sequence, Status syncStatus) {
		this.isDefault = Boolean.parseBoolean(isDefault);
		this.emailAddress = emailAddress;
		this.emailType = emailType;
		this.sequence = Integer.parseInt(sequence);
		this.syncStatus = syncStatus;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailType() {
		return emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
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
