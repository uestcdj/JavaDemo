package Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaDemo9 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		List<Integer> distinct = numbers.stream().map(x -> x * x).distinct().collect(Collectors.toList());
		System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
	}

}
