package gui.dialog;

import gui.form.NhaHangForm;
import java.awt.Frame;

import javax.swing.JOptionPane;

import dto.NhaHangDTO;

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
        // tfMaNhaHang.setText(nhaHang.getMaNhaHang() + "");
        tfTenNhaHang.setText(nhaHang.getTenNhaHang());
        tfDiaChi.setText(nhaHang.getDiaChi());
        tfGia.setText(nhaHang.getGia() + "");
        tfSoDienThoai.setText(nhaHang.getSoDienThoai());
        // cbTrangThai.setSelectedItem(nhaHang.getTrangThai() == 1 ? "Hoạt động" : "Đã khoá");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        tfTenNhaHang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfDiaChi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfGia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfSoDienThoai = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(tfGia, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(tfSoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(tfTenNhaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuy)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfDiaChi, tfGia, tfSoDienThoai, tfTenNhaHang});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHuy, btnSubmit});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfTenNhaHang, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfDiaChi)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfGia)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfDiaChi, tfGia, tfSoDienThoai, tfTenNhaHang});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnHuy, btnSubmit});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {
        if (nhaHang == null) {
            nhaHang = new NhaHangDTO(
                tfTenNhaHang.getText(),             
                tfDiaChi.getText(),
                Integer.parseInt(tfGia.getText()),
                tfSoDienThoai.getText()
                // cbTrangThai.getSelectedItem().equals("Hoạt động") ? 1 : 0
            );
        } else {
            nhaHang.setTenNhaHang(tfTenNhaHang.getText());
            nhaHang.setDiaChi(tfDiaChi.getText());
            nhaHang.setGia(Integer.parseInt(tfGia.getText()));
            nhaHang.setSoDienThoai(tfSoDienThoai.getText());
            // nhaHang.setTrangThai(cbTrangThai.getSelectedItem().equals("Hoạt động") ? 1 : 0);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tfDiaChi;
    private javax.swing.JTextField tfGia;
    private javax.swing.JTextField tfSoDienThoai;
    private javax.swing.JTextField tfTenNhaHang;
    // End of variables declaration//GEN-END:variables
}
