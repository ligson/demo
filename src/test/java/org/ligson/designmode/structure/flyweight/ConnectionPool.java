package org.ligson.designmode.structure.flyweight;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @author liuzhongbing
 * 享元模式 - 连接池实例
 */
public class ConnectionPool {

    private Vector<Connection> pool;

    private String url = "jdbc:mysql://localhost:3306/test";
    private String username = "root";
    private String password = "";
    private String driverClassName = "com.mysql.jdbc.Driver";

    /**
     * 连接池的大小，也就是连接池中有多少个数据库连接。
     */
    private int poolSize = 100;

    private static ConnectionPool instance = null;

    /**
     * 私有的构造方法，禁止外部创建本类的对象，要想获得本类的对象，通过<code>getIstance</code>方法。
     * 使用了设计模式中的单子模式。
     */
    private ConnectionPool() {
        pool = new Vector<Connection>(poolSize);
        // 在连接池中创建初始设置的的数据库连接
        Connection conn = null;
        for (int i = 0; i < poolSize; i++) {
            try {
                Class.forName(driverClassName);
                conn = java.sql.DriverManager.getConnection(url, username, password);
                pool.add(conn);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
	}
    
    /**
     * 返回连接到连接池中
     */
    public synchronized void release(Connection conn) {
        pool.add(conn);
    }

    /**
     * 关闭连接池中的所有数据库连接
     */
    public synchronized void closePool() {
        for (int i = 0; i < pool.size(); i++) {
            try {
                ((Connection) pool.get(i)).close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            pool.remove(i);
        }
    }

    /**
     * 返回当前连接池的一个对象
     */
    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    /**
     * 返回连接池中的一个数据库连接
     */
    public synchronized Connection getConnection() { 
        if (pool.size() > 0) {
            Connection conn = pool.get(0);
            pool.remove(conn);
            return conn;
        } else {
            return null;
        }
    }
}

