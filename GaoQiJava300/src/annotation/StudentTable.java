package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 表示类和表之间的转化的注解
 * @author yang
 *
 */
@Target(value={ElementType.TYPE})//只用于修饰类，表示类和表之间的转化
@Retention(RetentionPolicy.RUNTIME)
public @interface StudentTable {
	String value();
}
