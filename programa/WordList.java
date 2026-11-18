package programa;

import estructuras.List;
import estructuras.ListIF;

public class WordList {
	
	private ListIF<WordListN> wordList;
	
	public WordList() {
		this.wordList= new List<WordListN>();
	}
	
	public void add(String word) {
		boolean encontrado=false;
		if(!wordList.isEmpty()) {
			for(int i=1; i<=wordList.size() && !encontrado; i++) {
				if(wordList.get(i).getWordSize()==word.length()) {
					encontrado=true;
					wordList.get(i).add(word);
				}
			}
			if(!encontrado) {
				WordListN nueva = new WordListN(word.length());
				nueva.add(word);
				boolean insertado=false;
				for(int i=1; i<=wordList.size() && !insertado; i++) {
					if(wordList.get(i).getWordSize()<word.length()) {
						wordList.insert(i, nueva);
						insertado=true;
					}
				}
				if(!insertado) {
					wordList.insert(wordList.size()+1, nueva);
				}

			}
		}
		else {
			WordListN nueva = new WordListN(word.length());
			nueva.add(word);
			wordList.insert(wordList.size()+1, nueva);
		}
	}
	
	public String toString() {
		StringBuilder salida= new StringBuilder();
		for(int pos=1; pos<=this.wordList.size(); pos++) {
			salida.append(this.wordList.get(pos).toString());
		}
		return salida.toString();
	}
}