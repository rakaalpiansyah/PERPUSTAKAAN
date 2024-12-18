import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Comparator;

public class TambahBuku {

    public static void tampilkan() {
        JFrame frame = new JFrame("Tambah Buku");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(9, 2));

        // Input Fields
        JTextField tfJudul = new JTextField();
        JTextField tfPengarang = new JTextField();
        JTextField tfTahun = new JTextField();
        JTextField tfPenerbit = new JTextField();
        JTextField tfKota = new JTextField();
        JTextField tfVersi = new JTextField();
        JTextField tfISBN = new JTextField();
        JTextField tfCoverImage = new JTextField();

        // Tombol Pilih Gambar
        JButton btnPilihCover = new JButton("Pilih Gambar");

        // Menambahkan komponen ke panel
        panel.add(new JLabel(" Judul:"));
        panel.add(tfJudul);
        panel.add(new JLabel(" Pengarang:"));
        panel.add(tfPengarang);
        panel.add(new JLabel(" Tahun Terbit:"));
        panel.add(tfTahun);
        panel.add(new JLabel(" Penerbit:"));
        panel.add(tfPenerbit);
        panel.add(new JLabel(" Kota Terbit:"));
        panel.add(tfKota);
        panel.add(new JLabel(" Versi Buku:"));
        panel.add(tfVersi);
        panel.add(new JLabel(" ISBN:"));
        panel.add(tfISBN);
        panel.add(new JLabel(" Cover Buku:"));
        panel.add(tfCoverImage);

        btnPilihCover.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(frame);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                tfCoverImage.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        });
        panel.add(btnPilihCover);

        // Tombol Tambah Buku
        JButton btnTambah = new JButton("Tambah Buku");
        btnTambah.addActionListener(e -> {
            String judul = tfJudul.getText();
            String pengarang = tfPengarang.getText();
            String tahun = tfTahun.getText();
            String penerbit = tfPenerbit.getText();
            String kota = tfKota.getText();
            String versi = tfVersi.getText();
            String isbn = tfISBN.getText();
            String coverImage = tfCoverImage.getText();

            if (!judul.isEmpty() && !pengarang.isEmpty() && !tahun.isEmpty() && !penerbit.isEmpty()
                    && !kota.isEmpty() && !versi.isEmpty() && !isbn.isEmpty() && !coverImage.isEmpty()) {

                // Menambahkan buku ke koleksi utama
                ListBuku.daftarBuku.add(new Buku(judul, pengarang, tahun, penerbit, kota, versi, isbn, coverImage));

                // Mengurutkan daftar buku berdasarkan judul
                Collections.sort(ListBuku.daftarBuku, Comparator.comparing(Buku::getJudul));

                // Menampilkan pesan sukses
                JOptionPane.showMessageDialog(frame, "Buku berhasil ditambahkan!");
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Semua kolom harus diisi!");
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.add(btnTambah, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
