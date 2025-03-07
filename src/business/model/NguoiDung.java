/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.model;

/**
 *
 * @author pc
 */
public class NguoiDung {
    private String tenDangNhap;
    private String matKhau;
    private String vaiTro;
    private String id;
    private String hoND;
    private String tenND;
    private String ngaySinh;
    private String gioiTinh;
    private String soDT;
    private String email;
    private String diaChi;

    public NguoiDung() {
    }

    public NguoiDung(String tenDangNhap, String matKhau, String vaiTro, String id, String hoND, String tenND, String ngaySinh, String gioiTinh, String soDT, String email, String diaChi) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.id = id;
        this.hoND = hoND;
        this.tenND = tenND;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDT = soDT;
        this.email = email;
        this.diaChi = diaChi;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public String getId() {
        return id;
    }

    public String getHoND() {
        return hoND;
    }

    public String getTenND() {
        return tenND;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getSoDT() {
        return soDT;
    }

    public String getEmail() {
        return email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHoND(String hoND) {
        this.hoND = hoND;
    }

    public void setTenND(String tenND) {
        this.tenND = tenND;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    
}
