package presentation.gui.Components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class CustomComboBox<T> extends JComboBox<T> {

    private static final int CORNER_RADIUS = 8; // Adjust this value to control roundness

    /**
     * Creates new form CustomComboBox - This constructor is specifically for NetBeans Form Designer
     */
    public CustomComboBox() {
        super();
        initCustomUI();
    }
    
    // Constructor with model
    public CustomComboBox(ComboBoxModel<T> model) {
        super(model);
        initCustomUI();
    }
    
    // Constructor with array
    public CustomComboBox(T[] items) {
        super(items);
        initCustomUI();
    }
    
    // Common initialization code
    private void initCustomUI() {
        try {
            setUI(new RoundedComboBoxUI());
            setRenderer(new CustomComboBoxRenderer());
            setPreferredSize(new Dimension(120, 36));
            setBackground(Color.WHITE);
            setFocusable(false);
            setEditable(true); // Set to editable
            setEditor(new RoundedEditor()); // Use our custom rounded editor
            setBorder(new EmptyBorder(0, 0, 0, 0)); // Remove default border, we'll draw our own
            
            // Add the click-to-show behavior
            setupClickToShowDropdown();
            
        } catch (Exception e) {
            // Silent catch for design-time exceptions
            System.err.println("Error initializing CustomComboBox: " + e.getMessage());
        }
    }
    
    // Setup the click-to-show dropdown functionality
    private void setupClickToShowDropdown() {
        // Get the editor component
        Component editorComponent = getEditor().getEditorComponent();
        
        // Add a mouse listener to the editor component
        editorComponent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // When the editor is clicked, show the dropdown
                showPopup();
            }
        });
        
        // Make the text field not directly editable if we want dropdown-only behavior
        if (editorComponent instanceof JTextField) {
            JTextField textField = (JTextField) editorComponent;
            textField.setEditable(false);  // Make the text field read-only
            textField.setFocusable(false); // Prevent the text field from getting focus
            textField.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to indicate clickable
        }
    }

    // Custom editor with rounded corners
    private class RoundedEditor extends BasicComboBoxEditor {
        private JTextField editor;
        
        public RoundedEditor() {
            editor = new JTextField() {
                @Override
                protected void paintComponent(Graphics g) {
                    if (!isOpaque()) {
                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        g2.setColor(getBackground());
                        g2.fillRoundRect(1, 1, getWidth()-2, getHeight()-2, CORNER_RADIUS, CORNER_RADIUS);
                        g2.dispose();
                    }
                    super.paintComponent(g);
                }
            };
            
            editor.setBorder(new EmptyBorder(2, 8, 2, 0)); // Padding instead of border
            editor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            editor.setOpaque(false); // Make non-opaque to show the rounded corners
        }
        
        @Override
        public Component getEditorComponent() {
            return editor;
        }
        
        @Override
        public Object getItem() {
            return editor.getText();
        }
        
        @Override
        public void setItem(Object item) {
            if (item != null) {
                editor.setText(item.toString());
            } else {
                editor.setText("");
            }
        }
    }

    // UI tùy chỉnh - Rounded border combobox
    private class RoundedComboBoxUI extends BasicComboBoxUI {
        @Override
        protected JButton createArrowButton() {
            JButton button = new JButton("▾"); // Unicode triangle symbol
            button.setBorder(new EmptyBorder(0, 3, 0, 3));
            button.setContentAreaFilled(false);
            button.setFocusPainted(false);
            button.setOpaque(false);
            button.setForeground(Color.GRAY);
            return button;
        }

        @Override
        protected void installDefaults() {
            super.installDefaults();
            comboBox.setBackground(Color.WHITE);
            comboBox.setForeground(Color.BLACK);
            comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        }
        
        @Override
        public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
            // Do not paint the background here, we'll do it in paint()
        }
        
        @Override
        public void paint(Graphics g, JComponent c) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            // Draw the rounded border
            g2.setColor(Color.LIGHT_GRAY); // Border color
            RoundRectangle2D roundedRect = new RoundRectangle2D.Float(
                    0, 0, c.getWidth() - 1, c.getHeight() - 1, 
                    CORNER_RADIUS, CORNER_RADIUS);
            g2.draw(roundedRect);
            
            // Fill the background
            g2.setColor(c.getBackground());
            g2.fillRoundRect(1, 1, c.getWidth() - 2, c.getHeight() - 2, 
                    CORNER_RADIUS - 1, CORNER_RADIUS - 1);
            
            super.paint(g, c);
        }
    }

    // Renderer with rounded corners for dropdown items
    private static class CustomComboBoxRenderer extends JLabel implements ListCellRenderer<Object> {
        public CustomComboBoxRenderer() {
            setOpaque(true);
            setFont(new Font("Segoe UI", Font.PLAIN, 14));
            setBorder(new EmptyBorder(5, 10, 5, 5)); // padding for list items
        }

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value,
                                                     int index, boolean isSelected, boolean cellHasFocus) {
            setText(value != null ? value.toString() : "");

            if (isSelected) {
                setBackground(new Color(230, 230, 250)); // Light purple when selected
                setForeground(Color.BLACK);
            } else {
                setBackground(Color.WHITE);
                setForeground(Color.BLACK);
            }

            return this;
        }
    }
}
