<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<table class="table table-striped">
		<caption>Grouptarifs</caption>
		<thead>
			<tr>
				<th>index</th>
				<th>Groupe</th>
				<th>Libelle</th>
				
				<th>Tarif de jour</th>
				<th>Tarif de nuit</th>
				<th>Tarif jdf</th>
				<th>Tarif ndf</th>
				
				<th>Tarif mj</th>
				<th>Tarif mn</th>
				<th>Tarif mjfdf</th>
				<th>Tarif mndf</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${grouptarifss}" var="grouptarifs"
				varStatus="index">
				<tr>
					<td>${index.index}</td>
					<td>${grouptarifs.groupe}</td>
					<td>${grouptarifs.libelle}</td>
					
					<td>${grouptarifs.tarifjour}</td>
					<td>${grouptarifs.tarifnuit}</td>
					<td>${grouptarifs.tarifjdf}</td>
					<td>${grouptarifs.tarifndf}</td>
					
					<td>${grouptarifs.tarifmj}</td>
					<td>${grouptarifs.tarifmn}</td>
					<td>${grouptarifs.tarifmjdf}</td>
					<td>${grouptarifs.tarifmndf}</td>
					<td><a href="/update-grouptarifs?index=${index.index}"
						class="btn btn-success">Update</a> <a
						href="/delete-grouptarifs?index=${index.index}"
						class="btn btn-danger">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<div>
		<a class="btn btn-success" href="/add-grouptarifs">Add</a>
	</div>
</div>
<%@ include file="common/footer.jspf"%>
