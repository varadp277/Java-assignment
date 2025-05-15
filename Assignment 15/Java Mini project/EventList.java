import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class EventList extends JFrame {

    public EventList() {
        setTitle("Event List - College Event Management");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(0, 102, 204));
        JLabel titleLabel = new JLabel("Event List", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Event Data (Sample data for events)
        Object[][] eventData = {
            {"Tech Conference", "15-06-2025", "Auditorium"},
            {"Sports Meet", "20-06-2025", "Ground"},
            {"Cultural Fest", "25-06-2025", "Main Hall"}
        };

        // Column Names
        String[] columnNames = {"Event Name", "Date", "Location"};

        // Table Model
        DefaultTableModel tableModel = new DefaultTableModel(eventData, columnNames);
        JTable eventTable = new JTable(tableModel);
        eventTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        eventTable.setRowHeight(25);
        eventTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(eventTable);
        add(scrollPane, BorderLayout.CENTER);

        // Back Button
        JButton backButton = new JButton("Back to Dashboard");
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        backButton.setBackground(new Color(255, 69, 58));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Dashboard(); // Go back to Dashboard
                dispose(); // Close EventList window
            }
        });
        add(backButton, BorderLayout.SOUTH);

        // Set background color for the content area
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EventList());
    }
}
