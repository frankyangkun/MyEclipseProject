package server;

import java.lang.reflect.InvocationTargetException;

/**
 * 反射：把java类中的各种结构（方法，属性，构造器，类名）映射成一个个java对象
 * 1、获取Class对象（三种方式）
 * 2、可动态创建对象
 * 3、有了对象就可分解了，比如获取名称，包名，方法
 * 
 * 对象.getConstructor().newInstance();
 * @author yang
 */
public class S1_ReflectTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, 
	IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		//三种方式
		//1、对象.getClass()
		IPhone iphone = new IPhone();
		Class clz = iphone.getClass();
		System.out.println(clz);//结果：class server.IPhone
		//2、类.class()
		clz = IPhone.class;
		System.out.println(clz);//结果同上
		//3、Class.forName("包名.类名")  用的最多
		clz = Class.forName("server.IPhone");
		System.out.println(clz);//结果同上
		
		//创建对象
		IPhone iphone2 = (IPhone)clz.newInstance();//过时了，jdk9不推荐，不安全
		System.out.println(iphone2);
		IPhone iphone3 = (IPhone)clz.getConstructor().newInstance();//通过构造器，推荐
		System.out.println(iphone3);
	}
}
class IPhone{
	public IPhone() {
	}
}