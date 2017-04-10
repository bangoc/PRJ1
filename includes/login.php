
 <style type="text/css">
  .row{
    padding-top: 15px;
  }
</style>
<body>
   
           <a role="button" data-toggle="modal" data-target="#login"><i class="fa fa-user" aria-hidden="true"></i></i>Đăng nhập</a>
 
            
            <div id="login" class="modal ">
             
 
                    
                    <div class="content" style="background:#BCF5A9;margin-top: 100px;width: 600px;
                              margin-left: 400px;">
                        <div class="modal-header" style="background: #F781F3;">
                            <button type="modal-button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="title" style="color: #FF4000;text-align: center;">ĐĂNG NHẬP HỆ THỐNG</h4>
                        </div>
                      <div class="modal-body">
                          
                            <div class="row">
                                <div class="col-md-5"><label>Tên đăng nhập:</label></div>
                                <div class="col-md-7">
                                    <input class="form-control" type="text" id="username"/>
                                </div>

                                
                            </div>
                            
                            <div class="row">
                                <div class="col-md-5"><label>Mật khẩu</label>:</div>
                                <div class="col-md-7">
                                    <input class="form-control" type="password" id="password" />
                                </div>
                                
                            </div>
                            <div class="row">
                                     <div id="error" style="text-align: center;color: red;">
                                       
                                        </div>
                             </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" id="login-btn">Đăng nhập</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                       
                        </div>
                
                    
                </div>
            </div>
 <script type="text/javascript">
      $(document).ready(function(){
         $('#login-btn').click(function(){
            var username = $('#username').val();
            var password = $('#password').val();
            
      
            
            if(username==''){
              
               $('#error').html("**Bạn vui lòng điền tài khoản**");
              
             
            }
            else if(password=='')
            {

               $('#error').html("**Bạn vui lòng điền mật khẩu**");
               
              
            }

            else
           
            {

                var dataString = 'username='+ username +  '&password='+ password;
              
                 $.ajax({
                       type    : "POST",
                       url     : 'log_in.php',
                       data    :  dataString,
                       success : function(html){
                          if(html=='false'){
                            $('#error').html("Tên tài khoản hoặc mật khẩu không chính xác");
                      
                          }
                          else if(html=='true')
                          {
                           window.location="items.php";


                            setTimeout(function(){
                                $('#myModal').modal('hide');
                                $('.alert-danger').addClass('hide');
                                $('.alert-success').addClass('hide');
                            }, 3000);
                                  }
                        
                       }
                    });


              }

             return false;
         });
     });

 </script>
</body>

