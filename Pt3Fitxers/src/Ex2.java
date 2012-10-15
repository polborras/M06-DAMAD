import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/*Crea un editor de text Amb una GUI bàsica que consti de dos botons (Carregar i Guardar), 
 * una caixa de text JTextField d'on es llegirà el nom de fitxer a carregar i/o escriure, 
 * i una JTextArea. El programa ha de permetre realitzar modificacions sobre l'arxiu obert 
 * i guardar-lo. Has d'utilitzar classes d'accés a fitxer orientades a la lectura i escriptura 
 * de línies de caràcters. No dediquis molt de temps al disseny de la GUI: utilitza un layout 
 * Absolut (o GroupLayout) amb el dissenyador de Swing i no et preocupis per scrolls ni redimensions.*/

public class Ex2 extends JFrame {

	private JPanel contentPane;
	private JTextField tfNomDoc;
	
	private JTextArea taDoc;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex2 frame = new Ex2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ex2() {
		setTitle("Editor de Text - Pol Borras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FileOutputStream outFile;
				DataOutputStream outFileContent;
				
				try{
					
					outFile = new FileOutputStream(tfNomDoc.getText());
					
					outFileContent = new DataOutputStream(outFile);
					outFileContent.writeUTF(taDoc.getText());
					
				} 
				catch (FileNotFoundException fnfe2)
				{
					
				} 
				catch (IOException ioe2)
				{
					
				}
				
			}
		});
		btnGuardar.setBounds(240, 54, 117, 25);
		contentPane.add(btnGuardar);
		
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				FileInputStream inFile;
				DataInputStream inFileContent;
				
			try{
				
				inFile = new FileInputStream(tfNomDoc.getText()); // Cojer nombre del JTextField, introducir-lo en inFile
				inFileContent = new DataInputStream(inFile);
				
				String docLine = inFileContent.readLine();
				String tmp=""; 									// Variable tmp con nada dentro.
				
				while(docLine!=null){							// While para que vaya introduciendo linea a linea.
					
					if(taDoc.getText().equals("")) 				// Cojemos TextArea, igualamos con "", para que escriba en la primera linea si no hay nada.
					{
						tmp = docLine; 							// La primera vez que entra, la primera linea de docLine, la iguala con tmp, para guardarla.
					}
					else
					{
						tmp=taDoc.getText()+"\n"+docLine; 		// Cojemos todo lo que hay en TextArea + Hacemos un salto de linea + cojemos otra linea.
					}
					
					taDoc.setText(tmp);							// Imprimimos en el TextArea, la variable tmp (String).
					docLine = inFileContent.readLine();
				}
				inFile.close();
			} 
			catch (FileNotFoundException fnfe)
			{
				
			} 
			catch (IOException ioe){
				
			}
				
			}
		});
		btnCarregar.setBounds(85, 54, 117, 25);
		contentPane.add(btnCarregar);
		
		tfNomDoc = new JTextField();
		tfNomDoc.setBounds(26, 12, 381, 33);
		contentPane.add(tfNomDoc);
		tfNomDoc.setColumns(10);
		
		taDoc = new JTextArea();
		taDoc.setBounds(29, 91, 378, 139);
		contentPane.add(taDoc);
	}
}
