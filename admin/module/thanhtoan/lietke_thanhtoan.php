<?php
  $sql="select* from donhang, thanhtoan where donhang.id_thanhtoan=thanhtoan.id_thanhtoan and donhang.id_thanhtoan='1' order by iddonhang desc";
  $run=mysqli_query($conn,$sql) or
   die("Error:".mysqli_error($conn)); 
?>
</table>


<table width="880px" border="1" align="center" style=" margin-left:10px">
   <tr> 
   <td colspan="10" style="background:#CCC"> <strong>Quản lý đơn hàng đã thanh toán </strong></td>
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
    <td > Quản lý </td>
  
  <?php
 $id="1";
  while ($dong=mysqli_fetch_array ($run,MYSQLI_ASSOC)) {
    
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
  
  </tr>
  <?php 
   $id++;

  }
  ?>
</table>
