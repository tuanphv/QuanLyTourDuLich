package business.model;

public class KhachSanDTO {
    private int maKhachSan;
    private String tenKhachSan;
    private String diaChi;
    private String sdt;
    private int gia;
    private int trangThai;

    public KhachSanDTO() {
    }

    public KhachSanDTO(String tenKhachSan, String diaChi, String sdt, int gia) {
        this.tenKhachSan = tenKhachSan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.gia = gia;
    }

    public KhachSanDTO(int maKhachSan, String tenKhachSan, String diaChi, String sdt, int gia, int trangThai) {
        this.maKhachSan = maKhachSan;
        this.tenKhachSan = tenKhachSan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.gia = gia;
        this.trangThai = trangThai;
    }

    public int getMaKhachSan() {
        return maKhachSan;
    }

    public void setMaKhachSan(int maKhachSan) {
        this.maKhachSan = maKhachSan;
    }

    public String getTenKhachSan() {
        return tenKhachSan;
    }

    public void setTenKhachSan(String tenKhachSan) {
        this.tenKhachSan = tenKhachSan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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
        return "KhachSanDTO{" + "maKhachSan=" + maKhachSan + ", tenKhachSan=" + tenKhachSan + ", diaChi=" + diaChi + ", sdt=" + sdt + ", gia=" + gia + ", trangThai=" + trangThai + '}';
    }

    public static final String[] KHACH_SAN_COLUMN_NAMES = {
        "Mã khách sạn",
        "Tên khách sạn",
        "Địa chỉ",
        "Giá",
        "Số điện thoại",
        "Trạng thái"
    };
    
}
