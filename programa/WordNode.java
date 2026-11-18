package programa;

public class WordNode extends Node {
	
	private NodeType tipo;
	
	public WordNode() {
		tipo=NodeType.WORDNODE;
	}

	public NodeType getNodeType() {
		return tipo;
	}
}