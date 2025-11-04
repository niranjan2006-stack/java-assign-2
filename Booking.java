package assignment2;

public class Booking {
    private int bookingId;
    private Customer customer;
    private TourPackage tourPackage;
    private int seatsBooked;
    private boolean confirmed;
    private Payment payment;

    public Booking(int bookingId, Customer customer, TourPackage tourPackage, int seatsBooked) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.tourPackage = tourPackage;
        this.seatsBooked = seatsBooked;
        this.confirmed = false;
    }

    public int getBookingId() { return bookingId; }
    public Customer getCustomer() { return customer; }
    public TourPackage getTourPackage() { return tourPackage; }
    public int getSeatsBooked() { return seatsBooked; }
    public boolean isConfirmed() { return confirmed; }

    public void confirmBooking() {
        this.confirmed = true;
        tourPackage.reduceSeats(seatsBooked);
    }

    public void cancelBooking() {
        tourPackage.increaseSeats(seatsBooked);
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Payment getPayment() { return payment; }
}