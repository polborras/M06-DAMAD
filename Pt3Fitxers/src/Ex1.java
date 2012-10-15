import java.io.*;
import java.util.Scanner;

/*Crea un programa que demani un nom de fitxer origen i un altre destí per consola. 
 * El programa ha de llegir el fitxer origen, convertir les majúscules en minúscules i 
 * a l'inrevés, i guardar-lo com a fitxer destí.*/

public class Ex1 {
	
	public static void main (String[] args) {
		
		FileReader frFitxOrg; // Leer archivo
		BufferedReader brFitxOrg; // Cargar el contenido del archivo
		PrintWriter pwFitxDest; // Destino de escritura
		
		System.out.println("Escriu el nom del fitxer:");
		Scanner lectOrg = new Scanner(System.in); // Entrada desde teclado con la funcion System.in.
		String fitxNomOrg = lectOrg.next();
		
		System.out.println("Escriu el nom del fitxer al que vols traspasar:");
		Scanner lectDest = new Scanner(System.in); 
		String fitxNomDest = lectDest.next();
		
		try{
			frFitxOrg = new FileReader(fitxNomOrg); // Con el FileReader(NOMFITXER), almacenamos todo el fichero en la variable "frFitOrg" 
			brFitxOrg = new BufferedReader(frFitxOrg);
			
			pwFitxDest = new PrintWriter(fitxNomDest);  
			
			String frase=brFitxOrg.readLine();
			while (frase!=null){
				pwFitxDest.println(frase.toUpperCase());
				frase=brFitxOrg.readLine();
				System.out.println(frase);
			}
		pwFitxDest.close();
		}catch(Exception e){
			
		}
	}

}
