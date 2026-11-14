package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TaiLieu implements Serializable {

    private String ma;
    private String tieuDe;
    private String tacGia;
    private String danhMuc;
    private List<BanSao> ds;

    public TaiLieu(String ma, String tieuDe, String tacGia, String danhMuc) {
        this.ma = ma;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.danhMuc = danhMuc;
        this.ds = new ArrayList<>();
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public List<BanSao> getDs() {
        return ds;
    }

    public void setDs(List<BanSao> ds) {
        this.ds = ds;
    }

    @Override
    public String toString() {
        return ma + " - " + tieuDe + " - " + tacGia + " - " + danhMuc;
    }
}