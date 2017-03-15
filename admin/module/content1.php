<div id="rightContent">
   <div class="them"> <a href="quanlysanpham.php?quanli=quanlychitietsp&ac=them"><h3> <strong>Chi tiết sản phẩm </h3></strong></a> </div>
	
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
	   if ($tam=='quanlychitietsp')
	   {
		   include('module/quanlychitietsp/main.php');
	   }
	   if ($tam=='themsanpham')
	   {
		   include('module/quanlychitietsp/main1.php');
	   }
   ?>	
	
    </div>
<div class="clear"> </div>