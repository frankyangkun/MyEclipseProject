package classloader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.output.ByteArrayOutputStream;
/**
 * 自定义网络类加载器
 * @author yang
 *
 */
public class NetClassLoader2 extends ClassLoader{
	//比如给一个网络地址www.sxt.cn/myjava/ 会加载下面的类
//	private String rootDir;
	private String rootUrl;
	public NetClassLoader2(String rootUrl) {
		this.rootUrl = rootUrl;
	}
	
	//重写findClass方法
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c = findLoadedClass(name);//类型不确定，泛型就写问号
		if(c!=null){//应该先查询是否加载过此类，如果存在，说明已经加载，直接返回，否则加载新的类
			return c;
		}else{
			ClassLoader parent = this.getParent();
			try {
				c = parent.loadClass(name);//委派给父类加载
			} catch (Exception e) {
//				e.printStackTrace();//如果父类加载不到，报异常
			}
			if(c!=null){
				return c;
			}else{
				byte[] classData = getClassData(name);//getClassData是自定义类，传入类名，转化为字节数组
				if(classData==null){
					throw new ClassNotFoundException();
				}else{
					c = defineClass(name, classData,0, classData.length);
				}
			}
		}
		return c;
	}
	private byte[] getClassData(String classname){//比如传入com.test.User，转为d:/myjava/com/test/User.class
		String path = rootUrl+"/"+classname.replace('.', '/')+".class";
		//可以使用IOUtils，使用它将流中的数据转成字节数组
		InputStream is=null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			URL url = new URL(path);//获得url对象
//			is = new FileInputStream(path);//现在就不需要打开文件输入流对象了
			is = url.openStream();//根据url打开一个输入流
			byte[] buffer = new byte[1024];
			int temp = 0;
			while((temp=is.read(buffer))!=-1){
				baos.write(buffer,0,temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(baos!=null){
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return baos.toByteArray();
	}
}
