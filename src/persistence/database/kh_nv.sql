

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
INSERT INTO khachhang (username, password, ten, ho, ngaySinh, gioiTinh, soDT, email, ngayDK, cc_hc, trangThai)
VALUES
('nguyenvana', '123456', 'An', 'Nguyen Van', '1990-05-20', 'Nam', '0909123456', 'an.nguyen@example.com', '2024-12-01', '123456789', 1),
('tranthib', 'abc123', 'Binh', 'Tran Thi', '1995-08-15', 'Nữ', '0912233445', 'binh.tran@example.com', '2024-12-03', '987654321', 1),
('leminhc', 'matkhau1', 'Minh', 'Le', '1988-03-10', 'Nam', '0933123123', 'minh.le@example.com', '2024-12-05', '456789123', 0),
('phamthid', 'pass1234', 'Diem', 'Pham Thi', '1992-11-25', 'Nữ', '0944112233', 'diem.pham@example.com', '2024-12-07', '321654987', 1),
('doanthie', 'securepass', 'Thien', 'Doan', '1999-01-30', 'Nam', '0967888999', 'thien.doan@example.com', '2024-12-10', '852963741', 1);

INSERT INTO nhanvien (username, password, ten, ho, ngaySinh, gioiTinh, soDT, email, ngayVaoLam, chucVu, cc_hc, trangThai)
VALUES
('ttran', '123456', 'Trung', 'Tran', '1990-05-15', 'Nam', '0987654321', 'ttran@example.com', '2021-01-10', 'Nhân viên', '012345678901', 1),
('hnguyen', 'password1', 'Hoa', 'Nguyen', '1993-08-22', 'Nữ', '0912345678', 'hnguyen@example.com', '2022-03-01', 'Lễ tân', '023456789012', 1),
('plam', 'abc123', 'Phong', 'Lam', '1988-12-03', 'Nam', '0909090909', 'plam@example.com', '2020-07-15', 'Quản lý', '034567890123', 1),
('nthao', 'thao321', 'Thảo', 'Ngô', '1995-11-27', 'Nữ', '0933333333', 'nthao@example.com', '2023-06-20', 'Nhân viên', '045678901234', 0),
('btran', 'btranpass', 'Bảo', 'Trần', '1992-01-05', 'Nam', '0966666666', 'btran@example.com', '2019-09-01', 'Admin', '056789012345', 1);
