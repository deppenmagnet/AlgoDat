/**
 * Aufgabe 1.4
 */
package Blatt2;

import helper.LinkedList;

/**
 * @author Stefan Lange
 *
 */
public class ReverseLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.insertToHead(1);
		ll.insertToHead(2);
		ll.insertToHead(3);
		ll.insertToHead(4);
		System.out.println(ll.size());
		for(Integer element : ll)
			System.out.print(element+" ");
		System.out.println();
		
		LinkedList<Integer> ll2;
		ll2 = reverseTheList(ll);
		for(Integer element : ll2)
			System.out.print(element + " ");

	}

	private static LinkedList<Integer> reverseTheList(LinkedList<Integer> ll) {
		LinkedList<Integer> tmp = new LinkedList<Integer>();
		for (Integer element : ll)
			tmp.insertToHead(element);
		return tmp;
	}

}
