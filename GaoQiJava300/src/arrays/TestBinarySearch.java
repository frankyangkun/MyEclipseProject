package arrays;

import java.util.Arrays;

/**
 * 测试二分查找
 * @author yang
 *
 */
public class TestBinarySearch {

	public static void main(String[] args) {
		int [] arr = {30,3,90,54,26,11,9,69,20,10,4,2,39};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(myBinarySearch(arr, 20));//返回索引
	}
	public static int myBinarySearch(int[] arr,int value){
		int low = 0;
		int high = arr.length-1;
		
		while(low<=high){
			int mid = (low+high)/2;
			
			if(value == arr[mid]){
				return mid;
			}
			if(value > arr[mid]){
				low = mid+1;
			}
			if(value < arr[mid]){
				high = mid-1;
			}
		}
		return -1;//如果没找到，返回-1
	}
}
