    <?php include 'conn.php' ?>
     <?php
<<<<<<< HEAD
=======

>>>>>>> cd579d14c6a57a9d3d6bff5640547e6079abadbc
					        if(isset($_POST["submit"])) {
					            //lấy thông tin từ các form bằng phương thức POST
					            $username = $_POST["username"];
					            $password = $_POST["password"];
					            //$phone = $_POST["phone"];
					            //$email = $_POST["email"];
					            //$address=$_POST["address"];
					            //Kiểm tra điều kiện bắt buộc đối với các field không được bỏ trốn
					                    // Kiểm tra tài khoản đã tồn tại chưa
					                    $sql="SELECT * FROM user WHERE username='$username'";
					                    $kt=mysqli_query($conn, $sql) or die("error: ".mysqli_error($conn));
					                    if(mysqli_num_rows($kt)  > 0){
					                        echo "Tài khoản đã tồn tại";
					                    }else{
					                        //thực hiện việc lưu trữ dữ liệu vào db
					                        $sql = "INSERT INTO user(
					                            username,
					                            password,
					                            #phone,
					                            #email,
					                            #address
					                            ) VALUES (
					                            '$username',
					                            '$password',
					                            #'$phone',
					                            #'$email',
					                            #'address'
					                            )";}
					                        // thực thi câu $sql với biến conn lấy từ file connection.php
					                        mysqli_query($conn,$sql);
					                        echo "chúc mừng bạn đã đăng ký thành công";
					                    }
    		 ?> 