package dynamiccompile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class D1_Demo1 {
	public static void main(String[] args) throws Exception {
		JavaCompiler compile = ToolProvider.getSystemJavaCompiler();
		int result = compile.run(null,null,null,"/Users/yang/Downloads/test/dynamiccompiletest.java");
		System.out.println(result==0?"编译成功":"编译失败");
		
		String str = "public class Hi{public static void main(String[] args){System.out.print(\"haha.\");}}";
		//可以通过IO流操作，将字符串存储成一个临时文件（Hi.java），然后调用动态编译方法即可！！
		File file = new File("Hi.java");
		Writer writer = null;
		try {
			writer = new FileWriter(file);
			writer.write(str);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(writer!=null){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//动态编译
		JavaCompiler compile2 = ToolProvider.getSystemJavaCompiler();
		int result2 = compile2.run(null,null,null,"/Users/yang/Downloads/test/dynamiccompiletest.java");
		System.out.println(result2==0?"编译成功":"编译失败");
		//方法一：启动新进程 动态执行
//		Runtime run = Runtime.getRuntime();
//		Process process = run.exec("java -cp /Users/yang/Downloads/test		dynamiccompiletest");
//		InputStream in = process.getInputStream();//获得上面结果的输入流
//		BufferedReader bf = new BufferedReader(new InputStreamReader(in));//字符缓冲流BufferedReader
//		String info = "";
//		while((info = bf.readLine())!=null){
//			System.out.println(info);
//		}
		//方法二：使用反射调用编译好的类，要用到类加载器
		try{
			URL[] urls = new URL[]{new URL("file:/"+"Users/yang/Downloads/test/")};//注意Users前不要再加/，file:/已经有了
			URLClassLoader loader = new URLClassLoader(urls);
			Class c = loader.loadClass("dynamiccompiletest");
			//调用加载类的main方法
			Method m = c.getMethod("main", String[].class);//注意参数类型是String数组
			m.invoke(null, (Object)new String[] {});//如果有参数可以写比如new String[]{"aa","bb"}
			//由于可变参数是JDK5.0之后才有。如果不加(Object)，上面代码会编译成m.invoke(null,"aa","bb")，就会有参数不匹配问题。
			//因此必须加上(Object)转型，避免这个问题。
			//public static void mmm(String[] a,String[] b)
			//public static void main(String[] args)
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
