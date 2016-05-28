package by.epamlab.tags;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import by.epamlab.Constants;
import by.epamlab.beans.User;
import by.epamlab.beans.reservations.ResComponent;

public class ComponentCodeTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {
		User user = (User) pageContext.getAttribute(Constants.USER,
				PageContext.SESSION_SCOPE);
		List<ResComponent> list = user.getReservation().getResComponent();
		pageContext.getRequest().setAttribute(Constants.COMPONENTS, list);
		return SKIP_BODY;
	}
}