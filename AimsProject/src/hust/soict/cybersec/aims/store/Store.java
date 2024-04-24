package hust.soict.cybersec.aims.store;

import java.util.*;
import hust.soict.cybersec.aims.media.*;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<>();
	
	public void addMedia(Media media) {
		if (itemsInStore.size() < 100) {
			itemsInStore.add(media);
			System.out.println("The media " + media.getTitle() + " has been added to the store");
		} else {
			System.out.println("The store is full");
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			System.out.println("The media " + media.getTitle() + " has been removed from the store");
		} else {
			System.out.println("The media was not found in the store");
		}
	}
	
	public void printMedia() {
		System.out.println("Media in the store: ");
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
		}
	}
	
	/**Search for available Media inside the Store
	@return true if Media is available in the Store, false otherwise
	*/
	public Media search(String title) {
		for(Media item : itemsInStore) {
			if(item.isMatch(title)) {
				return item;
			}
		}
		return null;
		}
}
