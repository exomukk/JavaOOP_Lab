package hust.soict.cybersec.aims.store;
import hust.soict.cybersec.aims.media.*;

public class Store {
	private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[100];
	private int count = 0;
	
	public void addDVD(DigitalVideoDisc dvd) {
		if (count < itemsInStore.length) {
			itemsInStore[count] = dvd;
			count++; 
			System.out.println("The DVD has been added to the store");
		} else {
			System.out.println("The store is full");
		}
	}
	
	public void removeDVD(DigitalVideoDisc dvd) {
		for (int i = 0; i < count; i++) {
			if (itemsInStore[i].equals(dvd)) {
				System.arraycopy(itemsInStore, i+1, itemsInStore, i, count-i-1);
				count--;
				System.out.println("The DVD has benn removed from the store");
				return;
			}
		}
		
		System.out.println("The DVD was not found in the store");
	}
	
	public void printDVD() {
		System.out.println("DVDs in the store: ");
		for (int i = 0; i < count; i++) {
			System.out.println((i + 1) + ". " + itemsInStore[i].toString());
		}
	}
}
