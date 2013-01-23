<jsp:include page="template-top.jsp" />
<div class="holder_table">
	<section class="group5" style="height:auto;">
		<jsp:include page="error-list.jsp" />
		<form method="POST" action="createCustomer.do">
			<table border=0 class="accountTable" align="center">
				<tr>
					<td class="item">User Name:</td>
					<td><input name="username" size="25" type="text" /><font color="red">*</font></td>
				</tr>
				<tr>
					<td class="item">Password:</td>
					<td><input name="password" size="25" type="password" /><font color="red">*</font></td>
				</tr>
				<tr>
					<td class="item">Confirm Password:</td>
					<td><input name="confirmedPassword" size="25" type="password" /><font color="red">*</font></td>
				</tr>
				<tr>
					<td class="item">First Name:</td>
					<td><input name="firstName" size="25" type="text" /></td>
				</tr>
				<tr>
					<td class="item">Last Name:</td>
					<td><input name="lastName" size="25" type="text" /></td>
				</tr>
				<tr>
					<td class="item">Address Line1:</td>
					<td><input name="addressLine1" size="25" type="text" /></td>
				</tr>
				<tr>
					<td class="item">Address Line2:</td>
					<td><input name="addressLine2" size="25" type="text" /></td>
				</tr>
				<tr>
					<td class="item">City:</td>
					<td><input name="city" size="25" type="text" /></td>
				</tr>
				<tr>
					<td class="item">state:</td>
					<td><select name="state" id="State" style="width: 185px"
						onfocus="changeActive()">
							<option>Pennsylvania</option>
							<option>Connecticut</option>
							<option>Delaware</option>
							<option>Florida</option>
							<option>Georgia</option>
							<option>Illinois</option>
							<option>Indiana</option>
							<option>Iowa</option>
							<option>Kentucky</option>
							<option>Louisana</option>
							<option>Maine</option>
							<option>Maryland</option>
							<option>Massachusetts</option>
							<option>Michigan</option>
							<option>New Hampshire</option>
							<option>New Jersey</option>
							<option>New York</option>
							<option>North Carolina</option>
							<option>Ohio</option>
							<option>Rhode Island</option>
							<option>Vermont</option>
							<option>Virginia</option>
							<option>West Virginia</option>
					</select></td>
				</tr>
				<tr>
					<td class="item">zip:</td>
					<td><input name="zip" size="25" type="text" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="center">
							<input type="submit" name="button" id="accountBtn" value="Create" />
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
