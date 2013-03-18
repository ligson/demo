package demo.test;

import org.apache.struts2.StrutsTestCase;
import org.apache.struts2.util.StrutsTestCaseHelper;
import org.junit.Test;

import com.opensymphony.xwork2.ActionProxy;

import demo.action.ModifyUserPicAction;

public class ModifyUserPicActionTest extends StrutsTestCase {

	@Test
	public void testExecute() throws Exception {
		ActionProxy proxy = null;
		ModifyUserPicAction test = null;
		request.setAttribute("uid", "02aa7178-e47c-4486-b75f-d91cf9084573");
		proxy = getActionProxy("/ModifyUserPicAction");
		test = (ModifyUserPicAction) proxy.getAction();
		String result = proxy.execute();
		assertEquals("success", result);
	}
}
