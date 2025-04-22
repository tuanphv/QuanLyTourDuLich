package presentation.gui.Form;

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

import business.model.KhachSanDTO;
import business.service.KhachSanBUS;
import presentation.gui.Components.MyScrollBarUI;
import presentation.gui.InputDialog.InputKhachSan;

public class KhachSanForm extends javax.swing.JPanel {
    int rowSelected;
    DefaultTableModel modalTableKhachSan;
    KhachSanBUS khachSanBUS;
    ArrayList<KhachSanDTO> listKhachSan;

    public KhachSanForm() {
        initComponents();
        modalTableKhachSan = new DefaultTableModel(KhachSanDTO.KHACH_SAN_COLUMN_NAMES, 0);
        khachSanBUS = new KhachSanBUS();
        listKhachSan = khachSanBUS.getListHotel();

        scrollTableKhachSan.getVerticalScrollBar().setUI(new MyScrollBarUI());
        scrollTableKhachSan.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
        scrollTableKhachSan.getViewport().setBackground(Color.white);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scrollTableKhachSan.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        tableKhachSan.setModel(modalTableKhachSan);
        if (!java.beans.Beans.isDesignTime()) {
            // Chỉ loadData khi KHÔNG ở design time
            loadDataToTable();
            addToolBarAction();
        } else {
            System.out.println("DiaDanhForm đang chạy ở design time mode");
        }
    }

    private void loadDataToTable() {
        modalTableKhachSan.setRowCount(0);
        for (KhachSanDTO khachSan : listKhachSan) {
            modalTableKhachSan.addRow(new Object[] {
                khachSan.getMaKhachSan(), 
                khachSan.getTenKhachSan(), 
                khachSan.getDiaChi(), 
                khachSan.getGia(), 
                khachSan.getSoDienThoai(),
                khachSan.getTrangThai()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new presentation.gui.Components.PanelBorder();
        scrollTableKhachSan = new javax.swing.JScrollPane();
        tableKhachSan = new presentation.gui.Components.Table();
        jLabel1 = new javax.swing.JLabel();
        myToolBar1 = new presentation.gui.Components.MyToolBar();

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
                .addComponent(scrollTableKhachSan, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
        rowSelected = tableKhachSan.getSelectedRow();
        if (rowSelected == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đối tượng cần xoá!");
            return;
        } 

        int answer = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá " + modalTableKhachSan.getValueAt(rowSelected, 1), 
        "Xoá khách sạn", JOptionPane.INFORMATION_MESSAGE, JOptionPane.WARNING_MESSAGE);
        if (answer == JOptionPane.YES_OPTION) {
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

        KhachSanDTO khachSan = new KhachSanDTO(
            (int) tableKhachSan.getModel().getValueAt(rowSelected, 0),
            (String) tableKhachSan.getModel().getValueAt(rowSelected, 1),
            (String) tableKhachSan.getModel().getValueAt(rowSelected, 2),
            (int) tableKhachSan.getModel().getValueAt(rowSelected, 3),
            (String) tableKhachSan.getModel().getValueAt(rowSelected, 4),
            (int) tableKhachSan.getModel().getValueAt(rowSelected, 5)
        );
        Window parent = SwingUtilities.getWindowAncestor(this);
        InputKhachSan inputKhachSan = new InputKhachSan((Frame)parent, InputKhachSan.Mode.UPDATE, this);
        inputKhachSan.uploadDataToModal(khachSan);
        inputKhachSan.setLocationRelativeTo(null);
        inputKhachSan.setVisible(true);
    }
    
    public void updateHotel(KhachSanDTO khachSan) {
        boolean success = khachSanBUS.update(khachSan);
        if (success) {
            modalTableKhachSan.setValueAt(khachSan.getTenKhachSan(), rowSelected, 1);
            modalTableKhachSan.setValueAt(khachSan.getDiaChi(), rowSelected, 2);
            modalTableKhachSan.setValueAt(khachSan.getGia(), rowSelected, 3);
            modalTableKhachSan.setValueAt(khachSan.getSoDienThoai(), rowSelected, 4);
            modalTableKhachSan.setValueAt(khachSan.getTrangThai(), rowSelected, 5);
            JOptionPane.showMessageDialog(this, "Update thành công!");
        }
    }

    private void addToolBarAction() {
        myToolBar1.getBtnThem().addActionListener(e -> btnThemActionPerformed(e));
        myToolBar1.getBtnSua().addActionListener(e -> btnSuaActionPerformed(e));
        myToolBar1.getBtnXoa().addActionListener(e -> btnXoaActionPerformed(e));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private presentation.gui.Components.MyToolBar myToolBar1;
    private presentation.gui.Components.PanelBorder panelBorder1;
    private javax.swing.JScrollPane scrollTableKhachSan;
    private presentation.gui.Components.Table tableKhachSan;
    // End of variables declaration//GEN-END:variables
}
