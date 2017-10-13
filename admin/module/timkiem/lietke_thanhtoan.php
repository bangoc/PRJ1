
<?php include('module/config.php') ?>
<?php 
	if (isset($_REQUEST['timkiem'])) {
	$search = addslashes($_GET['search']);
	$sql_timkiem="SELECT*from donhang,thanhtoan where donhang.id_thanhtoan=thanhtoan.id_thanhtoan and donhang.id_thanhtoan='1'  and (iddonhang like '%$search%' or hoten like '%$search%' or address like '%$search%'  or email like '%$search%' ) ";
	$run_timkiem=mysqli_query($conn,$sql_timkiem) or die("ERROR: ".mysqli_error($conn));
   	$num = mysqli_num_rows($run_timkiem);
   	if ($num > 0&& $search != "") {
?>
</table>


<table width="880px" border="1" align="center" style=" margin-left:10px">
   <tr> 
   <td colspan="11" style="background:#CCC"> <strong>Quản lý đơn hàng đã thanh toán </strong></td>
   </tr>
  <tr>
    <td>STT</td>
    <td>ID đơn hàng</td>
    <td>Họ tên</td>
    <td>Phone</td>
    <td>Email</td>
    <td>Địa chỉ</td>
    <td>Tổng tiền</td>
    <td>Hình thức thanh toán</td>
    <td>Thanh toán </td>
    <td > Xem </td>
    <td>Xóa</td>
  
  <?php
 $id="1";
  while ($dong=mysqli_fetch_array ($run_timkiem,MYSQLI_ASSOC)) {
    
 ?>
 </tr>
  <tr>
    <td> <?php echo $id ; ?></td>
    <td><?php echo $dong['iddonhang']; ?></td>
     <td><?php echo $dong['hoten']; ?></td>
    <td><?php echo $dong['phone']; ?></td>
    <td><?php echo $dong['email']; ?></td>
    <td><?php echo $dong['address']; ?></td>
    <td><?php echo $dong['tongtien']; ?></td>
    <td><?php echo $dong['hinhthucthanhtoan']?></td>
    <td><?php echo $dong['thanhtoan']; ?></td>

    <td ><a href="qlchitietdonhang.php?quanli=chitietdonhang&ac=lietke&id=<?php echo $dong['iddonhang']?>" >Chi tiết </a></td>
  <td> <a onclick="return confirm('Bạn có thật sự muốn xóa không');" href="module/thanhtoan/xuli_xoa.php?id=<?php 
    echo $dong['iddonhang']?>"><i class="fa fa-trash" aria-hidden="true" style="font-size: 150%;"></i></a></td>
  </tr>
  <?php 
   $id++;
}
  }
  else {echo "<strong> <h2> Không tìm thấy sản phẩm nào với từ khóa '<b>$search</b>'. Mời bạn nhập vào từ khóa khác </h2> </strong>" ;}
}
  ?>
</table>