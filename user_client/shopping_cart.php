 <?php include 'nav_user.php' ?>
         <div class="container" style="margin-top: 70px;">
     <?php 
           include '../lib/conn.php';
           include 'user_sidebar.php';   ?>
           <div class="container col-sm-9" >
             <form style="background: #D0F5A9">
             <div class="nav nav-success" style="background: #33b75d;"><h4 style="text-align: center;">Shopping cart</h4></div>
                 <table class="table table-hover">
										    <thead>
										      <tr>
										        <th class="col-sm-1">ID</th>
										        <th class="col-sm-4">Tensp</th>
										        <th class="col-sm-2">Hình ảnh  </th>
										        <th class="col-sm-2">Số lượng</th>
										        <th class="col-sm-2">Giá</th>
										         <th class="col-sm-1">Xóa</th>
										      </tr>
										    </thead>
			             <?php 

								foreach ($_SESSION['cart'] as $value) {
									
									  ?>
									    
                                        <tbody>
								         <tr>
										           <td><?php echo $value['idsanpham'];?></td>
										           <td><?php echo $value['tensanpham'];?></td>
										           <td><img src="../image/<?php echo $value['hinhanh'];?>" style="width: 100px;height: 50px;"></td>
										           <td><?php echo $value['quantity'];?></td>
										           <td><?php echo $value['gia'];?></td>
										           <td>
										                <a href="delete_items.php">
										                <i class="fa fa-times" aria-hidden="true" style="color: red;"></i>
										                </a>
										           </td>
							            </tr> 
							            
								<?php
								}
								   
			              ?>
			                 <thead>
												   <tr>
												        <th class="col-sm-2">Tổng tiền:</th>
												        <th class="col-sm-5" style="color: red;">
												           <?php echo $value['quantity']*$value['gia'];?>
												        </th>
												   </tr>
							</thead>
					       </tbody>
				   

             </table>
             <div class="nav nav-success" style="float: right;">
	              <a href="user_order.php" class="btn btn-danger" id="register-btn">Đặt hàng ngay</a>
	              <a href="user.php" type="button" class="btn btn-success" > Tiếp tục mua hàng </a>
              </div>
             </form>
             </div>
	</div>
<?php include '../includes/footer.php' ?>