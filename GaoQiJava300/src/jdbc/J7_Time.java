package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;

/**
 * 测试时间处理（java.sql.Date,Time,Timestamp）
 * @author yang
 */
public class J7_Time {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps1 = null;
		try {//加载驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");//驱动类加载到内存
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testJDBC","root","123456");
			for (int i = 0; i < 100; i++) {
				ps1 = conn.prepareStatement("insert into t_user(username,pwd,regTime,lastLoginTime) values(?,?,?,?)");
				ps1.setObject(1, "tom"+i);
				ps1.setObject(2, "2222");
				
				//随机时间
				int rand = 1000000000+ new Random().nextInt();//1000000000代表毫秒，如果要指定某一段时间内的随机，可以计算一下
				java.sql.Date date = new java.sql.Date(System.currentTimeMillis());//传入当前时间
				Timestamp stamp = new Timestamp(System.currentTimeMillis()-rand);//若要插入指定时间，可使用Calendar，DateFormat
				
				ps1.setDate(3, date);
				ps1.setTimestamp(4, stamp);
				ps1.execute();//插入后没有时分秒，如果表设计是Timestamp类型，结果是2019-05-16 00:00:00，都是默认的0
				//如果表设计是Date类型，结果就是2019-05-16
			}
			System.out.println("插入一个用户tom");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{//关闭顺序遵循resultset-->statement-->connection
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
