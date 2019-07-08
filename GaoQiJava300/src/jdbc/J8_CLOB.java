package jdbc;

import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试CLOB 文本大对象的使用
 * 包含：将字符串，文件内容插入数据库中的CLOB字段，或将CLOB字段提取出来
 * @author yang
 */
public class J8_CLOB {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reader r = null;
		try {//加载驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");//驱动类加载到内存
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testJDBC","root","123456");
//			ps = conn.prepareStatement("insert into t_user(username,myInfo) values(?,?)");
//			ps.setString(1, "frank");
			//将文本文件内容直接输入到数据库
//				ps.setClob(2, new FileReader(new File("/Users/yang/Downloads/testBlob.txt")));
			//将程序中的字符串输入到数据库的CLOB中
//				ps.setClob(2, new BufferedReader(new InputStreamReader(new ByteArrayInputStream("aaaiiii".getBytes()))));
			//getBytes转为字节数组，ByteArrayInputStream转为输入流，InputStreamReader转为字符流，BufferedReader缓冲流
			
			//将CLOB数据读出来
			ps = conn.prepareStatement("select * from t_user where id = ?");
			ps.setObject(1, 20230);
			rs = ps.executeQuery();
			while(rs.next()){
				Clob c = rs.getClob("myInfo");//获取
				r = c.getCharacterStream();//通过流 读出来
				int temp=0;
				while((temp=r.read())!=-1){
					System.out.print((char)temp);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{//关闭顺序遵循resultset-->statement-->connection
			if(r!=null){
				try {
					r.close();
				} catch (Exception e) {
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
