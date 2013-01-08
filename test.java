package zad.asd;

import java.util.Hashtable;
import java.util.Random;

public class test {

	public static void main(String[] args) {
		Random rand = new Random(5000);
		long[] tabHash = testHashTable(rand);
		long[] tabBst = testBstTree(rand);
		long[] tabList = testLista(rand);
		
		for(int i=0; i<6;i++){
			switch(i){
				case 0:
					System.out.println("----------Wstawianie Posortowanych Liczb---------");
					break;
				case 1:
					System.out.println("----------Wyszukiwanie Posortowanych Liczb---------");
					break;
				case 2:
					System.out.println("----------Usuwanie nieposortowanych Liczb---------");
					break;
				case 3:
					System.out.println("----------Wstawianie nieposortowanych Liczb---------");
					break;
				case 4:
					System.out.println("----------Wyszukiwanie nieposortowanych Liczb---------");
					break;
				case 5:
					System.out.println("----------Usuwanie nieposortowanych Liczb---------");
					break;
			}
			System.out.println(tabHash[i]+"-HashTable");
			System.out.println(tabBst[i]+"-BstTree");
			System.out.println(tabList[i]+"-Lista");
		}
		
		
	}
	
	public static long[] testHashTable(Random rand){
		long[] timeTableHash = new long[6];
//-----------------SORT------------------------
		Hashtable companies = new Hashtable();
		long start=System.nanoTime();
		for(int i=0;i<5000;i++){
			companies.put(i, i);			
		}
		long stop=System.nanoTime();
		timeTableHash[0]=stop-start;
		
		
		start=System.nanoTime();
		for(int i=0;i<5000;i++){
			companies.get(i);			
		}
		stop=System.nanoTime();
		timeTableHash[1]=stop-start;
		
		for(int i=0;i<5000;i++){
			companies.remove(i);			
		}
		stop=System.nanoTime();
		timeTableHash[2]=stop-start;
		
//-----------------------UNSORT---------------------------------
		Hashtable companies2 = new Hashtable();
		int r;
		start=System.nanoTime();
		for(int i=0;i<5000;i++){
			r = rand.nextInt();
			companies2.put(i,r);
		}
		stop=System.nanoTime();
		timeTableHash[3]=stop-start;
		
		
		start=System.nanoTime();
		for(int i=0;i<5000;i++){
			companies2.get(i);
		}
		stop=System.nanoTime();
		timeTableHash[4]=stop-start;
		
		start=System.nanoTime();
		for(int i=0;i<5000;i++){
			companies2.remove(i);
		}
		stop=System.nanoTime();
		timeTableHash[5]=stop-start;
		return timeTableHash;
	}
	
	public static long[] testBstTree(Random rand){
		long[] timeBst = new long[6];
//-----------------SORT------------------------
		BstTree companies = new BstTree();
		long start=System.nanoTime();
		for(int i=0;i<5000;i++){
			companies.insert(null,i);			
		}
		long stop=System.nanoTime();
		timeBst[0]=stop-start;
		
		
		start=System.nanoTime();
		for(int i=0;i<5000;i++){
			companies.search(i);			
		}
		stop=System.nanoTime();
		timeBst[1]=stop-start;
		
		start=System.nanoTime();
		for(int i=0;i<5000;i++){
			companies.delete(i);			
		}
		stop=System.nanoTime();
		timeBst[2]=stop-start;
		
		start=System.nanoTime();
		for(int i=5000;i>=0;i--){
			companies.search(i);			
		}
		stop=System.nanoTime();
		long timeBst1=stop-start;
		
		start=System.nanoTime();
		for(int i=5000;i>=0;i--){
			companies.delete(i);			
		}
		stop=System.nanoTime();
		long timeBst2=stop-start;
		System.out.println(timeBst1 +"|"+timeBst2);
//-----------------------UNSORT---------------------------------
		BstTree companies2 = new BstTree();
		int r;
		Random rad=rand;
		Random ran=rand;
		start=System.nanoTime();
		for(int i=0;i<5000;i++){
			r = rand.nextInt();
			companies2.insert(null,r);
		}
		stop=System.nanoTime();
		timeBst[3]=stop-start;
		
		
		start=System.nanoTime();
		for(int i=0;i<5000;i++){
			r = rad.nextInt();
			companies2.search(r);
		}
		stop=System.nanoTime();
		timeBst[4]=stop-start;
		
		start=System.nanoTime();
		for(int i=0;i<5000;i++){
			r = ran.nextInt();
			companies2.delete(r);
		}
		stop=System.nanoTime();
		timeBst[5]=stop-start;
		return timeBst;
	}
	
	public static long[] testLista(Random rand){
		long[] timeLista = new long[6];
//-----------------SORT------------------------
		Lista companies = new Lista();
		long start=System.nanoTime();
		for(int i=0;i<5000;i++){
			companies.insert(i);			
		}
		long stop=System.nanoTime();
		timeLista[0]=stop-start;
		
		
		start=System.nanoTime();
		for(int i=0;i<5000;i++){
			companies.search(i);			
		}
		stop=System.nanoTime();
		timeLista[1]=stop-start;
		
		start=System.nanoTime();
		for(int i=1;i<5000;i++){
			companies.delete(i);			
		}
		stop=System.nanoTime();
		timeLista[2]=stop-start;
		
		start=System.nanoTime();
		for(int i=5000;i>0;i--){
			companies.search(i);			
		}
		stop=System.nanoTime();
		long timeLista1=stop-start;
		
		start=System.nanoTime();
		for(int i=5000;i>0;i--){
			companies.delete(i);			
		}
		stop=System.nanoTime();
		long timeLista2=stop-start;
		System.out.println(timeLista1+"\\"+timeLista2);
//-----------------------UNSORT---------------------------------
		Lista companies2 = new Lista();
		start=System.nanoTime();
		int r;
		Random rad=rand;
		Random ran=rand;
		for(int i=0;i<5000;i++){
			r = rand.nextInt();
			companies2.insert(r);
		}
		stop=System.nanoTime();
		timeLista[3]=stop-start;
		
		
		start=System.nanoTime();
		for(int i=0;i<5000;i++){
			r = rad.nextInt();
			companies2.search(r);
		}
		stop=System.nanoTime();
		timeLista[4]=stop-start;
		
		start=System.nanoTime();
		for(int i=0;i<5000;i++){
			r = ran.nextInt();
			companies2.delete(r);
		}
		stop=System.nanoTime();
		timeLista[5]=stop-start;
		return timeLista;
	}
}
