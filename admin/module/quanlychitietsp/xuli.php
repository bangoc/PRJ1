<?php include('../lib/conn.php') ?>
<?php
  if(isset ($_POST['them'])) {
	     $idsanpham=$_GET['idsanpham'];
		 $tensanpham=$_POST['tensanpham'];
		 $gia=$_POST['gia'];
		 $img=$_FILES['hinhanh']['name'];
		 $hinhanh='image/'.$img;
		 move_uploaded_file($_FILES['hinhanh']['tmp_name'],"../image/".$img);
		 $mota=$_POST['mota'];
		 $loaisp=$_POST['loaisp'];
		 $size=$_POST['size'];
		 $hang=$_POST['hang'];
		 $soluong=$_POST['soluong'];
		 $xuatxu=$_POST['xuatxu'];
		 $mausac=$_POST['mausac'];
	 //them sp
		 $sql="INSERT into sanpham(tensanpham,gia,hinhanh,mota,loaisp,soluong,hang,xuatxu,mausac) 
		       values('$tensanpham','$gia','$hinhanh','$mota','$loaisp','$soluong','$hang','$xuatxu','$mausac')";	
	     $result=mysqli_query($conn,$sql) or die("Error: ".mysqli_error($conn));
			 header('Location:quanlysanpham.php?quanli=quanlychitietsp&ac=them'); 
  }
	 ?>