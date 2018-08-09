package Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaDemo5 {
	
	static Predicate<String> startsWithJ = (n) -> n.startsWith("J");
	static Predicate<String> fourLetterLong = (n) -> n.length() == 4;
	
	public static void filter(List<String> names) {
		names.stream().filter(startsWithJ.and(fourLetterLong)).forEach((n) -> {
			System.out.println(n);
		});
	}

	public static void main(String[] a) {
		 List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		 filter(languages);
	}
	 
}
