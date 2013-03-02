package demo.util;

import org.springframework.beans.factory.InitializingBean;

public class SystemInit implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("http://127.0.0.1:8080/demo");
	}

}
