package locadia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;



@SuppressWarnings("serial")
public class frmclientes extends JFrame {

	private JPanel contentPane;
	// declarar aqui objetos do JFrame 
	JFormattedTextField ftxtNum = new JFormattedTextField();
	JFormattedTextField ftxtNome = new JFormattedTextField();
	JFormattedTextField ftxtEnde = new JFormattedTextField();
	JButton btnInc = new JButton("Incluir");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmclientes frame = new frmclientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	// definição das máscaras dos JFormattedText (CNH, Nome e Data Nascimento) evento componentShown do JFrame
	public frmclientes() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				try {
			        MaskFormatter mascNum = new MaskFormatter("#####"); // 5 caracteres numéricos
			        mascNum.install(ftxtNum);
			        MaskFormatter mascNome = new MaskFormatter("********************"); // qualquer tipo de caracter limitado a 20 caracteres
			        mascNome.install(ftxtNome);
			        MaskFormatter mascEnde = new MaskFormatter("********************"); // formato de data dd/mm/aaaa - somente caracteres numéricos
			        mascEnde.install(ftxtEnde);
			    } catch (ParseException ex) {
			        //ex.printStackTrace();
			    	JOptionPane.showMessageDialog(null, ex);
			    }
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(125, 0, 132, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNum = new JLabel("Numero: ");
		lblNum.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNum.setBounds(10, 62, 83, 29);
		contentPane.add(lblNum);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(10, 102, 83, 29);
		contentPane.add(lblNome);
		
		JLabel lblEnde = new JLabel("Endereço: ");
		lblEnde.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnde.setBounds(10, 147, 100, 29);
		contentPane.add(lblEnde);
		
		//JButton btnInc = new JButton("Incluir");
		btnInc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientes c = new clientes();
		        c.setNum(Integer.parseInt(ftxtNum.getText()));
		        c.setNome(ftxtNome.getText());
		        c.setEnde(ftxtEnde.getText());
		        try {
		            c.Incluir();
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, ex);
		        }
		       
			}
		});
		btnInc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInc.setBounds(21, 245, 89, 23);
		contentPane.add(btnInc);
		
		//JButton btnAlt = new JButton("Alterar");
		/*btnAlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Condutores c = new Condutores();
		        c.setCnh(Integer.parseInt(ftxtCnh.getText()));
		        c.setNome(ftxtNome.getText());
		        c.setNasc(ftxtNasc.getText());
		        try {
		            c.Alterar();
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, ex);
		        }
		        LimparTela();
			}
		});
		btnAlt.setEnabled(false);
		btnAlt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAlt.setBounds(145, 190, 89, 23);
		contentPane.add(btnAlt);
		
		//JButton btnExc = new JButton("Excluir");
		btnExc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Condutores c = new Condutores();
		        c.setCnh(Integer.parseInt(ftxtCnh.getText()));
		        c.setNome(ftxtNome.getText());
		        c.setNasc(ftxtNasc.getText());
		        try {
		            c.Excluir();
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, ex);
		        }
		        LimparTela();
			}
		});
		btnExc.setEnabled(false);
		btnExc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExc.setBounds(272, 190, 89, 23);
		contentPane.add(btnExc);
		
		//JButton btnCons = new JButton("Consultar");
		btnCons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Condutores c = new Condutores();
		        try {
		            c.Consultar();
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, ex);
		        }
		        LimparTela();
			}
		});
		btnCons.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCons.setBounds(70, 224, 104, 23);
		contentPane.add(btnCons);
		
		//JButton btnLimp = new JButton("Limpar");
		btnLimp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparTela();
			}
		});
		btnLimp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLimp.setBounds(208, 224, 89, 23);
		contentPane.add(btnLimp);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBounds(145, 258, 89, 23);
		contentPane.add(btnVoltar);
		
		//JButton btnPesq = new JButton("");
		btnPesq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Condutores c = new Condutores();
		        if(ftxtCnh.getText().trim().isEmpty())
		            c.setCnh(0);
		        else
		            c.setCnh(Integer.parseInt(ftxtCnh.getText()));
		        try {
		            c.Pesquisar();
		            ftxtNome.setText(c.getNome());
		            ftxtNasc.setText(c.getNasc());
		            ftxtCnh.setEnabled(false);
		            btnInc.setEnabled(false);
		            btnAlt.setEnabled(true);
		            btnExc.setEnabled(true);
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, ex);
		            LimparTela();
		        }
			}
		});
		btnPesq.setIcon(new ImageIcon("C:\\sos\\Aulas\\IFSP\\POO\\III\\Aplica\u00E7\u00F5es\\Eclipse\\POOBD\\lupa.png"));
		btnPesq.setBounds(244, 60, 53, 31);
		contentPane.add(btnPesq);
	}
	
	public void LimparTela()
	{
		ftxtCnh.setText("");
	    ftxtCnh.setEnabled(true);
	    ftxtNome.setText("");
	    ftxtNasc.setText("");
	    btnInc.setEnabled(true);
	    btnAlt.setEnabled(false);
	    btnExc.setEnabled(false);
	    ftxtCnh.requestFocus();
	}*/
}
}
