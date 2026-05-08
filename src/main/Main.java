import gui.LoginFrame;
import services.UserService;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserService();

        new LoginFrame(userService);
    }
}