package javassist;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 测试javassist的api
 * @author yang
 * 2019-05-10 17:31:38
 */
public class Demo02 {
	/**
	 * 处理类的基本用法
	 * @throws Exception 
	 */
	public static void test() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("javassist.Emp");//获得已有类，不能只写Emp，包名要写全
		
		byte[] bytes = cc.toBytecode();//转换为字节码，用字节数组接收
		System.out.println(Arrays.toString(bytes));//[-54, -2, -70, -66, 0, 0, 0, 5....很长一串字节数组，就是字节码的内容
		System.out.println(bytes);//[B@2a84aee7
		
		System.out.println(cc.getName());//javassist.Emp
		System.out.println(cc.getSimpleName());//Emp
		System.out.println(cc.getSuperclass());//获得父类
		System.out.println(cc.getInterfaces());//获得接口
	}
	/**
	 * 测试产生新的方法
	 * @throws Exception 
	 */
	public static void test2() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("javassist.Emp");
		
//		CtMethod m = CtNewMethod.make("public int add(int a,int b){return a+b;}", cc);//方法1
		CtMethod m2 = new CtMethod(CtClass.intType, "add",new CtClass[]{CtClass.intType,CtClass.intType},cc);//方法2
		m2.setModifiers(Modifier.PUBLIC);
		m2.setBody("{System.out.print(\"hello\");return $1+$2;}");//$1,$2占位符，代表传递的第一和第二个参数，$0代表this
		cc.addMethod(m2);
		
		//通过反射调用新生成的方法
		Class clazz = cc.toClass();//把CtClass转换为反射对象
		Object obj = clazz.newInstance();//通过调用Emp无参构造器创建对象
		Method method = clazz.getDeclaredMethod("add",int.class,int.class);
		Object result = method.invoke(obj, 200,300);
		System.out.println(result);
	}
	/**
	 * 修改已有方法
	 * @throws Exception
	 */
	public static void test3() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("javassist.Emp");
		
		CtMethod cm = cc.getDeclaredMethod("sayHi",new CtClass[]{CtClass.intType});//不能写成CtClass.intType，写成数组形式
		cm.insertBefore("System.out.print($1);System.out.println(\"start!\");");
		cm.insertAt(33, "int b=3;System.out.println(\"b=\"+b);");//在某行前加入内容
		cm.insertAfter("System.out.print($1);System.out.println(\"end!\");");
		//通过反射调用已有方法
		Class clazz = cc.toClass();//把CtClass转换为反射对象
		Object obj = clazz.newInstance();//通过调用Emp无参构造器创建对象
		Method method = clazz.getDeclaredMethod("sayHi",int.class);//反射调用
		Object result = method.invoke(obj, 200);
//		System.out.println(result);//没必要打印了，因为方法没返回值，打印结果是null
	}
	
	/**
	 * 属性操作
	 * @throws Exception
	 */
	public static void test4() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("javassist.Emp");
//		CtField f1 = CtField.make("private int empno;", cc);//方法1 新增属性
		CtField f1 = new CtField(CtClass.intType, "salary",cc);//方法2 新增属性
		f1.setModifiers(Modifier.PRIVATE);
		cc.addField(f1,"1001");//默认值1000,可不写
		
//		cc.getDeclaredField("ename");//获取指定的属性
		
		//增加响应的set和get方法，除了直接写Demo01里那种java代码，还可以下面这样
		cc.addMethod(CtNewMethod.getter("getSalary", f1));
		cc.addMethod(CtNewMethod.setter("setSalary", f1));
		
		//可通过反射调用已有属性，就不写了
	}
	/**
	 * 构造器操作
	 * @throws Exception 
	 */
	public static void test5() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("javassist.Emp");
		
		CtConstructor[] cs = cc.getConstructors();//获得构造器
		for (CtConstructor temp : cs) {
			System.out.println(temp.getLongName());
//			temp.insertBefore("");//在构造器前加内容，类似操作不做演示了
		}
	}
	/**
	 * 操作注解
	 * @throws Exception
	 */
	public static void test6() throws Exception{
		CtClass cc = ClassPool.getDefault().get("javassist.Emp");
		Object[] all = cc.getAnnotations();
		Author a = (Author) all[0];//因为只有1个注解，所以就取第一个
		String name = a.name();
		int year = a.year();
		System.out.println("name:"+name+",year:"+year);
	}
	public static void main(String[] args) throws Exception {
//		test();
//		test2();
		test6();
	}
}
