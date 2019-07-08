package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 修饰属性的注解
 * @author yang
 */
@Target(value={ElementType.FIELD})//用于修饰属性
@Retention(RetentionPolicy.RUNTIME)
public @interface StudentField {
	String columnName();
	String type();
	int length();
}
