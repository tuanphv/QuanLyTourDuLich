package business.model;

public class NhaHangDTO {
    private int maNhaHang;
    private String tenNhaHang;
    private String diaChi;
    private int gia;
    private String soDienThoai;
    private int trangThai;

    public NhaHangDTO() {
    }

    public NhaHangDTO(String tenNhaHang, String diaChi, int gia, String soDienThoai, int trangThai) {
        this.tenNhaHang = tenNhaHang;
        this.diaChi = diaChi;
        this.gia = gia;
        this.soDienThoai = soDienThoai;
        this.trangThai = trangThai;
    }

    public NhaHangDTO(int maNhaHang, String tenNhaHang, String diaChi, int gia, String soDienThoai, int trangThai) {
        this.maNhaHang = maNhaHang;
        this.tenNhaHang = tenNhaHang;
        this.diaChi = diaChi;
        this.gia = gia;
        this.soDienThoai = soDienThoai;
        this.trangThai = trangThai;
    }

    public int getMaNhaHang() {
        return maNhaHang;
    }

    public void setMaNhaHang(int maNhaHang) {
        this.maNhaHang = maNhaHang;
    }

    public String getTenNhaHang() {
        return tenNhaHang;
    }

    public void setTenNhaHang(String tenNhaHang) {
        this.tenNhaHang = tenNhaHang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "NhaHangDTO{" + "maNhaHang=" + maNhaHang + ", tenNhaHang=" + tenNhaHang + ", diaChi=" + diaChi + ", gia=" + gia + ", soDienThoai=" + soDienThoai + ", trangThai=" + trangThai + '}';
    }

    public static final String[] NHA_HANG_COLUMN_NAMES = {
        "Mã nhà hàng",
        "Tên nhà hàng",
        "Địa chỉ",
        "Giá",
        "Số điện thoại",
        "Trạng thái"
    };

    public Object[] toObject() {
        return new Object[] {
            maNhaHang, 
            tenNhaHang,
            diaChi,
            gia,
            soDienThoai,
            trangThai
        };
    }
    
}
