package hust.soict.cybersec.test.store;

import hust.soict.cybersec.aims.media.*;
import hust.soict.cybersec.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		Store store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "Tom & Jerry", "Animation", "Director", 120, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "John Wick", "Action", "Director2", 100, 9.95f);
        CompactDisc cd1 = new CompactDisc(3, "Fly me to the moon", "Old School", "Director2", 90, 10.95f, "Frank Sinatra");

        // Test addDVD
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(cd1);

        // Test removeDVD
        store.removeMedia(dvd1);
        
        // Print DVD
        store.print();
	}
}
