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
	private String var;

	public void setVar(String var) {
		this.var = var;
	}

	public int doStartTag() throws JspException {
		User user = (User) pageContext.getAttribute(Constants.USER,
				PageContext.SESSION_SCOPE);
<<<<<<< HEAD
		List<ResComponent> list = user.getReservation().getResComponents();
		pageContext.getRequest().setAttribute(Constants.COMPONENTS, list);
=======
		List<ResComponent> components = user.getReservation().getResComponent();
		pageContext.getRequest().setAttribute(var, components);
>>>>>>> master2
		return SKIP_BODY;
	}
}