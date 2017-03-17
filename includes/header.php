<!DOCTYPE html>
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
						  	 				<!-- Trigger the modal with a button -->
											<a role="button" data-toggle="modal" data-target="#myModal"><i class="fa fa-user-o" aria-hidden="true"></i>Đăng kí</a>

											<!-- Modal -->
											<div id="myModal" class="modal fade" role="dialog">
											  <div class="modal-dialog">

											    <!-- Modal content-->
											    <div class="modal-content">
											      <div class="modal-header">
											        <button type="button" class="close" data-dismiss="modal">&times;</button>
											        <h4 class="modal-title">Đăng kí</h4>
											      </div>
											      <div class="modal-body">											     
														 
											            <?php include 'lib/signup.php' ?>
													    <form action="login.php" method="POST">
														  <div class="form-group">
															    <label for="name">UserName:</label>
															    <input type="text"  name="name" class="form-control" id="email" required>
														 </div>
														  <div class="form-group">
															    <label for="email">Email</label>
															    <input type="email"  name="email" class="form-control" id="pwd" required>
														  </div>
														   <div class="form-group">
															    <label for="pwd">Password</label>
															    <input type="password"  name="password" class="form-control" id="pwd"
															    required>
														  </div>
														  <!-- <div class="form-group">
														    <label for="email">Email</label>
														    <input type="email"  name="email" class="form-control" id="pwd">
														  </div>
														  <div class="form-group">
															    <label for="pwd">Phone</label>
															    <input type="text"  name="phone" class="form-control" id="pwd">
														  </div>
														  <div class="form-group">
															    <label for="pwd">Address</label>
															    <input type="text" name="address" class="form-control" id="pwd">
														  </div>
<<<<<<< HEAD
															-->
														  <button type="submit" name="submit" class="btn btn-primary">Submit</button>
														</form>
											      </div>
											      <div class="modal-footer">
											        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
											      </div>

											    </div>

											  </div>
											</div>
						  	 			</li>
						  	 			<li>

						  	 				<a href="login.php"><i class="fa fa-user" aria-hidden="true"></i>Đăng nhập</a>

						  	 			</li>
						  	 			<li>

						  	 				<a href="#"><i class="fa fa-cart-plus" aria-hidden="true"></i>Giỏ hàng(0) </a>
						  	 			</li>
						  	   </ul>
	
		  	 </li>
          </ul>
        </div>
      </nav>