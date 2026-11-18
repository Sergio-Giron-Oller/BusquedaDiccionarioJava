package programa;

import estructuras.Queue;

public class WordListN {
	
	private Queue<String> cola;
	private int size;
	
	public WordListN(int size) {
		cola=new Queue<String>();
		this.size=size;
	}
	
	public void add(String word) {
		cola.enqueue(word);
	}
	
	public int getWordSize() {
		return size;
	}
	
	public String toString() {
		StringBuilder salida = new StringBuilder();
		int numPalabras = cola.size();
		salida.append("-Palabras de ");
		salida.append(this.getWordSize());
		salida.append(" letra");
		if(this.getWordSize()>1) {
			salida.append('s');
		}
		salida.append(": ");
		for(int pos=1; pos<=numPalabras; pos++) {
			String word=cola.getFirst();
			cola.dequeue();
			salida.append(word);
			if(pos<numPalabras) {
				salida.append(", ");
			}			
		}
		salida.append('\n');
		return salida.toString();
	}
}