 <?php    ini_set('display_errors','off');?>
 <?php include 'nav_user.php' ?>
         <div class="container" style="margin-top: 70px;">
     <?php 
           include '../lib/conn.php';
           include 'user_sidebar.php';   ?>
           <div class="container col-sm-9" >
             <form style="background: #D0F5A9" method="post" action="../library/update.php">
             <div class="nav nav-success" style="background: #33b75d;"><h4 style="text-align: center;">Shopping cart</h4></div>

                 <table class="table table-hover">
										    <thead>
										      <tr>
										        <th class="col-sm-1">STT</th>
										        <th class="col-sm-1">Tên sản phẩm</th>
										        <th class="col-sm-2">Hình ảnh  </th>
										        <th class="col-sm-2">Số lượng</th>
										        <th class="col-sm-1">Giá</th>
										        <th class="col-sm-2">Tổng tiền </th>
										        <th class="col-sm-1">Xóa</th>
										      </tr>
										    </thead>
			             <?php 
			              $price_total=0;
			              $stt=1;
			              if(!isset($_SESSION['cart']) or empty($_SESSION['cart'])){
			              	   echo  '<h4>Giỏ hàng trống!</h4>';

			              }
                                 
								foreach ($_SESSION['cart'] as $value) {
									
									  ?>
									    
                                        <tbody>
								         <tr>
										           <td><?php echo $stt;?></td>
										           <td><?php echo $value['tensanpham'];?></td>
										           <td><img src="../image/<?php echo $value['hinhanh'];?>" style="width: 100px;height: 50px;"></td>
										           <td>
										              <input type="text"  name="<?php echo $value['idsanpham'];?>"
										                     value="<?php echo $value['quantity'];?> "
										                     style="width: 30px;"
										              >
										              
										              	
										           </td>
										 
										           <td><?php echo $value['gia'];?></td>
										           <td><?php echo $value['gia']*$value['quantity'];?></td>
										           <td>
										                <a href="../library/delete_items.php?id=<?php echo $value['idsanpham'];?>" 
										                    onclick= 'return confirm("Bạn có muốn xóa không?")'>
										                <i class="fa fa-times" aria-hidden="true" style="color: red;"></i>
										                </a>
										           </td>
							            </tr> 
							            
								<?php
								                    $price_total+=$value['gia']*$value['quantity'];
								                    $stt++;
								}
						   
								   
			              ?>
			                 <thead>
												   <tr>
												        <th class="col-sm-2">Tổng tiền:</th>
												        <th class="col-sm-5" style="color: red;">
												           <?php echo $price_total;?> đ
												        </th>
												   </tr>
							</thead>
					       </tbody>
				   

             </table>
             <div class="nav nav-success" style="float: right;">
                  <input class="btn btn-primary" type="submit" name="ok" onclick='return confirm("Bạn có muốn update?")' value="Cập nhật">
	              <a href="user_order.php?tongtien=<?php echo $price_total  ?>" class="btn btn-danger" id="register-btn">Đặt hàng ngay</a>
	              <a href="user.php" type="button" class="btn btn-success" > Tiếp tục mua hàng </a>
              </div>
             </form>
             </div>
	</div>
<?php include '../includes/footer.php' ?>