<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.sql.*"%>
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
		$("#menus").menu();
	});
</script>


<title>Sal�o Facil</title>
</head>
<body>

	<div id="centro">

		<div id="cabe�alho"></div>
		<div id="menu"></div>
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

		</br>

		
		<%
			// Este exemplo mostra como paginar os resultados de uma
			// tabela MySQL
			// o nome da base de dados � "test"
			String url = "jdbc:mysql://ESPARTA:3306/pw164";
			String usuario = "pw164";
			String senha = "ikj123";
			Connection conn = null;
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = DriverManager.getConnection(url, usuario, senha);
			} catch (SQLException ex) {
				out.println("SQLException: " + ex.getMessage() + "<br>");
				out.println("SQLState: " + ex.getSQLState() + "<br>");
				out.println("VendorError: " + ex.getErrorCode() + "<br>");
			} catch (Exception e) {
				out.println("Problemas ao tentar conectar com o banco de dados");
			}
			
			int limit = 20;// quantidade de resultados por p�gina
			
			PreparedStatement pstmt = conn
					.prepareStatement("SELECT COUNT(*) AS c FROM funcionario");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int total_rows = Integer.parseInt(rs.getString("c"));
			String pagina = request.getParameter("pagina"); // p�gina atual
			if (pagina == null) {
				pagina = "1";
			}
			int limitValue = (Integer.parseInt(pagina) * limit) - limit;
			PreparedStatement pstmt2 = conn
					.prepareStatement("SELECT * FROM funcionario LIMIT "
							+ limitValue + ", " + limit); // inserir condi��o 
			ResultSet rs2 = pstmt2.executeQuery();
			while (rs2.next()) {
				int id = rs2.getInt("matricula");
				out.println("Matricula | " + id + " | ");
				String nome = rs2.getString("NOME");
				out.println("Nome: " + nome + " | ");
				int telefone = rs2.getInt("telefone");
				out.println("Telefone " + telefone + "<br><br>");
			}
			int anterior;
			if (Integer.parseInt(pagina) != 1) {
				anterior = Integer.parseInt(pagina) - 1;
				out.println("<a href=?pagina=" + anterior + ">" + limit
						+ " Anteriores</a>");
			} else
				out.println(limit + " Anteriores ");
			int numOfPages = total_rows / limit;
			int i;
			for (i = 1; i <= numOfPages; i++) {
				if (i == Integer.parseInt(pagina)) {
					out.println("<b>" + i + "</b> ");
				} else {
					out.println("<a href=?pagina=" + i + ">" + i + "</a> ");
				}
			}
			if ((total_rows % limit) != 0) {
				if (i == Integer.parseInt(pagina)) {
					out.println(i + " ");
				} else {
					out.println("<a href=?pagina=" + i + ">" + i + "</a> ");
				}
			}
			int proxima;
			if ((total_rows - (limit * Integer.parseInt(pagina))) > 0) {
				proxima = Integer.parseInt(pagina) + 1;
				out.println("<a href=?pagina=" + proxima + ">Pr�ximos " + limit
						+ "</a>");
			} else
				out.println("Pr�ximos " + limit);
		%>










	</div>

</body>
</html>