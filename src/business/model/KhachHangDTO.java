package business.model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class KhachHangDTO {
    private int maKH;
    private String username;
    private String password;
    private String ho;
    private String ten;
    private String ngaySinh;
    private String gioiTinh;
    private String soDT;
    private String email;
    private String cc_hc;
    private String ngayDK;
    private int trangThai;

    public KhachHangDTO() {}

    public KhachHangDTO(int maKH, String username, String password, String ho, String ten, String ngaySinh,
                        String gioiTinh, String soDT, String email, String cc_hc, String ngayDK, int trangThai) {
        this.maKH = maKH;
        this.username = username;
        this.password = password;
        this.ho = ho;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDT = soDT;
        this.email = email;
        this.cc_hc = cc_hc;
        this.ngayDK = ngayDK;
        this.trangThai = trangThai;
    }

    public int getMaKH() { return maKH; }
    public void setMaKH(int maKH) { this.maKH = maKH; }

    public String getHo() { return ho; }
    public void setHo(String ho) { this.ho = ho; }

    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }

    public String getHoTen() { return ho + " " + ten; }
    public void setHoTen(String ho, String ten) {
        this.ho = ho;
        this.ten = ten;
    }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(String ngaySinh) { this.ngaySinh = ngaySinh; }
    public void setNgaySinh(LocalDate date) {
        this.ngaySinh = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    public String getGioiTinh() { return gioiTinh; }
    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }

    public String getSoDT() { return soDT; }
    public void setSoDT(String soDT) { this.soDT = soDT; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCC_HC() { return cc_hc; }
    public void setCC_HC(String cc_hc) { this.cc_hc = cc_hc; }

    public String getNgayDK() { return ngayDK; }
    public void setNgayDK(String ngayDK) { this.ngayDK = ngayDK; }

    public int getTrangThai() { return trangThai; }
    public void setTrangThai(int trangThai) { this.trangThai = trangThai; }

    public Object[] toObject() {
        return new Object[] {
            maKH, getHoTen(), ngaySinh, gioiTinh, soDT, email, ngayDK, cc_hc
        };
    }

    public static final String[] KHACH_HANG_COLUMN_NAMES = {
        "Mã KH", "Họ tên", "Ngày sinh", "Giới tính", "Điện thoại", "Email", "Ngày đăng kí", "Căn cước/ Hộ chiếu"
    };
}