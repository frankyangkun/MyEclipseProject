package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 测试跟数据库建立连接
 * @author yang
 */
public class J1_Connection {
	public static void main(String[] args) {
		//加载驱动类
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//驱动类加载到内存
			long start = System.currentTimeMillis();
			//建立连接（连接对象内部包含了Socket对象，是一个远程的连接，比较耗时，这个Connection对象管理的一个要点！）
			//真正开发中，为了提高效率，都是使用连接池来管理连接对象！
//			Connection conn = DriverManager.getConnection("jdbc:mysql://131.10.10.54:3306/IOT","root","myanbu2017");//远程连接DB
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testJDBC","root","123456");
			long end = System.currentTimeMillis();
			System.out.println("建立连接，耗时："+(end-start)+"毫秒");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
