package thread;
/**
 * 模拟多人购票
 * @author yang
 *
 */
public class T21_HappyCinema {
	public static void main(String[] args) {
		Cinema c = new Cinema(3,"happy");
		new Thread(new Customer(c,2),"frank").start();
		new Thread(new Customer(c,1),"tom").start();
		new Thread(new Customer(c,1),"jerry").start();
	}
}
//顾客
class Customer implements Runnable{
	Cinema cinema;
	int seats;
	public Customer(Cinema cinema, int seats) {
		super();
		this.cinema = cinema;
		this.seats = seats;
	}
	@Override
	public void run() {
		synchronized (cinema) {
			boolean flag = cinema.booTickets(seats);
			if(flag){
				System.out.println("出票成功"+Thread.currentThread().getName()+"位置为："+seats);
			}else{
				System.out.println("出票失败"+Thread.currentThread().getName()+"位置不够！");
			}
		}
	}
}
//影院
class Cinema{
	int avaliable;//可用的位置
	String name;//名称
	public Cinema(int avaliable, String name) {
		super();
		this.avaliable = avaliable;
		this.name = name;
	}
	//购票数量
	public boolean booTickets(int seats){
		System.out.println("可用位置为："+avaliable);
		if(seats>avaliable){
			return false;
		}
		avaliable-=seats;
		return true;
	}
}