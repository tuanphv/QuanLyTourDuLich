package dto;

import enums.TrangThaiHoaDon;
import java.time.LocalDateTime;
import utils.TextUtils;

/**
 * Lớp Data Transfer Object cho Hóa Đơn
 */
public class HoaDonDTO {
    private int maHD;
    private int maDat;
    private int maNV;
    private LocalDateTime ngayLap;
    private float tongTien;
    private String hinhThucThanhToan;
    private TrangThaiHoaDon trangThai;

    public HoaDonDTO() {
        trangThai = TrangThaiHoaDon.CHO_XAC_NHAN;
    }

    public HoaDonDTO(int maHoaDon, int maDat, int maNV, LocalDateTime ngayLap, float tongTien, String hinhThucThanhToan, TrangThaiHoaDon trangThai) {
        this.maHD = maHoaDon;
        this.maDat = maDat;
        this.maNV = maNV;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.trangThai = trangThai;
    }

    public int getMaHoaDon() {
        return maHD;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHD = maHoaDon;
    }

    public int getMaDat() {
        return maDat;
    }

    public void setMaDat(int maDat) {
        this.maDat = maDat;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public LocalDateTime getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDateTime ngayLap) {
        this.ngayLap = ngayLap;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public TrangThaiHoaDon getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThaiHoaDon trangThai) {
        this.trangThai = trangThai;
    }

    public Object[] toTableRow() {
        return new Object[]{maHD, maDat, maNV, ngayLap, TextUtils.formatCurrency(tongTien), hinhThucThanhToan, trangThai};
    }
    
    public Object[] toExcelRow() {
        return new Object[]{maHD, maDat, maNV, ngayLap, tongTien, hinhThucThanhToan, trangThai.getMoTa()};
    }

    public static final String[] COLUMN_NAMES = {
        "Mã hóa đơn",
        "Mã đặt tour",
        "Mã nhân viên",
        "Ngày lập",
        "Tổng tiền",
        "Hình thức thanh toán",
        "Trạng thái"
    };

    @Override
    public String toString() {
        return "HoaDonDTO{" + "maHD=" + maHD + ", maDat=" + maDat + ", maNV=" + maNV + ", ngayLap=" + ngayLap + ", tongTien=" + tongTien + ", hinhThucThanhToan=" + hinhThucThanhToan + ", trangThai=" + trangThai + '}';
    }
}