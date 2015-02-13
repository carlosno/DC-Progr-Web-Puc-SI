<%@page import="com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default"%>
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
    $( "#data" ).datepicker();
  });
  </script>


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
        
        <%! salao.manterClientes c = new salao.manterClientes(); %>
        <%
        try{
        	if(request.getParameter("cadastrar") != null){
    			String cpf = request.getParameter("cpf");
    			String nome = request.getParameter("nome");
    			String email = request.getParameter("email");
    			String nascimento = request.getParameter("nascimento");
    			String telefone = request.getParameter("numero");
    			String sexo = request.getParameter("sexo");
    			String endereco = request.getParameter("endereco");
    			String complemento = request.getParameter("complemento");
    			String cep = request.getParameter("CEP");
    			String numeroend = request.getParameter("numeroend");
    			
    			
    			c = new salao.manterClientes(Integer.parseInt(cpf),nome, email, nascimento,Integer.parseInt(telefone),sexo,endereco,Integer.parseInt(numeroend),complemento,cep);
    			
    			
    			if(c.cadastraCliente(c) == true){
    			out.print("<script>alert('Cliente cadastrado!')</script>");
    			}else{
    				
    				out.print("<script>alert('Error!')</script>");
    			}
    		}
        }
        catch (Exception e){}
            
		//Testando qual botão foi clicado
		
        %>
    
            <form name="#" method="post">     
        	<table>     
            <tr>     
                <td>Nome:</td>     
                <td>  <input type="text" name="nome" value=""></td>     
                <tr> 
                <td> Endereço: </td>     
                <td><input type="text" name="endereco" value=""> </td>             
                <td>Numero: </td>     
                <td> <input type="text" name="numeroend" value=""></td>     
                
                <tr> 
                <td> Complemento:</td>     
                <td> <input type="text" name="complemento" value=""></td>             
                <td>CEP: </td>     
                <td><input type="text" name="CEP" value=""></td>   
                
                 <tr>     
                <td>CPF </td>     
                <td><input type="text" name="cpf" value=""></td>     
                <tr> 
                
                 <tr>     
                <td>Telefone: </td>     
                <td><input type="text" name="numero" value=""></td>     
                <tr> 
                
                 <tr>     
                <td>Email: </td>     
                <td><input type="text" name="email" value=""></td>     
                <tr> 
                
                 <tr>     
                <td>Data Nascimento:</td>     
                <td> <input type="text" name="nascimento" value=""></td>     
                <tr> 
                
                 <tr>     
                <td> Sexo: </td>     
                <td><input type="text" name="sexo" value=""></td>     
                <tr> 
                  
             </tr>     
        </table>  
        <input type="submit" name="cadastrar" value="Cadastrar">      
    	</form>   
        
        
        
        </div>

</body>
</html>