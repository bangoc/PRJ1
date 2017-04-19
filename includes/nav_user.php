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
		    <ul class="nav navbar-nav col-md-7">
		      <li class="active col-md-3">
		         <a href="main.php" style="background:#ed1c24; "><i class="fa fa-home" aria-hidden="true"></i>Trang chủ</a>
		       </li>
		      <li class="active col-sm-3">
		         <a href="#" style="background:#ed1c24; "><i class="fa fa-question-circle"></i>Liên hệ</a>
		      </li>

               <li class="active col-md-6">
                  <form class="navbar-form col-sm-6">
			      <div class="input-group">
			        <input type="text" class="form-control" placeholder="Search">
			        <div class="input-group-btn">
			          <button class="btn btn-default" type="submit">
			            <i class="glyphicon glyphicon-search"></i>
			          </button>
			        </div>
			      </div>
           </form>
               </li>
		       
		    </ul>
		    <ul class="nav navbar-nav navbar-right col-md-5">
		       <li class="col-md-3" style="height: 100%;width: 40%;">
		        <a href="cart.php"><i class="fa fa-cart-plus" aria-hidden="true"></i>Giỏ hàng(0) </a>
		       </li>
		      <li class="col-md-3" style="height: 100%;width: 20%;margin-top: 15px;
                color: white;">
                  <i class="fa fa-user-o" aria-hidden="true"></i>
		         <?php echo $_SESSION['username']; ?></li>
		      <li class="col-md-6" style="height: 100%;width: 40%;"><a href="#"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
		       </div>
		    </ul>
		  </div>
		</div>
</nav>