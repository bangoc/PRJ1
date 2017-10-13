
<?php 
    include('../config.php');
   $id=$_GET['id'];

$sql="delete from donhang where iddonhang='$id'";
mysqli_query($conn,$sql);
header('location:../../quanlydonhang.php?quanli=donhang&ac=lietke'); 
	
	
?>