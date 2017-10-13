 <div class="left">
 <?php
 if(isset($_GET['ac']))
   { $tam=$_GET['ac'];}
    else {
	   $tam='';
	   }
	   if($tam=='them')
	   {
		   include('module/quanlychitietsp/them.php');
	   }
	   if($tam=='sua')
	   {
		   include('module/quanlychitietsp/sua.php');
	   }
  ?>
  </div>
    