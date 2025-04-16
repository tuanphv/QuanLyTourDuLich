package presentation.gui.Components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class MyButton extends JButton {

    private Color bg;

    public MyButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorder(new EmptyBorder(8, 10, 8, 10));
        setFont(new Font("sansserif", Font.BOLD, 12));
        setForeground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                bg = getBackground();
                setBackground(new Color(bg.getRed(), bg.getGreen(), bg.getBlue(), 150));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(bg);
            }

        });
    }

    public MyButton() {
        this("");
    }

    @Override
    public void setText(String text) {
        super.setText(text);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        repaint();
    }

}
