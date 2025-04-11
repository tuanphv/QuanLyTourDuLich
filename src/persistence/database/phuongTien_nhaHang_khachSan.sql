use quanlytourdulich;

CREATE TABLE phuongtien (
    maPhuongTien INT AUTO_INCREMENT PRIMARY KEY,
    tenPhuongTien VARCHAR(100),
    loaiPhuongTien VARCHAR(50),
    soChoNgoi INT,
    sdt VARCHAR(20),
    gia FLOAT,
    trangThai varchar(20)
);

INSERT INTO phuongtien (maPhuongTien, tenPhuongTien, loaiPhuongTien, soChoNgoi, sdt, gia, trangThai) VALUES
(1, 'Xe 16 chỗ Ford Transit', 'Xe khách', 16, '0909123456', 1500000, 1),
(2, 'Xe máy Honda AirBlade', 'Xe máy', 2, '0909345678', 200000, 0),
(3, 'Xe giường nằm Thaco', 'Xe khách', 40, '0911223344', 2500000, 1),
(4, 'Du thuyền Hạ Long', 'Du thuyền', 20, '0911002233', 5000000, 1),
(5, 'Xe ô tô 7 chỗ Toyota Innova', 'Ô tô', 7, '0909456123', 800000, 0),
(6, 'Xe limousine Dcar', 'Limousine', 9, '0909888777', 1800000, 1),
(7, 'Xe máy Vision', 'Xe máy', 2, '0909333444', 180000, 0),
(8, 'Xe khách 29 chỗ Samco', 'Xe khách', 29, '0911333555', 1700000, 1),
(9, 'Du thuyền Ninh Bình', 'Du thuyền', 15, '0911666777', 4000000, 1),
(10, 'Xe điện VinFast VF e34', 'Ô tô điện', 5, '0909222333', 1000000, 0);

CREATE TABLE khachsan (
    maKhachSan INT AUTO_INCREMENT PRIMARY KEY,
    tenKhachSan VARCHAR(100),
    diaChi VARCHAR(255),
    sdt VARCHAR(20),
    gia FLOAT,
    trangThai varchar(20)
);

INSERT INTO khachsan (maKhachSan, tenKhachSan, diaChi, sdt, gia, trangThai) VALUES
(1, 'Khách sạn Majestic', '1 Đồng Khởi, Q.1, TP.HCM', '02838222222', 1200000, 1),
(2, 'Khách sạn Rex', '141 Nguyễn Huệ, Q.1, TP.HCM', '02838292185', 1500000, 1),
(3, 'Khách sạn Hương Giang', '8 Lê Lợi, TP. Huế', '02343822333', 900000, 0),
(4, 'Khách sạn Mường Thanh', 'Sơn Trà, Đà Nẵng', '02363667788', 1100000, 1),
(5, 'Khách sạn Ninh Kiều Riverside', '2 Hai Bà Trưng, Cần Thơ', '02922224444', 950000, 1),
(6, 'Khách sạn Novotel', '36 Bạch Đằng, Đà Nẵng', '02363778899', 1600000, 1),
(7, 'Khách sạn Imperial', '159 Thùy Vân, Vũng Tàu', '02543889900', 1400000, 0),
(8, 'Khách sạn Bạch Đằng', '50 Trần Phú, Nha Trang', '02583559888', 980000, 0),
(9, 'Khách sạn Grand Silverland', '125 Lý Tự Trọng, Q.1, TP.HCM', '02838293939', 1250000, 1),
(10, 'Khách sạn TTC Premium', '2 Lê Duẩn, Đà Lạt', '02633889977', 1050000, 1);

CREATE TABLE nhahang (
    maNhaHang INT AUTO_INCREMENT PRIMARY KEY,
    tenNhaHang VARCHAR(100),
    diaChi VARCHAR(255),
    sdt VARCHAR(20),
    gia FLOAT,
    trangThai varchar(20)
);

INSERT INTO nhahang (maNhaHang, tenNhaHang, diaChi, sdt, gia, trangThai) VALUES
(1, 'Nhà hàng Gánh', '3 Nguyễn Huệ, TP.HCM', '02839393939', 250000, 1),
(2, 'Nhà hàng Cơm Niêu Sài Gòn', '59 Hoàng Văn Thụ, Q.Phú Nhuận', '02838447788', 200000, 0),
(3, 'Nhà hàng Biển Đông', '76 Phạm Văn Đồng, Đà Nẵng', '02363998877', 300000, 1),
(4, 'Nhà hàng Nét Huế', '112 Lê Lai, Q.1, TP.HCM', '02839223344', 180000, 0),
(5, 'Nhà hàng Ninh Kiều', 'Số 1, Lê Lợi, Cần Thơ', '02922223344', 220000, 1),
(6, 'Nhà hàng Buffet D’Maris', '3C Tôn Đức Thắng, Q.1, TP.HCM', '02839393938', 350000, 1),
(7, 'Nhà hàng Hải sản Hương Biển', '45 Trần Phú, Nha Trang', '02583888999', 270000, 0),
(8, 'Nhà hàng Cánh Buồm', '123 Trần Hưng Đạo, Vũng Tàu', '02543881234', 230000, 1),
(9, 'Nhà hàng Song Hỷ', '18 Nguyễn Tri Phương, Đà Lạt', '02633884567', 210000, 1),
(10, 'Nhà hàng Góc Huế', '24 Nguyễn Thị Minh Khai, Huế', '02343998888', 190000, 0);
