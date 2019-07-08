package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 通过regex101自己生成的测试代码
 * @author yang
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		final String regex = "\\{\\d\\}{4}";
		final String string = "i love you1222 3332 699988809\n"
			 + "i love sxt123\n"
			 + "i love frank\n"
			 + "	hehe\n"
			 + "jj23kl1\n"
			 + "2k3";

		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(string);

		while (matcher.find()) {
		    System.out.println("Full match: " + matcher.group(0));
		    for (int i = 1; i <= matcher.groupCount(); i++) {
		        System.out.println("Group " + i + ": " + matcher.group(i));
		    }
		}
	}
}
