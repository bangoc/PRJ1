<?php include 'includes/header.php' ?>
<?php include 'lib/conn.php' ?>
 <style type="text/css">
 	i{margin-right: 10px;}

 </style>
  <div class="container" style="margin-top: 70px;">
     <div class="row" style="background:#e7f715;border-radius: 5px;">
       <div class="col-sm-12">
       	 <h1 style="font-weight: bold;text-align: center;color: #17f715 ">Đơn Đặt Hàng</h1>
       </div>
     </div>
     <div class="row" style="margin-top: 20px;">
     	<div class="col-sm-7 order" style="border: 1px solid #ccc;">
     	         <h2 style="text-align: center;color: red;" class="text-success"><i class="fa fa-clipboard" aria-hidden="true"></i>Thông Tin Người Nhận</h2>
     			 <form method="post" action="<?php htmlspecialchars($_SERVER['PHP_SELF']) ?>">
				  	 <div class="form-group">
             <div class="form-group">
              <label>Họ tên</label>
              <input class="form-control" type="text" placeholder="Họ tên" name="hoten" required></input>
              <p class="text-danger"></p>
             </div>
				  	 	<label>Email</label>
				  	 	<input class="form-control" type="text" placeholder="Email" name="email" required></input>
				  	 	<p class="text-danger"></p>
				  	 </div>
				  	  <div class="form-group">
				  	 	<label>Địa chỉ</label>
				  	 	<input class="form-control" type="text" placeholder="Địa chỉ" name="address"  required></input>
				  	 	<p class="text-danger"></p>
				  	 </div>
				  	 <div class="form-group">
				  	 	<label>Điện thoại</label>
				  	 	<input class="form-control" type="text" placeholder="Điện thoại" name="phone" required></input>
				  	 	<p class="text-danger"></p>
				  	 </div>
				  	 <button class="btn btn-primary" value="Log in" name="submit">Gửi</button>
				  	 <p class="text-danger"></p>

               </form>
               <?php 
               		if(isset($_POST['submit'])){
                   if(isset($_GET['id'])&&filter_var($_GET['id'])) {
                          $idsanpham=$_GET['id'];
                          $query="SELECT * FROM sanpham WHERE idsanpham='$idsanpham'";
                          $result=mysqli_query($conn,$query) or die("Error: ".mysqli_error($conn));
                          $sanpham=mysqli_fetch_array($result,MYSQLI_ASSOC);
                          $gia=$sanpham['gia']; 
                    /////////////////////////////////////////////
               			$email=mysqli_real_escape_string($conn,$_POST['email']);
               			$hoten=mysqli_real_escape_string($conn,$_POST['hoten']);
               			$address=mysqli_real_escape_string($conn,$_POST['address']);
               			$phone=mysqli_real_escape_string($conn,$_POST['phone']);
               			$sql=" INSERT INTO donhang(email,hoten,address,phone,tongtien) VALUES('$email','$hoten','$address','$phone','$gia')";
               			$result1=mysqli_query($conn,$sql) or die('error :'.mysqli_error($conn));
                    //////////////////////////////////////////////
                    $sql1="SELECT iddonhang FROM donhang having  'email'='$email' and 'hoten'='$hoten' and 'address'='$address' and 'phone'='$phone'";
                    $result2=mysqli_query($conn,$sql1) or die('error:'.mysqli_error($conn));
                    $donhang=mysqli_fetch_array($result2,MYSQLI_ASSOC);
                    //////////////////////////////////////////
                    $iddonhang=$donhang['iddonhang'];
                    $sql2="INSERT INTO qlchitietdonhang(idsanpham,iddonhang,soluong) VALUES('$idsanpham','$iddonhang','1')";
                    $result3=mysqli_query($conn,$sql2);
                    
                  } 
                }
                
                ?>
     	</div>
     	<div class="col-sm-5">
     		<ul class="list-group">
     			<li class="list-group-item" style="background:#15f7cf;text-align: center;font-weight: bold;color: red;">Thông tin Đơn Hàng</li>
     			<li class="list-group-item">Tên mặt hàng: </li>
                <li class="list-group-item">Hình ảnh: </li>
     			<li class="list-group-item">Số lượng:</li>
     			<li class="list-group-item">Tổng tiền:</li>
     		</ul>
     	</div>
     </div>
     <div class="row">
     	<div class="col-sm-8" style="margin-bottom: 80px;">
     		<h3><i class="fa fa-money" aria-hidden="true"></i>Hình thức thanh toán</h3>
     		 <div class="row" style="margin-top: 30px;">
		     		<div class="form-group">
		     			<div class="col-sm-4">
		     			  <div class="row">
		     				<input type="radio" name="pay" value="">
		     				<button class="btn btn-danger" value="">Thanh toán khi nhận hàng</button>
		     				</div>
		     			</div>
		     			<div class="col-sm-4">
		     			  <div class="row">
		     				<input type="radio" name="pay" value="">
		     				<button class="btn btn-danger" value=""><i class="fa fa-paypal" aria-hidden="true"></i>Thanh toán trực tuyến</button>
		     				</div>
		     			</div>
     		           </div>
     		    </div>
     	</div>
     </div>
   </div>
<?php include 'includes/footer.php' ?>