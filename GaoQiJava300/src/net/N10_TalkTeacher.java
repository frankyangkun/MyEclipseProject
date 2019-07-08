package net;
/**
 * 加入多线程，实现双向交流，模拟在线咨询
 * @author yang
 *
 */
public class N10_TalkTeacher {
	public static void main(String[] args) {
		new Thread(new N10_TalkReceive(9999,"学生")).start();//接收
		new Thread(new N10_TalkSend(5555,"127.0.0.1",8888)).start();//发送，5555是本机发送的端口，8888是对方接收的端口
	}
}
