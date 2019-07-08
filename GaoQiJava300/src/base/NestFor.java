package base;
//嵌套循环
//git本地修改2--冲突测试
public class NestFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=5;i++){
			for(int j=1;j<=5;j++){
				System.out.print(j+" ");//打印i和j是不同的效果
			}
			System.out.println();
		}
	}

}
