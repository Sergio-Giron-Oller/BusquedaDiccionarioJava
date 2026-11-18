package programa;

public class LetterNode extends Node {
	
	private NodeType tipo;
	private char letra;
	
	public LetterNode(char letra) {
		tipo=NodeType.LETTERNODE;
		this.letra=letra;
	}

	public NodeType getNodeType() {
		return tipo;
	}
	
	public char getLetra() {
		return this.letra;
	}
}