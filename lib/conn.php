<?php 
  $conn=mysqli_connect("localhost","root","","webbangiay");
  if(!$conn)
  {
  	die("Error: ".mysqli_connect_error($conn));
  }
  else
  	mysqli_set_charset($conn,'utf8');

 ?>