package dto;

import java.util.Date;
import utils.FormatDate;

public class KeHoachTourDTO {

    private int maKHTour;
    private int maTour;
    private Date thoiGianBD;
    private Date thoiGianKT;
    private int slDaDat;
    private int slToiDa;
    private String trangThai;
    private float tongChiPhi;

    public KeHoachTourDTO() {
    }

    public KeHoachTourDTO(int maKHTour, int maTour, Date thoiGianBD, Date thoiGianKT, int slDaDat, int slToiDa, String trangThai, float tongChiPhi) {
        this.maKHTour = maKHTour;
        this.maTour = maTour;
        this.thoiGianBD = thoiGianBD;
        this.thoiGianKT = thoiGianKT;
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

    public Date getThoiGianBD() {
        return thoiGianBD;
    }

    public void setThoiGianBD(Date thoiGianBD) {
        this.thoiGianBD = thoiGianBD;
    }

    public Date getThoiGianKT() {
        return thoiGianKT;
    }

    public void setThoiGianKT(Date thoiGianKT) {
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
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

    public static String[] KH_TOUR_COLUMN_NAMES = {"Mã KH tour", "Mã tour", "TG bắt đầu", "TG kết thúc", "Đã đặt", "Tối đa", "Trạng thái", "Tổng chi phí"};

    public Object[] toObjectArray() {
        return new Object[]{maKHTour, maTour, FormatDate.toString(thoiGianBD), FormatDate.toString(thoiGianKT), slDaDat, slToiDa, trangThai, String.valueOf(tongChiPhi)};
    }
}
