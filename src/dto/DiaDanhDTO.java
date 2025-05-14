package dto;

import utils.TextUtils;

public class DiaDanhDTO {
    private int maDD;
    private String tenDD;
    private String tinhThanh;
    int chiPhi;
    private String diemNoiBat;

    public DiaDanhDTO() {
    }

    public DiaDanhDTO(String tenDD, String tinhThanh, int chiPhi, String diemNoiBat) {
        this.tenDD = tenDD;
        this.tinhThanh = tinhThanh;
        this.chiPhi = chiPhi;
        this.diemNoiBat = diemNoiBat;
    }

    public DiaDanhDTO(int maDD, String tenDD, String tinhThanh, int chiPhi, String diemNoiBat) {
        this.maDD = maDD;
        this.tenDD = tenDD;
        this.tinhThanh = tinhThanh;
        this.chiPhi = chiPhi;
        this.diemNoiBat = diemNoiBat;
    }
    
    public int getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(int chiPhi) {
        this.chiPhi = chiPhi;
    }
    
    public int getMaDD() {
        return maDD;
    }
    public void setMaDD(int maDD) {
        this.maDD = maDD;
    }

    public String getTenDD() {
        return tenDD;
    }

    public void setTenDD(String tenDD) {
        this.tenDD = tenDD;
    }

    public String getTinhThanh() {
        return tinhThanh;
    }

    public void setTinhThanh(String tinhThanh) {
        this.tinhThanh = tinhThanh;
    }

    public String getDiemNoiBat() {
        return diemNoiBat;
    }

    public void setDiemNoiBat(String diemNoiBat) {
        this.diemNoiBat = diemNoiBat;
    }

    @Override
    public String toString() {
        return "DiaDanhDTO{" + "maDD=" + maDD + ", tenDD=" + tenDD + ", tinhThanh=" + tinhThanh + ", chiPhi=" + chiPhi + ", diemNoiBat=" + diemNoiBat + '}';
    }
    
    public Object[] toObjectArray() {
        return new Object[]{
            maDD, tenDD, tinhThanh, TextUtils.formatCurrency(chiPhi), diemNoiBat
        };
    }
    
    public static final String[] DIA_DANH_COLUMN_NAMES = {"Mã địa danh", "Tên địa danh", "Tỉnh thành", "Chi phí", "Điểm nổi bật"};
    
}
