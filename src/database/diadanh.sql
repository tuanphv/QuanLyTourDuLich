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
