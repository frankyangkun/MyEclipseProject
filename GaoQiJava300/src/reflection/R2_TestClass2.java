package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用反射的api，获取类的信息（类名，方法，属性，构造器等）
 * @author yang
 *
 */
public class R2_TestClass2 {
	public static void main(String[] args) {
		String path = "reflection.User";
		try {
			Class clazz = Class.forName(path);
			//获取类名
			System.out.println(clazz.getName());//reflection.User
			System.out.println(clazz.getSimpleName());//User
			
			//获取属性信息
			Field[] fields = clazz.getFields();
			Field[] fields2 = clazz.getDeclaredFields();
			Field field = clazz.getDeclaredField("age");
			System.out.println(fields.length);//0,只能获取public属性
			System.out.println(fields2.length);//3，返回所有属性
			for (Field temp : fields2) {
				System.out.println("属性："+temp);
			}
			System.out.println(field.getName());
			
			//获取方法信息
			Method[] methods = clazz.getDeclaredMethods();
			Method m =clazz.getDeclaredMethod("getAge", null);
			Method m2 =clazz.getDeclaredMethod("setAge", int.class);//参数2是参数类型对应的Class对象，因为可能有重载的方法，只传名字可能无法区分
			for (Method temp : methods) {
				System.out.println("方法："+temp);
			}
			
			//获取构造器信息
			Constructor[] c = clazz.getConstructors();//所有公开构造器
			Constructor[] c2 = clazz.getDeclaredConstructors();
			Constructor c3 = clazz.getDeclaredConstructor(null);//获取无参构造器
			Constructor c4 = clazz.getDeclaredConstructor(String.class,int.class,String.class);//获取有参构造器
			System.out.println(c3);
			System.out.println(c4);
			for (Constructor temp : c2) {
				System.out.println("构造器："+temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
