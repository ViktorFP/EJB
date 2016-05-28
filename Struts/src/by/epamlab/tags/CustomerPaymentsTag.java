package by.epamlab.tags;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import by.epamlab.Constants;
import by.epamlab.beans.User;
import by.epamlab.beans.reservations.customer.Payment;

public class CustomerPaymentsTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {
		User user = (User) pageContext.getAttribute(Constants.USER,
				PageContext.SESSION_SCOPE);
		List<Payment> payments = user.getReservation().getCustomer()
				.getPayments();
		pageContext.getRequest().setAttribute(Constants.PAYMENTS, payments);
		return SKIP_BODY;
	}
}