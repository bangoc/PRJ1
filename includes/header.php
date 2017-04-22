<!DOCTYPE html>
<?php
   session_start();

?>
<html>
<head>
	<title>Trang web ban laptop</title>
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
      <nav class="navbar navbar-inverse" style="position: fixed;
        z-index: 100;
         margin-top: -70px;background: #ed1c24;border:none;">
       <div class="container nav">
		  <div class="container-fluid">
		    <ul class="nav navbar-nav col-md-2">
		      <li class="active"><a href="main.php" style="background:#ed1c24; "><i class="fa fa-home" aria-hidden="true"></i>Trang chủ</a></li>

		       
		    </ul>
		     <ul class="nav navbar-nav col-md-2">
		      <li class="active"><a href="#" style="background:#ed1c24; "><i class="fa fa-question-circle"></i>Liên hệ</a></li>

		       
		    </ul>
		    <form action="search.php" method="get" enctype="multipart/form-data" class="navbar-form navbar-left col-md-3">
			      <div class="input-group">
			        <input type="text" name="search" class="form-control" placeholder="Search" required>
			        <div class="input-group-btn">
			          <button class="btn btn-default" type="submit" name="submit">
			            <a href="search.php"><i class="glyphicon glyphicon-search"></i></a>
			          </button>
			        </div>
			      </div>
           </form>
		    <ul class="nav navbar-nav navbar-right col-md-5">
		      <li class="col-md-4" style="height: 100%;width: 33%;"><?php include 'register.php' ?></li>
		      <li  class="col-md-4" style="height: 100%;width: 33%;"><?php include 'login.php' ?></li>
		    
		    <li class="col-md-4" style="height: 100%;width: 33%;">
		        <a href="#"><i class="fa fa-cart-plus" aria-hidden="true"></i>Giỏ hàng(0) </a>
		    </li>
		    </ul>
		  </div>
		</div>
</nav>