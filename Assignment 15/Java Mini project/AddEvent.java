import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddEvent extends JFrame {
    public AddEvent() {
        setTitle("Add Event - College Event Management");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Main panel with a light background color
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setBackground(new Color(245, 245, 245)); // Light background color

        // Label and text field setup
        JLabel nameLabel = new JLabel("Event Name:");
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        JTextField eventNameField = new JTextField(20);
        eventNameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        eventNameField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));

        JLabel dateLabel = new JLabel("Event Date (yyyy-mm-dd):");
        dateLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        JTextField eventDateField = new JTextField(20);
        eventDateField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        eventDateField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));

        JLabel venueLabel = new JLabel("Event Venue:");
        venueLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        JTextField eventVenueField = new JTextField(20);
        eventVenueField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        eventVenueField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));

        // Buttons with modern styling
        JButton saveButton = new JButton("Save Event");
        saveButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        saveButton.setBackground(new Color(0, 204, 0)); // Green
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusPainted(false);
        saveButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        saveButton.setBorder(BorderFactory.createLineBorder(new Color(0, 204, 0), 2));
        saveButton.setPreferredSize(new Dimension(200, 50));

        JButton backButton = new JButton("Back to Dashboard");
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        backButton.setBackground(new Color(255, 69, 58)); // Red
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setBorder(BorderFactory.createLineBorder(new Color(255, 69, 58), 2));
        backButton.setPreferredSize(new Dimension(200, 50));

        // Add components to the panel
        panel.add(nameLabel);
        panel.add(eventNameField);
        panel.add(dateLabel);
        panel.add(eventDateField);
        panel.add(venueLabel);
        panel.add(eventVenueField);
        panel.add(saveButton);
        panel.add(backButton);

        // ActionListener for Save Event button
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = eventNameField.getText();
                String date = eventDateField.getText();
                String venue = eventVenueField.getText();

                // Validate inputs
                if (name.isEmpty() || date.isEmpty() || venue.isEmpty()) {
                    JOptionPane.showMessageDialog(AddEvent.this, "Please fill all fields.");
                    return;
                }

                // Insert event into the database
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/event_system", "root", "root" // <-- Change password here
                    );

                    String query = "INSERT INTO events (title, description, date, location) VALUES (?, ?, ?, ?)";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, name);
                    pst.setString(2, "N/A"); // description not in UI
                    pst.setString(3, date);
                    pst.setString(4, venue);

                    int rows = pst.executeUpdate();
                    if (rows > 0) {
                        JOptionPane.showMessageDialog(AddEvent.this, "✅ Event added successfully!");
                        eventNameField.setText("");
                        eventDateField.setText("");
                        eventVenueField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(AddEvent.this, "❌ Failed to add event.");
                    }

                    con.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(AddEvent.this, "Error: " + ex.getMessage());
                }
            }
        });

        // ActionListener for Back button
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Dashboard(); // Go back to Dashboard
                dispose(); // Close AddEvent window
            }
        });

        // Add the panel to the frame
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddEvent();
    }
}
