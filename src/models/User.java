package models;

public abstract class User {

    protected int id;
    protected String name;
    protected String email;
    protected String password;
    protected Role role;
    
    public User(int id, String name, String email, String password, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public abstract void login();
    
    public Role getRole(){
        return role;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword(){
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User other = (User) obj;
        return id == other.id && role == other.role;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(id);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

}
