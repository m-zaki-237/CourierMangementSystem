package services;

import java.io.*;
import models.Parcel;

public class FileService {

    public void updateParcelFile(Parcel p, String filePath) {

        try {

            FileWriter fw = new FileWriter(filePath, true);

            fw.write("===== PARCEL UPDATE =====\n");
            fw.write("Tracking ID: " + p.getTrackingId() + "\n");
            fw.write("Sender: " + p.getSender().getName() + "\n");
            fw.write("Receiver: " + p.getReceiverName() + "\n");
            fw.write("Weight: " + p.getWeight() + "\n");
            fw.write("Weight per kg: 250 \n");
            fw.write("Total bill: " + p.getCost() + "\n");
            fw.write("Status: " + p.getStatus() + "\n");

            if (p.getAssignedAgent() != null) {
                fw.write("Agent: " + p.getAssignedAgent().getName() + "\n");
            }

            fw.write("----------------------\n\n");

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
