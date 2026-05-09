package services;

import java.util.ArrayList;
import models.User;
import models.Customer;
import models.Address;
import models.Parcel;
import models.ParcelStatus;
import models.Role;
import models.Admin;
import models.DeliveryAgent;

public class ParcelService {

    private FileService fileService = new FileService();
    private ArrayList<Parcel> parcels = new ArrayList<>();
    String filePath = "/media/zaki/workspace1/BCS2/OOP/LAB/SwiftShip/Parcels.txt";
    public ArrayList<Parcel> getParcels() {
        return parcels;
    }
    private int counter = 1000;

    public Parcel requestParcel(User user, String receiverName, String receiverEmail,
            Address address, double weight) {
        if (user.getRole() != Role.CUSTOMER) {
            System.out.println("Access Denied! Not a customer");
            return null;
        }

        Customer sender = (Customer) user;

        Parcel p = new Parcel(sender, receiverName, receiverEmail, address, weight);
        parcels.add(p);

        System.out.println("Parcel request submitted for admin approval");

        return p;
    }

    public void approveParcel(User user, Parcel parcel) {
        if (user.getRole() != Role.ADMIN) {
            System.out.println("Access Denied! Only Admin Can Approve Parcel");
            return;
        }
        parcel.calculateCost();
        parcel.showCostBreakdown();
        parcel.generateTrackingId();
        parcel.updateStatus(ParcelStatus.APPROVED, "Admin Approved Parcel");
        System.out.println("Tracking Id Generated: " + parcel.getTrackingId());
        System.out.println("Tracking Id sent to sender & reciever");
        fileService.updateParcelFile(parcel, filePath);
    }

    public void assignAgent(User user, Parcel parcel, DeliveryAgent agent) {
        if (user.getRole() != Role.ADMIN) {
            System.out.println("Only admin can assign delivery agents");
            return;
        }

        parcel.assignAgent(agent);
        System.out.println("Delivery agent assigned successfully");
    }

    public void updateDeliveryStatus(User user, Parcel parcel, ParcelStatus status, String location) {

        if (user.getRole() != Role.DELIVERY_AGENT) {
            System.out.println("Only delivery agents can update delivery status");
            return;
        }

        parcel.updateStatus(status, location);

        System.out.println("Parcel status updated: " + parcel.getStatus());

        fileService.updateParcelFile(parcel, filePath);
    }

    public void showAllParcels(User user) {

        if (user.getRole() != Role.ADMIN) {

            System.out.println("Only admin can view all parcels");
            return;
        }

        for (int i = 0; i < parcels.size(); i++) {

            Parcel p = parcels.get(i);

            System.out.println(
                    "Tracking ID: " + p.getTrackingId()
            );

            System.out.println(
                    "Sender: " + p.getSender().getName()
            );

            System.out.println(
                    "Receiver: " + p.getReceiverName()
            );

            System.out.println(
                    "Status: " + p.getStatus()
            );

            if (p.getAssignedAgent() != null) {

                System.out.println(
                        "Agent: "
                        + p.getAssignedAgent().getName()
                );
            }

            System.out.println("-------------------");
        }
        FileService fs = new FileService();
        fs.readParcels(filePath);
    }

    public void trackParcel(String trackingId) {

        for (int i = 0; i < parcels.size(); i++) {
            Parcel p = parcels.get(i);
            if (p.getTrackingId() != null
                    && p.getTrackingId().equals(trackingId)) {

                p.showTrackingHistory();
                return;
            }
        }

        System.out.println("Parcel not found");
    }

    public ArrayList<Parcel> getAllParcels() {
        return parcels;
    }

    public ArrayList<Parcel> getParcelsByStatus(ParcelStatus status) {
        ArrayList<Parcel> filteredParcels = new ArrayList<>();
        for (Parcel parcel : parcels) {
            if (parcel.getStatus() == status) {
                filteredParcels.add(parcel);
            }
        }
        return filteredParcels;
    }

    public ArrayList<Parcel> getParcelsByCustomer(Customer customer) {
        ArrayList<Parcel> customerParcels = new ArrayList<>();
        for (Parcel parcel : parcels) {
            if (parcel.getSender().equals(customer)) {
                customerParcels.add(parcel);
            }
        }
        return customerParcels;
    }

    public ArrayList<Parcel> getParcelsByAgent(DeliveryAgent agent) {
        ArrayList<Parcel> agentParcels = new ArrayList<>();
        for (Parcel parcel : parcels) {
            if (parcel.getAssignedAgent() != null && parcel.getAssignedAgent() == agent) {
                agentParcels.add(parcel);
            }
        }
        return agentParcels;
    }

    public Parcel getParcelByTrackingId(String trackingId) {
        if (trackingId == null) {
            return null;
        }
        for (Parcel parcel : parcels) {
            if (trackingId.equals(parcel.getTrackingId())) {
                return parcel;
            }
        }
        return null;
    }
}
