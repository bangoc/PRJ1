 
 <blockquote>&nbsp;</blockquote>
    <form action="module/quanlychitietsp/xuli.php" method="post"  enctype="multipart/form-data">

        <table width="500" border="1"  style="background:#CFC;margin:auto;">
          <tr>
            <td colspan="2" style="background:#099;color:#FFF" ><strong>Thêm chi tiết sản phẩm</strong></td>
            
          </tr>
          <tr>
            <td>Tên sản phẩm:</td>
            <td><input type="text" name="tensanpham" value="" required></td>
          </tr>
          <tr>
            <td>Giá sản phẩm:</td>
            <td><input type="text" name="gia" value="" required></td>
          </tr>
          <tr>
            <td>Hình ảnh:</td>
            <td><input type="file" name="hinhanh" value="" required></td>
          </tr>
          <tr>
            <td>Mô tả sp:</td>
            <td ><textarea name="mota" cols="25" rows="14" style="width: 90%;"></textarea></td>
          </tr>
          <?php
              $sql="select * from tenhang";
              $run=mysqli_query($conn,$sql);
           ?>
          <tr>
            <td>Tên hãng:</td>
            <td>
               <select name="idtenhang">
               <option> Chọn hãng sản phẩm </option>
               <?php 
                   while ($dong=mysqli_fetch_array($run,MYSQLI_ASSOC) ){
               ?>
                 
                  <option value="<?php echo $dong ['idtenhang'] ?>"> <?php echo $dong ['tenhang'] ?>  </option>
                  <?php
                    }
                   ?>
               </select>  
            </td>
          </tr>
          <tr>
            <td>Số lượng:</td>
            <td><input type="number" name="soluong"  min="1" max="100" value="1"></td>
          </tr>
           <tr>
            <td>Size:</td>
            <td><input type="text" name="size"  value="" required></td>
          </tr>
          <?php
            $sql=" select *from loaisp"; 
            $run= mysqli_query($conn,$sql);
           ?>
           <tr>
            <td>Loại sản phẩm:</td>
                
            <td>
               <select name="idloaisp">
               <option> Chọn loại sản phẩm </option>
               <?php 
                while ($dong=mysqli_fetch_array($run,MYSQLI_ASSOC)) {
               ?>
                  <option value="<?php echo $dong['idloaisp'] ?>"> <?php echo $dong ['loaisp']?></option>
                  <?php 
                }
                  ?>

               </select> 
            </td>
          </tr>
          <tr>
            <td>Màu sắc:</td>
            <td><input type="text" name="mausac" value="" required></td>
          </tr>
          <tr>
            <td>Xuất xứ:</td>
            <td><input type="text" name="xuatxu" value="" required></td>
          </tr>
          <tr>
            <td colspan="2"> <div align="center" style="margin-top: 40px;"> 
            <button name="them" value="Them"> Thêm </button>
            </td>
            
          </tr>
        </table>
  </form>

