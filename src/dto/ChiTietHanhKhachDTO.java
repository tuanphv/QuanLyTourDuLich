package dto;

import enums.LoaiHanhKhach;
import java.time.LocalDate;

public class ChiTietHanhKhachDTO {

    private int maDat;
    private int soThuTu;
    private String hoTen;
    private LocalDate ngaySinh;
    private LoaiHanhKhach loaiHanhKhach;
    private String soGiayTo;
    private boolean laNguoiDat;

    public ChiTietHanhKhachDTO() {
        laNguoiDat = false;
    }

    public ChiTietHanhKhachDTO(int maDat, int soThuTu, String hoTen, LocalDate ngaySinh, LoaiHanhKhach loaiHanhKhach, String soGiayTo, boolean laNguoiDat) {
        this.maDat = maDat;
        this.soThuTu = soThuTu;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.loaiHanhKhach = loaiHanhKhach;
        this.soGiayTo = soGiayTo;
        this.laNguoiDat = laNguoiDat;
    }

    public int getMaDat() {
        return maDat;
    }

    public void setMaDat(int maDat) {
        this.maDat = maDat;
    }

    public int getSoThuTu() {
        return soThuTu;
    }

    public void setSoThuTu(int soThuTu) {
        this.soThuTu = soThuTu;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public LoaiHanhKhach getLoaiHanhKhach() {
        return loaiHanhKhach;
    }

    public void setLoaiHanhKhach(LoaiHanhKhach loaiHanhKhach) {
        this.loaiHanhKhach = loaiHanhKhach;
    }

    public String getSoGiayTo() {
        return soGiayTo;
    }

    public void setSoGiayTo(String soGiayTo) {
        this.soGiayTo = soGiayTo;
    }

    public boolean isLaNguoiDat() {
        return laNguoiDat;
    }

    public void setLaNguoiDat(boolean laNguoiDat) {
        this.laNguoiDat = laNguoiDat;
    }

    public static String[] COLUMN_NAMES = new String[]{"STT", "Họ tên", "Ngày sinh", "Loai hành khách", "Số giấy tờ", "Là người đặt"};

    public Object[] toTableRow() {
        return new Object[]{
            soThuTu,
            hoTen,
            ngaySinh,
            loaiHanhKhach,
            soGiayTo,
            laNguoiDat
        };
    }

    @Override
    public String toString() {
        return "ChiTietHanhKhachDTO{" + "maDat=" + maDat + ", soThuTu=" + soThuTu + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", loaiHanhKhach=" + loaiHanhKhach + ", soGiayTo=" + soGiayTo + ", laNguoiDat=" + laNguoiDat + '}';
    }
}
