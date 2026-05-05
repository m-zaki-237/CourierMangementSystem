package models;

public class DeliveryAgent extends User {

    public DeliveryAgent(int id, String name, String email, String password) {
        super(id, name, email, password, Role.DELIVERY_AGENT);
    }

    @Override
    public void login() {
        System.out.println("Delivery Agent logged in");
    }
}