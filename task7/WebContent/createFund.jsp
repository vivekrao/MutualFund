<!doctype html>  
<head>
<meta charset="UTF-8">
<title>OnlineSolutions - CreateFund</title>
<link rel="icon" href="images/favicon.gif" type="image/x-icon"/>

<link rel="shortcut icon" href="images/favicon.gif" type="image/x-icon"/> 
<link rel="stylesheet" type="text/css" href="css/styles.css"/>
<link rel="stylesheet" type="text/css" href="css/account.css"/>

	<script src="js/jquery-1.7.2.min.js"></script>
	<script src="js/slides.min.jquery.js"></script>
	<script src="js/function.js"></script>
    </head>
    <body>
    <!--start container-->
    <div id="containerAccount">

	<header>
    <!--start logo-->
    <a href="#" id="logo"><img src="images/logo.png" width="380" height="80" alt="logo"/></a>    

	<!--end logo-->
	
	</header>
		 <!--start menu-->


    <div class="navi">
    <ul>
    <li><a href="#">Home</a></li>
    <li><a href="#">About</a></li>
	<li><a href="#">Portfolio</a></li>
    <li><a href="#">News</a></li>
    <li><a href="#">Contact</a></li>

    </ul>
    </div>
	<!--end menu-->
	 <!--start holder-->

   <div class="sidebar">
   <section class="group6">
   <p><a> Change Password </a></p>
   <p><a> Create Employee Account </a></p>
   <p><a> Create Customer Account </a></p>
   <p><a> Reset Customer Password </a></p>
   <p><a> View Customer Account </a></p>
   <p><a> Deposit Check </a></p>
   <p><a> Create Fund </a></p>
   <p><a> Transition Day </a></p>
   <p><a> Log out</a>
   </section>
   </div>
   <!--end holder-->
	<div class="holder_table">
	<section class="group5" >
	<form method="POST" action="change-pwd.do">
		<table border=0 class="accountTable" align="center">
			<tr>
				<td class="item">Name:</td>
				<td><input name="name" size="25" type="text" /></td>
			</tr>
			<tr>
				<td class="item">Ticker:</td>
				<td><input name="symbol" size="25" type="text" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<div align="center">
						<input type="submit" name="button" id="accountBtn" value="Create"/>
					</div>
				</td>
			</tr>
		</table>
	</form>
	</div>
	</div>
   
   </div>
   <!--end container-->
   
   <!--start footer-->
   <footer>
   <div class="container">
   <section class="footer_left">
   <h3>Contact information:
   <span>Lorem ipsum dolor sit amet</span>
   <span>Lorem ipsum dolor sit amet</span>
   </h3>
   </section> 
   
   <section class="footer_left">
   <h3>Website:
   <span>Lorem ipsum dolor sit amet</span>
   <span>Lorem ipsum dolor sit amet</span>
   </h3>
   </section> 

   
   <aside class="footer_left">
   <h3>Lorem ipsum:
   <span>Lorem ipsum dolor sit amet</span>
   <span>Lorem ipsum dolor sit amet</span>
   </h3>
   </aside> 
   <img src="images/contact-us.png" width="240" height="230" alt="contact" class="picture_footer"/>
   </div>
   </footer>
   <!--end footer-->
   </body></html>
