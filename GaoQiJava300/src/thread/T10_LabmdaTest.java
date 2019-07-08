package thread;
/**
 * lambda表达式推导
 * @author yang
 *
 */
public class T10_LabmdaTest {
	static class Like2 implements ILike{//2、静态内部类
		@Override
		public void lambda() {
			System.out.println("i like lambda2.");
		}	
	}
	public static void main(String[] args) {
		ILike like = new Like();
		like.lambda();
		
		like = new Like2();
		like.lambda();
		
		class Like3 implements ILike{//3、局部内部类
			@Override
			public void lambda() {
				System.out.println("i like lambda3.");
			}	
		}
		like = new Like3();
		like.lambda();
		
		like = new ILike(){//4、匿名内部类
			public void lambda() {
				System.out.println("i like lambda4.");
			}	
		};
		like.lambda();
		//5、lambda表达式
		like = ()->{
			System.out.println("i like lambda5.");
		};
		like.lambda();
		
		/*下面这样写是错的，lambda必须存在类型，也就是赋值给一个引用
		()->{
			System.out.println("i like lambda5.");
		}.lambda();
		*/
	}
}
interface ILike{//接口中必须只能有1个方法，才能使用lambda表示推导，多个方法就不行了
	void lambda();
}
class Like implements ILike{//1、外部类
	@Override
	public void lambda() {
		System.out.println("i like lambda1.");
	}	
}
