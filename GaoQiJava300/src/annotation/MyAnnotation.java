package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target(value=ElementType.METHOD)//注明该注解只能用于方法
@Target(value={ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	String name() default "";
	int id() default -1; //类似于String indexof("aa") 如果不存在返回-1
	int age() default 0;
	String[] schools() default "尚学堂";
}
