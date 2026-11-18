package programa;

public class RootNode extends Node {
	
	private NodeType tipo;
	
	public RootNode() {
		tipo=NodeType.ROOTNODE;
	}

	public NodeType getNodeType() {
		return tipo;
	}
}