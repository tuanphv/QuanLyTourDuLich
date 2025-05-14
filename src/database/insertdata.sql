USE quanlytourdulich;

INSERT INTO khachhang (username, password, ten, ho, ngaySinh, gioiTinh, soDT, email, ngayDK, cc_hc, trangThai)
VALUES
('nguyenvana', '123456', 'An', 'Nguyen Van', '1990-05-20', 'Nam', '0909123456', 'an.nguyen@example.com', '2024-12-01', '123456789', 1),
('tranthib', 'abc123', 'Binh', 'Tran Thi', '1995-08-15', 'Nữ', '0912233445', 'binh.tran@example.com', '2024-12-03', '987654321', 1),
('leminhc', 'matkhau1', 'Minh', 'Le', '1988-03-10', 'Nam', '0933123123', 'minh.le@example.com', '2024-12-05', '456789123', 0),
('phamthid', 'pass1234', 'Diem', 'Pham Thi', '1992-11-25', 'Nữ', '0944112233', 'diem.pham@example.com', '2024-12-07', '321654987', 1),
('doanthie', 'securepass', 'Thien', 'Doan', '1999-01-30', 'Nam', '0967888999', 'thien.doan@example.com', '2024-12-10', '852963741', 1),
('phamvanE', 'pwdE123',    'Van',      'Pham Van',    '1987-04-12', 'Nam',  '0912345670', 'van.pham@example.com',    '2025-01-05', '112233445', 1),
('nguyenthH', 'hhH@2025',   'Thao',     'Nguyen Thi',  '1991-09-08', 'Nữ',   '0923456781', 'thao.nguyen@example.com',  '2025-01-10', '223344556', 1),
('lequynhK', 'qK!4567',    'Quynh',    'Le Quynh',    '1993-02-14', 'Nữ',   '0934567892', 'quynh.le@example.com',     '2025-01-15', '334455667', 1),
('tranminhL',  'minhL789',   'Minh',     'Tran Minh',   '1985-12-22', 'Nam',  '0945678903', 'minh.tran@example.com',    '2025-01-20', '445566778', 0),
('hoducM',     'ducM!321',   'Duc',      'Ho Duc',      '1997-07-30', 'Nam',  '0956789014', 'duc.ho@example.com',       '2025-01-25', '556677889', 1),
('vuongthiN',  'vN@2025',    'Thi',      'Vuong Thi',   '1994-11-05', 'Nữ',   '0967890125', 'thi.vuong@example.com',    '2025-01-30', '667788990', 1),
('phamquocO',  'pqO#654',    'Quoc',     'Pham Quoc',   '1989-03-18', 'Nam',  '0978901236', 'quoc.pham@example.com',    '2025-02-04', '778899001', 1),
('dinhthuyP',  'thuyP$$12',  'Thuy',     'Dinh Thuy',   '1996-06-25', 'Nữ',   '0989012347', 'thuy.dinh@example.com',    '2025-02-09', '889900112', 0),
('ngoquangQ',  'qNg2025',    'Quang',    'Ngo Quang',   '1992-10-11', 'Nam',  '0990123458', 'quang.ngo@example.com',    '2025-02-14', '990011223', 1),
('lethanhR',   'tR#7890',    'Thanh',    'Le Thanh',    '1986-08-02', 'Nữ',   '0901234569', 'thanh.le@example.com',     '2025-02-19', '001122334', 1);

INSERT INTO nhanvien (username, password, ten, ho, ngaySinh, gioiTinh, soDT, email, ngayVaoLam, chucVu, cc_hc, trangThai)
VALUES
('ttran', '123456', 'Trung', 'Tran', '1990-05-15', 'Nam', '0987654321', 'ttran@example.com', '2021-01-10', 'Nhân viên', '012345678901', 1),
('hnguyen', 'password1', 'Hoa', 'Nguyen', '1993-08-22', 'Nữ', '0912345678', 'hnguyen@example.com', '2022-03-01', 'Lễ tân', '023456789012', 1),
('plam', 'abc123', 'Phong', 'Lam', '1988-12-03', 'Nam', '0909090909', 'plam@example.com', '2020-07-15', 'Quản lý', '034567890123', 1),
('nthao', 'thao321', 'Thảo', 'Ngô', '1995-11-27', 'Nữ', '0933333333', 'nthao@example.com', '2023-06-20', 'Nhân viên', '045678901234', 0),
('btran', 'btranpass', 'Bảo', 'Trần', '1992-01-05', 'Nam', '0966666666', 'btran@example.com', '2019-09-01', 'Admin', '056789012345', 1);

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

INSERT INTO tour (tenTour, gia, tinhTrang, moTa, diemKhoiHanh, diemDen, loaiTour, soNgay, soDem)
VALUES
-- Miền Bắc
('Tour Hà Nội - Hạ Long', 1500000, 'DANG_MO', 'Tham quan Vịnh Hạ Long 2 ngày 1 đêm', 'Hà Nội', 'Hạ Long', 'Miền Bắc', 2, 1),
('Tour Hà Nội - Sapa', 1800000, 'DANG_MO', 'Khám phá núi rừng Tây Bắc', 'Hà Nội', 'Sapa', 'Miền Bắc', 3, 2),
('Tour Hà Nội - Mộc Châu', 1700000, 'DANG_MO', 'Ngắm hoa cải trắng và đồi chè', 'Hà Nội', 'Mộc Châu', 'Miền Bắc', 2, 1),
('Tour Hà Nội - Tam Đảo', 1300000, 'DANG_MO', 'Trải nghiệm không khí mát lành', 'Hà Nội', 'Tam Đảo', 'Miền Bắc', 1, 0),
('Tour Hà Nội - Tràng An', 1500000, 'DANG_MO', 'Du ngoạn Tràng An - Bái Đính', 'Hà Nội', 'Ninh Bình', 'Miền Bắc', 1, 0),
('Tour Hải Phòng - Cát Bà', 1400000, 'DANG_MO', 'Tận hưởng biển xanh Cát Bà', 'Hải Phòng', 'Cát Bà', 'Miền Bắc', 3, 2),

-- Miền Trung
('Tour Đà Nẵng - Hội An', 2000000, 'DA_DONG', 'Khám phá phố cổ Hội An', 'Đà Nẵng', 'Hội An', 'Miền Trung', 2, 1),
('Tour Huế - Đà Lạt', 2800000, 'DA_DONG', 'Hành trình mộng mơ tại thành phố hoa', 'Huế', 'Đà Lạt', 'Miền Trung', 4, 3),
('Tour Đà Nẵng - Bà Nà Hills', 1700000, 'DA_DONG', 'Tham quan Cầu Vàng nổi tiếng', 'Đà Nẵng', 'Bà Nà Hills', 'Miền Trung', 1, 0),
('Tour Đà Nẵng - Huế', 1900000, 'DANG_MO', 'Di sản văn hóa cố đô Huế', 'Đà Nẵng', 'Huế', 'Miền Trung', 2, 1),
('Tour Vinh - Quảng Bình', 1600000, 'DANG_MO', 'Tham quan Phong Nha - Kẻ Bàng', 'Vinh', 'Quảng Bình', 'Miền Trung', 3, 2),
('Tour Nha Trang - Đà Lạt', 2000000, 'DANG_MO', 'Biển và rừng thông mộng mơ', 'Nha Trang', 'Đà Lạt', 'Miền Trung', 2, 1),
('Tour Buôn Ma Thuột - Gia Lai', 2100000, 'DANG_MO', 'Khám phá Tây Nguyên đại ngàn', 'Buôn Ma Thuột', 'Gia Lai', 'Miền Trung', 5, 4),
('Tour Quy Nhơn - Phú Yên', 2500000, 'DANG_MO', 'Tham quan Eo Gió và Ghềnh Đá Đĩa', 'Quy Nhơn', 'Phú Yên', 'Miền Trung', 3, 2),

-- Miền Nam
('Tour Sài Gòn - Phú Quốc', 3500000, 'DANG_MO', 'Tham quan đảo Phú Quốc', 'TP.HCM', 'Phú Quốc', 'Miền Nam', 4, 3),
('Tour TP.HCM - Nha Trang', 2200000, 'DANG_MO', 'Tắm biển và tham quan Vinpearl Land', 'TP.HCM', 'Nha Trang', 'Miền Nam', 3, 2),
('Tour TP.HCM - Đà Lạt', 2100000, 'DANG_MO', 'Thành phố sương mù và hoa', 'TP.HCM', 'Đà Lạt', 'Miền Nam', 2, 1),
('Tour TP.HCM - Côn Đảo', 3200000, 'DANG_MO', 'Biển xanh và di tích lịch sử', 'TP.HCM', 'Côn Đảo', 'Miền Nam', 5, 4),
('Tour TP.HCM - Bến Tre', 1100000, 'DANG_MO', 'Miền Tây miệt vườn xanh mát', 'TP.HCM', 'Bến Tre', 'Miền Nam', 1, 0),
('Tour Cần Thơ - Châu Đốc', 1600000, 'DANG_MO', 'Khám phá miền Tây sông nước', 'Cần Thơ', 'Châu Đốc', 'Miền Nam', 2, 1);

INSERT INTO KeHoachTour (maTour, thoiGianBD, thoiGianKT, slDaDat, slToiDa, trangThai, tongChiPhi)
VALUES
(1, '2025-05-10', '2025-05-11', 15, 30, 'DANG_MO', 2000000),
(2, '2025-06-01', '2025-06-03', 20, 25, 'DA_HUY', 3000000),
(3, '2025-05-20', '2025-05-23', 12, 20, 'DANG_MO', 4000000),
(4, '2025-07-15', '2025-07-19', 10, 15, 'DANG_MO', 5000000),
(5, '2025-06-10', '2025-06-12', 25, 30, 'DA_HUY', 2500000),
(6, '2025-05-18', '2025-05-20', 18, 25, 'DANG_MO', 2700000),
(7, '2025-08-05', '2025-08-06', 9, 20, 'DANG_MO', 1800000),
(8, '2025-05-25', '2025-05-26', 14, 20, 'DANG_MO', 1600000),
(9, '2025-06-15', '2025-06-17', 16, 30, 'DANG_MO', 2900000),
(10, '2025-07-01', '2025-07-04', 11, 20, 'DA_HUY', 3000000),
(11, '2025-06-10', '2025-06-12', 8, 15, 'DANG_MO', 1700000),
(12, '2025-07-12', '2025-07-15', 6, 12, 'DANG_MO', 1500000),
(13, '2025-05-28', '2025-05-30', 20, 25, 'DA_HUY', 2800000),
(14, '2025-06-05', '2025-06-06', 10, 20, 'DANG_MO', 1400000),
(15, '2025-07-20', '2025-07-22', 15, 20, 'DANG_MO', 2600000),
(16, '2025-08-01', '2025-08-03', 7, 15, 'DANG_MO', 1200000),
(17, '2025-06-25', '2025-06-27', 19, 25, 'DA_HUY', 2300000),
(18, '2025-07-10', '2025-07-11', 13, 20, 'DANG_MO', 1900000),
(19, '2025-05-15', '2025-05-17', 9, 15, 'DANG_MO', 2000000),
(20, '2025-06-20', '2025-06-25', 17, 20, 'DANG_MO', 3200000);

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

-- Đặt Tour (40 mẫu)
INSERT INTO DatTour (maKHTour, maKH, ngayDat, soLuong, tongTien, trangThai) VALUES
(1, 1, '2024-01-15', 1, 1500000, 'DaThanhToan'),
(2, 2, '2024-02-10', 1, 1200000, 'DaThanhToan'),
(3, 3, '2024-03-05', 3, 4500000, 'ChoThanhToan'),
(4, 4, '2024-04-25', 2, 2500000, 'DaThanhToan'),
(5, 5, '2024-05-18', 1, 1100000, 'ChoThanhToan'),
(6, 6, '2024-06-10', 1, 1800000, 'DaThanhToan'),
(7, 7, '2024-07-20', 2, 2100000, 'DaHuy'),
(8, 8, '2024-08-12', 1, 2000000, 'ChoThanhToan'),
(9, 9, '2024-09-15', 1, 1600000, 'DaThanhToan'),
(10, 10, '2024-10-05', 1, 1300000, 'DaThanhToan'),
(11, 11, '2024-11-11', 2, 2400000, 'ChoThanhToan'),
(12, 12, '2024-12-01', 1, 1700000, 'DaThanhToan'),
(13, 13, '2025-01-30', 1, 1400000, 'DaThanhToan'),
(14, 14, '2025-02-22', 2, 2200000, 'ChoThanhToan'),
(15, 15, '2025-03-10', 1, 1500000, 'DaThanhToan'),
(16, 6, '2025-04-25', 1, 1300000, 'DaThanhToan'),
(17, 7, '2025-05-17', 1, 1900000, 'DaHuy'),
(18, 8, '2025-06-19', 1, 1100000, 'ChoThanhToan'),
(19, 9, '2025-07-02', 2, 2600000, 'DaThanhToan'),
(20, 10, '2025-08-14', 2, 2300000, 'DaThanhToan'),
(1, 1, '2025-09-08', 1, 1500000, 'ChoThanhToan'),
(2, 2, '2025-10-15', 1, 1600000, 'DaThanhToan'),
(3, 3, '2025-11-03', 1, 1700000, 'DaThanhToan'),
(4, 4, '2025-12-10', 1, 1800000, 'DaThanhToan'),
(5, 5, '2024-02-28', 2, 2200000, 'DaHuy'),
(6, 6, '2024-04-01', 2, 2000000, 'DaThanhToan'),
(7, 7, '2024-06-30', 1, 1400000, 'ChoThanhToan'),
(8, 8, '2024-08-05', 1, 1900000, 'DaThanhToan'),
(9, 9, '2024-10-18', 2, 2500000, 'DaThanhToan'),
(10, 10, '2024-11-07', 1, 1200000, 'DaThanhToan'),
(11, 11, '2025-01-01', 1, 1300000, 'ChoThanhToan'),
(12, 12, '2025-02-18', 1, 1600000, 'DaThanhToan'),
(13, 13, '2025-03-11', 2, 2100000, 'DaThanhToan'),
(14, 14, '2025-04-05', 1, 1800000, 'DaHuy'),
(15, 15, '2025-05-21', 1, 1700000, 'DaThanhToan'),
(16, 1, '2025-06-25', 1, 1400000, 'ChoThanhToan'),
(17, 2, '2025-07-08', 2, 2400000, 'DaThanhToan'),
(18, 3, '2025-08-19', 1, 1300000, 'DaThanhToan'),
(19, 4, '2025-09-01', 1, 1100000, 'DaThanhToan'),
(20, 5, '2025-10-12', 1, 1500000, 'DaThanhToan');


-- Hóa Đơn (40 mẫu)
INSERT INTO HoaDon (maDat, maNV, ngayLap, tongTien, hinhThucThanhToan, trangThai) VALUES
(1, 1, '2024-01-16', 1500000, 'Chuyển khoản', 'DaThanhToan'),
(2, 2, '2024-02-11', 1200000, 'Tiền mặt', 'DaThanhToan'),
(3, 3, '2024-03-06', 4500000, 'Chuyển khoản', 'ChoXacNhan'),
(4, 4, '2024-04-26', 2500000, 'Tiền mặt', 'DaThanhToan'),
(5, 5, '2024-05-19', 1100000, 'Chuyển khoản', 'ChoXacNhan'),
(6, 1, '2024-06-11', 1800000, 'Tiền mặt', 'DaThanhToan'),
(7, 2, '2024-07-21', 2100000, 'Chuyển khoản', 'Huy'),
(8, 3, '2024-08-13', 2000000, 'Tiền mặt', 'ChoXacNhan'),
(9, 4, '2024-09-16', 1600000, 'Chuyển khoản', 'DaThanhToan'),
(10, 5, '2024-10-06', 1300000, 'Tiền mặt', 'DaThanhToan'),
(11, 1, '2024-11-12', 2400000, 'Chuyển khoản', 'ChoXacNhan'),
(12, 2, '2024-12-02', 1700000, 'Tiền mặt', 'DaThanhToan'),
(13, 3, '2025-01-31', 1400000, 'Chuyển khoản', 'DaThanhToan'),
(14, 4, '2025-02-23', 2200000, 'Tiền mặt', 'ChoXacNhan'),
(15, 5, '2025-03-11', 1500000, 'Chuyển khoản', 'DaThanhToan'),
(16, 1, '2025-04-26', 1300000, 'Tiền mặt', 'DaThanhToan'),
(17, 2, '2025-05-18', 1900000, 'Chuyển khoản', 'Huy'),
(18, 3, '2025-06-20', 1100000, 'Tiền mặt', 'ChoXacNhan'),
(19, 4, '2025-07-03', 2600000, 'Chuyển khoản', 'DaThanhToan'),
(20, 5, '2025-08-15', 2300000, 'Tiền mặt', 'DaThanhToan'),
(21, 1, '2025-09-09', 1500000, 'Chuyển khoản', 'ChoXacNhan'),
(22, 2, '2025-10-16', 1600000, 'Tiền mặt', 'DaThanhToan'),
(23, 3, '2025-11-04', 1700000, 'Chuyển khoản', 'DaThanhToan'),
(24, 4, '2025-12-11', 1800000, 'Tiền mặt', 'DaThanhToan'),
(25, 5, '2024-03-01', 2200000, 'Chuyển khoản', 'Huy'),
(26, 1, '2024-04-02', 2000000, 'Tiền mặt', 'DaThanhToan'),
(27, 2, '2024-07-01', 1400000, 'Chuyển khoản', 'ChoXacNhan'),
(28, 3, '2024-08-06', 1900000, 'Tiền mặt', 'DaThanhToan'),
(29, 4, '2024-10-19', 2500000, 'Chuyển khoản', 'DaThanhToan'),
(30, 5, '2024-11-08', 1200000, 'Tiền mặt', 'DaThanhToan'),
(31, 1, '2025-01-02', 1300000, 'Chuyển khoản', 'ChoXacNhan'),
(32, 2, '2025-02-19', 1600000, 'Tiền mặt', 'DaThanhToan'),
(33, 3, '2025-03-12', 2100000, 'Chuyển khoản', 'DaThanhToan'),
(34, 4, '2025-04-06', 1800000, 'Tiền mặt', 'Huy'),
(35, 5, '2025-05-22', 1700000, 'Chuyển khoản', 'DaThanhToan'),
(36, 1, '2025-06-26', 1400000, 'Tiền mặt', 'ChoXacNhan'),
(37, 2, '2025-07-09', 2400000, 'Chuyển khoản', 'DaThanhToan'),
(38, 3, '2025-08-20', 1300000, 'Tiền mặt', 'DaThanhToan'),
(39, 4, '2025-09-02', 1100000, 'Chuyển khoản', 'DaThanhToan'),
(40, 5, '2025-10-13', 1500000, 'Tiền mặt', 'DaThanhToan');

-- Chi Tiết Hành Khách (40 mẫu)
INSERT INTO ChiTietHanhKhach (maDat, soThuTu, hoTen, ngaySinh, loaiHanhKhach, soGiayTo, laNguoiDat) VALUES
(1, 1, 'Nguyen Van A', '1990-05-12', 'NguoiLon', 'A123456789', TRUE),

(2, 1, 'Tran Thi B', '1992-07-18', 'NguoiLon', 'B987654321', FALSE),

(3, 1, 'Pham Minh C', '2005-02-25', 'TreEm', 'C112233445', FALSE),
(3, 2, 'Le Thi D', '1990-08-15', 'NguoiLon', 'D556677889', TRUE),
(3, 3, 'Nguyen Hoang E', '1955-10-22', 'NguoiGia', 'E443322110', FALSE),

(4, 1, 'Tran Lan F', '2002-11-03', 'TreEm', 'F223344556', FALSE),
(4, 2, 'Pham Kim G', '1993-03-11', 'NguoiLon', 'G778899001', TRUE),

(5, 1, 'Nguyen Thi H', '1988-05-09', 'NguoiLon', 'H889900112', TRUE),

(6, 1, 'Tran Thi I', '1991-11-21', 'NguoiLon', 'I665544332', FALSE),
(6, 2, 'Pham Minh J', '2000-04-10', 'TreEm', 'J554433221', TRUE),

(7, 1, 'Le Hoang K', '1995-02-28', 'NguoiLon', 'K998877665', TRUE),
(7, 2, 'Nguyen Thi L', '2003-07-25', 'TreEm', 'L443322110', FALSE),

(8, 1, 'Pham Hoang M', '1997-03-06', 'NguoiLon', 'M223344556', TRUE),
(8, 2, 'Le Minh N', '1961-09-17', 'NguoiGia', 'N776655443', TRUE),

(9, 1, 'Nguyen Thi O', '1994-08-12', 'NguoiLon', 'O887766554', TRUE),
(9, 2, 'Pham Minh P', '1998-12-04', 'NguoiLon', 'P998877665', FALSE),

(10, 1, 'Le Hoang Q', '2006-02-18', 'TreEm', 'Q223344556', TRUE),
(10, 2, 'Nguyen Thi R', '2005-10-01', 'TreEm', 'R334455667', TRUE),

(11, 1, 'Nguyen Thi S', '1999-06-29', 'NguoiLon', 'S887766554', TRUE),
(11, 2, 'Pham Thi T', '2002-03-09', 'TreEm', 'T667788990', TRUE),

(12, 1, 'Le Thi U', '2004-01-22', 'TreSoSinh', 'U889900112', FALSE),

(13, 1, 'Nguyen Thi V', '1992-05-10', 'NguoiLon', 'V776655443', TRUE),
(13, 2, 'Pham Hoang W', '2000-02-28', 'NguoiLon', 'W998877665', FALSE),

(14, 1, 'Le Minh X', '2003-04-15', 'TreEm', 'X223344556', TRUE),

(15, 1, 'Nguyen Thi Y', '1990-11-03', 'NguoiLon', 'Y334455667', FALSE),

(16, 1, 'Pham Thi Z', '2002-06-17', 'TreEm', 'Z667788990', TRUE),

(17, 1, 'Nguyen Thi AA', '1997-05-11', 'NguoiLon', 'AA778899001', TRUE),

(18, 1, 'Pham Hoang BB', '2000-09-28', 'NguoiLon', 'BB667788990', FALSE),

(19, 1, 'Nguyen Minh CC', '2006-01-15', 'TreEm', 'CC223344556', TRUE),

(20, 1, 'Le Thi DD', '2001-08-20', 'TreEm', 'DD334455667', TRUE),

(21, 1, 'Nguyen Thi EE', '1995-03-10', 'NguoiLon', 'EE998877665', TRUE),

(22, 1, 'Pham Minh FF', '1999-06-01', 'NguoiLon', 'FF223344556', FALSE),

(23, 1, 'Le Thi GG', '1990-12-18', 'NguoiLon', 'GG667788990', TRUE),

(24, 1, 'Nguyen Thi HH', '2000-05-25', 'TreEm', 'HH889900112', FALSE),
(24, 2, 'Pham Minh II', '1993-07-19', 'NguoiLon', 'II776655443', TRUE),

(25, 1, 'Le Thi JJ', '2001-08-30', 'TreEm', 'JJ998877665', FALSE),

(26, 1, 'Nguyen Thi KK', '1994-11-15', 'NguoiLon', 'KK667788990', TRUE),
(26, 2, 'Pham Minh LL', '2003-02-22', 'TreEm', 'LL223344556', FALSE),

(27, 1, 'Le Hoang MM', '1992-04-14', 'NguoiLon', 'MM334455667', TRUE),

(28, 1, 'Nguyen Thi NN', '1996-09-05', 'NguoiLon', 'NN223344556', TRUE),
(28, 2, 'Pham Minh OO', '2000-01-10', 'TreEm', 'OO556677889', TRUE),

(29, 1, 'Le Thi PP', '2004-06-25', 'NguoiLon', 'PP223344556', TRUE),
(29, 2, 'Nguyen Thi QQ', '2003-09-17', 'TreEm', 'QQ998877665', FALSE),

(30, 1, 'Pham Minh RR', '2000-07-14', 'NguoiLon', 'RR667788990', TRUE),

(31, 1, 'Nguyen Thi SS', '1995-03-22', 'NguoiLon', 'SS334455667', TRUE),
(31, 2, 'Le Hoang TT', '2002-01-11', 'TreEm', 'TT998877665', FALSE),

(32, 1, 'Nguyen Thi UU', '1997-02-03', 'NguoiLon', 'UU667788990', TRUE),

(33, 1, 'Pham Minh VV', '2005-10-09', 'TreEm', 'VV223344556', FALSE),
(33, 2, 'Le Thi WW', '1999-07-28', 'NguoiLon', 'WW889900112', TRUE),

(34, 1, 'Nguyen Thi XX', '1992-06-21', 'NguoiLon', 'XX776655443', TRUE),

(35, 1, 'Pham Minh YY', '2002-11-16', 'TreEm', 'YY223344556', TRUE),

(36, 1, 'Le Hoang ZZ', '1998-05-22', 'NguoiLon', 'ZZ556677889', TRUE),

(37, 1, 'Nguyen Thi AAA', '2003-03-30', 'TreEm', 'AAA223344556', TRUE),

(38, 1, 'Pham Minh BBB', '1997-08-14', 'NguoiLon', 'BBB667788990', TRUE),

(39, 1, 'Le Thi CCC', '2001-12-25', 'TreEm', 'CCC223344556', FALSE),

(40, 1, 'Nguyen Thi DDD', '2004-07-05', 'TreEm', 'DDD998877665', TRUE);

-- Vé Du Lịch (40 mẫu)
INSERT INTO Ve (maDat, soThuTu, maKHTour, hoTen, ngayKhoiHanh, ngayCap, giaVe, trangThai) VALUES
(1, 1, 1, 'Nguyen Van A', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(2, 1, 2, 'Tran Thi B', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(3, 1, 3, 'Pham Minh C', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),
(3, 2, 3, 'Le Thi D', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),
(3, 3, 3, 'Nguyen Hoang E', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(4, 1, 4, 'Tran Lan F', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),
(4, 2, 4, 'Pham Kim G', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(5, 1, 5, 'Nguyen Thi H', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(6, 1, 6, 'Tran Thi I', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),
(6, 2, 6, 'Pham Minh J', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),

(7, 1, 7, 'Le Hoang K', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),
(7, 2, 7, 'Nguyen Thi L', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),

(8, 1, 8, 'Pham Hoang M', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),
(8, 2, 8, 'Le Minh N', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(9, 1, 9, 'Nguyen Thi O', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),
(9, 2, 9, 'Pham Minh P', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(10, 1, 10, 'Le Hoang Q', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),
(10, 2, 10, 'Nguyen Thi R', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),

(11, 1, 11, 'Nguyen Thi S', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),
(11, 2, 11, 'Pham Thi T', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),

(12, 1, 12, 'Le Thi U', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),

(13, 1, 13, 'Nguyen Thi V', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),
(13, 2, 13, 'Pham Hoang W', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(14, 1, 14, 'Le Minh X', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),

(15, 1, 15, 'Nguyen Thi Y', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(16, 1, 16, 'Pham Thi Z', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),

(17, 1, 17, 'Nguyen Thi AA', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(18, 1, 18, 'Pham Hoang BB', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(19, 1, 19, 'Nguyen Minh CC', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),

(20, 1, 20, 'Le Thi DD', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),

(21, 1, 1, 'Nguyen Thi EE', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(22, 1, 2, 'Pham Minh FF', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(23, 1, 3, 'Le Thi GG', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(24, 1, 4, 'Nguyen Thi HH', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),
(24, 2, 4, 'Pham Minh II', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(25, 1, 5, 'Le Thi JJ', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),

(26, 1, 6, 'Nguyen Thi KK', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),
(26, 2, 6, 'Pham Minh LL', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),

(27, 1, 7, 'Le Hoang MM', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(28, 1, 8, 'Nguyen Thi NN', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),
(28, 2, 8, 'Pham Minh OO', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),

(29, 1, 9, 'Le Thi PP', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),
(29, 2, 9, 'Nguyen Thi QQ', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),

(30, 1, 10, 'Pham Minh RR', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(31, 1, 11, 'Nguyen Thi SS', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),
(31, 2, 11, 'Le Hoang TT', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),

(32, 1, 12, 'Nguyen Thi UU', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(33, 1, 13, 'Pham Minh VV', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),
(33, 2, 13, 'Le Thi WW', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(34, 1, 14, 'Nguyen Thi XX', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(35, 1, 15, 'Pham Minh YY', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),

(36, 1, 16, 'Le Hoang ZZ', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(37, 1, 17, 'Nguyen Thi AAA', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),

(38, 1, 18, 'Pham Hoang BBB', '2025-05-08', '2025-05-08', 100000, 'DaPhatHanh'),

(39, 1, 19, 'Le Thi CCC', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh'),

(40, 1, 20, 'Nguyen Thi DDD', '2025-05-08', '2025-05-08', 50000, 'DaPhatHanh');

SET SQL_SAFE_UPDATES = 0;

UPDATE KeHoachTour k
SET slDaDat = (
    SELECT COUNT(*)
    FROM Ve v
    WHERE v.maKHTour = k.maKeHoachTour
      AND v.trangThai != 'DaHuy'
);

UPDATE Ve v
SET giaVe = (
	SELECT kh.tongChiPhi * 
		CASE ct.loaiHanhKhach
			WHEN 'NguoiLon' THEN 1
            WHEN 'NguoiGia' THEN 0.8
            WHEN 'TreEm' THEN 0.5
            ELSE 0
		END AS chiPhi
    FROM KeHoachTour kh, ChiTietHanhKhach ct
    WHERE kh.maKeHoachTour = v.maKHTour AND ct.maDat = v.maDat AND ct.soThuTu = v.soThuTu
);

UPDATE DatTour dt
SET tongTien = (
	SELECT SUM(v.giaVe)
    FROM Ve v
    WHERE v.maDat = dt.maDat
);

UPDATE HoaDon hd
SET tongTien = (
	SELECT dt.tongTien
    FROM DatTour dt
    WHERE dt.maDat = hd.maDat
);

SET SQL_SAFE_UPDATES = 1;
