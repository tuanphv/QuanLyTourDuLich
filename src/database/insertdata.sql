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

INSERT INTO KeHoachTour (maTour, thoiGianBD, slDaDat, slToiDa, trangThai, tongChiPhi)
VALUES
(1, '2025-05-10', 0, 30, 'DANG_MO', 20000000),
(2, '2025-06-01', 0, 25, 'DA_HUY', 30000000),
(3, '2025-05-20', 0, 20, 'DANG_MO', 40000000),
(4, '2025-07-15', 0, 15, 'DANG_MO', 50000000),
(5, '2025-06-10', 0, 30, 'DA_HUY', 25000000),
(6, '2025-05-18', 0, 25, 'DANG_MO', 27000000),
(7, '2025-08-05', 0, 20, 'DANG_MO', 18000000),
(8, '2025-05-25', 0, 20, 'DANG_MO', 16000000),
(9, '2025-06-15', 0, 30, 'DANG_MO', 29000000),
(10, '2025-07-01', 0, 20, 'DA_HUY', 30000000),
(11, '2025-06-10', 0, 15, 'DANG_MO', 17000000),
(12, '2025-07-12', 0, 12, 'DANG_MO', 15000000),
(13, '2025-05-28', 0, 25, 'DA_HUY', 28000000),
(14, '2025-06-05', 0, 20, 'DANG_MO', 14000000),
(15, '2025-07-20', 0, 20, 'DANG_MO', 26000000),
(16, '2025-08-01', 0, 15, 'DANG_MO', 12000000),
(17, '2025-06-25', 0, 25, 'DA_HUY', 23000000),
(18, '2025-07-10', 0, 20, 'DANG_MO', 19000000),
(19, '2025-05-15', 0, 15, 'DANG_MO', 20000000),
(20, '2025-06-20', 0, 20, 'DANG_MO', 32000000);

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

INSERT INTO DatTour (maKHTour, maKH, ngayDat, soLuong, tongTien, trangThai) VALUES
(1, 1, '2025-05-01', 3, 4500000, 'DaThanhToan'),
(2, 2, '2025-05-02', 2, 3000000, 'ChoThanhToan'),
(3, 3, '2025-05-03', 4, 6000000, 'DaThanhToan'),
(4, 4, '2025-05-04', 1, 1500000, 'DaHuy'),
(5, 5, '2025-05-05', 2, 3200000, 'DaThanhToan'),
(6, 6, '2025-05-06', 3, 4500000, 'ChoThanhToan'),
(7, 7, '2025-05-07', 5, 8000000, 'DaThanhToan'),
(8, 8, '2025-05-08', 2, 2800000, 'DaThanhToan'),
(9, 9, '2025-05-09', 4, 6400000, 'ChoThanhToan'),
(10, 10, '2025-05-10', 4, 6400000, 'DaThanhToan');

INSERT INTO HoaDon (maDat, maNV, ngayLap, tongTien, hinhThucThanhToan, trangThai) VALUES
(1, 1, '2025-05-01', 4500000, 'Chuyen Khoan', 'DaThanhToan'),
(2, 2, '2025-05-02', 3000000, 'Tien Mat', 'ChoXacNhan'),
(3, 3, '2025-05-03', 6000000, 'Chuyen Khoan', 'DaThanhToan'),
(4, 4, '2025-05-04', 1500000, 'Tien Mat', 'Huy'),
(5, 5, '2025-05-05', 3200000, 'Chuyen Khoan', 'DaThanhToan'),
(6, 1, '2025-05-06', 4500000, 'The Tin Dung', 'ChoXacNhan'),
(7, 2, '2025-05-07', 8000000, 'Chuyen Khoan', 'DaThanhToan'),
(8, 3, '2025-05-08', 2800000, 'Tien Mat', 'DaThanhToan'),
(9, 4, '2025-05-09', 6400000, 'Chuyen Khoan', 'ChoXacNhan'),
(10, 5, '2025-05-10', 6400000, 'The Tin Dung', 'DaThanhToan');

INSERT INTO ChiTietHanhKhach VALUES 
-- Đơn 1: 3 khách
(1, 1, 'Nguyen Van A', '1990-01-01', 'NguoiLon', 'CM001', TRUE),
(1, 2, 'Tran Thi B', '1992-02-02', 'NguoiLon', 'CM002', FALSE),
(1, 3, 'Nguyen C', '2015-03-03', 'TreEm', 'TE001', FALSE),

-- Đơn 2: 2 khách
(2, 1, 'Le Van D', '1985-04-04', 'NguoiLon', 'CM003', TRUE),
(2, 2, 'Le Thi E', '2016-05-05', 'TreEm', 'TE002', FALSE),

-- Đơn 3: 4 khách
(3, 1, 'Pham Van F', '1978-06-06', 'NguoiLon', 'CM004', TRUE),
(3, 2, 'Tran G', '1999-07-07', 'NguoiLon', 'CM005', FALSE),
(3, 3, 'Be H', '2020-08-08', 'TreSoSinh', 'SS001', FALSE),
(3, 4, 'Nguyen I', '2012-09-09', 'TreEm', 'TE003', FALSE),

-- Đơn 4: 1 khách
(4, 1, 'Doan J', '1990-10-10', 'NguoiLon', 'CM006', TRUE),

-- Đơn 5: 2 khách
(5, 1, 'Ly K', '1981-11-11', 'NguoiLon', 'CM007', TRUE),
(5, 2, 'Hoang L', '2010-12-12', 'TreEm', 'TE004', FALSE),

-- Đơn 6: 3 khách
(6, 1, 'Pham M', '1995-01-13', 'NguoiLon', 'CM008', TRUE),
(6, 2, 'Nguyen N', '2014-02-14', 'TreEm', 'TE005', FALSE),
(6, 3, 'Be O', '2023-03-15', 'TreSoSinh', 'SS002', FALSE),

-- Đơn 7: 5 khách
(7, 1, 'Phan P', '1980-04-16', 'NguoiLon', 'CM009', TRUE),
(7, 2, 'Tran Q', '2000-05-17', 'NguoiLon', 'CM010', FALSE),
(7, 3, 'Nguyen R', '2015-06-18', 'TreEm', 'TE006', FALSE),
(7, 4, 'Le S', '2019-07-19', 'TreEm', 'TE007', FALSE),
(7, 5, 'Be T', '2022-08-20', 'TreSoSinh', 'SS003', FALSE),

-- Đơn 8: 2 khách
(8, 1, 'Do U', '1993-09-21', 'NguoiLon', 'CM011', TRUE),
(8, 2, 'Vo V', '2016-10-22', 'TreEm', 'TE008', FALSE),

-- Đơn 9: 4 khách
(9, 1, 'Nguyen W', '1975-11-23', 'NguoiLon', 'CM012', TRUE),
(9, 2, 'Nguyen X', '1988-12-24', 'NguoiLon', 'CM013', FALSE),
(9, 3, 'Be Y', '2020-01-25', 'TreEm', 'TE009', FALSE),
(9, 4, 'Be Z', '2024-02-26', 'TreSoSinh', 'SS004', FALSE),

-- Đơn 10: 4 khách
(10, 1, 'Ho A1', '1984-03-27', 'NguoiLon', 'CM014', TRUE),
(10, 2, 'Nguyen A2', '2006-04-28', 'NguoiLon', 'CM015', FALSE),
(10, 3, 'Nguyen A3', '2013-05-29', 'TreEm', 'TE010', FALSE),
(10, 4, 'Be A4', '2023-06-30', 'TreSoSinh', 'SS005', FALSE);

-- Vé tương ứng từng hành khách
INSERT INTO Ve (maDat, soThuTu, maKHTour, hoTen, ngayKhoiHanh, ngayCap, trangThai) VALUES
(1, 1, 1, 'Nguyen Van A', '2025-06-10', '2025-05-01', 'SuDung'),
(1, 2, 1, 'Tran Thi B', '2025-06-10', '2025-05-01', 'DaPhatHanh'),
(1, 3, 1, 'Nguyen C', '2025-06-10', '2025-05-01', 'DaPhatHanh'),

(2, 1, 2, 'Le Van D', '2025-06-11', '2025-05-02', 'DaPhatHanh'),
(2, 2, 2, 'Le Thi E', '2025-06-11', '2025-05-02', 'DaPhatHanh'),

(3, 1, 3, 'Pham Van F', '2025-06-12', '2025-05-03', 'DaPhatHanh'),
(3, 2, 3, 'Tran G', '2025-06-12', '2025-05-03', 'DaPhatHanh'),
(3, 3, 3, 'Be H', '2025-06-12', '2025-05-03', 'DaPhatHanh'),
(3, 4, 3, 'Nguyen I', '2025-06-12', '2025-05-03', 'DaPhatHanh'),

(4, 1, 4, 'Doan J', '2025-06-13', '2025-05-04', 'DaHuy'),

(5, 1, 5, 'Ly K', '2025-06-14', '2025-05-05', 'DaPhatHanh'),
(5, 2, 5, 'Hoang L', '2025-06-14', '2025-05-05', 'DaPhatHanh'),

(6, 1, 6, 'Pham M', '2025-06-15', '2025-05-06', 'DaPhatHanh'),
(6, 2, 6, 'Nguyen N', '2025-06-15', '2025-05-06', 'DaPhatHanh'),
(6, 3, 6, 'Be O', '2025-06-15', '2025-05-06', 'DaPhatHanh'),

(7, 1, 7, 'Phan P', '2025-06-16', '2025-05-07', 'DaPhatHanh'),
(7, 2, 7, 'Tran Q', '2025-06-16', '2025-05-07', 'DaPhatHanh'),
(7, 3, 7, 'Nguyen R', '2025-06-16', '2025-05-07', 'SuDung'),
(7, 4, 7, 'Le S', '2025-06-16', '2025-05-07', 'SuDung'),
(7, 5, 7, 'Be T', '2025-06-16', '2025-05-07', 'DaPhatHanh'),

(8, 1, 8, 'Do U', '2025-06-17', '2025-05-08', 'DaPhatHanh'),
(8, 2, 8, 'Vo V', '2025-06-17', '2025-05-08', 'DaPhatHanh'),

(9, 1, 9, 'Nguyen W', '2025-06-18', '2025-05-09', 'DaPhatHanh'),
(9, 2, 9, 'Nguyen X', '2025-06-18', '2025-05-09', 'DaPhatHanh'),
(9, 3, 9, 'Be Y', '2025-06-18', '2025-05-09', 'SuDung'),
(9, 4, 9, 'Be Z', '2025-06-18', '2025-05-09', 'SuDung'),

(10, 1, 10, 'Ho A1', '2025-06-19', '2025-05-10', 'DaPhatHanh'),
(10, 2, 10, 'Nguyen A2', '2025-06-19', '2025-05-10', 'SuDung'),
(10, 3, 10, 'Nguyen A3', '2025-06-19', '2025-05-10', 'DaPhatHanh'),
(10, 4, 10, 'Be A4', '2025-06-19', '2025-05-10', 'DaPhatHanh');
