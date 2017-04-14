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
		      <li class="col-md-6"><a href="#"><span class="glyphicon glyphicon-user"></span> Username</a></li>
		     <li class="col-md-6"><a href="#"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
		    </ul>
		  </div>
		</div>
</nav>
 <div class="container" style="margin-top: 70px;margin-left: 89.5px;">
     <?php include 'includes/slide_show.php' ?>
     <?php include 'includes/side_bar.php' ?>
      <?php include 'lib/conn.php' ?>
       	   <div class="content col-sm-9">
       	         <div class="panel panel-danger" style="background: #337ab7;"><h4 style="text-align: center;">Top bán chạy</h4></div>
       	         
       	         
       	         <div class="row">
       	         <?php 
       	         	$sql="SELECT * from sanpham order by rand()   limit 0,3";
				  		$result=mysqli_query($conn,$sql) or die("ERROR :".mysqli_error());
				  		while ($data=mysqli_fetch_array($result,MYSQL_ASSOC)) {
				  	   ?>
       	   	    <div class="col-md-4">
							    <div class="thumbnail">
							      <a href="#">
							        <img src="image/<?php echo $data['hinhanh'] ?>" alt="Lights" style="width:252px;height: 236px;">
							         <div class="caption">
							          <p>Tên sản phẩm:<?php echo $data['tensanpham'] ?></p>
							          <p></p>
							        </div>
							        <div class="caption">
							          <p>Giá:<?php echo $data['gia'] ?></p>
							        </div>
							         <div class="caption">
							          <a href="items.php?id=<?php echo $data['idsanpham'] ?>" class="btn btn-danger">
							           <i class="fa fa-cart-plus" aria-hidden="true" style="color: red;">
							          	
							          </i>
							            Mua ngay
							          </a>
							        </div>
       	                         </div>
       	        </div>
       	       
       	        <?php } ?>
             </div>
          
          <div class="panel panel-danger" style="background: #337ab7;"><h4 style="text-align: center;">Hàng mới về</h4></div>
       	         
       	         
       	         <div class="row">
       	         <?php 
       	         	$sql="SELECT * from sanpham order by idsanpham desc   limit 0,3";
				  		$result=mysqli_query($conn,$sql) or die("ERROR :".mysqli_error());
				  		while ($data=mysqli_fetch_array($result,MYSQL_ASSOC)) {
				  	   ?>
       	   	    <div class="col-md-4">
							    <div class="thumbnail">
							      <a href="#">
							        <img src="image/<?php echo $data['hinhanh'] ?>" alt="Lights" style="width:252px;height: 236px;">
							         <div class="caption">
							          <p>Tên sản phẩm:<?php echo $data['tensanpham'] ?></p>
							          <p></p>
							        </div>
							        <div class="caption">
							          <p>Giá:<?php echo $data['gia'] ?></p>
							        </div>
							         <div class="caption">
							          <a href="items.php?id=<?php echo $data['idsanpham'] ?>" class="btn btn-danger">
							           <i class="fa fa-cart-plus" aria-hidden="true" style="color: red;">
							          	
							          </i>
							            Mua ngay
							          </a>
							        </div>
       	                         </div>
       	        </div>
       	       
       	        <?php } ?>
             </div>
             
          <div class="panel panel-danger" style="background: #337ab7;"><h4 style="text-align: center;">Hàng xem nhiều</h4></div>
       	         
       	         
       	         <div class="row">
       	         <?php 
       	         	$sql="SELECT * from sanpham order by rand()   limit 0,3";
				  		$result=mysqli_query($conn,$sql) or die("ERROR :".mysqli_error());
				  		while ($data=mysqli_fetch_array($result,MYSQL_ASSOC)) {
				  	   ?>
       	   	    <div class="col-md-4">
							    <div class="thumbnail">
							      <a href="#">
							        <img src="image/<?php echo $data['hinhanh'] ?>" alt="Lights" style="width:252px;height: 236px;">
							         <div class="caption">
							          <p>Tên sản phẩm:<?php echo $data['tensanpham'] ?></p>
							          <p></p>
							        </div>
							        <div class="caption">
							          <p>Giá:<?php echo $data['gia'] ?></p>
							        </div>
							         <div class="caption">
							          <a href="items.php?id=<?php echo $data['idsanpham'] ?>" class="btn btn-danger">
							           <i class="fa fa-cart-plus" aria-hidden="true" style="color: red;">
							          	
							          </i>
							            Mua ngay
							          </a>
							        </div>
       	                         </div>
       	        </div>
       	       
       	        <?php } ?>
             </div>
             
       </div>

	

	</div>
<?php include 'includes/footer.php' ?>