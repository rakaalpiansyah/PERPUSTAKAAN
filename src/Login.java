import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class Login {
    private static HashMap<String, String> users = new HashMap<>();
    private static HashMap<String, String> roles = new HashMap<>();

        public Login() {
            JFrame frame = new JFrame("Login");
            frame.setSize(500, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
    
            JPanel backgroundPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    ImageIcon background = new ImageIcon("lib/image.png"); 
                    g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
                }
            };
            backgroundPanel.setLayout(new GridBagLayout());
    
            JPanel loginPanel = new JPanel();
            loginPanel.setBackground(new Color(50, 50, 50, 220)); 
            loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
            loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            loginPanel.setPreferredSize(new Dimension(300, 270));
    
            JLabel titleLabel = new JLabel("Login");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
            titleLabel.setForeground(Color.WHITE);
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            loginPanel.add(titleLabel);
    
            loginPanel.add(Box.createRigidArea(new Dimension(0, 15)));
    
            JPanel userPanel = new JPanel(new BorderLayout());
            userPanel.setBackground(new Color(0, 0, 0, 0));
    
            JLabel userLabel = new JLabel("Username");
            userLabel.setForeground(Color.WHITE);
            userPanel.add(userLabel, BorderLayout.NORTH);
    
            JTextField usernameField = new JTextField();
            usernameField.setBackground(new Color(30, 30, 30));
            usernameField.setForeground(Color.WHITE);
            usernameField.setCaretColor(Color.WHITE);
            usernameField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            userPanel.add(usernameField, BorderLayout.CENTER);
    
            loginPanel.add(userPanel);
    
            loginPanel.add(Box.createRigidArea(new Dimension(0, 15)));
    
            JPanel passPanel = new JPanel(new BorderLayout());
            passPanel.setBackground(new Color(0, 0, 0, 0));
    
            JLabel passLabel = new JLabel("Password");
            passLabel.setForeground(Color.WHITE);
            passPanel.add(passLabel, BorderLayout.NORTH);
    
            JPasswordField passwordField = new JPasswordField();
            passwordField.setBackground(new Color(30, 30, 30));
            passwordField.setForeground(Color.WHITE);
            passwordField.setCaretColor(Color.WHITE);
            passwordField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            passPanel.add(passwordField, BorderLayout.CENTER);
    
            loginPanel.add(passPanel);
    
            loginPanel.add(Box.createRigidArea(new Dimension(0, 15)));
    
            JButton loginButton = new JButton("SIGN IN");
            loginButton.setBackground(new Color(30, 144, 200));
            loginButton.setForeground(Color.WHITE);
            loginButton.setFocusPainted(false);
            loginButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            loginPanel.add(loginButton);
    
            JButton createAccountButton = new JButton("Buat Akun Baru");
            createAccountButton.setBackground(new Color(0, 0, 0, 0));
            createAccountButton.setForeground(Color.WHITE);
            createAccountButton.setFocusPainted(false);
            createAccountButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            createAccountButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            loginPanel.add(createAccountButton);
    
            // Hover effect for loginButton
            loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    loginButton.setBackground(new Color(70, 130, 180));  // Lighter shade
                }
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    loginButton.setBackground(new Color(30, 144, 200));  // Original shade
                }
            });
    
            // Hover effect for createAccountButton
            createAccountButton.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    createAccountButton.setBackground(new Color(80, 80, 80));  // Lighter shade
                }
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    createAccountButton.setBackground(new Color(50, 50, 50, 230));  // Original shade
                }
            });
    
            loginButton.addActionListener(e -> {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();
    
                if (users.containsKey(username) && users.get(username).equals(password)) {
                    JOptionPane.showMessageDialog(frame, "Login berhasil!");
                    String role = roles.get(username); 
                    frame.dispose();
                    new Main(username, role); 
                } else {
                    JOptionPane.showMessageDialog(frame, "Username atau password salah!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
    
            createAccountButton.addActionListener(e -> {
                new Register();  
                frame.dispose(); 
            });
    
            backgroundPanel.add(loginPanel);
            frame.add(backgroundPanel);
            frame.setLocationRelativeTo(null); 
            frame.setVisible(true);
        }
    
        public static void main(String[] args) {
            addUser("admin", "admin123", "admin");
            addUser("user", "user123", "pengguna");
            SwingUtilities.invokeLater(Login::new);
        }
    
        public static void addUser(String username, String password, String role) {
            users.put(username, password);
            roles.put(username, role); 
        }
    }
    
class Register {
    public Register() {
        JFrame frame = new JFrame("Pendaftaran Pengguna Baru");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("lib/image.png"); 
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new GridBagLayout());

        JPanel registerPanel = new JPanel();
        registerPanel.setBackground(new Color(50, 50, 50, 220)); 
        registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.Y_AXIS));
        registerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        registerPanel.setPreferredSize(new Dimension(300, 280));

        JLabel titleLabel = new JLabel("Buat Akun Baru");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerPanel.add(titleLabel);

        registerPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        JPanel userPanel = new JPanel(new BorderLayout());
        userPanel.setBackground(new Color(0, 0, 0, 0));

        JLabel userLabel = new JLabel("Username");
        userLabel.setForeground(Color.WHITE);
        userPanel.add(userLabel, BorderLayout.NORTH);

        JTextField usernameField = new JTextField();
        usernameField.setBackground(new Color(30, 30, 30)); 
        usernameField.setForeground(Color.WHITE);
        usernameField.setCaretColor(Color.WHITE); 
        usernameField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); 
        userPanel.add(usernameField, BorderLayout.CENTER);
        registerPanel.add(userPanel);

        registerPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        JPanel passPanel = new JPanel(new BorderLayout());

        JLabel passLabel = new JLabel("Password");
        passPanel.add(passLabel, BorderLayout.NORTH);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBackground(new Color(30, 30, 30)); 
        passwordField.setForeground(Color.WHITE);
        passwordField.setCaretColor(Color.WHITE); 
        passwordField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); 
        passPanel.add(passwordField, BorderLayout.CENTER);
        registerPanel.add(passPanel);

        registerPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        JPanel confirmPassPanel = new JPanel(new BorderLayout());

        JLabel confirmPassLabel = new JLabel("Konfirmasi Password");
        confirmPassPanel.add(confirmPassLabel, BorderLayout.NORTH);

        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBackground(new Color(30, 30, 30)); 
        confirmPasswordField.setForeground(Color.WHITE);
        confirmPasswordField.setCaretColor(Color.WHITE); 
        confirmPasswordField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); 
        confirmPassPanel.add(confirmPasswordField, BorderLayout.CENTER);
        registerPanel.add(confirmPassPanel);

        registerPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        JButton registerButton = new JButton("Daftar");
        registerButton.setBackground(new Color(30, 30, 30, 180));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerPanel.add(registerButton);

        registerButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();
                String confirmPassword = new String(confirmPasswordField.getPassword()).trim();
        
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Username dan password tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(frame, "Password dan konfirmasi password tidak cocok!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Login.addUser(username, password, "pengguna");
                    JOptionPane.showMessageDialog(frame, "Pendaftaran berhasil!");
                    frame.dispose();
                    new Login(); 
                }
            }
        });
        
        // Tambahkan panel ke background
        backgroundPanel.add(registerPanel);
        frame.add(backgroundPanel);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
}
