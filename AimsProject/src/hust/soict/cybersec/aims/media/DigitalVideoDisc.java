package hust.soict.cybersec.aims.media;

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
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
