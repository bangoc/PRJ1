<?php 
      $usernamerr=$passwordrr="";
      $message=$username=$password="";
     if($_SERVER['REQUEST_METHOD']=='POST')
     {
     	if(empty($_POST['username']))
     	{
     		$usernamerr="Tên tài khoản không được bỏ trống!";
     	}
     	else
     		$username=$_POST['username'];
     	if(empty($_POST['password']))
     	{
     		$passwordrr="Mật khẩu không được bỏ trống!";
     	}
     	else
     		$password=$_POST['password'];
     	if(!(empty($_POST['username'])&&empty($_POST['password'])))
 	    {
		     	$query="SELECT * FROM user WHERE username='$username' and password='$password'";
		     	$result=mysqli_query($conn,$query) or die("Error: ".mysqli_error($conn));
		     	$row=mysqli_num_rows($result);
		     	if($row==0)
		     	{
		     		$message="Tên tài khoản hoặc mật khẩu không chính xác";
		     	}
		     	else
				     	{
				     		$_SESSION['username']='$username';
				     		header('Location: admin.php');
				     	}
	    }
     }

   ?>
  