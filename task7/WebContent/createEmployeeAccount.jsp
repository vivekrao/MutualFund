<jsp:include page="template-top.jsp" />
	<div class="holder_table">
	<section class="group5" >
	<form method="POST" action="change-pwd.do">
		<table border=0 class="accountTable" align="center">
			<tr>
				<td class="item">User Name:</td>
				<td><input name="username" size="25" type="text" /></td>
			</tr>
			<tr>
				<td class="item">Password:</td>
				<td><input name="password" size="25" type="password" /></td>
			</tr>
			<tr>
				<td class="item">Confirm Password:</td>
				<td><input name="confirmedPassword" size="25" type="password" /></td>
			</tr>
			<tr>
				<td class="item">First Name:</td>
				<td><input name="firstname" size="25" type="text" /></td>
			</tr>
			<tr>
				<td class="item">Last Name:</td>
				<td><input name="lastname" size="25" type="text" /></td>
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
   
   <jsp:include page="template-bottom.jsp" />