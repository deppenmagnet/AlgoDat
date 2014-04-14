/**
 * Der Stack mit der ominösen Sicherheit aus Blatt 2, Aufgabe 1.5
 * So dass der Iterator verhindert, dass die Funktionen push und pop ausge-
 * führt werden können, solange iteriert wird.
 */
package helper;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author Stefan Lange
 *
 */
public class LinkedListStackSicher<Item> extends LinkedListStack<Item> {

	private boolean lock = false; // die Sperre
	
	/**
	 * Die modifizierte Push-Funktion
	 * @param item
	 */
	@Override
	public void push(Item item){
		if(lock) // gem. Aufgabenstellung so gefordert
			throw new ConcurrentModificationException();
		super.push(item);
	}
	
	/**
	 * Die modifizierte pop-Funktion
	 * @return
	 */
	@Override
	public Item pop(){
		if(lock) // gem. Aufgabenstellung so gefordert
			throw new ConcurrentModificationException();
		return super.pop();
	}
	
	//Anonyme Klasse Iterator
	@Override
		public Iterator<Item> iterator(){
			return new ListIterator();
		}
		

		private class ListIterator implements Iterator<Item>{
			private Knoten<Item> current = first;
			public boolean hasNext(){
				if(current != null) // es wird noch iteriert
					lock = true;
				else				// fertig -> Lock freigeben
					lock = false;
				return (current != null);
			}
			public Item next(){
				Item item = current.item;
				current = current.next;
				return item;
			}
			@Override
			public void remove() {
				// tut nix tun
			}
		}
}
