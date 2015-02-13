package salao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;

public class testeinsert {
	 
	public static int codigo;
	public static String nome;
	
	public void cadastar(){
		
			try{
			String comandoSQL = "INSERT INTO new_table (idnew_table,nome) VALUES (?, ?)";
			ConectaMysql con = new ConectaMysql();
		
			con.iniciarConexao();

			PreparedStatement ps = con.conexao.prepareStatement(comandoSQL);

			ps.setInt(1,codigo); 
			ps.setString(2,nome); 
			ps.executeUpdate();
			con.conexao.close();

			}catch(Exception exc){
			exc.printStackTrace();
				}
			}
public String buscaCodigo(String codigo){
		
		testeinsert t1 =new testeinsert();
		String nomes = "";
			try {
				String comandoSQL="select * from new_table where idnew_table = ?";
				ConectaMysql con = new ConectaMysql();
				con.iniciarConexao();

				PreparedStatement ps = con.conexao.prepareStatement(comandoSQL);
				ps.setInt(1, Integer.parseInt(codigo));
				ResultSet resultado = ps.executeQuery();
				
				while(resultado.next()){
								
					nomes+="Codigo :";
					nomes+=resultado.getInt("codigo");
					nomes+="<br/>";
					
					nomes+="Nome :";
					nomes+=resultado.getString("nome");
					nomes+="<br/>";
				
				}
				
				con.conexao.close();
			} catch (Exception exc) {
				// TODO: handle exception
				exc.printStackTrace();
			}
			
			return nomes;

		}
	
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
	//manterClientes m = new manterClientes(1112223365,"carlos","carlos@carlos","2013-10-10",199999,"m","rua um",2045,"comple","13060726");
		
	//System.out.print(m.cadastraCliente(m));
	
		
//	manterServicos m =new manterServicos(201, "escova ", 50, "corte");
		
		//manterFuncionario n = new manterFuncionario("Carlos","1999999","16.0");
		
		//manterComanda m =new manterComanda("20/20/2012");
		
	//	System.out.print(m.cadastraServico(m));
		//System.out.print(m.cadastraServico(m));
	
	ConectaMysql c =new ConectaMysql();
	
	System.out.println(c.iniciarConexao());
	
	}
	

}
