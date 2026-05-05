package models;

public abstract class User {

    protected int id;
    protected String name;
    protected String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public abstract void login();

    public int getId() {
        return id;
    };
    
    public String getName() {
        return name;
    };
    
    public String getEmail() {
        return email;
    };

}
