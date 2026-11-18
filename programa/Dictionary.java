package programa;

import estructuras.GTree;
import estructuras.GTreeIF;
import estructuras.ListIF;
import programa.Node.NodeType;

public class Dictionary {
	
	protected GTree<Node> dict;
	
	public Dictionary() {
		dict=new GTree<Node>();
		RootNode raiz = new RootNode();
		dict.setRoot(raiz);
	}
	
	public void insert(String word) {
		insertInTree(word, this.dict);
	}
	
	private void insertInTree(String word, GTreeIF<Node> node) {
		if(word.equals("")) {
			WordNode nodo=new WordNode();
			GTreeIF<Node> arbol = new GTree<Node>();
			arbol.setRoot(nodo);
			node.addChild(1, arbol);
		}
		else {
			String recorte=word.substring(1);
			char caracter=word.charAt(0);
			ListIF<GTreeIF<Node>> hijos= node.getChildren();
			LetterNode nodo = new LetterNode(caracter);
			GTreeIF<Node> arbol= new GTree<Node>();
			arbol.setRoot(nodo);
			if(hijos.isEmpty()) {
				hijos.insert(1, arbol);
			}
			else {
				boolean encontrado=false;
				for(int i=1; i<=hijos.size() && !encontrado; i++) {
					if(hijos.get(i).getRoot() instanceof LetterNode) {
						if(((LetterNode)hijos.get(i).getRoot()).getLetra()==caracter) {
							encontrado=true;
						}
					}
				}
				if(!encontrado) {
					boolean insertado=false;
					for(int i=1; i<=hijos.size() && !insertado; i++) {
						if(hijos.get(i).getRoot() instanceof LetterNode) {
							if(((LetterNode)arbol.getRoot()).getLetra()<((LetterNode)hijos.get(i).getRoot()).getLetra()) {
								hijos.insert(i, arbol);
								insertado=true;
							}
							else {
								if(i==hijos.size()) {
									hijos.insert(i+1, arbol);
									insertado=true;
								}
							}
						}
					}
					if(!insertado) {
						hijos.insert(2, arbol);
					}
				}
			}
			boolean parar=false;
			for(int k=1; k<=hijos.size() && !parar; k++) {
				if(hijos.get(k).getRoot().getNodeType().equals(Node.NodeType.LETTERNODE)) {
					char letra=((LetterNode)hijos.get(k).getRoot()).getLetra();
					if(letra==caracter) {
						insertInTree(recorte, hijos.get(k));
						parar=true;
					}
				}
			}
		}
	}
	
	public WordList search(String sequence) {
		WordList salida = new WordList();
		searchInTree(sequence, "", this.dict, salida);
		return salida;
	}
		
	private void searchInTree(String sequence, String word, GTreeIF<Node> node, WordList salida) {
		ListIF<GTreeIF<Node>> hijos=node.getChildren();
		for(int i=1; i<=hijos.size(); i++) {
			if(hijos.get(i).getRoot().getNodeType().equals(NodeType.WORDNODE)) {
				salida.add(word);
			}
			if(hijos.get(i).getRoot().getNodeType().equals(NodeType.LETTERNODE)) {
				String buscar=word+((LetterNode)(hijos.get(i).getRoot())).getLetra();
				boolean encontrado=false;
				for(int j=0; j<sequence.length() && !encontrado; j++) {
					if(sequence.charAt(j)==((LetterNode)(hijos.get(i).getRoot())).getLetra()) {
						encontrado=true;
						String nueva="";
						if(j==0) {
							nueva=nueva+sequence.substring(1, sequence.length());
						}
						else {
							nueva=nueva+sequence.substring(0, j);
							nueva=nueva+sequence.substring(j+1, sequence.length());
						}
						searchInTree(nueva, buscar, hijos.get(i), salida);
					}
				}
			}
		}
	}	
	
	public WordListN search(String sequence, int size) {
		WordListN salida=new WordListN(size);
		searchInTreeN(sequence, "", this.dict, salida, size);
		return salida;
	}
	
	private void searchInTreeN(String sequence, String word, GTreeIF<Node> node, WordListN salida, int size) {
		ListIF<GTreeIF<Node>> hijos=node.getChildren();
		for(int i=1; i<=hijos.size(); i++) {
			if(hijos.get(i).getRoot().getNodeType().equals(NodeType.WORDNODE) && size==word.length()) {
				salida.add(word);
			}
			if(hijos.get(i).getRoot().getNodeType().equals(NodeType.LETTERNODE)) {
				String buscar=word+((LetterNode)(hijos.get(i).getRoot())).getLetra();
				boolean encontrado=false;
				for(int j=0; j<sequence.length() && !encontrado; j++) {
					if(sequence.charAt(j)==((LetterNode)(hijos.get(i).getRoot())).getLetra()) {
						encontrado=true;
						String nueva="";
						if(j==0) {
							nueva=nueva+sequence.substring(1, sequence.length());
						}
						else {
							nueva=nueva+sequence.substring(0, j);
							nueva=nueva+sequence.substring(j+1, sequence.length());
						}
						searchInTreeN(nueva, buscar, hijos.get(i), salida, size);
					}
				}
			}
		}
	}
}