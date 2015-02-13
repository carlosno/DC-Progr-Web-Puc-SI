package salao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.print.attribute.DateTimeSyntax;


public class manterComanda {

	private Date data;
	private String status;
	

	public manterComanda(){};
	
	public manterComanda(String data) throws Exception {
					
        this.data = formataData(data);
		
		this.status="em aberto";
	}
	
	
	public boolean cadastraComanda(manterComanda c,int servico,int funcionario,int cliente){
		boolean cadastraFuncionario = false;
		
		try{
			String comandoSQL = "INSERT INTO comanda VALUES (null,?,?,?,?,?)";
			
			
			ConectaMysql con = new ConectaMysql();
			con.iniciarConexao();
			
			
			PreparedStatement ps = con.conexao.prepareStatement(comandoSQL);
			
			ps.setDate(1, c.data);
			ps.setString(2, c.status);
			ps.setInt(3, servico );
			ps.setInt(4, funcionario );
			ps.setInt(5, cliente );
									
			if(ps.executeUpdate() != 0){
				cadastraFuncionario = true;
			}
			
		}catch(Exception exc){
			exc.printStackTrace();
		}
		
		return cadastraFuncionario;
	}
	
	 public static java.sql.Date formataData(String data) throws Exception {   
	        if (data == null || data.equals(""))  
	            return null;  
	          
	        java.sql.Date date = null;  
	        try {  
	            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	            date = new java.sql.Date( ((java.util.Date)formatter.parse(data)).getTime() );  
	        } catch (ParseException e) {              
	            throw e;  
	        }  
	        return date;  
	    }  
	
	 public String listaComanda(manterComanda c){
			String html = "";
			
			try{
				String comandoSQL = "select a.codigo, a.status,b.nome from comanda a,clientes b where b.cpf=a.clientes_numerocel and a.data=?";
			
			
				ConectaMysql con = new ConectaMysql();
				con.iniciarConexao();
			
				PreparedStatement ps = con.conexao.prepareStatement(comandoSQL);
				
				ps.setTimestamp(1, new Timestamp(c.data.getTime()));
				ResultSet resultado = ps.executeQuery();
				
				//Passagem por todas as linhas do que o SELECT retornou
				html += "<select name='comanda'>";
				while(resultado.next()){
					//O método getString pega o valor da coluna especificada
					html += "<option value='" + resultado.getInt("codigo") + "'>" +  resultado.getString("status") + " - " + resultado.getString("nome")  + "</option>";
				}
				
				html += "</select>";
				con.conexao.close();
				
			}catch(Exception exc){
				exc.printStackTrace();
			}
			
			return html;
		}
	 
	 
	 public boolean receberComanda(int codigo){
			
			boolean comandarecebida=false;
			
			try {
				String comandoSQL = "update comanda set status ='paga' where codigo=?";
				ConectaMysql con = new ConectaMysql();
				con.iniciarConexao();
				PreparedStatement ps = con.conexao.prepareStatement(comandoSQL);
				ps.setInt(1,codigo);
				
				if(ps.executeUpdate() != 0){
					comandarecebida = true;
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return comandarecebida;
		}
	 
	 
	 
}
