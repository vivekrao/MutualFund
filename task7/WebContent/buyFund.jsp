<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<head>
<meta charset="UTF-8">
<title>Mutual Funds - Buy fund</title>
<link rel="icon" href="images/favicon.gif" type="image/x-icon" />

<link rel="shortcut icon" href="images/favicon.gif" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/styles.css" />

<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/slides.min.jquery.js"></script>
<script src="js/function.js"></script>
<script>
	$(function() {
		$('#slides').slides({
			preload : true,
			preloadImage : 'images/loading.jpg',
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
		<div class="sidebar">
			<section class="group2">
				<p>
					<a> Change Password </a>
				</p>
				<p>
					<a> View Portfolio </a>
				</p>
				<p>
					<a> Buy Fund </a>
				</p>
				<p>
					<a> Sell Fund </a>
				</p>
				<p>
					<a> Transaction History </a>
				</p>
				<p>
					<a> Research Fund </a>
				</p>
				<p>
					<a> Request Check </a>
				</p>
				<p>
					<a>Log out</a>
			</section>
		</div>
		<!--end holder-->

		<div class="holder_table">

			<section class="group5">
				<p>Choose fund to buy:</p>
				<form method="POST" action="buyFund.do">
					<h4>
						Amount you want to buy: <input type="text" name="buyAmount">
					</h4>
					<br> <Label>Your current funds</Label>
					<table border="2" class="accountTable" align="center">
						<tr>
							<th width="100">Fund Name</th>
							<th width="100">Tickr</th>
							<th width="100">Share price<br></th>
							<th width="100">Select fund to buy</th>
							<th width="100"></th>
						</tr>
						<c:forEach var="f" items="${custFundList}">
							<tr>
								<td align="center">${f.name}</td>
								<td align="center">${f.symbol}</td>
								<td align="center">${f.latestPrice}</td>
								<td align="center"><input type="radio" name="fundName"
									value="${f.name}"></td>
								<td align="center"><input type="submit" value="Buy"></td>
							</tr>
						</c:forEach>
					</table>
					<br> <Label>All funds</Label>
					<table border="2" class="accountTable" align="center">
						<tr>
							<th width="100">Fund Name</th>
							<th width="100">Tickr</th>
							<th width="100">Share price<br></th>
							<th width="100">Select fund to buy</th>
							<th width="100"></th>
						</tr>
						<c:forEach var="f" items="${fundList}">
							<tr>
								<td align="center">${f.name}</td>
								<td align="center">${f.symbol}</td>
								<td align="center">${f.latestPrice}</td>
								<td align="center"><input type="radio" name="chooseFund"
									value="${f.name}"></td>
								<td align="center"><input type="submit" value="Buy"></td>
							</tr>
						</c:forEach>
					</table>

				</form>

			</section>

		</div>
		<!--end holder-->

	</div>
	<!--end container-->

	<!--start footer-->
	<footer>
		<div class="container">
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
			<img src="images/contact-us.png" width="240" height="230"
				alt="contact" class="picture_footer" />
		</div>
	</footer>
	<!--end footer-->
</body>
</html>
