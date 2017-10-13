<?php
  $sql="select* from user order by iduser desc";
  $run=mysqli_query($conn,$sql) or
   die("Error:".mysqli_error($conn));	
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
  while ($dong=mysqli_fetch_array ($run,MYSQLI_ASSOC)) {
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
  ?>
</table>
