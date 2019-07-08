package thread;
/**
 * 协作模型：生产者消费者实现方式一：管程法
 * 借助缓冲区
 * @author yang
 *
 */
public class T23_WaitTest1 {
	public static void main(String[] args) {
		SynContainer syn = new SynContainer();
		new Productor(syn).start();
		new Consumer(syn).start();
	}
}
//生产者
class Productor extends Thread{
	SynContainer container;
	public Productor(SynContainer container) {
		this.container = container;
	}
	@Override
	public void run() {
		//生产
		for (int i = 0; i < 100; i++) {
			System.out.println("生产-->第"+i+"个产品");
			container.push(new Product(i));
		}
	}
}
//消费者
class Consumer extends Thread{
	SynContainer container;
	public Consumer(SynContainer container) {
		this.container = container;
	}
	@Override
	public void run() {
		//消费
		for (int i = 0; i < 100; i++) {
			System.out.println("消费-->第"+container.pop().id+"个产品");
		}
	}
}
//缓冲区
class SynContainer{
	Product [] product = new Product[10];//存储容器
	int count = 0;//计数器
	//存储 生产
	public synchronized void push(Product p){
		//何时能生产，容器存在空间
		//容器空间满了，不可以生产，只能等待
		if(count==product.length){
			try {
				this.wait();//线程阻塞，直到消费者通知生产，阻塞解除，wait会释放锁，给别人用
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//容器存在空间，可以生产
		product[count] = p;
		count++;
		this.notifyAll();//存在数据了，可以通知消费了
	}
	//获取 消费
	public synchronized Product pop(){
		//控制何时消费 容器中是否存在数据
		//没有数据，只有等待
		if(count==0){
			try {
				this.wait();//线程阻塞，直到生产者通知消费，阻塞解除，wait会释放锁，给别人用
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//存在数据可以消费
		count --;//从最后一个位置取
		Product p = product[count];
		this.notifyAll();//消费后就有空间了，通知所有等待者被唤醒，可以生产了
		return p;
	}
}
//产品
class Product{
	int id;
	public Product(int id) {
		this.id = id;
	}
}