package assignment2;

import java.util.ArrayList;
import java.util.List;

public class TourPackage {
    private int id;
    private String name;
    private double price;
    private int seatsAvailable;
    private List<ItineraryItem> itineraryItems = new ArrayList<>();

    public TourPackage(int id, String name, double price, int seatsAvailable) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.seatsAvailable = seatsAvailable;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getSeatsAvailable() { return seatsAvailable; }

    public void addItineraryItem(ItineraryItem item) {
        itineraryItems.add(item);
    }

    public void reduceSeats(int count) {
        seatsAvailable -= count;
    }

    public void increaseSeats(int count) {
        seatsAvailable += count;
    }

    public void displayItinerary() {
        for (ItineraryItem item : itineraryItems) {
            System.out.println("  - " + item.getDescription() + " (" + item.getDay() + ")");
        }
    }

    public void display() {
        System.out.println("Package ID: " + id + " | Name: " + name + " | Price: " + price + " | Seats: " + seatsAvailable);
        displayItinerary();
    }
}