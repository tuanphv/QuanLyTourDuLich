package gui.form;

import bus.KeHoachTourBUS;
import dto.KeHoachTourDTO;
import gui.components.MyScrollBarUI;
import gui.dialog.KeHoachTour;
import interfaces.SearchHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class KeHoachTourForm extends javax.swing.JPanel {

    public KeHoachTourForm() {
        initComponents();
        spTable.getVerticalScrollBar().setUI(new MyScrollBarUI());
        spTable.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
        spTable.getViewport().setBackground(Color.white);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        DefaultTableModel model = new DefaultTableModel(KeHoachTourDTO.KH_TOUR_COLUMN_NAMES, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };
        table.setModel(model);
        if (!java.beans.Beans.isDesignTime()) {
            // Chỉ loadData khi KHÔNG ở design time
            loadDataToTable(new KeHoachTourBUS().getDSKHTour());
            addToolBarAction();
        } else {
            System.out.println("DiaDanhForm đang chạy ở design time mode");
        }
        myToolBar1.setSearchType(new String[]{"Mã tour", "Tên tour", "Số lượng tối đa"});
        myToolBar1.setSearchHandler(new SearchHandler() {
            @Override
            public void onSearch(String type, String text) {
                ArrayList<KeHoachTourDTO> khTours;
                KeHoachTourBUS keHoachTourBUS = new KeHoachTourBUS();
                switch (type) {
                    case "Mã tour" -> khTours = keHoachTourBUS.getKeHoachTourByMaTour(text);
                    case "Tên tour" -> khTours = keHoachTourBUS.getKeHoachTourByNameTour(text);
                    case "Số lượng tối đa" -> khTours = keHoachTourBUS.getKeHoachTourBySLToiDa(text);
                    default -> throw new AssertionError();
                }
                loadDataToTable(khTours);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new gui.components.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new gui.components.Table();
        jLabel1 = new javax.swing.JLabel();
        myToolBar1 = new gui.components.MyToolBar();

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
        jLabel1.setText("Quản lý Kế hoạch Tour");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnThemActionPerformed(ActionEvent evt) {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        // KeHoachTourDialog dialog = new KeHoachTourDialog(parentFrame);
        KeHoachTour dialog = new KeHoachTour(parentFrame, this, KeHoachTour.Action.INSERT);
        dialog.setVisible(true);
        if (dialog.isSave()) {
            dialog.saveKeHoachTour();
            JOptionPane.showMessageDialog(this, "Đã thêm kế hoạch tour!");

            // KeHoachTourDTO input = dialog.getInputData();
            // if (addTour(input)) {
            //     JOptionPane.showMessageDialog(this, "Đã thêm kế hoạch tour!");
            // } else {
            //     JOptionPane.showMessageDialog(this, "Thêm kế hoạch tour không thành công!");
            // }
        }
    }

    private void btnSuaActionPerformed(ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int index = table.getSelectedRow();
        if (index > -1) {
            KeHoachTourDTO khTour = new KeHoachTourBUS().getKeHoachTourById((int) model.getValueAt(index, 0));
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            // KeHoachTourDialog dialog = new KeHoachTourDialog(parentFrame);
            KeHoachTour dialog = new KeHoachTour(parentFrame, this, KeHoachTour.Action.UPDATE);
            dialog.setTitle("Cập nhật kế hoạch tour");
            dialog.loadKeHoachTour(khTour);
            // dialog.loadData(khTour);
            dialog.setLocationRelativeTo(parentFrame);
            dialog.setVisible(true);
            // if (dialog.isSave()) {
            //     KeHoachTourDTO input = dialog.getInputData();
            //     input.setMaKHTour(khTour.getMaKHTour());
            //     if (updateTour(input)) {
            //         JOptionPane.showMessageDialog(this, "Đã cập nhật kế hoạch tour!");
            //     } else {
            //         JOptionPane.showMessageDialog(this, "Cập nhật thông tin không thành công!");
            //     }
            // }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn kế hoạch tour cần cập nhật!");
        }
    }

    private void btnXoaActionPerformed(ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        KeHoachTourBUS bus = new KeHoachTourBUS();
        int rowSelected = table.getSelectedRow();
        if (rowSelected >= 0) {
            int result = JOptionPane.showConfirmDialog(
                    this,
                    "Bạn có chắc chắn muốn xóa kế hoạch tour " + model.getValueAt(rowSelected, 0) + "?",
                    "Xác nhận",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (result == JOptionPane.OK_OPTION) {
                if (bus.deleteKeHoachTour((int) model.getValueAt(rowSelected, 0))) {
                    model.removeRow(rowSelected);
                    JOptionPane.showMessageDialog(this, "Xóa tour thành công!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tour cần xóa!");
        }
    }

    private void addToolBarAction() {
        myToolBar1.getBtnThem().addActionListener(e -> btnThemActionPerformed(e));
        myToolBar1.getBtnSua().addActionListener(e -> btnSuaActionPerformed(e));
        myToolBar1.getBtnXoa().addActionListener(e -> btnXoaActionPerformed(e));
    }

    public int addTour(KeHoachTourDTO khTour) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        KeHoachTourBUS bus = new KeHoachTourBUS();
        int index = bus.addKeHoachTour(khTour);
        if (index != -1) {
            khTour.setMaKHTour(index);
            model.addRow(khTour.toObjectArray());
            return index;
        }
        return -1;
    }

    public boolean updateTour(KeHoachTourDTO khTour) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        KeHoachTourBUS bus = new KeHoachTourBUS();
        int index = bus.updateKeHoachTour(khTour);
        if (index != -1) {
            Object[] a = khTour.toObjectArray();
            for (int i = 0; i < a.length; i++) {
                model.setValueAt(a[i], index, i);
            }
            return true;
        }
        return false;
    }

    private void loadDataToTable(ArrayList<KeHoachTourDTO> khTours) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        // khTours.forEach((var e) -> {
        //     model.addRow(e.toObjectArray());
        // });
        for (KeHoachTourDTO khTour : khTours) {
            model.addRow(khTour.toObjectArray());
            // System.out.println(khTour);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private gui.components.MyToolBar myToolBar1;
    private gui.components.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private gui.components.Table table;
    // End of variables declaration//GEN-END:variables
}
