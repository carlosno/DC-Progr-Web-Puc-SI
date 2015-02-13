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
$( "#menus" ).menu();
});
</script>


<title>Salão Facil</title>
</head>
<body>

<div id="centro">

        <div id="cabeçalho"></div>
        <div id="menu">
            
        </div>
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
        
        
        <%
		
			
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

			
			PreparedStatement pstmt = conn
					.prepareStatement("SELECT COUNT(*) AS c FROM comanda where status='paga'");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int total = Integer.parseInt(rs.getString("c"));
			out.println("<br>Total Comandas Pagas = " + total + " | <br> ");
			
			String comandoSQL = "SELECT a.status,sum(b.valor)as soma from comanda a, servicos b where a.servicos_codigo=b.codigo and a.status ='paga'"; 
			
			PreparedStatement pstmt2 = conn.prepareStatement(comandoSQL); // inserir condição 

			ResultSet rs2 = pstmt2.executeQuery();
			while (rs2.next()) {
				int id = rs2.getInt("soma");
				out.println("Total = R$ " + id + " | ");
				
			}
		
			%>
        
        </div>

</body>
</html>