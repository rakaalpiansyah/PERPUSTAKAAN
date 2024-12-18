import javax.swing.*;
import java.awt.*;
import java.util.Map.Entry;
import java.util.Queue;

public class Main {
    public static Object daftarBuku;

    public Main(String username, String role) {
        JFrame frame = new JFrame("Perpustakaan - " + username.toUpperCase());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("lib/image.png"); 
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainPanel.setLayout(new GridBagLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));
        buttonPanel.setOpaque(false);

        JButton btnDaftarBuku = new JButton("Daftar Buku");
        JButton btnTambahBuku = new JButton("Tambah Buku");
        JButton btnPinjamBuku = new JButton("Pinjam Buku");
        JButton btnLihatPinjaman = new JButton("Lihat Pinjaman");
        JButton btnViewUsersBooks = new JButton("Lihat Pinjaman Pengguna");
        JButton btnLogout = new JButton("Logout");

        btnDaftarBuku.setFocusPainted(false);
        btnTambahBuku.setFocusPainted(false);
        btnPinjamBuku.setFocusPainted(false);
        btnLihatPinjaman.setFocusPainted(false);
        btnViewUsersBooks.setFocusPainted(false);
        btnLogout.setFocusPainted(false);

        Insets buttonMargin = new Insets(5, 20, 10, 20);
        btnDaftarBuku.setMargin(buttonMargin);
        btnTambahBuku.setMargin(buttonMargin);
        btnPinjamBuku.setMargin(buttonMargin);
        btnLihatPinjaman.setMargin(buttonMargin);
        btnViewUsersBooks.setMargin(buttonMargin);
        btnLogout.setMargin(new Insets(5, 5, 10, 20)); 

        Color buttonBackgroundColor = new Color(30, 30, 30, 180);
        Color buttonTextColor = Color.WHITE;                  

        btnDaftarBuku.setBackground(buttonBackgroundColor);
        btnDaftarBuku.setForeground(buttonTextColor);

        btnTambahBuku.setBackground(buttonBackgroundColor);
        btnTambahBuku.setForeground(buttonTextColor);

        btnPinjamBuku.setBackground(buttonBackgroundColor);
        btnPinjamBuku.setForeground(buttonTextColor);

        btnLihatPinjaman.setBackground(buttonBackgroundColor);
        btnLihatPinjaman.setForeground(buttonTextColor);

        btnViewUsersBooks.setBackground(buttonBackgroundColor);
        btnViewUsersBooks.setForeground(buttonTextColor);

        btnLogout.setBackground(new Color(220, 20, 100, 250));
        btnLogout.setForeground(buttonTextColor);

        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        btnDaftarBuku.setFont(buttonFont);
        btnTambahBuku.setFont(buttonFont);
        btnPinjamBuku.setFont(buttonFont);
        btnLihatPinjaman.setFont(buttonFont);
        btnViewUsersBooks.setFont(buttonFont);
        btnLogout.setFont(buttonFont);

        if (role.equalsIgnoreCase("admin")) {
            buttonPanel.add(btnDaftarBuku);
            buttonPanel.add(btnTambahBuku);
            buttonPanel.add(btnViewUsersBooks);
        } else if (role.equalsIgnoreCase("pengguna")) {
            buttonPanel.add(btnPinjamBuku);
            buttonPanel.add(btnLihatPinjaman);
            buttonPanel.add(btnDaftarBuku);
        }

        buttonPanel.add(btnLogout);

        btnDaftarBuku.addActionListener(e -> ListBuku.tampilkan());
        btnTambahBuku.addActionListener(e -> TambahBuku.tampilkan());
        btnPinjamBuku.addActionListener(e -> PinjamBuku.tampilkan(username));
        btnLihatPinjaman.addActionListener(e -> LihatPinjaman.tampilkan(username));

        btnViewUsersBooks.addActionListener(e -> {
            StringBuilder message = new StringBuilder("Daftar Pengguna dan Buku yang Dipinjam:\n\n");
            for (Entry<String, Queue<String>> entry : PinjamBuku.getUserBooks().entrySet()) {
                String user = entry.getKey();
                Queue<String> books = entry.getValue();
                message.append(user).append(" : ").append(String.join(", ", books)).append("\n");
            }
            JOptionPane.showMessageDialog(frame, message.toString());
        });

        btnLogout.addActionListener(e -> {
            int confirmed = JOptionPane.showConfirmDialog(frame, "Apakah Anda yakin ingin logout?", "Logout",
                    JOptionPane.YES_NO_OPTION);
            if (confirmed == JOptionPane.YES_OPTION) {
                frame.dispose();
                new Login();
            }
        });

        mainPanel.add(buttonPanel);

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
}
