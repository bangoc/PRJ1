<!DOCTYPE html>
<?php
   session_start();

?>
<html>
<head>
	<title>Trang web ban giay</title>
	<meta charset="utf-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="../bootstrap3/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="../bootstrap3/css/main.css">
	<link rel="stylesheet" type="text/css" href="../bootstrap3/css/footer.css">
	<link rel="stylesheet" type="text/css" href="../library/font-awesome/css/font-awesome.css">
	<script src="../bootstrap3/js/jquery-3.1.1.min.js"></script>
	<script src="../bootstrap3/js/bootstrap.js"></script>

</head>
<body>
<!--<nav class="navbar navbar-inverse" style="position: fixed;
        z-index: 100;
         margin-top: -70px;background: #ed1c24;border:none;">
       <div class="container nav">
		  <div class="container-fluid">
		    <ul class="nav navbar-nav col-md-7">
		      <li class="active col-md-3">
		         <a href="user.php" style="background:#ed1c24; "><i class="fa fa-home" aria-hidden="true"></i>Trang chủ</a>
		       </li>
		      <li class="active col-sm-3">
		         <a href="#" style="background:#ed1c24; "><i class="fa fa-question-circle"></i>Liên hệ</a>
		      </li>

               <li class="active col-md-6">
                    <form action="user_search.php" method="get" enctype="multipart/form-data" class="navbar-form navbar-left col-md-3">
					      <div class="input-group">
					        <input type="text" name="search" class="form-control" placeholder="Search" required>
					        <div class="input-group-btn">
					          <button class="btn btn-default" type="submit" name="submit">
					            <a href="search.php"><i class="glyphicon glyphicon-search"></i></a>
					          </button>
					        </div>
					      </div>
                   </form>
               </li>
		       
		    </ul>-->
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
		   			<a class="navbar-brand" href="user.php?username=<?php echo $_SESSION['username']; ?>">
		   			   <i class="fa fa-home" aria-hidden="true"></i>
		   			   Trang chủ
		   			</a>
		   		</div>
		   
		   		<!-- Collect the nav links, forms, and other content for toggling -->
		   		<div class="collapse navbar-collapse navbar-ex1-collapse" id="menu-collapse">
		   			<ul class="nav navbar-nav col-sm-3">
				      
				      <li><a href="#"><i class="fa fa-question-circle"></i>Liên hệ</a></li>

				       
				    </ul>
		   			 <form action="user_search.php" method="get" enctype="multipart/form-data" class="navbar-form navbar-left">
					      <div class="input-group">
					        <input type="text" name="search" class="form-control" placeholder="Search" required>
					        <div class="input-group-btn">
					          <button class="btn btn-default" type="submit" name="submit">
					            <a href="user_search.php"><i class="glyphicon glyphicon-search"></i></a>
					          </button>
					        </div>
					      </div>
		           </form>
		               </li>
				       
		    </ul>


		    <ul class="nav navbar-nav navbar-right col-md-5">
		       <li class="col-md-3" style="height: 100%;width: 40%;">
		       <?php
		        if(!isset($_SESSION['cart']) or empty($_SESSION['cart'])){
				  	      $total = 0;
				  }
				  else{
				          $total =0;
				  	      foreach ($_SESSION['cart'] as $value) {
				  	      	  $total+= $value['quantity'];

				  	      }
				  }
				?>
		        <a href="shopping_cart.php">
		            <i class="fa fa-cart-plus" aria-hidden="true"></i>Giỏ hàng(<?php echo $total; ?>) 
		        </a>
		       </li>
		      <li class="col-md-3" style="height: 100%;width: 20%;margin-top: 15px;
                color: white;">
                  <i class="fa fa-user-o" aria-hidden="true"></i>
		         <?php echo $_SESSION['username']; ?></li>
		      <li class="col-md-6" style="height: 100%;width: 40%;"><a href="../library/user_logout.php"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
		       </div>
		    </ul>
		  </div>
		</div>
</nav>
<script>
   	let button = document.getElementById('button-collapse'),
   		menu = document.getElementById('menu-collapse');

   	button.onclick = function () {
   		menu.classList.toggle('in');
   	}
   </script>