<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

	<div class="container">
		<table class="table table-striped">
			<caption>Sfamserv</caption>
			<thead>
				<tr>
		 		<th>index</th> 
					<th>Sfam</th>
					<th>Libelle</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sfamservs}" var="sfamserv" varStatus="index">
					<tr>
			  			<td>${index.index}</td> 
						<td>${sfamserv.sfam}</td>
						<td>${sfamserv.libelle}</td>
						<td><a href="/update-sfamserv?index=${index.index}"
							class="btn btn-success">Update</a> <a
							href="/delete-sfamserv?index=${index.index}" class="btn btn-danger">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


		<div>
			<a class="btn btn-success" href="/add-sfamserv">Add</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>
