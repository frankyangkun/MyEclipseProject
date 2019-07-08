package arrays;

import java.util.Arrays;

/**
 * 测试二维数组存储表格数据
 * @author yang
 *
 */
public class Test2DimensionArray2 {

	public static void main(String[] args) {
		Object[] emp1 = {1001,"Frank",18,"学生","2018.12.26"};
		Object[] emp2 = {1002,"Tom",22,"销售","2018.12.26"};
		Object[] emp3 = {1003,"Jerry",32,"老师","2018.12.26"};
		
		Object[][] tableData = new Object[3][];//定义长度为3的二维数组
		tableData[0] = emp1;
		tableData[1] = emp2;
		tableData[2] = emp3;
		
		System.out.println(tableData);
		System.out.println(Arrays.toString(tableData));
		
//		for (int i = 0; i < tableData.length; i++) {
////			System.out.println(tableData[i]);//不能直接打印，需要用到Arrays.toString
//			System.out.println(Arrays.toString(tableData[i]));
//		}
		for(Object[] temp:tableData){
//			System.out.println(temp);//同样不能直接打印temp
			System.out.println(Arrays.toString(temp));
		}
	}

}
