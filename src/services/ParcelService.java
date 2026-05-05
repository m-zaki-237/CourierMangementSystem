package services;

import java.util.ArrayList;
import models.User;
import models.Customer;
import models.Address;
import models.Parcel;
import models.ParcelStatus;
import models.Role;

public class ParcelService {

    private ArrayList<Parcel> parcels = new ArrayList<>();
    private int counter = 1000;

    public String generateTrackingId() {
        return "PK" + counter++;
    }

    // ===== CREATE PARCEL (ONLY CUSTOMER) =====
    public Parcel createParcel(User user, String receiverName,
                               Address address, double weight) {

        if (user.getRole() != Role.CUSTOMER) {
            System.out.println("Access Denied: Only customers can create parcels");
            return null;
        }

        String id = generateTrackingId();

        Parcel p = new Parcel(id, (Customer) user, receiverName, address, weight);

        parcels.add(p);

        return p;
    }

    // ===== UPDATE STATUS (ADMIN / DELIVERY AGENT ONLY) =====
    public boolean updateStatus(User user, String trackingId,
                                ParcelStatus status, String location) {

        if (user.getRole() != Role.ADMIN &&
            user.getRole() != Role.DELIVERY_AGENT) {

            System.out.println("Access Denied: No permission to update status");
            return false;
        }

        Parcel p = getParcelById(trackingId);

        if (p != null) {
            p.updateStatus(status, location);
            return true;
        }

        return false;
    }

    // ===== GET PARCEL =====
    public Parcel getParcelById(String id) {

        for (int i = 0; i < parcels.size(); i++) {
            if (parcels.get(i).getTrackingId().equals(id)) {
                return parcels.get(i);
            }
        }

        return null;
    }

    // ===== TRACK PARCEL (ALL USERS ALLOWED) =====
    public void trackParcel(String id) {

        Parcel p = getParcelById(id);

        if (p != null) {
            p.showTrackingHistory();
        } else {
            System.out.println("Parcel not found");
        }
    }
}