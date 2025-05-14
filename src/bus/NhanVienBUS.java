package bus;

import dto.NhanVienDTO;
import dao.NhanVienDAO;
import java.util.ArrayList;
import utils.CellUtils;
import utils.ExcelWriter;

public class NhanVienBUS {
    private NhanVienDAO dao;
    private ArrayList<NhanVienDTO> dsNhanVien;

    public NhanVienBUS() {
        dao = new NhanVienDAO();
        dsNhanVien = dao.getAll();
    }

    public int insert(NhanVienDTO nv) {
        int id = dao.insert(nv);
        if (id != -1) {
            nv.setMaNV(id);
            dsNhanVien.add(nv);
        }
        return id;
    }

    public boolean update(NhanVienDTO nv) {
        boolean success = dao.update(nv);
        if (success) {
            int index = getIndexById(nv.getMaNV());
            if (index != -1) dsNhanVien.set(index, nv);
        }
        return success;
    }

    public boolean delete(int maNV) {
        boolean success = dao.delete(maNV);
        if (success) {
            int index = getIndexById(maNV);
            if (index != -1) dsNhanVien.remove(index);
        }
        return success;
    }

    public ArrayList<NhanVienDTO> getList() {
        return dsNhanVien;
    }
    public NhanVienDTO getById(int id) {
        NhanVienDTO nv = dsNhanVien.stream().filter(kh -> kh.getMaNV() == id).findFirst().orElse(null);
        if (nv == null)
            return dao.getNhanVienByMa(id);
        return nv;
    }
    private int getIndexById(int maNV) {
        for (int i = 0; i < dsNhanVien.size(); i++) {
            if (dsNhanVien.get(i).getMaNV() == maNV) return i;
        }
        return -1;
    }
     public ArrayList<NhanVienDTO> timTheoMa(String ma) {
            ArrayList<NhanVienDTO> result = new ArrayList<>();
            for (NhanVienDTO nv : dsNhanVien) {
                if (String.valueOf(nv.getMaNV()).contains(ma)) {
                    result.add(nv);
                }
            }
            return result;
        }

    public ArrayList<NhanVienDTO> timTheoTen(String ten) {
        ArrayList<NhanVienDTO> result = new ArrayList<>();
        for (NhanVienDTO nv : dsNhanVien) {
            if (nv.getHoTen().toLowerCase().contains(ten.toLowerCase())) {
                result.add(nv);
            }
        }
        return result;
    }

    public ArrayList<NhanVienDTO> timTheoChucVu(String chucVu) {
        ArrayList<NhanVienDTO> result = new ArrayList<>();
        for (NhanVienDTO nv : dsNhanVien) {
            if (nv.getChucVu().toLowerCase().contains(chucVu.toLowerCase())) {
                result.add(nv);
            }
        }
        return result;
    }
    public NhanVienDTO login(String username, String password) {
        for (NhanVienDTO nv : dsNhanVien) {
            if (nv.getUsername().equals(username) && nv.getPassword().equals(password)) {
                return nv;
            }
        }
        return null;
    }
    public String exportExcel() {
        ArrayList<Object[]> data = new ArrayList<>();

        // Tạo headers
        Object[] headers = new Object[]{
            "Mã NV", "Username", "Họ", "Tên", "Ngày sinh", 
            "Giới tính", "SĐT", "Email", "CC/HC", "Ngày vào làm", "Chức vụ"
        };
        data.add(headers);

        // Thêm từng dòng nhân viên
        for (NhanVienDTO nv : dsNhanVien) {
            data.add(nv.toExcelRow()); // toExcelRow() là phương thức bạn cần có trong NhanVienDTO
        }

        // Tạo ExcelWriter và xử lý cell
        ExcelWriter excelWriter = new ExcelWriter((cell, value, rowIndex, columnIndex) -> {
            if (rowIndex == 0) {
                // Header
                cell.setCellStyle(CellUtils.getBoldStyle(cell.getSheet().getWorkbook()));
                cell.setCellValue((String) value);
            } else {
                switch (columnIndex) {
                    case 0 -> cell.setCellValue((Integer) value); // Mã NV
                    case 1, 2, 3, 5, 6, 7, 8, 10 -> cell.setCellValue((String) value); // text
                    case 4, 9 -> cell.setCellValue(value.toString()); // ngày -> chuyển thành string
                }
            }
        });

        return excelWriter.writeWithDialog("DanhSachNhanVien.xlsx", data);
    }
}