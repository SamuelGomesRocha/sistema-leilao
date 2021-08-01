<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="Stylesheet" href="css/reset.css">
<link rel="Stylesheet" href="css/style-cad.css">
<title>Cadastro de Leil�es</title>
</head>
<body>

	<div class="title">
	<h1 onclick="window.location.href='colecaoLeiloes'">Sistema de Leil�es</h1>
	</div>

<div id="corpao-da-bicha">
	
	<section>
	<form action="leilao" method="post">


	<div class="input-container">
		<h2>Cadastro de leil�es</h2>
		<input type="text" name="input-item" id="item" pattern=".+" required/>
		<label class="label" for="item">Item</label>
		<input type="text" name="input-lanceMinimo" id="lance-minimo" pattern=".+" required/>
		<label class="label" for="lance-minimo">Lance m�nimo</label>
		<input type="text" name="input-dataExpiracao" id="data-expiracao" pattern=".+" required/>
		<label class="label" for="data-expiracao">Data de expira��o</label>
		</br><input class="btn" id="input-button" type="submit" value="salvar"/>
	</div>
	
	</form>
	</section>
	
</div>	
</body>
</html>