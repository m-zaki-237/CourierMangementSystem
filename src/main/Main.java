package main;

import models.*;
import services.*;

public class Main {

    public static void main(String[] args) {

        // ===== Services =====
        UserService userService = new UserService();
        ParcelService parcelService = new ParcelService();

        // ===== Create Users =====
        Customer c1 = new Customer(1, "Zaki", "zaki@gmail.com", "123");

        userService.addUser(c1);

        // ===== Login Test =====
        User loggedUser = userService.login("zaki@gmail.com", "123");

        if (loggedUser != null) {
            System.out.println("Login Successful: " + loggedUser.getName());
        } else {
            System.out.println("Login Failed");
        }

        // ===== Create Address =====
        Address addr = new Address("Street 1", "Lahore");

        // ===== Create Parcel =====
        Parcel p1 = parcelService.createParcel(
                c1,
                "Ali",
                addr,
                2.5
        );

        System.out.println("Parcel Created with ID: " + p1.getTrackingId());

        // ===== Update Status =====
        parcelService.updateStatus(
                loggedUser,
                p1.getTrackingId(),
                ParcelStatus.SHIPPED,
                "Lahore Hub"
        );

        // ===== Track Parcel =====
        p1.showTrackingHistory();
    }
}
