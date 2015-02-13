package salao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class manterClientes {

	
	private int cpf;
	private String nome;
	private String email;
	private Timestamp nascimento;
	private int telefone;
	private String sexo;
	private String endereco;
	private int numeroend;
	private String complemento;
	private String cep;
	
	
	public manterClientes(){};
	
	public manterClientes(int cpf,String nome, String email,String nascimento,
			int telefone,String sexo,String endereco,int numeroend,String complemento,String cep){
		
		this.cpf=cpf;
		this.nome = nome;
		this.email = email;
		
		try {
			
			this.nascimento = (Timestamp) new SimpleDateFormat("yyyy/MM/dd").parse(nascimento);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		this.telefone=telefone;
		this.sexo=sexo;
		this.endereco=endereco;
		this.numeroend=numeroend;
		this.complemento=complemento;
		this.cep=cep;
	}
		
		
		public boolean cadastraCliente(manterClientes c){
			boolean clienteCadastrado = false;
			
			try{
				String comandoSQL = "INSERT INTO clientes VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				//Iniciando a conexão
				ConectaMysql con = new ConectaMysql();
				con.iniciarConexao();
				
				//import java.sql
				//O objeto ps recebe a conexão vinculada ao comando SQL
				PreparedStatement ps = con.conexao.prepareStatement(comandoSQL);
				
				//Passagem de valor para o ?
				ps.setInt(1, c.cpf);
				ps.setString(2, c.nome);
				ps.setString(3, c.email);
				ps.setTimestamp(4, c.nascimento);
				ps.setInt(5, c.telefone);
				ps.setString(6, c.sexo);
				ps.setString(7, c.endereco);
				ps.setInt(8, c.numeroend);
				ps.setString(9, c.complemento);
				ps.setString(10, c.cep);
				
				
				//Executa o comando no banco de dados e retorna
				//a quantidade de linhas afetadas. Se for diferente de
				//zero significa que o comando foi executado
				if(ps.executeUpdate() != 0){
					clienteCadastrado = true;
				}
				
			}catch(Exception exc){
				exc.printStackTrace();
			}
			
			return clienteCadastrado;
		}
		
		public String listaClientes(){
			String html = "";
			
			try{
				String comandoSQL = "SELECT * FROM clientes";
				
				ConectaMysql con = new ConectaMysql();
				con.iniciarConexao();
				
				
				PreparedStatement ps = con.conexao.prepareStatement(comandoSQL);
				
			
				ResultSet resultado = ps.executeQuery();
				
				
				html += "<select name='cliente'>";
				while(resultado.next()){
					
					html += "<option value='" + resultado.getString("cpf") + "'>" +  resultado.getString("cpf") + " - " + resultado.getString("nome")  + "</option>";
					
				}
				
				html += "</select>";
				con.conexao.close();
				
			}catch(Exception exc){
				exc.printStackTrace();
			}
			
			return html;
		}
		
		
		
	}
	
	



