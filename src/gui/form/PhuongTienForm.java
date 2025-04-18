package gui.form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Window;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import model.PhuongTienDTO;
import bus.PhuongTienBUS;
import gui.Components.MyScrollBarUI;
import gui.Dialog.InputPhuongTien;

public class PhuongTienForm extends javax.swing.JPanel {
    int rowSelected;
    DefaultTableModel modelTablePhuongTien;
    PhuongTienBUS phuongTienBUS;
    ArrayList<PhuongTienDTO> listPhuongTien;

    public PhuongTienForm() {
        initComponents();
        modelTablePhuongTien = new DefaultTableModel(PhuongTienDTO.PHUONG_TIEN_COLUMN_NAMES, 0);
        phuongTienBUS = new PhuongTienBUS();
        listPhuongTien = phuongTienBUS.getListVehicle();

        scrollTablePuongTien.getVerticalScrollBar().setUI(new MyScrollBarUI());
        scrollTablePuongTien.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
        scrollTablePuongTien.getViewport().setBackground(Color.white);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scrollTablePuongTien.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        tablePhuongTien.setModel(modelTablePhuongTien);
        uploadDataPhuongTien();
        addToolBarAction();
    }

    private void uploadDataPhuongTien() {
        modelTablePhuongTien.setRowCount(0);
        for (PhuongTienDTO phuongTien : listPhuongTien) {
            modelTablePhuongTien.addRow(new Object[] {
                phuongTien.getMaPhuongTien(),
                phuongTien.getTenPhuongTien(),
                phuongTien.getLoaiPhuongTien(),
                phuongTien.getSoChoNgoi(),
                phuongTien.getGia(),
                phuongTien.getSoDienThoai(),
                phuongTien.getTrangThai()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new gui.Components.PanelBorder();
        scrollTablePuongTien = new javax.swing.JScrollPane();
        tablePhuongTien = new gui.Components.Table();
        jLabel1 = new javax.swing.JLabel();
        myToolBar1 = new gui.Components.MyToolBar();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        scrollTablePuongTien.setBorder(null);

        tablePhuongTien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        scrollTablePuongTien.setViewportView(tablePhuongTien);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Bảng phương tiện");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(scrollTablePuongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(scrollTablePuongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(myToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {
        Window parent = SwingUtilities.getWindowAncestor(this);
        InputPhuongTien inputPhuongTien = new InputPhuongTien((Frame) parent, InputPhuongTien.Mode.ADD, this);
        inputPhuongTien.setLocationRelativeTo(null);
        inputPhuongTien.setVisible(true);
    }

    public void addPhuongTien(PhuongTienDTO phuongTien) {
        int id = phuongTienBUS.insert(phuongTien);
        if (id != -1) {
            phuongTien.setMaPhuongTien(id);
            modelTablePhuongTien.addRow(phuongTien.toOject());
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
        }
    }

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {
        rowSelected = tablePhuongTien.getSelectedRow();
        if (rowSelected == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phương tiện cần chỉnh sửa!");
            return;
        }

        PhuongTienDTO phuongTien = new PhuongTienDTO(
            (int) tablePhuongTien.getModel().getValueAt(rowSelected, 0),
            tablePhuongTien.getModel().getValueAt(rowSelected, 1).toString(),
            tablePhuongTien.getModel().getValueAt(rowSelected, 2).toString(),
            (int) tablePhuongTien.getModel().getValueAt(rowSelected, 3),
            (int) tablePhuongTien.getModel().getValueAt(rowSelected, 4),
            tablePhuongTien.getModel().getValueAt(rowSelected, 5).toString(),
            (int) tablePhuongTien.getModel().getValueAt(rowSelected, 6)
        );
        Window parent = SwingUtilities.getWindowAncestor(this);
        InputPhuongTien inputPhuongTien = new InputPhuongTien((Frame) parent, InputPhuongTien.Mode.UPDATE, this);
        inputPhuongTien.uploadDataToModal(phuongTien);
        inputPhuongTien.setLocationRelativeTo(null);
        inputPhuongTien.setVisible(true);
    }

    public void updatePhuongTien(PhuongTienDTO phuongTien) {
        boolean success = phuongTienBUS.update(phuongTien);
        if (success) {
            modelTablePhuongTien.setValueAt(phuongTien.getTenPhuongTien(), rowSelected, 1);
            modelTablePhuongTien.setValueAt(phuongTien.getLoaiPhuongTien(), rowSelected, 2);
            modelTablePhuongTien.setValueAt(phuongTien.getSoChoNgoi(), rowSelected, 3);
            modelTablePhuongTien.setValueAt(phuongTien.getGia(), rowSelected, 4);
            modelTablePhuongTien.setValueAt(phuongTien.getSoDienThoai(), rowSelected, 5);
            modelTablePhuongTien.setValueAt(phuongTien.getTrangThai(), rowSelected, 6);
            JOptionPane.showMessageDialog(this, "Update thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "ERROR!");
        }
    }

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
        rowSelected = tablePhuongTien.getSelectedRow();
        System.out.println("rowSelected: " + rowSelected);
        if (rowSelected == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đối tượng cần xoá!");
            return;
        } 

        int answer = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá " + modelTablePhuongTien.getValueAt(rowSelected, 1), 
        "Xoá nhà hàng", JOptionPane.INFORMATION_MESSAGE, JOptionPane.WARNING_MESSAGE);
        if (answer == JOptionPane.YES_OPTION) {
            phuongTienBUS.delete((int) modelTablePhuongTien.getValueAt(rowSelected, 0));
            modelTablePhuongTien.removeRow(rowSelected);
            JOptionPane.showMessageDialog(this, "Xoá thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Đã huỷ!");
        }
    }
    
    private void addToolBarAction() {
        myToolBar1.getBtnThem().addActionListener(e -> btnThemActionPerformed(e));
        myToolBar1.getBtnSua().addActionListener(e -> btnSuaActionPerformed(e));
        myToolBar1.getBtnXoa().addActionListener(e -> btnXoaActionPerformed(e));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private gui.Components.MyToolBar myToolBar1;
    private gui.Components.PanelBorder panelBorder1;
    private javax.swing.JScrollPane scrollTablePuongTien;
    private gui.Components.Table tablePhuongTien;
    // End of variables declaration//GEN-END:variables
}
