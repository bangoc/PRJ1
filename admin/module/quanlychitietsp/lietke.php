
<?php
  $sql="select* from sanpham order by idsanpham desc";
  $run=mysqli_query($conn,$sql) or
   die("Error:".mysqli_error($conn));	
?>
<table width="900px" border="1" bordercolor="#000000">
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
    <td><img src="module/quanlychitietsp/upload img/<?php echo $dong['hinhanh']?>" width="60" height="60"></td>
    <td><?php echo $dong['hang'];?></td>
    <td><?php echo $dong['mausac'];?></td>
    <td><?php echo $dong['soluong'];?></td>
    <td><?php echo $dong['xuatxu'];?></td>
    <td>Sửa </td>
    <td>Xóa</td>
    
  </tr>
  <?php
  $id++;
  }
  ?>
</table>
