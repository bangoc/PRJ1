<?php
$tenmaychu='localhost';
$tentaikhoan='root';
$pass='';
$csdl='webbangiay';
$conn=mysqli_connect($tenmaychu,$tentaikhoan,$pass,$csdl);
if(!$conn)
{
	echo "Kết nối không thành công";
}
else
{
	mysqli_set_charset($conn,'utf8');	
}
?>

