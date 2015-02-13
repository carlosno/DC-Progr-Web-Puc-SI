package salao;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;


public class telacadastraFuncionario extends JFrame implements ActionListener {
	JFrame tela = new JFrame("Cadastro de Funcionarios");
	
	JTable tabela;
	JScrollPane barraRolagem = new JScrollPane();
	
	
	JLabel texto1 = new JLabel("Matricula:");
	JLabel texto2 = new JLabel("Nome:");
	JLabel texto3 = new JLabel("Comissão");
	JLabel texto4 = new JLabel("telefone");
	
	
	JTextField campoMatricula = new JTextField();
	JTextField campoNome = new JTextField();
	JTextField campoComissao = new JTextField();
	JTextField campoTelefone = new JTextField();
	
	JButton botao = new JButton("Cadastrar");
	JButton botao1 = new JButton("Consultar");
	JButton botao2 = new JButton("Remover");
	
	public void montaTela(){
		tela.setSize(480, 700);
		tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		tela.setLayout(new FlowLayout());
		tela. setLocationRelativeTo(null);
		
		campoMatricula.setColumns(40);
		campoNome.setColumns(40);
		campoComissao.setColumns(40);
		campoTelefone.setColumns(40);
		
		tabela = new MontaTabela().criar("select * from funcionario");
		tabela.setSize(400, 300);
		barraRolagem = new JScrollPane(tabela);
		

		
		botao.addActionListener(this);
		botao1.addActionListener(this);
		botao2.addActionListener(this);
		tela.add(texto1);
		tela.add(campoMatricula);
		tela.add(texto2);
		
		
		tela.add(campoNome);
		tela.add(texto3);
		tela.add(campoComissao);
		tela.add(texto4);
		tela.add(campoTelefone);
		tela.add(botao);
		tela.add(botao1);
		tela.add(botao2);
		tela.add(barraRolagem);
		
		tela.setVisible(true);


	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		
		
		if(arg0.getSource()==botao){
			
			try {
				manterFuncionario n = new manterFuncionario(campoNome.getText(),campoTelefone.getText(),campoComissao.getText());
				if(n.cadastraFuncionario(n)){
					
					JOptionPane.showMessageDialog(null, "Funcionario cadastrado");
					DefaultTableModel tab = (DefaultTableModel) tabela.getModel();
					String linha []={"1","2","3","4"};
					tab.addRow(linha);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			
			
			}
			
					
			
		}
		/**	
		if(arg0.getSource()==botao1){
			
			String comandoSQL = "SELECT * FROM alunos where matricula=? ";
			Connection con = conecta.iniciaConexao();
		
			try {
				PreparedStatement ps = con.prepareStatement(comandoSQL);
				ps.setString(1, campoMatricula.getText());
			
			ResultSet resultado = ps.executeQuery();			
			
			while(resultado.next()){//percorendo objeto resultado com o select do banco
			campoMatricula.setText(resultado.getString("matricula"));
			campoTurma.setText(resultado.getString("turma_cod"));
			campoNome.setText(resultado.getString("nome"));
			campoCurso.setText(resultado.getString("curso"));
			
			}
			
			}catch(Exception exc){
				exc.printStackTrace();
			}
			
			}
		if(arg0.getSource()== botao2){
			String comandoSQL = "DELETE FROM alunos where matricula=?";
			Connection con = conecta.iniciaConexao();
			try{
				PreparedStatement ps = con.prepareStatement(comandoSQL);
				ps.setString(1, campoMatricula.getText());
				
				if(ps.executeUpdate() != 0){
					JOptionPane.showMessageDialog(null, "Removido");
					campoMatricula.setText("");
					campoTurma.setText("");
					campoNome.setText("");
					campoCurso.setText("");
					tela.remove(barraRolagem);
					tela.repaint();
					tabela = new MontaTabela().criar("select * from alunos");
					tabela.setSize(400, 300);
					barraRolagem = new JScrollPane(tabela);
					tela.add(barraRolagem);
					
				}else{
					JOptionPane.showMessageDialog(null, "Não removido");
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			}	
	**/

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		new telacadastraFuncionario().montaTela();
	}

}

