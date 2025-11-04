package assignment2;

public class Cancellation {
    private int cancelId;
    private Booking booking;
    private double refundAmount;
    private double cancellationFee;

    public Cancellation(int cancelId, Booking booking) {
        this.cancelId = cancelId;
        this.booking = booking;
        this.cancellationFee = booking.getTourPackage().getPrice() * 0.1;
        this.refundAmount = booking.getTourPackage().getPrice() - cancellationFee;
    }

    public void displayCancellationSummary() {
        System.out.println("Cancellation ID: " + cancelId);
        System.out.println("Booking ID: " + booking.getBookingId());
        System.out.println("Fee: " + cancellationFee + " | Refund: " + refundAmount);
    }
}