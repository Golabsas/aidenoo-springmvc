<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<form:form method="POST" commandName="grouptarifs">
		<fieldset class="form-group">
			<form:label path="groupe">Groupe</form:label>
			<form:input path="groupe" type="text" class="form-control"
				required="required" />
			<form:errors path="groupe" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="libelle">Libelle</form:label>
			<form:input path="libelle" type="text" class="form-control"
				required="required" />
			<form:errors path="libelle" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="tarifjour">Tarif de jour</form:label>
			<form:input path="tarifjour" type="text" class="form-control"
				required="required" />
			<form:errors path="tarifjour" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="tarifnuit">Tarif de nuit</form:label>
			<form:input path="tarifnuit" type="text" class="form-control"
				required="required" />
			<form:errors path="tarifnuit" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="tarifjdf">Tarif jdf</form:label>
			<form:input path="tarifjdf" type="text" class="form-control"
				required="required" />
			<form:errors path="tarifjdf" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="tarifndf">Tarif ndf</form:label>
			<form:input path="tarifndf" type="text" class="form-control"
				required="required" />
			<form:errors path="tarifndf" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="tarifmj">Tarif mj</form:label>
			<form:input path="tarifmj" type="text" class="form-control"
				required="required" />
			<form:errors path="tarifmj" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="tarifmn">Tarif mn</form:label>
			<form:input path="tarifmn" type="text" class="form-control"
				required="required" />
			<form:errors path="tarifmn" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="tarifmjdf">Tarif mjdf</form:label>
			<form:input path="tarifmjdf" type="text" class="form-control"
				required="required" />
			<form:errors path="tarifmjdf" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="tarifmndf">Tarif mndf</form:label>
			<form:input path="tarifmndf" type="text" class="form-control"
				required="required" />
			<form:errors path="tarifmndf" cssClass="text-warning" />
		</fieldset>
		<input class="btn btn-success" value="Submit" type="submit" />
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>