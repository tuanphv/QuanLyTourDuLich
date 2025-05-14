package gui.dialog;

import gui.form.PhuongTienForm;
import java.awt.Frame;

import javax.swing.JOptionPane;

import dto.PhuongTienDTO;

public class InputPhuongTien extends javax.swing.JDialog {
    PhuongTienForm phuongTienForm;
    private Mode mode = Mode.ADD;
    PhuongTienDTO phuongTien;

    public static enum Mode {
        ADD, 
        UPDATE
    }

    public InputPhuongTien(Frame parent, Mode mode, PhuongTienForm phuongTienForm) {
        super(parent, "Thông tin phương tiện", true);
        this.mode = mode;
        this.phuongTienForm = phuongTienForm;
        initComponents();
    }

    public void uploadDataToModal(PhuongTienDTO phuongTien) {
        this.phuongTien = phuongTien;
        // System.out.println(phuongTien.toString());
        // tfMaPhuongTien.setText(phuongTien.getMaPhuongTien() + "");
        tfTenPhuongTien.setText(phuongTien.getTenPhuongTien());
        tfLoaiPhuongTien.setText(phuongTien.getLoaiPhuongTien());
        tfSoChoNgoi.setText(phuongTien.getSoChoNgoi() + "");
        tfGia.setText(phuongTien.getGia() + "");
        tfSoDienThoai.setText(phuongTien.getSoDienThoai());
        // cbTrangThai.setSelectedItem(phuongTien.getTrangThai() == 1 ? "Hoạt động" : "Đã khoá");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        tfTenPhuongTien = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfLoaiPhuongTien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfSoChoNgoi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfGia = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnHuy = new javax.swing.JButton();
        tfSoDienThoai = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Tên phương tiện");

        tfTenPhuongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTenPhuongTienActionPerformed(evt);
            }
        });

        jLabel3.setText("Loại phương tiện");

        jLabel4.setText("Số chỗ");

        jLabel5.setText("Giá");

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel6.setText("Số điện thoại");

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfLoaiPhuongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(tfSoChoNgoi, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(tfGia, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(tfSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTenPhuongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuy)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5, jLabel6});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfGia, tfLoaiPhuongTien, tfSoChoNgoi, tfSoDienThoai, tfTenPhuongTien});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHuy, btnSubmit});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfTenPhuongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfLoaiPhuongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfSoChoNgoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfGia, tfLoaiPhuongTien, tfSoChoNgoi, tfSoDienThoai, tfTenPhuongTien});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnHuy, btnSubmit});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfTenPhuongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTenPhuongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTenPhuongTienActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {
        if (phuongTien == null) {
            phuongTien = new PhuongTienDTO(
                tfTenPhuongTien.getText(),             
                tfLoaiPhuongTien.getText(),
                Integer.parseInt(tfSoChoNgoi.getText()),
                Integer.parseInt(tfGia.getText()),
                tfSoDienThoai.getText()
                // cbTrangThai.getSelectedItem().equals("Hoạt động") ? 1 : 0
            );
        } else {
            phuongTien.setTenPhuongTien(tfTenPhuongTien.getText());
            phuongTien.setLoaiPhuongTien(tfLoaiPhuongTien.getText());
            phuongTien.setSoChoNgoi(Integer.parseInt(tfSoChoNgoi.getText()));
            phuongTien.setGia(Integer.parseInt(tfGia.getText()));
            phuongTien.setSoDienThoai(tfSoDienThoai.getText());
            // phuongTien.setTrangThai(cbTrangThai.getSelectedItem().equals("Hoạt động") ? 1 : 0);
        } 

        switch (mode) {
            case ADD -> phuongTienForm.addPhuongTien(phuongTien);
            case UPDATE -> phuongTienForm.updatePhuongTien(phuongTien);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField tfGia;
    private javax.swing.JTextField tfLoaiPhuongTien;
    private javax.swing.JTextField tfSoChoNgoi;
    private javax.swing.JTextField tfSoDienThoai;
    private javax.swing.JTextField tfTenPhuongTien;
    // End of variables declaration//GEN-END:variables
}
