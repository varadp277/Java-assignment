import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel messageLabel;

    public Login() {
        setTitle("Login - College Event Management System");
        setSize(450, 300);
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

        // Login Button with Styling
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginButton.setBackground(new Color(0, 102, 204));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        formPanel.add(loginButton, gbc);

        // Error Message Label
        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        messageLabel.setForeground(new Color(204, 0, 0)); // Red color for errors
        add(messageLabel, BorderLayout.SOUTH);

        add(formPanel, BorderLayout.CENTER);

        // Action Listener for Login Button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword());

                if (username.equals("admin") && password.equals("admin123")) {
                    JOptionPane.showMessageDialog(Login.this, "✅ Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new Dashboard(); // Replace with your Dashboard class
                } else {
                    messageLabel.setText("❌ Invalid username or password.");
                }
            }
        });

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login());
    }
}
