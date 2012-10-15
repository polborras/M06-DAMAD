import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Ex3 extends JFrame {

	private JPanel contentPane;
	private JTextField tfNom;
	private JTextField tfcog1;
	private JTextField tfCog2;
	private JTextField tfEdat;
	private JTextField tfTelf;
	private JTextField tfCompres;
	private JTextField tfDesc;
	private JTextField tfNomF;
	
	String nom, cog1, cog2, concat;
	byte edat;
	long tel;
	int comp;
	double desc;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex3 frame = new Ex3();
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
	public Ex3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{35, 135, 250, 0};
		gbl_contentPane.rowHeights = new int[]{21, 28, 28, 28, 28, 28, 28, 28, 29, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnGuardar = new JButton("Guardar >>");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				FileOutputStream outFile;
				DataOutputStream outFileContent;
				
				try {
					
					outFile = new FileOutputStream(tfNomF.getText());
					
					outFileContent = new DataOutputStream(outFile);
					
					outFileContent.writeChars("Nom     : "+tfNom.getText());
					outFileContent.writeChars("Cognom 1: "+tfcog1.getText());
					outFileContent.writeChars("Cognom 2: "+tfCog2.getText());
					outFileContent.writeBytes("Edat    : "+tfEdat.getText());
					outFileContent.writeLong(Long.parseLong("Telefon : "+tfTelf.getText()));
					outFileContent.writeInt(Integer.valueOf("Compres : "+tfCompres.getText()));
					outFileContent.writeDouble(Double.valueOf("Desc   : "+tfDesc.getText()));
							
				}catch(IOException e)
				{
				}
			}
		});
		
		JLabel lblNomFitxer = new JLabel("Nom Fitxer :");
		GridBagConstraints gbc_lblNomFitxer = new GridBagConstraints();
		gbc_lblNomFitxer.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNomFitxer.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomFitxer.gridx = 1;
		gbc_lblNomFitxer.gridy = 0;
		contentPane.add(lblNomFitxer, gbc_lblNomFitxer);
		
		tfNomF = new JTextField();
		GridBagConstraints gbc_tfNomF = new GridBagConstraints();
		gbc_tfNomF.fill = GridBagConstraints.BOTH;
		gbc_tfNomF.insets = new Insets(0, 0, 5, 0);
		gbc_tfNomF.gridx = 2;
		gbc_tfNomF.gridy = 0;
		contentPane.add(tfNomF, gbc_tfNomF);
		tfNomF.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom:");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.EAST;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 1;
		gbc_lblNom.gridy = 1;
		contentPane.add(lblNom, gbc_lblNom);
		
		tfNom = new JTextField();
		GridBagConstraints gbc_tfNom = new GridBagConstraints();
		gbc_tfNom.anchor = GridBagConstraints.NORTH;
		gbc_tfNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNom.insets = new Insets(0, 0, 5, 0);
		gbc_tfNom.gridx = 2;
		gbc_tfNom.gridy = 1;
		contentPane.add(tfNom, gbc_tfNom);
		tfNom.setColumns(10);
		
		JLabel lblCognom = new JLabel("Cognom 1:");
		GridBagConstraints gbc_lblCognom = new GridBagConstraints();
		gbc_lblCognom.anchor = GridBagConstraints.EAST;
		gbc_lblCognom.insets = new Insets(0, 0, 5, 5);
		gbc_lblCognom.gridx = 1;
		gbc_lblCognom.gridy = 2;
		contentPane.add(lblCognom, gbc_lblCognom);
		
		tfcog1 = new JTextField();
		GridBagConstraints gbc_tfcog1 = new GridBagConstraints();
		gbc_tfcog1.anchor = GridBagConstraints.NORTH;
		gbc_tfcog1.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfcog1.insets = new Insets(0, 0, 5, 0);
		gbc_tfcog1.gridx = 2;
		gbc_tfcog1.gridy = 2;
		contentPane.add(tfcog1, gbc_tfcog1);
		tfcog1.setColumns(10);
		
		JLabel lblCognom_1 = new JLabel("Cognom 2:");
		GridBagConstraints gbc_lblCognom_1 = new GridBagConstraints();
		gbc_lblCognom_1.anchor = GridBagConstraints.EAST;
		gbc_lblCognom_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCognom_1.gridx = 1;
		gbc_lblCognom_1.gridy = 3;
		contentPane.add(lblCognom_1, gbc_lblCognom_1);
		
		tfCog2 = new JTextField();
		GridBagConstraints gbc_tfCog2 = new GridBagConstraints();
		gbc_tfCog2.anchor = GridBagConstraints.NORTH;
		gbc_tfCog2.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCog2.insets = new Insets(0, 0, 5, 0);
		gbc_tfCog2.gridx = 2;
		gbc_tfCog2.gridy = 3;
		contentPane.add(tfCog2, gbc_tfCog2);
		tfCog2.setColumns(10);
		
		JLabel lblEdat = new JLabel("Edat:");
		GridBagConstraints gbc_lblEdat = new GridBagConstraints();
		gbc_lblEdat.anchor = GridBagConstraints.EAST;
		gbc_lblEdat.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdat.gridx = 1;
		gbc_lblEdat.gridy = 4;
		contentPane.add(lblEdat, gbc_lblEdat);
		
		tfEdat = new JTextField();
		GridBagConstraints gbc_tfEdat = new GridBagConstraints();
		gbc_tfEdat.anchor = GridBagConstraints.NORTH;
		gbc_tfEdat.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEdat.insets = new Insets(0, 0, 5, 0);
		gbc_tfEdat.gridx = 2;
		gbc_tfEdat.gridy = 4;
		contentPane.add(tfEdat, gbc_tfEdat);
		tfEdat.setColumns(10);
		
		JLabel lblTelfon = new JLabel("Tel\u00E8fon:");
		GridBagConstraints gbc_lblTelfon = new GridBagConstraints();
		gbc_lblTelfon.anchor = GridBagConstraints.EAST;
		gbc_lblTelfon.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelfon.gridx = 1;
		gbc_lblTelfon.gridy = 5;
		contentPane.add(lblTelfon, gbc_lblTelfon);
		
		tfTelf = new JTextField();
		GridBagConstraints gbc_tfTelf = new GridBagConstraints();
		gbc_tfTelf.anchor = GridBagConstraints.NORTH;
		gbc_tfTelf.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTelf.insets = new Insets(0, 0, 5, 0);
		gbc_tfTelf.gridx = 2;
		gbc_tfTelf.gridy = 5;
		contentPane.add(tfTelf, gbc_tfTelf);
		tfTelf.setColumns(10);
		
		JLabel lblcompresRealitzades = new JLabel("Compres Realitzades:");
		GridBagConstraints gbc_lblcompresRealitzades = new GridBagConstraints();
		gbc_lblcompresRealitzades.anchor = GridBagConstraints.WEST;
		gbc_lblcompresRealitzades.insets = new Insets(0, 0, 5, 5);
		gbc_lblcompresRealitzades.gridx = 1;
		gbc_lblcompresRealitzades.gridy = 6;
		contentPane.add(lblcompresRealitzades, gbc_lblcompresRealitzades);
		
		tfCompres = new JTextField();
		GridBagConstraints gbc_tfCompres = new GridBagConstraints();
		gbc_tfCompres.anchor = GridBagConstraints.NORTH;
		gbc_tfCompres.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCompres.insets = new Insets(0, 0, 5, 0);
		gbc_tfCompres.gridx = 2;
		gbc_tfCompres.gridy = 6;
		contentPane.add(tfCompres, gbc_tfCompres);
		tfCompres.setColumns(10);
		
		JLabel lblDescomptes = new JLabel("Descomptes:");
		GridBagConstraints gbc_lblDescomptes = new GridBagConstraints();
		gbc_lblDescomptes.anchor = GridBagConstraints.EAST;
		gbc_lblDescomptes.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescomptes.gridx = 1;
		gbc_lblDescomptes.gridy = 7;
		contentPane.add(lblDescomptes, gbc_lblDescomptes);
		
		tfDesc = new JTextField();
		GridBagConstraints gbc_tfDesc = new GridBagConstraints();
		gbc_tfDesc.anchor = GridBagConstraints.NORTH;
		gbc_tfDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDesc.insets = new Insets(0, 0, 5, 0);
		gbc_tfDesc.gridx = 2;
		gbc_tfDesc.gridy = 7;
		contentPane.add(tfDesc, gbc_tfDesc);
		tfDesc.setColumns(10);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				tfNom.setText("");
				tfcog1.setText("");
				tfCog2.setText("");
				tfEdat.setText("");
				tfTelf.setText("");
				tfCompres.setText("");
				tfDesc.setText("");
				tfNomF.setText("");
			}
		});
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.anchor = GridBagConstraints.NORTH;
		gbc_btnBorrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnBorrar.gridx = 1;
		gbc_btnBorrar.gridy = 8;
		contentPane.add(btnBorrar, gbc_btnBorrar);
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.NORTH;
		gbc_btnGuardar.gridx = 2;
		gbc_btnGuardar.gridy = 8;
		contentPane.add(btnGuardar, gbc_btnGuardar);
	}

}
