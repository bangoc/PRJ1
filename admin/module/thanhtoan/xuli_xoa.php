<?php ?>
<?php 
    include('../config.php');
   $id=$_GET['id'];

$sql="delete from donhang where iddonhang='$id'";
mysqli_query($conn,$sql);
header('location:../../thanhtoan.php?quanli=thanhtoan&ac=lietke'); 