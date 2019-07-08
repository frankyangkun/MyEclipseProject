package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试事务
 * @author yang
 */
public class J6_Transaction {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try {//加载驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");//驱动类加载到内存
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testJDBC","root","123456");
			
			conn.setAutoCommit(false);//JDBC中默认是自动提交事务的true
			ps1 = conn.prepareStatement("insert into t_user(username,pwd) values(?,?)");
			ps1.setObject(1, "tom");
			ps1.setObject(2, "2222");
			ps1.execute();//执行事务
			System.out.println("插入一个用户tom");
			try {
				Thread.sleep(2000);//间隔一会儿，便于观察
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ps2 = conn.prepareStatement("insert into t_user(username,pwd) values(?,?,?)");//传了3个参数，故意失败
			ps2.setObject(1, "tom2");
			ps2.setObject(2, "2222");
			ps2.execute();//执行事务
			System.out.println("插入一个用户tom2");
			conn.commit();//提交事务
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			try {
				conn.rollback();//遇到异常回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{//关闭顺序遵循resultset-->statement-->connection
//注意3个if的try都要分开写，不要都写在1个try里，因为如果其中一个关闭遇到异常，就直接到catch了，就不会关闭另外2个了
			if(ps1!=null){
				try {
					ps1.close();
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
