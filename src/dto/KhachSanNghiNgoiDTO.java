package dto;

public class KhachSanNghiNgoiDTO {
    private int maKhachSanNghiNgoi;
    private int maChiTietKeHoachTour;
    private int maKhachSan;
    private long chiPhiKhachSan;

    public KhachSanNghiNgoiDTO() {
    }

    public KhachSanNghiNgoiDTO(int maChiTietKeHoachTour, int maKhachSan, long chiPhiKhachSan) {
        this.maChiTietKeHoachTour = maChiTietKeHoachTour;
        this.maKhachSan = maKhachSan;
        this.chiPhiKhachSan = chiPhiKhachSan;
    }

    public KhachSanNghiNgoiDTO(int maKhachSanNghiNgoi, int maChiTietKeHoachTour, int maKhachSan, long chiPhiKhachSan) {
        this.maKhachSanNghiNgoi = maKhachSanNghiNgoi;
        this.maChiTietKeHoachTour = maChiTietKeHoachTour;
        this.maKhachSan = maKhachSan;
        this.chiPhiKhachSan = chiPhiKhachSan;
    }
    
    public int getMaKhachSanNghiNgoi() {
        return maKhachSanNghiNgoi;
    }

    public void setMaKhachSanNghiNgoi(int maKhachSanNghiNgoi) {
        this.maKhachSanNghiNgoi = maKhachSanNghiNgoi;
    }
    
    public int getMaChiTietKeHoachTour() {
        return maChiTietKeHoachTour;
    }

    public void setMaChiTietKeHoachTour(int maChiTietKeHoachTour) {
        this.maChiTietKeHoachTour = maChiTietKeHoachTour;
    }

    public int getMaKhachSan() {
        return maKhachSan;
    }

    public void setMaKhachSan(int maKhachSan) {
        this.maKhachSan = maKhachSan;
    }

    public long getChiPhiKhachSan() {
        return chiPhiKhachSan;
    }

    public void setChiPhiKhachSan(long chiPhiKhachSan) {
        this.chiPhiKhachSan = chiPhiKhachSan;
    }

    @Override
    public String toString() {
        return "KhachSanNghiNgoiDTO{" + "maKhachSanNghiNgoi=" + maKhachSanNghiNgoi + ", maChiTietKeHoachTour=" + maChiTietKeHoachTour + ", maKhachSan=" + maKhachSan + ", chiPhiKhachSan=" + chiPhiKhachSan + '}';
    }
    
}
