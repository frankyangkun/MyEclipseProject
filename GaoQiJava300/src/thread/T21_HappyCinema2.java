package thread;

import java.util.ArrayList;
import java.util.List;
/**
 * 模拟多人购票，支持选座
 * @author yang
 *
 */
public class T21_HappyCinema2 {
	public static void main(String[] args) {
		//可用的位置
		List<Integer> avaliable = new ArrayList<Integer>();
		avaliable.add(1);
		avaliable.add(2);
		avaliable.add(3);
		avaliable.add(6);
		avaliable.add(7);
		
		//顾客需要的位置
		List<Integer> seat1 = new ArrayList<Integer>();
		seat1.add(1);
		seat1.add(2);
		List<Integer> seat2 = new ArrayList<Integer>();
		seat2.add(3);
//		seat2.add(5);
//		seat2.add(6);
		List<Integer> seat3 = new ArrayList<Integer>();
		seat3.add(3);
		seat3.add(6);
		
		Cinema2 c = new Cinema2(avaliable,"happy");
		new Thread(new Customer2(c,seat1),"frank").start();
		new Thread(new Customer2(c,seat2),"tom").start();
		new Thread(new Customer2(c,seat3),"jerry").start();
	}
}
//顾客
class Customer2 implements Runnable{
	Cinema2 cinema;
	List<Integer> seats;
	public Customer2(Cinema2 cinema, List<Integer> seats) {
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
class Cinema2{
	List<Integer> avaliable;//可用的位置
	String name;//名称
	public Cinema2(List<Integer> avaliable, String name) {
		super();
		this.avaliable = avaliable;
		this.name = name;
	}
	//购票数量
	public boolean booTickets(List<Integer> seats){
		System.out.println("欢迎光临"+this.name+"影院，可用位置为："+avaliable);
		List<Integer> copy = new ArrayList<Integer>();
		copy.addAll(avaliable);
		//相减
		copy.removeAll(seats);
		//判断大小
		if(avaliable.size()-copy.size()!=seats.size()){//原有位子总是-变化后的数量是否等于要买的数量
			return false;
		}
		//成功
		avaliable = copy;
		return true;
	}
}