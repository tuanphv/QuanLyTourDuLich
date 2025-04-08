package presentation.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MenuItem extends JButton {

    public MenuItem() {
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setHorizontalAlignment(SwingConstants.LEFT);
        setBorder(new EmptyBorder(8, 15, 8, 15));
        setIconTextGap(10);
        setFont(new Font("sansserif", Font.BOLD, 16));
        setForeground(Color.WHITE);
        setPreferredSize( new Dimension(215, 40));

    }

    public void setModel(Model_Menu data) {
        super.setText(data.getName());
        super.setIcon(data.toIcon());
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(255, 255, 255, 80));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.dispose();
        super.paintComponent(g);
    }

}
