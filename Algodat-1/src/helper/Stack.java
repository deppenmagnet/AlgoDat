/**
 * Der Stack gemäß Vorlesung.
 */
package helper;

import java.lang.reflect.Array;

/**
 * @author Stefan Lange
 *
 */
public class Stack<Item> {
	
	private int numberOfElements;
	private Item[] a;
	private Class<Item[]> theClass;
	
	/**
	 * Der Konstruktor
	 * @param theClass
	 */
	public Stack(Class<Item[]> theClass){
		this.numberOfElements = 0;
		// Vorschlag aus der Vorlesung
		// Nachteil: Keine Typsicherheit:
		//this.a =  (Item[]) new Object[1];
		
		// Daher im Konstruktor das Argument Class erweitert, 
		// damit lässt sich nun ein typsicheres Array erstellen
		this.theClass = theClass;
		a = theClass.cast(Array.newInstance(theClass.getComponentType(), 1));	
	}
	
	/**
	 * Legt ein Objekt auf den Stack
	 * @param Item
	 */
	public void push (Item i){
		if(this.numberOfElements == a.length)
			resize(2*a.length);
		a[this.numberOfElements++] = i;
		
	}

	/**
	 * Holt ein Object vom Stack
	 * @return Object
	 */
	public Item pop(){
		if(this.numberOfElements == 0)
			throw new StackUnderflowException();
		Item rc = a[--this.numberOfElements];
		a[this.numberOfElements] = null; // GCollector
		if(this.numberOfElements > 0 && this.numberOfElements == a.length/4)
			resize(a.length/2);
		return rc;
	}
	
	/**
	 * ist der Stack leer???
	 * @return
	 */
	public boolean isEmpty(){
		return (this.numberOfElements == 0);
	}
	
	/**
	 * wie groß ist der Stack im Moment?
	 * @return
	 */
	public int size(){
		return this.numberOfElements;
	}
	
	/**
	 * passt die Stack-Größe an
	 * @param max
	 */
	private void resize(int max){
		Item[] temp = this.theClass.cast(Array.newInstance(
				theClass.getComponentType(), max));
		for(int i = 0; i < this.numberOfElements; i++)
			temp[i] = a[i];
		a = temp;
		temp = null;
	}
	

}
