<?php
 $sql= "select*from hangsanxuat where idhang=$_GET[idhang]";
 $run= mysqli_query ($conn,$sql);
 $dong=mysqli_fetch_array($run);
?>
<form action="module/hangsanxuat/xuly.php?idhang=<?php echo $dong['idhang'] ?>" method="post" enctype="multipart/form-data">
<table width="100%" border="1">
  <tr>
    <td colspan="2" div align="center"><h4>Sửa tên hãng</h4></td>
    
  </tr>
  <tr>
    <td><strong>Tên hãng</strong></td>
    <td>
    <input type="text" name="tenhang" value="<?php echo $dong['tenhang'];?> " /> </td>
  </tr>
  <tr>
    <td colspan="2"> <div align="center">
    <input type="submit" name="sua" id="sua" value="Sửa"> </div>
    
    </td>
   
  </tr>
</table>
</form>