package demo.util;

import java.io.File;

import org.springframework.beans.factory.InitializingBean;

public class SystemInit implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		String userdir = System.getProperty("user.dir");
		File file = new File(userdir,".demo");
		if(!file.exists()){
			file.mkdirs();
		}
		File dbFile = new File(file,"demodb");
		if(!dbFile.exists()){
			dbFile.createNewFile();
		}
		System.out.println("http://127.0.0.1:8080/demo");
	}

}
