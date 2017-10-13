<div class="right"> 
    <?php
   if(isset($_GET['ac']))
   { $tam=$_GET['ac'];}
    else {
	   $tam='';
	   }
	   if($tam=='lietke')
	   {
	include('module/qlchitietdonhang/lietke.php');
       }
       elseif($tam=='lietke_xoa')
       {
     	include('module/qlchitietdonhang/lietke_xoa.php');
       } 
	 ?>
    </div>
  
    