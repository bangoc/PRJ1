 <?php include 'nav_user.php' ?>
         <div class="container" style="margin-top: 70px;">
     <?php 
           include '../lib/conn.php';
           include 'user_sidebar.php';   ?>
    
           <div class="container col-sm-9" >

             <form style="background: #D0F5A9" method="post" action="../library/update.php">
             <div class="nav nav-success" style="background: #33b75d;"><h4 style="text-align: center;">Đơn hàng </h4></div>

                 <table class="table table-hover">
										    <thead>
										      <tr>
										        <th class="col-sm-1">STT</th>
										        <th class="col-sm-2">Tên sản phẩm</th>
										        <th class="col-sm-2">Hình ảnh  </th>
										        <th class="col-sm-2">Số lượng</th>
										        <th class="col-sm-1">Giá</th>
										        <th class="col-sm-2">Size</th>	
										      </tr>
										    </thead>
			            <?php if(isset($_SESSION['username'])){
							$sql1="SELECT * FROM user where username='".$_SESSION['username']."'";
							$result1=mysqli_query($conn,$sql1);
							$value1=mysqli_fetch_array($result1,MYSQLI_ASSOC);
							$iduser=$value1['iduser'];
							$sql="SELECT * FROM user,donhang,qlchitietdonhang,sanpham WHERE user.iduser=donhang.iduser and qlchitietdonhang.iddonhang=donhang.iddonhang and qlchitietdonhang.idsanpham=sanpham.idsanpham and donhang.id_thanhtoan=0  and user.iduser=$iduser order by donhang.iddonhang ";
							$result=mysqli_query($conn,$sql);
							echo mysqli_num_rows($result);
							$value=mysqli_fetch_assoc($result);
							$stt=1;
						}
						if(mysqli_num_rows($result)==0){
									echo "BẠN KHÔNG CÓ ĐƠN HÀNG NÀO !!!";
								}else
							while ($value=mysqli_fetch_assoc($result)) {
								
								
							 ?>
              
                                        <tbody>
								         <tr>
										           <td><?php echo $stt; ?></td>
										           <td><?php echo $value['tensanpham'];?></td>
										           <td><img src="../image/<?php echo $value['hinhanh'];	 ?>" style="width: 100px;height: 50px;"></td>
										           <td><?php echo $value['soluong']; ?> </td>
										           <td><?php echo $value['gia']; ?></td>
										           <td><?php echo $value['size'] ?></td>
							            </tr> 
							            
			                 <thead>
												   <tr>
												        <th class="col-sm-2">Tổng tiền:</th>
												        <th class="col-sm-5" style="color: red;">
												        <?php echo $value['tongtien']; ?>
												        </th>
												   </tr>
							</thead>
					       </tbody>
					       <?php $stt++; }; ?>
             </table>
             
             <!-- <div class="nav nav-success" style="float: right;">
                  <input class="btn btn-primary" type="submit" name="ok" onclick='return confirm("Bạn có muốn update?")' value="Cập nhật">
	              <a href="user_order.php?tongtien=<?php echo $price_total  ?>" class="btn btn-danger" id="register-btn">Đặt hàng ngay</a>
	              <a href="user.php" type="button" class="btn btn-success" > Tiếp tục mua hàng </a>
              </div> -->
             </form>
             </div>
	</div>
<?php include '../includes/footer.php' ?>