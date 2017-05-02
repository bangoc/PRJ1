
<?php 
include('../config.php');

 $id=$_GET['id'];
 
/*$iddonhang=$_POST['iddonhang'];
$hoten=$_POST['hoten'];
$phone=$_POST['phone'];
$address=$_POST['address'];
$tongtien=$_POST['tongtien'];
$hinhthucthanhtoan=$_POST['hinhthucthanhtoan']; */

if(isset($_POST['thanhtoan'])){
	 $sql=" update donhang set id_thanhtoan='1' where iddonhang='$id'";
	$result=mysqli_query($conn,$sql) or die ("error:".mysqli_errno($conn));
	header('location:../../quanlydonhang.php?quanli=donhang&ac=lietke');
}
	else{ 
$sql="delete from donhang where iddonhang='$id'";
mysqli_query($conn,$sql);
header('location:../../quanlydonhang.php?quanli=donhang&ac=lietke'); 
	}
?>
