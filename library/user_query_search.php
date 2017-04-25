  <?php include '../lib/conn.php' ?>
<?php 
	if (isset($_REQUEST['submit'])) {
   $search = addslashes($_GET['search']);
   $query="SELECT * from loaisp natural join sanpham natural join tenhang where loaisp like '%$search%' or tensanpham like '%$search%' or tenhang like '%$search%' or mota like '%$search%'" ;
   $result=mysqli_query($conn,$query) or die("ERROR: ".mysqli_error($conn));
   	$num = mysqli_num_rows($result);
   	if ($num > 0) {
   while ($data=mysqli_fetch_array($result,MYSQLI_ASSOC)) {
      ?>
            
		      <div class="col-md-4">
			      <div class="thumbnail">
							  
							        <img src="../image/<?php echo $data['hinhanh']; ?>" alt="<?php echo $data['tensanpham'] ?>" 
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
}
else {echo "Không tìm thấy sản phẩm nào với từ khóa <b>$search</b>, mời bạn nhập vào từ khóa khác";}
}
?>