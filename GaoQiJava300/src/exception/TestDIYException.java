package exception;
/**
 * 测试自定义异常
 * @author yang
 *
 */
public class TestDIYException {

	public static void main(String[] args) throws IllegalAgeException {
		Person p = new Person();
		p.setAge(-10);
	}
}
//class IllegalAgeException extends RuntimeException{//如果编译时就处理，可继承自Exception
class IllegalAgeException extends Exception{
	public IllegalAgeException(){
	}
	public IllegalAgeException(String msg){
		super(msg);
	}
}
class Person{
	private int age;
	
	public int getAge(){
		return age;
	}
	public void setAge(int age) throws IllegalAgeException{
		if(age<0){
//			try {
				throw new IllegalAgeException("年龄不能为负数");
//			} catch (IllegalAgeException e) {
//				e.printStackTrace();
//			}
		}
		this.age = age;
	}
}//此处只是为了测试，实际没必要专门定义异常来处理
