package presentation.gui.Form;

import business.model.KhachHangDTO;
import business.service.KhachHangBUS;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import presentation.gui.Components.MyScrollBarUI;
import presentation.gui.InputDialog.InputKhachHang;

public class KhachHangForm extends javax.swing.JPanel {
    private int rowSelected;
    private DefaultTableModel tableModel;
    private KhachHangBUS khachHangBUS;
    private ArrayList<KhachHangDTO> danhSachKhachHang;

    public KhachHangForm() {
        initComponents();
        tableModel = new DefaultTableModel(KhachHangDTO.KHACH_HANG_COLUMN_NAMES, 0);
        khachHangBUS = new KhachHangBUS();
        danhSachKhachHang = khachHangBUS.getList();

        spTable.getVerticalScrollBar().setUI(new MyScrollBarUI());
        spTable.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
        spTable.getViewport().setBackground(Color.white);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        table.setModel(tableModel);
        loadDataToTable();
        addToolBarAction();
    }

    private void loadDataToTable() {
        tableModel.setRowCount(0);
        for (KhachHangDTO kh : danhSachKhachHang) {
            tableModel.addRow(kh.toObject());
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        rowSelected = table.getSelectedRow();
        if (rowSelected == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng để xoá.");
            return;
        }
        int maKH = danhSachKhachHang.get(rowSelected).getMaKH();
        if (khachHangBUS.delete(maKH)) {
            tableModel.removeRow(rowSelected);
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
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
            tableModel.addRow(kh.toObject());
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
        }
    }

    public void updateKhachHang(KhachHangDTO kh) {
        if (khachHangBUS.update(kh)) {
            tableModel.setValueAt(kh.getHoTen(), rowSelected, 1);
            tableModel.setValueAt(kh.getNgaySinh(), rowSelected, 2);
            tableModel.setValueAt(kh.getGioiTinh(), rowSelected, 3);
            tableModel.setValueAt(kh.getSoDT(), rowSelected, 4);
            tableModel.setValueAt(kh.getEmail(), rowSelected, 5);
            tableModel.setValueAt(kh.getNgayDK(), rowSelected, 6);
            tableModel.setValueAt(kh.getCC_HC(), rowSelected, 7);
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
        }
    }

    private void addToolBarAction() {
        myToolBar1.getBtnThem().addActionListener(e -> btnAddActionPerformed(e));
        myToolBar1.getBtnSua().addActionListener(e -> btnUpdateActionPerformed(e));
        myToolBar1.getBtnXoa().addActionListener(e -> btnDeleteActionPerformed(e));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelBorder1 = new presentation.gui.Components.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new presentation.gui.Components.Table();
        jLabel1 = new javax.swing.JLabel();
        myToolBar1 = new presentation.gui.Components.MyToolBar();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ tên", "Ngày sinh", "Giới tính", "Điện thoại", "Email", "Ngày đăng kí", "Căn cước/ Hộ chiếu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
                    .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(myToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>                        

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private presentation.gui.Components.MyToolBar myToolBar1;
    private presentation.gui.Components.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private presentation.gui.Components.Table table;
    // End of variables declaration                   
}
