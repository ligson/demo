package demo.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() {
		// TODO Auto-generated method stub
		if(ActionContext.getContext().getSession().get("currentUser")!=null)
		{
			ActionContext.getContext().getSession().remove("currentUser");
		}
		return SUCCESS;
	}
	
}
