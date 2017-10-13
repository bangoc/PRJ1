<div id="rightContent">
   <div class="them"> <a href=""><h3> <strong>Hiển thị thông tin tìm kiếm</h3></strong></a> </div>	
	<?php 
   if(isset($_GET['timkiem']))
   { $tam=$_GET['timkiem'];}
   else {
	   $tam='';
	   }
	   if($tam=='search')
	   {
		   include('module/timkiem/main_user.php');
	   }
	   
	
   ?>	
	
    </div>
<div class="clear"> </div>