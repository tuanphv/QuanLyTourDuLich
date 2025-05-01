package dto;

import java.time.LocalDateTime;

/**
 * Lớp Data Transfer Object cho Hóa Đơn
 */
public class HoaDonDTO {
    private int maHoaDon;
    private int maKH;
    private int maKHTour;
    private int soVe;
    private int maNV;
    private float tongTien;
    private String ghiChu;
    private String maKhuyenMai;
    private LocalDateTime ngayLapPhieu;
    private int trangThai;

    /**
     * Constructor mặc định
     */
    public HoaDonDTO() {
        trangThai = 1;
    }

    /**
     * Constructor đầy đủ tham số
     * @param maHoaDon Mã hóa đơn
     * @param maKH Mã khách hàng
     * @param maKHTour Mã kế hoạch tour
     * @param soVe Số vé
     * @param maNV Mã nhân viên
     * @param tongTien Tổng tiền
     * @param ghiChu Ghi chú
     * @param maKhuyenMai Mã khuyến mãi
     * @param ngayLapPhieu Ngày lập phiếu
     * @param trangThai Trạng thái
     */
    public HoaDonDTO(int maHoaDon, int maKH, int maKHTour, int soVe, int maNV, float tongTien, String ghiChu, String maKhuyenMai, LocalDateTime ngayLapPhieu, int trangThai) {
        this.maHoaDon = maHoaDon;
        this.maKH = maKH;
        this.maKHTour = maKHTour;
        this.soVe = soVe;
        this.maNV = maNV;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.maKhuyenMai = maKhuyenMai;
        this.ngayLapPhieu = ngayLapPhieu;
        this.trangThai = trangThai;
    }

    /**
     * @return Mã hóa đơn
     */
    public int getMaHoaDon() {
        return maHoaDon;
    }

    /**
     * @param maHoaDon Mã hóa đơn mới
     */
    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    /**
     * @return Mã khách hàng
     */
    public int getMaKH() {
        return maKH;
    }

    /**
     * @param maKH Mã khách hàng mới
     */
    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    /**
     * @return Mã kế hoạch tour
     */
    public int getMaKHTour() {
        return maKHTour;
    }

    /**
     * @param maKHTour Mã kế hoạch tour mới
     */
    public void setMaKHTour(int maKHTour) {
        this.maKHTour = maKHTour;
    }

    /**
     * @return Số vé
     */
    public int getSoVe() {
        return soVe;
    }

    /**
     * @param soVe Số vé mới
     */
    public void setSoVe(int soVe) {
        this.soVe = soVe;
    }

    /**
     * @return Mã nhân viên
     */
    public int getMaNV() {
        return maNV;
    }

    /**
     * @param maNV Mã nhân viên mới
     */
    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    /**
     * @return Tổng tiền
     */
    public float getTongTien() {
        return tongTien;
    }

    /**
     * @param tongTien Tổng tiền mới
     */
    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    /**
     * @return Ghi chú
     */
    public String getGhiChu() {
        return ghiChu;
    }

    /**
     * @param ghiChu Ghi chú mới
     */
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    /**
     * @return Mã khuyến mãi
     */
    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    /**
     * @param maKhuyenMai Mã khuyến mãi mới
     */
    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    /**
     * @return Ngày lập phiếu
     */
    public LocalDateTime getNgayLapPhieu() {
        return ngayLapPhieu;
    }

    /**
     * @param ngayLapPhieu Ngày lập phiếu mới
     */
    public void setNgayLapPhieu(LocalDateTime ngayLapPhieu) {
        this.ngayLapPhieu = ngayLapPhieu;
    }

    /**
     * @return Trạng thái
     */
    public int getTrangThai() {
        return trangThai;
    }

    /**
     * @param trangThai Trạng thái mới
     */
    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    @Override
    public String toString() {
        return "HoaDonDTO{" +
                "maHoaDon=" + maHoaDon +
                ", maKH=" + maKH +
                ", maKHTour=" + maKHTour +
                ", soVe=" + soVe +
                ", maNV=" + maNV +
                ", tongTien=" + tongTien +
                ", ghiChu='" + ghiChu + '\'' +
                ", maKhuyenMai=" + maKhuyenMai +
                ", ngayLapPhieu=" + ngayLapPhieu +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }

    public Object[] toArray() {
        return new Object[]{maHoaDon, maKH, maKHTour, soVe, maNV, tongTien, ghiChu, maKhuyenMai == null ? "Không":maKhuyenMai, ngayLapPhieu, trangThai};
    }

    public static final String[] COLUMN_NAMES = {
        "Mã hóa đơn",
        "Mã khách hàng",
        "Mã kế hoạch tour",
        "Số vé",
        "Mã nhân viên",
        "Tổng tiền",
        "Ghi chú",
        "Mã khuyến mãi",
        "Ngày lập phiếu",
        "Trạng thái"
    };
}