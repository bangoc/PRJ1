<?php include('../lib/conn.php') ?>
 

<?php
 
  	    $id=$_GET['$id'];
  		$iddonhang=$_GET['iddonhang'];
	     $tensanpham=$_POST['tensanpham'];
		 $gia=$_POST['gia'];
		 $hinhanh=$_POST['hinhanh'];
		 $soluong=$_POST['soluong'];
		 $mausac=$_POST['mausac'];
		 $xuatxu=$_POST['xuatxu'];
		 $size=$_POST['size'];
		 $tenhang=$_POST['tenhang'];
		 $loaisp=$_POST['loaisp'];
	 // liet ke don hang

		 if($donhang.iddonhang=$qlchitietdonhang.iddonhang) {
		 $sql="INSERT into qlchitietdonhang (iddonhang,tensanpham,gia,hinhanh,soluong,mausac,xuatxu,size,tenhang,loaisp) 
		       values('$iddonhang','$tensanpham','$gia','$hinhanh','$soluong','$mausac','$xuatxu','$size','$tenhang','$loaisp')";	

	     $result=mysqli_query($conn,$sql) or die("Error: ".mysqli_error($conn));
			
 }
 
	 ?> 
