package menu;

import java.util.Scanner;
import manager.ChucNang;
import manager.KiemTraTrungMa;
import model.BanSao;
import model.TaiLieu;
import model.TrangThai;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final ChucNang chucNang = new ChucNang();
    private static final String TEN_FILE = "thuvien.dat";

    public static void main(String[] args) {
        chucNang.docFile(TEN_FILE);

        while (true) {
            hienThiMenu();
            int chon = nhapLuaChon();

            switch (chon) {
                case 1:
                    themTaiLieu();
                    break;
                case 2:
                    suaTaiLieu();
                    break;
                case 3:
                    xoaTaiLieu();
                    break;
                case 4:
                    chucNang.xemTatCaTaiLieu();
                    break;
                case 5:
                    themBanSao();
                    break;
                case 6:
                    suaTrangThaiBanSao();
                    break;
                case 7:
                    xoaBanSao();
                    break;
                case 8:
                    xemBanSaoTheoTaiLieu();
                    break;
                case 9:
                    chucNang.luuFile(TEN_FILE);
                    break;
                case 10:
                    xemDuLieuTrongBoNho(); 
                    break;
                case 0:
                    chucNang.luuFile(TEN_FILE);
                    System.out.println("Da thoat chuong trinh.");
                    sc.close();
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
            System.out.println("Nhan Enter de tiep tuc. ");
            sc.nextLine();
        }
    }

    private static void hienThiMenu() {
        System.out.println("\n========= QUAN LY THU VIEN =========");
        System.out.println("1. Them tai lieu moi");
        System.out.println("2. Sua thong tin tai lieu");
        System.out.println("3. Xoa tai lieu");
        System.out.println("4. Xem danh sach tai lieu va ban sao");
        System.out.println("5. Them ban sao cho tai lieu");
        System.out.println("6. Sua trang thai ban sao");
        System.out.println("7. Xoa ban sao");
        System.out.println("8. Xem ban sao theo ma tai lieu");
        System.out.println("9. Luu du lieu ra file");
        System.out.println("10. Xem lai cac du lieu vua nhap (trong bo nho)");
        System.out.println("0. Luu va thoat");
        System.out.print("Chon chuc nang: ");
    }

    private static int nhapLuaChon() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void themTaiLieu() {
        try {
            System.out.print("Nhap ma tai lieu: ");
            String ma = sc.nextLine();
            System.out.print("Nhap tieu de: ");
            String tieuDe = sc.nextLine();
            System.out.print("Nhap tac gia: ");
            String tacGia = sc.nextLine();
            System.out.print("Nhap danh muc: ");
            String danhMuc = sc.nextLine();

            chucNang.themTaiLieu(new TaiLieu(ma, tieuDe, tacGia, danhMuc));
            System.out.println("Them tai lieu thanh cong!");
        } catch (KiemTraTrungMa e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    private static void suaTaiLieu() {
        System.out.print("Nhap ma tai lieu can sua: ");
        String ma = sc.nextLine();
        System.out.print("Nhap tieu de moi: ");
        String tieuDeMoi = sc.nextLine();
        System.out.print("Nhap tac gia moi: ");
        String tacGiaMoi = sc.nextLine();
        System.out.print("Nhap danh muc moi: ");
        String danhMucMoi = sc.nextLine();

        if (chucNang.suaTaiLieu(ma, tieuDeMoi, tacGiaMoi, danhMucMoi)) {
            System.out.println("Cap nhat tai lieu thanh cong!");
        } else {
            System.out.println("Khong tim thay ma tai lieu!");
        }
    }

    private static void xoaTaiLieu() {
        System.out.print("Nhap ma tai lieu can xoa: ");
        String ma = sc.nextLine();
        if (chucNang.xoaTaiLieu(ma)) {
            System.out.println("Da xoa tai lieu!");
        } else {
            System.out.println("Khong tim thay ma tai lieu!");
        }
    }

    private static void themBanSao() {
        try {
            System.out.print("Nhap ma tai lieu goc: ");
            String maTL = sc.nextLine();
            System.out.print("Nhap ma ban sao moi: ");
            String maBS = sc.nextLine();
            TrangThai tt = chonTrangThai();

            if (chucNang.themBanSao(maTL, new BanSao(maBS, maTL, tt))) {
                System.out.println("Them ban sao thanh cong!");
            } else {
                System.out.println("Khong tim thay tai lieu goc!");
            }
        } catch (KiemTraTrungMa e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    private static void suaTrangThaiBanSao() {
        System.out.print("Nhap ma tai lieu: ");
        String maTL = sc.nextLine();
        System.out.print("Nhap ma ban sao can sua: ");
        String maBS = sc.nextLine();
        TrangThai ttMoi = chonTrangThai();

        if (chucNang.suaTrangThaiBanSao(maTL, maBS, ttMoi)) {
            System.out.println("Cap nhat trang thai thanh cong!");
        } else {
            System.out.println("Khong tim thay tai lieu hoac ban sao!");
        }
    }

    private static void xoaBanSao() {
        System.out.print("Nhap ma tai lieu: ");
        String maTL = sc.nextLine();
        System.out.print("Nhap ma ban sao can xoa: ");
        String maBS = sc.nextLine();

        if (chucNang.xoaBanSao(maTL, maBS)) {
            System.out.println("Da xoa ban sao!");
        } else {
            System.out.println("Khong tim thay tai lieu hoac ban sao!");
        }
    }

    private static void xemBanSaoTheoTaiLieu() {
        System.out.print("Nhap ma tai lieu can xem ban sao: ");
        String maTL = sc.nextLine();
        chucNang.xemBanSaoTheoTaiLieu(maTL);
    }

    private static void xemDuLieuTrongBoNho() {
        System.out.println("\n--- CAC DU LIEU BAN VUA NHAP (DANG LUU TRONG RAM) ---");
        chucNang.xemTatCaTaiLieu();
    }

    private static TrangThai chonTrangThai() {
        while (true) {
            System.out.print("Chon trang thai (1. Con tot | 2. Hu hong | 3. Mat): ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    return TrangThai.CON_TOT;
                case "2":
                    return TrangThai.HU_HONG;
                case "3":
                    return TrangThai.MAT;
                default:
                    System.out.println("Chi duoc nhap 1, 2 hoac 3!");
            }
        }
    }
}