package by.epamlab.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import by.epamlab.Constants;
import by.epamlab.beans.User;
import by.epamlab.beans.reservations.customer.Email;

public class CustomerEmailTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	private String var;

	public void setVar(String var) {
		this.var = var;
	}
	
	public int doStartTag() throws JspException {
		User user = (User) pageContext.getAttribute(Constants.USER,
				PageContext.SESSION_SCOPE);
		Email email = user.getReservation().getCustomer().getEmail();
		pageContext.getRequest().setAttribute(var, email);
		return SKIP_BODY;
	}
}