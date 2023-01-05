package home.furkanmuratcakir.universityselection;

public class Item {
    private String uni_adı;
    private String bolum;
    private String puan_turu;
    private String kont;
    private String taban_puan;
    private String basarı_sıra;

    public Item(String uni_adı, String bolum, String puan_turu, String kont, String taban_puan, String basarı_sıra) {
        this.uni_adı = uni_adı;
        this.bolum = bolum;
        this.puan_turu = puan_turu;
        this.kont = kont;
        this.taban_puan = taban_puan;
        this.basarı_sıra = basarı_sıra;
    }

    public String getTaban_puan() {
        return taban_puan;
    }

    public String getUni_adı() {
        return uni_adı;
    }

    public String getBolum() {
        return bolum;
    }

    public String getPuan_turu() {
        return puan_turu;
    }

    public String getKont() {
        return kont;
    }

    public String getBasarı_sıra() {
        return basarı_sıra;
    }
}
