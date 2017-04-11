<?php session_start(); ?>
<?php include('module/config.php'); ?>
<?php
ob_start();
if(isset($_SESSION["id"])){
	header("location: admin.php");
}
?>
<html>
<link rel="stylesheet" type="text/css" href="mos-css/style.css">
<head>
</head>
<body>
<div class="form-wrapper">
  
  <form action="#" method="post">
    <h3>Đăng nhập hệ thống</h3>
	
    <div class="form-item">
		<input type="text" name="username" required="required" placeholder="Username" autofocus required></input>
    </div>
    
    <div class="form-item">
		<input type="password" name="password" required="required" placeholder="Password" required></input>
    </div>
    
    <div class="button-panel">
		<input type="submit" class="button" title="Log In" name="login" value="Đăng nhập"></input>
    </div>
  </form>
  <?php
	if (isset($_POST['login']))
		{
			$username = mysqli_real_escape_string($conn, $_POST['username']);
			$password = mysqli_real_escape_string($conn, $_POST['password']);
			
			$query 		= mysqli_query($conn, "SELECT * FROM admin WHERE  password='$password' and username='$username'");
			$row		= mysqli_fetch_array($query);
			$num_row 	= mysqli_num_rows($query);
			
			if ($num_row > 0) 
				{			
					$_SESSION['id']=$row['id'];
					header('location:admin.php');
					
				}
			else
				{
					echo 'Tên tài khoản và mật khẩu không tồn tại';
				}
		}
  ?>
  
</div>

</body>
</html>