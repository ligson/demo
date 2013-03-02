package demo.action;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;

public class UploadTestAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7005301760152374320L;

	private File file;
	private String fileFileName;
	private String fileContentType;

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

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(getFileFileName());
		return SUCCESS;
	}

}
