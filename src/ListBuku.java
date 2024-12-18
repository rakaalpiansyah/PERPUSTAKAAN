import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ListBuku {
    public static ArrayList<Buku> daftarBuku = new ArrayList<>();
    private static final Map<String, ImageIcon> imageCache = new ConcurrentHashMap<>();

    static {
        daftarBuku.add(new Buku("Dasar Logika Pemrograman Komputer", "Abdul Kadir", "2017", "Elex Media Komputindo", "Jakarta", 
                "Cetakan Keempat", "978-602-04-5166-4", "lib/cover_buku/5592.png"));
        daftarBuku.add(new Buku("7 In 1 Pemrograman WEB Untuk Pemula ( Updated Version )", "Rohi Abdullah", "2023", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "978-623-004781-7", "lib/cover_buku/createthumb.png"));
        daftarBuku.add(new Buku("Langkah Mudah Pemrograman Database Menggunakan Python dan MySQL", "Abdul Kadir", "2023", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "978-623-00-4908-8", "lib/cover_buku/createthumb (1).png"));
        daftarBuku.add(new Buku("Pemrograman Graphical User Interface Menggunakan Python & PySimpluGUI", "Abdul Kadir", "2023", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "978-623-00-5020-6", "lib/cover_buku/createthumb (2).png"));
        daftarBuku.add(new Buku("Python: Bahasa Pemrograman Era Digital", "I Gusti Ngurah Suryantara", "2024", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "978-623-00-5605-5", "lib/cover_buku/createthumb (3).png"));
        daftarBuku.add(new Buku("Pemrograman Android Dengan Flutter", "Budi Raharjo", "2021", "Informatika", "Bandung", 
                "Edisi Pertama", "978-623-7131-56-4", "lib/cover_buku/createthumb (4).png"));
        daftarBuku.add(new Buku("Matlab: Pemrograman Dalam Pemecahan Masalah Di Bidang Perekayasaan", "Suyatno Budiharjo", "2023", "Informatika", "Bandung", 
                "Edisi Pertama", "978-623-7131-77-9", "lib/cover_buku/createthumb (5).png"));
        daftarBuku.add(new Buku("Pemrograman Microsoft Visual C++", "Maria Agustina S", "2009", "Andi", "Yogyakarta", 
                "Edisi Pertama", "978-979-29-1240-1", "lib/cover_buku/createthumb (6).png"));
        daftarBuku.add(new Buku("Pemrograman Phyton ( Teori dan Implementasi)", "R.H. Sianipar", "2015", "Informatika", "Bandung", 
                "Edisi Pertama", "978-602-1514-74-0", "lib/cover_buku/createthumb (7).png"));
        daftarBuku.add(new Buku("Arduino : Belajar Cepat dan Pemrograman", "Heri Ardianto", "2021", "Informatika", "Bandung", 
                "Edisi Kedua", "978-623-7131-49-6", "lib/cover_buku/createthumb (8).png"));
        daftarBuku.add(new Buku("Algoritma Dan Pemrograman", "Suarga", "2012", "Andi", "Yogyakarta", 
                "Edisi Pertama", "978-979-29-2745-0", "lib/cover_buku/createthumb (9).png"));
        daftarBuku.add(new Buku("Dasar Pemrograman Python 3", "Abdul Kadir", "2018", "Andi", "Yogyakarta", 
                "Edisi Pertama", "978-979-29-5810-2", "lib/cover_buku/createthumb (10).png"));
        daftarBuku.add(new Buku("Logika Pemrograman Python", "Yuniar Supardi", "2021", "Elex Media Komputindo", "Jakarta", 
                "Edisi Ketiga", "978-623-00-0227-4", "lib/cover_buku/createthumb (11).png"));
        daftarBuku.add(new Buku("Koleksi Aplikasi Web Laravel", "Yuniar Supardi", "2021", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "978-623-00-4844-9", "lib/cover_buku/createthumb (12).png"));
        daftarBuku.add(new Buku("Dasar Basis Data Graf & Neo4j", "Abdul Kadir", "2020", "Andi", "Yogyakarta", 
                "Edisi Pertama", "978-623-01-0430-5", "lib/cover_buku/createthumb (13).png"));
        daftarBuku.add(new Buku("Network : Tweaking dan Hacking", "Efvy Zam", "2019", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "978-602-04-9708-2", "lib/cover_buku/createthumb (14).png"));
        daftarBuku.add(new Buku("Network : Tweaking dan Hacking", "Efvy Zam", "2019", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "978-602-04-9708-2", "lib/cover_buku/createthumb (14).png"));
        daftarBuku.add(new Buku("PHP untuk Programmer Pemula", "Jubilee Enterprise", "2019", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "978-623-00-0210-6", "lib/cover_buku/Screenshot 2024-12-15 094221.png"));
        daftarBuku.add(new Buku("Mudah Belajar Ruby", "Budi Raharjo", "2017", "Infornatika", "Bandung", 
                "Edisi Pertama", "978-602-62-3233-5", "lib/cover_buku/Screenshot 2024-12-15 094933.png"));
        daftarBuku.add(new Buku("Html 5 & Php", "Jubilee Enterprise", "2016", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "978-602-02-8931-1", "lib/cover_buku/Screenshot 2024-12-15 095256.png"));
        daftarBuku.add(new Buku("Pengenalan HTML dan CSS", "Jubilee Enterprise", "2016", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "978-602-02-9693-7", "lib/cover_buku/Screenshot 2024-12-15 095432.png"));
        daftarBuku.add(new Buku("Graph Database Applications and Concepts", "Fauzan Risqullah, S.Kom.", "2024", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "978-623-00-5890-5", "lib/cover_buku/Screenshot 2024-12-15 100059.png"));
        daftarBuku.add(new Buku("Kolaborasi Macro Excel dan MySQL", "Yudhy Wicaksono", "2021", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "SCOOPG221758", "lib/cover_buku/Screenshot 2024-12-15 100435.png"));
        daftarBuku.add(new Buku("Database Relasional (Edisi Revisi)", "Abdul Kadir", "2021", "Andi Offset", "Bandung", 
                "Edisi Pertama", "978-623-01-0764-1", "lib/cover_buku/Screenshot 2024-12-15 101431.png"));
        daftarBuku.add(new Buku("Aplikasi Database Dengan Sqlite Dan Php 7", "Betha Sidik", "2021", "Informatia", "Bandung", 
                "Edisi Pertama", "978-623-71-3133-5", "lib/cover_buku/Screenshot 2024-12-15 101716.png"));
        daftarBuku.add(new Buku("Belajar Database Menggunakan Mysql Edisi Revisi", "Abdul Kadir", "2020", "Andi Offset", "Bandung", 
                "Edisi Pertama", "978-623-01-0002-4", "lib/cover_buku/Screenshot 2024-12-15 101901.png"));
        daftarBuku.add(new Buku("Pemrograman Database MySQL dengan Php 7", "Betha Sidik", "2020", "Informatika", "Bandung", 
                "Edisi Pertama", "978-623-71-3122-9", "lib/cover_buku/Screenshot 2024-12-15 102033.png"));
        daftarBuku.add(new Buku("Pemrograman Database Komplet", "Jubilee Enterprise", "2020", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "978-623-00-1270-9", "lib/cover_buku/Screenshot 2024-12-15 102448.png"));
        daftarBuku.add(new Buku("Kolaborasi Laravel dan Database PostgreSQL di Linux", "Anton Subagja", "2019", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "978-623-00-0870-2", "lib/cover_buku/Screenshot 2024-12-15 102621.png"));
        daftarBuku.add(new Buku("Tip & Trik Program Database Java", "Yuniar Supardi", "2019", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "978-623-00-0552-7", "lib/cover_buku/Screenshot 2024-12-15 102742.png"));
        daftarBuku.add(new Buku("Database Systems All in One", "Indrajani, S.Kom., Mm.", "2018", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "SCOOPG161631", "lib/cover_buku/Screenshot 2024-12-15 102919.png"));
        daftarBuku.add(new Buku("Database Design All in One", "Indrajani, S.Kom., Mm.", "2018", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "SCOOPG160799", "lib/cover_buku/Screenshot 2024-12-15 103026.png"));
        daftarBuku.add(new Buku("Koleksi Program Database VB2012", "Ir. Yuniar Supardi", "2018", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "978-602-04-7797-8", "lib/cover_buku/Screenshot 2024-12-15 103139.png"));
        daftarBuku.add(new Buku("Pemrograman Android & Database", "Abdul Kadir", "2018", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "978-602-04-5972-1", "lib/cover_buku/Screenshot 2024-12-15 103322.png"));
        daftarBuku.add(new Buku("Kolaborasi Macro Excel dan Access untuk Mengelola Database", "Yudhy Wicaksono", "2018", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "978-602-04-5253-1", "lib/cover_buku/Screenshot 2024-12-15 103500.png"));
        daftarBuku.add(new Buku("Mengolah Database dengan MS Excel 2016", "Jubilee Enterprise", "2017", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "SCOOPG145399", "lib/cover_buku/Screenshot 2024-12-15 103619.png"));
        daftarBuku.add(new Buku("Mengelola Database Menggunakan Macro Excel", "Yudhy Wicaksono", "2017", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "SCOOPG145326", "lib/cover_buku/Screenshot 2024-12-15 103747.png"));
        daftarBuku.add(new Buku("Java NetBeans IDE 8.0.2 dan Database MySQL", "Bay Haqi, M. Kom.", "2017", "Elex Media Komputindo", "Jakarta", 
                "Edisi Pertama", "978-602-04-4988-3", "lib/cover_buku/Screenshot 2024-12-15 103941.png"));
        daftarBuku.add(new Buku("Fundamental SQL Database Oracle 12C", "Halim Budi Santoso", "2017", "Andi Offset", "Bandung", 
                "Edisi Pertama", "978-979-29-5308-4", "lib/cover_buku/Screenshot 2024-12-15 104115.png"));
        daftarBuku.add(new Buku("Membuat Database dengan Microsoft Access (Edisi Revisi)", "Imam Heryanto", "2017", "Informatika", "Bandung", 
                "Edisi Pertama", "978-602-62-3238-0", "lib/cover_buku/Screenshot 2024-12-15 104240.png"));
        daftarBuku.add(new Buku("Visual Basic .Net (Edisi Revisi)", "Priyanto Hidayatullah", "2015", "Informatika", "Bandung", 
                "Edisi Kedua", "978-602-15-1480-1", "lib/cover_buku/Screenshot 2024-12-15 104442.png"));
    }

    public static void tampilkan() {
        JFrame frame = new JFrame("Daftar Buku");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        DefaultListModel<Buku> listModel = new DefaultListModel<>();
        daftarBuku.forEach(listModel::addElement);

        JList<Buku> list = new JList<>(listModel);
        list.setCellRenderer(new BukuRenderer());

        JTextArea detailArea = new JTextArea(10, 30);
        detailArea.setFont(new Font("Courier", Font.PLAIN, 15));
        detailArea.setEditable(false);



        JTextField searchField = new JTextField(20);
        searchField.setToolTipText("Cari buku berdasarkan judul, pengarang, atau tahun");

        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        searchField.addCaretListener(e -> {
            scheduler.schedule(() -> {
                String searchText = searchField.getText().toLowerCase();
                List<Buku> filteredBooks = daftarBuku.stream()
                        .filter(buku -> buku.getJudul().toLowerCase().contains(searchText) ||
                                buku.getPengarang().toLowerCase().contains(searchText) ||
                                buku.getTahunTerbit().toLowerCase().contains(searchText))
                        .collect(Collectors.toList());

                SwingUtilities.invokeLater(() -> {
                    listModel.clear();
                    filteredBooks.forEach(listModel::addElement);
                });
            }, 200, TimeUnit.MILLISECONDS);
        });

        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && list.getSelectedValue() != null) {
                Buku selectedBuku = list.getSelectedValue();
                detailArea.setText(selectedBuku.toString());
            }
        });

        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Cari Buku:"));
        searchPanel.add(searchField);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(list),
                new JScrollPane(detailArea));

        frame.add(searchPanel, BorderLayout.NORTH);
        frame.add(splitPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    static class BukuRenderer extends JPanel implements ListCellRenderer<Buku> {
        private JLabel coverLabel;
        private JLabel textLabel;

        public BukuRenderer() {
            setLayout(new BorderLayout(5, 5));
            coverLabel = new JLabel();
            coverLabel.setPreferredSize(new Dimension(80, 100));
            textLabel = new JLabel();
            textLabel.setVerticalAlignment(SwingConstants.CENTER);

            add(coverLabel, BorderLayout.WEST);
            add(textLabel, BorderLayout.CENTER);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Buku> list, Buku value, int index,
                                                       boolean isSelected, boolean cellHasFocus) {
            if (value != null) {
                String coverPath = value.getCoverImage();
                ImageIcon coverImage = imageCache.computeIfAbsent(coverPath, path -> {
                    ImageIcon imgIcon = new ImageIcon(path);
                    Image scaledImage = imgIcon.getImage().getScaledInstance(70, 90, Image.SCALE_SMOOTH);
                    return new ImageIcon(scaledImage);
                });
                coverLabel.setIcon(coverImage);

                textLabel.setText((index + 1) + ". " + value.getJudul());
            }

            setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
            setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());

            return this;
        }
    }
  
    
}
