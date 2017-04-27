<?php 
  session_start();
  include '../lib/conn.php';
          $id = $_GET['id'];
          $query = "SELECT * FROM sanpham WHERE idsanpham = '$id'";
          $result = mysqli_query($conn,$query) or die("error: ".mysqli_error($conn));
     
          if(mysqli_num_rows($result)> 0){

          	  $data = array();
          	  while ($row = mysqli_fetch_assoc($result)) {
          		  $data[$row['idsanpham']] = $row;
          		
          	  }
           }
  if(!isset($_SESSION['cart']) or empty($_SESSION['cart']) ){
      $data[$id]['size'] =25;
      $data[$id]['quantity'] =1;
      $_SESSION['size'][$id] = $data[$id];
      $_SESSION['cart'][$id] = $data[$id];
  }
  else{

      if(array_key_exists($id,$_SESSION['cart'])){
          $_SESSION['cart'][$id]['quantity']+=1;
      }
      else{

          $data[$id]['quantity'] =1;
          $_SESSION['cart'][$id] = $data[$id];
      }
  }
  header("Location: shopping_cart.php");
 ?>