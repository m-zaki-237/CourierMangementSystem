package models;

public class Admin extends User {

    public Admin(int id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void login() {
        System.out.println("Admin logged in");
    }
}