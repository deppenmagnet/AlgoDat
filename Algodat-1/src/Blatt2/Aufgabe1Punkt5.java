/**
 * Test des sicheren Stacks gem. Aufgabe 1.5
 */
package Blatt2;

import helper.LinkedListStackSicher;

/**
 * @author Stefan Lange
 *
 */
public class Aufgabe1Punkt5 {
	
	public static void main(String[] args){
		LinkedListStackSicher<Integer> stack = 
				new LinkedListStackSicher<Integer>();
	
		stack.push(1);
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		
		// jetzt mal den Stack füllen und wieder leeren
		for(int i = 1; i < 10; i++)
			stack.push(i);
		System.out.println(stack.size());
		// und Stack inspizieren, OHNE Elemente zu entnehmen
		for (Integer element : stack)
			System.out.print(element + " ");
		System.out.println();
		
		// und jetzt das selbe mit dem Versuch, eine Exception wie gefordert
		// zu provozieren
		
		for (Integer element : stack){
			System.out.print(element + " ");
			stack.pop();
		}
		System.out.println();
	}
}
