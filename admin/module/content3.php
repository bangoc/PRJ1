<div id="rightContent">
   <div class="them"> <a href="quanlydonhang.php?quanli=donhang"><h3> <strong>Quản lý đơn hàng </h3></strong></a> </div>	
	<?php 
   if(isset($_GET['quanli']))
   { $tam=$_GET['quanli'];}
   else {
	   $tam='';
	   }
	   if($tam=='donhang')
	   {
		   include('module/quanlydonhang/main.php');
	   }
	   
	
   ?>	
	
    </div>
<div class="clear"> </div>