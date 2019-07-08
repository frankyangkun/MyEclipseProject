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
 * 测试使用Map来封装一条记录
 * 使用List<Map>存储多条记录
 * @author yang
 */
public class T02_MapORM {
	
	public static void test01(){
		Connection conn = JDBCUtil.getMysqlConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Map<String,Object> row = new HashMap<>();//使用1个map封装1条记录
		try {
			ps = conn.prepareStatement("select empname,salary,age from emp where id = ?");//查了3列
			ps.setObject(1, 1);
			rs = ps.executeQuery();
			while(rs.next()){
//				System.out.println(rs.getString(1)+"---"+rs.getDouble(2)+"---"+rs.getInt(3));
				row.put("empname", rs.getObject(1));
				row.put("salary", rs.getObject(2));
				row.put("age", rs.getObject(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs,ps,conn);
		}
		//遍历map，就是遍历这一行的多列信息
		for (String key : row.keySet()) {
			System.out.print(key+"---"+row.get(key)+"\t");
		}
	}
	public static void test02(){
		Connection conn = JDBCUtil.getMysqlConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String,Object>> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement("select empname,salary,age from emp where id > ?");//查了3列
			ps.setObject(1, 1);
			rs = ps.executeQuery();
			while(rs.next()){
				Map<String,Object> row = new HashMap<>();//使用1个map封装1条记录
//				System.out.println(rs.getString(1)+"---"+rs.getDouble(2)+"---"+rs.getInt(3));
				row.put("empname", rs.getObject(1));
				row.put("salary", rs.getObject(2));
				row.put("age", rs.getObject(3));
				list.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs,ps,conn);
		}
		//遍历map，就是遍历这一行的多列信息
		for (Map<String, Object> row : list) {//外面是遍历List
			for (String key : row.keySet()) {//里面是遍历Map
				System.out.print(key+"---"+row.get(key)+"\t");
			}
			System.out.println();
		}
	}
	public static void test03(){
		Connection conn = JDBCUtil.getMysqlConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String,Map<String,Object>> maps = new HashMap<>();
		try {
			ps = conn.prepareStatement("select empname,salary,age from emp where id > ?");//查了3列
			ps.setObject(1, 1);
			rs = ps.executeQuery();
			while(rs.next()){
				Map<String,Object> row = new HashMap<>();//使用1个map封装1条记录
//				System.out.println(rs.getString(1)+"---"+rs.getDouble(2)+"---"+rs.getInt(3));
				row.put("empname", rs.getObject(1));
				row.put("salary", rs.getObject(2));
				row.put("age", rs.getObject(3));
				
				maps.put(rs.getString(1),row);//用真实的名字作为key
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs,ps,conn);
		}
		//遍历map，就是遍历这一行的多列信息
		for (String empname:maps.keySet()) {//外面是遍历Map
			Map<String,Object> row = maps.get(empname);//一条记录
			for (String key : row.keySet()) {//里面也是遍历Map 一条记录的多列
				System.out.print(key+"---"+row.get(key)+"\t");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		test03();
	}
}
