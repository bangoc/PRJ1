-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 23, 2017 lúc 05:04 CH
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
  `idgiohang` int(50) DEFAULT NULL,
  `iddonhang` int(50) NOT NULL,
  `phone` int(20) NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tongtien` int(20) NOT NULL,
  `hoten` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`idgiohang`, `iddonhang`, `phone`, `email`, `address`, `tongtien`, `hoten`) VALUES
(5, 10, 961931696, 'ngothuyhoa@gmail.com', 'ha nam', 1200, 'Ngô Thúy Hoa');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giohang`
--

CREATE TABLE `giohang` (
  `idgiohang` int(50) NOT NULL,
  `iduser` int(50) NOT NULL,
  `idsanpham` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
(1, 10, 42, 1, '26');

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
  `idtenhang` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idloaisp` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`idsanpham`, `tensanpham`, `gia`, `mota`, `hinhanh`, `soluong`, `mausac`, `xuatxu`, `size`, `idtenhang`, `idloaisp`) VALUES
(28, 'Giày thể thao ', 1200, 'Giày rất đẹp', 'giaypuma.jpg', 2, 'Blue', 'Việt Nam', '25', '4', 2),
(33, 'Adidas Superstar 1 NBA ', 3000, '', 'images (1).jpg', 3, 'Vàng', 'Việt Nam', '40', '3', 3),
(34, 'Adidas Adicolor Series', 4000, '', 'images.jpg', 4, 'Black', 'Việt Nam', '42', '3', 3),
(35, 'NIKE AIR 0D', 2500, 'Đối với giày thể thao, thì việc chọn lựa đúng với nhu cầu của mình rất quan trọng. Điều đó sẽ ảnh hưởng trực tiếp đến quá trình tập luyện và sức khỏe của bạn. Thấu hiểu được điều đó, mà giày Nike luôn cho ra đời những sản phẩm có cấu tạo và đặc tính riêng biệt, chuyên dụng hay đa năng, tùy từng loại để người tiêu dùng có thể lựa chọn. Những dòng đặc trưng mà giày Nike luôn chiếm lĩnh trên thị trường đó chính là Nike Lifestyle, Nike Running, Nike Training and Gym và Jordan dành riêng cho bóng rổ,… Không cần bàn cãi về chất lượng của các dòng giày Nike, điều mà mỗi một tín đồ cần để mắt đến, đó chính là mục đích sử dụng và kiểu dáng mà mình yêu thích.', '21211.jpg', 2, 'đen', 'Mỹ', '43', '1', 3),
(36, 'NIKE Luna', 2300, 'Đối với giày thể thao, thì việc chọn lựa đúng với nhu cầu của mình rất quan trọng. Điều đó sẽ ảnh hưởng trực tiếp đến quá trình tập luyện và sức khỏe của bạn. Thấu hiểu được điều đó, mà giày Nike luôn cho ra đời những sản phẩm có cấu tạo và đặc tính riêng biệt, chuyên dụng hay đa năng, tùy từng loại để người tiêu dùng có thể lựa chọn. Những dòng đặc trưng mà giày Nike luôn chiếm lĩnh trên thị trường đó chính là Nike Lifestyle, Nike Running, Nike Training and Gym và Jordan dành riêng cho bóng rổ,… Không cần bàn cãi về chất lượng của các dòng giày Nike, điều mà mỗi một tín đồ cần để mắt đến, đó chính là mục đích sử dụng và kiểu dáng mà mình yêu thích.', '21.jpg', 5, 'đen+xanh', 'Anh', '42', '1', 1),
(37, 'NIKE AIR Jordan', 5000, 'Đối với giày thể thao, thì việc chọn lựa đúng với nhu cầu của mình rất quan trọng. Điều đó sẽ ảnh hưởng trực tiếp đến quá trình tập luyện và sức khỏe của bạn. Thấu hiểu được điều đó, mà giày Nike luôn cho ra đời những sản phẩm có cấu tạo và đặc tính riêng biệt, chuyên dụng hay đa năng, tùy từng loại để người tiêu dùng có thể lựa chọn. Những dòng đặc trưng mà giày Nike luôn chiếm lĩnh trên thị trường đó chính là Nike Lifestyle, Nike Running, Nike Training and Gym và Jordan dành riêng cho bóng rổ,… Không cần bàn cãi về chất lượng của các dòng giày Nike, điều mà mỗi một tín đồ cần để mắt đến, đó chính là mục đích sử dụng và kiểu dáng mà mình yêu thích.', '21212.jpg', 7, 'silver', 'Mỹ', '42', '1', 1),
(38, 'Puma Ignite', 3200, 'Trẻ trung, năng động, nam tính và sành điệu cùng Giày Sneaker nam dáng xỏ của thương hiệu Zapas. Tông đen sang trọng, đẳng cấp cùng chất liệu vải sợi cao cấp, mềm mại, không mang đến cảm giác đau chân khi phải di chuyển nhiều, sản phẩm tạo nên sự tin tưởng tuyệt đối trong sự lựa chọn của giới trẻ thời nay.', 'images.jpg', 3, 'đen', 'pháp', '41', '2', 1),
(39, 'Ignite XT', 3100, 'Trẻ trung, năng động, nam tính và sành điệu cùng Giày Sneaker nam dáng xỏ của thương hiệu Zapas. Tông đen sang trọng, đẳng cấp cùng chất liệu vải sợi cao cấp, mềm mại, không mang đến cảm giác đau chân khi phải di chuyển nhiều, sản phẩm tạo nên sự tin tưởng tuyệt đối trong sự lựa chọn của giới trẻ thời nay.', '2211.jpg', 4, 'đỏ', 'pháp', '40', '2', 3),
(40, 'Converse Classic', 1200, 'Trẻ trung, năng động, nam tính và sành điệu cùng Giày Sneaker nam dáng xỏ của thương hiệu Zapas. Tông đen sang trọng, đẳng cấp cùng chất liệu vải sợi cao cấp, mềm mại, không mang đến cảm giác đau chân khi phải di chuyển nhiều, sản phẩm tạo nên sự tin tưởng tuyệt đối trong sự lựa chọn của giới trẻ thời nay.', '111.jpg', 10, 'đen+trắng', 'Việt Nam', '40', '4', 3),
(41, 'NIKE Luna S', 2600, 'Trẻ trung, năng động, nam tính và sành điệu cùng Giày Sneaker nam dáng xỏ của thương hiệu Zapas. Tông đen sang trọng, đẳng cấp cùng chất liệu vải sợi cao cấp, mềm mại, không mang đến cảm giác đau chân khi phải di chuyển nhiều, sản phẩm tạo nên sự tin tưởng tuyệt đối trong sự lựa chọn của giới trẻ thời nay.', '121.jpg', 4, 'đen', 'Mỹ', '41', '1', 3),
(42, 'Giày cao gót', 1500, 'Dành cho nữ', 'caogot.jpg', 1, 'Red', 'Mỹ', '25,26,27', '1', 2);

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
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `iduser` int(50) NOT NULL,
  `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` int(20) NOT NULL,
  `address` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPACT;

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
-- Chỉ mục cho bảng `giohang`
--
ALTER TABLE `giohang`
  ADD PRIMARY KEY (`idgiohang`);

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
-- AUTO_INCREMENT cho bảng `giohang`
--
ALTER TABLE `giohang`
  MODIFY `idgiohang` int(50) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT cho bảng `loaisp`
--
ALTER TABLE `loaisp`
  MODIFY `idloaisp` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT cho bảng `qlchitietdonhang`
--
ALTER TABLE `qlchitietdonhang`
  MODIFY `STT` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `idsanpham` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
--
-- AUTO_INCREMENT cho bảng `tenhang`
--
ALTER TABLE `tenhang`
  MODIFY `idtenhang` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `iduser` int(50) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
