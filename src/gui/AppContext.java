package gui;

import services.*;
import models.*;

public class AppContext {

    public static UserService userService = new UserService();
    public static ParcelService parcelService = new ParcelService();

    public static User currentUser;
}