package thread;
/**
 * 可重入锁: 锁可以延续使用 + 计数器
 * @author yang
 */
public class T30_LockTest3 {
	ReLock lock = new ReLock();
	public void a() throws InterruptedException{
		lock.lock();//使用锁 
		System.out.println("a()中使用锁后的锁数量："+lock.getHoldCount());//查看计数器
		doSth();//理论上进入方法a后拿到了锁，可以进入doSth方法，把锁带下去，但这里不行，一直在wait 
		lock.unlock();
		System.out.println("a()中释放锁后的锁数量："+lock.getHoldCount());//查看计数器
	}
	public void doSth() throws InterruptedException{//不可重入
		lock.lock();
		System.out.println("doSth()中使用锁后的锁数量："+lock.getHoldCount());//查看计数器
		//。。。业务代码。。。
		//。。。业务代码。。。
		lock.unlock();
		System.out.println("doSth()中释放锁后的锁数量："+lock.getHoldCount());//查看计数器
	}
	public static void main(String[] args) throws InterruptedException {
		T30_LockTest3 test = new T30_LockTest3();
		test.a();
		
		Thread.sleep(1000);
		System.out.println("最后查看锁数量："+test.lock.getHoldCount());//查看计数器
	}
}
class ReLock{//可重入锁
	private boolean isLocked = false;//是否占用
	private Thread lockedBy = null;//存储线程，如果是自身线程就不用等待
	private int holdCount = 0;//锁的计数器，统计锁的使用
	
	public synchronized void lock() throws InterruptedException{//使用锁
		Thread t = Thread.currentThread();
		while(isLocked && lockedBy!=t){//lockedBy!=t 如果不是当前线程才等待
			wait();
		}
		isLocked = true;	
		lockedBy = t;//当前线程，赋值后下一次while就进不去了，就不用等待了
		holdCount++;
	}
	public synchronized void unlock(){//释放锁
		if(Thread.currentThread()==lockedBy){//当前线程等于自身线程时才释放，其他线程就不释放，等待
			holdCount--;
			if(holdCount==0){//当计数器没有谁再持有时再释放
				isLocked = false;
				notify();
				lockedBy = null;
			}
		}
	}
	public int getHoldCount(){
		return holdCount;
	}
}