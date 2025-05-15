import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterEvent extends JFrame {

    public RegisterEvent() {
        setTitle("Register for Event - College Event Management");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(0, 102, 204));
        JLabel titleLabel = new JLabel("Event Registration", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Center Panel for Form
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Event Label and Field
        JLabel eventLabel = new JLabel("Select Event:");
        eventLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(eventLabel, gbc);

        JTextField eventField = new JTextField(20);
        eventField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        eventField.setForeground(Color.DARK_GRAY);
        eventField.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 1, true));
        gbc.gridx = 1;
        gbc.gridy = 0;
        formPanel.add(eventField, gbc);

        // Register Button with Styling
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        registerButton.setBackground(new Color(0, 153, 0));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        formPanel.add(registerButton, gbc);

        // Back Button with Styling
        JButton backButton = new JButton("Back to Dashboard");
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        backButton.setBackground(new Color(255, 69, 58));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        gbc.gridx = 1;
        gbc.gridy = 2;
        formPanel.add(backButton, gbc);

        // Action Listeners for buttons
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(RegisterEvent.this, "✅ Registered for event successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Dashboard(); // Go back to Dashboard
                dispose(); // Close RegisterEvent window
            }
        });

        add(formPanel, BorderLayout.CENTER);

        // Set the background color for the main content area
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegisterEvent());
    }
}
