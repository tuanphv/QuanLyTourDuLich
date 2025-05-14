package dto;

import utils.TextUtils;

public class KhachSanDTO {
    private int maKhachSan;
    private String tenKhachSan;
    private String diaChi;
    private int gia;
    private String soDienThoai;
    private int trangThai;

    public KhachSanDTO() {
    }

    public KhachSanDTO(String tenKhachSan, String diaChi, int gia, String soDienThoai) {
        this.tenKhachSan = tenKhachSan;
        this.diaChi = diaChi;
        this.gia = gia;
        this.soDienThoai = soDienThoai;
    }

    public KhachSanDTO(int maKhachSan, String tenKhachSan, String diaChi, int gia, String soDienThoai, int trangThai) {
        this.maKhachSan = maKhachSan;
        this.tenKhachSan = tenKhachSan;
        this.diaChi = diaChi;
        this.gia = gia;
        this.soDienThoai = soDienThoai;
        this.trangThai = trangThai;
    }

    public int getMaKhachSan() {
        return maKhachSan;
    }

    public void setMaKhachSan(int maKhachSan) {
        this.maKhachSan = maKhachSan;
    }

    public String getTenKhachSan() {
        return tenKhachSan;
    }

    public void setTenKhachSan(String tenKhachSan) {
        this.tenKhachSan = tenKhachSan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
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
        return "KhachSanDTO{" + "maKhachSan=" + maKhachSan + ", tenKhachSan=" + tenKhachSan + ", diaChi=" + diaChi + ", gia=" + gia + ", soDienThoai=" + soDienThoai + ", trangThai=" + trangThai + '}';
    }

    public Object[] toObject() {
        return new Object[] {
            maKhachSan,
            tenKhachSan, 
            diaChi,
            TextUtils.formatCurrency(gia),
            soDienThoai,
            // trangThai
        };
    }

    public static final String[] KHACH_SAN_COLUMN_NAMES = {
        "Mã khách sạn",
        "Tên khách sạn",
        "Địa chỉ",
        "Giá",
        "Số điện thoại",
        // "Trạng thái"
    };
    
}
