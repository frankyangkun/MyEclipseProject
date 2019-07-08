package arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Arrays与ArrayList相互转换
 * @author yang
 *
 */
public class TestArrays03 {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();  //大小没有定
        list.add("王利虎");  
        list.add("张三");  
        list.add("李四");  
        int size=list.size();  
        String[] array = (String[])list.toArray(new String[size]);  
        for(int i=0;i<array.length;i++){//方法1  
            System.out.println(array[i]);
        } 
        System.out.println("*****");
        for(int i=0;i<list.size();i++){//方法2
        	System.out.println(list.get(i));//效果和方法1一样
        }
        
        System.out.println("=========================================");
        String[] array2 = new String[3];  //定义时就定了大小
        array2[0]="王利虎";  
        array2[1]="张三";  
        array2[2]="李四";  
//        System.out.println(array2);//[Ljava.lang.String;@7852e922
        List<String> list2 = Arrays.asList(array2);  
//        System.out.println(list2);//[王利虎, 张三, 李四]
        for(int i=0;i<list2.size();i++){  
            System.out.println(list2.get(i));  //通过get方法来索引值
        }            
	}
}
