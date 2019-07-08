package thread;
/**
 * 创建线程方式3：
 * 1、创建：实现Callable+重写call
 * 2、启动：助服务和线程池
 * @author yang
 *
 */
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 多线程下载图片 使用Callable并发编程（juc技术）
 * @author yang
 *
 */
public class T07_DownloadPic implements Callable<Boolean>{

	private String url;//远程路径
	private String name;//存储名称
	
	public T07_DownloadPic(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}
	public Boolean call() throws Exception{
		T02_WebDownloadUtil wd = new T02_WebDownloadUtil();
		wd.download(url, name);
		System.out.println(name);
		return true;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		T07_DownloadPic t1 = new T07_DownloadPic("http://s2.dgtle.com/forum/201904/01/103657jko8h5o0sej5djes.jpg?imageView2/2/w/960/q/100","airpods1.jpg");
		T07_DownloadPic t2 = new T07_DownloadPic("http://s2.dgtle.com/forum/201904/01/103650jn3mzfgzqfvvrrmm.jpg?imageView2/2/w/960/q/100","airpods2.jpg");
		T07_DownloadPic t3 = new T07_DownloadPic("http://s2.dgtle.com/forum/201904/01/103701ye9ue6k04iez1nem.jpg?imageView2/2/w/960/q/100","airpods3.jpg");
		
		//创建执行服务
		ExecutorService ser = Executors.newFixedThreadPool(3);
		//提交执行
		Future<Boolean> res1 = ser.submit(t1);
		Future<Boolean> res2 = ser.submit(t2);
		Future<Boolean> res3 = ser.submit(t3);
		//获取结果
		boolean r1 = res1.get();//true
		boolean r2 = res2.get();//true
		boolean r3 = res3.get();//true
		//关闭服务
		ser.shutdownNow();
	}
}
