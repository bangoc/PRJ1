<div id="rightContent">
   <div class="them"> <a href="quanlynguoidung.php?quanli=user"><h3> <strong>Quản lý người dùng</h3></strong></a> </div>	
	<?php 
   if(isset($_GET['quanli']))
   { $tam=$_GET['quanli'];}
   else {
	   $tam='';
	   }
	   if($tam=='user')
	   {
		   include('module/quanlynguoidung/main.php');
	   }
	   
   ?>	
	
    </div>
<div class="clear"> </div>