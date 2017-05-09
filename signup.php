
<?php  
      $errors = array(
         'error' => 0
        );
      //mysqli_real_escape_string($conn,$_POST['username'])
         
       
        $username   = isset($_POST['username'])  ? trim($_POST['username']) : '';
        $password   = isset($_POST['password']) ? trim($_POST['password']) : '';
        $phone      = isset($_POST['email'])    ? trim($_POST['phone'])    : '';
        $address    = isset($_POST['address'])  ? trim($_POST['address']) : '';
         
       
        if (empty($username)){
            $errors['username'] = 'Bạn chưa nhập tên đăng nhập';
        }
         
        if (empty($password)){
           $errors['password'] = 'Bạn chưa nhập mật khẩu';
        }

        if (count($errors) > 1){
            $errors['error'] = 1;
           die (json_encode($errors));
        }
         
         
       
       $conn = mysqli_connect('localhost', 'root', '', 'webbangiay');
        if (!$conn){
            $errors['connect_db'] = 'Không thể kết nối đến database';
        }
         
        $sql = "SELECT * FROM user where username = '$username'";
         
        $result = mysqli_query($conn, $sql);
         
         
        if (mysqli_num_rows($result) > 0)
        {
            $row = mysqli_fetch_assoc($result);
            if ($row['username'] == $username){
               $errors['username'] = 'Tên đăng nhập đã tồn tại';
            }
        }
         
    
        if (count($errors) > 1){
            $errors['error'] = 1;
            die (json_encode($errors));
        }
         
         
        $sql = "INSERT INTO user(username, password, phone, address)".
                " VALUES('$username','$password','$phone','$address')";
        if (!mysqli_query($conn, $sql)){
            $errors['error'] = 1;
            $errors['sql_db'] = 'Lỗi câu truy vấn SQL';
        }
         
      
        die (json_encode($errors));
?>
