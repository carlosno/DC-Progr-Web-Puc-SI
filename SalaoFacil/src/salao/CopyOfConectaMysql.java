package salao;


import java.sql.DriverManager;

import java.sql.Connection;

public class CopyOfConectaMysql {

	private String usuario ="pw164";
	private String senha ="ikj123";
	private String driver = "com.mysql.jdbc.Driver";
	private String caminho ="jdbc:mysql://ESPARTA:3306/pw164";
	
	public Connection conexao;
	private Connection con;
	
	public Connection iniciaConexao(){
		
		boolean conectado = false;
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(caminho, usuario, senha);
			System.out.println("Conectado!");
			
		}catch(Exception e){
			System.out.println("Não conectou!");
			e.printStackTrace();
		}
		return con;
	}
}

