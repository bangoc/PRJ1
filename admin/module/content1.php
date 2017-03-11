<div id="rightContent">
<div class="them">
	<a href="quanlysanpham.php?quanli=hangsanxuat&ac=them"><h3> <strong>Hãng sản xuất </h3></strong></a></div>
   <div class="them"> <a href="quanlysanpham.php?quanli=quanlychitietloaisp&ac=them"><h3> <strong>Chi tiết sản phẩm </h3></strong></a> </div>
	
	<?php 
   if(isset($_GET['quanli']))
   { $tam=$_GET['quanli'];}
   else {
	   $tam='';
	   }
	   if($tam=='hangsanxuat')
	   {
		   include('module/hangsanxuat/main.php');
	   }
	   if ($tam=='quanlychitietloaisp')
	   {
		   include('module/quanlychitietsp/main.php');
	   }
   ?>	
	
    </div>
<div class="clear"> </div>