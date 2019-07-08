package arrays;

import java.util.Arrays;

/**
 * 测试java.util.Arrays工具类的使用
 * @author yang
 *
 */
public class TestArraysClass {
	public static void main(String[] args) {
		int [] a = {1,2,3};
		int [] b = {10,2,23,11,5};
		System.out.println(Arrays.toString(a));
		Arrays.sort(b);//排序
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.binarySearch(b, 23));//查元素的索引位置，但结果都不对，因为前面排过序了
	}

}
