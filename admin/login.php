<?php
  include('module/config.php');
  session_start();
    if(isset($_POST['login'])){
    $username=$_POST['username'];
    $password=$_POST['password'];
    $sql="select * from admin where username='$username' and password='$password'";
    $query=mysqli_query($conn,$sql);
    $nums=mysqli_num_rows($query);
    if($nums>0){
      $_SESSION['dangnhap']=$username;
      header('location:admin.php');
    }else{
      header('location:login.php');
    }
  }
?>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Login Form</title>
  
	<link rel="stylesheet" type="text/css" href="mos-css/style.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

</head>

<body>

  <div class="login">
  <h1>Login</h1>
    <form action="" method="post">
      <input type="text" name="username" placeholder="Username" required="required" />
        <input type="password" name="password" placeholder="Password" required="required" />
        <button type="submit" name="login" class="btn btn-primary btn-block btn-large">Sign in.</button>
    </form>
</div>

</body>
</html>
