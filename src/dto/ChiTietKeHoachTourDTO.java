package dto;

import java.time.LocalDate;

public class ChiTietKeHoachTourDTO {
    int maChiTietKeHoachTour;
    int maKeHoachTour;
    LocalDate ngay;
    String moTa;
    long chiPhiNgay;

    public ChiTietKeHoachTourDTO() {
    }

    public ChiTietKeHoachTourDTO(int maKeHoachTour, LocalDate ngay, String moTa, long chiPhiNgay) {
        this.maKeHoachTour = maKeHoachTour;
        this.ngay = ngay;
        this.moTa = moTa;
        this.chiPhiNgay = chiPhiNgay;
    }

    public ChiTietKeHoachTourDTO(int maChiTietKeHoachTour, int maKeHoachTour, LocalDate ngay, String moTa, long chiPhiNgay) {
        this.maChiTietKeHoachTour = maChiTietKeHoachTour;
        this.maKeHoachTour = maKeHoachTour;
        this.ngay = ngay;
        this.moTa = moTa;
        this.chiPhiNgay = chiPhiNgay;
    }
    
    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    public int getMaChiTietKeHoachTour() {
        return maChiTietKeHoachTour;
    }

    public void setMaChiTietKeHoachTour(int maChiTietKeHoachTour) {
        this.maChiTietKeHoachTour = maChiTietKeHoachTour;
    }

    public int getMaKeHoachTour() {
        return maKeHoachTour;
    }

    public void setMaKeHoachTour(int maKeHoachTour) {
        this.maKeHoachTour = maKeHoachTour;
    }

    public LocalDate getNgay() {
        return ngay;
    }

    public void setNgay(LocalDate ngay) {
        this.ngay = ngay;
    }

    public long getChiPhiNgay() {
        return chiPhiNgay;
    }

    public void setChiPhiNgay(long chiPhiNgay) {
        this.chiPhiNgay = chiPhiNgay;
    }

    @Override
    public String toString() {
        return "ChiTietKeHoachTourDTO{" + "maChiTietKeHoachTour=" + maChiTietKeHoachTour + ", maKeHoachTour=" + maKeHoachTour + ", ngay=" + ngay + ", moTa=" + moTa + ", chiPhiNgay=" + chiPhiNgay + '}';
    }

}
