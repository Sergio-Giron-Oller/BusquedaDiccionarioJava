package programa;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String [] args) throws IOException{
		
		//Carga el contenido del fichero al objeto diccionario
		String dict="src/diccionario.txt";
		Dictionary diccionario = new Dictionary();
		try {
			BufferedReader inDict = new BufferedReader(new InputStreamReader(new FileInputStream(dict), "UTF-8"));
			String word;
			while ((word = inDict.readLine())!=null) {
				diccionario.insert(word);
			}
			inDict.close();
		} catch (IOException ex) {
			System.err.println("No se puede abrir el fichero de diccionario para su lectura.");
		}
			
		//Carga el contenido del fichero de consultas, y las ejecuta en orden
		String letterSequences = "src/consultas.txt";
		try {
			BufferedReader inSequences = new BufferedReader(new InputStreamReader(new FileInputStream(letterSequences), "UTF-8"));
			String input;
			while((input = inSequences.readLine())!=null) {
				/* Separamos secuencia de tama�o */
				String[] data = input.split(" ");
				String sequence = data[0];
				System.out.println("Secuencia: \""+ sequence + "\"");
				if ( data[1].equalsIgnoreCase("ALL") ) {
					/* Se piden todos los tama�os de palabra */
					System.out.print(diccionario.search(sequence).toString());
				} else {
					/* Se pide un tama�o concreto de palabra */
					int len = Integer.parseInt(data[1]);
					System.out.print(diccionario.search(sequence,len).toString());
				}
				System.out.println("");
			}
			inSequences.close();
		} catch (IOException ex) {
			System.err.println("No se puede abrir el fichero de secuencias de letras para su lectura.");
		}
	}
}