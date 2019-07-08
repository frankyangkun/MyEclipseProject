package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射api调用构造方法，属性，构造对象
 * @author yang
 */
public class R2_TestClass3 {
	public static void main(String[] args) {
		String path = "reflection.User";
		try {
			Class<User> clazz = (Class<User>) Class.forName(path);//指定泛型，下面就不用强转类型了
			//通过反射api调用构造方法，构造对象
			User u = clazz.newInstance();//其实是调用了User的无参构造方法，框架中常会有这类用法，所有bean中一定要有无参构造器
			System.out.println(u.getName()+u.getAge()+u.getSex());//null0null,因为是无参构造器
			
			//使用有参构造器
			Constructor<User> c = clazz.getDeclaredConstructor(String.class,int.class,String.class);
			User u2 = c.newInstance("frank",18,"男");//现在构造出的就是有参的对象
			System.out.println(u2.getName()+u2.getAge()+u2.getSex());//frank18男
			
			//通过反射api调用普通方法
			User u3 = clazz.newInstance();
//			u3.setAge(30);
			Method method = clazz.getDeclaredMethod("setAge", int.class);//获得方法
			method.invoke(u3, 30);//invoke是调用的意思
			//相当于直接写u3.setAge(30);好处在于动态，因为方法名和参数都是字符串，可从文件，数据库，浏览器，等渠道获取
			System.out.println(u3.getAge());//30,设置成功
			
			//通过反射api操作属性
			User u4 = clazz.newInstance();
			Field f = clazz.getDeclaredField("name");//获取属性
			f.setAccessible(true);//这个属性不用做安全检查了，可以直接访问，可用于方法和属性，必须在set前
			f.set(u4, "tom");//通过反射直接写属性的值
			System.out.println(u4.getName());//如果没有setAccessible，不能访问私有属性，报错
			System.out.println(f.get(u4));//获取u4的f属性值，tom，上面是直接调用，这里是通过反射调用，本质一样
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
