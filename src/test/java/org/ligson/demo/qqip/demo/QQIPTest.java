package org.ligson.demo.qqip.demo;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

/***
 * ip定位以后可以做
 * @author ligson
 *
 */
public class QQIPTest {
	static File qqwryFile = new File("./qqwry.dat");

	public void demo() throws Exception {
		FileInputStream fis = new FileInputStream(qqwryFile);
		byte[] header = new byte[8];
		fis.read(header);
		System.out.println(Arrays.toString(header));
		byte[] offsetBuffer = new byte[4];
		byte[] maxBuffer = new byte[4];
		System.arraycopy(header, 0, offsetBuffer, 0, 4);
		System.arraycopy(header, 4, maxBuffer, 0, 4);
		System.out.println(Arrays.toString(offsetBuffer));
		System.out.println(Arrays.toString(maxBuffer));

		long offset = new BigInteger(offsetBuffer).intValue();
		long max = new BigInteger(maxBuffer).intValue();

		System.out.println(offset);
		System.out.println(max);

		fis.close();
	}
	
	public static void locationBmc(IPSeeker ipSeeker) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.201:3306/rmsyin", "root", "bfrootpassword");
		PreparedStatement ps = connection.prepareStatement("SELECT cl.ip,count(cl.id) as clid FROM consumer_log cl group by cl.ip order by clid desc");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			String ip = rs.getString(1);
			int count = rs.getInt(2);
			String address = ipSeeker.getAddress(ip);
			if(!address.contains("局域网")&&!address.contains("保留地址用于本地回送")){
				System.out.println(address+"====="+ip+"============"+count);
			}
			
		}
		rs.close();
		connection.close();
	}

	public static void main(String[] args) throws Exception {
		IPSeeker ipSeeker = IPSeeker.getInstance(qqwryFile);
		System.out.println(ipSeeker.getAddress("125.88.219.96"));
		System.out.println(ipSeeker.getArea("125.88.219.96"));
		System.out.println(ipSeeker.getCountry("125.88.219.96"));
		locationBmc(ipSeeker);
	}
}
