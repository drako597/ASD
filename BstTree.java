package zad.asd;

public class BstTree {
	
	public Struct root;

	public BstTree(){
		this.root=null;
	}
	
	public int insert(Struct r, int value){
		if(root==null){
			Struct struct = new Struct(null,null,null,value);
			root = struct;
			return 0;
		}
		else{
			if(r==null) r=root;
			if(r.getValue()==value) return 0;
			if(r.getValue()>value){
				if(r.getLeft()!=null) return insert(r.getLeft(),value);
				else{
					Struct s = new Struct(r,null,null,value);						
					r.setLeft(s);						
				}
			}
			else{
				if(r.getRight()!=null) return insert(r.getRight(),value);					
				else{
					Struct s = new Struct(r,null,null,value);						
					r.setRight(s);
				}
				}
		}
		return 0;
	}
	
	public Struct search(int key){
		Struct r=root;
		while(r!=null){
			if(r.getValue()==key){
				return r;
			}
			else{
				if(r.getValue()>key){
					r=r.getLeft();
				}
				else r=r.getRight();
			}
		}
		return null;
		
	}
	
	public void delete(int key){
		Struct del = search(key);
		Struct tmp = nast(del);
		if(tmp!=null){
			if(del!=root){
				if(del.getParent().getValue()>key){
					del.getParent().setLeft(tmp);
					tmp.getParent().setLeft(tmp.getRight());
					tmp.setLeft(del.getLeft());
					tmp.setRight(del.getRight());
					deleteElement(del);
				}
				else{
					del.getParent().setRight(tmp);
					tmp.getParent().setLeft(tmp.getRight());
					tmp.setLeft(del.getLeft());
					tmp.setRight(del.getRight());
					deleteElement(del);
				}
			}
			else{
				if(del.getRight()==tmp){
					root=tmp;
					deleteElement(del);
				}
				else{
				tmp.getParent().setLeft(tmp.getRight());
				tmp.setLeft(del.getLeft());
				tmp.setRight(del.getRight());
				deleteElement(del);
				root=tmp.getRight();
				}
			}
		}
		else{
			/*
			if(del.getParent().getValue()>key){
				if(del!=root)del.getParent().setLeft(null);
				deleteElement(del);
			}
			else{
				del.getParent().setRight(null);
				deleteElement(del);
			}*/
			if(del==root){
			//	root=del.getRight();
				deleteElement(del);
			}
		}
		
	}
	
	public Struct nast(Struct elem){
		if(elem!=null){
		if(elem.getRight()!=null){
			elem=elem.getRight();
			while(elem.getLeft()!=null){
				elem=elem.getLeft();
			}
			return elem;
		}
		else if((elem.getRight()==null)&&(elem.getLeft()!=null) ){
			return elem;
		}
		else{
		return null;
		}
		}
		else return null;
	}
	public void deleteElement(Struct tmp){
		tmp.setLeft(null);
		tmp.setParent(null);
		tmp.setRight(null);
		tmp.setValue(0);
	}
	
}
