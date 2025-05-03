
package dto;
import enums.TrangThaiDatTour;
import java.time.LocalDate;

public class DatTourDTO {
    private int maDat;
    private int maKHTour;
    private int maKH;
    private LocalDate ngayDat;
    private int soLuong;
    private float tongTien;
    private TrangThaiDatTour trangThai; // ChoThanhToan, DaThanhToan, DaHuy

    public DatTourDTO() {
        ngayDat = LocalDate.now();
        trangThai = TrangThaiDatTour.CHO_THANH_TOAN;
    }

    public DatTourDTO(int maDat, int maKHTour, int maKH, LocalDate ngayDat, int soLuong, float tongTien, TrangThaiDatTour trangThai) {
        this.maDat = maDat;
        this.maKHTour = maKHTour;
        this.maKH = maKH;
        this.ngayDat = ngayDat;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public int getMaDat() {
        return maDat;
    }

    public void setMaDat(int maDat) {
        this.maDat = maDat;
    }

    public int getMaKHTour() {
        return maKHTour;
    }

    public void setMaKHTour(int maKHTour) {
        this.maKHTour = maKHTour;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public LocalDate getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(LocalDate ngayDat) {
        this.ngayDat = ngayDat;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public TrangThaiDatTour getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThaiDatTour trangThai) {
        this.trangThai = trangThai;
    }
    
    public static String[] COLUMN_NAMES = {"Mã đặt tour", "Mã kế hoạch tour", "Mã khách hàng", "Ngày đặt", "Số lượng", "Tổng tiền", "Trạng thái"};
    
    public Object[] toArray() {
        return new Object[] {maDat, maKHTour, maKH, ngayDat, soLuong, tongTien, trangThai};
    }

}

