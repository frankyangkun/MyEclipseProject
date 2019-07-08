package reflection;
/**
 * 测试各种类型（class,interface,enum,annotation,primitive,void,type）java.lang.Class对象的获取方式
 * @author yang
 *
 */
public class R1_TestClass {
	public static void main(String[] args) {
		String path = "reflection.User";
		try {
			Class<?> clazz = Class.forName(path);//<?>是泛型的通配符，也可不加
			System.out.println(clazz+"==="+clazz.hashCode());//class reflection.User
			
			Class<?> clazz2 = Class.forName(path);
			System.out.println(clazz2+"==="+clazz.hashCode());//两个对象都是一样的地址，说明一个类只会生成一个类的对象（反射对象）
			
			Class strClazz = String.class;//获取String类的反射对象
			Class strClazz2 = path.getClass();
			System.out.println(strClazz==strClazz2);//true,因为path就是个字符串，也是String的对象，因此反射对象是相同的
			
			Class intClazz = int.class;//基本类型的Class对象也能够获取
			
			int [] arr01 = new int[10];
			int [] arr02 = new int[30];
			int [][] arr03 = new int [30][3];
			double [] d1 = new double[10];
			System.out.println(arr01.getClass().hashCode()==arr02.getClass().hashCode());//true
			System.out.println(arr01.getClass().hashCode()==arr03.getClass().hashCode());//false 维数不同
			System.out.println(arr01.getClass().hashCode()==d1.getClass().hashCode());//类型不同
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
