<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="css/css.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
<SCRIPT type="text/javascript" src="js/jquery-1.10.2.js"></SCRIPT>
<SCRIPT type="text/javascript" src="js/jquery-ui.js"></SCRIPT>



<script>
$(function() {
$( "#menus" ).menu();
});
</script>


<title>Sal�o Facil</title>
</head>
<body>

<div id="centro">

        <div id="cabe�alho"></div>
        <div id="menu">
            
        </div>
        <div id="menu1">
 <ul id="menus">
		<li class="ui-state-disabled">Menu</li>
		<li><a href="http://localhost:8080/SalaoFacil/index.jsp">Menu</a></li>
		<li><a href="http://localhost:8080/SalaoFacil/agendamento.jsp">Agendamento</a></li>
		<li><a href="http://localhost:8080/SalaoFacil/manterFuncionario.jsp">Busca Funcionarios</a></li>
		<li><a href="http://localhost:8080/SalaoFacil/buscaServico.jsp">Busca Servi�os</a></li>
		<li><a href="http://localhost:8080/SalaoFacil/cadastrocliente.jsp">Cadastro Clientes</a></li>
		<li><a href="http://localhost:8080/SalaoFacil/manterComanda.jsp">Rebeber Comanda</a></li>
		<li><a href="http://localhost:8080/SalaoFacil/manterRelatorio.jsp">Relatorio Comandas</a></li>
		
		
</ul>	
</div>
        </div>
        <div id="conteudo">
        
        
        
        
        </div>

</body>
</html>