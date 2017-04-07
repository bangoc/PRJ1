
<!DOCTYPE html>
<html>
<head>
	<title>Trang web ban laptop</title>
	<meta charset="utf-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="bootstrap3/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="bootstrap3/css/main.css">
	<link rel="stylesheet" type="text/css" href="library/font-awesome/css/font-awesome.css">
	<script src="bootstrap3/js/jquery-3.1.1.min.js"></script>
	<script src="bootstrap3/js/bootstrap.js"></script>

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
						  	 			  <i class="fa fa-user-o" aria-hidden="true"></i> <p><?php echo $_SESSION['username']; ?></p>
						  	 			</li>
						  	 			<li>
                                           <a href="log_out.php"> <i class="fa fa-user" aria-hidden="true"></i>Đăng xuất  </a>
						  	 			   

						  	 			</li>
						  	 			<li>

						  	 				<a href="#"><i class="fa fa-cart-plus" aria-hidden="true"></i>Giỏ hàng(0) </a>
						  	 			</li>
						  	   </ul>
	
		  	 </li>
          </ul>
        </div>
      </nav>