package testorm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
/**
 * JDBC简单封装_资源文件properties处理连接信息
 * @author yang
 *
 */
public class JDBCUtil {
	static Properties pros = null;//可帮助读取和处理资源文件信息
	static{//加载JDBCUtil类时调用，只调用一次
		pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));//加载properties内容
		} catch (IOException e) {
			e.printStackTrace();
		}//这行代码固定写法
	}
	public static Connection getMysqlConn(){//获得Mysql连接
		try {
			Class.forName(pros.getProperty("mysqlDriver"));
			return DriverManager.getConnection(pros.getProperty("mysqlURL"),
					pros.getProperty("mysqlUser"),pros.getProperty("mysqlPwd"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Connection getOralceConn(){//获得Oracle连接
		try {
			Class.forName(pros.getProperty("oracleDriver"));
			return DriverManager.getConnection(pros.getProperty("oracleURL"),
					pros.getProperty("oracleUser"),pros.getProperty("oraclePwd"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(ResultSet rs,Statement st,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(st!=null){
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(Statement st,Connection conn){
		if(st!=null){
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
