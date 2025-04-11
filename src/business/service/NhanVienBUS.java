/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.service;

import business.model.NhanVienDTO;
import persistence.dao.NhanVienDAO;
import java.util.ArrayList;

public class NhanVienBUS {
    private NhanVienDAO nhanVienDAO = new NhanVienDAO();
    private ArrayList<NhanVienDTO> danhSachNhanVien;

    public NhanVienBUS() {
        danhSachNhanVien = nhanVienDAO.getAllNhanVien();
    }

    // Lấy toàn bộ danh sách nhân viên
    public ArrayList<NhanVienDTO> getNhanVien() {
        return danhSachNhanVien;
    }

    // Thêm nhân viên mới
    public void addNhanVien(NhanVienDTO nv) {
        nhanVienDAO.addNhanVien(nv); // Thêm vào CSDL
        danhSachNhanVien.add(nv);    // Cập nhật danh sách trong BUS
    }

    // Sửa thông tin nhân viên
    public void updateNhanVien(int index, NhanVienDTO nv) {
        nhanVienDAO.updateNhanVien(nv);          // Cập nhật CSDL
        danhSachNhanVien.set(index, nv);         // Cập nhật danh sách trong BUS
    }

    // Xóa nhân viên theo index
    public void deleteNhanVien(int index) {
        int maNV = danhSachNhanVien.get(index).getMaNV();
        nhanVienDAO.deleteNhanVien(maNV);        // Xóa từ CSDL
        danhSachNhanVien.remove(index);          // Xóa khỏi danh sách trong BUS
    }

    // Tìm kiếm nhân viên theo mã
    public NhanVienDTO timNhanVienTheoMa(int maNV) {
        for (NhanVienDTO nv : danhSachNhanVien) {
            if (nv.getMaNV() == maNV) {
                return nv;
            }
        }
        return null;
    }
}
