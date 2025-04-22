package dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NhanVienDTO {
    private int maNV;
    private String username;
    private String password;
    private String ho;
    private String ten;
    private String ngaySinh;
    private String gioiTinh;
    private String soDT;
    private String email;
    private String cc_hc;
    private String ngayVaoLam;
    private String chucVu;
    private int trangThai;

    public NhanVienDTO() {}

    public NhanVienDTO(int maNV, String username, String password, String ho, String ten, 
                      String ngaySinh, String gioiTinh, String soDT, String email, 
                      String cc_hc, String ngayVaoLam, String chucVu, int trangThai) {
        this.maNV = maNV;
        this.username = username;
        this.password = password;
        this.ho = ho;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDT = soDT;
        this.email = email;
        this.cc_hc = cc_hc;
        this.ngayVaoLam = ngayVaoLam;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
    }

    // Getter và Setter cho tất cả trường
    public int getMaNV() { return maNV; }
    public void setMaNV(int maNV) { this.maNV = maNV; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getHo() { return ho; }
    public void setHo(String ho) { this.ho = ho; }

    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }

    public String getHoTen() { return ho + " " + ten; }
    public void setHoTen(String ho, String ten) {
        this.ho = ho;
        this.ten = ten;
    }
    
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

    public String getNgayVaoLam() { return ngayVaoLam; }
    public void setNgayVaoLam(String ngayVaoLam) { this.ngayVaoLam = ngayVaoLam; }

    public String getChucVu() { return chucVu; }
    public void setChucVu(String chucVu) { this.chucVu = chucVu; }

    public int getTrangThai() { return trangThai; }
    public void setTrangThai(int trangThai) { this.trangThai = trangThai; }

    public Object[] toObject() {
        return new Object[] {
            maNV, getHoTen(), ngaySinh, gioiTinh, soDT, email, cc_hc, ngayVaoLam, chucVu
        };
    }

    public static final String[] NHAN_VIEN_COLUMN_NAMES = {
        "Mã NV", "Họ tên", "Ngày sinh", "Giới tính", "Điện thoại", "Email", "Căn cước/ Hộ chiếu", "Ngày vào làm", "Chức vụ"
    };
}