<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="mos-css/web.css"  />
	<title>Trang quan tri</title>
</head>
 	 
<body>
	<?php
		session_start();
		if(!isset($_SESSION['dangnhap'])){
			header('location:login.php');
		}
	?>
	<?php
		include('module/config.php');
		include('module/modau.php');
		include ('module/menu.php');
	?>
	<div id="wrapper" style="width:100%; background:url(mos-css/img/d.PNG); font-size:14px">
	  <?php 
	   include ('module/content.php');	
	?>
	</div>
	<?php include ('module/footder.php')?>
</body>
</html>