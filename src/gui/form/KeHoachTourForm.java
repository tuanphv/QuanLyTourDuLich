package gui.form;

import bus.BuoiAnBUS;
import bus.ChiTietKeHoachTourBUS;
import bus.DiaDanhBUS;
import bus.DiaDiemThamQuanBUS;
import bus.KeHoachTourBUS;
import bus.KhachSanBUS;
import bus.KhachSanNghiNgoiBUS;
import bus.NhaHangBUS;
import bus.PhuongTienBUS;
import dto.BuoiAnDTO;
import dto.ChiTietKeHoachTourDTO;
import dto.DiaDiemThamQuanDTO;
import dto.KeHoachTourDTO;
import dto.KhachSanNghiNgoiDTO;
import gui.components.MyButton;
import gui.components.MyScrollBarUI;
import gui.dialog.KeHoachTour;
import gui.dialog.KeHoachTourDialog;
import interfaces.SearchHandler;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class KeHoachTourForm extends javax.swing.JPanel {
    KeHoachTourBUS keHoachTourBUS = new KeHoachTourBUS();
    ChiTietKeHoachTourBUS chiTietKeHoachTourBUS = new ChiTietKeHoachTourBUS();
    DiaDanhBUS diaDanhBUS = new DiaDanhBUS();
    PhuongTienBUS phuongTienBUS = new PhuongTienBUS();
    NhaHangBUS nhaHangBUS = new NhaHangBUS();
    KhachSanBUS khachSanBUS = new KhachSanBUS();
    DiaDiemThamQuanBUS diaDiemThamQuanBUS = new DiaDiemThamQuanBUS();
    BuoiAnBUS buoiAnBUS = new BuoiAnBUS();
    KhachSanNghiNgoiBUS khachSanNghiNgoiBUS = new KhachSanNghiNgoiBUS();
    KeHoachTour keHoachTourDialog = new KeHoachTour(); // Tạo để sử dụng lại hàm

    public KeHoachTourForm() {
        initComponents();
        
        spTable.getVerticalScrollBar().setUI(new MyScrollBarUI());
        spTable.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
        spTable.getViewport().setBackground(Color.white);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        DefaultTableModel model;
        model = new DefaultTableModel(KeHoachTourDTO.KH_TOUR_COLUMN_NAMES, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };
        table.setModel(model);
        if (!java.beans.Beans.isDesignTime()) {
            // Chỉ loadData khi KHÔNG ở design time
            loadDataToTable(new KeHoachTourBUS().getDSKHTour());
            addToolBarAction();
        } else {
            System.out.println("DiaDanhForm đang chạy ở design time mode");
        }
        
        myToolBar1.setSearchType(new String[]{"Mã tour", "Tên tour", "Số lượng tối đa"});
        myToolBar1.setSearchHandler(new SearchHandler() {
            @Override
            public void onSearch(String type, String text) {
                ArrayList<KeHoachTourDTO> khTours;
                KeHoachTourBUS keHoachTourBUS = new KeHoachTourBUS();
                switch (type) {
                    case "Mã tour" -> khTours = keHoachTourBUS.getKeHoachTourByMaTour(text);
                    case "Tên tour" -> khTours = keHoachTourBUS.getKeHoachTourByNameTour(text);
                    case "Số lượng tối đa" -> khTours = keHoachTourBUS.getKeHoachTourBySLToiDa(text);
                    default -> throw new AssertionError();
                }
                loadDataToTable(khTours);
            }
        });

        panelLichTrinh.setLayout(new BoxLayout(panelLichTrinh, BoxLayout.Y_AXIS));
        panelAnUong.setLayout(new BoxLayout(panelAnUong, BoxLayout.Y_AXIS));

        lbLichTrinh.setVisible(false);
        lbAnUong.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new gui.components.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new gui.components.Table();
        jLabel1 = new javax.swing.JLabel();
        myToolBar1 = new gui.components.MyToolBar();
        panelBorder3 = new gui.components.PanelBorder();
        jLabel9 = new javax.swing.JLabel();
        scrollChiTietKeHoachTour = new javax.swing.JScrollPane();
        panelChiTietKeHoachTour = new gui.components.PanelBorder();
        panelLichTrinh = new gui.components.PanelBorder();
        panelAnUong = new gui.components.PanelBorder();
        lbAnUong = new javax.swing.JLabel();
        lbLichTrinh = new javax.swing.JLabel();

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        spTable.setViewportView(table);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Quản lý Kế hoạch Tour");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Chi tiết Kế hoạch Tour");

        scrollChiTietKeHoachTour.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelLichTrinhLayout = new javax.swing.GroupLayout(panelLichTrinh);
        panelLichTrinh.setLayout(panelLichTrinhLayout);
        panelLichTrinhLayout.setHorizontalGroup(
            panelLichTrinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLichTrinhLayout.setVerticalGroup(
            panelLichTrinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelAnUongLayout = new javax.swing.GroupLayout(panelAnUong);
        panelAnUong.setLayout(panelAnUongLayout);
        panelAnUongLayout.setHorizontalGroup(
            panelAnUongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );
        panelAnUongLayout.setVerticalGroup(
            panelAnUongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        lbAnUong.setBackground(new java.awt.Color(255, 255, 255));
        lbAnUong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbAnUong.setForeground(new java.awt.Color(102, 102, 102));
        lbAnUong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbAnUong.setText("Ăn uống");

        lbLichTrinh.setBackground(new java.awt.Color(255, 255, 255));
        lbLichTrinh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbLichTrinh.setForeground(new java.awt.Color(102, 102, 102));
        lbLichTrinh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbLichTrinh.setText("Lịch trình");

        javax.swing.GroupLayout panelChiTietKeHoachTourLayout = new javax.swing.GroupLayout(panelChiTietKeHoachTour);
        panelChiTietKeHoachTour.setLayout(panelChiTietKeHoachTourLayout);
        panelChiTietKeHoachTourLayout.setHorizontalGroup(
            panelChiTietKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChiTietKeHoachTourLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelChiTietKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAnUong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelLichTrinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelChiTietKeHoachTourLayout.createSequentialGroup()
                        .addGroup(panelChiTietKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLichTrinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelAnUong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        panelChiTietKeHoachTourLayout.setVerticalGroup(
            panelChiTietKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChiTietKeHoachTourLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lbLichTrinh, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLichTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbAnUong, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAnUong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        scrollChiTietKeHoachTour.setViewportView(panelChiTietKeHoachTour);

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(375, 375, 375))
                    .addComponent(scrollChiTietKeHoachTour))
                .addGap(20, 20, 20))
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollChiTietKeHoachTour, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(myToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(myToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public JPanel createLichTrinhPanel(int dayNumber) {
        JPanel dayPanel = keHoachTourDialog.createTitledPanel("Ngày " + dayNumber);
        dayPanel.setBackground(new Color(255, 255, 255));

        // Tiêu đề ngày
        JPanel titlePanel = new JPanel(new BorderLayout());
        JTextField titleField = new JTextField();
        titleField.setBorder(keHoachTourDialog.createTitleBorder("Tiêu đề"));
        titlePanel.add(titleField, BorderLayout.CENTER);
        dayPanel.add(titlePanel);

        // Panel chứa các địa điểm
        JPanel locationPanel = keHoachTourDialog.createTitledPanel("Địa điểm tham quan");

        // Panel chứa khách sạn nghỉ ngơi
        JPanel hotelPanel = keHoachTourDialog.createTitledPanel("Khách sạn nghỉ ngơi");

        dayPanel.add(locationPanel);
        dayPanel.add(hotelPanel);

        // Ẩn tiêu đề nếu không có nội dung
        if (locationPanel.getComponentCount() == 0) {
            locationPanel.setBorder(null);
        }
        if (hotelPanel.getComponentCount() == 0) {
            hotelPanel.setBorder(null);
        }

        return dayPanel;
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int rowSelected = table.getSelectedRow();
        int maKeHoachTour = (int) table.getModel().getValueAt(rowSelected, 0);
        KeHoachTourDTO keHoachTour = keHoachTourBUS.getKeHoachTourById(maKeHoachTour);

        panelLichTrinh.removeAll();
        panelAnUong.removeAll();

        // lấy thông tin chi tiết kế hoạch tour
        ArrayList<ChiTietKeHoachTourDTO> chiTietKeHoachTour = chiTietKeHoachTourBUS.getChiTietKeHoachTourByMaKeHoachTour(maKeHoachTour);
        int soNgayTour = chiTietKeHoachTour.size();

        for (int i = 0; i < soNgayTour; i++) {
            ChiTietKeHoachTourDTO chiTietKeHoach = chiTietKeHoachTour.get(i);
            int maChiTietKeHoach = chiTietKeHoach.getMaChiTietKeHoachTour();

            JPanel lichTrinhPanel = createLichTrinhPanel(i + 1);
            JPanel anUongPanel = keHoachTourDialog.createAnUongPanel(i + 1);

            // Lấy thông tin lịch trình và ăn uống từ cơ sở dữ liệu
            ArrayList<DiaDiemThamQuanDTO> listDiaDiemThamQuan = diaDiemThamQuanBUS.getDiaDiemThamQuanByMaChiTietKeHoachTour(maChiTietKeHoach);
            ArrayList<KhachSanNghiNgoiDTO> listKhachSanNghiNgoi = khachSanNghiNgoiBUS.getKhachSanNghiNgoiByMaChiTietKeHoachTour(maChiTietKeHoach);
            ArrayList<BuoiAnDTO> listBuoiAn = buoiAnBUS.getBuoiAnByMaChiTietKeHoachTour(maChiTietKeHoach);

            // Thêm tiêu đề
            JTextField titleField = (JTextField) ((JPanel) lichTrinhPanel.getComponent(0)).getComponent(0);
            titleField.setText(chiTietKeHoach.getMoTa());

            // Thêm địa điểm tham quan
            JPanel diaDiemPanel = (JPanel) lichTrinhPanel.getComponent(1);
            keHoachTourDialog.loadDataFormDiaDiem(diaDiemPanel, listDiaDiemThamQuan);

            // Thêm khách sạn nghỉ ngơi
            JPanel khachSanPanel = (JPanel) lichTrinhPanel.getComponent(2);
            keHoachTourDialog.loadDataFormKhachSan(khachSanPanel, listKhachSanNghiNgoi);

            // Thêm ăn uống
            keHoachTourDialog.loadDataFormAnUong(anUongPanel, listBuoiAn);

            // // Thêm panel lịch trình và ăn uống vào panel chính
            panelLichTrinh.add(lichTrinhPanel);
            panelAnUong.add(anUongPanel);
        }

        if (panelLichTrinh.getComponentCount() != 0) lbLichTrinh.setVisible(true);
        else lbLichTrinh.setVisible(false);
        if (panelAnUong.getComponentCount() != 0) lbAnUong.setVisible(true);
        else lbAnUong.setVisible(false);
        
        // Cập nhật lại giao diện
        panelLichTrinh.revalidate();
        panelLichTrinh.repaint();
        panelAnUong.revalidate();
        panelAnUong.repaint();

    }//GEN-LAST:event_tableMouseClicked

    private void btnThemActionPerformed(ActionEvent evt) {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        // KeHoachTourDialog dialog = new KeHoachTourDialog(parentFrame);
        KeHoachTour dialog = new KeHoachTour(parentFrame, this, KeHoachTour.Action.INSERT);
        dialog.setVisible(true);
        if (dialog.isSave()) {
            dialog.saveKeHoachTour();
            JOptionPane.showMessageDialog(this, "Đã thêm kế hoạch tour!");

            // KeHoachTourDTO input = dialog.getInputData();
            // if (addTour(input)) {
            //     JOptionPane.showMessageDialog(this, "Đã thêm kế hoạch tour!");
            // } else {
            //     JOptionPane.showMessageDialog(this, "Thêm kế hoạch tour không thành công!");
            // }
        }
    }

    private void btnSuaActionPerformed(ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int index = table.getSelectedRow();
        if (index > -1) {
            KeHoachTourDTO khTour = new KeHoachTourBUS().getKeHoachTourById((int) model.getValueAt(index, 0));
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            // KeHoachTourDialog dialog = new KeHoachTourDialog(parentFrame);
            KeHoachTour dialog = new KeHoachTour(parentFrame, this, KeHoachTour.Action.UPDATE);
            dialog.setTitle("Cập nhật kế hoạch tour");
            dialog.loadKeHoachTour(khTour);
            // dialog.loadData(khTour);
            dialog.setLocationRelativeTo(parentFrame);
            dialog.setVisible(true);
            // if (dialog.isSave()) {
            //     KeHoachTourDTO input = dialog.getInputData();
            //     input.setMaKHTour(khTour.getMaKHTour());
            //     if (updateTour(input)) {
            //         JOptionPane.showMessageDialog(this, "Đã cập nhật kế hoạch tour!");
            //     } else {
            //         JOptionPane.showMessageDialog(this, "Cập nhật thông tin không thành công!");
            //     }
            // }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn kế hoạch tour cần cập nhật!");
        }
    }

    private void btnXoaActionPerformed(ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        KeHoachTourBUS bus = new KeHoachTourBUS();
        int rowSelected = table.getSelectedRow();
        if (rowSelected >= 0) {
            int result = JOptionPane.showConfirmDialog(
                    this,
                    "Bạn có chắc chắn muốn xóa kế hoạch tour " + model.getValueAt(rowSelected, 0) + "?",
                    "Xác nhận",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (result == JOptionPane.OK_OPTION) {
                if (bus.deleteKeHoachTour((int) model.getValueAt(rowSelected, 0))) {
                    model.removeRow(rowSelected);
                    JOptionPane.showMessageDialog(this, "Xóa tour thành công!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tour cần xóa!");
        }
    }

    private void addToolBarAction() {
        myToolBar1.getBtnThem().addActionListener(e -> btnThemActionPerformed(e));
        myToolBar1.getBtnSua().addActionListener(e -> btnSuaActionPerformed(e));
        myToolBar1.getBtnXoa().addActionListener(e -> btnXoaActionPerformed(e));
    }

    public int addTour(KeHoachTourDTO khTour) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        KeHoachTourBUS bus = new KeHoachTourBUS();
        int index = bus.addKeHoachTour(khTour);
        if (index != -1) {
            khTour.setMaKHTour(index);
            model.addRow(khTour.toObjectArray());
            return index;
        }
        return -1;
    }

    public boolean updateTour(KeHoachTourDTO khTour) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        KeHoachTourBUS bus = new KeHoachTourBUS();
        int index = bus.updateKeHoachTour(khTour);
        if (index != -1) {
            Object[] a = khTour.toObjectArray();
            for (int i = 0; i < a.length; i++) {
                model.setValueAt(a[i], index, i);
            }
            return true;
        }
        return false;
    }

    private void loadDataToTable(ArrayList<KeHoachTourDTO> khTours) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        // khTours.forEach((var e) -> {
        //     model.addRow(e.toObjectArray());
        // });
        for (KeHoachTourDTO khTour : khTours) {
            model.addRow(khTour.toObjectArray());
            // System.out.println(khTour);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbAnUong;
    private javax.swing.JLabel lbLichTrinh;
    private gui.components.MyToolBar myToolBar1;
    private gui.components.PanelBorder panelAnUong;
    private gui.components.PanelBorder panelBorder1;
    private gui.components.PanelBorder panelBorder3;
    private gui.components.PanelBorder panelChiTietKeHoachTour;
    private gui.components.PanelBorder panelLichTrinh;
    private javax.swing.JScrollPane scrollChiTietKeHoachTour;
    private javax.swing.JScrollPane spTable;
    private gui.components.Table table;
    // End of variables declaration//GEN-END:variables
}

