package gui.dialog;

import gui.form.KhachSanForm;
import java.awt.Frame;

import javax.swing.JOptionPane;

import dto.KhachSanDTO;

public class InputKhachSan extends javax.swing.JDialog {
    KhachSanDTO khachSan;
    KhachSanForm khachSanForm;
    private Mode mode = Mode.ADD;

    public static enum Mode {
        ADD,
        UPDATE
    }

    public InputKhachSan(Frame parent, Mode mode, KhachSanForm khachSanForm) {
        super(parent, "Thông tin khách sạn", true);
        this.mode = mode;
        this.khachSanForm = khachSanForm;
        initComponents();
    }

    public void uploadDataToModal(KhachSanDTO khachSan) {
        this.khachSan = khachSan;
        // System.out.println(khachSan.toString());
        tfTenKhachSan.setText(khachSan.getTenKhachSan());
        tfDiaChi.setText(khachSan.getDiaChi());
        tfGia.setText(khachSan.getGia() + "");
        tfSoDienThoai.setText(khachSan.getSoDienThoai());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        tfTenKhachSan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfDiaChi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfGia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfSoDienThoai = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Tên khách sạn");

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
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tfGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(tfDiaChi, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTenKhachSan, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfSoDienThoai))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHuy, btnSubmit});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfDiaChi, tfGia, tfSoDienThoai, tfTenKhachSan});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfTenKhachSan, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy))
                .addGap(20, 20, 20))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnHuy, btnSubmit});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel5});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfDiaChi, tfGia, tfSoDienThoai, tfTenKhachSan});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {     
        JOptionPane.showMessageDialog(this, "Đã huỷ!");                                 
        setVisible(false);
    }

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {  
        if (khachSan == null) {
            khachSan = new KhachSanDTO(
                tfTenKhachSan.getText(),             
                tfDiaChi.getText(),
                Integer.parseInt(tfGia.getText()),
                tfSoDienThoai.getText()
                // cbTrangThai.getSelectedItem().equals("Hoạt động") ? 1 : 0
            );
        } else {
            khachSan.setTenKhachSan(tfTenKhachSan.getText());
            khachSan.setDiaChi(tfDiaChi.getText());
            khachSan.setGia(Integer.parseInt(tfGia.getText()));
            khachSan.setSoDienThoai(tfSoDienThoai.getText());
            // khachSan.setTrangThai(cbTrangThai.getSelectedItem().equals("Hoạt động") ? 1 : 0);
        } 

        switch (mode) {
            case ADD -> khachSanForm.addHotel(khachSan);
            case UPDATE -> khachSanForm.updateHotel(khachSan);
        }

        dispose(); // đóng dialog
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
    private javax.swing.JTextField tfTenKhachSan;
    // End of variables declaration//GEN-END:variables
}
