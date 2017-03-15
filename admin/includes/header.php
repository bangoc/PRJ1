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
													
			
					<?php
						   $conn=mysqli_connect("localhost","root","","webbangiay(2)");
						  	if(!$conn)
						  	{
						    die("Error: ".mysqli_connect_error($conn));
						 	 }
						 	 else
						   	mysqli_set_charset($conn,'utf8');

						        if(isset($_POST["submit"])) {
						     
						            $username = $_POST["username"];
						            $email = $_POST["email"];
						            $password = $_POST["password"];
						            $phone= $_POST["phone"];
						           	$address=$_POST["address"];
						           
						                    // Kiểm tra tài khoản đã tồn tại chưa
						                   $sql="SELECT * FROM user WHERE username='$username'";
						                    $kt=mysqli_query($conn, $sql) or die("error: ".mysqli_error($conn));
						                    if(mysqli_num_rows($kt)  > 0){
						                        echo "Tài khoản đã tồn tại";
						                    }else{
						                        //thực hiện việc lưu trữ dữ liệu vào db
						                        $sql = "INSERT INTO user(
						                            username,
						                            password,
						                            phone,
						                            email,
						                            address
						                            ) VALUES (
						                            '$username',
						                            '$password',
						                            '$phone',
						                            '$email',
						                            '$address'
						                            )";}
						                        // thực thi câu $sql với biến conn lấy từ file connection.php
						                        mysqli_query($conn,$sql);
						                        echo "chúc mừng bạn đã đăng ký thành công";
						                  }
						                                        
						                    
						              
						     ?>
								
														 <form action="main.php" method="POST">
														  <div class="form-group">
														    <label for="name">UserName:</label>
														    <input type="text"  name="username" class="form-control" id="email">
														  </div>
														  <div class="form-group">
														    <label for="email">Email</label>
														    <input type="email"  name="email" class="form-control" id="pwd">
														  </div>
														   <div class="form-group">
														    <label for="pwd">Password</label>
														    <input type="password"  name="password" class="form-control" id="pwd">
														  </div>
														  <div class="form-group">
														    <label for="pwd">Phone</label>
														    <input type="text"  name="phone" class="form-control" id="pwd">
														  </div>
														  <div class="form-group">
														    <label for="pwd">Address</label>
														    <input type="text" name="address" class="form-control" id="pwd">
														  </div>
									
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