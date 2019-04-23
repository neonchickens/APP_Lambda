/* 
 * Programmer: Wes Laity
 * Date: 23 Apr 2019
 * Desc: Demonstration of Lambdas for the APP club.
 */

public class LambdaDriver {

	interface MyFunction {
		int operation (int x, int y);
	}
	
	public static void main(String[] args) {
		MyFunction add = (int x, int y) -> (x + y);
		MyFunction sub = (int x, int y) -> (x - y);
		MyFunction multi = (int x, int y) -> (x * y);
		MyFunction div = (int x, int y) -> (x / y);

		testFunction(add);
		testFunction(sub);
		testFunction(multi);
		testFunction(div);
		
		MyFunction pow = new MyFunction() {
			
			@Override
			public int operation(int x, int y) {
				return (int)Math.pow(x, y);
			}
		};
		testFunction(pow);
		
		testFunction((x, y) -> x + y);
	}

	public static void testFunction(MyFunction f) {
		int x = 15;
		int y = 5;
		System.out.printf("f(%d, %d) = %d\n", x, y, f.operation(x, y));
	}
	
}
