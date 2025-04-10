package business.model;

public class PhuongTienDTO {
    private int maPhuongTien;
    private String tenPhuongTien;
    private String loaiPhuongTien;
    private int soChoNgoi;
    private String sdt;
    private int gia;
    private int trangThai;

    public PhuongTienDTO() {
    }

    public PhuongTienDTO(String tenPhuongTien, String loaiPhuongTien, int soChoNgoi, String sdt, int gia) {
        this.tenPhuongTien = tenPhuongTien;
        this.loaiPhuongTien = loaiPhuongTien;
        this.soChoNgoi = soChoNgoi;
        this.sdt = sdt;
        this.gia = gia;
    }

    public PhuongTienDTO(int maPhuongTien, String tenPhuongTien, String loaiPhuongTien, int soChoNgoi, String sdt, int gia, int trangThai) {
        this.maPhuongTien = maPhuongTien;
        this.tenPhuongTien = tenPhuongTien;
        this.loaiPhuongTien = loaiPhuongTien;
        this.soChoNgoi = soChoNgoi;
        this.sdt = sdt;
        this.gia = gia;
        this.trangThai = trangThai;
    }

    public int getMaPhuongTien() {
        return maPhuongTien;
    }

    public void setMaPhuongTien(int maPhuongTien) {
        this.maPhuongTien = maPhuongTien;
    }

    public String getTenPhuongTien() {
        return tenPhuongTien;
    }

    public void setTenPhuongTien(String tenPhuongTien) {
        this.tenPhuongTien = tenPhuongTien;
    }

    public String getLoaiPhuongTien() {
        return loaiPhuongTien;
    }

    public void setLoaiPhuongTien(String loaiPhuongTien) {
        this.loaiPhuongTien = loaiPhuongTien;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
   
    @Override
    public String toString() {
        return "PhuongTienDTO{" + "maPhuongTien=" + maPhuongTien + ", tenPhuongTien=" + tenPhuongTien + ", loaiPhuongTien=" + loaiPhuongTien + ", soChoNgoi=" + soChoNgoi + ", sdt=" + sdt + ", gia=" + gia + ", trangThai=" + trangThai + '}';
    }

    public static final String[] PHUONG_TIEN_COLUMN_NAMES = {"Mã phương tiện",
        "Tên phương tiện",
        "Loại phương tiện",
        "Số chỗ ngồi",
        "Giá",
        "Số điện thoại",
        "Trạng thái"
    };

}
