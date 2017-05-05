<?php ?>

<?php include('module/config.php') ?>
<?php 
	if (isset($_REQUEST['timkiem'])) {
	$search = addslashes($_GET['search']);
	$sql_timkiem="SELECT iddonhang,tensanpham,hinhanh,gia,tenhang,qlchitietdonhang.soluong,mausac,qlchitietdonhang.size,xuatxu from qlchitietdonhang ,sanpham , tenhang  where sanpham.idsanpham=qlchitietdonhang.idsanpham and sanpham.idtenhang=tenhang.idtenhang and  (tensanpham like '%$search%' or tenhang like '%$search%' ) ";
	$run_timkiem=mysqli_query($conn,$sql_timkiem) or die("ERROR: ".mysqli_error($conn));
   	$num = mysqli_num_rows($run_timkiem);
   	if ($num > 0&& $search != "") {
?>
<table width="800px" border="1" align="center" style=" margin-left:70px">
   <tr>   
   <td colspan="12" style="background:#CCC"> <strong>Bảng quản lý chi tiết đơn hàng  </strong></td>
   </tr>
  <tr>
    <td>STT</td>
    
    <td>ID đơn hàng</td>
    <td>Tên sản phẩm</td>
    <td> Hình ảnh </td>
    <td> Giá </td>
    <td>Tên hãng</td>
    <td>Số lượng</td>
    <td>Màu sắc</td>
    <td> Size </td>
    <td>Xuất xứ</td>
    <td>Quản lý</td>

    

    <?php

 
$i="1";
  while ($dong=mysqli_fetch_array($run_timkiem,MYSQLI_ASSOC)) {
   
 
  ?>
  
 </tr>
    <tr>
     <td> <?php echo $i; ?></td>
     
    <td><?php echo $dong['iddonhang']; ?></td>
    <td><?php echo $dong['tensanpham']; ?></td>
   <td><img src="../image/<?php echo $dong['hinhanh']?>" width="60" height="60"></td>
    <td> <?php echo $dong['gia']; ?>  </td>
    <td><?php echo $dong['tenhang']; ?> </td>
    <td><?php echo $dong['soluong']; ?> </td>
    <td><?php echo $dong['mausac']; ?> </td>
    <td> <?php echo $dong['size']; ?>  </td>
    <td><?php echo $dong['xuatxu']; ?> </td>
   <td> 

   <a onclick="return confirm('Bạn có thật sự muốn xóa không');"  href="module/qlchitietdonhang/xuli_xoa.php?id_xoa=<?php echo $dong['STT'] ?>&id=<?php echo $dong['iddonhang'] ?>"> <i class="fa fa-trash" aria-hidden="true" style="font-size: 150%;"></i> 
   </a>

   </td>
  
 </tr>
 
 <?php
 $i++;

}
}
else {echo "<strong> <h2> Không tìm thấy sản phẩm nào với từ khóa '<b>$search</b>'. Mời bạn nhập vào từ khóa khác </h2> </strong>" ;}
}
?>

</table>