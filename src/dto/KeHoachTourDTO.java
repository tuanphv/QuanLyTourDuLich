package dto;

import java.time.LocalDate;
import enums.TrangThaiKeHoachTour;
import utils.FormatDate;

public class KeHoachTourDTO {

    private int maKHTour;
    private int maTour;
    private LocalDate thoiGianBD;
    private int slDaDat;
    private int slToiDa;
    private TrangThaiKeHoachTour trangThai;
    private float tongChiPhi;
    
    public KeHoachTourDTO() {
        this.trangThai = TrangThaiKeHoachTour.DANG_MO;
    }

    public KeHoachTourDTO(int maKHTour, int maTour, LocalDate thoiGianBD, int slDaDat, int slToiDa, TrangThaiKeHoachTour trangThai, float tongChiPhi) {
        this.maKHTour = maKHTour;
        this.maTour = maTour;
        this.thoiGianBD = thoiGianBD;
        this.slDaDat = slDaDat;
        this.slToiDa = slToiDa;
        this.trangThai = trangThai;
        this.tongChiPhi = tongChiPhi;
    }

    public int getMaTour() {
        return maTour;
    }

    public void setMaTour(int maTour) {
        this.maTour = maTour;
    }

    public LocalDate getThoiGianBD() {
        return thoiGianBD;
    }

    public void setThoiGianBD(LocalDate thoiGianBD) {
        this.thoiGianBD = thoiGianBD;
    }

    public int getSlDaDat() {
        return slDaDat;
    }

    public void setSlDaDat(int slDaDat) {
        this.slDaDat = slDaDat;
    }

    public int getSlToiDa() {
        return slToiDa;
    }

    public void setSlToiDa(int slToiDa) {
        this.slToiDa = slToiDa;
    }

    public TrangThaiKeHoachTour getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThaiKeHoachTour trangThai) {
        this.trangThai = trangThai;
    }

    public float getTongChiPhi() {
        return tongChiPhi;
    }

    public void setTongChiPhi(float tongChiPhi) {
        this.tongChiPhi = tongChiPhi;
    }

    public int getMaKHTour() {
        return maKHTour;
    }

    public void setMaKHTour(int maKHTour) {
        this.maKHTour = maKHTour;
    }
    
    public float getGiaVe() {
        return (float) (tongChiPhi * 1.5);
    }

    public static String[] KH_TOUR_COLUMN_NAMES = {"Mã KH tour", "Mã tour", "TG bắt đầu", "Đã đặt", "Tối đa", "Trạng thái", "Tổng chi phí"};

    public Object[] toObjectArray() {
        return new Object[]{maKHTour, maTour, FormatDate.toString(thoiGianBD), slDaDat, slToiDa, trangThai.getMoTa(), String.format("%.0f", tongChiPhi)};
    }
}
