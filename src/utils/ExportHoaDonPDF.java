package utils;

import bus.ChiTietHanhKhachBUS;
import bus.DatTourBUS;
import bus.HoaDonBUS;
import bus.KeHoachTourBUS;
import bus.KhachHangBUS;
import bus.NhanVienBUS;
import bus.TourBUS;
import bus.VeBUS;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.BaseFont;
import dto.ChiTietHanhKhachDTO;
import dto.DatTourDTO;
import dto.HoaDonDTO;
import dto.KeHoachTourDTO;
import dto.VeDTO;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import dto.KhachHangDTO;
import dto.NhanVienDTO;
import dto.TourDTO;

public class ExportHoaDonPDF {

    public String writePdfWithDialog(String defaultFileName, HoaDonDTO data) {
        // 1. Hộp thoại chọn vị trí lưu
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu file PDF");
        fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files (*.pdf)", "pdf"));
        fileChooser.setSelectedFile(new File(defaultFileName));

        if (fileChooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION) {
            return null;
        }

        // 2. Lấy đường dẫn
        File fileToSave = fileChooser.getSelectedFile();
        String filePath = fileToSave.getAbsolutePath();
        if (!filePath.toLowerCase().endsWith(".pdf")) {
            filePath += ".pdf";
        }

        // 3. Xác nhận ghi đè nếu file tồn tại
        File file = new File(filePath);
        if (file.exists()) {
            int result = JOptionPane.showConfirmDialog(null,
                    "File đã tồn tại. Bạn có muốn ghi đè không?",
                    "Xác nhận ghi đè", JOptionPane.YES_NO_OPTION);
            if (result != JOptionPane.YES_OPTION) {
                return null;
            }
        }

        // 4. Ghi file PDF
        if (createInvoice(filePath, data)) {
            return filePath;
        }

        return null;
    }

    public boolean createInvoice(String filePath, HoaDonDTO hoaDon) {
        try {
            // get hoaDon từ các
            DatTourDTO datTour = new DatTourBUS().getDatTourById(hoaDon.getMaDat());
            ArrayList<ChiTietHanhKhachDTO> dsChiTietHanhKhach = new ChiTietHanhKhachBUS().getChiTietHanhKhachByMaDat(datTour.getMaDat());
            KhachHangDTO khachHang = new KhachHangBUS().getById(datTour.getMaKH());
            KeHoachTourDTO khTour = new KeHoachTourBUS().getKeHoachTourByID(datTour.getMaKHTour());
            TourDTO tour = new TourBUS().getTourById(khTour.getMaTour());

            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Fonts
            BaseFont baseFont = BaseFont.createFont("src/resources/fonts/inter.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

            Font titleFont = new Font(baseFont, 18, Font.BOLD);
            Font boldFont = new Font(baseFont, 12, Font.BOLD);
            Font normalFont = new Font(baseFont, 12);

            // 1. Invoice Info
            document.add(new Paragraph("HÓA ĐƠN DU LỊCH", titleFont));

            document.add(new Paragraph(" "));
            document.add(new Paragraph("Mã hóa đơn: " + hoaDon.getMaHoaDon(), boldFont));
            document.add(new Paragraph("Ngày lập: " + hoaDon.getNgayLap(), normalFont));
            NhanVienDTO nhanVien = new NhanVienBUS().getById(hoaDon.getMaNV());
            document.add(new Paragraph("Nhân viên lập: " + nhanVien.getHoTen() + " - Mã NV: " + nhanVien.getMaNV(), normalFont));
            document.add(new Paragraph("Hình thức thanh toán: " + hoaDon.getHinhThucThanhToan(), normalFont));
            document.add(new Paragraph("Trạng thái: " + hoaDon.getTrangThai(), normalFont));
            document.add(new Paragraph(" "));

            // 2. Customer Info
            document.add(new Paragraph("Khách hàng: " + khachHang.getTen(), boldFont));
            document.add(new Paragraph("Email: " + khachHang.getEmail(), normalFont));
            document.add(new Paragraph("SĐT: " + khachHang.getSoDT(), normalFont));
            document.add(new Paragraph("Mã đặt tour: " + datTour.getMaDat(), normalFont));
            document.add(new Paragraph(" "));

            // 4. Tour Info
            document.add(new Paragraph("Tên tour: " + tour.getTenTour(), boldFont));
            document.add(new Paragraph("Mã tour: " + tour.getMaTour(), normalFont));
            document.add(new Paragraph("Ngày khởi hành: " + khTour.getThoiGianBD(), normalFont));
            document.add(new Paragraph("Giá gốc / người lớn: " + TextUtils.formatCurrency(khTour.getGiaVe()) + "₫", normalFont));
            document.add(new Paragraph(" "));

            // 5. Passenger Table
            document.add(new Paragraph("Số lượng người: " + datTour.getSoLuong(), boldFont));

            document.add(new Paragraph(" "));
            PdfPTable table = new PdfPTable(5);
            table.setWidths(new float[]{1, 3, 3, 3, 3});
            table.setWidthPercentage(100);

            String[] headers = new String[]{"STT", "Họ tên", "Ngày sinh", "Loại", "Giá vé"};
            for (String header : headers) {
                table.addCell(formatCell(header, boldFont));
            }

            int stt = 1;
            for (ChiTietHanhKhachDTO cTiet : dsChiTietHanhKhach) {
                VeDTO ve = new VeBUS().getVeByMaDatVaSTT(datTour.getMaDat(), stt);
                table.addCell(formatCell(String.valueOf(stt++), normalFont));
                table.addCell(formatCell(cTiet.getHoTen(), normalFont));
                table.addCell(formatCell(DateUtils.toString(cTiet.getNgaySinh()), normalFont));
                table.addCell(formatCell(cTiet.getLoaiHanhKhach().getText(), normalFont));
                table.addCell(formatCell(TextUtils.formatCurrency(ve.getGiaVe()) + "₫", normalFont));
            }
            document.add(table);
            document.add(new Paragraph(" "));

            // 6. Tổng kết
            document.add(new Paragraph("Tổng tiền: " + TextUtils.formatCurrency(hoaDon.getTongTien()) + "₫", boldFont));
            document.add(new Paragraph(" "));

            document.close();
            System.out.println("✅ File PDF đã được tạo: " + filePath);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Lỗi khi tạo PDF: " + e.getMessage());
            return false;
        }
    }

    private PdfPCell formatCell(String textString, Font font) {
        return formatCell(textString, font, 4f, 6f, 6f, 6f, 0, Element.ALIGN_MIDDLE);
    }

    private PdfPCell formatCell(String textString, Font font, float paddingTop, float paddingBottom, float paddingLeft, float paddingRight, int horizontalAlignment, int verticalAlignment) {
        PdfPCell cell = new PdfPCell(new Phrase(textString, font));
        cell.setPadding(paddingTop);
        cell.setPaddingBottom(paddingBottom);
        cell.setPaddingLeft(paddingLeft);
        cell.setPaddingRight(paddingRight);
        cell.setHorizontalAlignment(horizontalAlignment);
        cell.setVerticalAlignment(verticalAlignment);
        return cell;
    }

    // ✅ Mở file PDF sau khi tạo
    public static void openPdf(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists() && Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
                System.out.println("📄 Đã mở file: " + filePath);
            } else {
                System.out.println("⚠️ Không thể mở file PDF.");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Lỗi khi mở file PDF: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = new ExportHoaDonPDF().writePdfWithDialog("HoaDon1", new HoaDonBUS().getHoaDonById(1));
        ExportHoaDonPDF.openPdf(filePath);
    }
}
