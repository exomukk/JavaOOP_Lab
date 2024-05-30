package hust.soict.cybersec.aims.media;

public abstract class Media {
	
	private int id; 
	private String title;
	private String category;
	private float cost;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Media(int id, String title, String category, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	// equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Checks if both references point to the same object
        if (obj == null || getClass() != obj.getClass()) return false; // Checks for null and class type

        Media media = (Media) obj;

        return Double.compare(media.cost, cost) == 0 && title.equalsIgnoreCase(media.title);
    }

    // compareTo method
    public int compareTo(Media other) {
        if (other == null) throw new NullPointerException("Comparing media with null");

        // First compare by title
        int titleComparison = this.title.compareToIgnoreCase(other.title);
        if (titleComparison != 0) {
            return titleComparison;
        }

        // If titles are the same, compare by cost
        return Double.compare(this.cost, other.cost);
    }

    // isMatch method
    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }

}
