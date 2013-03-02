package demo.action;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;

import demo.service.UserService;

public class ModifyUserPicAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5483664401276531396L;

	private File file; // 上传的文件
	private String fileFileName; // 文件名称
	private String fileContentType; // 文件类型
	private UserService userService;
	private String uid;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if (getFile() != null && getFileContentType() != null) {
			String contentType = getFileContentType();
			if (contentType.equalsIgnoreCase("application/x-bmp")
					|| contentType.equalsIgnoreCase("image/bmp")) {
				contentType = ".bmp";
			} else if (contentType.equalsIgnoreCase("application/x-jpg")
					|| contentType.equalsIgnoreCase("image/jpeg")||contentType.equalsIgnoreCase("image/pjpeg")) {
				contentType = ".jpg";
			} else if (contentType.equalsIgnoreCase("application/x-png")
					|| contentType.equalsIgnoreCase("image/png")) {
				contentType = ".png";
			} else {
				addFieldError("file", "file type only allow jpg,png,bmp!");
			}
		}
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("================================");
		if (file == null) {
			return "upload";
		}
		/*
		 * map.put("result", true); String base =
		 * ServletActionContext.getServletContext().getRealPath("/"); String[]
		 * files = getPicFileName().split(".");
		 * 
		 * String fileType = files[files.length-1];
		 * 
		 * File dest = new
		 * File(base+"/upload/tmp/"+UUID.randomUUID().toString()+"."+fileType);
		 * FileUtils.copyFile(pic,dest); map.put("fileName", dest.getName());
		 */
		if (getUid() != null) {
			userService.modifyUserPicById(file, getFileContentType(), getUid());
		} else {
			return ERROR;
		}
		System.out.println(file.getAbsolutePath());
		return SUCCESS;
	}

}
