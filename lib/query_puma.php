  <?php include 'lib/conn.php' ?>
<?php 
   $query="SELECT idsanpham,tensanpham,hinhanh,gia from sanpham where idtenhang='2'";
   $result=mysqli_query($conn,$query) or die("ERROR: ".mysqli_error($conn));
   while ($data=mysqli_fetch_array($result,MYSQLI_ASSOC)) {
      ?>
            
		      <div class="col-md-4">
			      <div class="thumbnail">
							  
							        <img src="image/<?php echo $data['hinhanh']; ?>" alt="<?php echo $data['tensanpham'] ?>" 
							           style="width:252px;height: 236px;">
							         <div class="caption">
							          <p>Tên sản phẩm:</p>
							          <strong><?php echo $data['tensanpham']; ?></strong>
							        </div>
							        <div class="caption">
							          <p>Giá:<strong style="color: red;"><?php echo $data['gia'];?></strong></p>
							        </div>
							         <div class="caption">
							          <a href="items.php?id=<?php echo $data['idsanpham'];?>" class="btn btn-danger">
							           <i class="fa fa-cart-plus" aria-hidden="true" style="color: red;">
							          	
							          </i>
							            Mua ngay
							          </a>
							        </div>
       	           </div>
			</div>
			

<?php
}
?>