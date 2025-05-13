-- Drop database cũ (nếu có)
DROP DATABASE IF EXISTS quanlytourdulich;

-- Tạo database 
CREATE DATABASE quanlytourdulich;

-- Tạo các bảng
use quanlytourdulich;

-- 1. Bảng khách hàng
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

-- 2. Bảng nhân viên
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

-- 3. Bảng Phương tiện
CREATE TABLE phuongtien (
    maPhuongTien INT AUTO_INCREMENT PRIMARY KEY,
    tenPhuongTien VARCHAR(100),
    loaiPhuongTien VARCHAR(50),
    soChoNgoi INT,
    gia FLOAT,
    sdt VARCHAR(20),
    trangThai BOOLEAN 
);

-- 4. Bảng Khách sạn
CREATE TABLE khachsan (
    maKhachSan INT AUTO_INCREMENT PRIMARY KEY,
    tenKhachSan VARCHAR(100),
    diaChi VARCHAR(255),
    gia FLOAT,
    sdt VARCHAR(20),
    trangThai BOOLEAN 
);

-- 5. Bảng Nhà hàng
CREATE TABLE nhahang (
    maNhaHang INT AUTO_INCREMENT PRIMARY KEY,
    tenNhaHang VARCHAR(100),
    diaChi VARCHAR(255),
    gia FLOAT,
    sdt VARCHAR(20),
    trangThai BOOLEAN 
);

-- 6. Bảng Tour
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

-- 7. Bảng Kế hoạch tour
CREATE TABLE KeHoachTour (
    maKeHoachTour INT AUTO_INCREMENT PRIMARY KEY,
    maTour INT,
    thoiGianBD DATE,
    thoiGianKT DATE,
    slDaDat INT DEFAULT 0,
    slToiDa INT NOT NULL,
    trangThai VARCHAR(50),
    tongChiPhi FLOAT,
	CONSTRAINT FK_KeHoachTour_Tour FOREIGN KEY (maTour) REFERENCES Tour(maTour)
);

-- 8. Bảng Địa danh
CREATE TABLE diadanh (
    maDiaDanh INT AUTO_INCREMENT PRIMARY KEY,
    tenDD VARCHAR(100),
    tinhThanh VARCHAR(100),
    chiPhi FLOAT,
    diemNoiBat TEXT
);

-- 9. Bảng Đặt Tour
CREATE TABLE DatTour (
    maDat INT PRIMARY KEY AUTO_INCREMENT,
    maKHTour INT,
    maKH INT,
    ngayDat DATE,
    soLuong INT,
    tongTien FLOAT,
    trangThai ENUM('ChoThanhToan', 'DaThanhToan', 'DaHuy') DEFAULT 'ChoThanhToan',
    FOREIGN KEY (maKHTour) REFERENCES KeHoachTour(maKeHoachTour) ON DELETE CASCADE,
    FOREIGN KEY (maKH) REFERENCES KhachHang(maKH)
);

-- 10. Bảng Chi Tiết Hành Khách
CREATE TABLE ChiTietHanhKhach (
    maDat INT,
    soThuTu INT,
    hoTen VARCHAR(100),
    ngaySinh DATE,
    loaiHanhKhach ENUM('NguoiLon', 'TreEm', 'NguoiGia', 'TreSoSinh'),
    soGiayTo VARCHAR(50),
    laNguoiDat BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (maDat, soThuTu),
    FOREIGN KEY (maDat) REFERENCES DatTour(maDat)
);

-- 11. Bảng Hóa Đơn
CREATE TABLE HoaDon (
    maHD INT PRIMARY KEY AUTO_INCREMENT,
    maDat INT,
    maNV INT,
    ngayLap DATETIME,
    tongTien FLOAT,
    hinhThucThanhToan VARCHAR(50),
    trangThai ENUM('DaThanhToan', 'ChoXacNhan', 'Huy') DEFAULT 'ChoXacNhan',
    FOREIGN KEY (maDat) REFERENCES DatTour(maDat)
);

-- 12. Bảng Vé Du Lịch
CREATE TABLE Ve (
    maVe INT PRIMARY KEY AUTO_INCREMENT,
    maDat INT,
    soThuTu INT,
    maKHTour INT,
    hoTen VARCHAR(100),
    ngayKhoiHanh DATE,
    ngayCap DATE,
    giaVe FLOAT,
    trangThai ENUM('DaPhatHanh', 'DaHuy', 'SuDung') DEFAULT 'DaPhatHanh',
    FOREIGN KEY (maDat, soThuTu) REFERENCES ChiTietHanhKhach(maDat, soThuTu),
    FOREIGN KEY (maKHTour) REFERENCES KeHoachTour(maKeHoachTour) ON DELETE CASCADE
);

CREATE TABLE ChiTietKeHoachTour (
    maChiTietKeHoachTour INT AUTO_INCREMENT PRIMARY KEY,
    maKeHoachTour INT,
    ngay DATE,
    moTa TEXT,
    chiPhiNgay BIGINT,
    FOREIGN KEY (maKeHoachTour) REFERENCES KeHoachTour(maKeHoachTour) ON DELETE CASCADE
);

CREATE TABLE DiaDiemThamQuan (
    maDiaDiemThamQuan INT AUTO_INCREMENT PRIMARY KEY,
    maChiTietKeHoachTour INT,
    maDiaDanh INT,
    moTa TEXT,
    maPhuongTien INT,
    chiPhiThamQuan FLOAT,
    chiPhiDiChuyen FLOAT,
    FOREIGN KEY (maChiTietKeHoachTour) REFERENCES ChiTietKeHoachTour(maChiTietKeHoachTour) ON DELETE CASCADE,     
    FOREIGN KEY (maDiaDanh) REFERENCES DiaDanh(maDiaDanh),
    FOREIGN KEY (maPhuongTien) REFERENCES PhuongTien(maPhuongTien)
);

CREATE TABLE KhachSanNghiNgoi (
    maKhachSanNghiNgoi INT AUTO_INCREMENT PRIMARY KEY,
    maKhachSan INT,
    maChiTietKeHoachTour INT,
    chiPhiKhachSan FLOAT,
    FOREIGN KEY (maKhachSan) REFERENCES KhachSan(maKhachSan),
    FOREIGN KEY (maChiTietKeHoachTour) REFERENCES ChiTietKeHoachTour(maChiTietKeHoachTour) ON DELETE CASCADE
);

CREATE TABLE BuoiAn (
    maBuoiAn INT AUTO_INCREMENT PRIMARY KEY,
    maChiTietKeHoachTour INT,
    loaiBuoiAn VARCHAR(50),
    maNhaHang INT,
    chiPhi FLOAT,
    moTa TEXT,
    FOREIGN KEY (maNhaHang) REFERENCES NhaHang(maNhaHang),
    FOREIGN KEY (maChiTietKeHoachTour) REFERENCES ChiTietKeHoachTour(maChiTietKeHoachTour) ON DELETE CASCADE
);

