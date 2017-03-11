<?php 
  $conn=mysqli_connect("localhost","root","","weblaptop");
  if(!$conn)
  {
  	die("Error: ".mysqli_connect_error($conn));
  }
  else
  	mysqli_set_charset($conn,'utf8');

 ?>