
<?php include 'nav_user.php' ?>
 <style type="text/css">
 	i{margin-right: 10px;}

 </style>
  <div class="container" style="margin-top: 70px;">
     <div class="row" style="background:#A9A9F5;border-radius: 5px;">
       <div class="col-sm-12">
       	 <h1 style="font-weight: bold;text-align: center;color: #FF4000"><i class="fa fa-id-card" aria-hidden="true"></i>Đơn Hàng</h1>
       </div>
     </div>
     <div class="row" style="margin-top: 20px;">
     	<div class="col-sm-7 order" style="border: 1px solid #ccc;background: #9FF781;">
     	        <div class="nav nav-inverse "> 
     	              <h2 style="text-align: center;color: red;" class="text-success">
     	                 <i class="fa fa-clipboard" aria-hidden="true"></i>
     	                 Thông Tin Người Nhận
     	              </h2>
     	        </div>
     	       
     			 <form method="post" action="<?php htmlspecialchars($_SERVER['PHP_SELF']) ?>">
				  	 <div class="form-group">
				  	 	<label>Email</label>
				  	 	<input class="form-control" type="text" placeholder="Email" name="email" required></input>
				  	 	<p class="text-danger"></p>
				  	 </div>
				  	 <div class="form-group">
				  	 	<label>Họ và tên đệm</label>
				  	 	<input class="form-control" type="text" placeholder="Họ tên" name="hoten" required></input>
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
                     <div class="form-group">
                         <label>Hình thức thanh toán</label>
                         <select class="form-control" name="thanhtoan">
                             <option selected="">--Lựa chọn hình thức thanh toán--</option>
                             <option value="Thanh toán COD">Thanh toán COD</option>
                             <option value="Thanh toán trực tuyến">Thanh toán trực tuyến</option>
                             
                         </select>
                     </div>
				  	 <button class="btn btn-primary" value="Log in" name="submit">Gửi</button>
				  	 <p class="text-danger"></p>

               </form>
              
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
     
   </div>
<?php include '../library/user_query_data.php' ?>
<?php include '../includes/footer.php' ?>