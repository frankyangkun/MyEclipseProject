package thread;
/**
 * 创建线程方式2：
 * 1、创建：实现Runnable+重写run
 * 2、启动：创建实现类对象+start
 * @author yang
 *
 */
public class T03_DownloadPic implements Runnable{

	private String url;//远程路径
	private String name;//存储名称
	
	public T03_DownloadPic(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}
	public void run(){
		T02_WebDownloadUtil wd = new T02_WebDownloadUtil();
		wd.download(url, name);
		System.out.println(name);
	}
	public static void main(String[] args) {
		//启动线程 
		new Thread(new T03_DownloadPic("http://s2.dgtle.com/forum/201904/01/103657jko8h5o0sej5djes.jpg?imageView2/2/w/960/q/100","airpods1.jpg")).start();
		new Thread(new T03_DownloadPic("http://s2.dgtle.com/forum/201904/01/103657jko8h5o0sej5djes.jpg?imageView2/2/w/960/q/100","airpods2.jpg")).start();
		new Thread(new T03_DownloadPic("http://s2.dgtle.com/forum/201904/01/103657jko8h5o0sej5djes.jpg?imageView2/2/w/960/q/100","airpods3.jpg")).start();
	}
}
