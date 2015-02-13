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
		$("#data").datepicker();
	});
</script>



<script>
	$(function() {
		$("#menus").menu();
	});
</script>


<title>Salão Facil</title>
</head>
<body>

	<div id="centro">

		<div id="cabeçalho"></div>
		<div id="menu"></div>
		<div id="menu1">
			<ul id="menus">
				<li class="ui-state-disabled">Menu</li>
		<li><a href="http://localhost:8080/SalaoFacil/index.jsp">Menu</a></li>
		<li><a href="http://localhost:8080/SalaoFacil/agendamento.jsp">Agendamento</a></li>
		<li><a href="http://localhost:8080/SalaoFacil/manterFuncionario.jsp">Busca Funcionarios</a></li>
		<li><a href="http://localhost:8080/SalaoFacil/buscaServico.jsp">Busca Serviços</a></li>
		<li><a href="http://localhost:8080/SalaoFacil/cadastrocliente.jsp">Cadastro Clientes</a></li>
		<li><a href="http://localhost:8080/SalaoFacil/manterComanda.jsp">Rebeber Comanda</a></li>
		<li><a href="http://localhost:8080/SalaoFacil/manterRelatorio.jsp">Relatorio Comandas</a></li>
			</ul>
		</div>
	</div>
	<div id="conteudo">

		<%!int codigo_funcionario = 0;
	int codigo_servico = 0;
	String cpf = "";
	String data = "";%>






		<form action="#" method="post">

			Data: <input type="text" id="data" name="data"
				value='<%=request.getParameter("data")%>'> <br /> <br />

			<%
				salao.manterFuncionario s1 = new salao.manterFuncionario();

				out.print(s1.buscafuncionario2());
			%>

			<input type="submit" value="Buscar serviços" name="ok" />

			<%
				salao.manterFuncionario s = new salao.manterFuncionario();

				if (request.getParameter("ok") != null) {
					codigo_funcionario = Integer.parseInt(request
							.getParameter("funcionario"));

					out.print("<br />");
					out.print(s.buscaServicofuncionario(Integer.parseInt(request
							.getParameter("funcionario"))));
					out.print("<input type='submit' value='Inserir' name='Inserir'>");
				}

				if (request.getParameter("Inserir") != null) {
					codigo_servico = Integer.parseInt(request
							.getParameter("servicos1"));

					out.print("<br />");
					out.print(s.buscaServicofuncionario(Integer.parseInt(request
							.getParameter("funcionario"))));
					out.print("<input type='submit' value='Inserir'>");
					out.print("<br />");

					salao.manterClientes c = new salao.manterClientes();
					out.print(c.listaClientes());

					out.print("<input type='submit' value='Cadastrar' name='Cadastrar'>");
					String data = request.getParameter("data");

				}

				if (request.getParameter("Cadastrar") != null) {
					cpf = request.getParameter("cliente");

					salao.manterComanda c1 = new salao.manterComanda(
							request.getParameter("data"));
					if (c1.cadastraComanda(c1, codigo_servico, codigo_funcionario,
							Integer.parseInt(cpf)) == true) {
						out.print("<script>alert('Comanda Cadastrada!')</script>");

					}

				}
			%>

		</form>





	</div>

</body>
</html>