package main;

import models.*;
import services.*;

public class Main {

    public static void main(String[] args) {

        ParcelService parcelService = new ParcelService();
        UserService userService = new UserService();

        Customer customer = new Customer(
                1,
                "Zaki",
                "zaki@gmail.com",
                "123"
        );

        Admin admin = new Admin(
                2,
                "Admin",
                "admin@gmail.com",
                "admin"
        );

        DeliveryAgent agent = new DeliveryAgent(
                3,
                "Ali Agent",
                "agent@gmail.com",
                "agent"
        );

        userService.addUser(customer);
        userService.addUser(admin);
        userService.addUser(agent);

        User loggedCustomer = userService.login("zaki@gmail.com", "123");
        User loggedAdmin = userService.login("admin@gmail.com", "admin");
        User loggedAgent = userService.login("agent@gmail.com", "agent");

        System.out.println("\n===== CUSTOMER REQUEST PARCEL =====");

        Address addr = new Address("Street 1", "Lahore");

        Parcel parcel = parcelService.requestParcel(
                loggedCustomer,
                "Ali",
                addr,
                2.5
        );

        if (parcel == null) return;

        System.out.println("\n===== ADMIN APPROVES PARCEL =====");

        parcelService.approveParcel(loggedAdmin, parcel);

        System.out.println("\n===== ADMIN ASSIGNS AGENT =====");

        parcelService.assignAgent(loggedAdmin, parcel, agent);

        System.out.println("\n===== AGENT UPDATES DELIVERY =====");

        parcelService.updateDeliveryStatus(
                loggedAgent,
                parcel,
                ParcelStatus.SHIPPED,
                "Lahore Hub"
        );

        parcelService.updateDeliveryStatus(
                loggedAgent,
                parcel,
                ParcelStatus.IN_TRANSIT,
                "On the way to destination"
        );

        parcelService.updateDeliveryStatus(
                loggedAgent,
                parcel,
                ParcelStatus.DELIVERED,
                "Delivered at customer address"
        );

        System.out.println("\n===== TRACK PARCEL =====");

        parcelService.trackParcel(parcel.getTrackingId());

        System.out.println("\n===== ADMIN VIEW ALL PARCELS =====");

        parcelService.showAllParcels(loggedAdmin);
    }
}