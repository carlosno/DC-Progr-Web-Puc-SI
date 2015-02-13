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

				
		<form action="#" method="post">
		
			<select name="colunas" id="colunas">

			<option value="codigo">codigo</option>

			<option value="descricao">descricao</option>

			<option value="valor">valor</option>
			
			</select>
			<select name="ord" id="ord">

			<option value="asc">menor para maior</option>

			<option value="desc">maior para menos</option>
		
			</select>
				
		<input type="submit" name="cadastrarservico" value="BUSCAR">
		
	</form>
		

	</br>
		

		<%
		if(request.getParameter("cadastrarservico") != null){
			
			String comando = "where = 1";
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

			int limit = 20;// quantidade de resultados por página

			PreparedStatement pstmt = conn
					.prepareStatement("SELECT COUNT(*) AS c FROM servicos");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int total_rows = Integer.parseInt(rs.getString("c"));
			String pagina = request.getParameter("pagina"); // página atual
			if (pagina == null) {
				pagina = "1";
			}

			String coluna = request.getParameter("colunas");
			String order = " "+request.getParameter("ord");

			int limitValue = (Integer.parseInt(pagina) * limit) - limit;
			int ocorrencia = 0;
			String comandoSQL = "SELECT * FROM servicos order by " + coluna
					+ order + " LIMIT " + limitValue + ", " + limit;

			PreparedStatement pstmt2 = conn.prepareStatement(comandoSQL); // inserir condição 

			//pstmt2.setString(1,"codigo");				

			ResultSet rs2 = pstmt2.executeQuery();
			while (rs2.next()) {
				int id = rs2.getInt("codigo");
				out.println("Codigo " + id + " | ");
				String nome = rs2.getString("descricao");
				out.println("Descricao | " + nome + " | ");
				long valor = rs2.getInt("valor");
				out.println("Valor R$: " + valor + "<br><br>");
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
				out.println("<a href=?pagina=" + proxima + ">Próximos " + limit
						+ "</a>");
			} else
				out.println("Próximos " + limit);
		}
		%>


	</div>

</body>
</html>