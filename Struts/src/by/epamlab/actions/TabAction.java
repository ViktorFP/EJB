package by.epamlab.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class TabAction extends DispatchAction {

	 public ActionForward reservationPage(ActionMapping mapping, ActionForm form,
		        HttpServletRequest request, HttpServletResponse response)
		        throws Exception {
		 return mapping.findForward("reservationPage");
	 }
	 
	 public ActionForward customerPage(ActionMapping mapping, ActionForm form,
		        HttpServletRequest request, HttpServletResponse response)
		        throws Exception {
		 return mapping.findForward("customerPage");
	 }
	 
	 public ActionForward fareFamilyPage(ActionMapping mapping, ActionForm form,
		        HttpServletRequest request, HttpServletResponse response)
		        throws Exception {
		 return mapping.findForward("fareFamilyPage");
	 }
}
