package javascript;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 测试脚本引擎执行js代码
 * @author yang
 *2019-05-09 11:32:13
 */
public class Demo01 {
	public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
		//获得脚本引擎对象
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");//根据名称获取对应脚本语言的引擎
		
		//定义变量，存储到引擎上下文中
		engine.put("msg", "hello world");//jmeter中也有类似用法，将beanshell执行结果变量存储到jmeter中供其他采样器调用
		String str = "var user = {name:'frank',age:18,school:['北大','清华']};";
		str += "print(user.name);"; //这里不能用alert弹框，在控制台显示就行
		//****不知为何，println会报错"println" is not defined，只能用print，视频里都可以，难道是引擎版本问题？
		//正解：jdk1.6的使用方法规则 1.8已经不适用了，如果出现 "println" is not defined in <eval>,  则将"println"改"print"
		
		//执行脚本
		engine.eval(str);
		engine.eval("msg = 'i am a good man.';");//修改变量值
		System.out.println(engine.get("msg"));//若没修改，打印结果就是hello world
		System.out.println("####################");
		
		//定义函数
		engine.eval("function add(a,b){var sum = a+b;return sum;}");
		//取得调用接口,允许调用js中的方法，必须将engine转为Invocable接口才能调用
		Invocable jsInvoke = (Invocable) engine;
		//执行脚本中定义的方法
		Object result1 = jsInvoke.invokeFunction("add", new Object[]{11,12});//返回的是Object
		System.out.println(result1);
		
		//导入其他java包，使用其他包中的java类，若需要深入了解细节，可以详细学习Rhino的语法
//		String jsCode = "importPackage(java.util); var list=Arrays.asList([\"北大\",\"清华\"]);";//jdk1.6的使用方法规则 1.8已经不适用了
		String jsCode = "var list=java.util.Arrays.asList([\"北大\",\"清华\"]);";//新版本的写法
		engine.eval(jsCode);
		List<String> list2 = (List<String>) engine.get("list");//如果知道类型，可以用下泛型
		for (String temp : list2) {
			System.out.println(temp);
		}
		
		//执行一个js文件（将a.js放在项目的src下即可）
		URL url = Demo01.class.getClassLoader().getResource("a.js");//获取外部资源文件
//		System.out.println(url.getPath());
		FileReader fr = new FileReader(url.getPath());//找到绝对路径
		engine.eval(fr);//要传一个Reader
		fr.close();//因为是字符流Reader，所以需要关闭，由于只是测试，就不那么规范了。实际用时要使用try catch finally！
	}
}
