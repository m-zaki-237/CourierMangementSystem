package gui;

import javax.swing.*;
import models.*;

public class AdminPanel extends JFrame {

    public AdminPanel() {

        setTitle("Admin Panel");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JButton view = new JButton("View Parcels");
        view.setBounds(100, 50, 180, 30);

        JButton approve = new JButton("Approve First Parcel");
        approve.setBounds(100, 100, 180, 30);

        JButton assign = new JButton("Assign Agent");
        assign.setBounds(100, 150, 180, 30);

        JButton logout = new JButton("Logout");
        logout.setBounds(100, 180, 180, 30);

        add(view);
        add(approve);
        add(assign);
        add(logout);

        view.addActionListener(e ->
                AppContext.parcelService.showAllParcels(AppContext.currentUser)
        );

        approve.addActionListener(e -> {

            if (AppContext.parcelService.getParcels().isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "No Parcels Found");
                return;
            }

            Parcel p = AppContext.parcelService.getParcels().get(0);

            JOptionPane.showMessageDialog(
                    this,
                    "Approving Parcel Of: "
                    + p.getSender().getName()
                    + "\nReceiver: "
                    + p.getReceiverName()
            );

            AppContext.parcelService.approveParcel(
                    AppContext.currentUser,
                    p
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Parcel Approved\nTracking ID: "
                    + p.getTrackingId()
            );
        });

        assign.addActionListener(e -> {

            if (AppContext.parcelService.getParcels().isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "No Parcels Available");
                return;
            }

            Parcel p = AppContext.parcelService.getParcels().get(0);

            DeliveryAgent agent = null;

            for (User u : AppContext.userService.getUsers()) {

                if (u instanceof DeliveryAgent) {
                    agent = (DeliveryAgent) u;
                    break;
                }
            }

            if (agent != null) {

                AppContext.parcelService.assignAgent(
                        AppContext.currentUser,
                        p,
                        agent
                );

                JOptionPane.showMessageDialog(this,
                        "Agent Assigned");
            }
        });

        logout.addActionListener(e -> {

            dispose();
            AppContext.currentUser = null;
            new LoginFrame();
        });

        setVisible(true);
    }
}