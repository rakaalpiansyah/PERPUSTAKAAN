import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Queue;

public class LihatPinjaman {

    public static void tampilkan(String username) {
        JFrame frame = new JFrame("Buku yang Dipinjam");
        frame.setSize(700, 600);
        frame.setLayout(new BorderLayout());

        // Panel utama dengan background warna hijau pastel
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(235, 248, 235)); // Hijau pastel
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panel judul
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(80, 140, 100)); // Hijau tua
        JLabel headerLabel = new JLabel("Daftar Buku yang Dipinjam");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(headerLabel);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Data untuk tabel buku
        String[] columnNames = {"No", "Nama", "Judul Buku", "Jumlah"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        Queue<String> borrowedBooks = PinjamBuku.getUserBooks().get(username);

        if (borrowedBooks != null && !borrowedBooks.isEmpty()) {
            int no = 1;
            StringBuilder booksList = new StringBuilder();
            for (String buku : borrowedBooks) {
                booksList.append("- ").append(buku).append("\n");
            }

            // Menambahkan data ke tabel
            tableModel.addRow(new Object[]{no, username, booksList.toString(), borrowedBooks.size()});

         
        } 

        JTable table = new JTable(tableModel);
        table.setRowHeight(35);
        table.setBackground(new Color(245, 245, 245)); // Krem terang
        table.setFillsViewportHeight(true);
        table.getTableHeader().setBackground(new Color(100, 160, 120)); // Hijau gelap
        table.getTableHeader().setForeground(Color.black);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));

        // Mengatur perataan teks ke tengah
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Mengatur lebar kolom
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        table.getColumnModel().getColumn(2).setPreferredWidth(300);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBorder(BorderFactory.createEmptyBorder());

        // Menambahkan tabel ke panel utama
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        // Tombol Tutup
        JButton closeButton = new JButton("Tutup");
        closeButton.setBackground(new Color(100, 160, 120)); // Hijau gelap
        closeButton.setForeground(Color.BLACK);
        closeButton.setFont(new Font("Arial", Font.BOLD, 16));
        closeButton.setFocusPainted(false);
        closeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        closeButton.addActionListener(e -> frame.dispose());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(closeButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
