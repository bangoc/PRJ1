<?php  // Biến trả kết quả về cho người dùng
// dựa vào key error để nhận biết có lỗi hay không
        $errors = array(
            'error' => 0
        );
         
        // BƯỚC 1: LẤY THÔNG TIN
        $username   = isset($_POST['username']) ? trim($_POST['username']) : '';
        $password   = isset($_POST['password']) ? trim($_POST['password']) : '';
        $phone      = isset($_POST['email'])    ? trim($_POST['phone'])    : '';
        $address   = isset($_POST['address']) ? trim($_POST['address']) : '';
         
        // BƯỚC 2: VALIATE THÔNG TIN ĐƠN GIẢN
        if (empty($username)){
            $errors['username'] = 'Bạn chưa nhập tên đăng nhập';
        }
         
        if (empty($password)){
            $errors['password'] = 'Bạn chưa nhập mật khẩu';
        }
         
         
        // BƯỚC 3: KIỂM TRA CÓ LỖI KHÔNG, NẾU CÓ LỖI THÌ TRẢ VỀ LUÔN, CÒN KHÔNG THÌ TIẾP TỤC KIỂM TRA
        if (count($errors) > 1){
            $errors['error'] = 1;
            die (json_encode($errors));
        }
         
         
        // BƯỚC 4: KẾT NỐI CSDL VÀ KIỂM TRA THÔNG TIN
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
         
        // BƯỚC 5: TRẢ KẾT QUẢ VỀ NẾU CÓ LỖI
        if (count($errors) > 1){
            $errors['error'] = 1;
            die (json_encode($errors));
        }
         
        // BƯỚC 6: LƯU VÀO CSDL
        $sql = "INSERT INTO user(username, password, phone, address)".
                " VALUES('$username','$password','$phone','$address')";
        if (!mysqli_query($conn, $sql)){
            $errors['error'] = 1;
            $errors['sql_db'] = 'Lỗi câu truy vấn SQL';
        }
         
        // Trả kết quả cuối cùng
        die (json_encode($errors));
?>