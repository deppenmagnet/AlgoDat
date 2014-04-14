/**
 * Linked List gem. Vorlesung
 */
package helper;

import java.util.Iterator;

/**
 * @author Stefan Lange
 *
 */
public class LinkedList<Item> implements Iterable<Item>{
	protected Knoten<Item> first;
	private Knoten<Item> last;
	private int anzahlKnoten;
	
	public LinkedList(){
		first = null;
		last = null;
	}
	
	// Anonyme Klasse Knoten:
	class Knoten<Item>{
		Item item;
		Knoten<Item> next;
	}
	
	//Anonyme Klasse Iterator
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	
	protected class ListIterator implements Iterator<Item>{
		private Knoten<Item> current = first;
		public boolean hasNext(){
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
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return this.anzahlKnoten;
	}
	
	/**
	 * Element am Anfang einfügen
	 * Entspricht dem Push()
	 * @param item
	 */
	public void insertToHead(Item item){
		Knoten<Item> tmp = first;
		first = new Knoten<Item>();
		first.item = item;
		first.next = tmp;
		tmp = null;
		this.anzahlKnoten++;
	}
	
	/**
	 * Element vom Anfang zurückgeben
	 * Entspricht dem Pop bzw. dem dequeue
	 * @return
	 */
	public Item getFromHead(){
		Item item = first.item;
		first = first.next;
		if(isEmpty()){
			last = null;
			this.anzahlKnoten = 0;
		}else
			this.anzahlKnoten--;
		return item;
	}
	
	/**
	 * Element an das Ende einhängen
	 * Entspricht dem Enqueue
	 * @param item
	 */
	public void insertToTail(Item item){
		Knoten<Item> tmp = last;
		last = new Knoten<Item>();
		last.item = item;
		last.next = null;
		if(isEmpty()) 
			first= last;
		else
			tmp.next = last;
		this.anzahlKnoten++;
	}
	


}
