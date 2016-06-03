package by.epamlab.beans.reservations.customer;

public class Payment {
	private int amountPaid;
	private String formOfPaymentTypeCode;
	private String currencyCode;

	public Payment() {
	}

	public Payment(String amountPaid, String formOfPaymentTypeCode,
			String currencyCode) {
		setAmountPaid(Double.parseDouble(amountPaid));
		this.formOfPaymentTypeCode = formOfPaymentTypeCode;
		this.currencyCode = currencyCode;
	}

	public double getAmountPaid() {
		return amountPaid / 100;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = (int) (amountPaid * 100);
	}

	public String getFormOfPaymentTypeCode() {
		return formOfPaymentTypeCode;
	}

	public void setFormOfPaymentTypeCode(String formOfPaymentTypeCode) {
		this.formOfPaymentTypeCode = formOfPaymentTypeCode;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

}
