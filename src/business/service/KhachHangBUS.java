/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.service;

import business.model.KhachHangDTO;
import java.util.ArrayList;
import persistence.dao.KhachHangDAO;

/**
 *
 * @author pc
 */
public class KhachHangBUS {

    private KhachHangDAO cusDAO = new KhachHangDAO();
    private ArrayList<KhachHangDTO> list;

    public KhachHangBUS() {
        list = cusDAO.getAllKhachHang();
    }

    public ArrayList<KhachHangDTO> getKhachHang() {
        return list;
    }

    public void deleteKhachHang(KhachHangDTO c) {
        list.remove(c);
        cusDAO.deleteKhachHang(c.getMaKH());
    }

    public void deleteKhachHang(int index) {
        cusDAO.deleteKhachHang(list.get(index).getMaKH());
        list.remove(index);
    }

    public void addKhachHang(KhachHangDTO c) {
        list.add(c);
    }

    public void updateKhachHang(int index, KhachHangDTO c) {
        list.set(index, c);
        cusDAO.updateKhachHang(c);
    }
}
