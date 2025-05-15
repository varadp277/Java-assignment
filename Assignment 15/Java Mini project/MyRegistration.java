import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class MyRegistration extends JFrame {

    public MyRegistration() {
        setTitle("My Registrations - College Event Management");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Sample table data
        String[] columnNames = {"Event Name", "Date", "Status"};
        Object[][] data = {
            {"Tech Talk", "2025-03-15", "Registered"},
            {"Code Sprint", "2025-03-16", "Confirmed"},
            {"Webinar", "2025-03-20", "Pending"}
        };

        JTable table = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(table);

        JLabel title = new JLabel("My Registered Events", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton backButton = new JButton("Back to Dashboard");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Dashboard(); // Replace with actual dashboard class
                dispose();
            }
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(backButton);

        // Add components to frame
        add(title, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MyRegistration();
    }
}
