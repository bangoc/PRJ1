 <div class="left">
 <?php
 if(isset($_GET['ac']))
   { $tam=$_GET['ac'];}
    else {
	   $tam='';
	   }
	   if($tam=='them')
	   {
		   include('module/hangsanxuat/them.php');
	   }
	   if($tam=='sua')
	   {
		   include('module/hangsanxuat/sua.php');
	   }
  ?>
  </div>
    <div class="right"> 
    <?php
	include('module/hangsanxuat/lietke.php');
	 ?>
    </div>