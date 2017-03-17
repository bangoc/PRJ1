<?php
         include('../config.php');
         $id=$_GET['id'];
		 $tensanpham=$_POST['tensanpham'];
		 $gia=$_POST['gia'];
		 $hinhanh=$_FILES['hinhanh']['name'];
		 $hinhanh_tmp=$_FILES['hinhanh']['tmp_name'];
		 move_uploaded_file($hinhanh_tmp,'../../../image/'.$hinhanh);
		 $mota=$_POST['mota'];
		 $loaisp=$_POST['loaisp'];
		 $size=$_POST['size'];
		 $hang=$_POST['hang'];
		 $soluong=$_POST['soluong'];
		 $xuatxu=$_POST['xuatxu'];
		 $mausac=$_POST['mausac'];
  if(isset ($_POST['them'])) {
	 //them sp
	 
		 $sql="INSERT into sanpham(tensanpham,gia,hinhanh,mota,loaisp,soluong,hang,xuatxu,mausac,size) 
		       values('$tensanpham','$gia','$hinhanh','$mota','$loaisp','$soluong','$hang','$xuatxu','$mausac','$size')";	
	     $result=mysqli_query($conn,$sql) or die("Error: ".mysqli_error($conn));
			 header('Location:../../quanlysanpham.php?quanli=quanlychitietsp&ac=lietke'); 
  }elseif (isset($_POST['sua'])) {
	 //sua
	 if ($hinhanh!='') {
	 $sql=" update sanpham set tensanpham='$tensanpham',gia='$gia',hinhanh='$hinhanh',mota='$mota',loaisp='$loaisp',soluong='$soluong',hang='$hang',xuatxu='$xuatxu',mausac='$mausac' where idsanpham='$id'";
	 }
	 else {
		  $sql=" update sanpham set tensanpham='$tensanpham',gia='$gia',hinhanh='$hinhanh',mota='$mota',loaisp='$loaisp',soluong='$soluong',hang='$hang',xuatxu='$xuatxu',mausac='$mausac', where idsanpham='$id'";
		 }
	 $result=mysqli_query($conn,$sql) or die("error:" .mysqli_error($conn));
	    header('Location:../../quanlysanpham.php?quanli=quanlychitietsp&ac=lietke&id='.$id);  
 } else{
	 $sql="delete from sanpham where idsanpham='$id'";
	 mysqli_query($conn,$sql);
	 header('location:../../quanlysanpham.php?quanli=quanlychitietsp&ac=lietke'); 
 }
	 ?>