package thread;
/**
 * 静态代理
 * 0、接口
 * 1、真实角色
 * 2、代理角色
 * @author yang
 */
public class T08_StaticProxy {
	public static void main(String[] args) {
		new WeddingCompany(new You()).happyMarry();//类似new Thread(new testClass()).start()
	}
}
interface Marry{//相当于Runnable接口
	void happyMarry();//相当于run方法
}
class You implements Marry{//相当于Runnable接口
	@Override
	public void happyMarry() {//相当于重写run方法
		System.out.println("结婚了。");
	}
}
//代理对象 
class WeddingCompany implements Marry{//相当于Thread类
	//真实角色
	private Marry target;//目标类对象
    public WeddingCompany(Marry target) {
		this.target = target;
	}
	@Override
	public void happyMarry() {//相当于重写run方法
		ready();//准备事宜  相当于start方法
		this.target.happyMarry();
		after();//后续事宜  相当于释放资源
	}
	private void ready(){//类似于Thread类中的start0，或者日志中的记录谁登录及时间
		System.out.println("准备事宜");
	}
	private void after(){//类似于释放资源，或日志中的谁退出及退出时间
		System.out.println("后续事宜");
	}
}