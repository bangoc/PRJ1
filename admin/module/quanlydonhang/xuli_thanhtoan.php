
<?php 
    include('../config.php');
   $id=$_GET['id'];

	 $sql=" update donhang set id_thanhtoan='1' where iddonhang='$id'";
	$result=mysqli_query($conn,$sql) or die ("error:".mysqli_error($conn));
	header('location:../../quanlydonhang.php?quanli=donhang&ac=lietke');
	?>