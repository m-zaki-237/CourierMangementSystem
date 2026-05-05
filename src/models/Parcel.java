package models;
import java.util.ArrayList;

public class Parcel {
    private String trackingId;
    private Customer sender;
    private String receiverName;
    private Address address;
    private double weight;
    private ParcelStatus status;


    public ArrayList<TrackingRecord> getTrackingHistory() {
        return trackingHistory;
    }
    
    private ArrayList<TrackingRecord> trackingHistory;

    public Parcel(String trackingId, Customer sender, String receiverName, Address address,
            double weight) {
        this.trackingId = trackingId;
        this.sender = sender;
        this.receiverName = receiverName;
        this.address = address;
        this.weight = weight;
        
        this.status = ParcelStatus.CREATED;
        
        this.trackingHistory = new ArrayList<>();
        
        trackingHistory.add(new TrackingRecord(status, "Warehouse"));
    }
    
    public void updateStatus(ParcelStatus newStatus, String location){
        this.status = newStatus;
        trackingHistory.add(new TrackingRecord(newStatus, location));
    }
    
    public void showTrackingHistory(){
        System.out.println("Tracking ID: " + trackingId);
        for(int i = 0; i < trackingHistory.size(); i++){
            TrackingRecord record = trackingHistory.get(i);
            
            System.out.println(record.getStatus() + " | " + record.getLocation() + " | " + record.getTimeStamp());
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
    
}
