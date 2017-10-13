<?php ?>
<div id="rightContent">
   <div class="them"> <a href=""><h3> <strong>Quản lý chi tiết đơn hàng thanh toán </h3></strong></a> </div>	
	<?php 
   if(isset($_GET['quanli']))
   { $tam=$_GET['quanli'];}
   else {
	   $tam='';
	   }
	   if($tam=='thanhtoan')
	   {
		   include('module/thanhtoan/main_thanhtoan.php');
	   }
	   
	
   ?>	
	
    </div>
<div class="clear"> </div>