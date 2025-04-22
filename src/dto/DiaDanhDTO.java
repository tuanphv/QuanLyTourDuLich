package dto;

public class DiaDanhDTO {
    private int maDD;
    private String tenDD;
    private String tinhThanh;
    private String diemNoiBat;


    public DiaDanhDTO(int maDD, String tenDD, String tinhThanh, String diemNoiBat) {
        this.maDD = maDD;
        this.tenDD = tenDD;
        this.tinhThanh = tinhThanh;
        this.diemNoiBat = diemNoiBat;
    }
    
    public DiaDanhDTO(String tenDD, String tinhThanh, String diemNoiBat) {
        this.tenDD = tenDD;
        this.tinhThanh = tinhThanh;
        this.diemNoiBat = diemNoiBat;
    }

    public DiaDanhDTO() {
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
    
    public Object[] toObjectArray() {
        return new Object[]{
            maDD, tenDD, tinhThanh, diemNoiBat
        };
    }
    
    public static final String[] DIA_DANH_COLUMN_NAMES = {"Mã địa danh", "Tên địa danh", "Tỉnh thành", "Điểm nổi bật"};
}
