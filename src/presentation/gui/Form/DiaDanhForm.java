package presentation.gui.Form;

import business.model.DiaDanhDTO;
import business.service.DiaDanhBUS;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import presentation.gui.InputDialog.DiaDanhDialog;
import presentation.gui.Components.MyScrollBarUI;

public class DiaDanhForm extends javax.swing.JPanel {

    public DiaDanhForm() {
        initComponents();
        spTable.getVerticalScrollBar().setUI(new MyScrollBarUI());
        spTable.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
        spTable.getViewport().setBackground(Color.white);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        DefaultTableModel model = new DefaultTableModel(DiaDanhDTO.DIA_DANH_COLUMN_NAMES, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };
        table.setModel(model);
        loadAllCustomerData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new presentation.gui.Components.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new presentation.gui.Components.Table();
        jLabel1 = new javax.swing.JLabel();
        btnDelete = new presentation.gui.Components.MyButton();
        btnUpdate = new presentation.gui.Components.MyButton();
        btnAdd = new presentation.gui.Components.MyButton();

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
        jLabel1.setText("Bảng địa danh");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(51, 153, 255));
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(51, 255, 102));
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        DiaDanhBUS bus = new DiaDanhBUS();
        int i = table.getSelectedRow();
        if (i >= 0) {
            int result = JOptionPane.showConfirmDialog(
                    this,
                    "Bạn có chắc chắn muốn thoát?",
                    "Xác nhận",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (result == JOptionPane.OK_OPTION) {
                if (bus.deleteDiaDanh((int) model.getValueAt(i, 0))) {
                    model.removeRow(i);
                    JOptionPane.showMessageDialog(this, "Đã xóa địa danh thành công!");
                }
            }
        } else
            JOptionPane.showMessageDialog(this, "Vui lòng chọn địa danh cần xóa!");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int index = table.getSelectedRow();
        if (index > -1) {
            DiaDanhDTO dd = new DiaDanhDTO();
            dd.setMaDD((int) model.getValueAt(index, 0));
            dd.setTenDD((String) model.getValueAt(index, 1));
            dd.setTinhThanh((String) model.getValueAt(index, 2));
            dd.setDiemNoiBat((String) model.getValueAt(index, 3));
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            DiaDanhDialog dialog = new DiaDanhDialog(parentFrame);
            dialog.loadData(dd);
            dialog.setLocationRelativeTo(parentFrame);
            dialog.setVisible(true);
            if (dialog.isSave()) {
                DiaDanhDTO ddInput = dialog.getInputData();
                ddInput.setMaDD(dd.getMaDD());
                if (updateDiaDanh(ddInput)) {
                    JOptionPane.showMessageDialog(this, "Đã cập nhật địa danh!");
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin không thành công!");
                }
            }
        } else
            JOptionPane.showMessageDialog(this, "Vui lòng chọn địa danh cần cập nhật!");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        DiaDanhDialog dialog = new DiaDanhDialog(parentFrame);
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setVisible(true);
        if (dialog.isSave()) {
            DiaDanhDTO ddInput = dialog.getInputData();
            if (addDiaDanh(ddInput)) {
                JOptionPane.showMessageDialog(this, "Đã thêm địa danh!");
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin không thành công!");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    public boolean addDiaDanh(DiaDanhDTO dd) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        DiaDanhBUS bus = new DiaDanhBUS();
        int index = bus.addDiaDanh(dd);
        if (index != -1) {
            dd.setMaDD(index);
            model.addRow(dd.toObjectArray());
            return true;
        }
        return false;
    }

    public boolean updateDiaDanh(DiaDanhDTO dd) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        DiaDanhBUS bus = new DiaDanhBUS();
        int index = bus.updateDiaDanh(dd);
        if (index != -1) {
            model.setValueAt(dd.getTenDD(), index, 1);
            model.setValueAt(dd.getTinhThanh(), index, 2);
            model.setValueAt(dd.getDiemNoiBat(), index, 3);
            return true;
        }
        return false;
    }

    private void loadAllCustomerData() {
        DiaDanhBUS bus = new DiaDanhBUS();
        ArrayList<DiaDanhDTO> DiaDanhs = bus.getDsDiaDanh();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        DiaDanhs.forEach((var e) -> model.addRow(e.toObjectArray()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private presentation.gui.Components.MyButton btnAdd;
    private presentation.gui.Components.MyButton btnDelete;
    private presentation.gui.Components.MyButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private presentation.gui.Components.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private presentation.gui.Components.Table table;
    // End of variables declaration//GEN-END:variables
}
