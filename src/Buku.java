public class Buku {
    private String judul;
    private String pengarang;
    private String tahunTerbit;
    private String penerbit;
    private String kotaTerbit;
    private String versiBuku;
    private String noISBN;
    private String coverImage;

    public Buku(String judul, String pengarang, String tahunTerbit, String penerbit,
                String kotaTerbit, String versiBuku, String noISBN, String coverImage) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
        this.penerbit = penerbit;
        this.kotaTerbit = kotaTerbit;
        this.versiBuku = versiBuku;
        this.noISBN = noISBN;
        this.coverImage = coverImage;
    }


    public String getJudul() {
        return judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public String getTahunTerbit() {
        return tahunTerbit;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public String getKotaTerbit() {
        return kotaTerbit;
    }

    public String getVersiBuku() {
        return versiBuku;
    }

    public String getNoISBN() {
        return noISBN;
    }

    public String getCoverImage() {
        return coverImage;
    }

    @Override
    public String toString() {
        return String.format(
                "Judul: %s\nPengarang: %s\nTahun Terbit: %s\nPenerbit: %s\nKota Terbit: %s\nVersi Buku: %s\nISBN: %s",
                judul, pengarang, tahunTerbit, penerbit, kotaTerbit, versiBuku, noISBN);
    }
}
