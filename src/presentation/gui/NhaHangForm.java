package presentation.gui;

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

import business.model.NhaHangDTO;
import business.service.NhaHangBUS;

public class NhaHangForm extends javax.swing.JPanel {
    int rowSelected;
    DefaultTableModel modalTableNhaHang;
    NhaHangBUS nhaHangBUS;
    ArrayList<NhaHangDTO> listNhaHang;

    public NhaHangForm() {
        initComponents();
        modalTableNhaHang = new DefaultTableModel(NhaHangDTO.NHA_HANG_COLUMN_NAMES, 0);
        nhaHangBUS = new NhaHangBUS();
        listNhaHang = nhaHangBUS.getListRestaurant();

        scrollTableNhaHang.getVerticalScrollBar().setUI(new MyScrollBarUI());
        scrollTableNhaHang.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
        scrollTableNhaHang.getViewport().setBackground(Color.white);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scrollTableNhaHang.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        tableNhaHang.setModel(modalTableNhaHang);
        uploadDataPhuongTien();
    }

    private void uploadDataPhuongTien() {
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

        panelBorder1 = new presentation.gui.PanelBorder();
        scrollTableNhaHang = new javax.swing.JScrollPane();
        tableNhaHang = new presentation.gui.Table();
        jLabel1 = new javax.swing.JLabel();
        btnDelete = new presentation.gui.MyButton();
        btnUpdate = new presentation.gui.MyButton();
        btnAdd = new presentation.gui.MyButton();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

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
                    .addComponent(scrollTableNhaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(scrollTableNhaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
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

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
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

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private presentation.gui.MyButton btnAdd;
    private presentation.gui.MyButton btnDelete;
    private presentation.gui.MyButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private presentation.gui.PanelBorder panelBorder1;
    private javax.swing.JScrollPane scrollTableNhaHang;
    private presentation.gui.Table tableNhaHang;
    // End of variables declaration//GEN-END:variables
}
