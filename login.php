<?php 
   session_start();
 ?>

 <?php include 'admin/includes/header.php' ?>

<?php include 'lib/conn.php' ?>
 <?php include 'lib/function_login.php' ?>
		<div class="container" style="margin-top: 70px;">
			 <div class="login col-sm-7" >
				   <h2 style="text-align: center;" class="text-success">Log in</h2>
				  <form method="post" action="<?php htmlspecialchars($_SERVER['PHP_SELF']) ?>">
				  	 <div class="form-group">
				  	 	<label>Username</label>
				  	 	<input class="form-control" type="text" placeholder="Username" name="username"></input>
				  	 	<p class="text-danger"><?php echo $usernamerr; ?></p>
				  	 </div>
				  	 <div class="form-group">
				  	 	<label>Password</label>
				  	 	<input class="form-control" type="password" placeholder="Password" name="password"></input>
				  	 	<p class="text-danger"><?php echo $passwordrr; ?></p>
				  	 </div>
				  	 <button class="btn btn-primary" value="Log in" name="submit">Log in</button>
				  	 <p class="text-danger"><?php echo $message; ?></p>

               </form>
             </div>
         
		</div>
<?php include 'admin/includes/footer.php' ?>