CREATE TABLE Tour (
    maTour INT AUTO_INCREMENT PRIMARY KEY,
    tenTour VARCHAR(255),
    gia FLOAT,
    tinhTrang VARCHAR(50),
    moTa TEXT,
    diemKhoiHanh VARCHAR(100),
    diemDen VARCHAR(100),
    loaiTour VARCHAR(100),
    soNgay INT,
    soDem INT
);

INSERT INTO tour (maTour, tenTour, gia, tinhTrang, moTa, diemKhoiHanh, diemDen, loaiTour, soNgay, soDem)
VALUES
('T001', 'Tour Hà Nội - Hạ Long', 1500000, 'Đang mở', 'Tham quan Vịnh Hạ Long 2 ngày 1 đêm', 'Hà Nội', 'Hạ Long', 'Nội địa', 2, 1),
('T002', 'Tour Đà Nẵng - Hội An', 2000000, 'Đã đóng', 'Khám phá phố cổ Hội An', 'Đà Nẵng', 'Hội An', 'Nội địa', 3, 2),
('T003', 'Tour Sài Gòn - Phú Quốc', 3500000, 'Đang mở', 'Tham quan đảo Phú Quốc', 'TP.HCM', 'Phú Quốc', 'Nội địa', 4, 3),
('T004', 'Tour Hà Nội - Bangkok', 5500000, 'Đang mở', 'Du lịch Thái Lan trọn gói', 'Hà Nội', 'Bangkok', 'Quốc tế', 5, 4),
('T005', 'Tour Huế - Đà Lạt', 2800000, 'Đã đóng', 'Hành trình mộng mơ tại thành phố hoa', 'Huế', 'Đà Lạt', 'Nội địa', 3, 2);
