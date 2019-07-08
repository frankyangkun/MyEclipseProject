package designmode.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 处理器接口
 * @author yang
 * InvocationHandler是处理器接口，关于流程处理的内容
 * 和对真实角色的代理访问都在这个类的invoke方法里处理
 */
public class StarHandler implements InvocationHandler{
	Star realStar;//真实角色
	public StarHandler(Star realStar) {
		this.realStar = realStar;
	}
	@Override//proxy：代理对象，method：代理对象的方法，args：代理对象方法的参数
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws Throwable {//用到了反射
		Object obj = null;
		System.out.println("真正的方法执行前!");
		System.out.println("面谈，签合同，预付款，订票");
		
		System.out.println("****");
		//只要是调代理类的任何方法，都会进这个方法，所以在这儿可做统一流程控制
		if(method.getName().equals("sing")){
			method.invoke(realStar, args);
		}
		System.out.println("真正的方法执行后！");
		System.out.println("收尾款");
		return obj;
	}
}
