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
	<link rel="stylesheet" type="text/css" href="library/font-awesome/css/font-awesome.css">
</head>
<body>
    <nav style="position: fixed;
        z-index: 100;
         margin-top: -70px;">
      <div class="header">
          <ul>
             <li  class="intro_left">
	                <ul>
			          	 <li class="home">
			          	         <a href="main.php">
			  	 			       <i class="fa fa-home" aria-hidden="true"></i>
			  	 			          Trang chủ 
			  	 			     </a>
			  	 	     </li>
			          	 <li>
			          	 	    <a href="#">
			  	 			       <i class="fa fa-question-circle"></i>
			  	 			       Hỗ trợ trực tuyến
			  	 			     </a>
			          	 </li>
			          	 <li>
			          	 	<div class="form_search">
			          	 		  <input type="text" placeholder="Tìm kiếm sản phẩm" class="search">
			          	 	      <button class="searchbutton" type="button"><i class="fa fa-search fa-lg" style="color: black;"></i></button>
			           
			          	 	</div>
			          	 </li>
		           </ul>
          	 </li>
          	 <li class="intro_right">
				          	   <ul>
				       			
						  	 			<li>
                                            <a href="#"><?php echo $_SESSION['username']; ?></a>
						  	 			
						  	 			</li>
						  	 			<li>

						  	 				<a href="#"><i class="fa fa-cart-plus" aria-hidden="true"></i>Giỏ hàng(0) </a>
						  	 			</li>
						  	 			
						  	   </ul>
	
		  	 </li>
          </ul>
        </div>
      </nav>
 <div class="container" style="margin-top: 70px;">
     <?php include 'includes/slide_show.php' ?>
  <!--Phan content-->
     <?php include 'includes/main_content.php' ?>
	</div>
<?php include 'includes/footer.php' ?>