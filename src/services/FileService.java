package services;

import java.io.*;
import models.Parcel;

public class FileService {

    public void saveParcel(Parcel p, String filePath) {
        try {
            FileWriter fw = new FileWriter(filePath, true);

            fw.write("===== PARCEL RECORD =====\n");

            fw.write("Tracking ID: " + p.getTrackingId() + "\n");

            fw.write("Sender: " + p.getSender().getName() + "\n");
            fw.write("Sender Email: " + p.getSender().getEmail() + "\n");

            fw.write("Receiver: " + p.getReceiverName() + "\n");
            fw.write("Receiver Email: " + p.getReceiverEmail() + "\n");

            fw.write("Address: " + p.getAddress() + "\n");

            fw.write("Weight: " + p.getWeight() + "\n");

            fw.write("Price: " + p.getCost() + "\n");

            if (p.getAssignedAgent() != null) {
                fw.write("Agent: " + p.getAssignedAgent().getName() + "\n");
            }

            fw.write("Status: " + p.getStatus() + "\n");

            fw.write("=========================\n\n");

            fw.close();

        } catch (IOException e) {
            System.out.println("File write error: " + e.getMessage());
        }
    }

    public void updateParcelFile(java.util.ArrayList<Parcel> parcels, String filePath) {

        try {

            FileWriter fw = new FileWriter(filePath, false); // overwrite

            for (Parcel p : parcels) {

                fw.write("===== PARCEL RECORD =====\n");
                fw.write("Tracking ID: " + p.getTrackingId() + "\n");
                fw.write("Sender: " + p.getSender().getName() + "\n");
                fw.write("Receiver: " + p.getReceiverName() + "\n");
                fw.write("Status: " + p.getStatus() + "\n");

                if (p.getAssignedAgent() != null) {
                    fw.write("Agent: " + p.getAssignedAgent().getName() + "\n");
                }

                fw.write("----------------------\n\n");
            }

            fw.close();

        } catch (Exception e) {
            System.out.println("File update error: " + e.getMessage());
        }
    }

    public void readParcels(String filePath) {

        try {

            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("File read error: " + e.getMessage());
        }
    }
}
