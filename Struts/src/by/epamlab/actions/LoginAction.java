package by.epamlab.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import by.epamlab.Constants;
import by.epamlab.beans.User;
import by.epamlab.beans.ifaces.IUserDAO;
import by.epamlab.factories.UserFactory;
import by.epamlab.forms.LoginForm;

public class LoginAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoginForm loginForm = (LoginForm) form;
		IUserDAO userDAO = UserFactory.getClassFromFactory();
		User user = userDAO.getUser(loginForm.getUserName(),
				loginForm.getPassword());
		if (user != null) {
			// set this user to session scope
			request.getSession().setAttribute(Constants.USER, user);
			return mapping.findForward("success");
		} else {
			return mapping.findForward("failure");
		}
	}
}
