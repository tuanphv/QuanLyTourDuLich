/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author pc
 */
public class NhanVienDTO extends NguoiDungDTO {
    private String ngayVaoLam;
    private String chucVu;

    public NhanVienDTO() {
    }

    public NhanVienDTO(int id, String username, String password, String ho, String ten, String ngaySinh, String gioiTinh, String soDT, String email, String cc_hc, String ngayVaoLam, String chucVu, String trangThai) {
        super(id, username, password, ten, ho, ngaySinh, gioiTinh, soDT, email, cc_hc, trangThai);
        this.id = id;
        this.ngayVaoLam = ngayVaoLam;
        this.chucVu = chucVu;
    }

    public int getMaNV() {
        return id;
    }
    public String getNgayVaoLam() {
        return ngayVaoLam;
    }

    public String getChucVu() {
        return chucVu;
    }
    
    public void setMaNV(int id) {
        this.id= id;
    }
    public void setNgayVaoLam(String ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    
    public Object[] toArray() {
        Object[] arr = {this.id, this.username, this.password, this.ho + " " + this.ten, this.gioiTinh, this.soDT, this.email, this.ngayVaoLam};
        return arr;
    }
}
