-- Drop database cũ (nếu có)
DROP DATABASE IF EXISTS quanlytourdulich;

-- Tạo database 
create database quanlytourdulich;

-- Tạo các bảng
use quanlytourdulich;

-- Bảng khách hàng
CREATE TABLE khachhang (
    maKH INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    ten VARCHAR(255) NOT NULL,
    ho VARCHAR(255) NOT NULL,
    ngaySinh DATE,
    gioiTinh VARCHAR(10) NOT NULL,
    soDT VARCHAR(20) NOT NULL,
    email VARCHAR(255),
    ngayDK DATE NOT NULL,
    cc_hc VARCHAR(50),
    trangThai INT
);

INSERT INTO khachhang (username, password, ten, ho, ngaySinh, gioiTinh, soDT, email, ngayDK, cc_hc, trangThai)
VALUES
('nguyenvana', '123456', 'An', 'Nguyen Van', '1990-05-20', 'Nam', '0909123456', 'an.nguyen@example.com', '2024-12-01', '123456789', 1),
('tranthib', 'abc123', 'Binh', 'Tran Thi', '1995-08-15', 'Nữ', '0912233445', 'binh.tran@example.com', '2024-12-03', '987654321', 1),
('leminhc', 'matkhau1', 'Minh', 'Le', '1988-03-10', 'Nam', '0933123123', 'minh.le@example.com', '2024-12-05', '456789123', 0),
('phamthid', 'pass1234', 'Diem', 'Pham Thi', '1992-11-25', 'Nữ', '0944112233', 'diem.pham@example.com', '2024-12-07', '321654987', 1),
('doanthie', 'securepass', 'Thien', 'Doan', '1999-01-30', 'Nam', '0967888999', 'thien.doan@example.com', '2024-12-10', '852963741', 1);

-- Bảng nhân viên

CREATE TABLE nhanvien (
    maNV INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    ten VARCHAR(255),
    ho VARCHAR(255),
    ngaySinh DATE,
    gioiTinh VARCHAR(10),
    soDT VARCHAR(20),
    email VARCHAR(255),
    ngayVaoLam DATE,
    chucVu VARCHAR(255),
    cc_hc VARCHAR(50),
    trangThai INT
);

INSERT INTO nhanvien (username, password, ten, ho, ngaySinh, gioiTinh, soDT, email, ngayVaoLam, chucVu, cc_hc, trangThai)
VALUES
('ttran', '123456', 'Trung', 'Tran', '1990-05-15', 'Nam', '0987654321', 'ttran@example.com', '2021-01-10', 'Nhân viên', '012345678901', 1),
('hnguyen', 'password1', 'Hoa', 'Nguyen', '1993-08-22', 'Nữ', '0912345678', 'hnguyen@example.com', '2022-03-01', 'Lễ tân', '023456789012', 1),
('plam', 'abc123', 'Phong', 'Lam', '1988-12-03', 'Nam', '0909090909', 'plam@example.com', '2020-07-15', 'Quản lý', '034567890123', 1),
('nthao', 'thao321', 'Thảo', 'Ngô', '1995-11-27', 'Nữ', '0933333333', 'nthao@example.com', '2023-06-20', 'Nhân viên', '045678901234', 0),
('btran', 'btranpass', 'Bảo', 'Trần', '1992-01-05', 'Nam', '0966666666', 'btran@example.com', '2019-09-01', 'Admin', '056789012345', 1);

-- Bảng Phương tiện
CREATE TABLE phuongtien (
    maPhuongTien INT AUTO_INCREMENT PRIMARY KEY,
    tenPhuongTien VARCHAR(100),
    loaiPhuongTien VARCHAR(50),
    soChoNgoi INT,
    gia FLOAT,
    sdt VARCHAR(20),
    trangThai BOOLEAN 
);

INSERT INTO phuongtien (maPhuongTien, tenPhuongTien, loaiPhuongTien, soChoNgoi, gia, sdt, trangThai) VALUES
(1, 'Xe 16 chỗ Ford Transit', 'Xe khách', 16, 1500000,'0909123456', 1),
(2, 'Xe máy Honda AirBlade', 'Xe máy', 2, 200000, '0909345678', 0),
(3, 'Xe giường nằm Thaco', 'Xe khách', 40, 2500000, '0911223344', 1),
(4, 'Du thuyền Hạ Long', 'Du thuyền', 20, 5000000, '0911002233', 1),
(5, 'Xe ô tô 7 chỗ Toyota Innova', 'Ô tô', 7, 800000, '0909456123', 0),
(6, 'Xe limousine Dcar', 'Limousine', 9, 1800000, '0909888777', 1),
(7, 'Xe máy Vision', 'Xe máy', 2, 180000, '0909333444', 0),
(8, 'Xe khách 29 chỗ Samco', 'Xe khách', 29, 1700000, '0911333555', 1),
(9, 'Du thuyền Ninh Bình', 'Du thuyền', 15, 4000000, '0911666777', 1),
(10, 'Xe điện VinFast VF e34', 'Ô tô điện', 5, 1000000, '0909222333', 0);

-- Bảng Khách sạn
CREATE TABLE khachsan (
    maKhachSan INT AUTO_INCREMENT PRIMARY KEY,
    tenKhachSan VARCHAR(100),
    diaChi VARCHAR(255),
    gia FLOAT,
    sdt VARCHAR(20),
    trangThai BOOLEAN 
);

INSERT INTO khachsan (maKhachSan, tenKhachSan, diaChi, gia, sdt, trangThai) VALUES
(1, 'Khách sạn Majestic', '1 Đồng Khởi, Q.1, TP.HCM', 1200000, '02838222222', 1),
(2, 'Khách sạn Rex', '141 Nguyễn Huệ, Q.1, TP.HCM', 1500000, '02838292185', 1),
(3, 'Khách sạn Hương Giang', '8 Lê Lợi, TP. Huế', 900000, '02343822333', 0),
(4, 'Khách sạn Mường Thanh', 'Sơn Trà, Đà Nẵng', 1100000, '02363667788', 1),
(5, 'Khách sạn Ninh Kiều Riverside', '2 Hai Bà Trưng, Cần Thơ', 950000, '02922224444', 1),
(6, 'Khách sạn Novotel', '36 Bạch Đằng, Đà Nẵng', 1600000, '02363778899', 1),
(7, 'Khách sạn Imperial', '159 Thùy Vân, Vũng Tàu', 1400000, '02543889900', 0),
(8, 'Khách sạn Bạch Đằng', '50 Trần Phú, Nha Trang', 980000, '02583559888', 0),
(9, 'Khách sạn Grand Silverland', '125 Lý Tự Trọng, Q.1, TP.HCM', 1250000, '02838293939', 1),
(10, 'Khách sạn TTC Premium', '2 Lê Duẩn, Đà Lạt', 1050000, '02633889977', 1);

-- Bảng Nhà hàng
CREATE TABLE nhahang (
    maNhaHang INT AUTO_INCREMENT PRIMARY KEY,
    tenNhaHang VARCHAR(100),
    diaChi VARCHAR(255),
    gia FLOAT,
    sdt VARCHAR(20),
    trangThai BOOLEAN 
);

INSERT INTO nhahang (maNhaHang, tenNhaHang, diaChi, gia, sdt, trangThai) VALUES
(1, 'Nhà hàng Gánh', '3 Nguyễn Huệ, TP.HCM', 250000, '02839393939', 1),
(2, 'Nhà hàng Cơm Niêu Sài Gòn', '59 Hoàng Văn Thụ, Q.Phú Nhuận', 200000, '02838447788', 0),
(3, 'Nhà hàng Biển Đông', '76 Phạm Văn Đồng, Đà Nẵng', 300000, '02363998877', 1),
(4, 'Nhà hàng Nét Huế', '112 Lê Lai, Q.1, TP.HCM', 180000, '02839223344', 0),
(5, 'Nhà hàng Ninh Kiều', 'Số 1, Lê Lợi, Cần Thơ', 220000, '02922223344', 1),
(6, 'Nhà hàng Buffet D’Maris', '3C Tôn Đức Thắng, Q.1, TP.HCM', 350000, '02839393938', 1),
(7, 'Nhà hàng Hải sản Hương Biển', '45 Trần Phú, Nha Trang', 270000, '02583888999', 0),
(8, 'Nhà hàng Cánh Buồm', '123 Trần Hưng Đạo, Vũng Tàu', 230000, '02543881234', 1),
(9, 'Nhà hàng Song Hỷ', '18 Nguyễn Tri Phương, Đà Lạt', 210000, '02633884567', 1),
(10, 'Nhà hàng Góc Huế', '24 Nguyễn Thị Minh Khai, Huế', 190000, '02343998888', 0);

-- Bảng Tour
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

INSERT INTO tour (tenTour, gia, tinhTrang, moTa, diemKhoiHanh, diemDen, loaiTour, soNgay, soDem)
VALUES
('Tour Hà Nội - Hạ Long', 1500000, 'DANG_MO', 'Tham quan Vịnh Hạ Long 2 ngày 1 đêm', 'Hà Nội', 'Hạ Long', 'Nội địa', 2, 1),
('Tour Đà Nẵng - Hội An', 2000000, 'DA_DONG', 'Khám phá phố cổ Hội An', 'Đà Nẵng', 'Hội An', 'Nội địa', 3, 2),
('Tour Sài Gòn - Phú Quốc', 3500000, 'DANG_MO', 'Tham quan đảo Phú Quốc', 'TP.HCM', 'Phú Quốc', 'Nội địa', 4, 3),
('Tour Huế - Đà Lạt', 2800000, 'DA_DONG', 'Hành trình mộng mơ tại thành phố hoa', 'Huế', 'Đà Lạt', 'Nội địa', 3, 2),
('Tour Hà Nội - Sapa', 1800000, 'DANG_MO', 'Khám phá núi rừng Tây Bắc', 'Hà Nội', 'Sapa', 'Nội địa', 3, 2),
('Tour TP.HCM - Nha Trang', 2200000, 'DANG_MO', 'Tắm biển và tham quan Vinpearl Land', 'TP.HCM', 'Nha Trang', 'Nội địa', 3, 2),
('Tour Đà Nẵng - Bà Nà Hills', 1700000, 'DA_DONG', 'Tham quan Cầu Vàng nổi tiếng', 'Đà Nẵng', 'Bà Nà Hills', 'Nội địa', 2, 1),
('Tour Cần Thơ - Châu Đốc', 1600000, 'DANG_MO', 'Khám phá miền Tây sông nước', 'Cần Thơ', 'Châu Đốc', 'Nội địa', 2, 1),
('Tour Đà Nẵng - Huế', 1900000, 'DANG_MO', 'Di sản văn hóa cố đô Huế', 'Đà Nẵng', 'Huế', 'Nội địa', 2, 1),
('Tour Hải Phòng - Cát Bà', 1400000, 'DANG_MO', 'Tận hưởng biển xanh Cát Bà', 'Hải Phòng', 'Cát Bà', 'Nội địa', 2, 1),
('Tour TP.HCM - Đà Lạt', 2100000, 'DANG_MO', 'Thành phố sương mù và hoa', 'TP.HCM', 'Đà Lạt', 'Nội địa', 3, 2),
('Tour Hà Nội - Mộc Châu', 1700000, 'DANG_MO', 'Ngắm hoa cải trắng và đồi chè', 'Hà Nội', 'Mộc Châu', 'Nội địa', 3, 2),
('Tour Vinh - Quảng Bình', 1600000, 'DANG_MO', 'Tham quan Phong Nha - Kẻ Bàng', 'Vinh', 'Quảng Bình', 'Nội địa', 3, 2),
('Tour TP.HCM - Côn Đảo', 3200000, 'DANG_MO', 'Biển xanh và di tích lịch sử', 'TP.HCM', 'Côn Đảo', 'Nội địa', 4, 3),
('Tour Nha Trang - Đà Lạt', 2000000, 'DANG_MO', 'Biển và rừng thông mộng mơ', 'Nha Trang', 'Đà Lạt', 'Nội địa', 3, 2),
('Tour Hà Nội - Tam Đảo', 1300000, 'DANG_MO', 'Trải nghiệm không khí mát lành', 'Hà Nội', 'Tam Đảo', 'Nội địa', 2, 1),
('Tour Buôn Ma Thuột - Gia Lai', 2100000, 'DANG_MO', 'Khám phá Tây Nguyên đại ngàn', 'Buôn Ma Thuột', 'Gia Lai', 'Nội địa', 3, 2),
('Tour TP.HCM - Bến Tre', 1100000, 'DANG_MO', 'Miền Tây miệt vườn xanh mát', 'TP.HCM', 'Bến Tre', 'Nội địa', 2, 1),
('Tour Hà Nội - Tràng An', 1500000, 'DANG_MO', 'Du ngoạn Tràng An - Bái Đính', 'Hà Nội', 'Ninh Bình', 'Nội địa', 2, 1),
('Tour Quy Nhơn - Phú Yên', 2500000, 'DANG_MO', 'Tham quan Eo Gió và Ghềnh Đá Đĩa', 'Quy Nhơn', 'Phú Yên', 'Nội địa', 3, 2);

-- Bảng Kế hoạch tour
CREATE TABLE KeHoachTour (
    maKHTour INT AUTO_INCREMENT PRIMARY KEY,
    maTour INT,
    thoiGianBD DATE,
    thoiGianKT DATE,
    slDaDat INT DEFAULT 0,
    slToiDa INT NOT NULL,
    trangThai VARCHAR(50),
    tongChiPhi FLOAT,
	CONSTRAINT FK_KeHoachTour_Tour FOREIGN KEY (maTour) REFERENCES Tour(maTour)
);
	
INSERT INTO KeHoachTour (maTour, thoiGianBD, thoiGianKT, slDaDat, slToiDa, trangThai, tongChiPhi)
VALUES
(1, '2025-05-10', '2025-05-11', 15, 30, 'DANG_MO', 20000000),
(2, '2025-06-01', '2025-06-03', 20, 25, 'DA_HUY', 30000000),
(3, '2025-05-20', '2025-05-23', 12, 20, 'DANG_MO', 40000000),
(4, '2025-07-15', '2025-07-19', 10, 15, 'DANG_MO', 50000000),
(5, '2025-06-10', '2025-06-12', 25, 30, 'DA_HUY', 25000000),
(6, '2025-05-18', '2025-05-20', 18, 25, 'DANG_MO', 27000000),
(7, '2025-08-05', '2025-08-06', 9, 20, 'DANG_MO', 18000000),
(8, '2025-05-25', '2025-05-26', 14, 20, 'DANG_MO', 16000000),
(9, '2025-06-15', '2025-06-17', 16, 30, 'DANG_MO', 29000000),
(10, '2025-07-01', '2025-07-04', 11, 20, 'DA_HUY', 30000000),
(11, '2025-06-10', '2025-06-12', 8, 15, 'DANG_MO', 17000000),
(12, '2025-07-12', '2025-07-15', 6, 12, 'DANG_MO', 15000000),
(13, '2025-05-28', '2025-05-30', 20, 25, 'DA_HUY', 28000000),
(14, '2025-06-05', '2025-06-06', 10, 20, 'DANG_MO', 14000000),
(15, '2025-07-20', '2025-07-22', 15, 20, 'DANG_MO', 26000000),
(16, '2025-08-01', '2025-08-03', 7, 15, 'DANG_MO', 12000000),
(17, '2025-06-25', '2025-06-27', 19, 25, 'DA_HUY', 23000000),
(18, '2025-07-10', '2025-07-11', 13, 20, 'DANG_MO', 19000000),
(19, '2025-05-15', '2025-05-17', 9, 15, 'DANG_MO', 20000000),
(20, '2025-06-20', '2025-06-25', 17, 20, 'DANG_MO', 32000000);

 
-- Bảng Địa danh
CREATE TABLE diadanh (
    maDD INT AUTO_INCREMENT PRIMARY KEY,
    tenDD VARCHAR(100),
    tinhThanh VARCHAR(100),
    diemNoiBat TEXT
);

INSERT INTO diadanh (tenDD, tinhThanh, diemNoiBat)
VALUES
('Vịnh Hạ Long', 'Quảng Ninh', 'Di sản thiên nhiên thế giới với hàng nghìn đảo đá lớn nhỏ'),
('Phố cổ Hội An', 'Quảng Nam', 'Phố cổ nổi tiếng với kiến trúc cổ kính và đèn lồng'),
('Đảo Phú Quốc', 'Kiên Giang', 'Thiên đường du lịch biển với nhiều resort sang trọng'),
('Núi Bà Nà', 'Đà Nẵng', 'Khu du lịch với cáp treo dài và Cầu Vàng nổi bật'),
('Thành phố Đà Lạt', 'Lâm Đồng', 'Thành phố sương mù với hoa và khí hậu mát mẻ'),
('Cố đô Huế', 'Thừa Thiên Huế', 'Kinh thành cổ và các lăng tẩm của vua chúa nhà Nguyễn'),
('Hồ Hoàn Kiếm', 'Hà Nội', 'Biểu tượng của Thủ đô với tháp Rùa và đền Ngọc Sơn'),
('Chợ Bến Thành', 'TP.HCM', 'Khu chợ nổi tiếng nằm ở trung tâm Sài Gòn'),
('Thác Datanla', 'Lâm Đồng', 'Thác nước đẹp nằm giữa rừng thông, có trò chơi mạo hiểm'),
('Bãi biển Mỹ Khê', 'Đà Nẵng', 'Một trong những bãi biển đẹp nhất hành tinh theo Forbes');

CREATE TABLE HoaDon (
    maHoaDon INT AUTO_INCREMENT PRIMARY KEY,
    maKH INT,
    maKHTour INT,
    soVe INT,
    maNV INT,
    tongTien FLOAT,
    ghiChu TEXT,
    maKhuyenMai varchar(50),
    ngayLapPhieu DATETIME,
    trangThai BOOLEAN,
    
    FOREIGN KEY (maKH) REFERENCES KhachHang(maKH),
    FOREIGN KEY (maNV) REFERENCES NhanVien(maNV),
    FOREIGN KEY (maKHTour) REFERENCES KeHoachTour(maKHTour)
);

INSERT INTO HoaDon (maKH, maKHTour, soVe, maNV, tongTien, ghiChu, maKhuyenMai, ngayLapPhieu, trangThai) VALUES
(1, 1, 2, 3, 2000.0, 'Ghi chú 1', NULL, '2025-04-28 10:00:00', TRUE),
(2, 1, 4, 5, 4000.0, 'Ghi chú 2', NULL, '2025-04-28 10:05:00', TRUE),
(3, 2, 1, 2, 1000.0, 'Ghi chú 3', NULL, '2025-04-28 10:10:00', TRUE),
(4, 2, 3, 1, 3000.0, 'Ghi chú 4', NULL, '2025-04-28 10:15:00', TRUE),
(5, 3, 2, 4, 2000.0, 'Ghi chú 5', NULL, '2025-04-28 10:20:00', TRUE),
(1, 3, 5, 5, 5000.0, 'Ghi chú 6', NULL, '2025-04-28 10:25:00', TRUE),
(2, 4, 2, 2, 2000.0, 'Ghi chú 7', NULL, '2025-04-28 10:30:00', TRUE),
(3, 4, 3, 1, 3000.0, 'Ghi chú 8', NULL, '2025-04-28 10:35:00', TRUE),
(4, 5, 1, 3, 1000.0, 'Ghi chú 9', NULL, '2025-04-28 10:40:00', TRUE),
(5, 5, 2, 4, 2000.0, 'Ghi chú 10', NULL, '2025-04-28 10:45:00', TRUE),
(1, 6, 3, 5, 3000.0, 'Ghi chú 11', NULL, '2025-04-28 10:50:00', TRUE),
(2, 6, 1, 2, 1000.0, 'Ghi chú 12', NULL, '2025-04-28 10:55:00', TRUE),
(3, 7, 2, 1, 2000.0, 'Ghi chú 13', NULL, '2025-04-28 11:00:00', TRUE),
(4, 7, 4, 3, 4000.0, 'Ghi chú 14', NULL, '2025-04-28 11:05:00', TRUE),
(5, 8, 2, 4, 2000.0, 'Ghi chú 15', NULL, '2025-04-28 11:10:00', TRUE),
(1, 8, 3, 5, 3000.0, 'Ghi chú 16', NULL, '2025-04-28 11:15:00', TRUE),
(2, 9, 1, 2, 1000.0, 'Ghi chú 17', NULL, '2025-04-28 11:20:00', TRUE),
(3, 9, 5, 1, 5000.0, 'Ghi chú 18', NULL, '2025-04-28 11:25:00', TRUE),
(4, 10, 2, 3, 2000.0, 'Ghi chú 19', NULL, '2025-04-28 11:30:00', TRUE),
(5, 10, 4, 4, 4000.0, 'Ghi chú 20', NULL, '2025-04-28 11:35:00', TRUE),
(1, 11, 2, 5, 2000.0, 'Ghi chú 21', NULL, '2025-04-28 11:40:00', TRUE),
(2, 11, 3, 2, 3000.0, 'Ghi chú 22', NULL, '2025-04-28 11:45:00', TRUE),
(3, 12, 1, 1, 1000.0, 'Ghi chú 23', NULL, '2025-04-28 11:50:00', TRUE),
(4, 12, 2, 3, 2000.0, 'Ghi chú 24', NULL, '2025-04-28 11:55:00', TRUE),
(5, 13, 3, 4, 3000.0, 'Ghi chú 25', NULL, '2025-04-28 12:00:00', TRUE),
(1, 13, 4, 5, 4000.0, 'Ghi chú 26', NULL, '2025-04-28 12:05:00', TRUE),
(2, 14, 1, 2, 1000.0, 'Ghi chú 27', NULL, '2025-04-28 12:10:00', TRUE),
(3, 14, 5, 1, 5000.0, 'Ghi chú 28', NULL, '2025-04-28 12:15:00', TRUE),
(4, 15, 2, 3, 2000.0, 'Ghi chú 29', NULL, '2025-04-28 12:20:00', TRUE),
(5, 15, 3, 4, 3000.0, 'Ghi chú 30', NULL, '2025-04-28 12:25:00', TRUE),
(1, 16, 1, 5, 1000.0, 'Ghi chú 31', NULL, '2025-04-28 12:30:00', TRUE),
(2, 16, 2, 2, 2000.0, 'Ghi chú 32', NULL, '2025-04-28 12:35:00', TRUE),
(3, 17, 4, 1, 4000.0, 'Ghi chú 33', NULL, '2025-04-28 12:40:00', TRUE),
(4, 17, 3, 3, 3000.0, 'Ghi chú 34', NULL, '2025-04-28 12:45:00', TRUE),
(5, 18, 2, 4, 2000.0, 'Ghi chú 35', NULL, '2025-04-28 12:50:00', TRUE),
(1, 18, 5, 5, 5000.0, 'Ghi chú 36', NULL, '2025-04-28 12:55:00', TRUE),
(2, 19, 1, 2, 1000.0, 'Ghi chú 37', NULL, '2025-04-28 13:00:00', TRUE),
(3, 19, 4, 1, 4000.0, 'Ghi chú 38', NULL, '2025-04-28 13:05:00', TRUE),
(4, 20, 3, 3, 3000.0, 'Ghi chú 39', NULL, '2025-04-28 13:10:00', TRUE),
(5, 20, 2, 4, 2000.0, 'Ghi chú 40', NULL, '2025-04-28 13:15:00', TRUE);
