package org.ligson.designmode.structure.flyweight;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionPoolTest {

	public static void main(String[] args) throws Exception {
		String sql = "select id,name,phone from guestmessage";
		ConnectionPool pool = ConnectionPool.getInstance();
		for (int i = 0; i < 100; i++) {
			Connection conn = pool.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
			}
			rs.close();
			stmt.close();
			pool.release(conn);
		}
		pool.closePool();
	}
}