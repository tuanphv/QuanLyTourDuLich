package gui.form;

import bus.NhanVienBUS;
import dto.NhanVienDTO;
import gui.Main;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class LoginForm extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private NhanVienBUS nhanVienBUS;

    public LoginForm() {
        initComponents();
        nhanVienBUS = new NhanVienBUS();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        setSize(900, 800); // Chỉnh kích thước form
        setLocationRelativeTo(null);
        
        // Tạo layered pane chứa ảnh nền và components
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(900, 800));

        // Thêm ảnh nền
        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/resources/icons/login.jpg"));
        Image scaledImage = backgroundImage.getImage().getScaledInstance(900, 800, Image.SCALE_SMOOTH);
        JLabel lblBackground = new JLabel(new ImageIcon(scaledImage));
        lblBackground.setBounds(0, 0, 900, 800);
        layeredPane.add(lblBackground, JLayeredPane.DEFAULT_LAYER);

        // Panel chứa các thành phần đăng nhập
        JPanel contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setBounds(150, 200, 600, 230); // Điều chỉnh vị trí và kích thước

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Thêm các components
        JLabel lblUsername = new JLabel("Tên đăng nhập:");
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPanel.add(lblUsername, gbc);

        txtUsername = new JTextField(20);
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 1;
        gbc.gridy = 0;
        contentPanel.add(txtUsername, gbc);

        JLabel lblPassword = new JLabel("Mật khẩu:");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPanel.add(lblPassword, gbc);

        txtPassword = new JPasswordField(20);
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 1;
        gbc.gridy = 1;
        contentPanel.add(txtPassword, gbc);

        JButton btnLogin = new JButton("ĐĂNG NHẬP");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 18));
        btnLogin.setPreferredSize(new Dimension(300, 40));

        btnLogin.setBackground(new Color(30, 144, 200)); 
        btnLogin.setForeground(Color.WHITE);             
        btnLogin.setFocusPainted(false);                 
        btnLogin.setBorderPainted(false);                
        btnLogin.setOpaque(true);                        

        btnLogin.addActionListener(this::btnLoginActionPerformed);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPanel.add(btnLogin, gbc);

        layeredPane.add(contentPanel, JLayeredPane.PALETTE_LAYER);
        add(layeredPane);
    }

    private void btnLoginActionPerformed(ActionEvent evt) {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());
        // String username = "ttran";
        // String password = "123456";

        NhanVienDTO nv = nhanVienBUS.login(username, password);
        if (nv != null) {
            Main main = new Main();
            main.setVisible(true);
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(this, "Đăng nhập thất bại!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }

}