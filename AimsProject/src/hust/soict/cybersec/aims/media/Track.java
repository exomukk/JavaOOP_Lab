package hust.soict.cybersec.aims.media;

import hust.soict.cybersec.aims.exception.PlayerException;

public class Track implements Playable{
	private String title;
	private int length;

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getLength() {
		return length;
	}
	
	public boolean equals(Track track) {
		if(this.getTitle().equals(track.getTitle()) && this.getLength() == track.getLength()){
			return true;
		}
		return false;
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
