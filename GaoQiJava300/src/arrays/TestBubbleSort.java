package arrays;
import java.util.Arrays;
/**
 * 测试及优化冒泡排序
 * @author yang
 *
 */
public class TestBubbleSort {
	public static void main(String[] args) {
		int[] values = {3,1,5,4,7,0,9,2,8};
		int temp = 0;
		for(int j = 0;j < values.length-1;j++){
			boolean flag = true;//用来判断是否已经排好
			for (int i = 0; i < values.length-1-j; i++) {//需要减去外层循环的次数j
				if(values[i]>values[i+1]){
					temp = values[i];
					values[i] = values[i+1];
					values[i+1] = temp;
					
					flag = false;//如果发生了交换，说明数列还没排完，还需继续循环下去
				}
			System.out.println(Arrays.toString(values));
			}
			
			String jjx = Arrays.toString(values);
//			System.out.println("***"+jjx);
			if(flag)//如果flag是true说明内层循环没有执行了，证明排好序了，就结束
			{
				System.out.println("结束");
				break;
			}
			System.out.println("***"+jjx);
		}
	}
}
