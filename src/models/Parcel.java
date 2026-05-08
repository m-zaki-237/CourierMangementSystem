package models;

import java.util.ArrayList;

public class Parcel {

    private String trackingId;
    private Customer sender;
    private String receiverName;
    private String receiverEmail;
    private Address address;
    private double weight;
    private double cost;
    private ParcelStatus status;

    private DeliveryAgent assignedAgent;

    public ArrayList<TrackingRecord> getTrackingHistory() {
        return trackingHistory;
    }

    private ArrayList<TrackingRecord> trackingHistory;

    public Parcel(Customer sender, String receiverName, String receiverEmail, Address address,
            double weight) {
        this.trackingId = null;
        this.sender = sender;
        this.receiverName = receiverName;
        this.receiverEmail = receiverEmail;
        this.address = address;
        this.weight = weight;

        this.status = ParcelStatus.PENDING_APPROVAL;

        this.trackingHistory = new ArrayList<>();

        trackingHistory.add(new TrackingRecord(ParcelStatus.PENDING_APPROVAL, "Parcel request submitted"));
    }

    public void calculateCost() {
        double ratePerKg = 250;
        double total = weight * ratePerKg;
        this.cost = total;
    }

    public void showCostBreakdown() {

        double ratePerKg = 250;

        System.out.println("----- COST BREAKDOWN -----");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Rate per kg: " + ratePerKg);
        System.out.println("Total Price: " + cost);
    }

    public void generateTrackingId() {
        this.trackingId = "SwS " + (int) (Math.random() * 100000);
    }

    public void assignAgent(DeliveryAgent agent) {
        this.assignedAgent = agent;
    }

    public void updateStatus(ParcelStatus status, String location) {
        this.status = status;
        trackingHistory.add(new TrackingRecord(status, location));
    }

    public void showTrackingHistory() {
        System.out.println("Tracking ID: " + trackingId);
        for (int i = 0; i < trackingHistory.size(); i++) {
            TrackingRecord record = trackingHistory.get(i);

            System.out.println(record.getStatus() + " | " + record.getLocation());
        }
    }

    public double getCost() {
        return cost;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public Customer getSender() {
        return sender;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public Address getAddress() {
        return address;
    }

    public double getWeight() {
        return weight;
    }

    public ParcelStatus getStatus() {
        return status;
    }

    public DeliveryAgent getAssignedAgent() {
        return assignedAgent;
    }

}
