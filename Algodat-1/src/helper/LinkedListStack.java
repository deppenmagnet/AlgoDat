/**
 * Der Stack als Linked List
 */
package helper;

/**
 * @author Stefan Lange
 *
 */
public class LinkedListStack<Item> extends LinkedList<Item> {

	/**
	 * 
	 */
	public LinkedListStack() {
		super();
	}
	
	public void push(Item item){
		this.insertToHead(item);
	}
	
	public Item pop(){
		return this.getFromHead();
	}

}
