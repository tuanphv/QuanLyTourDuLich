package bus;

import dao.KhachSanDAO;
import dto.DiaDanhDTO;
import dto.KhachSanDTO;
import utils.CellUtils;
import utils.ExcelWriter;

import java.util.ArrayList;

public class KhachSanBUS {
    KhachSanDAO khachSanDAO;
    ArrayList<KhachSanDTO> listHotel;

    public KhachSanBUS() {
        khachSanDAO = new KhachSanDAO();
        listHotel = khachSanDAO.getAllHotel();
    }

    public int insert(KhachSanDTO khachSan) {
        int index = khachSanDAO.insert(khachSan);
        if (index != -1) listHotel.add(khachSan);
        return index;
    }

    public boolean update(KhachSanDTO khachSan) {
        boolean check = khachSanDAO.update(khachSan);
        if (check) listHotel.set(getIndexById(khachSan.getMaKhachSan()), khachSan);
        return check;
    }

    public boolean delete(int maKhachSan) {
        boolean check = khachSanDAO.delete(maKhachSan);
        if (check) listHotel.remove(getIndexById(maKhachSan));
        return check;
    }

    public ArrayList<KhachSanDTO> getListHotel() {
        return listHotel;
    }

    public int getIndexById(int maKhachSan) {
        for (int i = 0; i < listHotel.size(); i++) {
            if (listHotel.get(i).getMaKhachSan() == maKhachSan) {
                return i;
            }
        }
        return -1;
    }

    public KhachSanDTO getHotelById(int maKhachSan) {
        for (KhachSanDTO hotel : listHotel) {
            if (hotel.getMaKhachSan() == maKhachSan) {
                return hotel;
            }
        }
        return null;
    }

    public KhachSanDTO getHotelByName(String tenKhachSan) {
        for (KhachSanDTO hotel : listHotel) {
            if (hotel.getTenKhachSan().equals(tenKhachSan)) {
                return hotel;
            }
        }
        return null;
    }

    public int getIdByName(String tenKhachSan) {
        for (KhachSanDTO hotel : listHotel) {
            if (hotel.getTenKhachSan().equals(tenKhachSan)) {
                return hotel.getMaKhachSan();
            }
        }
        return -1;
    }

    public String getNameById(int maKhachSan) {
        for (KhachSanDTO hotel : listHotel) {
            if (hotel.getMaKhachSan() == maKhachSan) {
                return hotel.getTenKhachSan();
            }
        }
        return null;
    }

    public ArrayList<KhachSanDTO> getKhachSanByDiaChi(String diaChi) {
        ArrayList<KhachSanDTO> listKhachSan = new ArrayList<>();
        for (KhachSanDTO khachSan : listHotel) {
            if (khachSan.getDiaChi().toLowerCase().contains(diaChi.toLowerCase())) {
                listKhachSan.add(khachSan);
            }
        }
        return listKhachSan;
    }

    public ArrayList<KhachSanDTO> getKhachSanByChiPhi(int chiPhi) {
        ArrayList<KhachSanDTO> listKhachSan = new ArrayList<>();
        for (KhachSanDTO khachSan : listHotel) {
            if (khachSan.getGia() <= chiPhi) {
                listKhachSan.add(khachSan);
            }
        }
        return listKhachSan;
    }

    public String exportExcel() {
        ArrayList<Object[]> data = new ArrayList<>();
        // tạo headers
        String[] headers = {"Mã khách sạn", "Tên khách sạn", "Địa chỉ", "Giá", "Số điện thoại"};
        data.add(headers);
        // add data
        for (KhachSanDTO khachSan : listHotel) {
            data.add(khachSan.toExcelRow());
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
        return excelWriter.writeWithDialog("DanhSachKhachSan.xlsx", data);
    }

}

