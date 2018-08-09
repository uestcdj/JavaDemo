package Lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaDemo6 {

	public static void main(String[] args) {
		List<Integer> costBeforeTax = Arrays.asList(100,200, 300, 400, 500);
		double total = 0;
		for(Integer cost : costBeforeTax) {
			double price = cost + .12 * cost;
			total += price;
		}
		System.out.println(total);
		double bill = costBeforeTax.stream().map(cost -> cost + .12 * cost)
				.reduce((sum, cost) -> sum + cost).get();
		System.out.println("Total :" + bill);
	}

}
