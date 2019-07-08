package thread;
/**
 * lambda表达式推导+参数+返回值
 * @author yang
 *
 */
public class T10_LabmdaTest4 {
	public static void main(String[] args) {
		new Thread(()->{
			for(int i=0;i<5;i++){
				System.out.println("coding..");
			}
		}).start();
		
		//省略{}
		new Thread(()->System.out.println("playing..")).start();
	}
}
