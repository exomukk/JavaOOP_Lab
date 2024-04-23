package hust.soict.cybersec.test.store;

import hust.soict.cybersec.aims.media.*;
import hust.soict.cybersec.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		Store store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "Tom & Jerry", "Animation", "Director", 120, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "John Wick", "Action", "Director2", 100, 9.95f);

        // Test addDVD
        store.addDVD(dvd1);
        store.addDVD(dvd2);

        // Test removeDVD
        store.removeDVD(dvd1);
        
        // Print DVD
        store.printDVD();
	}
}
