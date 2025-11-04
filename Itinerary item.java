package assignment2;

public class ItineraryItem {
    private String day;
    private String description;

    public ItineraryItem(String day, String description) {
        this.day = day;
        this.description = description;
    }

    public String getDay() { return day; }
    public String getDescription() { return description; }
}