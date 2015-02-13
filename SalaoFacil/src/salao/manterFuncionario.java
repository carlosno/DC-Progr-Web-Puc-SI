package salao;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;

import sun.io.Converters;
import sun.security.util.BigInt;


public class manterFuncionario {

	
	
	private String nome;
	private String telefone;
	private float comissao;
	
	public manterFuncionario(){};
		
	public manterFuncionario(String nome, String tel, String comissao){
		
		
		this.nome=nome;
		this.telefone=tel;
		this.comissao=Float.parseFloat(comissao);
			
		
	}
	
	public boolean cadastraFuncionario(manterFuncionario c){
		boolean cadastraFuncionario = false;
		
		try{
			String comandoSQL = "INSERT INTO funcionario VALUES (null,?, ?,?)";
			
			
			ConectaMysql con = new ConectaMysql();
			con.iniciarConexao();
			
			
			PreparedStatement ps = con.conexao.prepareStatement(comandoSQL);
			
			ps.setString(1, c.nome);
			ps.setString(2, c.telefone);
			ps.setFloat(3, c.comissao);
			
			
						
			if(ps.executeUpdate() != 0){
				cadastraFuncionario = true;
			}
			
		}catch(Exception exc){
			exc.printStackTrace();
		}
		
		return cadastraFuncionario;
	}
	
	

	public boolean cadastraServicofunc(int servCod, int funcmatricula){
		boolean cadastraServicofunc = false;
		
		try{
			String comandoSQL = "INSERT INTO servicos_funcionario VALUES (?,?)";
			
			
			ConectaMysql con = new ConectaMysql();
			con.iniciarConexao();
			
			
			PreparedStatement ps = con.conexao.prepareStatement(comandoSQL);
			
			ps.setInt(1, servCod);
			ps.setInt(2, funcmatricula);
		
					
						
			if(ps.executeUpdate() != 0){
				cadastraServicofunc = true;
			}
			
		}catch(Exception exc){
			exc.printStackTrace();
		}
		
		return cadastraServicofunc;
	}

	public boolean removeFuncionario(String matricula){
		boolean funcionarioremovido = false;
		
		try{
			String comandoSQL = "DELETE FROM funcionario WHERE matricula = ?";
			
			ConectaMysql con = new ConectaMysql();
			con.iniciarConexao();
			
		
			PreparedStatement ps = con.conexao.prepareStatement(comandoSQL);
			
			//Passagem de valor para o ?
			ps.setInt(1, Integer.parseInt(matricula));
			
			if(ps.executeUpdate() != 0){
				funcionarioremovido = true;
			}
			
		}catch(Exception exc){
			exc.printStackTrace();
		}
		
		return funcionarioremovido;
	}
	
	public boolean atualizaFuncionario(String matricula, manterFuncionario c){
		boolean funcionarioAtualizado = false;
		
		try{
			String comandoSQL = "UPDATE clientes SET nome = ?, telefone = ?, comissao = ? WHERE matricula = ?";
			
			ConectaMysql con = new ConectaMysql();
			con.iniciarConexao();
			
			PreparedStatement ps = con.conexao.prepareStatement(comandoSQL);
			
			ps.setString(1, c.nome);
			ps.setString(2, c.telefone);
			ps.setFloat(3, c.comissao);
			ps.setInt(4, Integer.parseInt(matricula));
			
			
			if(ps.executeUpdate() != 0){
				funcionarioAtualizado = true;
			}
			
		}catch(Exception exc){
			exc.printStackTrace();
		}
		
		return funcionarioAtualizado;
	}

	
	public String buscafuncionario2(){
		String nomes = "";
		
		try {
			String comandoSQL="select * from funcionario";
			ConectaMysql con = new ConectaMysql();
			con.iniciarConexao();
			PreparedStatement ps = con.conexao.prepareStatement(comandoSQL);
			
			ResultSet resultado = ps.executeQuery();
			
			nomes += "<select name='funcionario'>";
			while(resultado.next()){
				nomes += "<option value='" + resultado.getString("matricula") + "'>" + resultado.getString("nome")  + "</option>";
			}
			nomes += "</select>";
			
			con.conexao.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nomes;
	
}



	public String buscaServicofuncionario(int codigo){
		String nomes = "";
		
		try {
			String comandoSQL="select a.descricao, a.codigo from servicos_funcionario b,servicos a  "
					+ "where b.servicos_codigo=a.codigo and funcionario_matricula=?";
			
			
			ConectaMysql con = new ConectaMysql();
			con.iniciarConexao();
			PreparedStatement ps = con.conexao.prepareStatement(comandoSQL);
			ps.setInt(1, codigo);
			
			
			ResultSet resultado = ps.executeQuery();
			
			nomes += "<select name='servicos1'>";
			while(resultado.next()){
				nomes += "<option value='" + resultado.getString("codigo") + "'>" + resultado.getString("descricao")  + "</option>";
			}
			nomes += "</select>";
			
			con.conexao.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nomes;
}




}
