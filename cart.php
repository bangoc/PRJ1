 <?php include 'includes/nav_user.php' ?>
         <div class="container" style="margin-top: 70px;margin-left: 89.5px;">
     <?php 
           include 'lib/conn.php';
           include 'includes/side_bar.php';   ?>
           <div class="container col-sm-9" >
             <form style="background: #D0F5A9">
             <div class="nav nav-success" style="background: #33b75d;"><h4 style="text-align: center;">Shopping cart</h4></div>
             <table class="table table-hover">
				    <thead>
				      <tr>
				        <th class="col-sm-1">ID</th>
				        <th class="col-sm-5">Tensp</th>
				        <th class="col-sm-2">Hình ảnh  </th>
				        <th class="col-sm-2">Số lượng</th>
				        <th class="col-sm-2">Giá</th>
				      </tr>
				    </thead>
				    <tbody>
				      <tr>
				        <td>1</td>
				        <td>2</td>
				        <td>3</td>
				         <td>3</td>
				         <td>3000đ</td>
				      </tr>
				      <tr>
				        <td>2</td>
				        <td>Moeđâsdasdasdas</td>
				        <td>mary@example.com</td>
				      </tr>
				      <tr>
				        <td>3</td>
				        <td>Dooley</td>
				        <td>july@example.com</td>
				      </tr>
				      <thead>
					      <tr>
					        <th class="col-sm-2">Tổng tiền:</th>
					        <th class="col-sm-5" style="color: red;">1000$</th>
					      </tr>
				      </thead>
				    </tbody>

             </table>
             <div class="nav nav-success" style="float: right;">
	              <a href="order.php" class="btn btn-danger" id="register-btn">Mua ngay</a>
	              <button type="button" class="btn btn-success" > Tiếp tục mua hàng </button>
              </div>
             </form>
             </div>
           
       	

	

	</div>
<?php include 'includes/footer.php' ?>