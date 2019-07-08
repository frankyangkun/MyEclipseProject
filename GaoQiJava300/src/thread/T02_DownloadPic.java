package thread;
/**
 * 多线程下载图片
 * @author yang
 *
 */
public class T02_DownloadPic extends Thread{

	private String url;//远程路径
	private String name;//存储名称
	
	public T02_DownloadPic(String url, String name) {
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
		T02_DownloadPic t1 = new T02_DownloadPic("http://s2.dgtle.com/forum/201904/01/103657jko8h5o0sej5djes.jpg?imageView2/2/w/960/q/100","airpods1.jpg");
		T02_DownloadPic t2 = new T02_DownloadPic("http://s2.dgtle.com/forum/201904/01/103650jn3mzfgzqfvvrrmm.jpg?imageView2/2/w/960/q/100","airpods2.jpg");
		T02_DownloadPic t3 = new T02_DownloadPic("http://s2.dgtle.com/forum/201904/01/103701ye9ue6k04iez1nem.jpg?imageView2/2/w/960/q/100","airpods3.jpg");
		
		//启动线程 
		t1.start();
		t2.start();
		t3.start();
//		t1.run();
//		t2.run();
//		t3.run();
	}
}
