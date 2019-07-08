package testorm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试使用Object[]来封装一条记录
 * 使用List<Object[]>存储多条记录
 * @author yang
 */
public class T01_ObjectORM {
	public static void main(String[] args) {
		Connection conn = JDBCUtil.getMysqlConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Object[]> list = new ArrayList<Object[]>();//用数组保存查询的信息，即使连接关闭了也可以操作信息
		try {
			ps = conn.prepareStatement("select empname,salary,age from emp where id > ?");//查了3列
			ps.setObject(1, 1);
			rs = ps.executeQuery();
			while(rs.next()){
				Object [] objs = new Object[3];//Object数组要定义在while里面！！一个Object数组封装了一条记录的信息
//				System.out.println(rs.getString(1)+"---"+rs.getDouble(2)+"---"+rs.getInt(3));
				objs[0] = rs.getString(1);
				objs[1] = rs.getObject(2);
				objs[2] = rs.getObject(3);
				
				list.add(objs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs,ps,conn);
		}
		for (Object[] objs : list) {
			System.out.println(objs[0]+"---"+objs[1]+"---"+objs[2]);//连接关闭了同样可以获得信息
		}
	}
}
