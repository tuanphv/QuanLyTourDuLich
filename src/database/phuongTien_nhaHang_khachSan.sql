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
