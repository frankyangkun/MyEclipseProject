package designmode.singleton;
/**
 * 测试枚举式实现单例模式
 * 枚举避免了反射和反序列化的漏洞
 * 唯一缺点就是没有延时加载的效果
 * @author yang
 */
public enum Singleton5 {//枚举类的缩写enum，就不用class了
	INSTANCE;//通过Singleton5.INSTANCE就可以获取了，枚举元素本身就是单例对象
	
	//可添加自己需要的针对单例对象的操作
	public void singletonOper(){
	}
}
