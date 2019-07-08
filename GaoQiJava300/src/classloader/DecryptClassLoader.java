package classloader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.output.ByteArrayOutputStream;
/**
 * 加载文件系统中加密后的class字节码的类加载器
 * @author yang
 *
 */
public class DecryptClassLoader extends ClassLoader{
	//比如给一个com.test.User -->会去d:/myjava/ 加载com/test/User.class
		private String rootDir;
		public DecryptClassLoader(String rootDir) {
			this.rootDir = rootDir;
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
//					e.printStackTrace();//如果父类加载不到，报异常
				}
				if(c!=null){
					return c;
				}else{
					byte[] classData = getClassData(name);//getClassData是自定义类，传入类名，转化为字节数组
					if(classData==null)
					{
						throw new ClassNotFoundException();
					}else{
						c = defineClass(name, classData,0, classData.length);
					}
				}
			}
			return c;
		}
		private byte[] getClassData(String classname){//比如传入com.test.User，转为d:/myjava/com/test/User.class
			String path = rootDir+"/"+classname.replace('.', '/')+".class";
			//可以使用IOUtils，使用它将流中的数据转成字节数组
			InputStream is=null;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try {
				is = new FileInputStream(path);
//				byte[] buffer = new byte[1024];
//				int temp = 0;
//				while((temp=is.read(buffer))!=-1){
//					baos.write(buffer,0,temp);
//				}
				//解密操作（取反）
				int temp = -1;
				while((temp=is.read())!=-1){
					baos.write(temp^0xff);//取反操作
				}
				return baos.toByteArray();
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
			
		}
}
