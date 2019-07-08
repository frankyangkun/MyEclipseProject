package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解信息，模拟处理注解信息的流程
 * @author yang
 *
 */
public class A02_Demo03 {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("annotation.A02_Student");
			//获得类所有的注解
			Annotation[] annotations = clazz.getAnnotations();
			for (Annotation a : annotations) {
				System.out.println("++++++"+a);//@annotation.StudentTable(value=tb_student)
			}
			//获取指定类的注解
			StudentTable s = (StudentTable) clazz.getAnnotation(StudentTable.class);
			System.out.println("======="+s.value());//tb_student
			//获得类的属性的注解
			Field f = clazz.getDeclaredField("name");//注意不是sname是name
			StudentField studentField = f.getAnnotation(StudentField.class);//注意这行的含义！！
			System.out.println(studentField.columnName()+"--"+studentField.type()+"--"+studentField.length());
			
			//下面就可以根据获得的表明，字段信息，拼出sql语句，然后使用JDBC执行这个sql，在数据库中生成相关表
			//省略，这里不是现在的重点
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
