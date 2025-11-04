package assignment2;

public class Payment {
    private int paymentId;
    private double amount;
    private boolean completed;

    public Payment(int paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.completed = false;
    }

    public void completePayment() {
        this.completed = true;
    }

    public boolean isCompleted() { return completed; }

    public void displayReceipt() {
        System.out.println("Payment ID: " + paymentId + " | Amount: " + amount + " | Status: " + (completed ? "Completed" : "Pending"));
    }
}