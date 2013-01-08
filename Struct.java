package zad.asd;

public class Struct {
	
	public Struct parent;
	public Struct right;
	public Struct left;
	public int value;
	
	public Struct(Struct parent, Struct right, Struct left, int value){
		this.parent=parent;
		this.right=right;
		this.left=left;
		this.value=value;
	}
	
	public Struct getParent(){
		return parent;
	}
	
	public Struct getRight(){
		return right;
	}
	
	public Struct getLeft(){
		return left;
	}
	
	public int getValue(){
		return value;
	}
	
	public void setLeft(Struct left){
		this.left=left;
	}
	
	public void setRight(Struct right){
		this.right=right;
	}
	
	public void setParent(Struct Parent){
		this.parent=Parent;
	}
	
	public void setValue(int value){
		this.value=value;
	}

	
}
