
<div class="content col-sm-9">
       	         <div class="panel panel-danger" style="background: #337ab7;"><h4 style="text-align: center;">Top bán chạy</h4></div>
       	         
       	         
       	         <div class="row">
       	         <?php 
       	         	$sql="SELECT * from sanpham order by rand()   limit 0,3";
				  		$result=mysqli_query($conn,$sql) or die("ERROR :".mysqli_error());
				  		while ($data=mysqli_fetch_array($result,MYSQL_ASSOC)) {
				  	   ?>
       	   	    <div class="col-md-4">
							    <div class="thumbnail">
							      <a href="#">
							        <img src="../image/<?php echo $data['hinhanh'] ?>" alt="Lights" style="width:252px;height: 236px;">
							         <div class="caption">
							          <p>Tên sản phẩm:<?php echo $data['tensanpham'] ?></p>
							          <p></p>
							        </div>
							        <div class="caption">
							          <p>Giá:<?php echo $data['gia'] ?></p>
							        </div>
							         <div class="caption">
							          <a href="user_items.php?id=<?php echo $data['idsanpham'] ?>" class="btn btn-danger">
							           <i class="fa fa-cart-plus" aria-hidden="true" style="color: red;">
							          	
							          </i>
							            Mua ngay
							          </a>
							        </div>
       	                         </div>
       	        </div>
       	       
       	        <?php } ?>
             </div>
          
          <div class="panel panel-danger" style="background: #337ab7;"><h4 style="text-align: center;">Hàng mới về</h4></div>
       	         
       	         
       	         <div class="row">
       	         <?php 
       	         	$sql="SELECT * from sanpham order by idsanpham desc   limit 0,3";
				  		$result=mysqli_query($conn,$sql) or die("ERROR :".mysqli_error());
				  		while ($data=mysqli_fetch_array($result,MYSQL_ASSOC)) {
				  	   ?>
       	   	    <div class="col-md-4">
							    <div class="thumbnail">
							      <a href="#">
							        <img src="../image/<?php echo $data['hinhanh'] ?>" alt="Lights" style="width:252px;height: 236px;">
							         <div class="caption">
							          <p>Tên sản phẩm:<?php echo $data['tensanpham'] ?></p>
							          <p></p>
							        </div>
							        <div class="caption">
							          <p>Giá:<?php echo $data['gia'] ?></p>
							        </div>
							         <div class="caption">
							          <a href="user_items.php?id=<?php echo $data['idsanpham'] ?>" class="btn btn-danger">
							           <i class="fa fa-cart-plus" aria-hidden="true" style="color: red;">
							          	
							          </i>
							            Mua ngay
							          </a>
							        </div>
       	                         </div>
       	        </div>
       	       
       	        <?php } ?>
             </div>
             
          <div class="panel panel-danger" style="background: #337ab7;"><h4 style="text-align: center;">Hàng xem nhiều</h4></div>
       	         
       	         
       	         <div class="row">
       	         <?php 
       	         	$sql="SELECT * from sanpham order by rand()   limit 0,3";
				  		$result=mysqli_query($conn,$sql) or die("ERROR :".mysqli_error());
				  		while ($data=mysqli_fetch_array($result,MYSQL_ASSOC)) {
				  	   ?>
       	   	    <div class="col-md-4">
							    <div class="thumbnail">
							      <a href="#">
							        <img src="../image/<?php echo $data['hinhanh'] ?>" alt="Lights" style="width:252px;height: 236px;">
							         <div class="caption">
							          <p>Tên sản phẩm:<?php echo $data['tensanpham'] ?></p>
							          <p></p>
							        </div>
							        <div class="caption">
							          <p>Giá:<?php echo $data['gia'] ?></p>
							        </div>
							         <div class="caption">
							          <a href="user_items.php?id=<?php echo $data['idsanpham'] ?>" class="btn btn-danger">
							           <i class="fa fa-cart-plus" aria-hidden="true" style="color: red;">
							          	
							          </i>
							            Mua ngay
							          </a>
							        </div>
       	                         </div>
       	        </div>
       	       
       	        <?php } ?>
             </div>
             
       </div>