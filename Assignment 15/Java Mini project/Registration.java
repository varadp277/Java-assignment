import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Registration extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JLabel messageLabel;

    public Registration() {
        setTitle("Register - College Event Management System");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(0, 102, 204));
        JLabel titleLabel = new JLabel("College Event Management", SwingConstants.CENTER);
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

        // Username Label and Field
        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(userLabel, gbc);

        usernameField = new JTextField(20);
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        usernameField.setForeground(Color.DARK_GRAY);
        usernameField.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 1, true));
        gbc.gridx = 1;
        gbc.gridy = 0;
        formPanel.add(usernameField, gbc);

        // Password Label and Field
        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(passLabel, gbc);

        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordField.setForeground(Color.DARK_GRAY);
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 1, true));
        gbc.gridx = 1;
        gbc.gridy = 1;
        formPanel.add(passwordField, gbc);

        // Confirm Password Label and Field
        JLabel confirmPassLabel = new JLabel("Confirm Password:");
        confirmPassLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(confirmPassLabel, gbc);

        confirmPasswordField = new JPasswordField(20);
        confirmPasswordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        confirmPasswordField.setForeground(Color.DARK_GRAY);
        confirmPasswordField.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 1, true));
        gbc.gridx = 1;
        gbc.gridy = 2;
        formPanel.add(confirmPasswordField, gbc);

        // Register Button with Styling
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        registerButton.setBackground(new Color(0, 102, 204));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        formPanel.add(registerButton, gbc);

        // Message Label for errors or success
        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        messageLabel.setForeground(new Color(204, 0, 0)); // Red color for errors
        add(messageLabel, BorderLayout.SOUTH);

        add(formPanel, BorderLayout.CENTER);

        // Action Listener for Register Button
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    messageLabel.setText("❌ All fields are required.");
                } else if (!password.equals(confirmPassword)) {
                    messageLabel.setText("❌ Passwords do not match.");
                } else {
                    messageLabel.setText("✅ Registration Successful!");
                    messageLabel.setForeground(new Color(0, 153, 0)); // Green color for success
                    // Save registration data (e.g., add to database)
                    // For simplicity, here just showing a success message
                }
            }
        });

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Registration());
    }
}
