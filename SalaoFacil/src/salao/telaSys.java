package salao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class telaSys  extends JFrame implements ActionListener {

	
	//Componentes
		JFrame tela = new JFrame("Salão Facil");
		JMenuBar barraMenu = new JMenuBar();
		
		//Itens do Menu Cadastro
		JMenu menu1 = new JMenu("Cadastros");
		JMenuItem item1Menu1 = new JMenuItem("Cadastrar Cliente");
		JMenuItem item2Menu1 = new JMenuItem("Cadastrar Funcionario");
		JMenuItem item3Menu1 = new JMenuItem("Cadastrar Serviço");
		JMenuItem item4Menu1 = new JMenuItem("Cadastrar Serviço do Funcinario");
		JMenuItem item5Menu1 = new JMenuItem("Manter Comandas");
		
		JMenuItem item7Menu1 = new JMenuItem("Sair");
		
		//botão
		
		JButton botao = new JButton("Cadastrar Cliente");
		JButton botao1 = new JButton("Cadastrar Funcionario");
		JButton botao2 = new JButton("Cadastrar Serviço");
		JButton botao3 = new JButton("Cadastrar Serviço do Funcinario");
		JButton botao4 = new JButton("Manter Comandas");
		
	
		
		//Montagem e configuração da tela
		public void montaTela(){
			tela.setDefaultCloseOperation(EXIT_ON_CLOSE);
			tela.setLayout(null);
			tela. setExtendedState(JFrame.MAXIMIZED_BOTH);
			
			
			//Botão
			botao.addActionListener(this);
			botao1.addActionListener(this);
			botao2.addActionListener(this);
			botao3.addActionListener(this);
			botao4.addActionListener(this);
			
			
			//         margemX, margemY, largura, altura
			barraMenu.setBounds(0, 0, 2000, 30);
			
			botao.setBounds(30, 50, 280, 30);
			botao1.setBounds(30, 100, 280, 30);
			botao2.setBounds(30, 150, 280, 30);
			botao3.setBounds(30, 200, 280, 30);
			botao4.setBounds(30, 250, 280, 30);
			
			//botão
			tela.add(botao);
			tela.add(botao1);
			tela.add(botao2);
			tela.add(botao3);
			tela.add(botao4);
	
			
//			//Configuração do tamanho da barra
//			barraMenu.setSize(400, 20); //largura, altura
			
			//Configurar os itens do menu para disparar eventos
			item1Menu1.addActionListener(this);
			item2Menu1.addActionListener(this);
			item3Menu1.addActionListener(this);
			item4Menu1.addActionListener(this);
			item5Menu1.addActionListener(this);
			
			item7Menu1.addActionListener(this);
			
			//Adicionar os itens dentro do Menu 1
			menu1.add(item1Menu1);
			menu1.add(item2Menu1);
			menu1.add(item3Menu1);
			menu1.add(item4Menu1);
			menu1.add(item5Menu1);
			
			menu1.addSeparator();
			menu1.add(item7Menu1);
			
		
			
			//Adicionar o menu1 e menu2 na barra
			barraMenu.add(menu1);

			//Adicionar a barra na tela
			tela.add(barraMenu);
			
			tela.setVisible(true);
		}
		@Override
			public void actionPerformed(ActionEvent arg0) {
						
		/**	if(arg0.getSource() == item1Menu1 ||arg0.getSource() == botao1){
				cadastra_aluno cc = new cadastra_aluno();
				cc.montaTela();
				}
		
			
		
			if(arg0.getSource() == item3Menu1 ||arg0.getSource() == botao2){
				cadastro_disciplina cc = new cadastro_disciplina();
				cc.montaTela();
				}
		
			if(arg0.getSource() == item4Menu1 || arg0.getSource() == botao3){
				cadastro_professor cc = new cadastro_professor();
				cc.montaTela();
				}
		
			if(arg0.getSource() == item5Menu1 || arg0.getSource() == botao4 ){
				cadastro_turma cc = new cadastro_turma();
				cc.montatela();
				}
			

			if(arg0.getSource() == item6Menu1 || arg0.getSource() == botao5){
				cadastro_turma_disciplina cc = new cadastro_turma_disciplina();
				cc.montatela();
				}
			
			**/
			if(arg0.getSource() == item7Menu1){
				
				System.exit(0);
				}
			
			if(arg0.getSource() == item2Menu1 ||arg0.getSource() == botao1){
				telacadastraFuncionario cc = new telacadastraFuncionario();
				cc.montaTela();
				
			
			}
			
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new telaSys().montaTela();
	
	}

}


