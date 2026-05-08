package gui;

import javax.swing.*;
import models.*;

public class LoginFrame extends JFrame {

    JTextField email;
    JPasswordField password;

    public LoginFrame() {

        setTitle("Login");
        setSize(300, 200);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel e = new JLabel("Email");
        e.setBounds(20, 20, 80, 25);
        add(e);

        email = new JTextField();
        email.setBounds(100, 20, 150, 25);
        add(email);

        JLabel p = new JLabel("Password");
        p.setBounds(20, 60, 80, 25);
        add(p);

        password = new JPasswordField();
        password.setBounds(100, 60, 150, 25);
        add(password);

        JButton login = new JButton("Login");
        login.setBounds(100, 110, 100, 30);
        add(login);

        login.addActionListener(e1 -> loginUser());

        setVisible(true);
    }

    void loginUser() {

        User u = AppContext.userService.login(
                email.getText(),
                new String(password.getPassword())
        );

        if (u == null) {
            JOptionPane.showMessageDialog(this, "Invalid login");
            return;
        }

        AppContext.currentUser = u;

        dispose();
        RoleRouter.openDashboard(u);
    }
}