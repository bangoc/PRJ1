<?php 

   $errors=array(
      'array'=>0
    );
   $username = isset($_POST['username'])? trim($_POST['username']) : '';
   $password = isset($_POST['password'])? trim($_POST['password']) : '';
    /*    $conn = mysqli_connect('localhost', 'root', '', 'webbangiay');
        if (!$conn){
            $errors['connect_db'] = 'Không thể kết nối đến database';
        }
         
        $sql = "SELECT * FROM user where username = '$username' AND password='$password'";
         
        $result = mysqli_query($conn, $sql);
         
        if (mysqli_num_rows($result) !=1)
        {
            $errors['error']= '1';
            die (json_encode($errors));
        }
        else{

         	  $_SESSION['username']='$username';

              header('Location:items.php');
         }
        die (json_encode($errors));
?>*/
         
     include 'lib/conn.php';

   $query ="SELECT * FROM user WHERE username =' $username ' AND password='$password'";
   $result=mysqli_query($conn,$query) or die("ERROR: ".mysqli_error($conn));
   $row=mysqli_num_rows($result);
      if($row!=0){
           $errors['error']= 1;
           die(json_encode($errors));
                 }

      	   	 
      	   
     // else{

             // $errors['username']= 'Tên tài khoản hoặc mật khẩu không chính xác';
             
              // $row = mysqli_fetch_assoc($result);
             // if ($row['username'] != $username || $row['password']!=$password){
               // $errors['username'] = 'Tên tài khoản hoặc mật khẩu không chính xác';
          // }
       

 ?>
 
