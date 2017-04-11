<?php include 'includes/header.php' ?>
<?php include 'lib/conn.php' ?>
<div class="container"  style="margin-top: 70px;">
	    <div class="btn-group btn-group-justified">
		  <a href="#" class="btn btn-primary">Trang chủ</a>
		  <a href="#" class="btn btn-primary">Xem thêm</a>
		
        </div>
        <div class="" style="margin-top: 50px;">
		  <?php include 'lib/query_product.php' ?>
			<div class="col-sm-4">
				<ul class="list-group" style="text-align: center;">
				  <li class="list-group-item" style="font-weight: bold;background: #45449d;text-align: center;color: #aeb85c;"><label>
				  	 <i class="fa fa-bars" aria-hidden="true"  style="margin-right: 10px; font-size: 120%;"></i>
				  	    DANH SÁCH SẢN PHẨM CỦA SHOP
				     </label>
				  </li>
					      <a href="nike.php" class="list-group-item"> Giày Nike</a>
						  <a href="adidas.php" class="list-group-item"> Giày Adidas</a>
						  <a href="puma.php" class="list-group-item">Giày Puma</a>
						  <a href="converse.php" class="list-group-item">Giày Converse</a>
				</ul>
			<ul class="list-group" style="text-align: center;">
				  <li class="list-group-item" style="font-weight: bold;background: #45449d;text-align: center;color: #aeb85c;"><label>
				  	 <i class="fa fa-book" aria-hidden="true" style="margin-right: 10px; font-size: 120%;"></i>
				  	    XEM THÊM CÁC SẢN PHẨM KHÁC
				     </label>
				  </li>
				  <?php 
				  		$idsp=$_GET['id'];
				  		$idtenhang=$_GET['idtenhang'];
				  		#$idtenhang=1;
				  		$sql="SELECT * from sanpham
				  			where idsanpham<>$idsp and idtenhang=$idtenhang
				  		  	order by rand()  limit 0,5";
				  		$result=mysqli_query($conn,$sql) or die("ERROR :".mysqli_error());
				  		while ($data=mysqli_fetch_array($result,MYSQL_ASSOC)) {
				  	   ?>
				  <li class="list-group-item">
					       <div class="thumbnail">
							      <a href="#">
							        <img src="image/<?php echo $data['hinhanh'] ?>" alt="Lights" style="width:150px;height: 150px;">
							       
							          <p>Tên sản phẩm:<?php echo $data['tensanpham'] ?></p>
							          <p></p>
							      
							    
							          <p>Giá:<?php echo $data['gia'] ?></p>
							      
							        
							          <a href="#" class="btn btn-danger">
							           <i class="fa fa-cart-plus" aria-hidden="true" style="color: red;">
							          	
							          </i>
							            Mua ngay
							          </a>
							      
       	                         </div>
       	            </li>
					<?php } ?>
				</ul>
			</div>
		
	</div>
</div>

<?php include 'includes/footer.php' ?>