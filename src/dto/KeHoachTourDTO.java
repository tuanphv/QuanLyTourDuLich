package dto;

import enums.TrangThaiKeHoachTour;
import java.time.LocalDate;
import utils.FormatDate;
import utils.TextUtils;

public class KeHoachTourDTO {

    private int maKHTour;
    private int maTour;
    private LocalDate thoiGianBD;
    private LocalDate thoiGianKT;
    private int slDaDat;
    private int slToiDa;
    private float tongChiPhi;
    private TrangThaiKeHoachTour trangThai;
    
    public KeHoachTourDTO() {
        this.trangThai = TrangThaiKeHoachTour.DANG_MO;
    }

    public KeHoachTourDTO(int maTour, LocalDate thoiGianBD, LocalDate thoiGianKT, int slDaDat, int slToiDa, float tongChiPhi, TrangThaiKeHoachTour trangThai) {
        this.maTour = maTour;
        this.thoiGianBD = thoiGianBD;
        this.thoiGianKT = thoiGianKT;
        this.slDaDat = slDaDat;
        this.slToiDa = slToiDa;
        this.tongChiPhi = tongChiPhi;
        this.trangThai = trangThai;
    }
    
    public KeHoachTourDTO(int maKHTour, int maTour, LocalDate thoiGianBD, LocalDate thoiGianKT, int slDaDat, int slToiDa, float tongChiPhi, TrangThaiKeHoachTour trangThai) {
        this.maKHTour = maKHTour;
        this.maTour = maTour;
        this.thoiGianBD = thoiGianBD;
        this.slDaDat = slDaDat;
        this.slToiDa = slToiDa;
        this.tongChiPhi = tongChiPhi;
        this.trangThai = trangThai;
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

    public LocalDate getThoiGianKT() {
        return thoiGianKT;
    }

    public void setThoiGianKT(LocalDate thoiGianKT) {
        this.thoiGianKT = thoiGianKT;
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
        return tongChiPhi;
    }

    public static String[] KH_TOUR_COLUMN_NAMES = {"Mã KH tour", "Mã tour", "TG bắt đầu", "TG kết thúc","Đã đặt", "Tối đa", "Trạng thái", "Tổng chi phí"};

    public Object[] toObjectArray() {
        return new Object[]{maKHTour, maTour, FormatDate.toString(thoiGianBD), FormatDate.toString(thoiGianKT), slDaDat, slToiDa, trangThai.getMoTa(), TextUtils.formatCurrency(tongChiPhi)};
    }
}
