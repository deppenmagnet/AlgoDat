/**
 * 
 */
package Blatt2;

import helper.Queue;

/**
 * @author Stefan Lange
 *
 */
public class QueueTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>(Integer[].class);
		
		System.out.println(q.isEmpty());
		System.out.println(q.size());
		q.enqueue(1);
		System.out.println(q.isEmpty());
		System.out.println(q.size());
		System.out.println("Element: "+q.dequeue());
		System.out.println(q.isEmpty());
		System.out.println(q.size());
		for (int i = 1; i < 100; i++)
			q.enqueue(i);
		System.out.println(q.isEmpty());
		System.out.println(q.size());
		for (int i = 1; i < 100; i++)
			System.out.println("Element " + i +": " + q.dequeue()  
					+" -- Queue-Länge: " + q.size()
					+" ist leer? " + q.isEmpty());
	}

}
