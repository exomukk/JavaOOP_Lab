package hust.soict.cybersec.aims.cart;

import hust.soict.cybersec.aims.media.*;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private Media itemsOrdered[] = new Media[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addMedia(Media media) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = media;
			qtyOrdered++;
			System.out.println("The media " + media.getTitle() + " has been added.");
		} else {
			System.out.println("The cart is almost full.");
		}
	}
	
	public void removeMedia(Media media) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].equals(media)) {
				System.arraycopy(itemsOrdered, i + 1, itemsOrdered, i, qtyOrdered - i - 1);
				qtyOrdered--;
				System.out.println("The media " + media.getTitle() + " has been removed.");
				return;
			}
		}
		System.out.println("The media was not found in the cart.");
	}
	
	public float totalCost() {
		float total = 0.0f;
		for (int i = 0; i < qtyOrdered; i++) {
			total += itemsOrdered[i].getCost();
		}
		total = Math.round(total * 100.0f) / 100.0f;
		return total;
	}
	
// customize print to console
	public void printCart() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items: ");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
		}
		
		System.out.println("Total cost: " + totalCost() + " $");
		System.out.println("***************************************************");
	}
	
//	Search by ID method
	public void searchByID(int id) {
		if (id < 0 || id >= qtyOrdered) {
			System.out.println("No match found");
		} else {
			System.out.println("Match found: " + itemsOrdered[id].toString());
		}
	}
	
//	Search by title method
	public void searchByTitle(String title) {
		boolean found = false;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].isMatch(title)) {
				System.out.println("Match found: " + itemsOrdered[i].toString());
				found = true;
			}
		}
		
		if (!found) {
			System.out.println("No match found");
		}
	}
}
