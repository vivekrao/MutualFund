<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>  
<head>
<meta charset="UTF-8">
<title>Home - Online Mutual Fund</title>
<link rel="icon" href="images/favicon.gif" type="image/x-icon"/>

<link rel="shortcut icon" href="images/favicon.gif" type="image/x-icon"/> 
<link rel="stylesheet" type="text/css" href="css/styles.css"/>


	<script src="js/jquery-1.7.2.min.js"></script>
	<script src="js/slides.min.jquery.js"></script>
	<script>
		$(function(){
			$('#slides').slides({
				preload: true,
				preloadImage: 'images/loading.gif',
				play: 5000,
				pause: 2500,
				hoverPause: true
			});
		});
	</script>


    </head>
    <body>
    <!--start container-->
    <div id="container">

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
   <section class="group2">
   <p><a> Change Password </a></p>
   <p><a> View Portfolio </a></p>
   <p><a> Buy Fund </a></p>
   <p><a> Sell Fund </a></p>
   <p><a> Transaction History </a></p>
   <p><a> Research Fund </a></p>
   <p><a> Request Check </a></p>
   <p><a>Log out</a>
   </section>
   </div>
   <!--end holder-->
   
   <div class="holder_table">
  <section class="group5">
   <p>Transaction History: </p><br>
   <form method="POST" action="BuyFund.html">
   
		<table border="2" class="accountTable" align="center">
			<tr>
				<th width="100">Transaction Date</th>
				<th width="100">Operation</th>
				<th width="100">Fund Name</th>
				<th width="100">Number of shares</th>
				<th width="60">Latest Price</th>
				<th width="100">Amount ($)</th>
				<th width="100">Status</th>
			</tr>
			
			<c:forEach var="t" items="${transactionHistory}">
			<tr>
				<td align="center">${t.execute_date}</td>
				<td align="center">${t.transaction_type}</td>
				<td align="center">${t.fund.name}</td>
				<td align="center">${t.shares}</td>
				<td align="center">${t.fund.latestPrice}</td>
				<td align="center">${t.amount}</td>
				<c:choose>
				<c:when test="${empty t.execute_date}">
					<td align="center">Pending</td>
				</c:when>
				<c:otherwise>
					<td align="center">Completed</td>
				</c:otherwise>
				</c:choose>
			</tr>
			</c:forEach>
		</table>
	</form>
   
   </section>
   </div>
   
   
   
   </div>
   <!--end container-->
   
   <!--start footer-->
   <footer>
   <div class="container">
   <img src="images/contact-us.png" width="240" height="230" alt="contact" class="picture_footer"/>
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
   </div>
   </footer>
   <!--end footer-->
   </body>
   </html>
