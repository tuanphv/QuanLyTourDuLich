package gui.dialog;

import bus.BuoiAnBUS;
import bus.ChiTietKeHoachTourBUS;
import java.awt.BorderLayout;
import java.awt.Color;
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
import utils.DateUtils;

public class KeHoachTour extends javax.swing.JDialog {
    private boolean  save;

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

    // SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
  
    public KeHoachTour(java.awt.Frame parent) {
        super(parent, "Thêm kế hoạch tour", true);
        initComponents();


        dateStart.setDateFormatString("dd-MM-yyyy");
        dateEnd.setDateFormatString("dd-MM-yyyy");

        scrollPanelChiTietKeHoachTour.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPanelChiTietKeHoachTour.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // panelChiTietKeHoachTour.setLayout(new BoxLayout(panelChiTietKeHoachTour, BoxLayout.Y_AXIS));
        panelLichTrinh.setLayout(new BoxLayout(panelLichTrinh, BoxLayout.Y_AXIS));
        panelAnUong.setLayout(new BoxLayout(panelAnUong, BoxLayout.Y_AXIS));

        // lấy danh sách dữ liệu nhà hàng, khách sạn, phương tiện
        listNhaHang = nhaHangBUS.getListRestaurant();
        listDiaDanh = diaDanhBUS.getDsDiaDanh();
        listPhuongTien = phuongTienBUS.getListVehicle();
        listKhachSan = khachSanBUS.getListHotel();
        loadComboBox();

        dateStart.addPropertyChangeListener("date", evt -> {
            initEndDate();
        });
        cbTour.addPropertyChangeListener("date", evt -> {
            initEndDate();
        });

        // pack();
        setLocationRelativeTo(null);

        initializeValues(); // Khởi tạo giá trị mặc định
        initializeSchedule(); // Khởi tạo lịch trình mặc định
    }

    public boolean isSave() {
        return this.save;
    }

    public void initEndDate() {
        // Lấy số ngày của tour đã chọn
        java.util.Date startDate = dateStart.getDate();
        if (startDate == null) {
            System.err.println("Ngày bắt đầu không hợp lệ");
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
        
        // panelChiTietKeHoachTour.revalidate();
        // panelChiTietKeHoachTour.repaint();

        // JOptionPane.showMessageDialog(null, "Success!");
    }

    public JPanel createLichTrinhPanel(int dayNumber) {
        JPanel dayPanel = new JPanel();
        dayPanel.setLayout(new BoxLayout(dayPanel, BoxLayout.Y_AXIS));
        dayPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            "Ngày " + dayNumber,
            TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));

        // Tiêu đề ngày
        JPanel titlePanel = new JPanel(new BorderLayout());
        // JPanel titlePanel = new JPanel();
        // titlePanel.add(new JLabel("Ngày " + dayNumber), BorderLayout.WEST);
        JTextField titleField = new JTextField();
        TitledBorder titleBorder = BorderFactory.createTitledBorder("Tiêu đề");
        titleBorder.setTitleFont(new Font("Arial", Font.BOLD, 14));
        titleField.setBorder(titleBorder);
        titlePanel.add(titleField, BorderLayout.CENTER);
        titlePanel.add(titleField);
        dayPanel.add(titlePanel);

        // Panel chứa các địa điểm
        JPanel locationPanel = new JPanel();
        locationPanel.setLayout(new BoxLayout(locationPanel, BoxLayout.Y_AXIS));
        locationPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            "Địa điểm tham quan",
            TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));

        // thêm 1 địa điểm mặc định
        locationPanel.add(createFormDiaDiem());
        locationPanel.revalidate();
        locationPanel.repaint();

        // Panel chứa khách sạn nghỉ ngơi
        JPanel hotelPanel = new JPanel();
        hotelPanel.setLayout(new BoxLayout(hotelPanel, BoxLayout.Y_AXIS));
        hotelPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            "Khách sạn nghỉ ngơi",
            TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));

        // thêm 1 khách sạn mặc định
        hotelPanel.add(createFormKhachSan());
        hotelPanel.revalidate();
        hotelPanel.repaint();   

        // Nút thêm địa điểm
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton addLocationBtn = new JButton("➕ Thêm địa điểm");
        JButton addHotelBtn = new JButton("➕ Thêm khách sạn");
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

        return dayPanel;
    }

    public JPanel createAnUongPanel(int dayNumber) {
        JPanel anUongPanel = new JPanel();
        anUongPanel.setLayout(new BoxLayout(anUongPanel, BoxLayout.Y_AXIS));
        anUongPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            "Ngày " + dayNumber,
            TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));

        // Lấy danh sách nhà hàng
        ArrayList<String> listTenNhaHang = new ArrayList<>();
        for (NhaHangDTO nhaHang : listNhaHang) {
            listTenNhaHang.add(nhaHang.getTenNhaHang());
        }
        // JComboBox comboBoxNhaHang = new JComboBox(listTenNhaHang.toArray(new String[0]));

        // Thêm các thành phần khác vào anUongPanel nếu cần
        JPanel buaSangPanel = new JPanel();
        buaSangPanel.setLayout(new BoxLayout(buaSangPanel, BoxLayout.Y_AXIS));
        buaSangPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            "Bữa sáng",
            TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));
        JComboBox comboBoxBuaSang = new JComboBox(listTenNhaHang.toArray(new String[0]));

        // comboBoxBuaSang.setModel(new DefaultComboBoxModel<>(new String[] { "Bánh mì", "Phở", "Cơm tấm" }));
        JTextField chiPhiBuaSang = new JTextField();
        chiPhiBuaSang.setBorder(BorderFactory.createTitledBorder("Chi phí"));
        JTextField moTaBuaSang = new JTextField();
        moTaBuaSang.setBorder(BorderFactory.createTitledBorder("Mô tả"));
        buaSangPanel.add(comboBoxBuaSang);
        buaSangPanel.add(chiPhiBuaSang);
        buaSangPanel.add(moTaBuaSang);

        JPanel buaTruaPanel = new JPanel();
        buaTruaPanel.setLayout(new BoxLayout(buaTruaPanel, BoxLayout.Y_AXIS));
        buaTruaPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            "Bữa trưa",
            TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));
        JComboBox comboBoxBuaTrua = new JComboBox(listTenNhaHang.toArray(new String[0]));
        
        // comboBoxBuaTrua.setModel(new DefaultComboBoxModel<>(new String[] { "Bánh mì", "Phở", "Cơm tấm" }));
        JTextField chiPhiBuaTrua = new JTextField();
        chiPhiBuaTrua.setBorder(BorderFactory.createTitledBorder("Chi phí"));
        JTextField moTaBuaTrua = new JTextField();
        moTaBuaTrua.setBorder(BorderFactory.createTitledBorder("Mô tả"));
        buaTruaPanel.add(comboBoxBuaTrua);
        buaTruaPanel.add(chiPhiBuaTrua);
        buaTruaPanel.add(moTaBuaTrua);

        JPanel buaToiPanel = new JPanel();
        buaToiPanel.setLayout(new BoxLayout(buaToiPanel, BoxLayout.Y_AXIS));
        buaToiPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            "Bữa tối",
            TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));
        JComboBox comboBoxBuaToi = new JComboBox(listTenNhaHang.toArray(new String[0]));
        
        // comboBoxBuaToi.setModel(new DefaultComboBoxModel<>(new String[] { "Bánh mì", "Phở", "Cơm tấm" }));
        JTextField chiPhiBuaToi = new JTextField();
        chiPhiBuaToi.setBorder(BorderFactory.createTitledBorder("Chi phí"));
        JTextField moTaBuaToi = new JTextField();
        moTaBuaToi.setBorder(BorderFactory.createTitledBorder("Mô tả"));
        buaToiPanel.add(comboBoxBuaToi);
        buaToiPanel.add(chiPhiBuaToi);
        buaToiPanel.add(moTaBuaToi);

        anUongPanel.add(buaSangPanel);
        anUongPanel.add(buaTruaPanel);
        anUongPanel.add(buaToiPanel);

        return anUongPanel;
    }

    public JPanel createFormDiaDiem() {
        JPanel diaDiemPanel = new JPanel();
        diaDiemPanel.setLayout(new BoxLayout(diaDiemPanel, BoxLayout.Y_AXIS));
        diaDiemPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            "Địa điểm",
            TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));

        // Lấy danh sách địa điểm
        ArrayList<String> listTenDiaDiem = new ArrayList<>();
        for (DiaDanhDTO diaDanh : listDiaDanh) {
            listTenDiaDiem.add(diaDanh.getTenDD());
        }
        JComboBox<String> diaDiemComboBox = new JComboBox<>(listTenDiaDiem.toArray(new String[0]));
        diaDiemPanel.add(diaDiemComboBox);

        JTextField tfChiPhiThamQuan = new JTextField();
        tfChiPhiThamQuan.setBorder(BorderFactory.createTitledBorder("Chi phí tham quan"));
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
        JComboBox<String> phuongTienComboBox = new JComboBox<>(listTenPhuongTien.toArray(new String[0]));
        // phuongTienComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Máy bay", "Xe khách", "Tàu hỏa" }));
        phuongTienComboBox.setBorder(BorderFactory.createTitledBorder("Phương tiện di chuyển"));
        diaDiemPanel.add(phuongTienComboBox);
        
        JTextField tfChiPhiDiChuyen = new JTextField();
        tfChiPhiDiChuyen.setBorder(BorderFactory.createTitledBorder("Chi phí di chuyển"));
        diaDiemPanel.add(tfChiPhiDiChuyen);

        return diaDiemPanel;
    }

    public JPanel createFormKhachSan() {
        JPanel khachSanPanel = new JPanel();
        khachSanPanel.setLayout(new BoxLayout(khachSanPanel, BoxLayout.Y_AXIS));
        khachSanPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            "Khách sạn",
            TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));

        // Lấy danh sách khách sạn
        ArrayList<String> listTenKhachSan = new ArrayList<>();
        for (KhachSanDTO khachSan : listKhachSan) {
            listTenKhachSan.add(khachSan.getTenKhachSan());
        }
        JComboBox<String> khachSanComboBox = new JComboBox<>(listTenKhachSan.toArray(new String[0]));
        khachSanPanel.add(khachSanComboBox);

        JTextField tfChiPhi = new JTextField();
        tfChiPhi.setBorder(BorderFactory.createTitledBorder("Chi phí"));
        khachSanPanel.add(tfChiPhi);

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
            float tongChiPhi = Float.parseFloat(tfTongChiPhi.getText().trim());
            TrangThaiKeHoachTour trangThai = (TrangThaiKeHoachTour) cbtrangThai.getSelectedItem();
    
            // === LƯU THÔNG TIN KẾ HOẠCH TOUR ===
            int maKeHoachTour = keHoachTourBUS.addKeHoachTour(
                new KeHoachTourDTO(
                    maTour, 
                    startDate.toLocalDate(), 
                    endDate.toLocalDate(), 
                    // soLuongDaDat, 
                    0,
                    soLuongToiDa, 
                    tongChiPhi, 
                    trangThai
                )
            );
    
            // === LƯU LỊCH TRÌNH VÀ ĂN UỐNG THEO NGÀY ===
            int soNgayTour = tourBUS.getTourById(maTour).getSoNgay();
    
            for (int i = 0; i < soNgayTour; i++) {
                int maChiTietKeHoachTour = chiTietKeHoachTourBUS.insert(
                    new ChiTietKeHoachTourDTO(
                        maKeHoachTour, 
                        startDate.toLocalDate().plusDays(i + 1),
                        0
                    )
                );
                // chưa xử lí chi phí ngày

                JPanel panelLichTrinhNgay = (JPanel) panelLichTrinh.getComponent(i);
                JPanel panelAn = (JPanel) panelAnUong.getComponent(i);
    
                // Lấy title ngày
                JTextField titleField = (JTextField) ((JPanel) panelLichTrinhNgay.getComponent(0)).getComponent(0);
                String tieuDe = titleField.getText().trim();
    
                // === Lưu Địa điểm ===
                JPanel diaDiemPanel = (JPanel) panelLichTrinhNgay.getComponent(1);
                for (int j = 0; j < diaDiemPanel.getComponentCount(); j++) {
                    JPanel diaDiemItem = (JPanel) diaDiemPanel.getComponent(j);
                    JComboBox cbDiaDiem = (JComboBox) diaDiemItem.getComponent(0);
                    JTextField chiPhiThamQuan = (JTextField) diaDiemItem.getComponent(1);
                    JTextField moTa = (JTextField) diaDiemItem.getComponent(2);
                    JComboBox cbPhuongTien = (JComboBox) diaDiemItem.getComponent(3);
                    JTextField chiPhiDiChuyen = (JTextField) diaDiemItem.getComponent(4);
    
                    diaDiemThamQuanBUS.insert(
                        new DiaDiemThamQuanDTO(
                            maChiTietKeHoachTour, 
                            diaDanhBUS.getIdByName(cbDiaDiem.getSelectedItem().toString()), 
                            moTa.getText(), 
                            phuongTienBUS.getIdByName(cbPhuongTien.getSelectedItem().toString()), 
                            Long.parseLong(chiPhiThamQuan.getText()),
                            Long.parseLong(chiPhiDiChuyen.getText())
                        )
                    );
                }
    
                // === Lưu Khách sạn ===
                JPanel khachSanPanel = (JPanel) panelLichTrinhNgay.getComponent(2);
                for (int j = 0; j < khachSanPanel.getComponentCount(); j++) {
                    JPanel ksItem = (JPanel) khachSanPanel.getComponent(j);
                    JComboBox cbKhachSan = (JComboBox) ksItem.getComponent(0);
                    JTextField chiPhiKhachSan = (JTextField) ksItem.getComponent(1);
                    khachSanNghiNgoiBUS.insert(
                        new KhachSanNghiNgoiDTO (
                            maChiTietKeHoachTour, 
                            khachSanBUS.getIdByName(cbKhachSan.getSelectedItem().toString()), 
                            Long.parseLong(chiPhiKhachSan.getText())
                        )
                    );
                }
    
                // === Lưu Ăn uống ===
                for (int k = 0; k < 3; k++) { // Bữa sáng, trưa, tối
                    JPanel buaAn = (JPanel) panelAn.getComponent(k);
                    JComboBox cbNhaHang = (JComboBox) buaAn.getComponent(0);
                    JTextField chiPhi = (JTextField) buaAn.getComponent(1);
                    JTextField moTa = (JTextField) buaAn.getComponent(2);
                    buoiAnBUS.insert(
                        new BuoiAnDTO(
                            maChiTietKeHoachTour, 
                            buoiAnBUS.getLoaiBuaAn(k + 1), 
                            nhaHangBUS.getIdByName(cbNhaHang.getSelectedItem().toString()), 
                            Double.parseDouble(chiPhi.getText()), 
                            moTa.getText()
                        )
                    );
                }
            }
            JOptionPane.showMessageDialog(this, "Lưu kế hoạch tour thành công!");
            this.dispose();
    
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi lưu kế hoạch tour: " + e.getMessage());
        }
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

        jLabel4.setText("Số lượng đã đặt");

        jLabel5.setText("Số lượng tối đa");

        jLabel6.setText("Tổng chi phí");

        jLabel7.setText("Trạng thái");

        tfSoLuongDaDat.setEnabled(false);

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

        paneKeHoachTourLayout.setVerticalGroup(
            paneKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneKeHoachTourLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(paneKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTour, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(paneKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateStart, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
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

        paneKeHoachTourLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7});

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
            .addGap(0, 383, Short.MAX_VALUE)
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
            .addGap(0, 429, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelChiTietKeHoachTourLayout = new javax.swing.GroupLayout(panelChiTietKeHoachTour);
        panelChiTietKeHoachTour.setLayout(panelChiTietKeHoachTourLayout);
        panelChiTietKeHoachTourLayout.setHorizontalGroup(
            panelChiTietKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChiTietKeHoachTourLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelChiTietKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelChiTietKeHoachTourLayout.createSequentialGroup()
                        .addComponent(panelAnUong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelChiTietKeHoachTourLayout.createSequentialGroup()
                        .addGroup(panelChiTietKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                            .addComponent(panelLichTrinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5))))
        );
        panelChiTietKeHoachTourLayout.setVerticalGroup(
            panelChiTietKeHoachTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChiTietKeHoachTourLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLichTrinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
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
        save = true;
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
                JTextField chiPhiDiChuyen = (JTextField) diaDiemItem.getComponent(4);
    
                cbDiaDiem.setSelectedIndex(0); // Chọn địa điểm đầu tiên
                chiPhiThamQuan.setText("100000"); // Chi phí tham quan mặc định
                moTa.setText("Tham quan địa điểm nổi bật");
                cbPhuongTien.setSelectedIndex(0); // Chọn phương tiện đầu tiên
                chiPhiDiChuyen.setText("50000"); // Chi phí di chuyển mặc định
    
                JPanel khachSanPanel = (JPanel) lichTrinhPanel.getComponent(2);
                JPanel khachSanItem = (JPanel) khachSanPanel.getComponent(0);
                JComboBox cbKhachSan = (JComboBox) khachSanItem.getComponent(0);
                JTextField chiPhiKhachSan = (JTextField) khachSanItem.getComponent(1);
    
                cbKhachSan.setSelectedIndex(0); // Chọn khách sạn đầu tiên
                chiPhiKhachSan.setText("300000"); // Chi phí khách sạn mặc định
    
                // Thiết lập giá trị mặc định cho ăn uống
                for (int k = 0; k < 3; k++) { // Bữa sáng, trưa, tối
                    JPanel buaAnPanel = (JPanel) anUongPanel.getComponent(k);
                    JComboBox cbNhaHang = (JComboBox) buaAnPanel.getComponent(0);
                    JTextField chiPhi = (JTextField) buaAnPanel.getComponent(1);
                    JTextField moTaBuaAn = (JTextField) buaAnPanel.getComponent(2);
    
                    cbNhaHang.setSelectedIndex(0); // Chọn nhà hàng đầu tiên
                    chiPhi.setText("50000"); // Chi phí ăn uống mặc định
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


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KeHoachTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KeHoachTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KeHoachTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KeHoachTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                KeHoachTour dialog = new KeHoachTour(new javax.swing.JFrame());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
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
