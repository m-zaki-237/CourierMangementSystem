package models;

public class Customer extends User {

    public Customer(int id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void login() {
        System.out.println("Customer Logged in");
    }
}
