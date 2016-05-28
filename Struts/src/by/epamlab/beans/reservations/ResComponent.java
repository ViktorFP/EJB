package by.epamlab.beans.reservations;

public class ResComponent {
	private String componentTypeCode;
	private String createDateTime;
	private String internalStatus;
	private int sequence;

	public ResComponent() {
	}

	public ResComponent(String componentTypeCode, String createDateTime,
			String internalStatus, String sequence) {
		this.componentTypeCode = componentTypeCode;
		this.createDateTime = createDateTime;
		this.internalStatus = internalStatus;
		this.sequence = Integer.parseInt(sequence);
	}

	public String getComponentTypeCode() {
		return componentTypeCode;
	}

	public void setComponentTypeCode(String componentTypeCode) {
		this.componentTypeCode = componentTypeCode;
	}

	public String getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getInternalStatus() {
		return internalStatus;
	}

	public void setInternalStatus(String internalStatus) {
		this.internalStatus = internalStatus;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	@Override
	public String toString() {
		return sequence+" "+componentTypeCode
				+ " " + createDateTime + " "
				+ internalStatus;
	}

}
