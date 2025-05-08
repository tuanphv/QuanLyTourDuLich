package dto;

public class DiaDiemThamQuanDTO {
    private int maDiaDiemThamQuan;
    private int maChiTietKeHoachTour;
    private int maDiaDanh;
    private String moTaHoatDong;
    private int maPhuongTienDiChuyen;
    private long chiPhiThamQuan;
    private long chiPhiDiChuyen;

    public DiaDiemThamQuanDTO() {
    }

    public DiaDiemThamQuanDTO(int maChiTietKeHoachTour, int maDiaDanh, String moTaHoatDong, int maPhuongTienDiChuyen, long chiPhiThamQuan, long chiPhiDiChuyen) {
        this.maChiTietKeHoachTour = maChiTietKeHoachTour;
        this.maDiaDanh = maDiaDanh;
        this.moTaHoatDong = moTaHoatDong;
        this.maPhuongTienDiChuyen = maPhuongTienDiChuyen;
        this.chiPhiThamQuan = chiPhiThamQuan;
        this.chiPhiDiChuyen = chiPhiDiChuyen;
    }

    public DiaDiemThamQuanDTO(int maDiaDiemThamQuan, int maChiTietKeHoachTour, int maDiaDanh, String moTaHoatDong, int maPhuongTienDiChuyen, long chiPhiThamQuan, long chiPhiDiChuyen) {
        this.maDiaDiemThamQuan = maDiaDiemThamQuan;
        this.maChiTietKeHoachTour = maChiTietKeHoachTour;
        this.maDiaDanh = maDiaDanh;
        this.moTaHoatDong = moTaHoatDong;
        this.maPhuongTienDiChuyen = maPhuongTienDiChuyen;
        this.chiPhiThamQuan = chiPhiThamQuan;
        this.chiPhiDiChuyen = chiPhiDiChuyen;
    }

    public int getMaDiaDiemThamQuan() {
        return maDiaDiemThamQuan;
    }

    public void setMaDiaDiemThamQuan(int maDiaDiemThamQuan) {
        this.maDiaDiemThamQuan = maDiaDiemThamQuan;
    }

    public int getMaChiTietKeHoachTour() {
        return maChiTietKeHoachTour;
    }

    public void setMaChiTietKeHoachTour(int maChiTietKeHoachTour) {
        this.maChiTietKeHoachTour = maChiTietKeHoachTour;
    }

    public int getMaDiaDanh() {
        return maDiaDanh;
    }

    public void setMaDiaDanh(int maDiaDanh) {
        this.maDiaDanh = maDiaDanh;
    }

    public String getMoTaHoatDong() {
        return moTaHoatDong;
    }

    public void setMoTaHoatDong(String moTaHoatDong) {
        this.moTaHoatDong = moTaHoatDong;
    }

    public int getMaPhuongTienDiChuyen() {
        return maPhuongTienDiChuyen;
    }

    public void setMaPhuongTienDiChuyen(int maPhuongTienDiChuyen) {
        this.maPhuongTienDiChuyen = maPhuongTienDiChuyen;
    }

    public long getChiPhiThamQuan() {
        return chiPhiThamQuan;
    }

    public void setChiPhiThamQuan(long chiPhiThamQuan) {
        this.chiPhiThamQuan = chiPhiThamQuan;
    }

    public long getChiPhiDiChuyen() {
        return chiPhiDiChuyen;
    }

    public void setChiPhiDiChuyen(long chiPhiDiChuyen) {
        this.chiPhiDiChuyen = chiPhiDiChuyen;
    }

    @Override
    public String toString() {
        return "DiaDiemThamQuanDTO{" + "maDiaDiemThamQuan=" + maDiaDiemThamQuan + ", maChiTietKeHoachTour=" + maChiTietKeHoachTour + ", maDiaDanh=" + maDiaDanh + ", moTaHoatDong=" + moTaHoatDong + ", maPhuongTienDiChuyen=" + maPhuongTienDiChuyen + ", chiPhiThamQuan=" + chiPhiThamQuan + ", chiPhiDiChuyen=" + chiPhiDiChuyen + '}';
    }

}
