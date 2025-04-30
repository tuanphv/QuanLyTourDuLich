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

import dto.NhaHangDTO;
import bus.NhaHangBUS;
import gui.dialog.InputNhaHang;
import gui.components.MyScrollBarUI;

public class NhaHangForm extends javax.swing.JPanel {
    int rowSelected;
    DefaultTableModel modalTableNhaHang;
    NhaHangBUS nhaHangBUS;
    ArrayList<NhaHangDTO> listNhaHang;

    public NhaHangForm() {
        initComponents();
        modalTableNhaHang = new DefaultTableModel(NhaHangDTO.NHA_HANG_COLUMN_NAMES, 0);
        

        scrollTableNhaHang.getVerticalScrollBar().setUI(new MyScrollBarUI());
        scrollTableNhaHang.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
        scrollTableNhaHang.getViewport().setBackground(Color.white);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scrollTableNhaHang.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        tableNhaHang.setModel(modalTableNhaHang);
        if (!java.beans.Beans.isDesignTime()) {
            // Chỉ loadData khi KHÔNG ở design time
            nhaHangBUS = new NhaHangBUS();
            listNhaHang = nhaHangBUS.getListRestaurant();
            loadDataToTable();
            addToolBarAction();
        } else {
            System.out.println("DiaDanhForm đang chạy ở design time mode");
        }
    }

    private void loadDataToTable() {
        modalTableNhaHang.setRowCount(0);
        for (NhaHangDTO nhaHang : listNhaHang) {
            modalTableNhaHang.addRow(new Object[] {
                nhaHang.getMaNhaHang(),
                nhaHang.getTenNhaHang(),
                nhaHang.getDiaChi(),
                nhaHang.getGia(),
                nhaHang.getSoDienThoai(),
                nhaHang.getTrangThai()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new gui.components.PanelBorder();
        scrollTableNhaHang = new javax.swing.JScrollPane();
        tableNhaHang = new gui.components.Table();
        jLabel1 = new javax.swing.JLabel();
        myToolBar1 = new gui.components.MyToolBar();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setPreferredSize(new java.awt.Dimension(986, 649));

        scrollTableNhaHang.setBorder(null);

        tableNhaHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        scrollTableNhaHang.setViewportView(tableNhaHang);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Bảng nhà hàng");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(scrollTableNhaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(scrollTableNhaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE))
                .addContainerGap(640, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(myToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {
        Window parent = SwingUtilities.getWindowAncestor(this);
        InputNhaHang inputNhaHang = new InputNhaHang((Frame)parent, InputNhaHang.Mode.ADD, this);
        inputNhaHang.setLocationRelativeTo(null);
        inputNhaHang.setVisible(true);
    }

    public void addRestaurant(NhaHangDTO nhaHang) {
        int id = nhaHangBUS.insert(nhaHang);
        if (id != -1) {
            nhaHang.setMaNhaHang(id);
            modalTableNhaHang.addRow(nhaHang.toObject());
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
        }
    }

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {
        rowSelected = tableNhaHang.getSelectedRow();
        if (rowSelected == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhà hàng cần chỉnh sửa!");
            return;
        }

        NhaHangDTO nhaHang = new NhaHangDTO(
            (int) tableNhaHang.getModel().getValueAt(rowSelected, 0),
            (String) tableNhaHang.getModel().getValueAt(rowSelected, 1),
            (String) tableNhaHang.getModel().getValueAt(rowSelected, 2),
            (int) tableNhaHang.getModel().getValueAt(rowSelected, 3),
            (String) tableNhaHang.getModel().getValueAt(rowSelected, 4),
            (int) tableNhaHang.getModel().getValueAt(rowSelected, 5)
        );
        Window parent = SwingUtilities.getWindowAncestor(this);
        InputNhaHang inputNhaHang = new InputNhaHang((Frame) parent, InputNhaHang.Mode.UPDATE, this);
        inputNhaHang.uploadDataToModal(nhaHang);
        inputNhaHang.setLocationRelativeTo(null);
        inputNhaHang.setVisible(true);
    }

    public void updateRestaurant(NhaHangDTO nhaHang) {
        boolean success = nhaHangBUS.update(nhaHang);
        if (success) {
            modalTableNhaHang.setValueAt(nhaHang.getTenNhaHang(), rowSelected, 1);
            modalTableNhaHang.setValueAt(nhaHang.getDiaChi(), rowSelected, 2);
            modalTableNhaHang.setValueAt(nhaHang.getGia(), rowSelected, 3);
            modalTableNhaHang.setValueAt(nhaHang.getSoDienThoai(), rowSelected, 4);
            modalTableNhaHang.setValueAt(nhaHang.getTrangThai(), rowSelected, 5);
            JOptionPane.showMessageDialog(this, "Update thành công!");
        }
    }

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
        rowSelected = tableNhaHang.getSelectedRow();
        if (rowSelected == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đối tượng cần xoá!");
            return;
        } 

        int answer = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá " + modalTableNhaHang.getValueAt(rowSelected, 1), 
        "Xoá nhà hàng", JOptionPane.INFORMATION_MESSAGE, JOptionPane.WARNING_MESSAGE);
        if (answer == JOptionPane.YES_OPTION) {
            nhaHangBUS.delete((int) modalTableNhaHang.getValueAt(rowSelected, 0));
            modalTableNhaHang.removeRow(rowSelected);
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
    private gui.components.MyToolBar myToolBar1;
    private gui.components.PanelBorder panelBorder1;
    private javax.swing.JScrollPane scrollTableNhaHang;
    private gui.components.Table tableNhaHang;
    // End of variables declaration//GEN-END:variables
}
