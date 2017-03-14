 <blockquote>&nbsp;</blockquote>
  <?php include 'xuli.php' ?>
    <form action="<?php htmlspecialchars($_SERVER['PHP_SELF']) ?>" method="post"  enctype="multipart/form-data">

        <table width="500" border="1"  style="background:#CCC;margin:auto;">
          <tr>
            <td colspan="2" style="background:#ea4916"><strong>Thêm chi tiết sản phẩm</strong></td>
            
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
            <td><input type="file" name="hinhanh" value=""></td>
          </tr>
          <tr>
            <td>Mô tả sp:</td>
            <td ><textarea name="mota" cols="25" rows="14" style="width: 90%;"></textarea></td>
          </tr>
          <tr>
            <td>Tên hãng:</td>
            <td>
               <select name="hang">
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
            <td><input type="number" name="soluong"  min="1" max="100" value="1"></td>
          </tr>
           <tr>
            <td>Size:</td>
            <td><input type="number" name="size"  min="20" max="60" value="20"></td>
          </tr>
           <tr>
            <td>Loại sản phẩm:</td>
            <td>
               <select name="loaisp">
                  <option> Chọn loại sản phẩm </option>
                  <option> Nam </option>
                  <option> Nữ </option>
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

