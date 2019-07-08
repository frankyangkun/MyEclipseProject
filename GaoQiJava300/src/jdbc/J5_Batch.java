package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试批处理的基本用法
 * @author yang
 */
public class J5_Batch {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {//加载驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");//驱动类加载到内存
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testJDBC","root","123456");
			conn.setAutoCommit(false);//事务设置为手动提交，关闭自动提交
			stmt = conn.createStatement();
			long start = System.currentTimeMillis();
			for (int i = 0; i < 20000; i++) {
				stmt.addBatch("insert into t_user(username,pwd,regTime) values('frank"+i+"',6666,now())");//注意现在是Statement，就不能用?占位符了
			}
			stmt.executeBatch();//执行批处理
			conn.commit();//提交事务
			long end = System.currentTimeMillis();
			System.out.println("插入2万条数剧耗时："+(end-start)+"毫秒");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{//关闭顺序遵循resultset-->statement-->connection
//注意3个if的try都要分开写，不要都写在1个try里，因为如果其中一个关闭遇到异常，就直接到catch了，就不会关闭另外2个了
			if(rs!=null){
				try {//try可以写到if外面，也可写在if里面，视频里是写外面的
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
