-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 16, 2017 lúc 05:38 CH
-- Phiên bản máy phục vụ: 10.1.21-MariaDB
-- Phiên bản PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `webbangiay`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `admin`
--

CREATE TABLE `admin` (
  `id` int(10) NOT NULL,
  `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'id', 'id');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `iddonhang` int(50) NOT NULL,
  `iduser` int(10) NOT NULL,
  `hoten` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hinhthucthanhtoan` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tongtien` int(20) NOT NULL,
  `id_thanhtoan` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`iddonhang`, `iduser`, `hoten`, `phone`, `email`, `address`, `hinhthucthanhtoan`, `tongtien`, `id_thanhtoan`) VALUES
(110, 6, 'J', 'J', 'jJ', 'J', 'Thanh toán COD', 1000, 0),
(111, 6, 'J', 'J', 'jJ', 'J', 'Thanh toán COD', 1000, 0),
(112, 6, 'k', 'k', 'k', 'k', 'Thanh toán COD', 3000, 0),
(113, 12, 'Phạm Sỹ Bằng', '01647718971', 'bangphamsy97@gmail.com', 'Hải Dương', 'Thanh toán trực tuyến', 12000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisp`
--

CREATE TABLE `loaisp` (
  `idloaisp` int(10) NOT NULL,
  `loaisp` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `loaisp`
--

INSERT INTO `loaisp` (`idloaisp`, `loaisp`) VALUES
(1, 'Nam'),
(2, 'Nữ'),
(3, 'All');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `qlchitietdonhang`
--

CREATE TABLE `qlchitietdonhang` (
  `STT` int(10) NOT NULL,
  `iddonhang` int(50) NOT NULL,
  `idsanpham` int(50) NOT NULL,
  `soluong` int(50) NOT NULL,
  `size` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `qlchitietdonhang`
--

INSERT INTO `qlchitietdonhang` (`STT`, `iddonhang`, `idsanpham`, `soluong`, `size`) VALUES
(101, 92, 39, 1, '25,26,27,28,29'),
(102, 93, 39, 1, '25,26,27,28,29'),
(103, 94, 37, 1, '25,26,27,28,29'),
(104, 95, 36, 2, '25,26,27,28,29'),
(105, 95, 38, 1, '25,26,27,28'),
(106, 96, 36, 2, '25,26,27,28,29'),
(107, 96, 38, 1, '25,26,27,28'),
(108, 0, 36, 1, '25,26,27,28,29'),
(109, 101, 36, 1, '25,26,27,28,29'),
(110, 102, 36, 2, '25,26,27,28,29'),
(111, 103, 36, 2, '25,26,27,28,29'),
(112, 103, 36, 2, '25,26,27,28,29'),
(113, 102, 36, 2, '25,26,27,28,29'),
(114, 102, 36, 2, '25,26,27,28,29'),
(115, 103, 36, 2, '25,26,27,28,29'),
(116, 108, 36, 2, '25,26,27,28,29'),
(117, 108, 36, 2, '25,26,27,28,29'),
(118, 110, 36, 1, '25,26,27,28,29'),
(119, 110, 36, 1, '25,26,27,28,29'),
(120, 112, 38, 1, '25,26,27,28'),
(121, 113, 37, 3, '25,26,27,28,29'),
(122, 113, 38, 2, '25,26,27,28');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `idsanpham` int(50) NOT NULL,
  `tensanpham` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gia` int(20) NOT NULL,
  `mota` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `hinhanh` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `soluong` int(50) NOT NULL,
  `mausac` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `xuatxu` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `size` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idtenhang` int(10) NOT NULL,
  `idloaisp` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`idsanpham`, `tensanpham`, `gia`, `mota`, `hinhanh`, `soluong`, `mausac`, `xuatxu`, `size`, `idtenhang`, `idloaisp`) VALUES
(40, 'Giày Outventune', 550000, 'Chỉ cần xỏ chân vào những mẫu giày thể thao đơn giản, bạn sẽ thoải mái dạo bước phố phường, khám phá từng con hẻm nhỏ, từng quán café, vừa lạ vừa quen để cảm nhận hơi thở dịu dàng của cuộc sống. Trong những cuộc picnic rộn ràng, giày thể thao sẽ sát cánh cùng bạn trên những đoạn đường gập ghềnh, khó đi. Và nếu bạn thích chạy bộ, tập aerobic thì HappyShoes chắc chắn là vật dụng không thể thiếu!\r\nSự kết hợp hài hòa giữa phong cách trẻ trung, cá tính nhưng đồng thời cũng rất sang trọng là điều mà ta có thể tìm thấy ở HappyShoes, bạn hãy sử dụng để cảm nhận nhé! Giày HappyShoes đảm bảo sẽ mang đến cho Quý khách hàng một phong cách mới lạ mà không bị\r\nhòa lẫn giữa đám đông.\r\nBạn sẽ tự tin sải bước cùng đôi giày Outventune với kiểu dáng thanh mảnh cùng điểm nhấn đế giầy gồm nhiều lớp bằng cao su rất thích hợp khi đi cùng những chiếc quần jeans ôm tạo dáng đi uyển chuyển. Đồng thời, bạn cũng có thể kết hợp với váy, đầm thanh lịch và sang trọng.\r\nHình chụp thực tế của Shop Happyshoes\r\nKhách hàng nên gọi điện cho shop trước khi đặt hàng để được shop hướng dẫn hoặc hỗ trợ phí vận chuyển', 'uN1ts7_simg_b5529c_250x250_maxb.png', 1, 'hồng', 'VN', '27', 1, 3),
(41, 'GIÀY NIKE LUNARGLIDE', 249000, 'Giày NIKE LUNARGLIDE 8 (843725-006)\r\nLunar Glide 8 - đứa CON NUÔI mang họ GLIDE .\r\nThế hệ thứ 8 của dòng Lunar Glide là 1 DỊ THƯỜNG vì đây là phiên bản được hình thành bởi sự thay đổi trong thiết kế cũng như kết hợp công nghệ rất phức tạp khi so với các phiên bản trước.Đa số các hãng giày chạy bộ chuyên nghiệp thường hiếm khi thay đổi quá nhiều thiết kế của hai đời giày kế tiếp nhau. Chẳng ai muốn làm mất đi trải nghiệm của runner trong dòng giày quen thuộc. Chỉ cần một sai lầm sẽ biến trải nghiệm tuyệt vời thành thảm hoạ. Mất lòng tin, mất khách như chơi.\r\n\r\nNhưng Nike lại chọn chiến thuật hoàn toàn khác: giày lên đời mới là đột biến gen hoàn toàn luôn. Có công nghệ mới nào là tích hợp ngay để mang đến trải nghiệm mới cho khách hàng.\r\nĐệm lunarlon thần thánh nằm từ phần giữa bàn chân phủ lên phía các ngón chân đúng theo nguyên lý đặt lệch, được bao bên ngoài bởi vật liệu Phylon và điều ĐẶC SẮC ở đây là chúng được KẾT HỢP với nhau thành 1 lớp chứ không phải là dán 2 lớp với nhau như trên các phiên bản trước. Khi nhìn từ ngoài vào ta không thể thấy lớp lunarlon này nhưng khi lật mặt đế lên sẽ thấy phần vật liệu khác màu.\r\nĐế giày: Công nghệ cắt đế bằng laser – Laser Siping – được Nike tiếp tục mang lên LunarGlide 8 sau màn ra mắt thành công trên LunarEpic. Các đường cắt trên LunarGlide 8 có thiết kế khác với LunarEpic. Ở hai bên đế giày, chỉ có phần má ngoài được cắt, còn má trong giữ nguyên vẹn. Các đường cắt ở má ngoài cạn, không sâu như trên LunarEpic\r\nCác đường cắt LASER: phía sau gót tại má ngoài của đế có những đường cắt laser, cải tiến này giúp cho đế giày có khả năng xẹp xuống nhanh hơn, tạo ra ít phản lực hơn khi nện chân xuống, hỗ trợ rất tốt cho những guồng chân nhanh, tuy nhiên nó cũng làm cho đôi giày dễ mất cân bằng hơn. Tại bề mặt đế tiếp đất, các rãnh cắt theo trục đứng dạng vân tay là điểm mới xuất hiện, thay thế cho hệ vân cũ dạng bản đồ nhiệt , hệ vân mới bố trí theo 4 cụm, có khả năng xô theo mọi hướng làm cho mặt đế có độ delay rất thú vị, khiến cho các pha đáp đất và bứt đi trở nên bớt gắt hơn nhưng tiêu tốn năng lượng hơn. Lớp cao su trên các phiên bản cũ đã bị bỏ đi và toàn bộ mặt đế chỉ là Phylon.', '5x2xwd_simg_b5529c_250x250_maxb.jpg', 1, 'tím', 'VN', '28', 1, 1),
(42, 'Giày adidas barricade', 2450000, 'Một cơn gió cách mạng thổi vào bộ sưu tập mới này được thực hiện bởi các nhà thiết kế Yohji Yamamoto. Y3.  Thiết kế riêng cho giải Roland Garros 2016, Y-3 là trực quan nổi bật và tạo ra một cảm giác chuyển động trên sân như một chú ngựa vằn. Lấy cảm hứng từ vẻ đẹp mê hoặc của các chú ngựa vằn và phong cách thời trang từ thập niên 40 và 50, các sọc trong chuyển động là hoàn hảo cho người chơi tìm kiếm hiệu quả chuyển động.\r\nBarricade  Boost cung cấp công nghệ mới ở gót chân giúp người chơi lấy lại năng lượng và bùng nổ trên sân. Lớp đệm phản ứng từ sẽ giúp người chơi cảm thấy ít mệt mỏi và bùng nổ. Đế ngoài cao su AdiWear 6 là bền hơn bao giờ hết và cung cấp lực kéo tuyệt vời trên bất kỳ bề mặt sân nào. \r\nFit: Chiều dài phù hợp với đúng kích thước. \r\nUpper: Ballistic lớ lưới giúp người đi có cảm giác thoải mái sang trọng và thoáng tuyệt vời. TPU trong ngón chân cái để hỗ trợ thêm và độ bền.\r\nMidsole: tăng bọt cung cấp số lượng lớn trở lại với năng lượng, hấp thụ, phản ứng đệm mềm mại như khung gầm Barricade hỗ trợ midfoot và gót chân cho sự ổn định tối đa.\r\nĐế ngoài: AdiWear đế ngoài cao su 6 trong một mô hình xương cá tread đổi cung cấp lực kéo chưa từng có và độ bền trên bất kỳ bề mặt sân nào.\r\nThiết kế kỹ thuật , mô hình này đưa vào công nghệ BOOST đã cách mạng hóa thế giới giày tennis. Thích nghi với quần vợt, nó mang lại cho Boost Barricade: một trong những đôi giày biểu diễn nhất trên thị trường. Các Unity Boost tích hợp ở gót chân là một lớp đệm linh hoạt và perfoming mà cung cấp thu hồi năng lượng tốt nhất để cung cấp một bước tiến động học và thông thạo. Phần còn lại của những đôi giày gi', '91VE9N_simg_b5529c_250x250_maxb.jpg', 1, 'xám', 'VN', '28', 3, 2),
(43, 'Giày thể thao Puma', 1180000, 'Việc sắm một đôi giày thể thao là khá cần thiết cho những lúc chơi thể thao, chạy nhảy hay dạo phố. Với thiết kế đơn giản và cá tính, giày thể thao nam luôn là sản phẩm được lựa chọn số 1. Nhẹ và chắc chắn rất phù hợp với mọi hoạt động thể thao. Đế giày làm từ cao su được thiết kế cách điệu tạo sự năng động cho đôi giày.', '21.jpg', 1, 'xanh', 'VN', '32', 2, 3),
(44, 'Giay converse 2511', 2000000, 'Giày converse 2511 - Vua tốc độ là sự lựa chọn tối ưu nhất của Roger Federer được cập nhật với Nike Flyknit cho phù hợp với mọi sân đấu. Phiên bản mới nhất này với thiết kế hiện đại hơn, làm cho nó nhẹ hơn và linh động hơn bao giờ hết. Ngoài ra, độ bền đã được cải thiện với các khu vực trợ lực trên các ngón chân và bên hông. Bạn hoàn toàn có sự kết nối cho từng bước chạy cộng với sự hỗ trợ đặc biệt và sự ổn định tạo cảm hứng cho người chơi có thể bao quát toàn bộ sân ở tốc độ nhanh nhất của họ. Nike Zoom Vapor Flyknit là thực sự phù hợp cho một vị vua !\r\nXin lưu ý : Chúng tôi khuyên bạn nên đặt kích thước nhỏ hơn 1/2 size so với kích thước thông thường của bạn.\r\nUpper : Flyknit tạo cho chân của bạn sự thoải mái, nhẹ, mềm mại và ổn định đặc biệt. Công nghệ Flywire cho phép bạn tùy chỉnh phù hợp thông qua các dây để tạo năng động và phù hợp với cá nhân.\r\nMidsole : EVA midsole với Zoom Air ở gót chân để đệm thêm vào và đáp ứng sự mềm mại dưới chân. TPU ở giữa bàn chân giúp chống xoắn, lật để tránh những tai nạn không mong muốn.\r\nĐế ngoài : XDR hợp chất cao su được đặt trong một mô hình xương cá giúp cung cấp lực kéo đặc biệt trên bất kỳ bề mặt sân.', '2211.jpg', 1, 'đỏ', 'VN', '40', 4, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tenhang`
--

CREATE TABLE `tenhang` (
  `idtenhang` int(10) NOT NULL,
  `tenhang` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tenhang`
--

INSERT INTO `tenhang` (`idtenhang`, `tenhang`) VALUES
(1, 'Nike'),
(2, 'Puma'),
(3, 'Adidas'),
(4, 'Converse');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thanhtoan`
--

CREATE TABLE `thanhtoan` (
  `id_thanhtoan` int(10) NOT NULL,
  `thanhtoan` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `thanhtoan`
--

INSERT INTO `thanhtoan` (`id_thanhtoan`, `thanhtoan`) VALUES
(0, 'Chưa thanh toán'),
(1, 'Đã thanh toán');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `iduser` int(50) NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`iduser`, `username`, `password`, `phone`, `address`) VALUES
(5, 'hoa', '123456', '961931696', 'ha nam'),
(12, 'bằng', 'abc', '012345', 'hải dương'),
(48, 'phạm sỹ bằng', 'hhhh', '01238451478', 'hải dương');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`iddonhang`);

--
-- Chỉ mục cho bảng `loaisp`
--
ALTER TABLE `loaisp`
  ADD PRIMARY KEY (`idloaisp`);

--
-- Chỉ mục cho bảng `qlchitietdonhang`
--
ALTER TABLE `qlchitietdonhang`
  ADD PRIMARY KEY (`STT`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`idsanpham`);

--
-- Chỉ mục cho bảng `tenhang`
--
ALTER TABLE `tenhang`
  ADD PRIMARY KEY (`idtenhang`);

--
-- Chỉ mục cho bảng `thanhtoan`
--
ALTER TABLE `thanhtoan`
  ADD PRIMARY KEY (`id_thanhtoan`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`iduser`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `iddonhang` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=114;
--
-- AUTO_INCREMENT cho bảng `loaisp`
--
ALTER TABLE `loaisp`
  MODIFY `idloaisp` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT cho bảng `qlchitietdonhang`
--
ALTER TABLE `qlchitietdonhang`
  MODIFY `STT` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=123;
--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `idsanpham` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
--
-- AUTO_INCREMENT cho bảng `tenhang`
--
ALTER TABLE `tenhang`
  MODIFY `idtenhang` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `iduser` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

