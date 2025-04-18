package gui.Components;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JFrame;
import gui.Main;

public class Menu extends javax.swing.JPanel {

    private Main mainFrame;
    private ArrayList<MenuItem> items;

    public Menu() {
        initComponents();
        setOpaque(false);
        init();
    }

    private void init() {
        tour.setModel(new Model_Menu("tour", "Tour", Model_Menu.MenuType.MENU));
        diadanh.setModel(new Model_Menu("place", "Địa danh", Model_Menu.MenuType.MENU));
        phuongTien.setModel(new Model_Menu("vehicle", "Phương tiện", Model_Menu.MenuType.MENU));
        khachSan.setModel(new Model_Menu("hotel", "Khách sạn", Model_Menu.MenuType.MENU));
        nhaHang.setModel(new Model_Menu("restaurant", "Nhà hàng", Model_Menu.MenuType.MENU));
        KhachHang.setModel(new Model_Menu("customer", "Khách Hàng", Model_Menu.MenuType.MENU));

        items = new ArrayList<>();
        items.add(tour);
        items.add(diadanh);
        items.add(phuongTien);
        items.add(khachSan);
        items.add(nhaHang);
        items.add(KhachHang);
        changeBackground(tour);
        repaint();
    }
    
    public void addFrame(Main mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    private void changeBackground(MenuItem btn) {
        for (MenuItem item: items) {
            item.setBackground(new Color(255, 255, 255, 0));
        }
        btn.setBackground(new Color(255, 255, 255, 80));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tour = new gui.Components.MenuItem();
        diadanh = new gui.Components.MenuItem();
        phuongTien = new gui.Components.MenuItem();
        khachSan = new gui.Components.MenuItem();
        nhaHang = new gui.Components.MenuItem();
        KhachHang = new gui.Components.MenuItem();

        panelMoving.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý Tour du lịch");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );

        jPanel1.setOpaque(false);

        tour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tourActionPerformed(evt);
            }
        });

        diadanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diadanhActionPerformed(evt);
            }
        });

        phuongTien.setText("");
        phuongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phuongTienActionPerformed(evt);
            }
        });

        khachSan.setText("");
        khachSan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khachSanActionPerformed(evt);
            }
        });

        nhaHang.setText("");
        nhaHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhaHangActionPerformed(evt);
            }
        });

        KhachHang.setText("");
        KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KhachHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nhaHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(khachSan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(phuongTien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(diadanh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(tour, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(15, 15, 15))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(tour, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(diadanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phuongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(khachSan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nhaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(247, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tourActionPerformed
        // TODO add your handling code here:
        MenuItem src = (MenuItem) evt.getSource();
        changeBackground(src);
        mainFrame.showCard("cardTour");
        
    }//GEN-LAST:event_tourActionPerformed

    private void diadanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diadanhActionPerformed
        // TODO add your handling code here:
        MenuItem src = (MenuItem) evt.getSource();
        changeBackground(src);
        mainFrame.showCard("cardDiaDanh");
    }//GEN-LAST:event_diadanhActionPerformed

    private void phuongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phuongTienActionPerformed
        // TODO add your handling code here:
        MenuItem src = (MenuItem) evt.getSource();
        changeBackground(src);
        mainFrame.showCard("cardPhuongTien");
    }//GEN-LAST:event_phuongTienActionPerformed

    private void khachSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khachSanActionPerformed
        // TODO add your handling code here:
        MenuItem src = (MenuItem) evt.getSource();
        changeBackground(src);
        mainFrame.showCard("cardKhachSan");
    }//GEN-LAST:event_khachSanActionPerformed

    private void nhaHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhaHangActionPerformed
        // TODO add your handling code here:
        MenuItem src = (MenuItem) evt.getSource();
        changeBackground(src);
        mainFrame.showCard("cardNhaHang");
    }//GEN-LAST:event_nhaHangActionPerformed

    private void KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KhachHangActionPerformed
        // TODO add your handling code here:
        MenuItem src = (MenuItem) evt.getSource();
        changeBackground(src);
        mainFrame.showCard("cardKhachHang");
    }//GEN-LAST:event_KhachHangActionPerformed

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gdp = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
        g2.setPaint(gdp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
//        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    private int x;
    private int y;

    public void initMoving(JFrame frame) {
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = getX();
                y = getY();
            }

        });

        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                frame.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.Components.MenuItem KhachHang;
    private gui.Components.MenuItem diadanh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private gui.Components.MenuItem khachSan;
    private gui.Components.MenuItem nhaHang;
    private javax.swing.JPanel panelMoving;
    private gui.Components.MenuItem phuongTien;
    private gui.Components.MenuItem tour;
    // End of variables declaration//GEN-END:variables
}
