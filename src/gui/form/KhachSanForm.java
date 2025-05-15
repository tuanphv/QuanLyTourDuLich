package gui.form;

import bus.KhachSanBUS;
import bus.NhaHangBUS;
import dto.KhachSanDTO;
import dto.NhaHangDTO;
import dto.KhachHangDTO;
import gui.components.MyScrollBarUI;
import gui.dialog.InputKhachSan;
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

public class KhachSanForm extends javax.swing.JPanel {
    int rowSelected;
    DefaultTableModel modalTableKhachSan;
    KhachSanBUS khachSanBUS;
    ArrayList<KhachSanDTO> listKhachSan;
    private ArrayList<KhachSanDTO> dataFromExcel;


    public KhachSanForm() {
        initComponents();
        modalTableKhachSan = new DefaultTableModel(KhachSanDTO.KHACH_SAN_COLUMN_NAMES, 0);

        scrollTableKhachSan.getVerticalScrollBar().setUI(new MyScrollBarUI());
        scrollTableKhachSan.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
        scrollTableKhachSan.getViewport().setBackground(Color.white);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scrollTableKhachSan.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        tableKhachSan.setModel(modalTableKhachSan);
        if (!java.beans.Beans.isDesignTime()) {
            // Chỉ loadData khi KHÔNG ở design time
            khachSanBUS = new KhachSanBUS();
            listKhachSan = khachSanBUS.getListHotel();
            loadDataToTable(listKhachSan);
            addToolBarAction();
        } else {
            System.out.println("DiaDanhForm đang chạy ở design time mode");
        }

        myToolBar1.setSearchType(new String[] {"Địa chỉ", "Chi phí"});
        myToolBar1.setSearchHandler(new SearchHandler() {
            @Override
            public void onSearch(String type, String text) {
                ArrayList<KhachSanDTO> dsKhachSan;
                switch (type) {
                    case "Địa chỉ" -> dsKhachSan = khachSanBUS.getKhachSanByDiaChi(text);
                    case "Chi phí" -> dsKhachSan = khachSanBUS.getKhachSanByChiPhi(Integer.parseInt(text.trim()));
                    default -> throw new AssertionError();
                }
                loadDataToTable(dsKhachSan);
            }
        });
        
    }

    private void loadDataToTable(ArrayList<KhachSanDTO> listKhachSan) {
        modalTableKhachSan.setRowCount(0);
        for (KhachSanDTO khachSan : listKhachSan) {
            if (khachSan.getTrangThai() == 1) {
                modalTableKhachSan.addRow(khachSan.toObject());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new gui.components.PanelBorder();
        scrollTableKhachSan = new javax.swing.JScrollPane();
        tableKhachSan = new gui.components.Table();
        jLabel1 = new javax.swing.JLabel();
        myToolBar1 = new gui.components.MyToolBar();

        setPreferredSize(new java.awt.Dimension(1040, 779));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setPreferredSize(new java.awt.Dimension(986, 649));

        scrollTableKhachSan.setBorder(null);

        tableKhachSan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        scrollTableKhachSan.setViewportView(tableKhachSan);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Bảng khách sạn");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(scrollTableKhachSan, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(scrollTableKhachSan, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
        rowSelected = tableKhachSan.getSelectedRow();
        if (rowSelected == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đối tượng cần xoá!");
            return;
        } 

        int answer = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá " + modalTableKhachSan.getValueAt(rowSelected, 1), 
        "Xác nhận xoá", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (answer == JOptionPane.OK_OPTION) {
            khachSanBUS.delete((int) modalTableKhachSan.getValueAt(rowSelected, 0));
            modalTableKhachSan.removeRow(rowSelected);
            JOptionPane.showMessageDialog(this, "Xoá thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Đã huỷ!");
        }
    }

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {                                       
        Window parent = SwingUtilities.getWindowAncestor(this);
        InputKhachSan inputKhachSan = new InputKhachSan((Frame)parent, InputKhachSan.Mode.ADD, this);
        inputKhachSan.setLocationRelativeTo(null);
        inputKhachSan.setVisible(true);
    }

    public void addHotel(KhachSanDTO khachSan) {
        int id = khachSanBUS.insert(khachSan);
        if (id != -1) {
            khachSan.setMaKhachSan(id);
            modalTableKhachSan.addRow(khachSan.toObject());
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
        }
    }

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {                                          
        rowSelected = tableKhachSan.getSelectedRow();
        if (rowSelected == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách sạn cần chỉnh sửa!");
            return;
        }

        KhachSanDTO khachSan = khachSanBUS.getHotelById((int) modalTableKhachSan.getValueAt(rowSelected, 0));
        Window parent = SwingUtilities.getWindowAncestor(this);
        InputKhachSan inputKhachSan = new InputKhachSan((Frame)parent, InputKhachSan.Mode.UPDATE, this);
        inputKhachSan.uploadDataToModal(khachSan);
        inputKhachSan.setLocationRelativeTo(null);
        inputKhachSan.setVisible(true);
    }
    
    public void updateHotel(KhachSanDTO khachSan) {
        boolean success = khachSanBUS.update(khachSan);
        if (success) {
            Object[] rowData = khachSan.toObject();
            for (int i = 0; i < rowData.length; i++) {
                modalTableKhachSan.setValueAt(rowData[i], rowSelected, i);
            }
            JOptionPane.showMessageDialog(this, "Update thành công!");
        }
    }

     private void btnXuatExcelActionPerformed(ActionEvent evt) {
        String savedFilePath = new KhachSanBUS().exportExcel();

        if (savedFilePath != null) {
            JOptionPane.showMessageDialog(null,
                    "Đã lưu file thành công tại:\n" + savedFilePath,
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void btnNhapExcelActionPerformed(ActionEvent evt) {
        ExcelReader<KhachSanDTO> read = new ExcelReader();
        dataFromExcel = read.readWithDialog(row -> {
            try {
                return new KhachSanDTO(
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
            loadDataToTable(listKhachSan);
            myToolBar1.setSearchText("");
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private gui.components.MyToolBar myToolBar1;
    private gui.components.PanelBorder panelBorder1;
    private javax.swing.JScrollPane scrollTableKhachSan;
    private gui.components.Table tableKhachSan;
    // End of variables declaration//GEN-END:variables
}
