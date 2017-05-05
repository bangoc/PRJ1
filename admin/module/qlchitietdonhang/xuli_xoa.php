<?php 
    include('../config.php');
    $id_xoa=$_GET['id_xoa'];
    $id =  $_GET['id'];
 
   

$sql="delete from qlchitietdonhang where STT='$id_xoa'";
mysqli_query($conn,$sql);
header('location:../../qlchitietdonhang.php?quanli=chitietdonhang&ac=lietke&id='.$id); 
	
	
?>