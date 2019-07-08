package designmode.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

import file.RealStar;

public class Client {
	public static void main(String[] args) {
		Star realStar = new RealStar();//真实角色
		StarHandler hanlder = new StarHandler(realStar);//处理器接口对象，它持有了realStar对象的属性方法
		//代理类对象，Proxy类是帮我们动态生成代理对象
		//参数1：类加载器就用系统默认的ClassLoader.getSystemClassLoader()
		//参数2：接口，这样动态生成的代理类对象就会自动实现这个接口，所以这里返回的对象类型是Star
		//参数3：每次通过Proxy生成代理类对象都要指定对应的处理器对象，我们这里就是handler
		Star proxy = (Star) Proxy.newProxyInstance(
				ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, hanlder);
		proxy.sing();
	}
}
