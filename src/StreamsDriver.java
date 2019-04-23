import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDriver {

	public static void main(String[] args) {		
		//Alphabet list
		List<Character> lstAlphabet = new ArrayList<Character>();
		for (char c = 'a'; c <= 'z'; c++) {
			lstAlphabet.add(c);
		}

		System.out.printf("Every other letter: %s\n",
				lstAlphabet.stream()
				.filter(x -> (x - 'a') % 2 == 0)
				.collect(Collectors.toList()));

		System.out.printf("Five letter shift cypher: %s\n",
				lstAlphabet.stream()
				.map(x -> (char)('a' + (x - 'a' + 5) % 26))
				.collect(Collectors.toList()));
		

		//Number list
		List<Integer> lstNumbers = new ArrayList<Integer>();
		for (int i = 0; i < 50; i++) {
			lstNumbers.add(i);
		}
		
		System.out.printf("Prime numbers: %s\n",
				lstNumbers.stream()
				//This of this as a double for loop
				//The outside goes through numbers tbd
				//The inside goes through possible tests to determine if the outside is prime
				//If nothing is divisible (result list is empty), its prime!
				.filter(x1 -> IntStream.range(2, x1).filter(x2 -> x1 % x2 == 0).count() == 0)
				.limit(50)
				.collect(Collectors.toList()));

		//Instead of printing the list, I print each member using a forEach(lambda) function
		System.out.printf("Even numbers: ");
		lstNumbers.stream()
			.filter(x -> x % 2 == 0)
			.limit(10)
			.forEach(x -> System.out.print(x + " "));

		System.out.printf("\nMin number: %s\n",
				lstNumbers.stream()
				.min((x1, x2) -> x1 - x2)
				.orElseThrow(NoSuchElementException::new));
	}	
}
