package bus;

import dao.PhuongTienDAO;
import dto.DiaDanhDTO;
import dto.PhuongTienDTO;
import utils.CellUtils;
import utils.ExcelWriter;

import java.util.ArrayList;

public class PhuongTienBUS {
    PhuongTienDAO phuongTienDAO;
    ArrayList<PhuongTienDTO> listVehicle;

    public PhuongTienBUS() {
        phuongTienDAO = new PhuongTienDAO();
        listVehicle = phuongTienDAO.getAllVehicle();
    }

    public int insert(PhuongTienDTO phuongTien) {
        int index = phuongTienDAO.insert(phuongTien);
        if (index != -1) listVehicle.add(phuongTien);
        return index;
    }

    public boolean update(PhuongTienDTO phuongTien) {
        boolean check = phuongTienDAO.update(phuongTien);
        if (check) listVehicle.set(getIndexById(phuongTien.getMaPhuongTien()), phuongTien);
        return check;
    }

    public boolean delete(int maPhuongTien) {
        boolean check = phuongTienDAO.delete(maPhuongTien);
        if (check) listVehicle.remove(getIndexById(maPhuongTien));
        return check;
    }

    public ArrayList<PhuongTienDTO> getListVehicle() {
        return listVehicle;
    }

    public int getIndexById(int maPhuongTien) {
        for (int i = 0; i < listVehicle.size(); i++) {
            if (listVehicle.get(i).getMaPhuongTien() == maPhuongTien) {
                return i;
            }
        }
        return -1;
    }

    public PhuongTienDTO getVehicleById(int maPhuongTien) {
        for (PhuongTienDTO phuongTien : listVehicle) {
            if (phuongTien.getMaPhuongTien() == maPhuongTien) {
                return phuongTien;
            }
        }
        return null;
    }

    public PhuongTienDTO getVehicleByName(String tenPhuongTien) {
        for (PhuongTienDTO phuongTien : listVehicle) {
            if (phuongTien.getTenPhuongTien().equals(tenPhuongTien)) {
                return phuongTien;
            }
        }
        return null;
    }

    public int getIdByName(String tenPhuongTien) {
        for (PhuongTienDTO phuongTien : listVehicle) {
            if (phuongTien.getTenPhuongTien().equals(tenPhuongTien)) {
                return phuongTien.getMaPhuongTien();
            }
        }
        return -1;
    }

    public String getNameById(int maPhuongTien) {
        for (PhuongTienDTO phuongTien : listVehicle) {
            if (phuongTien.getMaPhuongTien() == maPhuongTien) {
                return phuongTien.getTenPhuongTien();
            }
        }
        return null;
    }
    
    public ArrayList<PhuongTienDTO> getListPhuongTienBySoCho(int soChoNgoi) {
        ArrayList<PhuongTienDTO> listPhuongTien = new ArrayList<>();
        for (PhuongTienDTO phuongTien : listVehicle) {
            if (phuongTien.getSoChoNgoi() > soChoNgoi) {
                listPhuongTien.add(phuongTien);
            }
        }
        return listPhuongTien;
    }

    public ArrayList<PhuongTienDTO> getListPhuongTienByLoaiPhuongTien(String tenPhuongTien) {
        ArrayList<PhuongTienDTO> listPhuongTien = new ArrayList<>();
        for (PhuongTienDTO phuongTien : listVehicle) {
            if (phuongTien.getLoaiPhuongTien().toLowerCase().contains(tenPhuongTien.toLowerCase())) {
                listPhuongTien.add(phuongTien);
            }
        }
        return listPhuongTien;
    }

    public ArrayList<PhuongTienDTO> getListPhuongTienByChiPhi(int chiPhi) {
        ArrayList<PhuongTienDTO> listPhuongTien = new ArrayList<>();
        for (PhuongTienDTO phuongTien : listVehicle) {
            if (phuongTien.getGia() <= chiPhi) {
                listPhuongTien.add(phuongTien);
            }
        }
        return listPhuongTien;
    }

    public String exportExcel() {
        ArrayList<Object[]> data = new ArrayList<>();
        // tạo headers
        String [] headers = {"Mã phương tiện", "Tên phương tiện", "Loại phương tiện", "Số chỗ ngồi", "Giá", "Số điện thoại"};
        data.add(headers);
        // add từng dòng
        for (PhuongTienDTO phuongTien : listVehicle) {
            data.add(phuongTien.toExcelRow());
        }

        ExcelWriter excelWriter = new ExcelWriter(((cell, value, rowIndex, columnIndex) -> {
            if (rowIndex == 0) {
                cell.setCellStyle(CellUtils.getBoldStyle(cell.getSheet().getWorkbook()));
                cell.setCellValue((String) value);
            } else {
                switch (columnIndex) {
                    case 0, 3 ->
                        cell.setCellValue((Integer) value);
                    case 4 -> {
                        cell.setCellStyle(CellUtils.getCurrencyStyle(cell.getSheet().getWorkbook()));
                        cell.setCellValue((Integer) value);
                    }
                    default ->
                        cell.setCellValue((String) value);
                }
            }
        }));
        return excelWriter.writeWithDialog("DanhSachPhuongTien.xlsx", data);
    }

}

