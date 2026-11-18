package programa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PruebasBusqueda {
	
	public static void main(String[] args) {
		
		Dictionary diccionario = new Dictionary();		
	    try (BufferedReader br = new BufferedReader(new FileReader("src/diccionario.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	diccionario.insert(line);
		    }
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
	    System.out.println(diccionario.search("riomwalfo", 6));

	}
}