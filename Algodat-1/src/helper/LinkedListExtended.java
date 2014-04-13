/**
 * 
 */
package helper;

/**
 * @author Stefan Lange
 *
 */
public class LinkedListExtended<Item> extends LinkedList<Item> {
	
	public boolean delete(int elementNummer){
		if(elementNummer > this.size())
			return false;
		else{
			Knoten<Item> tmp = first;
			// Den Knoten vor dem zu Löschenden suchen
			for (int i = 0; i < (elementNummer -1); i++)
				tmp = tmp.next;
			// Nun den zu löschenden Knoten aushängen
		tmp.next = tmp.next.next;
		return true;
		}
	}
	
	public boolean find(Item item){
		boolean rc = false;
		Knoten<Item> tmp = first;
		// durch die Knotenliste laufen
		for(int i = 0; i < this.size(); i++){
			if(tmp.item.equals(item)){ // wenn gefunden: Abbruch
				rc = true;
				break;
			}
		}
		return rc;
	}
}
