package models;

public class DeliveryAgent extends User {

    public DeliveryAgent(int id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void login() {
        System.out.println("Delivery Agent logged in");
    }
}