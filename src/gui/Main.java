package gui;

import java.awt.CardLayout;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        menu1.addFrame(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new gui.components.PanelBorder();
        menu1 = new gui.components.Menu();
        cardPanel = new javax.swing.JPanel();
        tourForm = new gui.form.TourForm();
        diaDanhForm = new gui.form.DiaDanhForm();
        phuongTienForm = new gui.form.PhuongTienForm();
        nhaHangForm = new gui.form.NhaHangForm();
        khachSanForm = new gui.form.KhachSanForm();
        khachHangForm = new gui.form.KhachHangForm();
        nhanVienForm = new gui.form.NhanVienForm();
        keHoachTourForm = new gui.form.KeHoachTourForm();
        hoaDonForm = new gui.form.HoaDonForm();
        datTourForm = new gui.form.DatTourForm();
        veForm1 = new gui.form.VeForm();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        cardPanel.setLayout(new java.awt.CardLayout());
        cardPanel.add(tourForm, "cardTour");
        cardPanel.add(diaDanhForm, "cardDiaDanh");
        cardPanel.add(phuongTienForm, "cardPhuongTien");
        cardPanel.add(nhaHangForm, "cardNhaHang");
        cardPanel.add(khachSanForm, "cardKhachSan");
        cardPanel.add(khachHangForm, "cardKhachHang");
        cardPanel.add(nhanVienForm, "cardNhanVien");
        cardPanel.add(keHoachTourForm, "cardKeHoachTour");
        cardPanel.add(hoaDonForm, "cardHoaDon");
        cardPanel.add(datTourForm, "cardDatTour");
        cardPanel.add(veForm1, "cardVe");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
    
    public void showCard(String name) {
        CardLayout layout = (CardLayout) cardPanel.getLayout();
        layout.show(cardPanel, name);
  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardPanel;
    private gui.form.DatTourForm datTourForm;
    private gui.form.DiaDanhForm diaDanhForm;
    private gui.form.HoaDonForm hoaDonForm;
    private gui.form.KeHoachTourForm keHoachTourForm;
    private gui.form.KhachHangForm khachHangForm;
    private gui.form.KhachSanForm khachSanForm;
    private gui.components.Menu menu1;
    private gui.form.NhaHangForm nhaHangForm;
    private gui.form.NhanVienForm nhanVienForm;
    private gui.components.PanelBorder panelBorder1;
    private gui.form.PhuongTienForm phuongTienForm;
    private gui.form.TourForm tourForm;
    private gui.form.VeForm veForm1;
    // End of variables declaration//GEN-END:variables
}
