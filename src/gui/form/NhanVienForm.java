package gui.form;

import bus.NhanVienBUS;
import dto.NhanVienDTO;
import gui.components.MyScrollBarUI;
import gui.dialog.InputNhanVien;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class NhanVienForm extends javax.swing.JPanel {
    private int rowSelected;
    private DefaultTableModel tableModel;
    private NhanVienBUS nhanVienBUS;
    private ArrayList<NhanVienDTO> danhSachNhanVien;

    public NhanVienForm() {
        initComponents();
        tableModel = new DefaultTableModel(NhanVienDTO.NHAN_VIEN_COLUMN_NAMES, 0);

        spTable.getVerticalScrollBar().setUI(new MyScrollBarUI());
        spTable.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
        spTable.getViewport().setBackground(Color.white);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        table.setModel(tableModel);
        if (!java.beans.Beans.isDesignTime()) {
            // Chỉ loadData khi KHÔNG ở design time
            nhanVienBUS = new NhanVienBUS();
            danhSachNhanVien = nhanVienBUS.getList();
            loadDataToTable();
            addToolBarAction();
        } else {
            System.out.println("DiaDanhForm đang chạy ở design time mode");
        }
    }

    private void loadDataToTable() {
        tableModel.setRowCount(0);
        for (NhanVienDTO nv : danhSachNhanVien) {
            tableModel.addRow(nv.toObject());
        }
    }


    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        rowSelected = table.getSelectedRow();
        if (rowSelected == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên để xoá.");
            return;
        }
        if (rowSelected >= 0) {
            int result = JOptionPane.showConfirmDialog(
                    this,
                    "Bạn có chắc chắn muốn xóa?",
                    "Xác nhận",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

        int maNV = danhSachNhanVien.get(rowSelected).getMaNV();
        if (nhanVienBUS.delete(maNV)) {
            tableModel.removeRow(rowSelected);
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        }
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        rowSelected = table.getSelectedRow();
        if (rowSelected == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên để sửa.");
            return;
        }
        NhanVienDTO nv = danhSachNhanVien.get(rowSelected);
        InputNhanVien dialog = new InputNhanVien((Frame) SwingUtilities.getWindowAncestor(this), InputNhanVien.Mode.UPDATE, this, nv);
        dialog.setVisible(true);
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        InputNhanVien dialog = new InputNhanVien((Frame) SwingUtilities.getWindowAncestor(this), InputNhanVien.Mode.ADD, this);
        dialog.setVisible(true);
    }

    public void addNhanVien(NhanVienDTO nv) {
        int id = nhanVienBUS.insert(nv);
        if (id != -1) {
            nv.setMaNV(id);
            tableModel.addRow(nv.toObject());
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
        }
    }

    public void updateNhanVien(NhanVienDTO nv) {
        if (nhanVienBUS.update(nv)) {
            tableModel.setValueAt(nv.getHoTen(), rowSelected, 1);
            tableModel.setValueAt(nv.getNgaySinh(), rowSelected, 2);
            tableModel.setValueAt(nv.getGioiTinh(), rowSelected, 3);
            tableModel.setValueAt(nv.getSoDT(), rowSelected, 4);
            tableModel.setValueAt(nv.getEmail(), rowSelected, 5);
            tableModel.setValueAt(nv.getCC_HC(), rowSelected, 6);
            tableModel.setValueAt(nv.getNgayVaoLam(), rowSelected, 7);            
            tableModel.setValueAt(nv.getChucVu(), rowSelected, 8);
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
        }
    }

    private void addToolBarAction() {
        myToolBar1.getBtnThem().addActionListener(e -> btnAddActionPerformed(e));
        myToolBar1.getBtnSua().addActionListener(e -> btnUpdateActionPerformed(e));
        myToolBar1.getBtnXoa().addActionListener(e -> btnDeleteActionPerformed(e));
        myToolBar1.getBtnRefresh().addActionListener(e -> {
            danhSachNhanVien = nhanVienBUS.getList();
            loadDataToTable();
            myToolBar1.setSearchText("");
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new gui.components.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new gui.components.Table();
        jLabel1 = new javax.swing.JLabel();
        myToolBar1 = new gui.components.MyToolBar();

        setPreferredSize(new java.awt.Dimension(1040, 779));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setPreferredSize(new java.awt.Dimension(986, 649));

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        spTable.setViewportView(table);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Quản lý nhân viên");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                    .addComponent(myToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(myToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
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
