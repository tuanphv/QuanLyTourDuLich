package gui.form;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import dto.DiaDanhDTO;
import bus.DiaDanhBUS;
import gui.components.MyScrollBarUI;
import gui.dialog.DiaDanhDialog;
import utils.ExcelReader;

public class DiaDanhForm extends javax.swing.JPanel {

    private ArrayList<DiaDanhDTO> dataFromExcel;
    private DiaDanhBUS bus;

    public DiaDanhForm() {
        initComponents();
        btnLuu.setVisible(false);
        btnHuy.setVisible(false);
        spTable.getVerticalScrollBar().setUI(new MyScrollBarUI());
        spTable.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
        spTable.getViewport().setBackground(Color.white);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        DefaultTableModel model = new DefaultTableModel(DiaDanhDTO.DIA_DANH_COLUMN_NAMES, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setModel(model);
        if (!java.beans.Beans.isDesignTime()) {
            bus = new DiaDanhBUS();
            loadDataToTable(bus.getDsDiaDanh());
            addToolBarAction();
        } else {
            System.out.println("DiaDanhForm đang chạy ở design time mode");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new gui.components.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new gui.components.Table();
        jLabel1 = new javax.swing.JLabel();
        btnHuy = new gui.components.MyButton();
        btnLuu = new gui.components.MyButton();
        myToolBar1 = new gui.components.MyToolBar();

        setPreferredSize(new java.awt.Dimension(1660, 1000));

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

        btnHuy.setBackground(new java.awt.Color(255, 102, 102));
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/x-mark.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnLuu.setBackground(new java.awt.Color(0, 255, 51));
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/save.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(20, 20, 20))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)))
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        saveData();
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        JOptionPane.showMessageDialog(null,
                    "Hủy thêm dữ liệu file excel",
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        btnLuu.setVisible(false);
        btnHuy.setVisible(false);
        loadDataToTable(bus.getDsDiaDanh());
        dataFromExcel = null;
    }//GEN-LAST:event_btnHuyActionPerformed

    public boolean addDiaDanh(DiaDanhDTO dd) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
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
        ExcelReader<DiaDanhDTO> read = new ExcelReader();
        dataFromExcel = read.readWithDialog(row -> {
            try {
                return new DiaDanhDTO(
                        (int) row.getCell(0).getNumericCellValue(),
                        row.getCell(1).getStringCellValue(),
                        row.getCell(2).getStringCellValue(), 
                        (int) row.getCell(3).getNumericCellValue(),
                        row.getCell(4).getStringCellValue()
                );
            } catch (Exception e) {
                System.out.println("⚠️ Dòng lỗi: " + row.getRowNum());
                return null;
            }
        });
        if (!dataFromExcel.isEmpty()) {
            btnLuu.setVisible(true);
            btnHuy.setVisible(true);
            loadDataToTable(dataFromExcel);
        }
    }

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {
        String savedFilePath = new DiaDanhBUS().exportExcel();

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
        myToolBar1.getBtnRefresh().addActionListener(e -> {
            loadDataToTable(bus.getDsDiaDanh());
            myToolBar1.setSearchText("");
        });
        myToolBar1.getBtnNhapExcel().addActionListener(e -> btnNhapExcelActionPerformed(e));
        myToolBar1.getBtnXuatExcel().addActionListener(e -> btnXuatExcelActionPerformed(e));
    }

    public boolean updateDiaDanh(DiaDanhDTO dd) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int index = bus.updateDiaDanh(dd);
        if (index != -1) {
            model.setValueAt(dd.getTenDD(), index, 1);
            model.setValueAt(dd.getTinhThanh(), index, 2);
            model.setValueAt(dd.getChiPhi(), index, 3);
            model.setValueAt(dd.getDiemNoiBat(), index, 4);
            return true;
        }
        return false;
    }

    private void loadDataToTable(ArrayList<DiaDanhDTO> list) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        list.forEach((var e) -> model.addRow(e.toObjectArray()));
    }

    private void saveData() {
        int failCount = 0;
        if (dataFromExcel != null) {
            for (DiaDanhDTO dd : dataFromExcel) {
                if (bus.addDiaDanh(dd) == -1) {
                    failCount++;
                }
            }
        }
        if (failCount > 0) {
            JOptionPane.showMessageDialog(null,
                    "Lưu không thành công " + failCount + " dòng",
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Lưu thành công " + (dataFromExcel.size() - failCount) + " dòng",
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        btnLuu.setVisible(false);
        btnHuy.setVisible(false);
        dataFromExcel = null;
        loadDataToTable(bus.getDsDiaDanh());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.components.MyButton btnHuy;
    private gui.components.MyButton btnLuu;
    private javax.swing.JLabel jLabel1;
    private gui.components.MyToolBar myToolBar1;
    private gui.components.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private gui.components.Table table;
    // End of variables declaration//GEN-END:variables
}
