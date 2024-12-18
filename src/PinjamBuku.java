import javax.swing.*;
import java.util.*;

public class PinjamBuku {
    private static HashMap<String, Queue<String>> userBooks = new HashMap<>();

    public static void tampilkan(String username) {
        JFrame frame = new JFrame("Pinjam Buku");
        frame.setSize(500, 500);
    
        DefaultListModel<String> listModel = new DefaultListModel<>();
    
        int index = 1; // Initialize a number for listing books
        for (Buku buku : ListBuku.daftarBuku) {
            if (!isBookBorrowed(buku.getJudul())) {
                listModel.addElement(index + ". " + buku.getJudul()); // Add the number to the book title
                index++;
            }
        }
    
        JList<String> list = new JList<>(listModel);
        JButton button = new JButton("Pinjam");
    
        button.addActionListener(e -> {
            String buku = list.getSelectedValue();
            if (buku != null) {
                // Remove the number from the selected book to store only the title
                String bookTitle = buku.substring(buku.indexOf(".") + 2);
                addBookToUser(username, bookTitle);
                JOptionPane.showMessageDialog(frame, "Buku \"" + bookTitle + "\" berhasil dipinjam!");
    
                listModel.removeElement(buku);
            } else {
                JOptionPane.showMessageDialog(frame, "Pilih buku terlebih dahulu!");
            }
        });
    
        frame.add(new JScrollPane(list), "Center");
        frame.add(button, "South");
    
        frame.setVisible(true);
    }
    
    private static boolean isBookBorrowed(String bookTitle) {
        for (Queue<String> borrowedBooks : userBooks.values()) {
            if (borrowedBooks.contains(bookTitle)) {
                return true;
            }
        }
        return false;
    }

    private static void addBookToUser(String username, String bookTitle) {
        userBooks.putIfAbsent(username, new LinkedList<>());
        userBooks.get(username).offer(bookTitle); 
    }

    public static void lihatPinjaman(String username) {
        Queue<String> borrowedBooks = userBooks.get(username);

        if (borrowedBooks != null && !borrowedBooks.isEmpty()) {
            StringBuilder message = new StringBuilder("Buku yang dipinjam:\n");
            for (String book : borrowedBooks) {
                message.append(book).append("\n");
            }
            JOptionPane.showMessageDialog(null, message.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Anda belum meminjam buku.");
        }
    }

    public static void kembalikanBuku(String username) {
        Queue<String> borrowedBooks = userBooks.get(username);
        if (borrowedBooks != null && !borrowedBooks.isEmpty()) {
            String returnedBook = borrowedBooks.poll(); 
            JOptionPane.showMessageDialog(null, "Buku \"" + returnedBook + "\" berhasil dikembalikan!");
        } else {
            JOptionPane.showMessageDialog(null, "Tidak ada buku yang dipinjam untuk dikembalikan.");
        }
    }

    public static HashMap<String, Queue<String>> getUserBooks() {
        return userBooks;
    }
}
