package models;

import java.util.ArrayList;

public class Parcel {

    private String trackingId;
    private Customer sender;
    private String receiverName;
    private Address address;
    private double weight;
    private ParcelStatus status;

    private DeliveryAgent assignedAgent;

    public ArrayList<TrackingRecord> getTrackingHistory() {
        return trackingHistory;
    }

    private ArrayList<TrackingRecord> trackingHistory;

    public Parcel(Customer sender, String receiverName, Address address,
            double weight) {
        this.trackingId = null;
        this.sender = sender;
        this.receiverName = receiverName;
        this.address = address;
        this.weight = weight;

        this.status = ParcelStatus.PENDING_APPROVAL;

        this.trackingHistory = new ArrayList<>();

        trackingHistory.add(new TrackingRecord(ParcelStatus.PENDING_APPROVAL, "Parcel request submitted"));
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

    public String getTrackingId() {
        return trackingId;
    }

    public Customer getSender() {
        return sender;
    }

    public String getReceiverName() {
        return receiverName;
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
