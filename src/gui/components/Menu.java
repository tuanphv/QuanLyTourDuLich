package gui.components;

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
        keHoachTour.setModel(new Model_Menu("list", "Kế hoạch Tour", Model_Menu.MenuType.MENU));
        diadanh.setModel(new Model_Menu("place", "Địa danh", Model_Menu.MenuType.MENU));
        phuongTien.setModel(new Model_Menu("vehicle", "Phương tiện", Model_Menu.MenuType.MENU));
        khachSan.setModel(new Model_Menu("hotel", "Khách sạn", Model_Menu.MenuType.MENU));
        nhaHang.setModel(new Model_Menu("restaurant", "Nhà hàng", Model_Menu.MenuType.MENU));
        khachHang.setModel(new Model_Menu("customer", "Khách Hàng", Model_Menu.MenuType.MENU));
        nhanVien.setModel(new Model_Menu("employee", "Nhân Viên", Model_Menu.MenuType.MENU));
        hoaDon.setModel(new Model_Menu("bill", "Hóa đơn", Model_Menu.MenuType.MENU));
        datTour.setModel(new Model_Menu("booking", "Đặt tour", Model_Menu.MenuType.MENU));
        ve.setModel(new Model_Menu("ticket", "Vé tour", Model_Menu.MenuType.MENU));

        items = new ArrayList<>();
        items.add(tour);
        items.add(keHoachTour);
        items.add(diadanh);
        items.add(phuongTien);
        items.add(khachSan);
        items.add(nhaHang);
        items.add(khachHang);
        items.add(nhanVien);
        items.add(hoaDon);
        items.add(datTour);
        items.add(ve);
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
        tour = new gui.components.MenuItem();
        diadanh = new gui.components.MenuItem();
        phuongTien = new gui.components.MenuItem();
        khachSan = new gui.components.MenuItem();
        nhaHang = new gui.components.MenuItem();
        keHoachTour = new gui.components.MenuItem();
        khachHang = new gui.components.MenuItem();
        nhanVien = new gui.components.MenuItem();
        hoaDon = new gui.components.MenuItem();
        datTour = new gui.components.MenuItem();
        ve = new gui.components.MenuItem();

        setPreferredSize(new java.awt.Dimension(240, 654));

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
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
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

        keHoachTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keHoachTourActionPerformed(evt);
            }
        });

        khachHang.setText("");
        khachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khachHangActionPerformed(evt);
            }
        });

        nhanVien.setText("");
        nhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhanVienActionPerformed(evt);
            }
        });

        hoaDon.setText("");
        hoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoaDonActionPerformed(evt);
            }
        });

        datTour.setText("");
        datTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datTourActionPerformed(evt);
            }
        });

        ve.setText("");
        ve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nhaHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(khachSan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phuongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(diadanh, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(tour, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(keHoachTour, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(khachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datTour, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ve, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(tour, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(keHoachTour, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(diadanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phuongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(khachSan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nhaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(khachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(datTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void keHoachTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keHoachTourActionPerformed
        MenuItem src = (MenuItem) evt.getSource();
        changeBackground(src);
        mainFrame.showCard("cardKeHoachTour");
    }//GEN-LAST:event_keHoachTourActionPerformed

    private void khachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khachHangActionPerformed
        MenuItem src = (MenuItem) evt.getSource();
        changeBackground(src);
        mainFrame.showCard("cardKhachHang");
    }//GEN-LAST:event_khachHangActionPerformed

    private void nhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhanVienActionPerformed
        MenuItem src = (MenuItem) evt.getSource();
        changeBackground(src);
        mainFrame.showCard("cardNhanVien");
    }//GEN-LAST:event_nhanVienActionPerformed

    private void hoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoaDonActionPerformed
        MenuItem src = (MenuItem) evt.getSource();
        changeBackground(src);
        mainFrame.showCard("cardHoaDon");
    }//GEN-LAST:event_hoaDonActionPerformed

    private void datTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datTourActionPerformed
        MenuItem src = (MenuItem) evt.getSource();
        changeBackground(src);
        mainFrame.showCard("cardDatTour");
    }//GEN-LAST:event_datTourActionPerformed

    private void veActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_veActionPerformed
        MenuItem src = (MenuItem) evt.getSource();
        changeBackground(src);
        mainFrame.showCard("cardVe");
    }//GEN-LAST:event_veActionPerformed

    private void tourActionPerformed(java.awt.event.ActionEvent evt) {                                     
        MenuItem src = (MenuItem) evt.getSource();
        changeBackground(src);
        mainFrame.showCard("cardTour");  
    }                                    

    private void diadanhActionPerformed(java.awt.event.ActionEvent evt) {                                        
        MenuItem src = (MenuItem) evt.getSource();
        changeBackground(src);
        mainFrame.showCard("cardDiaDanh");
    }                                       

    private void phuongTienActionPerformed(java.awt.event.ActionEvent evt) {                                           
        MenuItem src = (MenuItem) evt.getSource();
        changeBackground(src);
        mainFrame.showCard("cardPhuongTien");
    }                                          

    private void khachSanActionPerformed(java.awt.event.ActionEvent evt) {                                         
        MenuItem src = (MenuItem) evt.getSource();
        changeBackground(src);
        mainFrame.showCard("cardKhachSan");
    }                                        

    private void nhaHangActionPerformed(java.awt.event.ActionEvent evt) {                                        
        MenuItem src = (MenuItem) evt.getSource();
        changeBackground(src);
        mainFrame.showCard("cardNhaHang");
    }                                       
                                 
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gdp = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
        g2.setPaint(gdp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
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
    private gui.components.MenuItem datTour;
    private gui.components.MenuItem diadanh;
    private gui.components.MenuItem hoaDon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private gui.components.MenuItem keHoachTour;
    private gui.components.MenuItem khachHang;
    private gui.components.MenuItem khachSan;
    private gui.components.MenuItem nhaHang;
    private gui.components.MenuItem nhanVien;
    private javax.swing.JPanel panelMoving;
    private gui.components.MenuItem phuongTien;
    private gui.components.MenuItem tour;
    private gui.components.MenuItem ve;
    // End of variables declaration//GEN-END:variables
}
