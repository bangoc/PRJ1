
<?php
 $sql_x= "select * from donhang where STT=$_GET[id]";
 $run_x= mysqli_query ($conn,$sql_x)or
   die("Error:".mysqli_error($conn)); 
 $dong_x=mysqli_fetch_array($run_x,MYSQLI_ASSOC);
?>
<form action="module/qlchitietdonhang/xuli_xoa.php" method="post"  enctype="multipart/form-data">
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
    if (isset($_GET['id'])){
    $id = $_GET['id'];
  
  }
    ?>

    <?php 
 
    
 $sql="select STT,qlchitietdonhang.iddonhang ,tensanpham,hinhanh,gia,tenhang,qlchitietdonhang.soluong,qlchitietdonhang.size,xuatxu,mausac from qlchitietdonhang, donhang, sanpham ,tenhang where qlchitietdonhang.iddonhang=donhang.iddonhang and sanpham.idsanpham=qlchitietdonhang.idsanpham and sanpham.idtenhang=tenhang.idtenhang and qlchitietdonhang.iddonhang=$id ";
 $run=mysqli_query($conn,$sql) or 
 die("Error:" .mysqli_error($conn));

?>


    <?php

 
$i="1";
  while ($dong_x=mysqli_fetch_array($run_x,MYSQLI_ASSOC)) {
   
 
  ?>
  
 </tr>
    <tr>
     <td> <?php echo $i; ?></td>
     
    <td><?php echo $dong_x['iddonhang']; ?></td>
    <td><?php echo $dong_x['tensanpham']; ?></td>
   <td><img src="../image/<?php echo $dong['hinhanh']?>" width="60" height="60"></td>
    <td> <?php echo $dong_x['gia']; ?>  </td>
    <td><?php echo $dong_x['tenhang']; ?> </td>
    <td><?php echo $dong_x['soluong']; ?> </td>
    <td><?php echo $dong_x['mausac']; ?> </td>
    <td> <?php echo $dong_x['size']; ?>  </td>
    <td><?php echo $dong_x['xuatxu']; ?> </td>
   <td> 

   <a onclick="return confirm('Bạn có thật sự muốn xóa không');"  href="module/qlchitietdonhang/xuli_xoa.php?id_xoa=<?php echo $dong['STT']; ?>"> <i class="fa fa-trash" aria-hidden="true" style="font-size: 150%;"></i> 
   </a>

   </td>
  
 </tr>
 
 <?php
 $i++;

}
?>

</table>
</form>