package salao;
import java.sql.PreparedStatement;


public class manterServicos {

	
	
	private int codigo;
	private String desc;
	private float valor;
	private String tipo;
	
	
	
	public manterServicos(int codigo,String descri,float valor, String tipo ){
		
		
		this.codigo=codigo;
		this.desc=descri;
		this.valor=valor;
		this.tipo=tipo;
		
	}


	public boolean cadastraServico(manterServicos c){
		boolean servicoCadastrado = false;
		
		try{
			String comandoSQL = "INSERT INTO servicos VALUES (?, ?, ?, ?)";
			
			
			ConectaMysql con = new ConectaMysql();
			con.iniciarConexao();
			
			
			PreparedStatement ps = con.conexao.prepareStatement(comandoSQL);
			
			ps.setInt(1, c.codigo);
			ps.setString(2, c.desc);
			ps.setFloat(3, c.valor);
			ps.setString(4, c.tipo);
			
						
			if(ps.executeUpdate() != 0){
				servicoCadastrado = true;
			}
			
		}catch(Exception exc){
			exc.printStackTrace();
		}
		
		return servicoCadastrado;
	}


}



