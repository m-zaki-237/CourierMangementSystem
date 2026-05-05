package models;
import java.time.LocalDateTime;

public class TrackingRecord {
    private ParcelStatus status;
    private String location;
    private LocalDateTime timeStamp;


    public TrackingRecord(ParcelStatus status, String location) {
        this.status = status;
        this.location = location;
        this.timeStamp = LocalDateTime.now();
    }
    
    public ParcelStatus getStatus() {
        return status;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
    
    
    
}
