<?php
         include('../config.php');
         $id=$_GET['id'];
		 $tensanpham=$_POST['tensanpham'];
		 $gia=$_POST['gia'];
		 $hinhanh=$_FILES['hinhanh']['name'];
		 $hinhanh_tmp=$_FILES['hinhanh']['tmp_name'];
		 move_uploaded_file($hinhanh_tmp,'../../../image/'.$hinhanh);
		 $mota=$_POST['mota'];
		 $size=$_POST['size'];
		 $soluong=$_POST['soluong'];
		 $xuatxu=$_POST['xuatxu'];
		 $mausac=$_POST['mausac'];
		 $idtenhang=$_POST['idtenhang'];
		 $idloaisp=$_POST['idloaisp'];
		 
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