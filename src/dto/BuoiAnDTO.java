package dto;

public class BuoiAnDTO {
    int maBuoiAn;
    int maChiTietKeHoachTour;
    String loaiBuoiAn; // breakfast, lunch, dinner
    int maNhaHang;
    double chiPhi;
    String moTa;

    public BuoiAnDTO() {
    }

    public BuoiAnDTO(int maChiTietKeHoachTour, String loaiBuoiAn, int maNhaHang, double chiPhi, String moTa) {
        this.maChiTietKeHoachTour = maChiTietKeHoachTour;
        this.loaiBuoiAn = loaiBuoiAn;
        this.maNhaHang = maNhaHang;
        this.chiPhi = chiPhi;
        this.moTa = moTa;
    }

    public BuoiAnDTO(int maBuoiAn, int maChiTietKeHoachTour, String loaiBuoiAn, int maNhaHang, double chiPhi, String moTa) {
        this.maBuoiAn = maBuoiAn;
        this.maChiTietKeHoachTour = maChiTietKeHoachTour;
        this.loaiBuoiAn = loaiBuoiAn;
        this.maNhaHang = maNhaHang;
        this.chiPhi = chiPhi;
        this.moTa = moTa;
    }

    public int getMaBuoiAn() {
        return maBuoiAn;
    }

    public void setMaBuoiAn(int maBuoiAn) {
        this.maBuoiAn = maBuoiAn;
    }

    public int getMaChiTietKeHoachTour() {
        return maChiTietKeHoachTour;
    }

    public void setMaChiTietKeHoachTour(int maChiTietKeHoachTour) {
        this.maChiTietKeHoachTour = maChiTietKeHoachTour;
    }

    public int getMaNhaHang() {
        return maNhaHang;
    }

    public void setMaNhaHang(int maNhaHang) {
        this.maNhaHang = maNhaHang;
    }

    public double getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(double chiPhi) {
        this.chiPhi = chiPhi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getLoaiBuoiAn() {
        return loaiBuoiAn;
    }

    public void setLoaiBuoiAn(String loaiBuoiAn) {
        this.loaiBuoiAn = loaiBuoiAn;
    }

    @Override
    public String toString() {
        return "BuoiAnDTO{" + "maBuoiAn=" + maBuoiAn + ", maChiTietKeHoachTour=" + maChiTietKeHoachTour + ", loaiBuoiAn=" + loaiBuoiAn + ", maNhaHang=" + maNhaHang + ", chiPhi=" + chiPhi + ", moTa=" + moTa + '}';
    }

}
