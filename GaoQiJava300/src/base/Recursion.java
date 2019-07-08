package base;
//测试递归
public class Recursion {
	static int count = 0;
	static void a(){
		System.out.println("a"+count);
		count ++;
		if(count<10){
			a();
		}else{
			return;
		}
	}
	//求阶乘(递归)
	static long factorial(int n){
		if(n == 1){
			return 1;
		}else{
			return n * factorial(n - 1);//n!=n*(n-1)!
		}
	}
	
	//普通循环求阶乘
	static long factorial2(int n){
		
		int result = 1;
		while(n > 1){
			result *= n * (n - 1);
			n -= 2;
		}
		return result;
	}
	public static void main(String[] args) {

		long d1 = System.currentTimeMillis();
		System.out.printf("%d阶乘的结果：%s%n",5,factorial(5));
		long d2 = System.currentTimeMillis();
		System.out.printf("递归费时：%s%n",d2 - d1);

		long d3 = System.currentTimeMillis();
		System.out.printf("%d阶乘的结果：%s%n",5,factorial2(5));
		long d4 = System.currentTimeMillis();
		System.out.printf("递归费时：%s%n",d4 - d3);

		}
}
