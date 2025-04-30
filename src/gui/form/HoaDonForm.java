package gui.form;

import bus.HoaDonBUS;
import dto.HoaDonDTO;
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
import gui.dialog.HoaDonDialog;
import interfaces.SearchHandler;

public class HoaDonForm extends javax.swing.JPanel {

    public HoaDonForm() {
        initComponents();
        spTable.getVerticalScrollBar().setUI(new MyScrollBarUI());
        spTable.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
        spTable.getViewport().setBackground(Color.white);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        DefaultTableModel model = new DefaultTableModel(HoaDonDTO.COLUMN_NAMES, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setModel(model);
        if (!java.beans.Beans.isDesignTime()) {
            // Chỉ loadData khi KHÔNG ở design time
            loadDataToTable(new HoaDonBUS().getDSHoaDon());
            addToolBarAction();
        } else {
            System.out.println("HoaDonForm đang chạy ở design time mode");
        }
        myToolBar1.setSearchType(new String[]{"Mã khách hàng", "Mã nhân viên", "Mã kế hoạch tour"});
        myToolBar1.setSearchHandler(new SearchHandler() {
            @Override
            public void onSearch(String type, String text) {
                ArrayList<HoaDonDTO> khTours;
                HoaDonBUS bus = new HoaDonBUS();
                switch (type) {
                    case "Mã khách hàng" -> khTours = bus.getHoaDonByMaKH(Integer.parseInt(text));
                    case "Mã nhân viên" -> khTours = bus.getHoaDonByMaNV(Integer.parseInt(text));
                    case "Mã kế hoạch tour" -> khTours = bus.getHoaDonByMaKHTour(Integer.parseInt(text));
                    default -> throw new AssertionError();
                }
                loadDataToTable(khTours);
            }
            
        });
        spChiTietVe.getVerticalScrollBar().setUI(new MyScrollBarUI());
        spChiTietVe.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
        spChiTietVe.getViewport().setBackground(Color.white);
        spChiTietVe.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new gui.components.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new gui.components.Table();
        jLabel1 = new javax.swing.JLabel();
        myToolBar1 = new gui.components.MyToolBar();
        panelBorder2 = new gui.components.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        spChiTietVe = new javax.swing.JScrollPane();
        table1 = new gui.components.Table();

        setPreferredSize(new java.awt.Dimension(1660, 1000));

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
        jLabel1.setText("Quản lý Hóa đơn");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder2.setPreferredSize(new java.awt.Dimension(600, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Mã hóa đơn");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Mã khách hàng");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Mã nhân viên");

        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Mã kế hoạch tour");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Ngày lập phiếu");

        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jTextField6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Mã khuyến mại");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Tổng tiền");

        jTextField7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Số vé");

        jTextField8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã vé", "Mã khách hàng", "Giá vé"
            }
        ));
        spChiTietVe.setViewportView(table1);

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spChiTietVe)
                    .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBorder2Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelBorder2Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelBorder2Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelBorder2Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelBorder2Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder2Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelBorder2Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelBorder2Layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField8)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(spChiTietVe, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField6)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField7)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(myToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(ActionEvent evt) {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        HoaDonDialog dialog = new HoaDonDialog(parentFrame);
        dialog.setVisible(true);
        if (dialog.isSave()) {
            HoaDonDTO input = dialog.getInputData();
            if (addTour(input)) {
                JOptionPane.showMessageDialog(this, "Đã thêm kế hoạch tour!");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm kế hoạch tour không thành công!");
            }
        }
    }

    private void btnSuaActionPerformed(ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int index = table.getSelectedRow();
        if (index > -1) {
            HoaDonDTO hoaDon = new HoaDonBUS().getHoaDonById((int) model.getValueAt(index, 0));
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            HoaDonDialog dialog = new HoaDonDialog(parentFrame);
            dialog.loadData(hoaDon);
            dialog.setLocationRelativeTo(parentFrame);
            dialog.setVisible(true);
            if (dialog.isSave()) {
                HoaDonDTO input = dialog.getInputData();
                if (update(input)) {
                    JOptionPane.showMessageDialog(this, "Đã cập nhật kế hoạch tour!");
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin không thành công!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn kế hoạch tour cần cập nhật!");
        }
    }

    private void btnXoaActionPerformed(ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        HoaDonBUS bus = new HoaDonBUS();
        int i = table.getSelectedRow();
        if (i >= 0) {
            int result = JOptionPane.showConfirmDialog(
                    this,
                    "Bạn có chắc chắn muốn xóa?",
                    "Xác nhận",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (result == JOptionPane.OK_OPTION) {
                if (bus.deleteHoaDon((int) model.getValueAt(i, 0))) {
                    model.removeRow(i);
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

    public boolean addTour(HoaDonDTO hoaDon) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        HoaDonBUS bus = new HoaDonBUS();
        int index = bus.addHoaDon(hoaDon);
        if (index != -1) {
            hoaDon.setMaHoaDon(index);
            model.addRow(hoaDon.toArray());
            return true;
        }
        return false;
    }

    public boolean update(HoaDonDTO hoaDon) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        HoaDonBUS bus = new HoaDonBUS();
        int index = bus.updateHoaDon(hoaDon);
        if (index != -1) {
            Object[] a = hoaDon.toArray();
            for (int i = 0; i < a.length; i++) {
                model.setValueAt(a[i], index, i);
            }
            return true;
        }
        return false;
    }

    private void loadDataToTable(ArrayList<HoaDonDTO> hoaDons) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        hoaDons.forEach((var e) -> model.addRow(e.toArray()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private gui.components.MyToolBar myToolBar1;
    private gui.components.PanelBorder panelBorder1;
    private gui.components.PanelBorder panelBorder2;
    private javax.swing.JScrollPane spChiTietVe;
    private javax.swing.JScrollPane spTable;
    private gui.components.Table table;
    private gui.components.Table table1;
    // End of variables declaration//GEN-END:variables
}
