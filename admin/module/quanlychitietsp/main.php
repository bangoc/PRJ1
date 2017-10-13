 <div class="shortcutHome1" >
  <a href="quanlysanpham.php?quanli=themsanpham&ac=them"> <img src="mos-css/img/ac.PNG" width="40" height="30"><br>Thêm sản phẩm</a>
		</div>

    <div class="right"> 
    <?php
	if(isset($_GET['ac']))
   { $tam=$_GET['ac'];}
    else {
	   $tam='';
	   }
	   if($tam=='lietke')
	   {
	include('module/quanlychitietsp/lietke.php');
	   }
	 ?>
    </div>