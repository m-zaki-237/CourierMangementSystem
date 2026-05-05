package services;
import models.*;

public class TrackingService {
    public void showTracking(Parcel p){
        if(p == null){
            System.out.println("Parcel not found");
            return;
        }
        
        System.out.println("Tracking ID: " + p.getTrackingId());
        p.getTrackingHistory();
    }
    
    public void printStatus(Parcel p){
        if(p != null){
            System.out.println("Current Status: " + p.getStatus());
        }
    }
}
