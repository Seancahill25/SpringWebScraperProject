<%@page import="java.sql.Connection" %>
<%@page import="com.sean.stockscraper.db.DbConnection" %>
<%@page import="com.sean.stockscraper.scraper.SeleniumScraper" %>
<%@page import="java.sql.DriverManager" %>

<!DOCTYPE html>
<html>
<body>
<h2>Hello World!</h2>

<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				
				<c:forEach var="tempCustomer" items="${stocks}">
					<tr>
						<td> ${tempCustomer.symbol} </td>
						<td> ${tempCustomer.changes} </td>
						<td> ${tempCustomer.volume} </td>
					</tr>
				</c:forEach>
			
			</table>
		</div>
	</div>

</body>
</html>
