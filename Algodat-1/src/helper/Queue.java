/**
 * 
 */
package helper;

import java.lang.reflect.Array;

/**
 * @author Stefan Lange
 * 
 * Ich würde ja nie im Leben eine Queue auf einem Array aufbauen, aber
 * da der Prof das so wünscht...here we go
 * 
 * P.S.: kann es sein, dass das Queue auf den Vorlesungsfolien nicht drauf ist?
 *
 */
public class Queue <Item>{
	private int erstesElement;
	private int letztesElement;
	// Zur Typ-Sicherung:
	private Class <Item[]> theClass;
	// und das komische Array
	Item[] a;
	
	/**
	 * Der Konstruktor
	 * @param theClass
	 */
	public Queue(Class<Item[]> theClass){
		this.erstesElement=0;
		this.letztesElement=0;
		this.theClass = theClass;
		//Array initialisieren:
		a = theClass.cast(Array.newInstance(theClass.getComponentType(), 1));
	}
	
	/**
	 * Hängt ein Item i hinten an die Warteschlange an
	 * @param i
	 */
	public void enqueue(Item i){
		if (this.letztesElement == a.length){
			resize(2*a.length);
		}
		a[this.letztesElement++] = i;
	}
	
	/**
	 * Gibt das Erste Element in der Schlange zurück
	 * @return
	 */
	public Item dequeue(){
		if(this.letztesElement < this.erstesElement)
			throw new QueueEmptyException();
		Item rc = a[this.erstesElement];
		a[this.erstesElement++]= null; // garbage collect
		// Test ob das Array im ersten Viertel leer ist:
		if(this.letztesElement-this.erstesElement > 0 && // überhaupt noch was
				this.erstesElement == a.length/4)
			shrinkArray();
		return rc;
	}

	/** 
	 * Schneidet den leeren Anfang des alten Arrays ab
	 */
	private void shrinkArray() {
		Item[] temp = theClass.cast(Array.newInstance(
				theClass.getComponentType(), (this.letztesElement-
						this.erstesElement)));
		for (int i = 0; i < temp.length; i++)
			temp[i] = a[this.erstesElement+i];
		// Indizes anpassen
		this.erstesElement = 0;
		this.letztesElement = temp.length;
		a = temp;
		temp = null;
	}
	
	/**
	 * Gibt zurück, ob noch was in der Queue ist
	 * @return
	 */
	public boolean isEmpty(){
		return(this.letztesElement <= this.erstesElement);
	}
	
	/**
	 * Gibt die Größe der Queue zurück
	 * @return
	 */
	public int size(){
		return (this.letztesElement-this.erstesElement);
	}

	/**
	 * Vergrößert das Array
	 * @param i
	 */
	private void resize(int max) {
		Item[] temp = theClass.cast(Array.newInstance(
				theClass.getComponentType(), max));
		for(int i = this.erstesElement; i < this.letztesElement; i++)
			temp[i] = a[i];
		a = temp;
		temp = null;
	}

}
