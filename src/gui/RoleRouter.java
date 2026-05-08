package gui;

import models.*;

public class RoleRouter {

    public static void openDashboard(User u) {

        switch (u.getRole()) {

            case ADMIN -> new AdminPanel();
            case CUSTOMER -> new CustomerPanel();
            case DELIVERY_AGENT -> new AgentPanel();
        }
    }
}