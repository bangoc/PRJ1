<?php include('module/config.php') ?>
<?php 
	if (isset($_REQUEST['timkiem'])) {
	$search = addslashes($_GET['search']);
	$sql_timkiem="SELECT*from user  where  address like '%$search%'  or username like '%$search%'  ";
	$run_timkiem=mysqli_query($conn,$sql_timkiem) or die("ERROR: ".mysqli_error($conn));
   	$num = mysqli_num_rows($run_timkiem);
   	if ($num > 0&& $search != "") {
?>
<table width="800px" border="1" align="center" style=" margin-left:70px">
   <tr> 
   <td colspan="7" style="background:#CCC"> <strong>Bảng thông tin người dùng </strong></td>
   </tr>
  <tr>
    <td>ID</td>
    <td>Tên đăng nhập</td>
    <td>Mật khẩu</td>
    <td>Số điện thoại</td>
    <td>Địa chỉ</td>
    <td>Xóa</td>
   <?php
 $id="1";
  while ($dong=mysqli_fetch_array ($run_timkiem,MYSQLI_ASSOC)) {
 ?>
 </tr>
  <tr>
    <td> <?php echo $id ; ?></td>
    <td><?php echo $dong['username']; ?></td>
    <td><?php echo $dong['password']; ?></td>
    <td><?php echo $dong['phone']; ?></td>
    <td><?php echo $dong['address']; ?></td>
    <td> <a onclick="return confirm('Bạn có thật sự muốn xóa không');" href="module/thongtinnguoidung/xuli_xoa.php?id=<?php echo $dong['iduser'] ?>"> <i class="fa fa-trash" aria-hidden="true" style="font-size: 150%;"></i>  </a></td>
  </tr>
  <?php 
   $id++;
  }
}
else {echo "<strong> <h2> Không tìm thấy sản phẩm nào với từ khóa '<b>$search</b>'. Mời bạn nhập vào từ khóa khác </h2> </strong>" ;}
}
  ?>
</table>
