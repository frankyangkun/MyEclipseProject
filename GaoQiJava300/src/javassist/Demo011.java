package javassist;

import java.io.IOException;

import javassist.ClassPool;
/**
 * 测试使用javassist生成一个新的类
 * @author yang
 *
 */
public class Demo011 {
	public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass("javassist.Emp");//CtClass就代表要创建的类
		
		//创建属性 源码级操作，会自动转成字节码
		CtField cf = CtField.make("public int empno2;", cc);
		CtField cf2 = CtField.make("public String ename2;", cc);
		cc.addField(cf);
		cc.addField(cf2);
		
		//创建方法
		CtMethod m1 = CtMethod.make("public int getEmpno(){return empno2;}", cc);
		CtMethod m2 = CtMethod.make("public void setEmpno(int empno2){this.empno2 = empno2;}", cc);
		cc.addMethod(m1);
		cc.addMethod(m2);
		
		//添加构造器
		CtConstructor constructor = new CtConstructor(new CtClass[]{CtClass.intType, pool.get("java.lang.String")},cc);
		//由于CtClass没找到String类型，所以可以写成pool.get("java.lang.String")，如果是无参构造器，上面写成new CtClass[]{}即可
		constructor.setBody("{this.empno2=empno2;this.ename2=ename2;}");//上面的CtMethod对象也有setBody方法，用来修改方法体
		cc.addConstructor(constructor);
		
		//由于目前只是在内存里存在的类，需要写到工作空间
		cc.writeFile("/Users/yang/Downloads/javassist");//将构建好的类写到某个地方
		System.out.println("生成类成功！");
	}
}
