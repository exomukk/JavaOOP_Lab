package hust.soict.cybersec.aims.media;

import java.util.*;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();
	
	public void addAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			authors.add(authorName);
		}
	}

	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
		}
	}
	
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}

	public List<String> getAuthhors() {
		return authors;
	}

	public void setAuthhors(List<String> authhors) {
		this.authors = authhors;
	}
	
	@Override
	public String toString() {
		return "Book - " + getId() + " - " + getTitle() + " - " + getAuthhors() + " - " + getCategory() + ": " + getCost() + " $";
	}

}
