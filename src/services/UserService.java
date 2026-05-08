package services;
import java.util.ArrayList;
import models.*;

public class UserService {
    private ArrayList<User> users = new ArrayList<>();
    
    public void addUser(User u){
        users.add(u);
    }
    
    public User login(String email, String password){
        for (int i = 0; i < users.size(); i++){
            User u = users.get(i);
            if(u.getEmail().equals(email) && u.getPassword().equals(password)){
                System.out.println("LOGIN ROLE: " + u.getRole());
                return u;
            }
        }
        return null;
    }
    
    public void showUsers(){
        for(int i = 0; i < users.size(); i++){
            System.out.println(users.get(i).getName());
        }
    }
    
    public ArrayList<User> getUsers() {
        return users;
    }
}
