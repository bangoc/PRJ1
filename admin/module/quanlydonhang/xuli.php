<?php include('../lib/conn.php') ?>
<?php
  if(isset ($_POST['them'])) {
	     $hoten=$_GET['hoten'];
		 $phone=$_POST['phone'];
		 $email=$_POST['email'];
		 $address=$_POST['address'];
		 $tongtien=$_POST['tongtien'];
		 $iddonhang=$_GET['iddonhang'];
	 // liet ke don hang
		 $sql="INSERT into donhang (iddonhang,hoten,phone,email,address,tongtien) 
		       values('$iddonhang','$hoten','$phone','$email','$address','$tongtien')";	
	     $result=mysqli_query($conn,$sql) or die("Error: ".mysqli_error($conn));
			
  }
	 ?>