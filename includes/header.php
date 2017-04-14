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
		    <form class="navbar-form navbar-left col-md-4">
			      <div class="input-group">
			        <input type="text" class="form-control" placeholder="Search">
			        <div class="input-group-btn">
			          <button class="btn btn-default" type="submit">
			            <i class="glyphicon glyphicon-search"></i>
			          </button>
			        </div>
			      </div>
           </form>
		    <ul class="nav navbar-nav navbar-right col-md-4">
		      <li class="col-md-6"><?php include 'register.php' ?></li>
		      <li  class="col-md-6"><?php include 'login.php' ?></li>
		    </ul>
		  </div>
		</div>
</nav>