package hust.soict.cybersec.aims.media;

import hust.soict.cybersec.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
	public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
		super(id, title, category, director, length, cost);
		this.setId(id);
		this.setTitle(title);
		this.setCategory(category);
		this.setDirector(director);
		this.setLength(length);
		this.setCost(cost);
	}
	
	// toString method for DigitalVideoDisc class
	@Override
	public String toString() {
		return "DVD - " + getId() + " - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
	}

	@Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            System.err.println("ERROR: Track length is non-positive");
            throw new PlayerException("Track length is non-positive");
        } else {
	        System.out.println("Playing Track: " + this.getTitle());
	        System.out.println("Track length: " + this.getLength());
        }
    }
}
