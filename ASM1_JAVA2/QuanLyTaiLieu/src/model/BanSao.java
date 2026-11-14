package model;

import java.io.Serializable;

public class BanSao implements Serializable {

    private String maBanSao;
    private String maTaiLieu;
    private TrangThai trangThai;

    public BanSao(String maBanSao, String maTaiLieu, TrangThai trangThai) {
        this.maBanSao = maBanSao;
        this.maTaiLieu = maTaiLieu;
        this.trangThai = trangThai;
    }

    public String getMaBanSao() {
        return maBanSao;
    }

    public void setMaBanSao(String maBanSao) {
        this.maBanSao = maBanSao;
    }

    public String getMaTaiLieu() {
        return maTaiLieu;
    }

    public void setMaTaiLieu(String maTaiLieu) {
        this.maTaiLieu = maTaiLieu;
    }

    public TrangThai getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThai trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return maBanSao + " - " + maTaiLieu + " - " + trangThai.gettrangThai();
    }
}