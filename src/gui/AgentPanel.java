package gui;

import javax.swing.*;
import models.*;

public class AgentPanel extends JFrame {

    public AgentPanel() {

        setTitle("Agent Panel");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JButton update = new JButton("Update Status");
        update.setBounds(100, 100, 180, 30);

        add(update);

        update.addActionListener(e -> {

            if (AppContext.parcelService.getParcels().isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "No Parcels Found");

                return;
            }

            Parcel p
                    = AppContext.parcelService.getParcels().get(0);

            String location
                    = JOptionPane.showInputDialog(
                            "Enter Current Location");

            ParcelStatus status = (ParcelStatus) JOptionPane.showInputDialog(
                    this,
                    "Select Status",
                    "Update Status",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    ParcelStatus.values(),
                    ParcelStatus.IN_TRANSIT
            );
            if (status == null) {
                return;
            }

            AppContext.parcelService.updateDeliveryStatus(
                    AppContext.currentUser,
                    p,
                    status,
                    location
            );

            JOptionPane.showMessageDialog(this,
                    "Delivery Status Updated");
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
