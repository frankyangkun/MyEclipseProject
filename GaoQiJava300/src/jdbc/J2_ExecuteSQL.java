package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试执行sql，及sql注入问题
 * @author yang
 */
public class J2_ExecuteSQL {
	public static void main(String[] args) {
		//加载驱动类
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//驱动类加载到内存
			//建立连接（连接对象内部包含了Socket对象，是一个远程的连接，比较耗时，这个Connection对象管理的一个要点！）
			//真正开发中，为了提高效率，都是使用连接池来管理连接对象！
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testJDBC","root","123456");
			stmt = conn.createStatement();//获得statement对象
//			String sql = "insert into t_user(username,pwd,regTime) values('frank3',123,now())";
//			stmt.executeUpdate(sql);//不知道为什么execute(sql)不能执行，一直卡住，第二天又可以执行exectue()了，应该是网络问题
			
			//测试sql注入
			String id = "5 or 1=1";
			String sql = "delete from t_user where id = "+id;
			stmt.execute(sql);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
