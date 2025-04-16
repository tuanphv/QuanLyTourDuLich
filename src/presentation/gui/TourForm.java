package presentation.gui;

import business.model.TourDTO;
import business.service.TourBUS;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class TourForm extends javax.swing.JPanel {

    public TourForm() {
        initComponents();
        spTable.getVerticalScrollBar().setUI(new MyScrollBarUI());
        spTable.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
        spTable.getViewport().setBackground(Color.white);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        DefaultTableModel model = new DefaultTableModel(TourDTO.TOUR_COLUMN_NAMES, 0) {
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

        panelBorder1 = new presentation.gui.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new presentation.gui.Table();
        jLabel1 = new javax.swing.JLabel();
        btnDelete = new presentation.gui.MyButton();
        btnUpdate = new presentation.gui.MyButton();
        btnAdd = new presentation.gui.MyButton();

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
        jLabel1.setText("Bảng Tour du lịch");

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
        TourBUS bus = new TourBUS();
        int i = table.getSelectedRow();
        if (i >= 0) {
            if (bus.deleteTour((int) model.getValueAt(i, 0))) {
                model.removeRow(i);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int index = table.getSelectedRow();
        if (index > -1) {
            TourDTO tour = new TourDTO();
            tour.setMaTour((int) model.getValueAt(index, 0));
            tour.setTenTour((String) model.getValueAt(index, 1));
            tour.setGia((float) model.getValueAt(index, 2));
            tour.setTinhTrang((String) model.getValueAt(index, 3));
            tour.setMoTa((String) model.getValueAt(index, 4));
            tour.setDiemKhoiHanh((String) model.getValueAt(index, 5));
            tour.setDiemDen((String) model.getValueAt(index, 6));
            tour.setLoaiTour((String) model.getValueAt(index, 7));
            tour.setSoNgay((int) model.getValueAt(index, 8));
            tour.setSoDem((int) model.getValueAt(index, 9));
            InputTour formInput = new InputTour(this, InputTour.Mode.UPDATE);
            formInput.loadData(tour);
            formInput.setVisible(true);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        InputTour formInput = new InputTour(this, InputTour.Mode.ADD);
        formInput.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    public void addTour(TourDTO tour) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TourBUS bus = new TourBUS();
        int index = bus.addTour(tour);
        if (index != -1) {
            tour.setMaTour(index);
            model.addRow(tour.toObjectArray());
        }
    }

    public void updateTour(TourDTO tour) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TourBUS bus = new TourBUS();
        int index = bus.updateTour(tour);
        System.out.println("Update Tour: " + index);
        if (index != -1) {
            model.setValueAt(tour.getTenTour(), index, 1);
            model.setValueAt(tour.getGia(), index, 2);
            model.setValueAt(tour.getTinhTrang(), index, 3);
            model.setValueAt(tour.getMoTa(), index, 4);
            model.setValueAt(tour.getDiemKhoiHanh(), index, 5);
            model.setValueAt(tour.getDiemDen(), index, 6);
            model.setValueAt(tour.getLoaiTour(), index, 7);
            model.setValueAt(tour.getSoNgay(), index, 8);
            model.setValueAt(tour.getSoDem(), index, 9);
        }
    }

    private void loadAllCustomerData() {
        TourBUS bus = new TourBUS();
        ArrayList<TourDTO> tours = bus.getDsTour();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        tours.forEach((var e) -> model.addRow(e.toObjectArray()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private presentation.gui.MyButton btnAdd;
    private presentation.gui.MyButton btnDelete;
    private presentation.gui.MyButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private presentation.gui.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private presentation.gui.Table table;
    // End of variables declaration//GEN-END:variables
}
