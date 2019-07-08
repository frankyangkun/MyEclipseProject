package designmode.prototype;
/**
 * 测试普通new方式创建对象和clone方式创建对象的效率差异
 * 如果需要短时间创建大量对象，且new的过程比较耗时，则可以考虑原型模式
 * Spring框架里对象创建就2种模式，单例和原型（当然，原型模式需要和工厂模式搭配，工厂底层是new方式创建）
 * @author yang
 */
public class Client4 {
	public static void testNew(int size){
		long start = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			Laptop t = new Laptop();//通过new方式获得对象
		}
		long end = System.currentTimeMillis();
		System.out.println("new的方式创建耗时："+(end-start));
	}
	
	public static void testClone(int size) throws CloneNotSupportedException{
		long start = System.currentTimeMillis();
		Laptop t = new Laptop();//原型对象
		for (int i = 0; i < size; i++) {
			Laptop temp = (Laptop) t.clone();//通过克隆方式获得对象
		}
		long end = System.currentTimeMillis();
		System.out.println("克隆的方式创建耗时："+(end-start));
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		testNew(1000);
		testClone(1000);
	}
}

class Laptop implements Cloneable{
	public Laptop() {//无参构造器
		try {
			Thread.sleep(10);//模拟在初始化Laptop类的时候很耗时的过程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();//直接调用object对象的clone()方法！
		return obj;
	}
}
