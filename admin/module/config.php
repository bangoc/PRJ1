<?php
	$tenmaychu='localhost';
	$tentaikhoan='root';
	$pass='';
	$csdl='webbangiay';
	$conn=mysqli_connect($tenmaychu,$tentaikhoan,$pass,$csdl) or die('Ko kết nối được');
	mysqli_select_db($conn,$csdl);
	if(!$conn)
  {
  	die("Error: ".mysqli_connect_error($conn));
  }
  else
	mysqli_set_charset($conn,'utf8');
?>