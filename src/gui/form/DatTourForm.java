package gui.form;

import bus.ChiTietHanhKhachBUS;
import dto.DatTourDTO;
import bus.DatTourBUS;
import bus.KeHoachTourBUS;
import bus.VeBUS;
import dto.ChiTietHanhKhachDTO;
import dto.KeHoachTourDTO;
import dto.VeDTO;
import enums.TrangThaiDatTour;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import gui.components.MyScrollBarUI;
import gui.dialog.AddDatTourDialog;
import gui.dialog.TrangThaiDialog;
import interfaces.SearchHandler;
import java.time.LocalDate;

public class DatTourForm extends javax.swing.JPanel {

    public DatTourForm() {
        initComponents();

        spTable.getVerticalScrollBar().setUI(new MyScrollBarUI());
        spTable.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
        spTable.getViewport().setBackground(Color.white);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        DefaultTableModel model = new DefaultTableModel(DatTourDTO.COLUMN_NAMES, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setModel(model);

        spTableCTietHKhach.getVerticalScrollBar().setUI(new MyScrollBarUI());
        spTableCTietHKhach.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
        spTableCTietHKhach.getViewport().setBackground(Color.white);
        spTableCTietHKhach.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        DefaultTableModel modelCTiet = new DefaultTableModel(ChiTietHanhKhachDTO.COLUMN_NAMES, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableCTietHKhach.setModel(modelCTiet);
        if (!java.beans.Beans.isDesignTime()) {
            // Chỉ loadData khi KHÔNG ở design time
            loadDataToTable(new DatTourBUS().getAllDatTour());
            addToolBarAction();
        } else {
            System.out.println("DatTourForm đang chạy ở design time mode");
        }
        myToolBar1.setSearchType(new String[]{"Mã kế hoạch tour", "Mã khách hàng"});
        myToolBar1.setSearchHandler(new SearchHandler() {
            @Override
            public void onSearch(String type, String text) {
                DatTourBUS bus = new DatTourBUS();
                int ma = Integer.parseInt(text.trim());
                switch (type) {
                    case "Mã kế hoạch tour" ->
                        loadDataToTable(bus.getDatTourByKeHoachTour(ma));
                    case "Mã khách hàng" ->
                        loadDataToTable(bus.getDatTourByKhachHang(ma));
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new gui.components.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new gui.components.Table();
        jLabel1 = new javax.swing.JLabel();
        myToolBar1 = new gui.components.MyToolBar();
        panelBorder2 = new gui.components.PanelBorder();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        spTableCTietHKhach = new javax.swing.JScrollPane();
        tableCTietHKhach = new gui.components.Table();

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
        jLabel1.setText("Quản lý đặt tour");

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/filter.png"))); // NOI18N
        jLabel2.setText("Chi tiết hành khách");

        spTableCTietHKhach.setBackground(new java.awt.Color(255, 255, 255));
        spTableCTietHKhach.setBorder(null);

        tableCTietHKhach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        spTableCTietHKhach.setViewportView(tableCTietHKhach);

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                    .addComponent(spTableCTietHKhach)
                    .addComponent(jLabel2))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTableCTietHKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(20, 20, 20)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(myToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        showChiTiet();
    }//GEN-LAST:event_tableMouseClicked

    private void btnThemActionPerformed(ActionEvent evt) {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        AddDatTourDialog dialog = new AddDatTourDialog(parentFrame);
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setVisible(true);
        if (dialog.isSave()) {
            DatTourDTO inputData = dialog.getInputData();
            ArrayList<ChiTietHanhKhachDTO> listChiTietHanhKhachDTOs = dialog.getChiTietHanhKhachList();
            if (add(inputData, listChiTietHanhKhachDTOs)) {
                JOptionPane.showMessageDialog(this, "Đã thêm đặt tour và chi tiết hành khách!");
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin không thành công!");
            }
        }
    }

    private void btnSuaActionPerformed(ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int index = table.getSelectedRow();
        if (index > -1) {
            DatTourBUS bus = new DatTourBUS();
            DatTourDTO dto = bus.getDatTourById((int) model.getValueAt(index, 0));
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            TrangThaiDialog dialog = new TrangThaiDialog(parentFrame);
            dialog.loadData(new Object[]{TrangThaiDatTour.CHO_THANH_TOAN, TrangThaiDatTour.DA_THANH_TOAN}, dto.getTrangThai());
            dialog.setVisible(true);
            if (dialog.isSave()) {
                TrangThaiDatTour trangThaiMoi = (TrangThaiDatTour) dialog.getInputData();
                if (bus.updateTrangThaiDatTour(dto, trangThaiMoi)) {
                    model.setValueAt(trangThaiMoi, index, model.getColumnCount() - 1);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đặt tour cần cập nhật!");
        }
    }

    private void btnXoaActionPerformed(ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        DatTourBUS bus = new DatTourBUS();
        int i = table.getSelectedRow();
        if (i >= 0) {
            int result = JOptionPane.showConfirmDialog(
                    this,
                    "Bạn có chắc chắn muốn xóa?",
                    "Xác nhận",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                if (bus.deleteDatTour((int) model.getValueAt(i, 0))) {
                    model.removeRow(i);
                    JOptionPane.showMessageDialog(this, "Xóa đặt tour thành công!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đặt tour cần xóa!");
        }
    }

    private void addToolBarAction() {
        myToolBar1.getBtnThem().addActionListener(e -> btnThemActionPerformed(e));
        myToolBar1.getBtnSua().addActionListener(e -> btnSuaActionPerformed(e));
        myToolBar1.getBtnXoa().addActionListener(e -> btnXoaActionPerformed(e));
        myToolBar1.getBtnRefresh().addActionListener(e -> loadDataToTable(new DatTourBUS().getAllDatTour()));
    }

    public boolean add(DatTourDTO dto, ArrayList<ChiTietHanhKhachDTO> listCTietHKhach) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int index = new DatTourBUS().addDatTour(dto);
        if (index != -1) {
            // thêm dattour
            dto.setMaDat(index);
            model.addRow(dto.toArray());
            
            // thêm số lượng vé đã đặt
            KeHoachTourBUS khBUS = new KeHoachTourBUS();
            KeHoachTourDTO khTour = khBUS.getKeHoachTourById(dto.getMaKHTour());
            khTour.setSlDaDat(khTour.getSlDaDat() + dto.getSoLuong());
            if (khBUS.updateKeHoachTour(khTour) != -1) System.out.println("Cập nhật số lượng thành công");;
            // thêm chi tiết hành khách
            ChiTietHanhKhachBUS bus = new ChiTietHanhKhachBUS();
            for (int i = 0; i < listCTietHKhach.size(); i++) {
                ChiTietHanhKhachDTO e = listCTietHKhach.get(i);
                e.setMaDat(index);
                e.setSoThuTu(i+1);
                if (bus.addCTietHKhach(e)) {
                    VeDTO ve = new VeDTO();
                    ve.setMaDat(index);
                    ve.setSoThuTu(i+1);
                    ve.setMaKHTour(dto.getMaKHTour());
                    ve.setHoTen(e.getHoTen());
                    ve.setNgayKhoiHanh(khTour.getThoiGianBD());
                    ve.setNgayCap(LocalDate.now());
                    ve.setGiaVe(e.getLoaiHanhKhach().getHeSoGia() * khTour.getGiaVe());
                    new VeBUS().addVe(ve);
                }
            }
            return true;
        }
        return false;
    }

    public boolean update(DatTourDTO datTour) {
        DatTourBUS bus = new DatTourBUS();
        int index = bus.updateDatTour(datTour);
        System.out.println("Update DatTour: " + index);
        return index != -1;
    }

    private void loadDataToTable(ArrayList<DatTourDTO> datTours) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        datTours.forEach((var e) -> model.addRow(e.toArray()));
    }

    private void showChiTiet() {
        DefaultTableModel modelCTiet = (DefaultTableModel) tableCTietHKhach.getModel();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int index = table.getSelectedRow();
        if (index > -1) {
            ArrayList<ChiTietHanhKhachDTO> list = new ChiTietHanhKhachBUS().getChiTietHanhKhachByMaDat((int) model.getValueAt(index, 0));
            modelCTiet.setRowCount(0);
            for (ChiTietHanhKhachDTO x : list) {
                modelCTiet.addRow(x.toTableRow());
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private gui.components.MyToolBar myToolBar1;
    private gui.components.PanelBorder panelBorder1;
    private gui.components.PanelBorder panelBorder2;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JScrollPane spTableCTietHKhach;
    private gui.components.Table table;
    private gui.components.Table tableCTietHKhach;
    // End of variables declaration//GEN-END:variables
}
