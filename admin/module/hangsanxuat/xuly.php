<?php
 include('../config.php');
 $idhang=$_GET['idhang'];
 $tenhang=$_POST['tenhang'];
 if(isset ($_POST['them'])) {
	 //them sp
 $sql="insert into hangsanxuat(tenhang) values('$tenhang')";	
	 $result=mysqli_query($conn,$sql);
	 header('location:../../quanlysanpham.php?quanli=hangsanxuat&ac=them'); 
 }elseif (isset($_POST['sua'])) {
	 //sua
	 $sql=" update hangsanxuat set tenhang='$tenhang' where idhang='$idhang'";
	 mysqli_query ($conn,$sql);
	 header ('location:../../quanlysanpham.php?quanli=hangsanxuat&ac=sua&idhang='.$idhang);
 } else{
	 $sql="delete from hangsanxuat where idhang='$idhang'";
	 mysqli_query($conn,$sql);
	 header('location:../../quanlysanpham.php?quanli=hangsanxuat&ac=them'); 
 }
?>	