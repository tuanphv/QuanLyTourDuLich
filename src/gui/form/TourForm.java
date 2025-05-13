package gui.form;

import dto.TourDTO;
import bus.TourBUS;
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
import gui.components.MyScrollBarUI;
import gui.dialog.TourDialog;
import interfaces.SearchHandler;

public class TourForm extends javax.swing.JPanel {

    private TourBUS bus;

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
                return false;
            }
        };
        table.setModel(model);
        if (!java.beans.Beans.isDesignTime()) {
            bus = new TourBUS();
            loadDataToTable(bus.getDsTour());
            addToolBarAction();
        } else {
            System.out.println("DiaDanhForm đang chạy ở design time mode");
        }
        myToolBar1.setSearchType(new String[]{"Tên tour", "Điểm khởi hành", "Điểm đến"});
        myToolBar1.setSearchHandler(new SearchHandler() {
            @Override
            public void onSearch(String type, String text) {
                ArrayList<TourDTO> tours;
                switch (type) {
                    case "Tên tour" ->
                        tours = bus.timTheoTen(text);
                    case "Điểm khởi hành" ->
                        tours = bus.timTheoDiemKhoiHanh(text);
                    case "Điểm đến" ->
                        tours = bus.timTheoDiemDen(text);
                    default ->
                        throw new AssertionError();
                }

                loadDataToTable(tours);
            }
        });

        txtMinCost.setSelectionColor(new Color(30, 144, 255));
        txtMinCost.setSelectedTextColor(Color.WHITE);
        txtMaxCost.setSelectionColor(new Color(30, 144, 255));
        txtMaxCost.setSelectedTextColor(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new gui.components.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new gui.components.Table();
        jLabel1 = new javax.swing.JLabel();
        myToolBar1 = new gui.components.MyToolBar();
        panelBorder2 = new gui.components.PanelBorder();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMinCost = new javax.swing.JTextField();
        txtMaxCost = new javax.swing.JTextField();
        btnFilter = new gui.components.MyButton();
        jLabel6 = new javax.swing.JLabel();
        cbLoaiTour = new gui.components.CustomComboBox();
        jLabel7 = new javax.swing.JLabel();
        cb1Day = new javax.swing.JCheckBox();
        cb2To4Day = new javax.swing.JCheckBox();
        cb5PlusDay = new javax.swing.JCheckBox();

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/filter.png"))); // NOI18N
        jLabel2.setText("Lọc");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Từ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Giá");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Đến");

        txtMinCost.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMinCost.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMinCostFocusLost(evt);
            }
        });
        txtMinCost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtMinCostMousePressed(evt);
            }
        });

        txtMaxCost.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMaxCost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtMaxCostMousePressed(evt);
            }
        });

        btnFilter.setText("Lọc kết quả");
        btnFilter.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Loại tour");

        cbLoaiTour.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất cả", "Miền Bắc", "Miền Trung", "Miền Nam" }));
        cbLoaiTour.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Số ngày");

        cb1Day.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cb1Day.setText("1");

        cb2To4Day.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cb2To4Day.setText("2-4");

        cb5PlusDay.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cb5PlusDay.setText("5+");

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbLoaiTour, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelBorder2Layout.createSequentialGroup()
                                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMinCost, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                            .addComponent(txtMaxCost)))))))
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(cb1Day)
                        .addGap(65, 65, 65)
                        .addComponent(cb2To4Day)
                        .addGap(50, 50, 50)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb5PlusDay))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMinCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbLoaiTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb1Day)
                    .addComponent(cb2To4Day)
                    .addComponent(cb5PlusDay))
                .addGap(34, 34, 34)
                .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(20, 20, 20)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(myToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        Float min = "".equals(txtMinCost.getText()) ? null : Float.valueOf(txtMinCost.getText());
        Float max = "".equals(txtMaxCost.getText()) ? null : Float.valueOf(txtMaxCost.getText());
        String loaiTour = (String) cbLoaiTour.getSelectedItem();
        boolean is1Day = cb1Day.isSelected();
        boolean is2To4Day = cb2To4Day.isSelected();
        boolean is5PlusDay = cb5PlusDay.isSelected();
        loadDataToTable(bus.filter(min, max, loaiTour, is1Day, is2To4Day, is5PlusDay));
    }//GEN-LAST:event_btnFilterActionPerformed

    private void txtMinCostMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMinCostMousePressed
        txtMinCost.selectAll();
    }//GEN-LAST:event_txtMinCostMousePressed

    private void txtMaxCostMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaxCostMousePressed
        txtMaxCost.selectAll();
    }//GEN-LAST:event_txtMaxCostMousePressed

    private void txtMinCostFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMinCostFocusLost
        // TODO: check bé hơn max cost
    }//GEN-LAST:event_txtMinCostFocusLost

    private void btnThemActionPerformed(ActionEvent evt) {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        TourDialog dialog = new TourDialog(parentFrame);
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setVisible(true);
        if (dialog.isSave()) {
            TourDTO tourInput = dialog.getInputData();
            if (addTour(tourInput)) {
                JOptionPane.showMessageDialog(this, "Đã thêm tour!");
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin không thành công!");
            }
        }
    }

    private void btnSuaActionPerformed(ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int index = table.getSelectedRow();
        if (index > -1) {
            TourDTO tour = bus.getTourById((int) model.getValueAt(index, 0));
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            TourDialog dialog = new TourDialog(parentFrame);
            dialog.loadData(tour);
            dialog.setLocationRelativeTo(parentFrame);
            dialog.setVisible(true);
            if (dialog.isSave()) {
                TourDTO tourInput = dialog.getInputData();
                tourInput.setMaTour(tour.getMaTour());
                if (updateTour(tourInput)) {
                    JOptionPane.showMessageDialog(this, "Đã cập nhật tour!");
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin không thành công!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tour cần cập nhật!");
        }
    }

    private void btnXoaActionPerformed(ActionEvent evt) {
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
                if (bus.deleteTour((int) model.getValueAt(i, 0))) {
                    model.removeRow(i);
                    JOptionPane.showMessageDialog(this, "Xóa tour thành công!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tour cần xóa!");
        }
    }

    private void btnXuatExcelActionPerformed(ActionEvent evt) {
        String savedFilePath = new TourBUS().exportExcel();

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
        myToolBar1.getBtnXuatExcel().addActionListener(e -> btnXuatExcelActionPerformed(e));
        myToolBar1.getBtnRefresh().addActionListener(e -> loadDataToTable(new TourBUS().getDsTour()));
    }

    public boolean addTour(TourDTO tour) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int index = bus.addTour(tour);
        if (index != -1) {
            tour.setMaTour(index);
            model.addRow(tour.toTableRow());
            return true;
        }
        return false;
    }

    public boolean updateTour(TourDTO tour) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int index = bus.updateTour(tour);
        System.out.println("Update Tour: " + index);
        if (index != -1) {
            Object[] rowData = tour.toTableRow();
            for (int i = 0; i < rowData.length; i++) {
                model.setValueAt(rowData[i], index, i);
            }
            return true;
        }
        return false;
    }

    private void loadDataToTable(ArrayList<TourDTO> tours) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        tours.forEach((var e) -> model.addRow(e.toTableRow()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.components.MyButton btnFilter;
    private javax.swing.JCheckBox cb1Day;
    private javax.swing.JCheckBox cb2To4Day;
    private javax.swing.JCheckBox cb5PlusDay;
    private gui.components.CustomComboBox cbLoaiTour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private gui.components.MyToolBar myToolBar1;
    private gui.components.PanelBorder panelBorder1;
    private gui.components.PanelBorder panelBorder2;
    private javax.swing.JScrollPane spTable;
    private gui.components.Table table;
    private javax.swing.JTextField txtMaxCost;
    private javax.swing.JTextField txtMinCost;
    // End of variables declaration//GEN-END:variables
}
