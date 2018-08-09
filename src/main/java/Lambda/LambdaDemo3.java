package Lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaDemo3 {

	public static void main(String[] a) {
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		for(String l : features) {
			System.out.println(l);
		}
		features.forEach(s -> {
			System.out.println(s);
		});
		features.forEach(System.out::println);
	}
}
