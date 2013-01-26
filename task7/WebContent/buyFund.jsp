<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="template-top.jsp" />

		<div class="holder_table">

			<section class="group5">
				<p>Choose fund to buy:</p>
				<form method="POST" action="buyFund.do">
					<h4>
						Amount you want to buy: <input type="text" name="buyAmount">
					</h4>
					Your current funds
					<table border="2" class="accountTable" align="center">
						<tr>
							<th width="200">Fund Name</th>
							<th width="200">Tickr</th>
							<th width="200">Share price<br></th>
							<th width="200">Select fund to buy</th>
							<th width="200"></th>
						</tr>
						<c:forEach var="f" items="${custFundList}">
							<tr>
								<td align="center">${f.name}</td>
								<td align="center">${f.symbol}</td>
								<td align="right">${f.latestPrice}</td>
								<td align="center"><input type="radio" name="fundName"
									value="${f.name}"></td>
								<td align="center"><input type="submit" value="Buy"></td>
							</tr>
						</c:forEach>
					</table>
					All funds
					<table border="2" class="accountTable" align="center">
						<tr>
							<th width="200">Fund Name</th>
							<th width="200">Tickr</th>
							<th width="200">Share price<br></th>
							<th width="200">Select fund to buy</th>
							<th width="200"></th>
						</tr>
						<c:forEach var="f" items="${fundList}">
							<tr>
								<td align="center">${f.name}</td>
								<td align="center">${f.symbol}</td>
								<td align="right">${f.latestPrice}</td>
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

	<jsp:include page="template-bottom.jsp" />