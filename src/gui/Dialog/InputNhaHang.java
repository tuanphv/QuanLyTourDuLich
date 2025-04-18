package gui.Dialog;

import gui.form.NhaHangForm;
import java.awt.Frame;

import javax.swing.JOptionPane;

import model.NhaHangDTO;

public class InputNhaHang extends javax.swing.JDialog {
    NhaHangDTO nhaHang;
    NhaHangForm nhaHangForm;
    private Mode mode = Mode.ADD;

    public static enum Mode {
        ADD, 
        UPDATE
    }

    public InputNhaHang(Frame parent, Mode mode, NhaHangForm nhaHangForm) {
        super(parent, "Thông tin nhà hàng", true);
        this.mode = mode;
        this.nhaHangForm = nhaHangForm; 
        initComponents();
    }

    public void uploadDataToModal(NhaHangDTO nhaHang) {
        this.nhaHang = nhaHang;
        // System.out.println(nhaHang.toString());
        tfMaNhaHang.setText(nhaHang.getMaNhaHang() + "");
        tfTenNhaHang.setText(nhaHang.getTenNhaHang());
        tfDiaChi.setText(nhaHang.getDiaChi());
        tfGia.setText(nhaHang.getGia() + "");
        tfSoDienThoai.setText(nhaHang.getSoDienThoai());
        cbTrangThai.setSelectedItem(nhaHang.getTrangThai() == 1 ? "Hoạt động" : "Đã khoá");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfMaNhaHang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfTenNhaHang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfDiaChi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfGia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfSoDienThoai = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbTrangThai = new javax.swing.JComboBox<>();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Mã nhà hàng");

        tfMaNhaHang.setEnabled(false);

        jLabel2.setText("Tên nhà hàng");

        jLabel3.setText("Địa chỉ");

        jLabel4.setText("Giá");

        jLabel5.setText("Số điện thoại");

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel6.setText("Trạng thái");

        cbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoạt động", "Đã khoá" }));

        btnHuy.setText("Huỷ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(tfTenNhaHang, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(tfMaNhaHang, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(tfGia, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(tfSoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuy)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbTrangThai, tfDiaChi, tfGia, tfMaNhaHang, tfSoDienThoai, tfTenNhaHang});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHuy, btnSubmit});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfMaNhaHang, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTenNhaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy))
                .addGap(22, 22, 22))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbTrangThai, tfDiaChi, tfGia, tfMaNhaHang, tfSoDienThoai, tfTenNhaHang});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnHuy, btnSubmit});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {
        if (nhaHang == null) {
            nhaHang = new NhaHangDTO(
                tfTenNhaHang.getText(),             
                tfDiaChi.getText(),
                Integer.parseInt(tfGia.getText()),
                tfSoDienThoai.getText(),
                cbTrangThai.getSelectedItem().equals("Hoạt động") ? 1 : 0
            );
        } else {
            nhaHang.setTenNhaHang(tfTenNhaHang.getText());
            nhaHang.setDiaChi(tfDiaChi.getText());
            nhaHang.setGia(Integer.parseInt(tfGia.getText()));
            nhaHang.setSoDienThoai(tfSoDienThoai.getText());
            nhaHang.setTrangThai(cbTrangThai.getSelectedItem().equals("Hoạt động") ? 1 : 0);
        } 

        switch (mode) {
            case ADD -> nhaHangForm.addRestaurant(nhaHang);
            case UPDATE -> nhaHangForm.updateRestaurant(nhaHang);
        }

        dispose(); // đóng dialog
    }

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {     
        JOptionPane.showMessageDialog(this, "Đã huỷ!");                                 
        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField tfDiaChi;
    private javax.swing.JTextField tfGia;
    private javax.swing.JTextField tfMaNhaHang;
    private javax.swing.JTextField tfSoDienThoai;
    private javax.swing.JTextField tfTenNhaHang;
    // End of variables declaration//GEN-END:variables
}
