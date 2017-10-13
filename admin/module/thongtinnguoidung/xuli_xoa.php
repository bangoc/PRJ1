<?php 
	include('../config.php');
	$id=$_GET['id'];
	$sql="delete from user where iduser=$id ";
	mysqli_query($conn,$sql);
	header('location:../../thongtinnguoidung.php?quanli=user');
?>
