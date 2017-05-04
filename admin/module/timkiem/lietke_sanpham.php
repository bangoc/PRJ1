
<?php include('module/config.php') ?>
<?php 
	if (isset($_REQUEST['timkiem'])) {
	$search = addslashes($_GET['search']);
	$sql="SELECT*from sanpham natural join loaisp natural join tenhang  where   
	loaisp like '%$search%' or tensanpham like '%$search%' or tenhang like '%$search%' ";
	$run=mysqli_query($conn,$sql) or die("ERROR: ".mysqli_error($conn));
   	$num = mysqli_num_rows($run);
   	if ($num > 0&& $search != "") {
?>
<table width="850px" border="1" bordercolor="#000000">
<tr> 
     <td colspan="11" style="background:#CCC; color:#006" > <strong>Danh sách sản phẩm </strong></td>
  </tr>
  <tr >
    <td >ID</td>
    <td>Tên sản phẩm</td>
    <td>Giá</td>
    <td>Hình ảnh</td>
    <td>Tên hãng</td>
    <td>Màu sắc</td>
    <td>Số lượng</td>
    <td>Xuất xứ</td>
    <td colspan="2">Quản lý</td>

   
    <?php
 $id="1";
  while ($dong=mysqli_fetch_array ($run,MYSQLI_ASSOC)) {
 ?>
  </tr>
  <tr>
    <td><?php echo $id; ?></td>
    
    <td><?php echo $dong['tensanpham'];?></td>
    <td><?php echo $dong['gia'];?></td>
    <td><img src="../image/<?php echo $dong['hinhanh']?>" width="60" height="60"></td>
    <td><?php echo $dong['tenhang'];?></td>
    <td><?php echo $dong['mausac'];?></td>
    <td><?php echo $dong['soluong'];?></td>
    <td><?php echo $dong['xuatxu'];?></td>
    <td><a href="quanlysanpham.php?quanli=themsanpham&ac=sua&id=<?php echo $dong['idsanpham'] ?>"><i class="fa fa-pencil" aria-hidden="true" style="font-size: 130%;"></i></a></td>
    <td> <a onclick="return confirm('Bạn có thật sự muốn xóa không');" href="module/quanlychitietsp/xuli.php?id=<?php 
		echo $dong['idsanpham']?>"><i class="fa fa-trash" aria-hidden="true" style="font-size: 130%;"></i></a></td>
    
  </tr>
  <?php
  $id++;
  }
  
  }
else {echo "<strong> <h2> Không tìm thấy sản phẩm nào với từ khóa '<b>$search</b>'. Mời bạn nhập vào từ khóa khác </h2> </strong>" ;}
}
  ?>



</table>

