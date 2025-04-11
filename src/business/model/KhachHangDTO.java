/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.model;

/**
 *
 * @author pc
 */
public class KhachHangDTO extends NguoiDungDTO {
    private String ngayDK;

    public KhachHangDTO() {
    }

    public KhachHangDTO(int id, String username, String password, String ho, String ten, String ngaySinh, String gioiTinh, String soDT, String email, String cc_hc, String ngayDK, String trangThai) {
        super(id, username, password, ten, ho, ngaySinh, gioiTinh, soDT, email, cc_hc, trangThai);
        this.ngayDK = ngayDK;
    }
    public int getMaKH() {
        return id;
    }
    
    public String getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(String ngayDK) {
        this.ngayDK = ngayDK;
    }
    
    public void setMaKH(int maHK) {
        this.id = id;
    }
    
    public Object[] toArray() {
        Object[] arr = {this.id,this.username, this.password, this.ho + " " + this.ten, this.gioiTinh, this.soDT, this.email, this.ngayDK};
        return arr;
    }
}
