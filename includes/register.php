
<script type="text/javascript">
        $(document).ready(function(){
 
           $('#register-btn').click(function(){
 
           var data = {
            username    : $('#username').val(),
            password    : $('#password').val(),
            phone      : $('#phone').val(),
            address   : $('#address').val()
        };
 
        
        $.ajax({
            type : "post",
            dataType : "JSON",
            url : "signup.php",
            data : data,
            success : function(result)
            {
                
                if (result.hasOwnProperty('error') && result.error == '1'){
                    var html = '';
 
                    
                    $.each(result, function(key, item){
                        
                        if (key != 'error'){ 
                            html += '<li>'+item+'</li>';
                        }
                    });
                    $('.alert-danger').html(html).removeClass('hide');
                    $('.alert-success').addClass('hide');
                }
                else{ 
                    $('.alert-success').html('Đăng ký thành công!').removeClass('hide');
                    $('.alert-danger').addClass('hide');
 
                    
                    setTimeout(function(){
                        $('#myModal').modal('hide');
                        $('.alert-danger').addClass('hide');
                        $('.alert-success').addClass('hide');
                    }, 4000);
                }
            }
        });
    });
});
</script>
<style type="text/css">
  .row{
    padding-top: 15px;
  }
</style>
                                   
        
           <a role="button" data-toggle="modal" data-target="#register"><i class="fa fa-user-o" aria-hidden="true"></i>Đăng kí</a>
 
           
            <div id="register" class="modal fade" role="dialog">
                
 
                    
                    <div class="modal-content" style="background:#F3F781;width: 600px;
                             margin-left: 400px;">
                        <div class="modal-header" style="background: #64FE2E;">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title" style="color: green;text-align: center;">ĐĂNG KÝ THÀNH VIÊN</h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-md-3"><label>Tên đăng nhập:</label></div>
                                <div class="col-md-8">
                                    <input class="form-control" type="text" id="username" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3"><label>Mật khẩu</label>:</div>
                                <div class="col-md-8">
                                    <input class="form-control" type="text" id="password" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3"><label>Số điện thoại:</label></div>
                                <div class="col-md-8">
                                    <input class="form-control" type="text" id="phone" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3"><label>Địa chỉ:</label></div>
                                <div class="col-md-8">
                                    <input class="form-control" type="text" id="address" />
                                </div>
                            </div>
                        </div>
                        <div class="alert alert-danger hide">
                          
                        </div>
                        <div class="alert alert-success hide">
 
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" id="register-btn">Đăng ký</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    
                </div>
            </div>
