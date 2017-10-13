 <?php    ini_set('display_errors','off');?>
<?php include 'nav_user.php' ?>
 <style type="text/css">
 	i{margin-right: 10px;}
    body{
        background: #A9F5F2;
    }

 </style>
  <div class="container">
     <div class="row" style="background:#A9A9F5;border-radius: 5px;margin-bottom:150px;height: 542px;">
       	 <h1 style="font-weight: bold;text-align: center;color: #FF4000">
          ------------------Đơn Hàng---------------------</h1>
     	<div class="col-sm-7 order" style="border: 1px solid #ccc;background: #9FF781;">
     	        <div class="nav nav-inverse "> 
     	              <h3 style="text-align: center;color: red;" class="text-success">
     	                 <i class="fa fa-address-card" aria-hidden="true"></i>
     	                 Thông Tin Người Nhận
     	              </h3>
     	        </div>
     	       
     			 <form method="post">
				  	 <div class="form-group">
				  	 	<label>Email</label>
				  	 	<input class="form-control" type="text" placeholder="Email..." name="email" required></input>
				  	 	<p class="text-danger"></p>
				  	 </div>
				  	 <div class="form-group">
				  	 	<label>Họ và tên đệm</label>
				  	 	<input class="form-control" type="text" placeholder="Họ tên..." name="hoten" required></input>
				  	 	<p class="text-danger"></p>
				  	 </div>
				  	  <div class="form-group">
				  	 	<label>Địa chỉ</label>
				  	 	<input class="form-control" type="text" placeholder="Địa chỉ..." name="address"  required></input>
				  	 	<p class="text-danger"></p>
				  	 </div>
				  	 <div class="form-group">
				  	 	<label>Điện thoại</label>
				  	 	<input class="form-control" type="text" placeholder="Điện thoại..." name="phone" required></input>
				  	 	<p class="text-danger"></p>
				  	 </div>
                     <div class="form-group">
                         <label>Hình thức thanh toán</label>
                         <select class="form-control" name="thanhtoan">
                             <option value="Thanh toán COD">Thanh toán COD</option>
                             <option value="Thanh toán trực tuyến">Thanh toán trực tuyến</option>
                             
                         </select>
                     </div>
				  	 <button class="btn btn-primary" value="Log in" name="submit">Gửi</button>
				  	 <p class="text-danger"></p>

               </form>
              
     	</div>
     	<div class="col-sm-5" style="padding-right: 0">
     		<ul class="list-group" style="color:red;">
     			<li class="list-group-item" style="background:#15f7cf;text-align: center;font-weight: bold;color: red;">Quyền lợi khách hàng khi mua sản phẩm</li>
     			<li class="list-group-item">
                    <i class="fa fa-truck" aria-hidden="true"></i>
                    Giao hàng tận nhà nhanh trong vòng 2-3 ngày 
                </li>
                <li class="list-group-item">
                    <i class="fa fa-refresh" aria-hidden="true"></i>
                    Đổi trả miễn phí trong vòng 7 ngày
                </li>
     			<li class="list-group-item">
                    <i class="fa fa-cc-paypal" aria-hidden="true"></i>
                    Giảm 10% cho những đơn hàng thanh toán trực tuyến

                </li>
     			<li class="list-group-item">
                    <i class="fa fa-cc" aria-hidden="true"></i>
                    Free ship cho những đơn trên 400k
                </li>
                <li class="list-group-item">
                
                    <img src="../image/banner2.jpg" alt="guốc cao gót" 
                       style="height: 250px;width: 100%;">
                </li>
               
                
     	</div>
     </div>
     </div>
     
   </div>
<?php include '../library/user_query_data.php' ?>
<?php include '../includes/footer.php' ?>