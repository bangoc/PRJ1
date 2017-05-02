
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="mos-css/web.css"  />
<title>Tìm kiếm</title>

</head>
 	 
<body>
<div class="container" style="width: 1300px; border: 1px solid #dcdcdc ; margin: 5px auto;  ">
<?php
     include('module/config.php') ?>
	<?php include('module/modau_donhang.php') ?>
<?php 
    include ('module/menu.php');
	
?>
<div id="wrapper" style="width:1300px; background:url(mos-css/img/d.PNG); font-size:14px">
  <?php 
   
	include ('module/query_timkiemdh.php');?>
</div>
<?php include ('module/footder.php');?>

</div>
</body>
</html>
