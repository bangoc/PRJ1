
<?php
 $sql= "select * from donhang where iddonhang=$_GET[id]";
 $run= mysqli_query ($conn,$sql)or
   die("Error:".mysqli_error($conn)); 
 $dong=mysqli_fetch_array($run,MYSQLI_ASSOC);
?>
<form action="module/qlchitietdonhang/xuli_xoa.php" method="post"  enctype="multipart/form-data">
<table width="800px" border="1" align="center" style=" margin-left:70px">
   <tr> 
   <td colspan="12" style="background:#CCC"> <strong>Bảng quản lý chi tiết đơn hàng  </strong></td>
   </tr>
  <tr>
    <td>STT</td>
    <td> id</td>
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
  while ($dong=mysqli_fetch_array($run,MYSQLI_ASSOC)) {
   
 
  ?>
  
 </tr>
    <tr>
     <td> <?php echo $i; ?></td>
     <td><?php echo $dong['STT']; ?></td>
    <td><?php echo $dong['iddonhang']; ?></td>
    <td><?php echo $dong['tensanpham']; ?></td>
   <td><img src="../image/<?php echo $dong['hinhanh']?>" width="60" height="60"></td>
    <td> <?php echo $dong['gia']; ?>  </td>
    <td><?php echo $dong['tenhang']; ?> </td>
    <td><?php echo $dong['soluong']; ?> </td>
    <td><?php echo $dong['mausac']; ?> </td>
    <td> <?php echo $dong['size']; ?>  </td>
    <td><?php echo $dong['xuatxu']; ?> </td>
   <td> <a  href=""> <i class="fa fa-trash" aria-hidden="true" style="font-size: 150%;"></i> </a></td>
  
 </tr>
 
 <?php
 $i++;

}
?>

</table>
</form>