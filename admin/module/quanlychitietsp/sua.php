 <?php
 $sql= "select * from sanpham where idsanpham=$_GET[id]";
 $run= mysqli_query ($conn,$sql);
 $dong=mysqli_fetch_array($run,MYSQLI_ASSOC);
?>
<script src="//tinymce.cachefly.net/4.2/tinymce.min.js"></script>
<script>tinymce.init({selector:'textarea'});</script>
 <blockquote>&nbsp;</blockquote>

    <form action="module/quanlychitietsp/xuli.php?id=<?php echo $dong['idsanpham'] ?>"  method="post"  enctype="multipart/form-data">

        <table width="500" border="1"  style="background:#CFC ;margin:auto;">
          <tr>
            <td colspan="2" style="background:#099;color:#FFF" ><strong>Sửa chi tiết sản phẩm</strong></td>
            
          </tr>
          <tr>
            <td>Tên sản phẩm:</td>
            <td><input type="text" name="tensanpham" value="<?php echo $dong['tensanpham']; ?>" required></td>
          </tr>
          <tr>
            <td>Giá sản phẩm:</td>
            <td><input type="text" name="gia" value="<?php echo $dong['gia']; ?>" required></td>
          </tr>
          <tr>
            <td>Hình ảnh:</td>
            <td><input type="file" name="hinhanh" > <img src="../<?php echo $dong['hinhanh'] ?>" width="60" height="60">	</td>
            <td>Hình ảnh</td>
          </tr>
          <tr>
            <td>Mô tả sp:</td>
            <td ><textarea name="mota"><?php echo $dong['mota']; ?></textarea></td>
          </tr>
          <tr>
            <td>Tên hãng:</td>
            <td>
               <select name="hang" >
                  <option> Chọn hãng sản phẩm </option>
                  <option> Nike </option>
                  <option> Adidas </option>
                  <option> Puma</option>
                  <option> Converse</option>
               </select> 
            </td>
          </tr>
          <tr>
            <td>Số lượng:</td>
            <td><input type="number" name="soluong"  min="1" max="100" value="<?php echo $dong['soluong']; ?>"></td>
          </tr>
           <tr>
            <td>Size:</td>
            <td><input type="number" name="size"  min="20" max="60" value="<?php echo $dong['size']; ?>"></td>
          </tr>
           <tr>
            <td>Loại sản phẩm:</td>
            <td>
               <select name="loaisp">
                  <option> Chọn loại sản phẩm </option>
                  <option> Nam </option>
                  <option> Nữ </option>
                  <option> All </option>
               </select> 
            </td>
          </tr>
          <tr>
            <td>Màu sắc:</td>
            <td><input type="text" name="mausac" value="<?php echo $dong['mausac']; ?>" required></td>
          </tr>
          <tr>
            <td>Xuất xứ:</td>
            <td><input type="text" name="xuatxu" value="<?php echo $dong['xuatxu']; ?>" required></td>
          </tr>
          <tr>
            <td colspan="2"> <div align="center" style="margin-top: 40px;"> 
            <button name="sua" value="sua"> Sửa </button>
            </td>
            
          </tr>
        </table>
  </form>

