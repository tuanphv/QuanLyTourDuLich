package utils;

import bus.VeBUS;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import dto.VeDTO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VePDFExporter {

    private static final String FONT_PATH = "src/resources/fonts/inter.ttf"; // hoặc fonts hỗ trợ Unicode khác

    public static String writePdfWithDialog(String defaultFileName, VeDTO ve) {
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
        if (xuatVe(filePath, ve)) {
            return filePath;
        }

        return null;
    }
    
    public static boolean xuatVe(String filePath, VeDTO ve) {
        try {
            Document document = new Document(PageSize.A5, 36, 36, 36, 36); // Khổ A5
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            BaseFont baseFont = BaseFont.createFont(FONT_PATH, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font titleFont = new Font(baseFont, 18, Font.BOLD, BaseColor.BLUE);
            Font normalFont = new Font(baseFont, 12, Font.NORMAL);

            // Tiêu đề
            Paragraph title = new Paragraph("🎫 VÉ DU LỊCH", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20f);
            document.add(title);

            // Bảng thông tin vé
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
            table.setWidths(new int[]{1, 2});

            addRow(table, "Mã vé", String.valueOf(ve.getMaVe()), normalFont);
            addRow(table, "Mã đặt tour", String.valueOf(ve.getMaDat()), normalFont);
            addRow(table, "Số thứ tự", String.valueOf(ve.getSoThuTu()), normalFont);
            addRow(table, "Mã kế hoạch tour", String.valueOf(ve.getMaKHTour()), normalFont);
            addRow(table, "Họ tên", ve.getHoTen(), normalFont);
            addRow(table, "Ngày khởi hành", ve.getNgayKhoiHanh().toString(), normalFont);
            addRow(table, "Ngày cấp", ve.getNgayCap().toString(), normalFont);
            addRow(table, "Giá vé", TextUtils.formatCurrency(ve.getGiaVe()), normalFont);
            addRow(table, "Trạng thái", ve.getTrangThai().getMoTa(), normalFont);

            document.add(table);

            document.close();
            return true;

        } catch (DocumentException | IOException e) {
            System.out.println("❌ Lỗi khi tạo PDF: " + e.getMessage());
            return false;
        }
    }

    private static void addRow(PdfPTable table, String label, String value, Font font) {
        PdfPCell cell1 = new PdfPCell(new Phrase(label, font));
        PdfPCell cell2 = new PdfPCell(new Phrase(value, font));
        cell1.setBorder(Rectangle.NO_BORDER);
        cell2.setBorder(Rectangle.NO_BORDER);
        cell1.setPadding(5f);
        cell2.setPadding(5f);
        table.addCell(cell1);
        table.addCell(cell2);
    }
    
    public static void main(String[] args) {
        VeDTO ve = new VeBUS().getVeById(1);
        String path = VePDFExporter.writePdfWithDialog("Ve", ve);
        ExportHoaDonPDF.openPdf(path);
    }
}
