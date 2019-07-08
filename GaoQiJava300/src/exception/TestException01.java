package exception;
/**
 * 测试异常
 * @author yang
 *
 */
public class TestException01 {
	
	public static void main(String[] args) {
		int a = 0;
		int b = 1;
		if(a!=0){
			System.out.println(b/a);
		}
		String str = null;
		str.length();
	}

}
