 <!-- Button -->
 <style type="text/css">
  .row{
    padding-top: 15px;
  }
</style>
           <a role="button" data-toggle="modal" data-target="#login"><i class="fa fa-user" aria-hidden="true"></i></i>Đăng nhập</a>
 
            <!-- Modal -->
            <div id="login" class="modal fade"  role="dialog">
                <div class="modal-dialog">
 
                    <!-- Modal content-->
                    <div class="modal-content" style="background:#BCF5A9;margin-top: 100px;">
                        <div class="modal-header" style="background: #F781F3;">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title" style="color: #FF4000;text-align: center;">ĐĂNG NHẬP HỆ THỐNG</h4>
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
                           
                        </div>
                        <div class="alert alert-danger hide">
                          
                        </div>
                        <div class="alert alert-success hide">
 
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" id="login-btn">Đăng nhập</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
