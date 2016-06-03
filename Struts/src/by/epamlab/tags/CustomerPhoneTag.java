package by.epamlab.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import by.epamlab.Constants;
import by.epamlab.beans.User;
import by.epamlab.beans.reservations.customer.Phone;

public class CustomerPhoneTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	private String var;

	public void setVar(String var) {
		this.var = var;
	}

	public int doStartTag() throws JspException {
		User user = (User) pageContext.getAttribute(Constants.USER,
				PageContext.SESSION_SCOPE);
		Phone phone = user.getReservation().getCustomer().getPhone();
		pageContext.getRequest().setAttribute(var, phone);
		return SKIP_BODY;
	}
}