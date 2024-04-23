package hust.soict.cybersec.aims.media;

import java.util.*;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();

	public String getArtist() {
		return artist;
	}

	public CompactDisc(int id, String title, String category, String director, int length, float cost, String artist) {
		super(id, title, category, director, length, cost);
		this.artist = artist;
	}
	
	public void addTrack(Track track) {
		if(tracks.contains(track)) {
			System.out.println("\n" + track.getTitle() + " already exist, cannot add!");
		}
		tracks.add(track);
		System.out.println("\nSuccessfully added " + track.getTitle() + "!");
	}
	
	public void removeTrack(Track track) {
		if(!tracks.contains(track)) {
			System.out.println("\n" + track.getTitle() + " does not exist, cannot remove!");
		}
		tracks.remove(track);
		System.out.println("\nSuccessfully removed " + track.getTitle() + "!");
	}
	
	@Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

	@Override
	public void play() {
		System.out.println("\nCD is containing " + tracks.size());
		System.out.println("Playing each track one by one");
		for(Track track : tracks) {
			System.out.println("*Playing track: " + track.getTitle());
			track.play();
		}
		System.out.println("CD finished playing");
	}
	
	@Override
	public String toString() {
		return "CD - " + getId() + " - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getArtist() + " - " + getLength() + ": " + getCost() + " $";
	}

}
