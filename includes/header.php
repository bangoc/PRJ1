<!DOCTYPE html>
<?php
   session_start();

?>
<html>
<head>
	<title>Trang web ban giay</title>
	<meta charset="utf-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="bootstrap3/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="bootstrap3/css/main.css">
	<link rel="stylesheet" type="text/css" href="bootstrap3/css/footer.css">
	<link rel="stylesheet" type="text/css" href="library/font-awesome/css/font-awesome.css">
	<script src="bootstrap3/js/jquery-3.1.1.min.js"></script>
	<script src="bootstrap3/js/bootstrap.js"></script>

</head>
<body>
   <nav class="navbar navbar-default" role="navigation" style="background: #ed1c24;border:none;color: white;">
   	<div class="container-fluid">
   		<!-- Brand and toggle get grouped for better mobile display -->
   		<div class="navbar-header">
   			<button type="button" class="navbar-toggle" id="button-collapse">
   				<span class="sr-only">Toggle navigation</span>
   				<span class="icon-bar"></span>
   				<span class="icon-bar"></span>
   				<span class="icon-bar"></span>
   			</button>
   			<a class="navbar-brand" href="main.php">
   			   <i class="fa fa-home" aria-hidden="true"></i>
   			   Trang chủ
   			</a>
   		</div>
   
   		<!-- Collect the nav links, forms, and other content for toggling -->
   		<div class="collapse navbar-collapse navbar-ex1-collapse" id="menu-collapse">
   			<ul class="nav navbar-nav col-sm-3">
		      
		      <li><a href="#"><i class="fa fa-question-circle"></i>Liên hệ</a></li>

		       
		    </ul>
   			 <form action="search.php" method="get" enctype="multipart/form-data" class="navbar-form navbar-left">
			      <div class="input-group">
			        <input type="text" name="search" class="form-control" placeholder="Search" required>
			        <div class="input-group-btn">
			          <button class="btn btn-default"  name="submit">
			            <a href="search.php"><i class="glyphicon glyphicon-search"></i></a>
			          </button>
			        </div>
			      </div>
           </form>
   			<ul class="nav navbar-nav navbar-right">
   				  <li ><?php include 'register.php' ?></li>
		          <li ><?php include 'login.php' ?></li>
		    
		           <li>
				        <a  onclick="return alert('Bạn cần đăng nhập');"><i class="fa fa-cart-plus" aria-hidden="true"></i>Giỏ hàng(0) </a>
		          </li>
   			</ul>
   		</div><!-- /.navbar-collapse -->
   	</div>
   </nav>
   <script>
   	let button = document.getElementById('button-collapse'),
   		menu = document.getElementById('menu-collapse');

   	button.onclick = function () {
   		menu.classList.toggle('in');
   	}
   </script>
 
  