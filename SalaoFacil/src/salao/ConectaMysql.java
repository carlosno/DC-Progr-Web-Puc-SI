package salao;


import java.sql.DriverManager;

import java.sql.Connection;

public class ConectaMysql {

	private String usuario ="pw164";
	private String senha ="ikj123";
	private String driver = "com.mysql.jdbc.Driver";
	private String caminho ="jdbc:mysql://ESPARTA:3306/";
	
	public Connection conexao;
	
	
	public boolean iniciarConexao(){
		
		boolean conectado = false;
		
		try{
			Class.forName(driver);
			
			conexao = DriverManager.getConnection(caminho+usuario,usuario,senha);
			 conectado=true;
			 
		}catch(Exception exc ){
			
			exc.printStackTrace();
			
		}
				
		return conectado;
	}
}

