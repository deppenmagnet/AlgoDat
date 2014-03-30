package fibonacci;

// F(55) nach 57 Minuten

public class FibonacciTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int N = 0; N < 100; N++)
			System.out.println(N + " Fibonacci: "+ F(N));
	}
	
	public static long F(int N){
		if (N == 0) return 0;
		if (N ==1) return 1;
		return (F(N-1)+F(N-2));
	}

}
