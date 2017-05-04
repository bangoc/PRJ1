<?php 
    include('../config.php');
    $id_xoa=$_GET['id_xoa'];
 
   

$sql="delete from qlchitietdonhang where STT='$id_xoa'";
mysqli_query($conn,$sql);
header('location:../../qlchitietdonhang.php?quanli=chitietdonhang&ac=lietke_xoa'); 
	
	
?>