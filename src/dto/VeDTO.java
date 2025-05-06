
package dto;

import enums.TrangThaiVe;
import java.time.LocalDate;

public class VeDTO {
    private int maVe;
    private int maDat;
    private int soThuTu;
    private int maKHTour;
    private String hoTen;
    private LocalDate ngayKhoiHanh;
    private LocalDate ngayCap;
    private TrangThaiVe trangThai;

    public VeDTO() {
    }

    public VeDTO(int maVe, int maDat, int soThuTu, int maKHTour, String hoTen, LocalDate ngayKhoiHanh, LocalDate ngayCap, TrangThaiVe trangThai) {
        this.maVe = maVe;
        this.maDat = maDat;
        this.soThuTu = soThuTu;
        this.maKHTour = maKHTour;
        this.hoTen = hoTen;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.ngayCap = ngayCap;
        this.trangThai = trangThai;
    }

    public int getMaVe() {
        return maVe;
    }

    public void setMaVe(int maVe) {
        this.maVe = maVe;
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

    public int getMaKHTour() {
        return maKHTour;
    }

    public void setMaKHTour(int maKHTour) {
        this.maKHTour = maKHTour;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(LocalDate ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public LocalDate getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(LocalDate ngayCap) {
        this.ngayCap = ngayCap;
    }

    public TrangThaiVe getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThaiVe trangThai) {
        this.trangThai = trangThai;
    }
    
    public static String[] COLUMN_NAMES = new String[]{"Mã vé", "Mã đặt tour", "Số thứ tự", "Mã kế hoạch tour", "Họ tên", "Ngày khởi hành", "Ngày cấp", "Trạng thái"};
    
    public Object[] toObjectArray() {
        return new Object[]{maVe, maDat, soThuTu, maKHTour, hoTen, ngayKhoiHanh, ngayCap, trangThai.getMoTa()};
    }
    
}
