package designmode.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 测试多线程环境下五种创建单例模式的效率
 * @author yang
 */
public class Singleton6 implements Serializable{//要使用反序列化方式创建多个对象必须实现Serializable接口
	//懒汉式：类初始化时，不初始化这个对象，延时加载，真正用的时候再创建
	private static Singleton6 instance;
	private Singleton6(){
		if(instance!=null){//方式通过反射跳过权限检查
			throw new RuntimeException();
		}
	}
	public static synchronized Singleton6 getInstance(){
		if(instance==null){
			instance = new Singleton6();
		}
		return instance;//如果不为空，就不新建对象了，直接返回原有对象
	}//由于初始化时instance并没有赋值，所以可能会有多线程同步问题，可能会创建多个实例，因此需要加上同步
	
	//反序列化时，如果定义了readResolve()，则直接返回此方法指定的对象，而不需单独创建新对象
	public Object readResolve() throws ObjectStreamException{
		return instance;
	}
}


