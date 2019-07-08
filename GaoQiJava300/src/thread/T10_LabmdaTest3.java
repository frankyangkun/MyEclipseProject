package thread;
/**
 * lambda表达式推导+参数+返回值
 * @author yang
 *
 */
public class T10_LabmdaTest3 {
	public static void main(String[] args) {
		IInterest interest = (int a,int c)-> {
			System.out.println("i like lambda."+(a+c));
			return a+c;
		};
		interest.lambda(100, 200);
		
		interest = (a,c)-> {//多个参数，不能省略括号
			System.out.println("i like lambda."+(a+c));
			return a+c;
		};
		interest.lambda(200, 200);
		
		interest = (a,c)-> a+c;//返回值的简化
		System.out.println(interest.lambda(300, 200));
	}
}
interface IInterest{
	int lambda(int a,int b);
}

class Interest implements IInterest{
	@Override
	public int lambda(int a,int c) {
		System.out.println("i like lambda."+(a+c));
		return a+c;
	}	
}