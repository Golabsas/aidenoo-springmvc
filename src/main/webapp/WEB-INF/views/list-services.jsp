<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

	<div class="container">
		<table class="table table-striped">
			<caption>Sfamserv</caption>
			<thead>
				<tr>
		 		<th>index</th> 
					<th>Type</th>
					<th>Libelle</th>
					<th>Groupe de Tarif</th>
					<th>Specialisation</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${servicess}" var="services" varStatus="index">
					<tr>
			  			<td>${index.index}</td> 
						<td>${services.type}</td>
						<td>${services.groupetarif}</td>
						<td>${services.libelle}</td>
						<td>${services.specialisation}</td>
						<td><a href="/update-services?index=${index.index}"
							class="btn btn-success">Update</a> <a
							href="/delete-services?index=${index.index}" class="btn btn-danger">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


		<div>
			<a class="btn btn-success" href="/add-services">Add</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>
