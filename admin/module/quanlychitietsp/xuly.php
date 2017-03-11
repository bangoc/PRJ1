<?php
 include('../config.php');
 $id=$_GET['id'];
 $tensp=$_POST['tensp'];
 $giasp=$_POST['giasp'];
 $hinhanh=$_POST['hinhanh'];
 $motasp=$_POST['motasp'];
 $loaisp=$_POST['loaisp'];
 $soluong=$_POST['soluong'];
 if(isset ($_POST['them'])) {
	 //them sp
 $sql="insert into chitietloaisp(tensp,giasp,hinhanh,motasp,loaisp,soluong) values('$tensp','$giasp','$hinhanh','$motasp','$loaisp','$soluong')";	
	 $result=mysqli_query($conn,$sql);
	 header('location:../../quanlysanpham.php?quanli=quanlychitietsp&ac=them'); 
 }
	 ?>