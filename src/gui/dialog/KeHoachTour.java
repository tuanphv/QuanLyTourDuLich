package gui.dialog;

import bus.BuoiAnBUS;
import bus.ChiTietHanhKhachBUS;
import bus.ChiTietKeHoachTourBUS;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import bus.DiaDanhBUS;
import bus.DiaDiemThamQuanBUS;
import bus.KeHoachTourBUS;
import bus.KhachSanBUS;
import bus.KhachSanNghiNgoiBUS;
import bus.NhaHangBUS;
import bus.PhuongTienBUS;
import bus.TourBUS;
import dto.BuoiAnDTO;
import dto.ChiTietHanhKhachDTO;
import dto.ChiTietKeHoachTourDTO;
import dto.DiaDanhDTO;
import dto.DiaDiemThamQuanDTO;
import dto.KeHoachTourDTO;
import dto.KhachSanDTO;
import dto.KhachSanNghiNgoiDTO;
import dto.NhaHangDTO;
import dto.PhuongTienDTO;
import dto.TourDTO;
import enums.TrangThaiKeHoachTour;
import gui.components.CustomComboBox;
import gui.components.MyButton;
import gui.components.MyScrollBarUI;
import gui.form.KeHoachTourForm;
import java.lang.reflect.Array;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.SwingUtilities;
import org.w3c.dom.Text;
import utils.DateUtils;
import utils.TextUtils;

public class KeHoachTour extends javax.swing.JDialog {
    private boolean save;
    private Action action;
    KeHoachTourForm keHoachTourForm;
    KeHoachTourDTO keHoachTourDTO;

    public static enum Action {
        INSERT, UPDATE
    }

    TourBUS tourBUS = new TourBUS();
    KeHoachTourBUS keHoachTourBUS = new KeHoachTourBUS();
    ChiTietKeHoachTourBUS chiTietKeHoachTourBUS = new ChiTietKeHoachTourBUS();
    DiaDanhBUS diaDanhBUS = new DiaDanhBUS();
    PhuongTienBUS phuongTienBUS = new PhuongTienBUS();
    NhaHangBUS nhaHangBUS = new NhaHangBUS();
    KhachSanBUS khachSanBUS = new KhachSanBUS();
    DiaDiemThamQuanBUS diaDiemThamQuanBUS = new DiaDiemThamQuanBUS();
    BuoiAnBUS buoiAnBUS = new BuoiAnBUS();
    KhachSanNghiNgoiBUS khachSanNghiNgoiBUS = new KhachSanNghiNgoiBUS();
    

    ArrayList<NhaHangDTO> listNhaHang;
    ArrayList<DiaDanhDTO> listDiaDanh;
    ArrayList<PhuongTienDTO> listPhuongTien;
    ArrayList<KhachSanDTO> listKhachSan;
    ArrayList<ChiTietKeHoachTourDTO> listChiTietKeHoachTour;

    // SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public KeHoachTour() {
        // lấy danh sách dữ liệu nhà hàng, khách sạn, phương tiện
        listNhaHang = nhaHangBUS.getListRestaurant();
        listDiaDanh = diaDanhBUS.getDsDiaDanh();
        listPhuongTien = phuongTienBUS.getListVehicle();
        listKhachSan = khachSanBUS.getListHotel();
    }
  
    public KeHoachTour(java.awt.Frame parent, KeHoachTourForm keHoachTourForm, Action action) {
        super(parent, "Thêm kế hoạch tour", true);
        this.keHoachTourForm = keHoachTourForm;
        this.action = action;
        initComponents();

        dateStart.setDateFormatString("dd-MM-yyyy");
        dateEnd.setDateFormatString("dd-MM-yyyy");

        scrollPanelChiTietKeHoachTour.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPanelChiTietKeHoachTour.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanelChiTietKeHoachTour.getVerticalScrollBar().setUI(new MyScrollBarUI());
        scrollPanelChiTietKeHoachTour.getHorizontalScrollBar().setUI(new MyScrollBarUI());
        scrollPanelChiTietKeHoachTour.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
        scrollPanelChiTietKeHoachTour.getVerticalScrollBar().setBackground(Color.WHITE);

        // panelChiTietKeHoachTour.setLayout(new BoxLayout(panelChiTietKeHoachTour, BoxLayout.Y_AXIS));
        panelLichTrinh.setLayout(new BoxLayout(panelLichTrinh, BoxLayout.Y_AXIS));
        panelAnUong.setLayout(new BoxLayout(panelAnUong, BoxLayout.Y_AXIS));

        // lấy danh sách dữ liệu nhà hàng, khách sạn, phương tiện
        listNhaHang = nhaHangBUS.getListRestaurant();
        listDiaDanh = diaDanhBUS.getDsDiaDanh();
        listPhuongTien = phuongTienBUS.getListVehicle();
        listKhachSan = khachSanBUS.getListHotel();
        listChiTietKeHoachTour = chiTietKeHoachTourBUS.getAllChiTietKeHoachTour();

        loadComboBox();

        tfSoLuongDaDat.setText("0");
        dateStart.addPropertyChangeListener("date", evt -> {
            initEndDate();
        });
        cbTour.addPropertyChangeListener("date", evt -> {
            initEndDate();
        });

        // pack();
        setLocationRelativeTo(null);

        // initializeValues(); // Khởi tạo giá trị mặc định
        // initializeSchedule(); // Khởi tạo lịch trình mặc định
    }

    public boolean isSave() {
        return this.save;
    }

    public void initEndDate() {
        // Lấy số ngày của tour đã chọn
        java.util.Date startDate = dateStart.getDate();
        if (startDate == null) {
            // System.err.println("Ngày bắt đầu không hợp lệ");
            return;
        }

        int soNgayTour = tourBUS.getTourById(Integer.parseInt(cbTour.getSelectedItem().toString().split(" - ")[0].trim())).getSoNgay();
        // System.err.println("Số ngày tour: " + soNgayTour);
        LocalDate localDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(soNgayTour - 1);
        dateEnd.setDate(java.sql.Date.valueOf(localDate));
    }

    public void loadComboBox() {
        // Load data for cbTour
        ArrayList<TourDTO> listTour = tourBUS.getDsTour();

        String[] items = new String[listTour.size()];
        int i = 0;
        for (TourDTO tour : listTour) {
            items[i++] = tour.getMaTour() + " - " + tour.getTenTour();
        }

        DefaultComboBoxModel modalComboTour = new DefaultComboBoxModel<>(items);
        cbTour.setModel(modalComboTour);

        // Chọn giá trị đầu tiên
        // if (cbTour.getItemCount() > 0) {
        //     cbTour.setSelectedIndex(0);
        // }

        // Load data for cbtrangThai
        cbtrangThai.setModel(new DefaultComboBoxModel<>(TrangThaiKeHoachTour.values()));

        // Tự động tạo lịch trình sau khi tải dữ liệu
        createSchedule();
    }

    public void createSchedule() {
        int soNgayTour = tourBUS.getTourById(Integer.parseInt(cbTour.getSelectedItem().toString().split(" - ")[0].trim())).getSoNgay();
        // System.out.println("Tour: " + cbTour.getSelectedItem().toString());
        // System.out.println("So ngay tour: " + soNgayTour);
        
        panelLichTrinh.removeAll();
        panelAnUong.removeAll();

        for (int i = 1; i <= soNgayTour; i++) {
            panelLichTrinh.add(createLichTrinhPanel(i));
            panelAnUong.add(createAnUongPanel(i));
        }

        panelLichTrinh.revalidate();
        panelLichTrinh.repaint();
        panelAnUong.revalidate();
        panelAnUong.repaint();
        
        panelChiTietKeHoachTour.revalidate();
        panelChiTietKeHoachTour.repaint();
    }

    // Phương thức tiện ích để tạo một JPanel có BoxLayout Y và titled border
    public JPanel createTitledPanel(String title) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            title, TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));
        return p;
    }

    // Phương thức tiện ích tạo titled border
    public TitledBorder createTitleBorder(String title) {
        TitledBorder titleBorder = BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            title,
            TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        );
        return titleBorder;
    }

    public JPanel createLichTrinhPanel(int dayNumber) {
        JPanel dayPanel = createTitledPanel("Ngày " + dayNumber);
        dayPanel.setBackground(new Color(255, 255, 255));

        // Tiêu đề ngày
        JPanel titlePanel = new JPanel(new BorderLayout());
        JTextField titleField = new JTextField();
        titleField.setBorder(createTitleBorder("Tiêu đề"));
        titlePanel.add(titleField, BorderLayout.CENTER);
        dayPanel.add(titlePanel);

        // Panel chứa các địa điểm
        JPanel locationPanel = createTitledPanel("Địa điểm tham quan");
        // thêm 1 địa điểm mặc định
        // locationPanel.add(createFormDiaDiem());
        // locationPanel.repaint();
        // locationPanel.revalidate();

        // Panel chứa khách sạn nghỉ ngơi
        JPanel hotelPanel = createTitledPanel("Khách sạn nghỉ ngơi");
        // thêm 1 khách sạn mặc định
        // hotelPanel.add(createFormKhachSan());
        // hotelPanel.repaint();
        // hotelPanel.revalidate();

        // Nút thêm địa điểm
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(new Color(255, 255, 255));
        MyButton addLocationBtn = new MyButton("➕ Thêm địa điểm");
        MyButton addHotelBtn = new MyButton("➕ Thêm khách sạn");
        buttonPanel.add(addLocationBtn);
        buttonPanel.add(addHotelBtn);

        dayPanel.add(locationPanel);
        dayPanel.add(hotelPanel);
        dayPanel.add(buttonPanel);

        addLocationBtn.addActionListener(evt -> {
            locationPanel.add(createFormDiaDiem());
            locationPanel.revalidate();
            locationPanel.repaint();
        });

        addHotelBtn.addActionListener(evt -> {
            hotelPanel.add(createFormKhachSan());
            hotelPanel.revalidate();
            hotelPanel.repaint();
        });

        // Ẩn tiêu đề nếu không có nội dung
        if (locationPanel.getComponentCount() == 0) {
            locationPanel.setBorder(null);
        }
        if (hotelPanel.getComponentCount() == 0) {
            hotelPanel.setBorder(null);
        }

        return dayPanel;
    }

    public JPanel createMealPanel(String mealName, ArrayList<String> listTenNhaHang) {
        JPanel mealPanel = createTitledPanel(mealName);
        mealPanel.setBackground(new Color(255, 255, 255));

        CustomComboBox<String> comboBox = new CustomComboBox<>(listTenNhaHang.toArray(new String[0]));
        int chiPhi = nhaHangBUS.getRestaurantByName(comboBox.getSelectedItem().toString()).getGia();
        // JLabel lbChiPhi = new JLabel("Chi phí: " + chiPhi + " VNĐ");
        JTextField tfChiPhi = new JTextField("Chi phí: " + chiPhi + " VNĐ");
        tfChiPhi.setFocusable(false);
        JTextField moTa = new JTextField();
        moTa.setBorder(BorderFactory.createTitledBorder("Mô tả"));

        mealPanel.add(comboBox);
        // mealPanel.add(lbChiPhi);
        mealPanel.add(tfChiPhi);
        mealPanel.add(moTa);

        // Lắng nghe sự kiện chọn địa điểm
        comboBox.addActionListener(evt -> {
            int chiPhiSelected = nhaHangBUS.getRestaurantByName(comboBox.getSelectedItem().toString()).getGia();
            // lbChiPhi.setText("Chi phí: " + chiPhiSelected + " VNĐ");
            tfChiPhi.setText("Chi phí: " + chiPhiSelected + " VNĐ");
        });

        // Lắng nghe sự kiện chọn nhà hàng
        comboBox.addActionListener(evt -> {
            int chiPhiSelected = nhaHangBUS.getRestaurantByName(comboBox.getSelectedItem().toString()).getGia();
            // lbChiPhi.setText("Chi phí: " + chiPhiSelected + " VNĐ");
            tfChiPhi.setText("Chi phí: " + chiPhiSelected + " VNĐ");
        });

        return mealPanel;
    }

    public JPanel createAnUongPanel(int dayNumber) {
        JPanel anUongPanel = createTitledPanel("Ngày " + dayNumber);
        anUongPanel.setBackground(new Color(255, 255, 255));

        // Lấy danh sách nhà hàng
        ArrayList<String> listTenNhaHang = new ArrayList<>();
        for (NhaHangDTO nhaHang : listNhaHang) {
            listTenNhaHang.add(nhaHang.getTenNhaHang());
        }

        // Danh sách các bữa ăn
        String [] mealNames = {"Bữa sáng", "Bữa trưa", "Bữa tối"};
        for (String meal : mealNames) {
            JPanel mealPanel = createMealPanel(meal, listTenNhaHang);
            anUongPanel.add(mealPanel);
        }

        return anUongPanel;
    }

    public JPanel createFormDiaDiem() {
        JPanel diaDiemPanel = createTitledPanel("Địa điểm tham quan");
        diaDiemPanel.setBackground(new Color(255, 255, 255));

        // Lấy danh sách địa điểm
        ArrayList<String> listTenDiaDiem = new ArrayList<>();
        for (DiaDanhDTO diaDanh : listDiaDanh) {
            listTenDiaDiem.add(diaDanh.getTenDD());
        }
        CustomComboBox<String> diaDiemComboBox = new CustomComboBox<>(listTenDiaDiem.toArray(new String[0]));
        diaDiemPanel.add(diaDiemComboBox);

        // int chiPhiThamQuan = diaDanhBUS.getDiaDanhByName(diaDiemComboBox.getSelectedItem().toString()).getChiPhiThamQuan();
        // JLabel lbChiPhiThamQuan = new JLabel(chiPhiThamQuan + " VNĐ");
        int chiPhiThamQuan = diaDanhBUS.getDiaDanhByName(diaDiemComboBox.getSelectedItem().toString()).getChiPhi();
        JTextField tfChiPhiThamQuan = new JTextField("Chi phí: " + chiPhiThamQuan + " VNĐ");
        tfChiPhiThamQuan.setFocusable(false);
        // tfChiPhiThamQuan.setBorder(BorderFactory.createTitledBorder("Chi phí tham quan"));
        diaDiemPanel.add(tfChiPhiThamQuan);
        
        JTextField tfMoTa = new JTextField();
        tfMoTa.setBorder(BorderFactory.createTitledBorder("Mô tả"));
        diaDiemPanel.add(tfMoTa);

        // Lấy danh sách phưong tiện
        ArrayList<String> listTenPhuongTien = new ArrayList<>();
        for (PhuongTienDTO phuongTien : listPhuongTien) {
            listTenPhuongTien.add(phuongTien.getTenPhuongTien());
        }

        // JComboBox<String> phuongTienComboBox = new JComboBox<>();
        CustomComboBox<String> phuongTienComboBox = new CustomComboBox<>(listTenPhuongTien.toArray(new String[0]));
        phuongTienComboBox.setBorder(BorderFactory.createTitledBorder("Phương tiện di chuyển"));
        phuongTienComboBox.setPreferredSize(new Dimension(200, 60));
        // phuongTienComboBox.setPreferredSize(new Dimension(phuongTienComboBox.getWidth(), diaDiemComboBox.getHeight()));
        diaDiemPanel.add(phuongTienComboBox);
        
        int chiPhiDiChuyen = phuongTienBUS.getVehicleByName(phuongTienComboBox.getSelectedItem().toString()).getGia();
        // JLabel lbChiPhiDiChuyen = new JLabel("Chi phí: " + chiPhiDiChuyen + " VNĐ");
        JTextField tfChiPhiDiChuyen = new JTextField("Chi phí: " + chiPhiDiChuyen + " VNĐ");
        tfChiPhiDiChuyen.setFocusable(false);
        // JTextField tfChiPhiDiChuyen = new JTextField();
        // lbChiPhiDiChuyen.setBorder(BorderFactory.createTitledBorder("Chi phí di chuyển"));
        // diaDiemPanel.add(lbChiPhiDiChuyen);
        diaDiemPanel.add(tfChiPhiDiChuyen);

        // lắng nghe sự kiện thay đổi phương tiện
        phuongTienComboBox.addActionListener(evt -> {
            int chiPhi = phuongTienBUS.getVehicleByName(phuongTienComboBox.getSelectedItem().toString()).getGia();
            // lbChiPhiDiChuyen.setText("Chi phí: " + chiPhi + " VNĐ");
            tfChiPhiDiChuyen.setText("Chi phí: " + chiPhi + " VNĐ");
        });

        return diaDiemPanel;
    }

    public JPanel createFormKhachSan() {
        JPanel khachSanPanel = createTitledPanel("Khách sạn");
        khachSanPanel.setBackground(new Color(255, 255, 255));

        // Lấy danh sách khách sạn
        ArrayList<String> listTenKhachSan = new ArrayList<>();
        for (KhachSanDTO khachSan : listKhachSan) {
            listTenKhachSan.add(khachSan.getTenKhachSan());
        }
        CustomComboBox<String> khachSanComboBox = new CustomComboBox<>(listTenKhachSan.toArray(new String[0]));
        khachSanPanel.add(khachSanComboBox);

        int chiPhiKhachSan = khachSanBUS.getHotelByName(khachSanComboBox.getSelectedItem().toString()).getGia();
        // JLabel lbChiPhiKhachSan = new JLabel(chiPhiKhachSan + " VNĐ");
        // JLabel lbChiPhiKhachSan = new JLabel("Chi phí: " + chiPhiKhachSan + " VNĐ");
        JTextField tfChiPhiKhachSan = new JTextField("Chi phí: " + chiPhiKhachSan + " VNĐ");
        tfChiPhiKhachSan.setFocusable(false);
        // lbChiPhiKhachSan.setBorder(BorderFactory.createTitledBorder("Chi phí"));
        // lbChiPhiKhachSan.setPreferredSize(new Dimension(200, 30));
        // lbChiPhiKhachSan.setHorizontalAlignment(SwingConstants.LEFT); // Căn trái nội dung
        // lbChiPhiKhachSan.setAlignmentX(Component.LEFT_ALIGNMENT); // Căn trái JLabel
        // JTextField lbChiPhiKhachSan = new JTextField();
        // lbChiPhiKhachSan.setBorder(BorderFactory.createTitledBorder("Chi phí"));
        // khachSanPanel.add(lbChiPhiKhachSan);
        khachSanPanel.add(tfChiPhiKhachSan);

        // lắng nghe sự kiện thay đổi khách sạn
        khachSanComboBox.addActionListener(evt -> {
            int chiPhi = khachSanBUS.getHotelByName(khachSanComboBox.getSelectedItem().toString()).getGia();
            // lbChiPhiKhachSan.setText("Chi phí: " + chiPhi + " VNĐ");
            tfChiPhiKhachSan.setText("Chi phí: " + chiPhi + " VNĐ");
        });

        return khachSanPanel;
    }

    public void saveKeHoachTour() {
        try {
            // === LẤY THÔNG TIN CHUNG ===
            int maTour = Integer.parseInt(cbTour.getSelectedItem().toString().split(" - ")[0].trim());
            java.sql.Date startDate = new java.sql.Date(dateStart.getDate().getTime());
            java.sql.Date endDate = new java.sql.Date(dateEnd.getDate().getTime());
            // int soLuongDaDat = Integer.parseInt(tfSoLuongDaDat.getText().trim());
            int soLuongToiDa = Integer.parseInt(tfSoLuongToiDa.getText().trim());
            // float tongChiPhi = Float.parseFloat(tfTongChiPhi.getText().trim());
            TrangThaiKeHoachTour trangThai = (TrangThaiKeHoachTour) cbtrangThai.getSelectedItem();
    
            // === LƯU THÔNG TIN KẾ HOẠCH TOUR ===
            int maKeHoachTour = keHoachTourForm.addTour(
                new KeHoachTourDTO(
                    maTour, 
                    startDate.toLocalDate(), 
                    endDate.toLocalDate(), 
                    0,
                    soLuongToiDa, 
                    0,
                    trangThai
                )
            );

            int chiPhiTour = 0;
            // === LƯU LỊCH TRÌNH VÀ ĂN UỐNG THEO NGÀY ===
            int soNgayTour = tourBUS.getTourById(maTour).getSoNgay();
    
            for (int i = 0; i < soNgayTour; i++) {
                
                JPanel panelLichTrinhNgay = (JPanel) panelLichTrinh.getComponent(i);
                JPanel panelAn = (JPanel) panelAnUong.getComponent(i);
                
                // Lấy title ngày
                JTextField titleField = (JTextField) ((JPanel) panelLichTrinhNgay.getComponent(0)).getComponent(0);
                String tieuDe = titleField.getText().trim();
                
                int maChiTietKeHoachTour = chiTietKeHoachTourBUS.insert(
                    new ChiTietKeHoachTourDTO(
                        maKeHoachTour, 
                        startDate.toLocalDate().plusDays(i + 1),
                        tieuDe,
                        0
                    )
                );
                
                // === Lưu Địa điểm ===
                long tongChiPhiNgay = 0;
                JPanel diaDiemPanel = (JPanel) panelLichTrinhNgay.getComponent(1);
                for (int j = 0; j < diaDiemPanel.getComponentCount(); j++) {
                    JPanel diaDiemItem = (JPanel) diaDiemPanel.getComponent(j);
                    JComboBox cbDiaDiem = (JComboBox) diaDiemItem.getComponent(0);
                    JTextField chiPhiThamQuan = (JTextField) diaDiemItem.getComponent(1);
                    JTextField moTa = (JTextField) diaDiemItem.getComponent(2);
                    JComboBox cbPhuongTien = (JComboBox) diaDiemItem.getComponent(3);
                    // JLabel chiPhiDiChuyen = (JLabel) diaDiemItem.getComponent(4);
                    JTextField chiPhiDiChuyen = (JTextField) diaDiemItem.getComponent(4);
    
                    // Tính chi phí dịch vụ
                    long chiPhiThamQuanValue = TextUtils.getFirstNumber(chiPhiThamQuan.getText());
                    long chiPhiDiChuyenValue = TextUtils.getFirstNumber(chiPhiDiChuyen.getText());
                    tongChiPhiNgay += chiPhiThamQuanValue + chiPhiDiChuyenValue;

                    diaDiemThamQuanBUS.insert(
                        new DiaDiemThamQuanDTO(
                            maChiTietKeHoachTour, 
                            diaDanhBUS.getIdByName(cbDiaDiem.getSelectedItem().toString()), 
                            moTa.getText(), 
                            phuongTienBUS.getIdByName(cbPhuongTien.getSelectedItem().toString()), 
                            TextUtils.getFirstNumber(chiPhiThamQuan.getText()),
                            // Long.parseLong(chiPhiThamQuan.getText()),
                            // Long.parseLong(chiPhiDiChuyen.getText())
                            TextUtils.getFirstNumber(chiPhiDiChuyen.getText())
                        )
                    );
                }
    
                // === Lưu Khách sạn ===
                JPanel khachSanPanel = (JPanel) panelLichTrinhNgay.getComponent(2);
                for (int j = 0; j < khachSanPanel.getComponentCount(); j++) {
                    JPanel ksItem = (JPanel) khachSanPanel.getComponent(j);
                    JComboBox cbKhachSan = (JComboBox) ksItem.getComponent(0);
                    // JLabel chiPhiKhachSan = (JLabel) ksItem.getComponent(1);
                    JTextField chiPhiKhachSan = (JTextField) ksItem.getComponent(1);

                    // Tính chi phí dịch vụ
                    long chiPhiKhachSanValue = TextUtils.getFirstNumber(chiPhiKhachSan.getText());
                    tongChiPhiNgay += chiPhiKhachSanValue;

                    khachSanNghiNgoiBUS.insert(
                        new KhachSanNghiNgoiDTO (
                            maChiTietKeHoachTour, 
                            khachSanBUS.getIdByName(cbKhachSan.getSelectedItem().toString()), 
                            // Long.parseLong(chiPhiKhachSan.getText())
                            TextUtils.getFirstNumber(chiPhiKhachSan.getText())
                        )
                    );
                }
    
                // === Lưu Ăn uống ===
                for (int k = 0; k < 3; k++) { // Bữa sáng, trưa, tối
                    JPanel buaAn = (JPanel) panelAn.getComponent(k);
                    JComboBox cbNhaHang = (JComboBox) buaAn.getComponent(0);
                    // JLabel chiPhi = (JLabel) buaAn.getComponent(1);
                    JTextField chiPhi = (JTextField) buaAn.getComponent(1);
                    JTextField moTa = (JTextField) buaAn.getComponent(2);

                    // Tính chi phí dịch vụ
                    long chiPhiBuoiAnValue = TextUtils.getFirstNumber(chiPhi.getText());
                    tongChiPhiNgay += chiPhiBuoiAnValue;

                    buoiAnBUS.insert(
                        new BuoiAnDTO(
                            maChiTietKeHoachTour, 
                            buoiAnBUS.getLoaiBuaAn(k + 1), 
                            nhaHangBUS.getIdByName(cbNhaHang.getSelectedItem().toString()), 
                            // Double.parseDouble(chiPhi.getText()), 
                            TextUtils.getFirstNumber(chiPhi.getText()),
                            moTa.getText()
                        )
                    );
                }
            
                // Cập nhật chi phí ngày
                chiTietKeHoachTourBUS.update(
                    new ChiTietKeHoachTourDTO(
                        maChiTietKeHoachTour,
                        maKeHoachTour, 
                        startDate.toLocalDate().plusDays(i + 1), 
                        tieuDe,
                        tongChiPhiNgay
                    )
                );

                // tính toán chi phí tour
                chiPhiTour += tongChiPhiNgay;
            }

            // Cập nhật chi phí tour
            System.out.println("Chi phí tour: " + chiPhiTour);
            keHoachTourForm.updateTour(
                new KeHoachTourDTO(
                    maKeHoachTour, 
                    maTour, 
                    startDate.toLocalDate(), 
                    endDate.toLocalDate(), 
                    0,
                    soLuongToiDa, 
                    chiPhiTour, 
                    trangThai
                )
            );
            JOptionPane.showMessageDialog(this, "Lưu kế hoạch tour thành công!");
            this.dispose();
    
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi lưu kế hoạch tour: " + e.getMessage());
        }
    }
    
    public void updateKeHoachTour() {
        // keHoachTourDTO.setMaTour(Integer.parseInt(cbTour.getSelectedItem().toString().split(" - ")[0].trim()));
        keHoachTourDTO.setThoiGianBD(DateUtils.dateToLocalDate(dateStart.getDate()));
        keHoachTourDTO.setThoiGianKT(DateUtils.dateToLocalDate(dateStart.getDate()));
        keHoachTourDTO.setSlDaDat(Integer.parseInt(tfSoLuongDaDat.getText().trim()));
        keHoachTourDTO.setSlToiDa(Integer.parseInt(tfSoLuongToiDa.getText().trim()));
        // keHoachTourDTO.setTongChiPhi(Float.parseFloat(tfTongChiPhi.getText().trim()));
        keHoachTourDTO.setTrangThai((TrangThaiKeHoachTour) cbtrangThai.getSelectedItem());

        // Cập nhật kế hoạch tour
        // keHoachTourForm.updateTour(keHoachTourDTO);

        long tongChiPhiTour = 0;
        // Cập nhật lịch trình
        ArrayList<ChiTietKeHoachTourDTO> dsChiTietKeHoachTour = chiTietKeHoachTourBUS.getChiTietKeHoachTourByMaKeHoachTour(keHoachTourDTO.getMaKHTour());
        int soNgayTour = dsChiTietKeHoachTour.size();
        for (int i = 0; i < soNgayTour; i++) {
            ChiTietKeHoachTourDTO chiTietKeHoachTour = dsChiTietKeHoachTour.get(i);
            int maChiTietKeHoachTour = chiTietKeHoachTour.getMaChiTietKeHoachTour();
            
            JPanel panelLichTrinhNgay = (JPanel) panelLichTrinh.getComponent(i);
            JPanel panelAn = (JPanel) panelAnUong.getComponent(i);

            // Lấy title ngày
            JTextField titleField = (JTextField) ((JPanel) panelLichTrinhNgay.getComponent(0)).getComponent(0);
            String tieuDe = titleField.getText().trim();

            // tinh toán chi phí
            long tongChiPhiNgay = 0;

            // cập nhật địa điểm tham quan
            JPanel diaDiemPanel = (JPanel) panelLichTrinhNgay.getComponent(1);
            ArrayList<DiaDiemThamQuanDTO> dsDiaDiemThamQuan = diaDiemThamQuanBUS.getDiaDiemThamQuanByMaChiTietKeHoachTour(maChiTietKeHoachTour);
            for (int j = 0; j < diaDiemPanel.getComponentCount(); j++) {
                JPanel diaDiemItem = (JPanel) diaDiemPanel.getComponent(j);
                JComboBox cbDiaDiem = (JComboBox) diaDiemItem.getComponent(0);
                JTextField chiPhiThamQuan = (JTextField) diaDiemItem.getComponent(1);
                JTextField moTa = (JTextField) diaDiemItem.getComponent(2);
                JComboBox cbPhuongTien = (JComboBox) diaDiemItem.getComponent(3);
                // JLabel chiPhiDiChuyen = (JLabel) diaDiemItem.getComponent(4);
                JTextField chiPhiDiChuyen = (JTextField) diaDiemItem.getComponent(4);

                // Tính chi phí dịch vụ
                long chiPhiThamQuanValue = TextUtils.getFirstNumber(chiPhiThamQuan.getText());
                long chiPhiDiChuyenValue = TextUtils.getFirstNumber(chiPhiDiChuyen.getText());
                tongChiPhiNgay += chiPhiThamQuanValue + chiPhiDiChuyenValue;

                // cập nhật địa điểm tham quan
                diaDiemThamQuanBUS.update(
                    new DiaDiemThamQuanDTO(
                        dsDiaDiemThamQuan.get(j).getMaDiaDiemThamQuan(),
                        maChiTietKeHoachTour, 
                        diaDanhBUS.getIdByName(cbDiaDiem.getSelectedItem().toString()), 
                        moTa.getText(), 
                        phuongTienBUS.getIdByName(cbPhuongTien.getSelectedItem().toString()), 
                        TextUtils.getFirstNumber(chiPhiThamQuan.getText()),
                        // Long.parseLong(chiPhiThamQuan.getText()),
                        // Long.parseLong(chiPhiDiChuyen.getText()),
                        TextUtils.getFirstNumber(chiPhiDiChuyen.getText())
                    )
                );
            }

            // cập nhật khách sạn
            JPanel khachSanPanel = (JPanel) panelLichTrinhNgay.getComponent(2);
            ArrayList<KhachSanNghiNgoiDTO> dsKhachSanNghiNgoi = khachSanNghiNgoiBUS.getKhachSanNghiNgoiByMaChiTietKeHoachTour(maChiTietKeHoachTour);
            for (int j = 0; j < khachSanPanel.getComponentCount(); j++) {
                JPanel ksItem = (JPanel) khachSanPanel.getComponent(j);
                JComboBox cbKhachSan = (JComboBox) ksItem.getComponent(0);
                // JLabel chiPhiKhachSan = (JLabel) ksItem.getComponent(1);
                JTextField chiPhiKhachSan = (JTextField) ksItem.getComponent(1);

                // Tính chi phí dịch vụ
                long chiPhiKhachSanValue = TextUtils.getFirstNumber(chiPhiKhachSan.getText());
                tongChiPhiNgay += chiPhiKhachSanValue;

                // cập nhật khách sạn
                khachSanNghiNgoiBUS.update(
                    new KhachSanNghiNgoiDTO(
                        dsKhachSanNghiNgoi.get(j).getMaKhachSanNghiNgoi(),
                        maChiTietKeHoachTour, 
                        khachSanBUS.getIdByName(cbKhachSan.getSelectedItem().toString()), 
                        // Long.parseLong(chiPhiKhachSan.getText())
                        TextUtils.getFirstNumber(chiPhiKhachSan.getText())
                    )
                );
            }

            // cập nhật ăn uống
            ArrayList<BuoiAnDTO> dsBuoiAn = buoiAnBUS.getBuoiAnByMaChiTietKeHoachTour(maChiTietKeHoachTour);
            for (int k = 0; k < 3; k++) { // Bữa sáng, trưa, tối
                JPanel buaAn = (JPanel) panelAn.getComponent(k);
                JComboBox cbNhaHang = (JComboBox) buaAn.getComponent(0);
                // JLabel chiPhi = (JLabel) buaAn.getComponent(1);
                JTextField chiPhi = (JTextField) buaAn.getComponent(1);
                JTextField moTa = (JTextField) buaAn.getComponent(2);

                // Tính chi phí dịch vụ
                long chiPhiBuoiAnValue = TextUtils.getFirstNumber(chiPhi.getText());
                tongChiPhiNgay += chiPhiBuoiAnValue;

                // cập nhật ăn uống
                buoiAnBUS.update(
                    new BuoiAnDTO(
                        dsBuoiAn.get(k).getMaBuoiAn(),
                        maChiTietKeHoachTour, 
                        buoiAnBUS.getLoaiBuaAn(k + 1), 
                        nhaHangBUS.getIdByName(cbNhaHang.getSelectedItem().toString()), 
                        // Double.parseDouble(chiPhi.getText()), 
                        TextUtils.getFirstNumber(chiPhi.getText()),
                        moTa.getText()
                    )
                );
            }

            // Cập nhật chi phí ngày
            chiTietKeHoachTourBUS.update(
                new ChiTietKeHoachTourDTO(
                    maChiTietKeHoachTour,
                    keHoachTourDTO.getMaKHTour(), 
                    DateUtils.dateToLocalDate(dateStart.getDate()).plusDays(i + 1), 
                    tieuDe,
                    tongChiPhiNgay
                )
            );

            // tính toán chi phí tour
            tongChiPhiTour += tongChiPhiNgay;
        }
        
        // Cập nhật chi phí tour
        keHoachTourDTO.setTongChiPhi(tongChiPhiTour);
        keHoachTourForm.updateTour(keHoachTourDTO);

        System.out.println("Chi phí tour: " + tongChiPhiTour);
        keHoachTourBUS.updateKeHoachTour(
            new KeHoachTourDTO(
                keHoachTourDTO.getMaKHTour(), 
                keHoachTourDTO.getMaTour(), 
                keHoachTourDTO.getThoiGianBD(), 
                keHoachTourDTO.getThoiGianKT(), 
                keHoachTourDTO.getSlDaDat(),
                keHoachTourDTO.getSlToiDa(), 
                // keHoachTourDTO.getTongChiPhi(), 
                tongChiPhiTour,
                keHoachTourDTO.getTrangThai()
            )
        );

        // Hiển thị thông báo thành công
        JOptionPane.showMessageDialog(this, "Cập nhật kế hoạch tour thành công!");
        this.dispose();
    }

    public void loadDataFormKeHoachTour(KeHoachTourDTO keHoachTour) {
        int maKeHoachTour = keHoachTour.getMaKHTour();
        int maTour = keHoachTour.getMaTour();
        // Load thông tin kế hoạch tour vào form
        cbTour.setSelectedItem(maTour + " - " + tourBUS.getTourById(maTour).getTenTour());

        // System.out.println("Mã tour: " + keHoachTour.getMaTour());
        // System.out.println("Tour: " + tourBUS.getTourById(keHoachTour.getMaTour()).getTenTour());
        dateStart.setDate(Date.valueOf(keHoachTour.getThoiGianBD()));
        // System.out.println("Ngày bắt đầu: " + keHoachTour.getThoiGianBD());
        // System.out.println("Ngày kết thúc: " + keHoachTour.getThoiGianKT());
        dateEnd.setDate(Date.valueOf(keHoachTour.getThoiGianKT()));
        tfSoLuongDaDat.setText(String.valueOf(keHoachTour.getSlDaDat()));
        tfSoLuongToiDa.setText(String.valueOf(keHoachTour.getSlToiDa()));
        tfTongChiPhi.setText(String.valueOf(keHoachTour.getTongChiPhi()));
        cbtrangThai.setSelectedItem(keHoachTour.getTrangThai());
    }

    public void loadDataFormDiaDiem(JPanel diaDiemPanel, ArrayList<DiaDiemThamQuanDTO> listDiaDiemThamQuan) {
        for (DiaDiemThamQuanDTO diaDiem : listDiaDiemThamQuan) {
                JPanel diaDiemItem = createFormDiaDiem();
                JComboBox cbDiaDiem = (JComboBox) diaDiemItem.getComponent(0);
                JTextField chiPhiThamQuan = (JTextField) diaDiemItem.getComponent(1);
                JTextField moTa = (JTextField) diaDiemItem.getComponent(2);
                JComboBox cbPhuongTien = (JComboBox) diaDiemItem.getComponent(3);
                // JLabel chiPhiDiChuyen = (JLabel) diaDiemItem.getComponent(4);
                JTextField chiPhiDiChuyen = (JTextField) diaDiemItem.getComponent(4);

                cbDiaDiem.setSelectedItem(diaDanhBUS.getNameById(diaDiem.getMaDiaDanh()));
                chiPhiThamQuan.setText("Chi phí: " + diaDiem.getChiPhiThamQuan() + " VNĐ");
                moTa.setText(diaDiem.getMoTaHoatDong());
                cbPhuongTien.setSelectedItem(phuongTienBUS.getNameById(diaDiem.getMaPhuongTienDiChuyen()));
                chiPhiDiChuyen.setText("Chi phí: " + diaDiem.getChiPhiDiChuyen() + " VNĐ");
                diaDiemPanel.add(diaDiemItem);
            }
    }

    public void loadDataFormKhachSan(JPanel khachSanPanel, ArrayList<KhachSanNghiNgoiDTO> listKhachSanNghiNgoi) {
        for (KhachSanNghiNgoiDTO khachSan : listKhachSanNghiNgoi) {
            JPanel khachSanItem = createFormKhachSan();
            JComboBox cbKhachSan = (JComboBox) khachSanItem.getComponent(0);
            // JLabel chiPhiKhachSan = (JLabel) khachSanItem.getComponent(1);
            JTextField chiPhiKhachSan = (JTextField) khachSanItem.getComponent(1);

            cbKhachSan.setSelectedItem(khachSanBUS.getNameById(khachSan.getMaKhachSan()));
            chiPhiKhachSan.setText("Chi phí: " + khachSan.getChiPhiKhachSan() + " VNĐ");
            khachSanPanel.add(khachSanItem);
        }
    }

    public void loadDataFormAnUong(JPanel anUongPanel, ArrayList<BuoiAnDTO> listBuoiAn) {
        for (int j = 0; j < 3; j++) { // Bữa sáng, trưa, tối
            JPanel buaAnPanel = (JPanel) anUongPanel.getComponent(j);
            JComboBox cbNhaHang = (JComboBox) buaAnPanel.getComponent(0);
            // JLabel chiPhi = (JLabel) buaAnPanel.getComponent(1);
            JTextField chiPhi = (JTextField) buaAnPanel.getComponent(1);
            JTextField moTa = (JTextField) buaAnPanel.getComponent(2);

            BuoiAnDTO buoiAn = listBuoiAn.get(j);
            cbNhaHang.setSelectedItem(nhaHangBUS.getNameById(buoiAn.getMaNhaHang()));
            chiPhi.setText("Chi phí: " + buoiAn.getChiPhi() + " VNĐ");
            moTa.setText(buoiAn.getMoTa());
        }
    }

    public void loadKeHoachTour(KeHoachTourDTO keHoachTour) {
        this.keHoachTourDTO = keHoachTour;
        
        loadDataFormKeHoachTour(keHoachTour);
        // int soNgayTour = tourBUS.getTourById(maKeHoachTour).getSoNgay();
        // Xoá các thành phần hiện tại trong panel
        panelLichTrinh.removeAll();
        panelAnUong.removeAll();

        // lấy thông tin chỉ tiết kế hoạch của tour
        ArrayList<ChiTietKeHoachTourDTO> allChiTietKeHoachTour = chiTietKeHoachTourBUS.getAllChiTietKeHoachTour();
        System.out.println("Tổng số chi tiết kế hoạch tour: " + allChiTietKeHoachTour.size());
        ArrayList<ChiTietKeHoachTourDTO> chiTietKeHoachTour = chiTietKeHoachTourBUS.getChiTietKeHoachTourByMaKeHoachTour(keHoachTour.getMaKHTour());
        System.out.println("Kế hoạch tour: " + keHoachTour);
        System.out.println("Chi tiết kế hoạch tour: " + chiTietKeHoachTour.size());
        // for (int i = 0; i < chiTietKeHoachTour.size(); i++) {
        //     ChiTietKeHoachTourDTO chiTiet = chiTietKeHoachTour.get(i);
        //     System.out.println("Mã chi tiết kế hoạch tour: " + chiTiet.getMaChiTietKeHoachTour());
        // }
        int soNgayTour = chiTietKeHoachTour.size();
        // System.out.println("Số ngày tour: " + soNgayTour);
        for (int i = 0; i < soNgayTour; i++) {
            ChiTietKeHoachTourDTO chiTiet = chiTietKeHoachTour.get(i);
            int maChiTietKeHoachTour = chiTiet.getMaChiTietKeHoachTour();
            // System.out.println("Mã chi tiết kế hoạch tour: " + maChiTietKeHoachTour);
            // Tạo panel cho lịch trình và ăn uống
            JPanel lichTrinhPanel = createLichTrinhPanel(i + 1);
            JPanel anUongPanel = createAnUongPanel(i + 1);

            // Lấy thông tin lịch trình và ăn uống từ cơ sở dữ liệu
            ArrayList<DiaDiemThamQuanDTO> listDiaDiemThamQuan = diaDiemThamQuanBUS.getDiaDiemThamQuanByMaChiTietKeHoachTour(maChiTietKeHoachTour);
            ArrayList<KhachSanNghiNgoiDTO> listKhachSanNghiNgoi = khachSanNghiNgoiBUS.getKhachSanNghiNgoiByMaChiTietKeHoachTour(maChiTietKeHoachTour);
            ArrayList<BuoiAnDTO> listBuoiAn = buoiAnBUS.getBuoiAnByMaChiTietKeHoachTour(maChiTietKeHoachTour);
            // System.out.println("Số địa điểm tham quan: " + listDiaDiemThamQuan.size());
            // System.out.println("Số khách sạn: " + listKhachSanNghiNgoi.size());
            // System.out.println("Số bữa ăn: " + listBuoiAn.size());

            // Thêm các thông tin vào panel
            JTextField titleField = (JTextField) ((JPanel) lichTrinhPanel.getComponent(0)).getComponent(0);
            titleField.setText(chiTiet.getMoTa());

            // Thêm địa điểm tham quan
            JPanel diaDiemPanel = (JPanel) lichTrinhPanel.getComponent(1);
            loadDataFormDiaDiem(diaDiemPanel, listDiaDiemThamQuan);

            // Thêm khách sạn nghỉ ngơi
            JPanel khachSanPanel = (JPanel) lichTrinhPanel.getComponent(2);
            loadDataFormKhachSan(khachSanPanel, listKhachSanNghiNgoi);

            // Thêm ăn uống
            loadDataFormAnUong(anUongPanel, listBuoiAn);

            // Thêm panel lịch trình và ăn uống vào panel chính
            panelLichTrinh.add(lichTrinhPanel);
            panelAnUong.add(anUongPanel);
        }
    
        // Cập nhật lại giao diện
        panelLichTrinh.revalidate();
        panelLichTrinh.repaint();
        panelAnUong.revalidate();
        panelAnUong.repaint();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneKeHoachTour = new gui.components.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        cbTour = new gui.components.CustomComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateStart = new com.toedter.calendar.JDateChooser();
        dateEnd = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfSoLuongDaDat = new javax.swing.JTextField();
        tfSoLuongToiDa = new javax.swing.JTextField();
        cbtrangThai = new gui.components.CustomComboBox();
        tfTongChiPhi = new javax.swing.JTextField();
        btnSave = new gui.components.MyButton();
        btnCancel = new gui.components.MyButton();
        scrollPanelChiTietKeHoachTour = new javax.swing.JScrollPane();
        panelChiTietKeHoachTour = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        panelLichTrinh = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        panelAnUong = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Loại tour");

        cbTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTourActionPerformed(evt);
            }
        });

        jLabel2.setText("Thời gian bắt đầu");

        jLabel3.setText("Thời gian kết thúc");

        dateEnd.setFocusable(false);

        jLabel4.setText("Số lượng đã đặt");

        jLabel5.setText("Số lượng tối đa");

        jLabel6.setText("Tổng chi phí");

        jLabel7.setText("Trạng thái");

        tfSoLuongDaDat.setFocusable(false);

        tfTongChiPhi.setFocusable(false);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneKeHoachTourLayout = new javax.swing.GroupLayout(paneKeHoachTour);
        paneKeHoachTour.setLayout(paneKeHoachTourLayout);
        paneKeHoachTourLayout.setHorizontalGroup(
            paneKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneKeHoachTourLayout.createSequentialGroup()
                .addGroup(paneKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneKeHoachTourLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(paneKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(paneKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(paneKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbTour, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateStart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfSoLuongDaDat)
                            .addComponent(tfSoLuongToiDa)
                            .addComponent(cbtrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfTongChiPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(paneKeHoachTourLayout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        paneKeHoachTourLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7});

        paneKeHoachTourLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbTour, cbtrangThai, dateEnd, dateStart, tfSoLuongDaDat, tfSoLuongToiDa, tfTongChiPhi});

        paneKeHoachTourLayout.setVerticalGroup(
            paneKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneKeHoachTourLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(paneKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTour, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(paneKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(paneKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(tfSoLuongDaDat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(paneKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(tfSoLuongToiDa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(tfTongChiPhi))
                .addGap(18, 18, 18)
                .addGroup(paneKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbtrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(paneKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        paneKeHoachTourLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7});

        paneKeHoachTourLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbTour, cbtrangThai, dateEnd, dateStart, tfSoLuongDaDat, tfSoLuongToiDa, tfTongChiPhi});

        scrollPanelChiTietKeHoachTour.setBackground(new java.awt.Color(255, 255, 255));

        panelChiTietKeHoachTour.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Lịch trình");

        javax.swing.GroupLayout panelLichTrinhLayout = new javax.swing.GroupLayout(panelLichTrinh);
        panelLichTrinh.setLayout(panelLichTrinhLayout);
        panelLichTrinhLayout.setHorizontalGroup(
            panelLichTrinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLichTrinhLayout.setVerticalGroup(
            panelLichTrinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Ăn uống");

        javax.swing.GroupLayout panelAnUongLayout = new javax.swing.GroupLayout(panelAnUong);
        panelAnUong.setLayout(panelAnUongLayout);
        panelAnUongLayout.setHorizontalGroup(
            panelAnUongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelAnUongLayout.setVerticalGroup(
            panelAnUongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelChiTietKeHoachTourLayout = new javax.swing.GroupLayout(panelChiTietKeHoachTour);
        panelChiTietKeHoachTour.setLayout(panelChiTietKeHoachTourLayout);
        panelChiTietKeHoachTourLayout.setHorizontalGroup(
            panelChiTietKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelChiTietKeHoachTourLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelChiTietKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelLichTrinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAnUong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelChiTietKeHoachTourLayout.setVerticalGroup(
            panelChiTietKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChiTietKeHoachTourLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLichTrinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAnUong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        scrollPanelChiTietKeHoachTour.setViewportView(panelChiTietKeHoachTour);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(paneKeHoachTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollPanelChiTietKeHoachTour)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneKeHoachTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPanelChiTietKeHoachTour))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTourActionPerformed
        createSchedule();
        initEndDate();
    }//GEN-LAST:event_cbTourActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        switch (action) {
            case INSERT:
                saveKeHoachTour();
                break;
            case UPDATE:
                updateKeHoachTour();
                break;
            default:
                throw new AssertionError();
        }
        dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        int result = JOptionPane.showConfirmDialog(
                getOwner(),
                "Bạn có chắc chắn muốn thoát?",
                "Xác nhận",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnCancelActionPerformed
    
    public void initializeValues() {
        try {
            // Thiết lập giá trị mặc định cho các trường
            cbTour.setSelectedIndex(0); // Chọn tour đầu tiên trong danh sách
            dateStart.setDate(java.sql.Date.valueOf(LocalDate.now())); // Ngày bắt đầu là ngày hiện tại
            dateEnd.setDate(java.sql.Date.valueOf(LocalDate.now().plusDays(1))); // Ngày kết thúc là ngày hôm sau
            tfSoLuongDaDat.setText("0"); // Số lượng đã đặt mặc định là 0
            tfSoLuongToiDa.setText("20"); // Số lượng tối đa mặc định là 20
            tfTongChiPhi.setText("0.0"); // Tổng chi phí mặc định là 0.0
            cbtrangThai.setSelectedItem(TrangThaiKeHoachTour.SAP_KHOI_HANH); // Trạng thái mặc định là "Chưa bắt đầu"
    
            // Tự động tạo lịch trình và cập nhật ngày kết thúc
            createSchedule();
            initEndDate();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi khởi tạo giá trị: " + e.getMessage());
        }
    }

    public void initializeSchedule() {
        try {
            // Lấy số ngày của tour đã chọn
            int soNgayTour = tourBUS.getTourById(Integer.parseInt(cbTour.getSelectedItem().toString().split(" - ")[0].trim())).getSoNgay();
    
            // Xóa các thành phần cũ
            panelLichTrinh.removeAll();
            panelAnUong.removeAll();
    
            // Tạo lịch trình mặc định cho từng ngày
            for (int i = 1; i <= soNgayTour; i++) {
                JPanel lichTrinhPanel = createLichTrinhPanel(i);
                JPanel anUongPanel = createAnUongPanel(i);
    
                // Thiết lập giá trị mặc định cho từng ngày
                JTextField titleField = (JTextField) ((JPanel) lichTrinhPanel.getComponent(0)).getComponent(0);
                titleField.setText("Ngày " + i + " - Lịch trình mặc định");
    
                JPanel diaDiemPanel = (JPanel) lichTrinhPanel.getComponent(1);
                JPanel diaDiemItem = (JPanel) diaDiemPanel.getComponent(0);
                JComboBox cbDiaDiem = (JComboBox) diaDiemItem.getComponent(0);
                JTextField chiPhiThamQuan = (JTextField) diaDiemItem.getComponent(1);
                JTextField moTa = (JTextField) diaDiemItem.getComponent(2);
                JComboBox cbPhuongTien = (JComboBox) diaDiemItem.getComponent(3);
    
                cbDiaDiem.setSelectedIndex(0); // Chọn địa điểm đầu tiên
                // chiPhiThamQuan.setText("100000"); // Chi phí tham quan mặc định
                moTa.setText("Tham quan địa điểm nổi bật");
                cbPhuongTien.setSelectedIndex(0); // Chọn phương tiện đầu tiên
    
                JPanel khachSanPanel = (JPanel) lichTrinhPanel.getComponent(2);
                JPanel khachSanItem = (JPanel) khachSanPanel.getComponent(0);
                JComboBox cbKhachSan = (JComboBox) khachSanItem.getComponent(0);
    
                cbKhachSan.setSelectedIndex(0); // Chọn khách sạn đầu tiên
    
                // Thiết lập giá trị mặc định cho ăn uống
                for (int k = 0; k < 3; k++) { // Bữa sáng, trưa, tối
                    JPanel buaAnPanel = (JPanel) anUongPanel.getComponent(k);
                    JComboBox cbNhaHang = (JComboBox) buaAnPanel.getComponent(0);
                    JTextField moTaBuaAn = (JTextField) buaAnPanel.getComponent(2);
    
                    cbNhaHang.setSelectedIndex(0); // Chọn nhà hàng đầu tiên
                    moTaBuaAn.setText("Bữa ăn tiêu chuẩn");
                }
    
                // Thêm các panel vào giao diện
                panelLichTrinh.add(lichTrinhPanel);
                panelAnUong.add(anUongPanel);
            }
    
            // Cập nhật giao diện
            panelLichTrinh.revalidate();
            panelLichTrinh.repaint();
            panelAnUong.revalidate();
            panelAnUong.repaint();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi khởi tạo lịch trình: " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.components.MyButton btnCancel;
    private gui.components.MyButton btnSave;
    private gui.components.CustomComboBox cbTour;
    private gui.components.CustomComboBox cbtrangThai;
    private com.toedter.calendar.JDateChooser dateEnd;
    private com.toedter.calendar.JDateChooser dateStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private gui.components.PanelBorder paneKeHoachTour;
    private javax.swing.JPanel panelAnUong;
    private javax.swing.JPanel panelChiTietKeHoachTour;
    private javax.swing.JPanel panelLichTrinh;
    private javax.swing.JScrollPane scrollPanelChiTietKeHoachTour;
    private javax.swing.JTextField tfSoLuongDaDat;
    private javax.swing.JTextField tfSoLuongToiDa;
    private javax.swing.JTextField tfTongChiPhi;
    // End of variables declaration//GEN-END:variables
}

