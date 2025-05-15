package bus;

import dao.NhaHangDAO;
import dto.KhachSanDTO;
import dto.NhaHangDTO;
import utils.CellUtils;
import utils.ExcelWriter;

import java.util.ArrayList;

public class NhaHangBUS {
    NhaHangDAO nhaHangDAO;
    ArrayList<NhaHangDTO> listRestaurant;

    public NhaHangBUS() {
        nhaHangDAO = new NhaHangDAO();
        listRestaurant = nhaHangDAO.getAllRestaurant();
    }

    public int insert(NhaHangDTO nhaHang) {
        int index = nhaHangDAO.insert(nhaHang);
        if (index != -1) listRestaurant.add(nhaHang);
        return index;
    }

    public boolean update(NhaHangDTO nhaHang) {
        boolean check = nhaHangDAO.update(nhaHang);
        if (check) listRestaurant.set(getIndexById(nhaHang.getMaNhaHang()), nhaHang);
        return check;
    }

    public boolean delete(int maNhaHang) {
        boolean check = nhaHangDAO.delete(maNhaHang);
        if (check) listRestaurant.remove(getIndexById(maNhaHang));
        return check;
    }

    public ArrayList<NhaHangDTO> getListRestaurant() {
        return listRestaurant;
    }

    public int getIndexById(int maNhaHang) {
        for (int i = 0; i < listRestaurant.size(); i++) {
            if (listRestaurant.get(i).getMaNhaHang() == maNhaHang) {
                return i;
            }
        }
        return -1;
    }

    public NhaHangDTO getRestaurantById(int maNhaHang) {
        for (NhaHangDTO nhaHang : listRestaurant) {
            if (nhaHang.getMaNhaHang() == maNhaHang) {
                return nhaHang;
            }
        }
        return null;
    }

    public NhaHangDTO getRestaurantByName(String tenNhaHang) {
        for (NhaHangDTO nhaHang : listRestaurant) {
            if (nhaHang.getTenNhaHang().equals(tenNhaHang)) {
                return nhaHang;
            }
        }
        return null;
    }

    public int getIdByName(String tenNhaHang) {
        for (NhaHangDTO nhaHang : listRestaurant) {
            if (nhaHang.getTenNhaHang().equals(tenNhaHang)) {
                return nhaHang.getMaNhaHang();
            }
        }
        return -1;
    }

    public String getNameById(int maNhaHang) {
        for (NhaHangDTO nhaHang : listRestaurant) {
            if (nhaHang.getMaNhaHang() == maNhaHang) {
                return nhaHang.getTenNhaHang();
            }
        }
        return null;
    }
    
    public ArrayList<NhaHangDTO> getNhaHangByDiaChi(String diaChi) {
        ArrayList<NhaHangDTO> listNhaHang = new ArrayList<>();
        for (NhaHangDTO nhaHang : listRestaurant) {
            if (nhaHang.getDiaChi().toLowerCase().contains(diaChi.toLowerCase())) {
                listNhaHang.add(nhaHang);
            }
        }
        return listNhaHang;
    }

    public ArrayList<NhaHangDTO> getNhaHangByChiPhi(int chiPhi) {
        ArrayList<NhaHangDTO> listNhaHang = new ArrayList<>();
        for (NhaHangDTO nhaHang : listRestaurant) {
            if (nhaHang.getGia() <= chiPhi) {
                listNhaHang.add(nhaHang);
            }            
        }
        return listNhaHang;
    }

    public String exportExcel() {
        ArrayList<Object[]> data = new ArrayList<>();
        // tạo headers
        Object[] headers = new Object[]{"Mã nhà hàng", "Tên nhà hàng", "Địa chỉ", "Giá", "Số điện thoại"};
        data.add(headers);
        // add data
        for (NhaHangDTO nhaHang : listRestaurant) {
            data.add(nhaHang.toExcelRow());
        }

        ExcelWriter excelWriter = new ExcelWriter(((cell, value, rowIndex, columnIndex) -> {
            if (rowIndex == 0) {
                cell.setCellStyle(CellUtils.getBoldStyle(cell.getSheet().getWorkbook()));
                cell.setCellValue((String) value);
            } else {
                switch (columnIndex) {
                    case 0 ->
                        cell.setCellValue((Integer) value);
                    case 3 -> {
                        cell.setCellStyle(CellUtils.getCurrencyStyle(cell.getSheet().getWorkbook()));
                        cell.setCellValue((Integer) value);
                    }
                    default ->
                        cell.setCellValue((String) value);
                }
            }
        }));
        return excelWriter.writeWithDialog("DanhSachNhaHang.xlsx", data);
    }

}

