package presentation.gui.Form;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import business.model.DiaDanhDTO;
import business.service.DiaDanhBUS;
import presentation.gui.Components.MyScrollBarUI;
import presentation.gui.InputDialog.DiaDanhDialog;
import utils.ExcelReader;
import utils.ExcelWriter;
import utils.TypeUtils;

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
        addToolBarAction();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new presentation.gui.Components.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new presentation.gui.Components.Table();
        jLabel1 = new javax.swing.JLabel();
        myToolBar1 = new presentation.gui.Components.MyToolBar();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {

                }));
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
                                .addGroup(panelBorder1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 960,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        panelBorder1Layout.setVerticalGroup(
                panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addGap(20, 20, 20)
                                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 564,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(myToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(20, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(myToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        DiaDanhBUS bus = new DiaDanhBUS();
        int i = table.getSelectedRow();
        if (i >= 0) {
            int result = JOptionPane.showConfirmDialog(
                    this,
                    "Bạn có chắc chắn muốn xóa?",
                    "Xác nhận",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                if (bus.deleteDiaDanh((int) model.getValueAt(i, 0))) {
                    model.removeRow(i);
                    JOptionPane.showMessageDialog(this, "Đã xóa địa danh thành công!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn địa danh cần xóa!");
        }
    }

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int index = table.getSelectedRow();
        if (index > -1) {
            DiaDanhBUS bus = new DiaDanhBUS();
            DiaDanhDTO dd = bus.getDiaDanhByMa((int) model.getValueAt(index, 0));
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
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn địa danh cần cập nhật!");
        }
    }

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {
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
    }

    private void btnNhapExcelActionPerformed(java.awt.event.ActionEvent evt) {
        ExcelReader read = new ExcelReader();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        ArrayList<Object[]> list = read.readWithDialog(TypeUtils.getTypes(new DiaDanhDTO()));
        if (!list.isEmpty()) {
            model.setRowCount(0);
            list.forEach(e -> model.addRow(e));
        }
    }

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {
        ExcelWriter excelWriter = new ExcelWriter();
        String savedFilePath = excelWriter.exportFromTable("DanhSachDiaDanh.xlsx", table.getModel());

        if (savedFilePath != null) {
            JOptionPane.showMessageDialog(null,
                    "Đã lưu file thành công tại:\n" + savedFilePath,
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void addToolBarAction() {
        myToolBar1.getBtnThem().addActionListener(e -> btnThemActionPerformed(e));
        myToolBar1.getBtnSua().addActionListener(e -> btnSuaActionPerformed(e));
        myToolBar1.getBtnXoa().addActionListener(e -> btnXoaActionPerformed(e));
        myToolBar1.getBtnNhapExcel().addActionListener(e -> btnNhapExcelActionPerformed(e));
        myToolBar1.getBtnXuatExcel().addActionListener(e -> btnXuatExcelActionPerformed(e));
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
    private javax.swing.JLabel jLabel1;
    private presentation.gui.Components.MyToolBar myToolBar1;
    private presentation.gui.Components.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private presentation.gui.Components.Table table;
    // End of variables declaration//GEN-END:variables
}
