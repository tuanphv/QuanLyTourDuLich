-- Tạo database 
-- create database quanlytourdulich;

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
-- Nhân viên 1
('ttran', '123456', 'Trung', 'Tran', '1990-05-15', 'Nam', '0987654321', 'ttran@example.com', '2021-01-10', 'Nhân viên', '012345678901', 1),

-- Nhân viên 2
('hnguyen', 'password1', 'Hoa', 'Nguyen', '1993-08-22', 'Nữ', '0912345678', 'hnguyen@example.com', '2022-03-01', 'Lễ tân', '023456789012', 1),

-- Nhân viên 3
('plam', 'abc123', 'Phong', 'Lam', '1988-12-03', 'Nam', '0909090909', 'plam@example.com', '2020-07-15', 'Quản lý', '034567890123', 1),

-- Nhân viên 4
('nthao', 'thao321', 'Thảo', 'Ngô', '1995-11-27', 'Nữ', '0933333333', 'nthao@example.com', '2023-06-20', 'Nhân viên', '045678901234', 0),

-- Nhân viên 5
('btran', 'btranpass', 'Bảo', 'Trần', '1992-01-05', 'Nam', '0966666666', 'btran@example.com', '2019-09-01', 'Admin', '056789012345', 1);
