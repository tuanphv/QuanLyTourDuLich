package dto;

import enums.TrangThaiTour;

public class TourDTO {

    private int maTour;
    private String tenTour;
    private float gia;
    private TrangThaiTour tinhTrang;
    private String moTa;
    private String diemKhoiHanh;
    private String diemDen;
    private String loaiTour;
    private int soNgay;
    private int soDem;

    public TourDTO(int maTour, String tenTour, float gia, TrangThaiTour tinhTrang, String moTa, String diemKhoiHanh, String diemDen, String loaiTour, int soNgay, int soDem) {
        this.maTour = maTour;
        this.tenTour = tenTour;
        this.gia = gia;
        this.tinhTrang = tinhTrang;
        this.moTa = moTa;
        this.diemKhoiHanh = diemKhoiHanh;
        this.diemDen = diemDen;
        this.loaiTour = loaiTour;
        this.soNgay = soNgay;
        this.soDem = soDem;
    }

    public TourDTO(String tenTour, float gia, TrangThaiTour tinhTrang, String moTa, String diemKhoiHanh, String diemDen, String loaiTour, int soNgay, int soDem) {
        this.tenTour = tenTour;
        this.gia = gia;
        this.tinhTrang = tinhTrang;
        this.moTa = moTa;
        this.diemKhoiHanh = diemKhoiHanh;
        this.diemDen = diemDen;
        this.loaiTour = loaiTour;
        this.soNgay = soNgay;
        this.soDem = soDem;
    }

    public TourDTO() {
    }

    public int getMaTour() {
        return maTour;
    }

    public void setMaTour(int maTour) {
        this.maTour = maTour;
    }

    public String getTenTour() {
        return tenTour;
    }

    public void setTenTour(String tenTour) {
        this.tenTour = tenTour;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public TrangThaiTour getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(TrangThaiTour tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getDiemKhoiHanh() {
        return diemKhoiHanh;
    }

    public void setDiemKhoiHanh(String diemKhoiHanh) {
        this.diemKhoiHanh = diemKhoiHanh;
    }

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

    public String getLoaiTour() {
        return loaiTour;
    }

    public void setLoaiTour(String loaiTour) {
        this.loaiTour = loaiTour;
    }

    public int getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }

    public int getSoDem() {
        return soDem;
    }

    public void setSoDem(int soDem) {
        this.soDem = soDem;
    }

    public Object[] toObjectArray() {
        return new Object[]{
            maTour,
            tenTour,
            gia,
            tinhTrang.getMoTa(),
            moTa,
            diemKhoiHanh,
            diemDen,
            loaiTour,
            soNgay,
            soDem
        };
    }

    public static final String[] TOUR_COLUMN_NAMES = {
        "Mã Tour",
        "Tên Tour",
        "Giá",
        "Tình Trạng",
        "Mô Tả",
        "Điểm Khởi Hành",
        "Điểm Đến",
        "Loại Tour",
        "Số Ngày",
        "Số Đêm"
    };
}
