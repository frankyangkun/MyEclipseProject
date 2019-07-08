package thread;
/**
 * lambda表达式推导+参数
 * @author yang
 *
 */
public class T10_LabmdaTest2 {
	public static void main(String[] args) {
		ILove i = (int a)-> {
			System.out.println("i like lambda."+"-->"+a);
		};
		i.lambda(100);
		//省略类型
		i = (a)-> {
			System.out.println("i like lambda."+"-->"+a);
		};
		i.lambda(50);
		//省略括号
		i = a-> {
			System.out.println("i like lambda."+"-->"+a);
		};//如果有多行代码，必须加分号表示语句结束
		i.lambda(5);
		//写成一行，去掉{}
		i = a-> System.out.println("i like lambda."+"-->"+a);
		i.lambda(1);
	}
}
interface ILove{
	void lambda(int a);
}

