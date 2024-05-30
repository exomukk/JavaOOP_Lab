package hust.soict.cybersec.test.cart;

import javax.naming.LimitExceededException;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.DigitalVideoDisc;

public class CartTest{
	public static void main(String[] args) throws LimitExceededException {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(
				1,
				"The Lion King", 
				"Animation", 
				"Roger Allers", 
				87,
				19.95f
		);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(
				2,
				"Star Wars",
				"Science Fiction",
				"George Lucas",
				87,
				24.95f
		);
		
		DigitalVideoDisc dvd3  = new DigitalVideoDisc(
				3,
				"Aladin",
				"Animation",
				"hieu",
				20,
				18.99f
		);
				
		cart.addMedia(dvd3);
		cart.addMedia(dvd1);
		cart.addMedia(dvd2);
		
		cart.removeMedia(dvd1);
		
		cart.print();
		
		System.exit(0);
	}
}
