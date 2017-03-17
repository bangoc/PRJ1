<?php
  $sql="select* from user order by iduser desc";
  $run=mysqli_query($conn,$sql) or
   die("Error:".mysqli_error($conn));	
?>
<table width="800px" border="1" align="center" style=" margin-left:70px">
   <tr> 
   <td colspan="6" style="background:#CCC"> <strong>Bảng quản lý người dùng </strong></td>
   </tr>
  <tr>
    <td>ID</td>
    <td>Tên đăng nhập</td>
    <td>Mật khẩu</td>
    <td>Phone</td>
    <td>Địa chỉ email</td>
  
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
    <td><?php echo $dong['email']; ?></td>
  </tr>
  <?php 
   $id++;
  }
  ?>
</table>
