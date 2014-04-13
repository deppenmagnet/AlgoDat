package Blatt2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import helper.Stack;
import helper.WrongParensException;

/**
 * Klammern - Algodat Übungsblatt 2 Aufgabe 1.1
 * Mittels eines Stacks die Klammern einer Zeichenfolge prüfen
 * @author Stefan Lange
 *
 */


public class Klammern {

	public static void main(String[] args) {
		// erst mal nen Stack
		Stack<Character> stack = new Stack<Character>(Character[].class);
	
		String userInput = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Bitte geben sie die zu testende Zeichenfolge ein: ");
		try {
			userInput = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < userInput.length(); i++){
			switch(userInput.charAt(i)){
				case '[':
				case '{':
				case '(': stack.push(userInput.charAt(i));
						break;
				case ')': if (stack.pop() != '(')
						throw new WrongParensException();
						break;
				case '}': if (stack.pop() != '{')
						throw new WrongParensException();
				case ']': if (stack.pop() != '[')
						throw new WrongParensException();
			}
		}
		if (stack.isEmpty()){
			System.out.println("Klammern passen!");
		}else{
			System.out.println("OOps...da stimmt was nicht!");
		};
	}
}
