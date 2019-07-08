package testorm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试使用JavaBean对象来封装一条记录
 * 使用List<JavaBean>存储多条记录或Map
 * @author yang
 */
public class T03_JavaBeanORM {
	public static void test01(){
		Connection conn = JDBCUtil.getMysqlConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Emp emp = null;//javabean对象
		try {
			ps = conn.prepareStatement("select empname,salary,age from emp where id = ?");//查了3列
			ps.setObject(1, 1);
			rs = ps.executeQuery();
			while(rs.next()){
//				System.out.println(rs.getString(1)+"---"+rs.getDouble(2)+"---"+rs.getInt(3));
//				row.put("empname", rs.getObject(1));
//				row.put("salary", rs.getObject(2));
//				row.put("age", rs.getObject(3));
				emp = new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs,ps,conn);
		}
		//遍历map，就是遍历这一行的多列信息
//		for (String key : row.keySet()) {
//			System.out.print(key+"---"+row.get(key)+"\t");
//		}
		System.out.println(emp.getEmpname()+"---"+emp.getSalary()+"---"+emp.getAge());
	}
	public static void test02(){
		Connection conn = JDBCUtil.getMysqlConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
//		List<Map<String,Object>> list = new ArrayList<>();
		List<Emp> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement("select empname,salary,age from emp where id > ?");//查了3列
			ps.setObject(1, 1);
			rs = ps.executeQuery();
			while(rs.next()){
//				Map<String,Object> row = new HashMap<>();//使用1个map封装1条记录
////				System.out.println(rs.getString(1)+"---"+rs.getDouble(2)+"---"+rs.getInt(3));
//				row.put("empname", rs.getObject(1));
//				row.put("salary", rs.getObject(2));
//				row.put("age", rs.getObject(3));
				Emp emp = new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));
//				list.add(row);
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs,ps,conn);
		}
		//遍历map，就是遍历这一行的多列信息
//		for (Map<String, Object> row : list) {//外面是遍历List
//			for (String key : row.keySet()) {//里面是遍历Map
//				System.out.print(key+"---"+row.get(key)+"\t");
//			}
//			System.out.println();
//		}
		for (Emp emp : list) {//外面是遍历List
			System.out.println(emp.getEmpname()+"---"+emp.getSalary()+"---"+emp.getAge());
		}
	}
	
	public static void main(String[] args) {
		test02();
	}
}
