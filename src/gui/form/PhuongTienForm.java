package gui.form;

import bus.PhuongTienBUS;
import bus.TourBUS;
import dto.PhuongTienDTO;
import dto.TourDTO;
import enums.TrangThaiTour;
import gui.components.MyScrollBarUI;
import gui.dialog.InputPhuongTien;
import interfaces.SearchHandler;
import utils.ExcelReader;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import utils.TextUtils;

public class PhuongTienForm extends javax.swing.JPanel {
    int rowSelected;
    DefaultTableModel modelTablePhuongTien;
    PhuongTienBUS phuongTienBUS;
    ArrayList<PhuongTienDTO> listPhuongTien;
    private ArrayList<PhuongTienDTO> dataFromExcel;


    public PhuongTienForm() {
        initComponents();
        modelTablePhuongTien = new DefaultTableModel(PhuongTienDTO.PHUONG_TIEN_COLUMN_NAMES, 0);
        scrollTablePuongTien.getVerticalScrollBar().setUI(new MyScrollBarUI());
        scrollTablePuongTien.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
        scrollTablePuongTien.getViewport().setBackground(Color.white);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scrollTablePuongTien.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        tablePhuongTien.setModel(modelTablePhuongTien);
        if (!java.beans.Beans.isDesignTime()) {
            // Chỉ loadData khi KHÔNG ở design time
            phuongTienBUS = new PhuongTienBUS();
            listPhuongTien = phuongTienBUS.getListVehicle();
            loadDataToTable(listPhuongTien);
            addToolBarAction();
        } else {
            System.out.println("DiaDanhForm đang chạy ở design time mode");
        }

        myToolBar1.setSearchType(new String[] {"Loại phương tiện", "Số chỗ ngồi", "Chi phí"});
        myToolBar1.setSearchHandler(new SearchHandler() {
            @Override
            public void onSearch(String type, String text) {
                ArrayList<PhuongTienDTO> dsPhuongTien;
                switch (type) {
                    case "Loại phương tiện" -> dsPhuongTien = phuongTienBUS.getListPhuongTienByLoaiPhuongTien(text);
                    case "Số chỗ ngồi" -> dsPhuongTien = phuongTienBUS.getListPhuongTienBySoCho(Integer.parseInt(text.trim()));
                    case "Chi phí" -> {
                        dsPhuongTien = phuongTienBUS.getListPhuongTienByChiPhi(TextUtils.parseGroupedInt(text.trim()));
                        System.out.println(text.trim());
                    }
                        
                    default -> throw new AssertionError();
                }
                loadDataToTable(dsPhuongTien);
            }
        });

    }

    private void loadDataToTable(ArrayList<PhuongTienDTO> listPhuongTien) {
        modelTablePhuongTien.setRowCount(0);
        for (PhuongTienDTO phuongTien : listPhuongTien) {
            if (phuongTien.getTrangThai() == 1) {
                modelTablePhuongTien.addRow(phuongTien.toOject());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new gui.components.PanelBorder();
        scrollTablePuongTien = new javax.swing.JScrollPane();
        tablePhuongTien = new gui.components.Table();
        jLabel1 = new javax.swing.JLabel();
        myToolBar1 = new gui.components.MyToolBar();

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
                .addComponent(scrollTablePuongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        PhuongTienDTO phuongTien = phuongTienBUS.getVehicleById((int) modelTablePhuongTien.getValueAt(rowSelected, 0));
        Window parent = SwingUtilities.getWindowAncestor(this);
        InputPhuongTien inputPhuongTien = new InputPhuongTien((Frame) parent, InputPhuongTien.Mode.UPDATE, this);
        inputPhuongTien.uploadDataToModal(phuongTien);
        inputPhuongTien.setLocationRelativeTo(null);
        inputPhuongTien.setVisible(true);
    }

    public void updatePhuongTien(PhuongTienDTO phuongTien) {
        boolean success = phuongTienBUS.update(phuongTien);
        if (success) {
            Object[] data = phuongTien.toOject();
            for (int i = 0; i < data.length; i++) {
                modelTablePhuongTien.setValueAt(data[i], rowSelected, i);
            }
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
        "Xác nhận xoá", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (answer == JOptionPane.OK_OPTION) {
            phuongTienBUS.delete((int) modelTablePhuongTien.getValueAt(rowSelected, 0));
            modelTablePhuongTien.removeRow(rowSelected);
            JOptionPane.showMessageDialog(this, "Xoá thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Đã huỷ!");
        }
    }

    private void btnXuatExcelActionPerformed(ActionEvent evt) {
        String savedFilePath = new PhuongTienBUS().exportExcel();

        if (savedFilePath != null) {
            JOptionPane.showMessageDialog(null,
                    "Đã lưu file thành công tại:\n" + savedFilePath,
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void btnNhapExcelActionPerformed(ActionEvent evt) {
        ExcelReader<PhuongTienDTO> read = new ExcelReader();
        dataFromExcel = read.readWithDialog(row -> {
            try {
                return new PhuongTienDTO(
                        (int) row.getCell(0).getNumericCellValue(),
                        row.getCell(1).getStringCellValue(),
                        row.getCell(2).getStringCellValue(),
                        (int) row.getCell(3).getNumericCellValue(),
                        (int) row.getCell(4).getNumericCellValue(),
                        row.getCell(5).getStringCellValue()
                );
            } catch (Exception e) {
                System.out.println("⚠️ Dòng lỗi: " + row.getRowNum());
                return null;
            }
        });
        if (!dataFromExcel.isEmpty()) {
            // btnLuu.setVisible(true);
            // btnHuy.setVisible(true);
            loadDataToTable(dataFromExcel);
        }
    }
    
    private void addToolBarAction() {
        myToolBar1.getBtnThem().addActionListener(e -> btnThemActionPerformed(e));
        myToolBar1.getBtnSua().addActionListener(e -> btnSuaActionPerformed(e));
        myToolBar1.getBtnXoa().addActionListener(e -> btnXoaActionPerformed(e));
        myToolBar1.getBtnNhapExcel().addActionListener(e -> btnNhapExcelActionPerformed(e));
        myToolBar1.getBtnXuatExcel().addActionListener(e -> btnXuatExcelActionPerformed(e));
        myToolBar1.getBtnRefresh().addActionListener(e -> {
            loadDataToTable(listPhuongTien);
            myToolBar1.setSearchText("");
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private gui.components.MyToolBar myToolBar1;
    private gui.components.PanelBorder panelBorder1;
    private javax.swing.JScrollPane scrollTablePuongTien;
    private gui.components.Table tablePhuongTien;
    // End of variables declaration//GEN-END:variables
}

