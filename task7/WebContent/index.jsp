<!doctype html>
<head>
<meta charset="UTF-8">
<title>Home - Online Mutual Fund</title>
<link rel="icon" href="images/favicon.gif" type="image/x-icon" />

<link rel="shortcut icon" href="images/favicon.gif" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/styles.css" />


<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/slides.min.jquery.js"></script>
<script>
	$(function() {
		$('#slides').slides({
			preload : true,
			preloadImage : 'images/loading.gif',
			play : 5000,
			pause : 2500,
			hoverPause : true
		});
	});
</script>


</head>
<body>
	<!--start container-->
	<div id="container">

		<header>
			<!--start logo-->
			<a href="#" id="logo"><img src="images/logo.png" width="380"
				height="80" alt="logo" /></a>

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
		<!--start intro-->

		<section id="intro">
			<div id="slides">
				<div class="slides_container">
					<img src="images/banner1.png" width="800" height="300" alt="baner">
					<img src="images/banner1.png" width="800" height="300" alt="baner">
					<img src="images/banner1.png" width="800" height="300" alt="baner">

				</div>
			</div>

		</section>
		<!--end intro-->


		<!--start holder-->
		<div class="holder_content1">

			<section class="group4">
				<h1>Most Advanced</h1>

				<article>
					<table class="table">
						<tr>
							<th>Company</th>
							<th>Last Sale</th>
							<th>Change Net / %</th>
							<th>Share Volume</th>
						</tr>
						<tr>
							<td>a</td>
							<td>a</td>
							<td>a</td>
							<td>a</td>
						</tr>
						<tr>
							<td>a</td>
							<td>a</td>
							<td>a</td>
							<td>a</td>
						</tr>
						<tr>
							<td>a</td>
							<td>a</td>
							<td>a</td>
							<td>a</td>
						</tr>
						<tr>
							<td>a</td>
							<td>a</td>
							<td>a</td>
							<td>a</td>
						</tr>
						<tr>
							<td>a</td>
							<td>a</td>
							<td>a</td>
							<td>a</td>
						</tr>
					</table>
				</article>

			</section>

		</div>
		<!--end holder-->


		<!--start holder-->

		<div class="holder_content">

			<section class="group1">
				<h1>Login as Customer</h1>
				<img src="images/icon2.png" width="51" height="52" alt="icons"
					class="icons" />
				<form method="post" action="login1.do">
					Username: <input type="text" name="userName" id="cusername"
						 /> Password: <input type="password"
						name="password" id="cpassword" /> <input type="submit"
						name="clogin" value="Login" class="button" />
				</form>
			</section>

			<section class="group1">
				<h1>Login as Employee</h1>
				<img src="images/icon4.png" width="51" height="52" alt="icons"
					class="icons" />
				<form method="post" action="employeeLogin.do">
					Username: <input type="text" name="userName" id="eusername" />
					Password: <input type="password" name="password" id="epassword" />
					<input type="submit" name="elogin" value="Login" class="button" />
				</form>
			</section>


		</div>
		<!--end holder-->


	</div>
	<!--end container-->

	<!--start footer-->
	<footer>
		<div class="container">
			<img src="images/contact-us.png" width="240" height="230"
				alt="contact" class="picture_footer" />
			<section class="footer_left">
				<h3>
					Contact information: <span>Lorem ipsum dolor sit amet</span> <span>Lorem
						ipsum dolor sit amet</span>
				</h3>
			</section>

			<section class="footer_left">
				<h3>
					Website: <span>Lorem ipsum dolor sit amet</span> <span>Lorem
						ipsum dolor sit amet</span>
				</h3>
			</section>


			<aside class="footer_left">
				<h3>
					Lorem ipsum: <span>Lorem ipsum dolor sit amet</span> <span>Lorem
						ipsum dolor sit amet</span>
				</h3>
			</aside>
		</div>
	</footer>
	<!--end footer-->
</body>
</html>
