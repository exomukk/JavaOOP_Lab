package hust.soict.cybersec.aims;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.disc.DigitalVideoDisc;

public class Aims{
	public static void main(String[] args) {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(
				"The Lion King", 
				"Animation", 
				"Roger Allers", 
				87,
				19.95f
		);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(
				"Star Wars",
				"Science Fiction",
				"George Lucas",
				87,
				24.95f
		);
		
		DigitalVideoDisc dvd3  = new DigitalVideoDisc(
				"Aladin",
				"Animation",
				"hieu",
				20,
				18.99f
		);
				
		cart.addDigitalVideoDisc(dvd3);
		cart.addDigitalVideoDisc(dvd1);
		cart.addDigitalVideoDisc(dvd2);
		
		cart.removeDigitalVideoDisc(dvd1);
		
		cart.printCart();
		
		System.exit(0);
	}
}