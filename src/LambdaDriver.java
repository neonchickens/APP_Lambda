import java.util.ArrayList;
import java.util.List;

public class LambdaDriver {

	interface MyFunction {
		int operation (int x, int y);
	}
	
	public static void main(String[] args) {
		MyFunction add = (int x, int y) -> (x + y);
		MyFunction sub = (int x, int y) -> (x - y);
		MyFunction multi = (int x, int y) -> (x * y);
		MyFunction div = (int x, int y) -> (x / y);

		int n1 = 15;
		int n2 = 5;

		System.out.println(add.operation(n1, n2));
		System.out.println(sub.operation(n1, n2));
		System.out.println(multi.operation(n1, n2));
		System.out.println(div.operation(n1, n2));
		
		MyFunction f = new MyFunction() {
			
			@Override
			public int operation(int x, int y) {
				return x + y;
			}
		};
		
		testFunction((x, y) -> x / y);
	}

	public static void testFunction(MyFunction f) {
		int x = 10;
		int y = 5;
		System.out.printf("f(%d, %d) = %d\n", x, y, f.operation(x, y));
	}
	
}
