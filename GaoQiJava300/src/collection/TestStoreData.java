package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 测试表格数据的存储
 * @author yang
 *
 */
public class TestStoreData {
	public static void main(String[] args) {
		Map<String,Object> row1 = new HashMap<>();//value可能是任意类型，所以用Object
		row1.put("id",1001);
		row1.put("name","张三");
		row1.put("salary",2000);
		row1.put("入职日期","2008-3-3");
		
		Map<String,Object> row2 = new HashMap<>();//value可能是任意类型，所以用Object
		row2.put("id",1002);
		row2.put("name","李四");
		row2.put("salary",3000);
		row2.put("入职日期","2004-5-13");
		
		Map<String,Object> row3 = new HashMap<>();//value可能是任意类型，所以用Object
		row3.put("id",1003);
		row3.put("name","王五");
		row3.put("salary",4000);
		row3.put("入职日期","2006-2-8");
		
		List<Map<String,Object>> table1 = new ArrayList<>();
		table1.add(row1);
		table1.add(row2);
		table1.add(row3);
		
		for(Map<String,Object> row:table1){//遍历list，list里面存的是map
			Set<String> keyset = row.keySet();//每一行是1个map，1个map存放了多个kv，因此先获得每行的key列表
//			System.out.println(keyset);//每行的key列表都是 [name, id, salary, 入职日期]
			for(String key:keyset){//遍历map的key列表，获得key值
				System.out.print(key+":"+row.get(key)+"\t");//row.get(key)map--map对象row根据key取得value
			}
			System.out.println();
		}
	}
}
 