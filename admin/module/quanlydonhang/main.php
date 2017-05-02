
<div class="right"> 
    <?php
    if(isset($_GET['ac']))
   { $tam=$_GET['ac'];}
    else {
	   $tam='';
	   }
	   if($tam=='lietke')
	   {
	include('module/quanlydonhang/lietke.php');
		}
		if($tam=='thanhtoan')
		{
			include('module/quanlydonhang/thanhtoan.php');
		}

	 ?>
    </div>