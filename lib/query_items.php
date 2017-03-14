
   <?php include 'lib/conn.php' ?>
<?php 
   $query="SELECT tensanpham,gia from sanpham";
   $result=mysqli_query($conn,$query) or die("ERROR: ".mysqli_error($conn));
   while ($data=mysqli_fetch_array($result,MYSQLI_ASSOC)) {
      ?>

		      <div class="col-md-4">
			    <div class="thumbnail">
			      <a href="items.php">
			        <img src="<?php echo $data['hinhanh'];?>" alt="Nature" style="width:100%">
			        <div class="caption">
			          <p>Tên sản phẩm:<?php echo $data['tensanpham'];?></p>
			        </div>
			        <div class="caption">
			          <p>Giá:<?php echo $data['gia'];?></p>
			        </div>
			      </a>
			    </div>
			  </div>
<?php
}
?>