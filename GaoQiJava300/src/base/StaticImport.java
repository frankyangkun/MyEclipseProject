package base;
//测试静态导入
import static java.lang.Math.*;

public class StaticImport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.PI);
		System.out.println(PI);//静态导入后可直接使用该静态属性
	}

}
