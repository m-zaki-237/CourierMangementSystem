package main;

import gui.*;
import models.*;

public class Main {

    public static void main(String[] args) {

        AppContext.userService.addUser(
                new Customer(1, "Zaki", "zaki@gmail.com", "123")
        );
        AppContext.userService.addUser(
                new Customer(1, "Sheri", "sheri@gmail.com", "123")
        );

        AppContext.userService.addUser(
                new Admin(2, "Admin", "admin@gmail.com", "admin")
        );

        AppContext.userService.addUser(
                new DeliveryAgent(3, "Agent", "agent@gmail.com", "agent")
        );

        new LoginFrame();
    }
}