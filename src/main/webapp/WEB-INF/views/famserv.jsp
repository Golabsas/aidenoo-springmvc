<%@ include file="common/header.jspf"  %>
<%@ include file="common/navigation.jspf"  %>

	<div class="container">
			<form:form method="POST" commandName="famserv" >
			<fieldset class="form-group">
				<form:label path="type">Type</form:label>
				<form:input path="type" type="text" class="form-control"
					required="required" />
				<form:errors path="type" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="libelle">Libelle</form:label>
				<form:input path="libelle" type="text" class="form-control"
					required="required" />
				<form:errors path="libelle" cssClass="text-warning" />
			</fieldset>
			<input class="btn btn-success" value="Submit" type="submit" />
		</form:form>
	</div>
<%@ include file="common/footer.jspf"  %>