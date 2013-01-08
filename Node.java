package zad.asd;

public class Node{
	public int key;
	public Node next;
	public Node prev;
	
	public Node(int key,Node next, Node prev){
		this.key=key;
		this.next=next;
		this.prev=prev;
		
	}

	public Node getNext() {
		return this.next;
	}
	public void setNext(Node next){
		this.next=next;
	}
	public Node getPrev() {
		return this.prev;
	}
	public void setPrev(Node prev){
		this.prev=prev;
	}
	public int getKey(){
		return this.key;
	}
	public void delete(){
		key=0;
		next=null;
		prev=null;
	}
	public void setNextNull(){
		this.next=null;
	}
	
}