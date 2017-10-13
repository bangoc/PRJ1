<div id="rightContent">
   <div class="them"> <a href=""><h3> <strong>Liên hệ </h3></strong></a> </div>	
	<?php 
   if(isset($_GET['quanli']))
   { $tam=$_GET['quanli'];}
   else {
	   $tam='';
	   }
	   if($tam=='lienhe')
	   {
		   include('module/lienhe/main.php');
	   }
	   
	
   ?>	
	
    </div>
<div class="clear"> </div>