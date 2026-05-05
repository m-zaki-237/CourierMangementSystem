package models;

public class Customer extends User {

    public Customer(int id, String name, String email, String password) {
        super(id, name, email, password, Role.CUSTOMER);
    }

    @Override
    public void login() {
        System.out.println("Customer Logged in");
    }
}
