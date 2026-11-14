package model;
public enum TrangThai {
    CON_TOT("Còn tốt"),
    HU_HONG("Hư hỏng"),
    MAT("Mất");

    private final String trangThai;

    TrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String gettrangThai() {
        return trangThai;
    }
}