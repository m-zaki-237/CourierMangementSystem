package gui;

import javax.swing.*;
import models.*;

public class CustomerPanel extends JFrame {

    public CustomerPanel() {

        setTitle("Customer Panel");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JButton request = new JButton("Request Parcel");
        request.setBounds(100, 80, 180, 30);

        JButton track = new JButton("Track Parcel");
        track.setBounds(100, 130, 180, 30);

        add(request);
        add(track);

        request.addActionListener(e -> {

            String receiverName
                    = JOptionPane.showInputDialog("Enter Receiver Name");

            String receiverEmail
                    = JOptionPane.showInputDialog("Enter Receiver Email");

            String street
                    = JOptionPane.showInputDialog("Enter Street");

            String city
                    = JOptionPane.showInputDialog("Enter City");

            String weightInput
                    = JOptionPane.showInputDialog("Enter Weight");

            double weight = Double.parseDouble(weightInput);

            Address addr = new Address(street, city);

            Parcel p = AppContext.parcelService.requestParcel(
                    AppContext.currentUser,
                    receiverName,
                    receiverEmail,
                    addr,
                    weight
            );

            if (p != null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Parcel Request Submitted Successfully"
                );
            }
        });

        track.addActionListener(e -> {

            String id
                    = JOptionPane.showInputDialog(
                            "Enter Tracking ID");

            if (id == null || id.isEmpty()) {
                return;
            }

            boolean found = false;

            for (Parcel p : AppContext.parcelService.getParcels()) {

                if (p.getTrackingId() != null
                        && p.getTrackingId().replace(" ", "").equalsIgnoreCase(id.replace(" ", ""))) {

                    found = true;

                    String message
                            = "Tracking ID: "
                            + p.getTrackingId()
                            + "\nSender: "
                            + p.getSender().getName()
                            + "\nReceiver: "
                            + p.getReceiverName()
                            + "\nCurrent Status: "
                            + p.getStatus();

                    JOptionPane.showMessageDialog(
                            this,
                            message
                    );
                }
            }

            if (!found) {

                JOptionPane.showMessageDialog(
                        this,
                        "Parcel Not Found"
                );
            }
        });

        setVisible(true);

        JButton logout = new JButton("Logout");
        logout.setBounds(100, 180, 180, 30);
        add(logout);

        logout.addActionListener(e -> {

            dispose();

            AppContext.currentUser = null;

            new LoginFrame();
        });
    }
}
