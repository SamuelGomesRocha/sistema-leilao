<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="Stylesheet" href="css/reset.css">
<link rel="Stylesheet" href="css/style-index.css">
<title>Leilões</title>
</head>
<body>
	<div class="title">
	<h1>Lista de Leilões</h1>
	
	</div>
	<div id="colecao-content">
	
	<div>
	<p><button class="btn" type="button" onclick="window.location.href='cadastro-leilao'">Novo leilão</button></p>
	</div>
	
	<table>
		
		<thead>
			<tr>
				<th>Item  </th>
				<th> Lance mínimo  </th>
				<th> Status  </th>
				<th> Data de expiração  </th>			
			</tr>
		</thead>
		
		<tbody>
	
			<c:forEach items="${leiloes}" var="l" >
				
				<tr>
					<td>${l.item}</td>
					<td>${l.lanceMinimo}</td>
					<td>${l.status}</td>
					<td>${l.dataExpiracao}</td>
					<td><a href="deleta?itemLeilao=${l.item}">excluir</a></td>
				</tr>
				
			</c:forEach>
		
		</tbody>
	
	</table>
	</div>
</body>
</html>