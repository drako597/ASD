package zad.asd;

public class Lista {
	public Node head;
	public Node tail;
	
	public Lista(){
		head=null;
		tail=null;
	}
	
	public void insert(int key){
		if(head==null){
			Node newNode = new Node(key,null,null);
			head=newNode;
			tail=newNode;
		}
		else{
			Node newNode = new Node(key,head,null);
			head.setPrev(newNode);
			head=newNode;
		}
	}
	public Node search(int Key){
		Node tmp=head;
		while(tmp!=null){
			if(tmp.getKey()==Key){
				return tmp;
			}
			else{
				tmp=tmp.getNext();
			}
			
		}
		return null;
	}
	public void wyswietl(){
		Node tmp = head;
		while(tmp!=null){
			System.out.print(tmp.getKey()+"|");
			tmp=tmp.getNext();
		}
	}
	public void delete(int key){
		Node tmp = search(key);
		if(tmp!=null){
			if(tmp==tail){
				tail=tmp.getPrev();
				tmp.getPrev().setNext(null);
				tmp.delete();
			}
			else if(tmp==head){
				head=tmp.getNext();
				tmp.getNext().setPrev(null);
				tmp.delete();
			}
			else{
				tmp.getPrev().setNext(tmp.getNext());
				tmp.getNext().setPrev(tmp.getPrev());
				tmp.delete();
			}
		}
	}

}
