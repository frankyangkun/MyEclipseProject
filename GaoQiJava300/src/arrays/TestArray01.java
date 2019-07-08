package arrays;
//测试数组

class User{
	private int id;
	private String name;
	
	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
public class TestArray01 {
	public static void main(String[] args) {
		int arr01 [] = new int[10];
		String arr02 [] = new String [5];
		
		arr01[0] = 13;
		arr01[1] = 13;
//		arr01[10] = 13;//越界异常
		for(int i=0;i<arr01.length;i++){
			arr01[i] = 10*i;
			System.out.println(arr01[i]);
		}
		System.out.println("##################");
		for(int m:arr01){//foreach循环：用于读取数组元素，不能修改元素的值
			System.out.print(m+" ");//不能通过下标引用，只有1个临时变量m
		}//注意：变量取出来的值放在临时变量m中，打印的是m，而不是arr01
		
		User [] arr03 = new User[3];
	    arr03[0] = new User(1001,"frank1");
	    arr03[1] = new User(1002,"frank2");
	    arr03[2] = new User(1003,"frank3");
		
		for(int i=0;i<arr03.length;i++){
			System.out.println(arr03[i].getName());
		}
	}
}
