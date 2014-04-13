package fibonacci2;

import java.math.BigInteger;

public class FibonacciOptimized {
	// BigInteger-Array um alle Werte zwischenzuspeichern
	static BigInteger[] f_speicher = new BigInteger[20000];
	
	public static void main(String[] args) {
		for (int i = 0; i < f_speicher.length; i++)
			f_speicher[i] = new BigInteger(""+0);
		for (int N = 0; N < 20000; N++)
			System.out.println(N + " Fibonacci: "+ F(N));
	}
	
	public static BigInteger F(int N){
		if (N == 0) return BigInteger.ZERO;
		if (N == 1) return BigInteger.ONE;
		f_speicher[N] = 
				(BigInteger)((f_speicher[N-1].compareTo(BigInteger.ZERO)>0)?
						f_speicher[N-1]:F(N-1)).add
				((BigInteger)((f_speicher[N-2].compareTo(BigInteger.ZERO)>0)?
						f_speicher[N-2]:F(N-2)));
		return f_speicher[N];
	}
}
