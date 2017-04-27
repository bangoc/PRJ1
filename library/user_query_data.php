<?php 
    session_start();

    include '../lib/conn.php';
    $get_username = $_SESSION['username'] ;
    $tongtien   = $_GET['tongtien'] ;



    // lay iduser cua nguoi mua
    $query  = "SELECT iduser FROM user WHERE username = '$get_username'";
    $result = mysqli_query($conn,$query) or die("error: ".mysqli_error($conn));
    
    if($row= mysqli_num_rows($result)>0){
        $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
        $iduser = $row['iduser'];
    }

    //thêm iduser,tong tien vào trong bang donhang;
    $insert = "INSERT INTO donhang(iduser,tongtien) VALUES ('$iduser','$tongtien')";
    $result_insert = mysqli_query($conn,$insert) or die("error: ".mysqli_error($conn));


    //lay cai iddonhang theo iduser
    $sql = "SELECT iddonhang FROM donhang WHERE iduser = '$iduser'";
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






?>