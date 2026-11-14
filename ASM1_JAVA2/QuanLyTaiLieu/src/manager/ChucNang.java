package manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import model.BanSao;
import model.TaiLieu;
import model.TrangThai;

public class ChucNang {

    private Map<String, TaiLieu> mapTaiLieu;

    public ChucNang() {
        this.mapTaiLieu = new HashMap<>();
    }

    public void themTaiLieu(TaiLieu tl) throws KiemTraTrungMa {
        if (mapTaiLieu.containsKey(tl.getMa())) {
            throw new KiemTraTrungMa("Ma tai lieu '" + tl.getMa() + "' da ton tai!");
        }
        mapTaiLieu.put(tl.getMa(), tl);
    }

    public boolean suaTaiLieu(String ma, String tieuDeMoi, String tacGiaMoi, String danhMucMoi) {
        TaiLieu tl = mapTaiLieu.get(ma);
        if (tl == null) {
            return false;
        }
        tl.setTieuDe(tieuDeMoi);
        tl.setTacGia(tacGiaMoi);
        tl.setDanhMuc(danhMucMoi);
        return true;
    }

    public boolean xoaTaiLieu(String ma) {
        return mapTaiLieu.remove(ma) != null;
    }

    public TaiLieu timTaiLieu(String ma) {
        return mapTaiLieu.get(ma);
    }

    public void xemTatCaTaiLieu() {
        if (mapTaiLieu.isEmpty()) {
            System.out.println("Danh sach tai lieu dang trong.");
            return;
        }
        for (TaiLieu tl : mapTaiLieu.values()) {
            System.out.println(tl);
            if (tl.getDs().isEmpty()) {
                System.out.println("   (Chua co ban sao nao)");
            } else {
                for (BanSao bs : tl.getDs()) {
                    System.out.println("   -> " + bs);
                }
            }
        }
    }

    public boolean themBanSao(String maTaiLieu, BanSao bsMoi) throws KiemTraTrungMa {
        TaiLieu tl = mapTaiLieu.get(maTaiLieu);
        if (tl == null) {
            return false;
        }

        for (TaiLieu item : mapTaiLieu.values()) {
            for (BanSao bs : item.getDs()) {
                if (bs.getMaBanSao().equalsIgnoreCase(bsMoi.getMaBanSao())) {
                    throw new KiemTraTrungMa("Ma ban sao '" + bsMoi.getMaBanSao() + "' da ton tai!");
                }
            }
        }

        bsMoi.setMaTaiLieu(maTaiLieu);
        tl.getDs().add(bsMoi);
        return true;
    }

    public boolean suaTrangThaiBanSao(String maTaiLieu, String maBanSao, TrangThai trangThaiMoi) {
        TaiLieu tl = mapTaiLieu.get(maTaiLieu);
        if (tl == null) {
            return false;
        }
        for (BanSao bs : tl.getDs()) {
            if (bs.getMaBanSao().equalsIgnoreCase(maBanSao)) {
                bs.setTrangThai(trangThaiMoi);
                return true;
            }
        }
        return false;
    }

    public boolean xoaBanSao(String maTaiLieu, String maBanSao) {
        TaiLieu tl = mapTaiLieu.get(maTaiLieu);
        if (tl == null) {
            return false;
        }
        return tl.getDs().removeIf(bs -> bs.getMaBanSao().equalsIgnoreCase(maBanSao));
    }

    public void xemBanSaoTheoTaiLieu(String maTaiLieu) {
        TaiLieu tl = mapTaiLieu.get(maTaiLieu);
        if (tl == null) {
            System.out.println("Khong tim thay tai lieu co ma: " + maTaiLieu);
            return;
        }
        System.out.println("Tai lieu: " + tl.getTieuDe());
        if (tl.getDs().isEmpty()) {
            System.out.println("-> Tai lieu nay chua co ban sao nao.");
        } else {
            for (BanSao bs : tl.getDs()) {
                System.out.println("-> " + bs);
            }
        }
    }

    public void luuFile(String tenFile) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tenFile))) {
            oos.writeObject(mapTaiLieu);
            System.out.println("Luu du lieu ra file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi khi luu file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void docFile(String tenFile) {
        File file = new File(tenFile);
        if (!file.exists()) {
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(tenFile))) {
            mapTaiLieu = (Map<String, TaiLieu>) ois.readObject();
            System.out.println("Doc du lieu tu file thanh cong!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }
}