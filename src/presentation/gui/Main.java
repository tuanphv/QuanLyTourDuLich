package presentation.gui;

import java.awt.CardLayout;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        menu1.addFrame(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelBorder1 = new presentation.gui.Components.PanelBorder();
        menu1 = new presentation.gui.Components.Menu();
        cardPanel = new javax.swing.JPanel();
        tourForm = new presentation.gui.Form.TourForm();
        diaDanhForm = new presentation.gui.Form.DiaDanhForm();
        phuongTienForm = new presentation.gui.Form.PhuongTienForm();
        nhaHangForm = new presentation.gui.Form.NhaHangForm();
        khachSanForm = new presentation.gui.Form.KhachSanForm();
        khachHangForm = new presentation.gui.Form.KhachHangForm();
        nhanVienForm = new presentation.gui.Form.NhanVienForm();

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

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1026, Short.MAX_VALUE))
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
    }// </editor-fold>                        

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

    // Variables declaration - do not modify                     
    private javax.swing.JPanel cardPanel;
    private presentation.gui.Form.DiaDanhForm diaDanhForm;
    private presentation.gui.Form.KhachHangForm khachHangForm;
    private presentation.gui.Form.KhachSanForm khachSanForm;
    private presentation.gui.Components.Menu menu1;
    private presentation.gui.Form.NhaHangForm nhaHangForm;
    private presentation.gui.Components.PanelBorder panelBorder1;
    private presentation.gui.Form.PhuongTienForm phuongTienForm;
    private presentation.gui.Form.TourForm tourForm;
    private presentation.gui.Form.NhanVienForm nhanVienForm;
    // End of variables declaration                   
}
