package demo.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.struts2.ServletActionContext;

import demo.dao.UserDao;
import demo.domain.User;
import demo.service.MailService;
import demo.service.UserService;
import demo.util.DateUtils;

@WebService(endpointInterface = "demo.service.UserService",   
           serviceName = "demoUserService") 

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	private MailService mailService;

	public MailService getMailService() {
		return mailService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	@Override
	public String register(User user) {
		return userDao.add(user);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean nameIsUnique(String name) {
		return userDao.propertyIsUnique("name", name);
	}

	@Override
	public List<User> list(int offset, int max) {
		// TODO Auto-generated method stub
		return userDao.findAllBy(null, null, offset, max);
	}

	@Override
	public boolean login(String name, String password) {
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<String>();
		names.add("name");
		names.add("password");

		List<Object> values = new ArrayList<Object>();
		values.add(name);
		values.add(password);

		User user = userDao.findByAnd(names, values);

		return user != null;

	}

	@Override
	public long countUsers() {
		// TODO Auto-generated method stub
		return userDao.countBy(null, null);
	}

	@Override
	public User getUserById(String uid) {
		// TODO Auto-generated method stub
		return userDao.getById(uid);
	}

	@Override
	public void modify(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

	@Override
	public void removeUserById(String uid) {
		// TODO Auto-generated method stub
		User user = userDao.getById(uid);
		userDao.delete(user);
	}

	@Override
	public User getUserByNameAndPassword(String name, String password) {
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<String>();
		List<Object> values = new ArrayList<Object>();

		names.add("name");
		names.add("password");
		values.add(name);
		values.add(password);
		return userDao.findByAnd(names, values);
	}

	@Override
	public void modifyUserPicById(File file, String contentType, String uid) {
		// TODO Auto-generated method stub

		HttpServletRequest request = ServletActionContext.getRequest();

		// application/x-bmp,application/x-jpg,image/jpeg,application/x-png,image/png

		if (contentType.equalsIgnoreCase("application/x-bmp")
				|| contentType.equalsIgnoreCase("image/bmp")) {
			contentType = ".bmp";
		} else if (contentType.equalsIgnoreCase("application/x-jpg")
				|| contentType.equalsIgnoreCase("image/jpeg")) {
			contentType = ".jpg";
		} else if (contentType.equalsIgnoreCase("application/x-png")
				|| contentType.equalsIgnoreCase("image/png")) {
			contentType = ".png";
		} else {
			throw new RuntimeException("file type error!");
		}
		String destName = "upload/user/" + UUID.randomUUID().toString()
				+ contentType;
		File dest = new File(request.getRealPath("/"), destName);
		try {
			FileUtils.copyFile(file, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(request.getContextPath());
		System.out.println(request.getRealPath("/"));
		userDao.updateProperty("pic", destName, uid);
	}

	@Override
	public File buildExcel(List<User> users) {
		try {

			HSSFWorkbook workbook = new HSSFWorkbook();
			Sheet sheet = workbook.createSheet();
			Row row = sheet.createRow(0);
			row.setHeight((short) 50);

			HSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			cellStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);

			HSSFFont fontStyle = workbook.createFont();
			fontStyle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			cellStyle.setFont(fontStyle);

			Cell cell1 = row.createCell(0);
			Cell cell2 = row.createCell(1);
			Cell cell3 = row.createCell(2);
			Cell cell4 = row.createCell(3);
			Cell cell5 = row.createCell(4);

			cell1.setCellValue("ID");
			cell2.setCellValue("姓名");
			cell3.setCellValue("性别");
			cell4.setCellValue("出生日期");
			cell5.setCellValue("email");

			cell1.setCellStyle(cellStyle);
			cell2.setCellStyle(cellStyle);
			cell3.setCellStyle(cellStyle);
			cell4.setCellStyle(cellStyle);
			cell5.setCellStyle(cellStyle);

			int i = 1;
			for (User user : users) {
				Row _row = sheet.createRow(i++);
				Cell _cell1 = _row.createCell(0);
				Cell _cell2 = _row.createCell(1);
				Cell _cell3 = _row.createCell(2);
				Cell _cell4 = _row.createCell(3);
				Cell _cell5 = _row.createCell(4);

				_cell1.setCellValue(user.getId());
				_cell2.setCellValue(user.getName());
				_cell3.setCellValue(user.isSex() ? "男" : "女");
				_cell4.setCellValue(DateUtils.dateTextToFormat(user.getBirth(),
						"yyyyMMddHHmmss", "yyyy-MM-dd"));
				_cell5.setCellValue(user.getEmail());
			}

			File file = File.createTempFile("user", "xls");
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
			fileOutputStream.close();
			return file;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void sendMail(User currentUser, String receiverId) {
		User receiver = userDao.getById(receiverId);
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("username",receiver.getName());
		params.put("email",currentUser.getEmail());
		mailService.sendMail(currentUser, receiver, "ModifyPassword.html", params);
	}

}
