package model.entities;

public class Node {

	private int information;
	private Node [] listNodes;
	private Node root;
	
	public Node(int information) {
		this.information = information;
	}

	public Node(int information, Node[] listNodes, Node root) {
		super();
		this.information = information;
		this.listNodes = listNodes;
		this.root = root;
	}
	
	public int getInformation() {
		return information;
	}
	
	public void setInformation(int information) {
		this.information = information;
	}
	
	
}
