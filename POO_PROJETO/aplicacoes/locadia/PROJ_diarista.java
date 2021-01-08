package locadia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PROJ_diarista {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PROJ_diarista window = new PROJ_diarista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PROJ_diarista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema de controle de loca\u00E7\u00E3o de Diaristas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(69, 110, 285, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		frame.setJMenuBar(menuBar);
		
		JMenu mnuCadastro = new JMenu("Cadastro");
		menuBar.add(mnuCadastro);
		
		
		
		JMenu mnuClientes = new JMenu("Clientes");
		mnuClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmclientes fa = new frmclientes();
				fa.setVisible(true);
			}
		});
		mnuCadastro.add(mnuClientes);
		
		/*JMenu mnNewMenu_3 = new JMenu("Diaristas");
		mnNewMenu.add(mnNewMenu_3);
		
		JMenu mnNewMenu_1 = new JMenu("Reserva");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_5 = new JMenu("Registro");
		mnNewMenu_1.add(mnNewMenu_5);
		
		JMenu mnNewMenu_6 = new JMenu("New menu");
		mnNewMenu_1.add(mnNewMenu_6);
		
		JMenu mnNewMenu_2 = new JMenu("Sair");
		menuBar.add(mnNewMenu_2);
	}*/
}
}
