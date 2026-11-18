package programa;

public abstract class Node {
	
	public enum NodeType{ ROOTNODE, LETTERNODE, WORDNODE }
	
	public abstract NodeType getNodeType();
}