package Lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names,(a, b) -> b.compareTo(a));
		Something something = new Something();
		Convert<String, String> converter = something::startsWith;
		String converted = converter.convert("Java");
		System.out.println(converted);
		
		PersonFactory<Person> personFactory = Person::new;
		final int num = 1;
		Convert<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
	}
}