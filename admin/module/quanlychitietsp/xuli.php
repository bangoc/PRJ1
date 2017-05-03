<?php
         include('../config.php');
         
		 
  if(isset ($_POST['them'])) {
	 //them sp
	 
		 $sql="INSERT into sanpham(tensanpham,gia,hinhanh,mota,idloaisp,soluong,idtenhang,xuatxu,mausac,size) 
		       values('$tensanpham','$gia','$hinhanh','$mota','$idloaisp','$soluong','$idtenhang','$xuatxu','$mausac','$size')";	
	     $result=mysqli_query($conn,$sql) or die("Error: ".mysqli_error($conn));
			 header('Location:../../quanlysanpham.php?quanli=quanlychitietsp&ac=lietke'); 
  }elseif (isset($_POST['sua'])) {
	 //sua
	 if ($hinhanh!='') {
	 $sql=" update sanpham set tensanpham='$tensanpham',gia='$gia',hinhanh='$hinhanh',mota='$mota',idloaisp='$idloaisp',soluong='$soluong',idtenhang='$idtenhang',xuatxu='$xuatxu',mausac='$mausac',size='$size' where idsanpham='$id'";
	 }
	 else {
		  $sql=" update sanpham set tensanpham='$tensanpham',gia='$gia',mota='$mota',idloaisp='$idloaisp',soluong='$soluong',idtenhang='$idtenhang',xuatxu='$xuatxu',mausac='$mausac',size='$size' where idsanpham='$id'";
		 }
	 $result=mysqli_query($conn,$sql) or die("error:" .mysqli_error($conn));
	    header('Location:../../quanlysanpham.php?quanli=quanlychitietsp&ac=lietke&id='.$id);  
	    // xoa
 } else{
	 $sql="delete from sanpham where idsanpham='$id'";
	 mysqli_query($conn,$sql);
	 header('location:../../quanlysanpham.php?quanli=quanlychitietsp&ac=lietke'); 
 }
	 ?>