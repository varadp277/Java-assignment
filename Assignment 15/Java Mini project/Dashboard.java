import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame {
    public Dashboard() {
        setTitle("Dashboard - College Event Management");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Main panel with a background color
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setBackground(new Color(245, 245, 245)); // Light background color

        // Buttons with attractive colors and font
        JButton addEventButton = new JButton("Add Event");
        addEventButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        addEventButton.setBackground(new Color(0, 204, 0)); // Green
        addEventButton.setForeground(Color.WHITE);
        addEventButton.setFocusPainted(false);
        addEventButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addEventButton.setBorder(BorderFactory.createLineBorder(new Color(0, 204, 0), 2));
        addEventButton.setPreferredSize(new Dimension(200, 50));
        
        JButton viewEventsButton = new JButton("View Event List");
        viewEventsButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        viewEventsButton.setBackground(new Color(0, 204, 255)); // Light Blue
        viewEventsButton.setForeground(Color.WHITE);
        viewEventsButton.setFocusPainted(false);
        viewEventsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewEventsButton.setBorder(BorderFactory.createLineBorder(new Color(0, 204, 255), 2));
        viewEventsButton.setPreferredSize(new Dimension(200, 50));
        
        JButton registerEventButton = new JButton("Register for Event");
        registerEventButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        registerEventButton.setBackground(new Color(255, 165, 0)); // Orange
        registerEventButton.setForeground(Color.WHITE);
        registerEventButton.setFocusPainted(false);
        registerEventButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerEventButton.setBorder(BorderFactory.createLineBorder(new Color(255, 165, 0), 2));
        registerEventButton.setPreferredSize(new Dimension(200, 50));
        
        JButton myRegistrationButton = new JButton("My Registrations");
        myRegistrationButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        myRegistrationButton.setBackground(new Color(255, 105, 180)); // Pink
        myRegistrationButton.setForeground(Color.WHITE);
        myRegistrationButton.setFocusPainted(false);
        myRegistrationButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        myRegistrationButton.setBorder(BorderFactory.createLineBorder(new Color(255, 105, 180), 2));
        myRegistrationButton.setPreferredSize(new Dimension(200, 50));
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        logoutButton.setBackground(new Color(255, 69, 58)); // Red
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFocusPainted(false);
        logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutButton.setBorder(BorderFactory.createLineBorder(new Color(255, 69, 58), 2));
        logoutButton.setPreferredSize(new Dimension(200, 50));

        // Action listeners for buttons
        addEventButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddEvent(); // Open Add Event page
                dispose(); // Close Dashboard window
            }
        });

        viewEventsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new EventList(); // Open Event List page
                dispose(); // Close Dashboard window
            }
        });

        registerEventButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RegisterEvent(); // Open Register Event page
                dispose(); // Close Dashboard window
            }
        });

        myRegistrationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MyRegistration(); // Open My Registration page
                dispose(); // Close Dashboard window
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login(); // Go back to Login page
                dispose(); // Close Dashboard window
            }
        });

        // Add buttons to the panel
        panel.add(addEventButton);
        panel.add(viewEventsButton);
        panel.add(registerEventButton);
        panel.add(myRegistrationButton);
        panel.add(logoutButton);

        // Set the background color for the window
        getContentPane().setBackground(new Color(230, 230, 230)); // Light grey background

        // Add the main panel to the frame
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
