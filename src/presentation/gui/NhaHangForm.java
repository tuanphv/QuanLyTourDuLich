package presentation.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import business.model.NhaHangDTO;
import business.service.NhaHangBUS;

public class NhaHangForm extends javax.swing.JPanel {
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

        btnUpdate.setBackground(new java.awt.Color(51, 153, 255));
        btnUpdate.setText("UPDATE");

        btnAdd.setBackground(new java.awt.Color(51, 255, 102));
        btnAdd.setText("ADD");

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
