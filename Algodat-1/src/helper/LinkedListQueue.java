/**
 * 
 */
package helper;

/**
 * @author Stefan Lange
 *
 */
public class LinkedListQueue<Item> extends LinkedList<Item>{
	
	public LinkedListQueue(){
		super();
	}
	
	public void enqueue(Item item){
		this.insertToTail(item);
	}
	
	public Item dequeue(){
		return this.getFromHead();
	}

}
