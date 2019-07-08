package jdbc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试BLOB 二进制对象的使用
 * @author yang
 */
public class J9_BLOB {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		InputStream r = null;//CLOB用Reader，BLOB因为是二进制，所以用InputStream
		OutputStream os = null;
		try {//加载驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");//驱动类加载到内存
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testJDBC","root","123456");
			//将二进制大对象数据(BLOB)存到数据库
//			ps = conn.prepareStatement("insert into t_user(username,headerImag) values(?,?)");
//			ps.setString(1, "frank");
//			ps.setBlob(2, new FileInputStream("/Users/yang/Pictures/ME2.jpg"));//图片不能太大
//			ps.execute();//存入成功
			
			//将文本文件内容直接输入到数据库
//			ps.setClob(2, new FileReader(new File("/Users/yang/Downloads/testBlob.txt")));
			//将程序中的字符串输入到数据库的CLOB中
//			ps.setClob(2, new BufferedReader(new InputStreamReader(new ByteArrayInputStream("aaaiiii".getBytes()))));
			//getBytes转为字节数组，ByteArrayInputStream转为输入流，InputStreamReader转为字符流，BufferedReader缓冲流
			
			
			//将CLOB数据读出来
//			ps = conn.prepareStatement("select * from t_user where id = ?");
//			ps.setObject(1, 20230);
//			rs = ps.executeQuery();
//			while(rs.next()){
//				Clob c = rs.getClob("myInfo");//获取
//				r = c.getCharacterStream();//通过流 读出来
//				int temp=0;
//				while((temp=r.read())!=-1){
//					System.out.print((char)temp);
//				}
//			}
			//将数据库中的BLOB信息读取出来
			ps = conn.prepareStatement("select * from t_user where id = ?");
			ps.setObject(1, 20231);
			rs = ps.executeQuery();
			while(rs.next()){//控制台无法打印二进制图片信息，乱码，定义个输出流OutputStream
				Blob b = rs.getBlob("headerImag");//获取  注意是java.sql.Blob;不是com.mysql.cj.jdbc.Blob;
				r = b.getBinaryStream();//通过流 读出来
				os = new FileOutputStream("/Users/yang/Downloads/mecopy.jpg");
				int temp=0;
				while((temp=r.read())!=-1){
//					System.out.print((char)temp);//由于图片是二进制信息，所以打印的是乱码
					os.write(temp);
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
			if(os!=null){
				try {
					os.close();
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
