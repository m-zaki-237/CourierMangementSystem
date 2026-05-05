package models;

public class Admin extends User {

    public Admin(int id, String name, String email, String password) {
        super(id, name, email, password, Role.ADMIN);
    }

    @Override
    public void login() {
        System.out.println("Admin logged in");
    }
}