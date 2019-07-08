package thread;
/**
 * 不可重入锁: 锁不可以延续使用
 * @author yang
 */
public class T30_LockTest2 {
	Lock lock = new Lock();
	public void a() throws InterruptedException{
		lock.lock();//使用锁 
		doSth();//理论上进入方法a后拿到了锁，可以进入doSth方法，把锁带下去，但这里不行，一直在wait 
		lock.unlock();
	}
	public void doSth() throws InterruptedException{//不可重入
		lock.lock();
		//。。。业务代码。。。
		//。。。业务代码。。。
		lock.unlock();
	}
	public static void main(String[] args) throws InterruptedException {
		T30_LockTest2 test = new T30_LockTest2();
		test.a();
		test.doSth();
	}
}
class Lock{//不可重入锁
	private boolean isLocked = false;//是否占用
	public synchronized void lock() throws InterruptedException{//使用锁
		while(isLocked){//如果为真，表示被持有被占用了，就等待
			wait();
		}
		isLocked = true;	
	}
	public synchronized void unlock(){//释放锁
		isLocked = false;
		notify();
	}
}