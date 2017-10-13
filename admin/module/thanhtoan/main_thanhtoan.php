
<div class="right"> 
    <?php
    if(isset($_GET['ac']))
   { $tam=$_GET['ac'];}
    else {
	   $tam='';
	   }
	   if($tam=='lietke')
	   {
	include('module/thanhtoan/lietke_thanhtoan.php');
}
	 ?>
    </div>