package net;
/**
 * 加入多线程，实现双向交流，模拟在线咨询
 * @author yang
 *
 */
public class N10_TalkStudent {
	public static void main(String[] args) {
		new Thread(new N10_TalkSend(7777,"127.0.0.1",9999)).start();//发送，7777是本机发送的端口，9999是对方接收的端口
		
		new Thread(new N10_TalkReceive(8888,"老师")).start();//接收,8888是本机接收的端口
	}
}
