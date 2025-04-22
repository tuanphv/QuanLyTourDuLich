/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author pc
 */
public class NguoiDungDTO {

    protected int id;
    protected String username;
    protected String password;
    protected String ho;
    protected String ten;
    protected String ngaySinh;
    protected String gioiTinh;
    protected String soDT;
    protected String email;
    protected String cc_hc;
    protected String trangThai;

    public NguoiDungDTO() {
    }

    public NguoiDungDTO(int ma, String username, String password, String ten, String ho, String ngaySinh, String gioiTinh, String soDT, String email, String cc_hc, String trangThai) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.ten = ten;
        this.ho = ho;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDT = soDT;
        this.email = email;
        this.cc_hc = cc_hc;
        this.trangThai = trangThai;
    }
    public int getID(){
        return id;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public String getTen() {
        return ten;
    }

    public String getHo() {
        return ho;
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
    public String getCC_HC() {
        return cc_hc;
    }
    public String getTrangThai() {
        return trangThai;
    }
    
    public void setID (int id){
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setHo(String ho) {
        this.ho = ho;
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
    public void setCC_HC(String cc_hc) {
        this.cc_hc = cc_hc;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
