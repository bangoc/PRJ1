<?php
  $sql="select* from hangsanxuat order by idhang desc";
  $run=mysqli_query($conn,$sql) or
   die("Error:".mysqli_error($conn));	
?>
<table width="100%" border="1" style="border:1px;">
  <tr> 
     <td colspan="5"><h3> <strong>Danh sách hãng sản xuất </strong></h3></td>
  </tr>
  <tr >
    <td><strong>STT</strong></td>
    <td><strong>Tên hãng</strong></td>
    <td colspan="2"><strong>Quản lý</strong></td>
  </tr>
  <?php
 $i="1";
  while ($dong=mysqli_fetch_array ($run,MYSQLI_ASSOC)) {
 ?>
  <tr>
    <td><?php echo $i; ?></td>
    <td><?php echo $dong['tenhang'] ?></td>
    <td> <a href="hangsanxuat.php?quanli=hangsanxuat&ac=sua&idhang=<?php echo $dong['idhang'] ?>"> Sửa</a></td>
    <td><a onclick="return confirm('Bạn có thật sự muốn xóa không');" href="module/hangsanxuat/xuly.php?idhang=<?php 
		echo $dong['idhang']?>"> Xóa</a></td>
  </tr>
  <?php
  $i++;
  }
  ?>
</table>

