                                                                                                                 package thread;

/**
 * 模拟购买火车票，使用同步方法（非同步块）实现
 * @author yang
 *
 */
public class T21_HappyWeb12306 {
	public static void main(String[] args) {
		Web12306 c = new Web12306(2,"happy");
		new Customer3(c,"frank",2).start();
		new Customer3(c,"jim",1).start();
	}
}
//顾客 作为代理（跟Thread一样），为Web12306做代理，把Customer3类当做Thread类用
class Customer3 extends Thread{
	int seats;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
	public Customer3(Runnable target,String name,int seats) {
		super(target,name);
		this.seats = seats;
	}
}
//火车票网
class Web12306 implements Runnable{
	int avaliable;//可用的位置
	String name;//名称
	public Web12306(int avaliable, String name) {
		super();
		this.avaliable = avaliable;
		this.name = name;
	}
	@Override
	public void run() {
		Customer3 c = (Customer3)Thread.currentThread();//当前线程强转成线程子类
		boolean flag = this.booTickets(c.seats);//转成子类后，就能获取子类属性c.seats了
		if(flag){
			System.out.println("出票成功"+Thread.currentThread().getName()+"购票数为："+c.seats);
		}else{
			System.out.println("出票失败"+Thread.currentThread().getName()+"位置不够！");
		}
	}
	//购票
	public synchronized boolean booTickets(int seats){
		System.out.println("欢迎光临"+this.name+"影院，可用位置为："+avaliable);
		if(seats>avaliable){
			return false;
		}
		//成功
		avaliable -= seats;
		return true;
	}
}