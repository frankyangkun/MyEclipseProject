package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 测试PreparedStatement基本用法
 * @author yang
 */
public class J3_PreparedStatement {
	public static void main(String[] args) {
		//加载驱动类
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//驱动类加载到内存
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testJDBC","root","123456");

			String sql = "insert into t_user(username,pwd,regTime) values (?,?,now())";//?是占位符，有预处理机制，可以防止sql注入
			ps = conn.prepareStatement(sql);
//			ps.setString(1, "张三");//参数索引从1开始，而Hibernate是从0开始算的
//			ps.setString(2, "123456");//也可不管类型，使用setObject()
//			ps.execute();
			Date time = new Date(System.currentTimeMillis());
			System.out.println(time);
			ps.setObject(1, "王五2");
			ps.setObject(2, "123456");
//			ps.setObject(3, time);//注意，jdbc中的时间是导java.sql.Date包
			ps.execute();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(ps!=null){
				try {
					ps.close();
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
