package gui.components;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MenuItem extends JButton {

    private Icon icon;
    private String text;
    private final int ICON_X = 10;
    private final int TEXT_X = 50;

    public MenuItem() {
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorder(new EmptyBorder(8, 15, 8, 15));
        setFont(new Font("sansserif", Font.BOLD, 16));
        setForeground(Color.WHITE);
        setBackground(new Color(255, 255, 255, 0));
        setPreferredSize(new Dimension(185, 40));
    }

    public void setModel(Model_Menu data) {
        this.text = data.getName();
        this.icon = data.toIcon();
        repaint();
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Khử răng cưa và vẽ nền
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

        // Vẽ icon
        if (icon != null) {
            int iconY = (getHeight() - icon.getIconHeight()) / 2;
            icon.paintIcon(this, g2, ICON_X, iconY);
        }

        // Vẽ text
        if (text != null) {
            g2.setFont(getFont());
            g2.setColor(getForeground());

            FontMetrics fm = g2.getFontMetrics();
            int textY = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();

            g2.drawString(text, TEXT_X, textY);  // TEXT_X cố định để canh trái text
        }

        g2.dispose();
    }

    // Ghi đè để tránh dùng hệ thống icon/text mặc định của JButton
    @Override
    public void setText(String text) {
        this.text = text;
        repaint();
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setIcon(Icon icon) {
        this.icon = icon;
        repaint();
    }

    @Override
    public Icon getIcon() {
        return icon;
    }
}
