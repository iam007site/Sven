<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="jquery-ui.css" rel="stylesheet">
<style>
body {
	font-size: 62.5%;
}

label, input {
	display: block;
}

input.text {
	margin-bottom: 12px;
	width: 95%;
	padding: .4em;
}

fieldset {
	padding: 0;
	border: 0;
	margin-top: 25px;
}

h1 {
	font-size: 2.2em;
	margin: .6em 0;
}

div#users-contain {
	width: 350px;
	margin: 20px 0;
}

div#users-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#users-contain table td, div#users-contain table th {
	border: 1px solid #eee;
	padding: .6em 10px;
	text-align: left;
}

.ui-dialog .ui-state-error {
	padding: .3em;
}

.validateTips {
	border: 1px solid transparent;
	padding: 0.3em;
}
</style>
<script src="jquery.min.js"></script>
<script src="jquery-ui.min.js"></script>
<script>
	var dialog;
	function showDialog(id) {
		var selector = "#" + id + "-form";
		dialog = $(selector).dialog("open");
	}
	function createDialog(id) {
		var selector = "#" + id + "-form";
		$(selector).dialog({
			autoOpen : false,
			position : {
				my : "center top",
				at : "center top"
			},
			height : 400,
			width : 500,
			modal : true,
			buttons : {
				"提交测试" : function() {
					$(this).find("form").submit();
					$(this).dialog("close");
				},
				Cancel : function() {
					$(this).dialog("close");
				}
			},
			close : function() {
				$(this).dialog("close");
			}
		});
		//dialog.dialog( "open" );
	}
</script>
</head>
<body>
	<table>
		<tr>
			<th>请求URL</th>
			<th>请求方法</th>
			<th>传递变量</th>
		</tr>
		<c:forEach var="model" items="${modelList}">
			<tr>
				<td><a href="#"><span
						onclick="showDialog('<c:out value="${model.id}"/>')"><c:out
								value="${model.url}" /></span></a></td>
				<td><c:out value="${model.method}" /></td>
				<td><c:forEach var="item" items="${model.paramters}">
						<c:out value="${item.name}" />,</c:forEach></td>
			</tr>
		</c:forEach>
	</table>

	<c:forEach var="model" items="${modelList}">
		<div style="display: none;" id="<c:out value="${model.id}"/>-form"
			title="<c:out value="${model.url}"/>测试表单">
			<p class="validateTips">填入测试选项.</p>
			<form id="<c:out value="${model.id}"/>"
				method="<c:out value="${model.method}"/>"
				action="<c:out value="${model.url}"/>" target="_blank">
				<fieldset>
					<c:forEach var="item" items="${model.paramters}">
						<label for='<c:out value="${item.name}"/>'><c:out
								value="${item.name}" /></label>
						<input type="text" name="<c:out value="${item.name}"/>"
							id="<c:out value="${item.name}"/>"
							value="<c:out value="${item.value}"/>"
							class="text ui-widget-content ui-corner-all">
					</c:forEach>
					<input type="submit" value="提交" tabindex="-1"
						style="position: absolute; top: -1000px">
				</fieldset>
			</form>
		</div>
		<script type="text/javascript">
createDialog('<c:out value="${model.id}"/>');
</script>
	</c:forEach>

</body>
</html>