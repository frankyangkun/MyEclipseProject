package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 测试时间处理（java.sql.Date,Time,Timestamp）,取出指定时间段的数据
 * @author yang
 */
public class J7_Time2 {
	/**
	 * 将字符串代表的日期转为long数字(格式：yyyy-MM-dd hh:mm:ss)
	 * @param dateStr
	 * @return
	 */
	public static long str2Date(String dateStr){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			return format.parse(dateStr).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {//加载驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");//驱动类加载到内存
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testJDBC","root","123456");
			ps = conn.prepareStatement("select * from t_user where lastLoginTime > ? and lastLoginTime < ?");
			
//			java.sql.Date start = new java.sql.Date(str2Date("2019-4-29 0:00:00"));
//			java.sql.Date end = new java.sql.Date(str2Date("2019-5-5 12:11:11"));
			
			Timestamp start = new Timestamp(str2Date("2019-4-29 0:00:00"));
			Timestamp end = new Timestamp(str2Date("2019-5-5 12:11:11"));
			
			ps.setObject(1, start);
			ps.setObject(2, end);
			rs = ps.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getInt("id")+"---"+rs.getString("username")+"---"+rs.getTimestamp("lastLoginTime"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{//关闭顺序遵循resultset-->statement-->connection
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
