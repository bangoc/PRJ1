<?php 
    session_start();

    include '../lib/conn.php';
    $get_username = $_SESSION['username'] ;
    if(isset($_GET['tongtien'])){
            $tongtien   = $_GET['tongtien'] ;
            // lay iduser cua nguoi mua
            $query  = "SELECT iduser FROM user WHERE username = '$get_username'";
            $result = mysqli_query($conn,$query) or die("error: ".mysqli_error($conn));
            
            if($row= mysqli_num_rows($result)>0){
                $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
                $iduser = $row['iduser'];
            }
            if(isset($_POST['submit'])){
                $email=mysqli_real_escape_string($conn,$_POST['email']);
                $hoten=mysqli_real_escape_string($conn,$_POST['hoten']);
                $address=mysqli_real_escape_string($conn,$_POST['address']);
                $phone=mysqli_real_escape_string($conn,$_POST['phone']);
                $thanhtoan=mysqli_real_escape_string($conn,$_POST['thanhtoan']);
            //thêm iduser,tong tien vào trong bang donhang;
            $insert = "INSERT INTO donhang(iduser,tongtien,email,hoten,address,phone,hinhthucthanhtoan) VALUES ('$iduser','$tongtien','$email','$hoten','$address','$phone',
            '$thanhtoan')";
            $result_insert = mysqli_query($conn,$insert) or die("error: ".mysqli_error($conn));


            //lay cai iddonhang theo iduser
            $sql = "SELECT * FROM donhang WHERE iduser = '$iduser' and email='$email' and tongtien='$tongtien' and hoten='$hoten'";
            $return=mysqli_query($conn,$sql) or die("error: ".mysqli_error($conn));
            
            if($data  = mysqli_num_rows($return)>0){
                $data = mysqli_fetch_array($return,MYSQLI_ASSOC);
                $iddonhang = $data['iddonhang'];
            }

            foreach ($_SESSION['cart'] as $value) {
                $idsanpham = $value['idsanpham'];
                $soluong   = $value['quantity'];
                

                      //thêm thông tin iddonhang,idsanpham,soluong vao trong bang qlichitietdonhang
            $insert_ql ="INSERT INTO qlchitietdonhang(iddonhang,idsanpham,soluong)
                         VALUES ('$iddonhang','$idsanpham','$soluong')";
            $result_ql =mysqli_query($conn,$insert_ql) or die("error: ".mysqli_error($conn));
             }
    }   
      // unset($_SESSION['cart']);
      // header("Location:'../user_client/success_buy.php'");

    
    }else if(isset($_GET['id'])){
        $idsanpham=$_GET['id'];
        $s="SELECT * FROM sanpham where idsanpham ='$idsanpham'";
        $r=mysqli_query($conn,$s);
        $n=mysqli_fetch_array($r,MYSQL_ASSOC);
        $tongtien=$n['gia'];

         $query  = "SELECT iduser FROM user WHERE username = '$get_username'";
            $result = mysqli_query($conn,$query) or die("error: ".mysqli_error($conn));
            
            if($row= mysqli_num_rows($result)>0){
                $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
                $iduser = $row['iduser'];
            }
            if(isset($_POST['submit'])){
                $email=mysqli_real_escape_string($conn,$_POST['email']);
                $hoten=mysqli_real_escape_string($conn,$_POST['hoten']);
                $address=mysqli_real_escape_string($conn,$_POST['address']);
                $phone=mysqli_real_escape_string($conn,$_POST['phone']);
                $thanhtoan=mysqli_real_escape_string($conn,$_POST['thanhtoan']);
            //thêm iduser,tong tien vào trong bang donhang;
            $insert = "INSERT INTO donhang(iduser,tongtien,email,hoten,address,phone,hinhthucthanhtoan) VALUES ('$iduser','$tongtien','$email','$hoten','$address','$phone','$thanhtoan')";
            $result_insert = mysqli_query($conn,$insert) or die("error: ".mysqli_error($conn));


            //lay cai iddonhang theo iduser
            $sql = "SELECT iddonhang FROM donhang WHERE iduser = '$iduser' and email='$email' and tongtien='$tongtien' and hoten='$hoten'";
            $return=mysqli_query($conn,$sql) or die("error: ".mysqli_error($conn));
            
            if($data  = mysqli_num_rows($return)>0){
                $data = mysqli_fetch_array($return,MYSQLI_ASSOC);
                $iddonhang = $data['iddonhang'];

            // insert du lieu vao bang qlchitietdonhang
             $insert_ql ="INSERT INTO qlchitietdonhang(iddonhang,idsanpham,soluong)
                         VALUES ('$iddonhang','$idsanpham','1')";
            $result_ql =mysqli_query($conn,$insert_ql) or die("error: ".mysqli_error($conn));

            }


    }
}
?>