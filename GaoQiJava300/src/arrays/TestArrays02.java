package arrays;

import java.util.Arrays;

/**
 * 数组的拷贝（在指定位置删除和增加元素）
 * @author yang
 *
 */
public class TestArrays02 {
	public static void main(String[] args) {
		String[] s = {"AA","BB","CC","DD","EE"};
//		removeArrayElement(s, 1);
//		extendArrayElement();
		String[] a = insertElment(s, 2, "xx");
		for (String temp:a) {
			System.out.println(temp);
		}
		System.out.println(Arrays.toString(a));//用Arrays工具类直接打印数组
	}
	
	public static void testBasicCopy(){
		String s1 [] = {"aa","bb","cc","dd","ee"};
		String s2 [] = new String [10];
		System.arraycopy(s1, 2, s2, 6, 3);//源数组下标为2，目标数组下标为6，拷贝3个单位
		
		for(int i = 0;i<s2.length;i++)
		{
			System.out.println(i+"---"+s2[i]);
		}
	}
	
	//测试从数组中删除某个元素（本质上还是数组的拷贝）
	public static void testBasicCopy2(){
		String s1 [] = {"aa","bb","cc","dd","ee"};
//		String s2 [] = new String [10];
		System.arraycopy(s1, 3, s1, 2, s1.length-3);
		
		s1[s1.length-1] = null;//最后一个置为空
		
		for(int i = 0;i<s1.length;i++)
		{
			System.out.println(i+"---"+s1[i]);
		}
	}
	
	//删除数组中指定索引位置的元素，并将原数组返回
	public static String [] removeArrayElement(String [] s, int index){
		System.arraycopy(s, index+1, s, index, s.length-index-1);
		s[s.length-1] = null;
		for(int i=0;i<s.length;i++){
			System.out.println(i+"---"+s[i]);
		}
		return s;
	}
	
	//数组扩容，本质上先定义一个更大数组，然后将原数组内容拷进去
	public static String[] extendArrayElement(String[] s1){
//		String [] s1 = {"aa","bb","cc"};
		String [] s2 = new String[s1.length+10];
		
		System.arraycopy(s1, 0, s2, 0, s1.length);
		for(String temp:s2){
			System.out.println(temp);
		}
		return s1;
	}
	
	/**
     * 返回已经插入后的数组
     * @param str
     * @param index
     * @param elment
     * @return
     */
    public  static String[] insertElment(String str[],int index,String elment){
        String s2[]=new String[str.length+1];
        System.arraycopy(str,0,s2,0,index);
        s2[index]=elment;
        System.arraycopy(str,index,s2,index+1,str.length-index);
        return s2;
    }

}
