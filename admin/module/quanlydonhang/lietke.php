<?php
  $sql="select* from donhang order by iddonhang desc";
  $run=mysqli_query($conn,$sql) or
   die("Error:".mysqli_error($conn));	
?>


<table width="800px" border="1" align="center" style=" margin-left:70px">
   <tr> 
   <td colspan="8" style="background:#CCC"> <strong>Bảng quản lý đơn hàng </strong></td>
   </tr>
  <tr>
    <td>STT</td>
    <td>ID đơn hàng</td>
    <td>Họ tên</td>
    <td>Phone</td>
    <td>Email</td>
    <td>Địa chỉ</td>
    <td>Tổng tiền</td>
    <td > Quản lý </td>
  
  <?php
 $id="1";
  while ($dong=mysqli_fetch_array ($run,MYSQLI_ASSOC)) {
 ?>
 </tr>
  <tr>
    <td> <?php echo $id ; ?></td>
    <td><?php echo $dong['hoten']; ?></td>
     <td><?php echo $dong['hoten']; ?></td>
    <td><?php echo $dong['phone']; ?></td>
    <td><?php echo $dong['email']; ?></td>
    <td><?php echo $dong['address']; ?></td>
    <td><?php echo $dong['tongtien']; ?></td>
    <td ><a href="qlchitietdonhang.php?quanli=chitietdonhang" >Chi tiết </a></td>
  
  </tr>
  <?php 
   $id++;
  }
  ?>
</table>
