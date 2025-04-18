-- Drop database cũ (nếu có)
DROP DATABASE IF EXISTS quanlytourdulich;

-- Tạo database 
create database quanlytourdulich;

-- Tạo các bảng
use quanlytourdulich;

-- Bảng khách hàng
CREATE TABLE khachhang (
    maKH int(255) AUTO_INCREMENT PRIMARY KEY,
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
    trangThai int(1)
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
    maNV int(255) AUTO_INCREMENT PRIMARY KEY,
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
    trangThai int(1)
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
('Tour Hà Nội - Hạ Long', 1500000, 'Đang mở', 'Tham quan Vịnh Hạ Long 2 ngày 1 đêm', 'Hà Nội', 'Hạ Long', 'Nội địa', 2, 1),
('Tour Đà Nẵng - Hội An', 2000000, 'Đã đóng', 'Khám phá phố cổ Hội An', 'Đà Nẵng', 'Hội An', 'Nội địa', 3, 2),
('Tour Sài Gòn - Phú Quốc', 3500000, 'Đang mở', 'Tham quan đảo Phú Quốc', 'TP.HCM', 'Phú Quốc', 'Nội địa', 4, 3),
('Tour Hà Nội - Bangkok', 5500000, 'Đang mở', 'Du lịch Thái Lan trọn gói', 'Hà Nội', 'Bangkok', 'Quốc tế', 5, 4),
('Tour Huế - Đà Lạt', 2800000, 'Đã đóng', 'Hành trình mộng mơ tại thành phố hoa', 'Huế', 'Đà Lạt', 'Nội địa', 3, 2);

-- Bảng Kế hoạch tour
CREATE TABLE KeHoachTour (
    maKHTour INT AUTO_INCREMENT PRIMARY KEY,
    maTour INT,
    thoiGianBD DATE,
    thoiGianKT DATE,
    trangThai VARCHAR(50),
    tongChiPhi FLOAT
);

INSERT INTO KeHoachTour (maTour, thoiGianBD, thoiGianKT, trangThai, tongChiPhi)
VALUES 
(1, '2025-05-01', '2025-05-05', 'CHO_DUYET', 15000000),
(2, '2025-06-10', '2025-06-15', 'DA_DUYET', 20000000),
(3, '2025-04-20', '2025-04-25', 'DANG_DIEN_RA', 17500000),
(4, '2025-07-01', '2025-07-05', 'HOAN_THANH', 16000000),
(5, '2025-08-15', '2025-08-20', 'DA_HUY', 0),
(2, '2025-09-01', '2025-09-05', 'CHO_DUYET', 18000000),
(1, '2025-10-10', '2025-10-14', 'DA_DUYET', 15500000),
(3, '2025-11-01', '2025-11-06', 'HOAN_THANH', 21000000),
(4, '2025-12-20', '2025-12-25', 'DANG_DIEN_RA', 19500000),
(5, '2026-01-05', '2026-01-10', 'DA_HUY', 0);
 
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
