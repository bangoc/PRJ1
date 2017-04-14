<div id="rightContent">
   <div class="them"> <a href="qlchitietdonhang.php?quanli=chitietdonhang"><h3> <strong>Quản lý chi tiet đơn hàng </h3></strong></a> </div>	
	<?php 
   if(isset($_GET['quanli']))
   { $tam=$_GET['quanli'];}
   else {
	   $tam='';
	   }
	   if($tam=='chitietdonhang')
	   {
		   include('module/qlchitietdonhang/main.php');
	   }
	   
	
   ?>	
	
    </div>
<div class="clear"> </div>