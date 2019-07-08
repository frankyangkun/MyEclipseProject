package classloader;
/**
 * 测试自定义FileSystemClassLoader
 * @author yang
 *
 */
public class Demo03 {
	public static void main(String[] args) throws ClassNotFoundException {
		FileSystemClassLoader loader = new FileSystemClassLoader("/Users/yang/Downloads/test");//以这个目录为基准，加载下面的类
		FileSystemClassLoader loader2 = new FileSystemClassLoader("/Users/yang/Downloads/test");
		
		Class<?> c = loader.loadClass("hello");
		Class<?> c2 = loader.loadClass("hello");
		Class<?> c3 = loader2.loadClass("hello");
		
		Class<?> c4 = loader2.loadClass("java.lang.String");
		Class<?> c5 = loader2.loadClass("classloader.Demo01");
		
		System.out.println(c.hashCode());//1639705018
		System.out.println(c2.hashCode());//1639705018 因为是同一个类加载器，所以加载的是同一个类
		System.out.println(c3.hashCode());//同一个类，被不同加载器加载，JVM认为也是不同的类
		System.out.println(c4.hashCode());//很显然，系统类也是可以加载的
		
		System.out.println(c4.getClassLoader());//null，引导类加载器
		System.out.println(c3.getClassLoader());//classloader.FileSystemClassLoader@61bbe9ba 自定义类加载器
		System.out.println(c5.getClassLoader());//sun.misc.Launcher$AppClassLoader@2a139a55 系统默认类加载器

		
	}
}
