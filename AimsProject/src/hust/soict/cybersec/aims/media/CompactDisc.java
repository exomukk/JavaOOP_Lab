package hust.soict.cybersec.aims.media;

import java.util.*;

import hust.soict.cybersec.aims.exception.PlayerException;

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
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            System.err.println("ERROR: CD length is non-positive");
            throw new PlayerException("CD length is non-positive");
        }

        Iterator<Track> iter = tracks.iterator();
        while (iter.hasNext()) {
            Track nextTrack = iter.next();
            try {
                nextTrack.play();
            } catch (PlayerException e) {
                System.err.println("ERROR: Cannot play track: " + nextTrack.getTitle());
                throw e;
            }
        }
    }
	
	@Override
	public String toString() {
		return "CD - " + getId() + " - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getArtist() + " - " + getLength() + ": " + getCost() + " $";
	}

}
