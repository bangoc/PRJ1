<?php
$tenmaychu='localhost';
$tentaikhoan='root';
$pass='';
$csdl='webbangiay';
$conn=mysqli_connect($tenmaychu,$tentaikhoan,$pass,$csdl);
mysqli_select_db($conn,$csdl);
if(!$conn)
{
	echo "Kết nối không thành công";
}
else
{
	mysqli_set_charset($conn,'utf8');	
}
?>

