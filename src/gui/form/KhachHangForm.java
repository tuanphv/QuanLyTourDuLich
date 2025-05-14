package gui.form;

import bus.KhachHangBUS;
import dto.KhachHangDTO;
import gui.components.MyScrollBarUI;
import gui.dialog.InputKhachHang;
import interfaces.SearchHandler;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class KhachHangForm extends javax.swing.JPanel {
    private int rowSelected;
    private DefaultTableModel tableModel;
    private KhachHangBUS khachHangBUS;
    private ArrayList<KhachHangDTO> danhSachKhachHang;

    public KhachHangForm() {
        initComponents();
        tableModel = new DefaultTableModel(KhachHangDTO.KHACH_HANG_COLUMN_NAMES, 0);
        

        spTable.getVerticalScrollBar().setUI(new MyScrollBarUI());
        spTable.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
        spTable.getViewport().setBackground(Color.white);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        table.setModel(tableModel);
        if (!java.beans.Beans.isDesignTime()) {
            // Chỉ loadData khi KHÔNG ở design time
            khachHangBUS = new KhachHangBUS();
            danhSachKhachHang = khachHangBUS.getList();
            loadDataToTable(danhSachKhachHang);
            addToolBarAction();
        } else {
            System.out.println("KhachHangForm đang chạy ở design time mode");
        }
            myToolBar1.setSearchType(new String[]{"Tên khách hàng", "Mã khách hàng", "CCCD khách hàng"});
            myToolBar1.setSearchHandler(new SearchHandler() {
            @Override
            public void onSearch(String type, String text) {
                ArrayList<KhachHangDTO> result = new ArrayList<>();
                switch (type) {
                    case "Mã khách hàng" -> {
                        try {
                            int maKH = Integer.parseInt(text);
                            result = khachHangBUS.timTheoMaKH(maKH);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(KhachHangForm.this, "Mã khách hàng phải là số!");
                        }
                    }
                    case "Tên khách hàng" ->
                        result = khachHangBUS.timTheoTen(text);                   
                    case "CCCD khách hàng" ->
                        result = khachHangBUS.timTheoCC(text);
                    default ->
                        throw new AssertionError();
                }
                loadDataToTable(result);
            }
        });
    }

    private void loadDataToTable(ArrayList<KhachHangDTO> list) {
        tableModel.setRowCount(0);
        for (KhachHangDTO kh : list) {
            tableModel.addRow(kh.toObject());
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        rowSelected = table.getSelectedRow();
        if (rowSelected == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng để xoá.");
            return;
        }
        if (rowSelected >= 0) {
            int result = JOptionPane.showConfirmDialog(
                    this,
                    "Bạn có chắc chắn muốn xóa?",
                    "Xác nhận",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

        int maKH = danhSachKhachHang.get(rowSelected).getMaKH();
        if (khachHangBUS.delete(maKH)) {
            tableModel.removeRow(rowSelected);
            JOptionPane.showMessageDialog(this, "Xóa khách hàng thành công!");
        }
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        rowSelected = table.getSelectedRow();
        if (rowSelected == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng để sửa.");
            return;
        }
        KhachHangDTO kh = danhSachKhachHang.get(rowSelected);
        InputKhachHang dialog = new InputKhachHang((Frame) SwingUtilities.getWindowAncestor(this), InputKhachHang.Mode.UPDATE, this, kh);
        dialog.setVisible(true);
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        InputKhachHang dialog = new InputKhachHang((Frame) SwingUtilities.getWindowAncestor(this), InputKhachHang.Mode.ADD, this);
        dialog.setVisible(true);
    }

    public void addKhachHang(KhachHangDTO kh) {
        int id = khachHangBUS.insert(kh);
        if (id != -1) {
            kh.setMaKH(id);
            danhSachKhachHang = khachHangBUS.getList();
            loadDataToTable(danhSachKhachHang);
        }
    }

    public void updateKhachHang(KhachHangDTO kh) {
        if (khachHangBUS.update(kh)) {
            danhSachKhachHang = khachHangBUS.getList();
            loadDataToTable(danhSachKhachHang);
        }
    }

    private void addToolBarAction() {
        myToolBar1.getBtnThem().addActionListener(e -> btnAddActionPerformed(e));
        myToolBar1.getBtnSua().addActionListener(e -> btnUpdateActionPerformed(e));
        myToolBar1.getBtnXoa().addActionListener(e -> btnDeleteActionPerformed(e));
        myToolBar1.getBtnRefresh().addActionListener(e -> loadDataToTable(new KhachHangBUS().getList()));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new gui.components.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new gui.components.Table();
        jLabel1 = new javax.swing.JLabel();
        myToolBar1 = new gui.components.MyToolBar();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        spTable.setViewportView(table);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Quản lý khách hàng");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(myToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(640, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(myToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private gui.components.MyToolBar myToolBar1;
    private gui.components.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private gui.components.Table table;
    // End of variables declaration//GEN-END:variables
}
