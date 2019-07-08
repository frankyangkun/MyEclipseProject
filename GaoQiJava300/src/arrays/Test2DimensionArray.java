package arrays;
/**
 * 测试二维数组
 * @author yang
 *
 */
public class Test2DimensionArray {
	public static void main(String[] args) {
		int [][] a = new int[3][];
//		a[0] = {20,30};//不能写成这样,一维数组可以 int [] b = {20,30};
		a[0] = new int[] {20,30};
		a[1] = new int[] {10,15,90};
		a[2] = new int[] {50,60};
		
		System.out.println(a[1][2]);//90
		
		//静态初始化二维数组
		int [][] b = {
				{1,2},
				{10,20},
				{100,200,300}
		};
		System.out.println(b[2][2]);
	}

}
