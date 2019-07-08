package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试ResultSet结果集的基本用法
 * 它的用法可以很复杂，ResultSet接口的方法很多，我们掌握基本的即可
 * @author yang
 */
public class J4_ResultSet {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {//加载驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");//驱动类加载到内存
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testJDBC","root","123456");
			String sql = "select * from t_user where id>?";//?占位符
			ps = conn.prepareStatement(sql);
			ps.setObject(1, 17);//把id大于17的都记录下来
			rs = ps.executeQuery();
			while(rs.next()){//getInt(1)表示第一列
				System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getString(3));
			}
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
